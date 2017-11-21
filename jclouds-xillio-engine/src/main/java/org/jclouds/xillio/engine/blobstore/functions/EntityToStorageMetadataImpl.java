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

package org.jclouds.xillio.engine.blobstore.functions;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.hash.HashCode;
import com.google.inject.Inject;
import org.jclouds.blobstore.domain.MutableBlobMetadata;
import org.jclouds.blobstore.domain.MutableStorageMetadata;
import org.jclouds.blobstore.domain.StorageType;
import org.jclouds.blobstore.domain.internal.MutableBlobMetadataImpl;
import org.jclouds.blobstore.domain.internal.MutableStorageMetadataImpl;
import org.jclouds.domain.Location;
import org.jclouds.io.MutableContentMetadata;
import org.jclouds.xillio.engine.model.ContainerDecorator;
import org.jclouds.xillio.engine.model.CreatedDecorator;
import org.jclouds.xillio.engine.model.DescriptionDecorator;
import org.jclouds.xillio.engine.model.Entity;
import org.jclouds.xillio.engine.model.FileDecorator;
import org.jclouds.xillio.engine.model.FileSystemDecorator;
import org.jclouds.xillio.engine.model.HashDecorator;
import org.jclouds.xillio.engine.model.MimeTypeDecorator;
import org.jclouds.xillio.engine.model.ModifiedDecorator;
import org.jclouds.xillio.engine.model.ParentDecorator;
import org.jclouds.xillio.engine.model.PropertiesDecorator;
import org.jclouds.xillio.engine.model.VersionDecorator;
import org.jclouds.xillio.engine.reference.XillioConstants;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.HASH_MD5;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.HASH_SHA1;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.HASH_SHA256;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.VERSION_TAG;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.CONTAINER_HAS_CHILDREN;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.DESCRIPTION_SHORT;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.FILE_SYSTEM_PATH;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.DecoratorName.MIME_TYPE_TYPE;

import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.Kind.FOLDER;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.Kind.CONTAINER;
import static org.jclouds.xillio.engine.reference.XillioConstants.Domain.Kind.CONFIGURATION;

public class EntityToStorageMetadataImpl<T extends MutableStorageMetadata> implements Function<Entity, T> {

    private Supplier<Location> defaultLocation;

    public EntityToStorageMetadataImpl() {
    }

    @Inject
    EntityToStorageMetadataImpl(Supplier<Location> defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public T apply(Entity fromEntity) {
        T toMetadata = getTypedMetadata(fromEntity);
        addDefaultMetadata(fromEntity, toMetadata);
        addUserMetadata(fromEntity, toMetadata);
        return toMetadata;
    }

    private String extractContainer(ParentDecorator parent) {
        if (parent == null || parent.getId() == null) {
            return null;
        }
        return parent.getId().replaceFirst("http.*\\/v2\\/entities\\/([^\\/]+)\\/.*", "$1");
    }


    private String extractName(Entity fromEntity) {
        if (fromEntity == null || fromEntity.getId() == null) {
            return null;
        }
        return fromEntity.getId().replaceFirst("http.*\\/v2\\/entities\\/[^\\/]+\\/(.*)", "$1");
    }

    private T getTypedMetadata(Entity fromEntity) {
        T toMetadata;
        if (isKind(fromEntity, XillioConstants.Domain.Kind.FILE)) {
            MutableBlobMetadata blobMetadata = new MutableBlobMetadataImpl();
            blobMetadata.setPublicUri(URI.create(fromEntity.getId()));
            ParentDecorator parent = fromEntity.getModified().getParent();
            if (parent != null) {
                blobMetadata.setContainer(extractContainer(parent));
            }
            addContentMetadata(fromEntity, blobMetadata);

            toMetadata = (T) blobMetadata;
            toMetadata.setType(StorageType.BLOB);
        } else if (isKind(fromEntity, FOLDER)) {
            toMetadata = (T) new MutableStorageMetadataImpl();
            toMetadata.setType(StorageType.FOLDER);
        } else if (isKind(fromEntity, CONFIGURATION) || isKind(fromEntity, CONTAINER)) {
            toMetadata = (T) new MutableStorageMetadataImpl();
            toMetadata.setType(StorageType.CONTAINER);
        } else {
            throw new RuntimeException(String.format("Unsupported metadata type found: %s for entity with id %s", fromEntity.getKind(), fromEntity.getId()));
        }
        return toMetadata;
    }


    private void addContentMetadata(Entity fromEntity, MutableBlobMetadata blobMetadata) {
        MutableContentMetadata contentMetadata = blobMetadata.getContentMetadata();

        MimeTypeDecorator mimeType = fromEntity.getModified().getMimeType();
        FileDecorator file = fromEntity.getModified().getFile();
        HashDecorator hash = fromEntity.getModified().getHash();
        if (mimeType != null) {
            contentMetadata.setContentType(mimeType.getType());
        }
        if (hash != null) {
            contentMetadata.setContentMD5(HashCode.fromString(hash.getMd5()));
        }
        if (file != null) {
            contentMetadata.setContentLength(file.getSize().longValue());
        }
    }

    private void addDefaultMetadata(Entity fromEntity, T toMetadata) {
        toMetadata.setLocation(defaultLocation == null ? null : defaultLocation.get());
        toMetadata.setId(fromEntity.getId());
        toMetadata.setUri(URI.create(fromEntity.getId()));

        CreatedDecorator created = fromEntity.getModified().getCreated();
        String name = extractName(fromEntity);
        FileDecorator file = fromEntity.getModified().getFile();
        ModifiedDecorator modified = fromEntity.getModified().getModified();

        if (name != null) {
            toMetadata.setName(name);
        } else {
            toMetadata.setName(fromEntity.getId());
        }
        if (created != null) {
            toMetadata.setCreationDate(Date.from(created.getDate().toInstant()));
        }
        if (modified != null) {
            toMetadata.setLastModified(Date.from(modified.getDate().toInstant()));
        }
        if (file != null) {
            toMetadata.setSize(file.getSize().longValue());
        }
    }

    private void addUserMetadata(Entity fromEntity, T toMetadata) {
        HashDecorator hash = fromEntity.getModified().getHash();
        VersionDecorator version = fromEntity.getModified().getVersion();
        DescriptionDecorator description = fromEntity.getModified().getDescription();
        PropertiesDecorator properties = fromEntity.getModified().getProperties();
        ContainerDecorator container = fromEntity.getModified().getContainer();
        FileSystemDecorator fileSystem = fromEntity.getModified().getFilesystem();
        MimeTypeDecorator mimeType = fromEntity.getModified().getMimeType();

        Map<String, String> userMetadata = new HashMap<>();
        if (hash != null) {
            userMetadata.put(HASH_MD5.getMetadataKey(), hash.getMd5());
            userMetadata.put(HASH_SHA1.getMetadataKey(), hash.getSha1());
            userMetadata.put(HASH_SHA256.getMetadataKey(), hash.getSha256());
        }
        if (version != null) {
            userMetadata.put(VERSION_TAG.getMetadataKey(), version.getTag());
        }
        if (description != null) {
            userMetadata.put(DESCRIPTION_SHORT.getMetadataKey(), description.getShort());
        }
        if (container != null) {
            userMetadata.put(CONTAINER_HAS_CHILDREN.getMetadataKey(), Boolean.toString(container.getHasChildren()));
        }
        if (fileSystem != null) {
            userMetadata.put(FILE_SYSTEM_PATH.getMetadataKey(), fileSystem.getPath());
        }
        if (mimeType != null) {
            userMetadata.put(MIME_TYPE_TYPE.getMetadataKey(), mimeType.getType());
        }
        if (properties != null && !properties.isEmpty()) {
            userMetadata.putAll(properties);
        }

        toMetadata.setUserMetadata(userMetadata);
    }


    private boolean isKind(Entity fromEntity, XillioConstants.Domain.Kind kind) {
        return kind != null && kind.is(fromEntity.getKind());
    }
}
