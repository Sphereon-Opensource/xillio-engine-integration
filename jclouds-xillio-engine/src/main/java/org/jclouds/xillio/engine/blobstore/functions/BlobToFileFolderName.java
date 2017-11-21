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
import org.jclouds.blobstore.domain.Blob;

import java.util.ArrayList;
import java.util.List;

public class BlobToFileFolderName implements Function<Blob, BlobToFileFolderName.FileFolder> {

    public static final String SLASH = "/";

    @Override
    public FileFolder apply(Blob blob) {
        String blobName = blob.getMetadata().getName();

        FileFolder fileFolder = new FileFolder();
        if (blobName != null && !"".equals(blobName.trim())) {
            fileFolder = parse(blobName);
        }
        return fileFolder;
    }

    private FileFolder parse(String input) {
        FileFolder fileFolder = new FileFolder();
        if (input.endsWith(SLASH)) {
            // is this possible for a blob?
            fileFolder.setFolder(input);
        } else if (!input.contains(SLASH)) {
            fileFolder.setFile(input);
        } else {

            int last = input.lastIndexOf(SLASH);
            fileFolder.setFolder(input.substring(0, last));
            fileFolder.setFile(input.substring(last + 1, input.length()));
        }
        return fileFolder;
    }


    public static class FileFolder {
        private String file;
        private String folder;

        public String getExtension() {
            if (!hasFile()) {
                return null;
            }
            int dot = getFile().lastIndexOf(".");
            if (dot <= 0 || dot == getFile().length()) {
                return "";
            }
            return getFile().substring(dot + 1, getFile().length());
        }

        public String getFile() {
            return file;
        }

        public boolean hasFile() {
            return getFile() != null && !"".equals(getFile().trim());
        }

        protected void setFile(String file) {
            this.file = file;
        }

        public String getFolder() {
            if (folder == null) {
                return "";
            }
            return folder;
        }

        public List<String> getFolderParts() {
            List<String> parts = new ArrayList<>();
            if (!"".equals(getFolder())) {
                String[] folders = getFolder().split("/");
                if (folders.length > 0) {
                    for (String folder : folders) {
                        parts.add(folder);
                    }
                }
            }
            return parts;
        }

        public List<String> getFolderHierarchy() {
            List<String> hierarchy = new ArrayList<>();
            List<String> parts = getFolderParts();
            String last = "";
            if (parts.size() > 0) {
                for (String folder : parts) {
                    last += folder;
                    hierarchy.add(last);
                    last += "/";
                }
            }

            return hierarchy;
        }

        protected void setFolder(String folder) {
            this.folder = folder;
            if (folder != null && folder.endsWith("/")) {
                this.folder = folder.substring(0, folder.length() - 1);
            }
        }

        public boolean hasFolder() {
            return !"".equals(getFolder());
        }


    }
}
