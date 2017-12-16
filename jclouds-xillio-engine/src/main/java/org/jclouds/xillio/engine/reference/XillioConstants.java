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

package org.jclouds.xillio.engine.reference;

import org.jclouds.blobstore.domain.StorageType;

public final class XillioConstants {

    private XillioConstants() {
    }

    public static final String XILLIO_ENGINE = "xillio-engine";

    private static final String BASE = "jclouds." + XILLIO_ENGINE;

    public static final String API_ENDPOINT = BASE + ".endpoint";
    public static final String CLIENT_ID = XILLIO_ENGINE + ".identity";
    public static final String CLIENT_SECRET = XILLIO_ENGINE + ".secret";
    public static final String USERNAME = XILLIO_ENGINE + ".username";
    public static final String PASSWORD = XILLIO_ENGINE + ".password";
    public static final String AUTH_ENDPOINT = BASE + "auth-endpoint";

    public static final class Domain {

        public enum DecoratorName {
            HASH_MD5("hash", "md5"), HASH_SHA1("hash", "sha1"), HASH_SHA256("hash", "sha256"),
            VERSION_TAG("version", "tag"),
            DESCRIPTION_SHORT("description", "short"),
            CONTAINER_HAS_CHILDREN("container", "has-children"),
            FILE_SYSTEM_PATH("file-system", "path"),
            MIME_TYPE_TYPE("mime-type", "type");

            private final String value;
            private final String decorator;

            DecoratorName(String decorator, String value) {
                this.decorator = decorator;
                this.value = value;
            }

            public String getDecorator() {
                return decorator;
            }

            public String getValue() {
                return value;
            }

            public String getMetadataKey() {
                return getDecorator() + "." + getValue();
            }
        }

        public enum Kind {
            FILE("File", StorageType.BLOB), FOLDER("Folder", StorageType.FOLDER), FILE_SYSTEM("FileSystem", StorageType.FOLDER), CONFIGURATION("Configuration", StorageType.CONTAINER), CONTAINER("Container", StorageType.CONTAINER);

            private final String entityValue;
            private final StorageType storageType;

            Kind(String entityValue, StorageType storageType) {
                this.entityValue = entityValue;
                this.storageType = storageType;
            }

            public String getEntityValue() {
                return entityValue;
            }

            public boolean is(String value) {
                return value != null && entityValue.equalsIgnoreCase(value);
            }

            public StorageType getStorgeType() {
                return storageType;
            }

            public static Kind getFirstOfType(StorageType storageType) {
                for (Kind kind : values()) {
                    if (storageType == kind.getStorgeType()) {
                        return kind;
                    }
                }
                throw new IllegalArgumentException("Could not find type for storage type " + storageType.name());
            }
        }

    }


}