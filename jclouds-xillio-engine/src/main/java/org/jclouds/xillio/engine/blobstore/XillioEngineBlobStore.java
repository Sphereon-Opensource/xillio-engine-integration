/*
 * Copyright 2017 Sphereon B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.xillio.engine.blobstore;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.inject.name.Named;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.blobstore.domain.Blob;
import org.jclouds.blobstore.domain.BlobAccess;
import org.jclouds.blobstore.domain.BlobMetadata;
import org.jclouds.blobstore.domain.ContainerAccess;
import org.jclouds.blobstore.domain.MultipartPart;
import org.jclouds.blobstore.domain.MultipartUpload;
import org.jclouds.blobstore.domain.MutableBlobMetadata;
import org.jclouds.blobstore.domain.PageSet;
import org.jclouds.blobstore.domain.StorageMetadata;
import org.jclouds.blobstore.domain.internal.BlobImpl;
import org.jclouds.blobstore.domain.internal.PageSetImpl;
import org.jclouds.blobstore.internal.BaseBlobStore;
import org.jclouds.blobstore.options.CreateContainerOptions;
import org.jclouds.blobstore.options.GetOptions;
import org.jclouds.blobstore.options.ListContainerOptions;
import org.jclouds.blobstore.options.PutOptions;
import org.jclouds.blobstore.util.BlobUtils;
import org.jclouds.collect.Memoized;
import org.jclouds.domain.Credentials;
import org.jclouds.domain.Location;
import org.jclouds.io.MutableContentMetadata;
import org.jclouds.io.Payload;
import org.jclouds.io.PayloadSlicer;
import org.jclouds.location.Provider;
import org.jclouds.logging.Logger;
import org.jclouds.logging.slf4j.SLF4JLogger;
import org.jclouds.rest.ResourceAlreadyExistsException;
import org.jclouds.rest.ResourceNotFoundException;
import org.jclouds.util.Strings2;
import org.jclouds.xillio.engine.XillioEngineApi;
import org.jclouds.xillio.engine.auth.AuthorizationApi;
import org.jclouds.xillio.engine.blobstore.functions.BlobMetadataToEntity;
import org.jclouds.xillio.engine.blobstore.functions.BlobToFileFolderName;
import org.jclouds.xillio.engine.blobstore.functions.EntityToBlobMetadata;
import org.jclouds.xillio.engine.blobstore.functions.EntityToStorageMetadata;
import org.jclouds.xillio.engine.blobstore.functions.ListContainerOptionsToEntityQueryOptions;
import org.jclouds.xillio.engine.model.ContainerDecorator;
import org.jclouds.xillio.engine.model.Entity;
import org.jclouds.xillio.engine.model.EntityResponse;
import org.jclouds.xillio.engine.options.EntityQueryOptions;
import org.jclouds.xillio.engine.reference.XillioConstants;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.io.ByteStreams.toByteArray;

@Singleton
public class XillioEngineBlobStore extends BaseBlobStore {

    private static final Logger logger = new SLF4JLogger.SLF4JLoggerFactory().getLogger(XillioEngineBlobStore.class.getName());
    private final Supplier<Credentials> credentialsSupplier;

    private final String apiEndpoint;
    private final AuthorizationApi authorizationApi;
    private final XillioEngineApi api;
    private final EntityToStorageMetadata entityToStorageMetadata;
    private final EntityToBlobMetadata entityToBlobMetadata;
    private final ListContainerOptionsToEntityQueryOptions listContainerOptionsToEntityQueryOptions;
    private final BlobMetadataToEntity blobMetadataToEntity;
    private final BlobToFileFolderName blobToFileFolderName;


    @Inject
    XillioEngineBlobStore(BlobStoreContext context,
                          BlobUtils blobUtils,
                          Supplier<Location> defaultLocation,
                          @Memoized Supplier<Set<? extends Location>> locations,
                          @Provider Supplier<Credentials> credentialsSupplier,
                          PayloadSlicer slicer,
                          XillioEngineApi api,
                          AuthorizationApi authorizationApi,
                          EntityToStorageMetadata entityToStorageMetadata,
                          EntityToBlobMetadata entityToBlobMetadata,
                          BlobMetadataToEntity blobMetadataToEntity,
                          ListContainerOptionsToEntityQueryOptions listContainerOptionsToEntityQueryOptions,
                          BlobToFileFolderName blobToFileFolderName,
                          @Named(XillioConstants.API_ENDPOINT) String apiEndpoint
    ) {
        super(context, blobUtils, defaultLocation, locations, slicer);
        this.authorizationApi = authorizationApi;
        this.api = api;
        this.entityToStorageMetadata = entityToStorageMetadata;
        this.entityToBlobMetadata = entityToBlobMetadata;
        this.blobMetadataToEntity = blobMetadataToEntity;
        this.listContainerOptionsToEntityQueryOptions = listContainerOptionsToEntityQueryOptions;
        this.credentialsSupplier = credentialsSupplier;
        this.blobToFileFolderName = blobToFileFolderName;
        this.apiEndpoint = apiEndpoint;
    }



    @Override
    protected boolean deleteAndVerifyContainerGone(String containerName) {
        return false; // TODO: 3-11-2017 Delete configuration api call
    }


    @Override
    public PageSet<? extends StorageMetadata> list() {
        return ((Function<EntityResponse, PageSet<? extends StorageMetadata>>) fromEntity ->
                new PageSetImpl<>(Iterables.transform(fromEntity.getChildren(), entityToStorageMetadata), null)).
                apply(api.listRepositories(ListContainerOptions.NONE));
    }


    @Override
    public boolean containerExists(String containerName) {
        return api.configurationExists(containerName);
    }


    @Override
    public boolean createContainerInLocation(Location location, String containerName) {
        return createContainerInLocation(location, containerName, CreateContainerOptions.NONE);
    }

    @Override
    public boolean createContainerInLocation(Location location, String containerName, CreateContainerOptions createContainerOptions) {
        // We discard the Location attribute
        logger.warn("Create container is not implemented yet. Assuming existing container " + containerName);
        return true;
    }


    @Override
    public ContainerAccess getContainerAccess(String containerName) {
        return ContainerAccess.PRIVATE;
    }


    @Override
    public void setContainerAccess(String s, ContainerAccess containerAccess) {
        logger.warn("Not implemented yet. Container access: " + containerAccess.name());

    }


    @Override
    public PageSet<? extends StorageMetadata> list(String containerName, ListContainerOptions listContainerOptions) {
        EntityQueryOptions entityQueryOptions = listContainerOptionsToEntityQueryOptions.apply(listContainerOptions);
        EntityResponse entityResponse;
        if (listContainerOptions.getPrefix() != null) {
            entityResponse = api.getEntity(containerName, listContainerOptions.getPrefix(), entityQueryOptions);
        } else if (listContainerOptions.getDir() != null) {
            entityResponse = api.getEntity(containerName, listContainerOptions.getDir().replaceFirst("/", ""), entityQueryOptions);
        } else {
            entityResponse = api.getRepository(containerName, entityQueryOptions);
        }
        if (entityResponse == null) {
            entityResponse = new EntityResponse().children(new ArrayList<>());
        }
        List<Entity> entities = new ArrayList<>();
        if (entityResponse.getEntity() != null && (XillioConstants.Domain.Kind.FILE.is(entityResponse.getEntity().getKind()) || XillioConstants.Domain.Kind.FOLDER.is(entityResponse.getEntity().getKind()))) {
            entities.add(entityResponse.getEntity());
        }
        entities.addAll(entityResponse.getChildren());
        return ((Function<EntityResponse, PageSet<? extends StorageMetadata>>) fromEntity ->
                new PageSetImpl<>(Iterables.transform(entities, entityToStorageMetadata), null)).
                apply(entityResponse);

    }

    @Override
    public boolean blobExists(String containerName, String filePath) {
        return api.entityExists(containerName, filePath /*Strings2.urlEncode(filePath)*/);
    }

    @Override
    public String putBlob(String containerName, Blob blob) {
        return putBlob(containerName, blob, PutOptions.NONE);
    }

    @Override
    public String putBlob(String containerName, Blob blob, PutOptions putOptions) {
        MutableContentMetadata contentMetadata = checkNotNull(blob.getPayload().getContentMetadata());
        long length = checkNotNull(contentMetadata.getContentLength());

        if (length != 0 && (putOptions.isMultipart() || !blob.getPayload().isRepeatable())) {
            // JCLOUDS-912 prevents using single-part uploads with InputStream payloads.
            // Work around this with multi-part upload which buffers parts in-memory.
            try {
                byte[] bytes = toByteArray(blob.getPayload().openStream());
                blob.setPayload(bytes);
                blob.getPayload().setContentMetadata(contentMetadata);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to read stream", e);
            }
        }

        Entity entity = blobMetadataToEntity.apply(blob);
        EntityResponse response;
        BlobToFileFolderName.FileFolder fileFolder = blobToFileFolderName.apply(blob);
        try {
            response = api.createEntity(containerName, fileFolder.getFolder(), entity, blob.getPayload());
        } catch (ResourceAlreadyExistsException re) {
            // Ok we update the entity with the new payload
            api.updateContents(containerName, blob.getMetadata().getName(), blob.getPayload());
            response = api.getEntity(containerName, blob.getMetadata().getName());
        } catch (ResourceNotFoundException rnf) {
            createFoldersWhenNeeded(containerName, blob, fileFolder);
            // No need to check ResourceExistsException, since we already determined the folders are not there
            response = api.createEntity(containerName, fileFolder.getFolder(), entity, blob.getPayload());
        }

        // todo etag instead of xdip
        return response == null ? null : response.getEntity().getXdip();
    }

    private void createFoldersWhenNeeded(String containerName, Blob blob, BlobToFileFolderName.FileFolder fileFolder) {
        if (!fileFolder.hasFolder()) {
            return;
        }
        List<String> parts = fileFolder.getFolderParts();
        List<String> hierarchy = fileFolder.getFolderHierarchy();
        for (int i = 0; i < parts.size(); i++) {
            String folderName = parts.get(i);
            String folderPath = i == 0 ? "" : hierarchy.get(i - 1);

            Entity folderEntity = folderEntity(blob);
            folderEntity.getOriginal().getName().setSystemName(folderName);
            folderEntity.getModified().getName().setSystemName(folderName);
            try {
                api.createEntity(containerName, folderPath, folderEntity, null);
            } catch (ResourceAlreadyExistsException re) {
                logger.info(String.format("Folder '%s' already exists in path '%s' in container '%s'", folderName, folderPath, containerName));
            }
        }
    }

    public Entity folderEntity(Blob blob) {
        Entity entity = blobMetadataToEntity.apply(blob);
        entity.setKind(XillioConstants.Domain.Kind.FOLDER.getEntityValue());
        entity.getOriginal().container(new ContainerDecorator().hasChildren(true));
        entity.getModified().container(new ContainerDecorator().hasChildren(true));
        return entity;
    }


    @Override
    public BlobMetadata blobMetadata(String containerName, String path) {
        Entity entity = api.getEntity(containerName, path /*Strings2.urlEncode(path)*/).getEntity();
        return entityToBlobMetadata.apply(entity);
    }


    @Override
    public Blob getBlob(String containerName, String path, GetOptions getOptions) {
        EntityResponse entityResponse = api.getEntity(containerName, path /*Strings2.urlEncode(path)*/);
        if (entityResponse == null) {
            return null;
        }
        Entity entity = entityResponse.getEntity();

        MutableBlobMetadata metadata = entityToBlobMetadata.apply(entity);
        Blob blob = new BlobImpl(metadata);
        Payload payload = api.getContents(containerName, path /*Strings2.urlEncode(path)*/).getPayload();
        payload.setContentMetadata(metadata.getContentMetadata()); // Doing this first retains it on setPayload.
        blob.setPayload(payload);

        return blob;
    }


    @Override
    public void removeBlob(String containerName, String path) {
        api.deleteEntity(containerName, Strings2.urlEncode(path));
    }

    @Override
    public BlobAccess getBlobAccess(String s, String s1) {
        return null;
    }


    @Override
    public void setBlobAccess(String s, String s1, BlobAccess blobAccess) {

    }


    @Override
    public MultipartUpload initiateMultipartUpload(String s, BlobMetadata blobMetadata, PutOptions putOptions) {
        return null;
    }


    @Override
    public void abortMultipartUpload(MultipartUpload multipartUpload) {

    }


    @Override
    public String completeMultipartUpload(MultipartUpload multipartUpload, List<MultipartPart> list) {
        return null;
    }


    @Override
    public MultipartPart uploadMultipartPart(MultipartUpload multipartUpload, int i, Payload payload) {
        return null;
    }


    @Override
    public List<MultipartPart> listMultipartUpload(MultipartUpload multipartUpload) {
        return null;
    }


    @Override
    public List<MultipartUpload> listMultipartUploads(String s) {
        return null;
    }


    @Override
    public long getMinimumMultipartPartSize() {
        return 0;
    }


    @Override
    public long getMaximumMultipartPartSize() {
        return 0;
    }


    @Override
    public int getMaximumNumberOfParts() {
        return 0;
    }

}
