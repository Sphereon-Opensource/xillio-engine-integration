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
import com.google.common.hash.HashCode;
import org.jclouds.blobstore.domain.Blob;
import org.jclouds.blobstore.domain.BlobMetadata;
import org.jclouds.io.ContentMetadata;
import org.jclouds.xillio.engine.model.ContainerDecorator;
import org.jclouds.xillio.engine.model.CreatedDecorator;
import org.jclouds.xillio.engine.model.Decorators;
import org.jclouds.xillio.engine.model.DescriptionDecorator;
import org.jclouds.xillio.engine.model.Entity;
import org.jclouds.xillio.engine.model.FileDecorator;
import org.jclouds.xillio.engine.model.FileSystemDecorator;
import org.jclouds.xillio.engine.model.HashDecorator;
import org.jclouds.xillio.engine.model.ModifiedDecorator;
import org.jclouds.xillio.engine.model.NameDecorator;
import org.jclouds.xillio.engine.model.ParentDecorator;
import org.jclouds.xillio.engine.model.PropertiesDecorator;
import org.jclouds.xillio.engine.model.VersionDecorator;
import org.jclouds.xillio.engine.reference.XillioConstants;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneId;
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

public class BlobMetadataToEntity implements Function<Blob, Entity> {

    public Entity apply(Blob blob) {
        if (blob == null || blob.getMetadata() == null) {
            return null;
        }

        BlobMetadata fromMetadata = blob.getMetadata();
        BlobToFileFolderName.FileFolder fileFolder = new BlobToFileFolderName().apply(blob);
        XillioConstants.Domain.Kind kind = XillioConstants.Domain.Kind.getFirstOfType(fromMetadata.getType());

        Decorators modified = new Decorators();
        Entity entity = new Entity().modified(modified);
        entity.setKind(kind.getEntityValue());

        defaultDecorators(fromMetadata, fileFolder, entity);
        if (kind == XillioConstants.Domain.Kind.FILE) {
            decoratorsFromContentMetadata(fromMetadata, modified);
        }
        decoratorsFromUserMetadata(fromMetadata, modified);


        // This only works for new blobs
        entity.original(modified);

        return entity;
    }

    private void decoratorsFromUserMetadata(BlobMetadata fromMetadata, Decorators modified) {
        Map<String, String> userMetadata = fromMetadata.getUserMetadata();

        HashDecorator hash = modified.getHash() == null ? new HashDecorator() : modified.getHash();
        if (userMetadata.containsKey(HASH_MD5.getMetadataKey())) {
            hash.md5(userMetadata.get(HASH_MD5.getMetadataKey()));
        }
        if (userMetadata.containsKey(HASH_SHA1.getMetadataKey())) {
            hash.md5(userMetadata.get(HASH_SHA1.getMetadataKey()));
        }
        if (userMetadata.containsKey(HASH_SHA256.getMetadataKey())) {
            hash.md5(userMetadata.get(HASH_SHA256.getMetadataKey()));
        }
        if (hash.getMd5() != null || hash.getSha1() != null || hash.getSha256() != null) {
            modified.hash(hash);
        }

        if (userMetadata.containsKey(VERSION_TAG.getMetadataKey())) {
            modified.version(new VersionDecorator().tag(userMetadata.get(VERSION_TAG.getMetadataKey())));
        }
        if (userMetadata.containsKey(DESCRIPTION_SHORT.getMetadataKey())) {
            modified.description(new DescriptionDecorator()._short(userMetadata.get(DESCRIPTION_SHORT.getMetadataKey())));
        }

        Map<String, String> copiedUserData = new HashMap<>();
        copiedUserData.putAll(userMetadata);
        for (XillioConstants.Domain.DecoratorName decoratorName : XillioConstants.Domain.DecoratorName.values()) {
            copiedUserData.remove(decoratorName.getMetadataKey());
        }
        modified.properties(new PropertiesDecorator()).getProperties().putAll(copiedUserData);

        if (userMetadata.containsKey(CONTAINER_HAS_CHILDREN.getMetadataKey())) {
            modified.container(new ContainerDecorator().hasChildren(Boolean.valueOf(userMetadata.get(CONTAINER_HAS_CHILDREN.getMetadataKey()))));
        }
        if (userMetadata.containsKey(FILE_SYSTEM_PATH.getMetadataKey())) {
            modified.filesystem(new FileSystemDecorator().path(userMetadata.get(FILE_SYSTEM_PATH.getMetadataKey())));
        }
    }

    private void defaultDecorators(BlobMetadata fromMetadata, BlobToFileFolderName.FileFolder fileFolder, Entity entity) {
        Decorators modified = entity.getModified();
        String name = fileFolder.getFile();
        boolean isFile = name != null;
        if (!isFile) {
            name = fileFolder.getFolder();
        }
        modified.name(new NameDecorator().systemName(name));

        if (isFile) {
            FileDecorator fileDecorator = modified.getFile() == null ? modified.file(new FileDecorator()).getFile() : modified.getFile();
            if (fileDecorator.getSize() == null && fromMetadata.getSize() != null) {
                fileDecorator.size(new BigDecimal(fromMetadata.getSize()));
            }
            fileDecorator.extension(fileFolder.getExtension()).rawExtension(fileFolder.getExtension());
        }
        if (fromMetadata.getUri() != null) {
            entity.setId(fromMetadata.getUri().toString());
        }
    }

    private String contentType(String orig) {
        if (orig == null || !orig.contains(";")) {
            return orig;
        }
        return orig.split(";")[0];
    }

    private void decoratorsFromContentMetadata(BlobMetadata fromMetadata, Decorators modified) {
        ContentMetadata contentMetadata = fromMetadata.getContentMetadata();
//            String contentDisposition = contentMetadata.getContentDisposition();
//            String contentEncoding = contentMetadata.getContentEncoding();
//            String contentLanguage = contentMetadata.getContentLanguage();
        String container = fromMetadata.getContainer();
        String contentType = contentMetadata.getContentType();
        Long contentLength = contentMetadata.getContentLength();
        HashCode md5 = contentMetadata.getContentMD5AsHashCode();
        Date creationDate = fromMetadata.getCreationDate();
        Date lastModified = fromMetadata.getLastModified();


        if (creationDate != null) {
            modified.created(new CreatedDecorator().date(OffsetDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault())));
        }
        if (lastModified != null) {
            modified.modified(new ModifiedDecorator().date(OffsetDateTime.ofInstant(lastModified.toInstant(), ZoneId.systemDefault())));
        }
        if (container != null) {
            modified.parent(new ParentDecorator().id(container));
        }
        // JSON parse error: Can not construct instance of nl.xillio.engine.model.MimeTypeDecorator: no suitable constructor found,
//        if (contentType != null) {
//            modified.mimeType(new MimeTypeDecorator().type(contentType(contentType)));
//        }
        if (md5 != null) {
            modified.hash(new HashDecorator().md5(md5.toString()));
        }
        if (contentLength != null) {
            // Could have been set already in default method
            FileDecorator fileDecorator = modified.getFile() == null ? new FileDecorator() : modified.getFile();
            if (fileDecorator.getSize() == null) {
                fileDecorator.size(new BigDecimal(contentLength));
            }
            modified.file(fileDecorator);
        }
    }
}