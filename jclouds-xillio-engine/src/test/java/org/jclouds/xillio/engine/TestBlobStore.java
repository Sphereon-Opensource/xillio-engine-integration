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

package org.jclouds.xillio.engine;

import com.google.common.net.MediaType;
import org.jclouds.ContextBuilder;
import org.jclouds.blobstore.BlobStore;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.blobstore.domain.Blob;
import org.jclouds.blobstore.domain.BlobBuilder;
import org.jclouds.blobstore.domain.PageSet;
import org.jclouds.blobstore.domain.StorageMetadata;
import org.jclouds.blobstore.options.ListContainerOptions;
import org.jclouds.blobstore.options.PutOptions;
import org.jclouds.http.HttpResponseException;
import org.jclouds.io.ByteStreams2;
import org.jclouds.xillio.engine.reference.XillioConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Test(singleThreaded = true)
public class TestBlobStore {

    private final BlobStore blobStore = getXillioBlobStore();
    private static final String container = System.getProperty("XILLIO.TEST.CONTAINER", "5a0d9e26857aba0005396d53");
    private static final String filename1 = "file1.txt";
    private static final String filename2 = "folder/file1.txt";

    private static final boolean FIDDLER_ENABLED = false;

    static {
        if (FIDDLER_ENABLED) {
            // to support localhost.fiddler
            System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("https.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "8888");
            System.setProperty("https.proxyPort", "8888");
        }
    }

    @Test(priority = 1)
    public void assertContainerNotExists() {
        boolean exists = blobStore.containerExists("Non-existing-" + System.currentTimeMillis());
        Assert.assertFalse(exists);
    }

    @Test(priority = 2)
    public void assertContainerExists() {
        boolean exists = blobStore.containerExists(container);
        Assert.assertTrue(exists);
    }


    @Test(priority = 3)
    public void putAndGetBlob() throws IOException, InterruptedException {
        byte[] payload = "TEXT".getBytes();
        BlobBuilder blobBuilder = blobStore.blobBuilder(filename1);
        BlobBuilder.PayloadBlobBuilder payloadBlobBuilder = blobBuilder.payload(payload);
        payloadBlobBuilder.contentType(MediaType.PLAIN_TEXT_UTF_8);
        Blob blob = payloadBlobBuilder.build();

        String eTag = blobStore.putBlob(container, blob);
        Assert.assertNotNull(eTag);
        Thread.sleep(50);

        boolean exists = blobStore.blobExists(container, filename1);
        Assert.assertTrue(exists);

        Blob retrieved = blobStore.getBlob(container, filename1);
        assertBlobs(blob, retrieved);

        Assert.assertEquals(ByteStreams2.toByteArrayAndClose(retrieved.getPayload().openStream()), payload);
    }

    @Test(priority = 4)
    public void putAndGetBlobAgain() throws IOException, InterruptedException {

        byte[] payload = "Updated TEXT".getBytes();
        BlobBuilder blobBuilder = blobStore.blobBuilder(filename1);
        BlobBuilder.PayloadBlobBuilder payloadBlobBuilder = blobBuilder.payload(payload);
        payloadBlobBuilder.contentType(MediaType.PLAIN_TEXT_UTF_8);
        Blob blob = payloadBlobBuilder.build();

        String eTag = blobStore.putBlob(container, blob);
        Assert.assertNotNull(eTag);
        Thread.sleep(50);

        Blob retrieved = blobStore.getBlob(container, filename1);
        assertBlobs(blob, retrieved);
        Assert.assertEquals(ByteStreams2.toByteArrayAndClose(retrieved.getPayload().openStream()), payload);
    }

    @Test(priority = 5)
    public void putAndGetBlobFolder() {
        byte[] payload = "TEXT".getBytes();
        BlobBuilder blobBuilder = blobStore.blobBuilder(filename2);
        BlobBuilder.PayloadBlobBuilder payloadBlobBuilder = blobBuilder.payload(payload);
        payloadBlobBuilder.contentType(MediaType.PLAIN_TEXT_UTF_8);
        Blob blob = payloadBlobBuilder.build();

        PutOptions putOptions = PutOptions.Builder.multipart();

        String eTag = blobStore.putBlob(container, blob, putOptions);
        Assert.assertNotNull(eTag);

        boolean exists = blobStore.blobExists(container, filename2);
        Assert.assertTrue(exists);

        Blob retrieved = blobStore.getBlob(container, filename2);

        assertBlobs(blob, retrieved);

    }


    @Test(priority = 6)
    public void list() {

        ListContainerOptions options = ListContainerOptions.Builder.prefix(filename1);
        PageSet<? extends StorageMetadata> list = blobStore.list(container, options);

        Assert.assertEquals( list.size(), 1);

    }

    @Test(priority = 7)
    public void removeBlob() {
        PageSet<? extends StorageMetadata> list = null;
        int sizeBefore = 0;
        boolean existed = blobStore.blobExists(container, filename1);
        try {
            list = blobStore.list(container);
            sizeBefore = list.size();
        } finally {
            if (existed) {
                blobStore.removeBlob(container, filename1);
            }
        }

        boolean exists = blobStore.blobExists(container, filename1);
        Assert.assertFalse(exists);

        if (existed) {
            list = blobStore.list(container);
            Assert.assertEquals(list.size(), sizeBefore - 1);
        }
    }

    @Test(enabled = false, priority = 8, expectedExceptions = HttpResponseException.class)
    public void deleteContainerTry() {
        boolean deleted = blobStore.deleteContainerIfEmpty(container);
        Assert.assertFalse(deleted);
    }

    @Test(enabled = false, priority = 9)
    public void deleteContainer() {
        blobStore.removeBlob(container, filename2);

        blobStore.deleteContainer(container);


        boolean exists = blobStore.blobExists(container, filename1);
        Assert.assertFalse(exists);

        exists = blobStore.blobExists(container, filename2);
        Assert.assertFalse(exists);
    }

    @Test(enabled = false, priority = 10)
    public void assertContainerDeleted() {
        boolean exists = blobStore.containerExists(container);
        Assert.assertFalse(exists);
    }

    private void assertBlobs(Blob blob, Blob retrieved) {
        Assert.assertNotNull(retrieved);
        Assert.assertNotNull(retrieved.getMetadata().getContainer());
        Assert.assertEquals(retrieved.getMetadata().getName(), blob.getMetadata().getName());
        Assert.assertEquals(retrieved.getMetadata().getType(), blob.getMetadata().getType());
        Assert.assertNotNull(retrieved.getMetadata().getSize());
        Assert.assertNotNull(retrieved.getMetadata().getLastModified());
        Assert.assertNotNull(retrieved.getMetadata().getCreationDate());
        Assert.assertNotNull(retrieved.getMetadata().getContentMetadata().getContentType());
    }


    protected BlobStore getXillioBlobStore() {
        String provider = "xillio-engine";
        ContextBuilder contextBuilder = ContextBuilder.newBuilder(provider);
        Properties properties = new Properties();
        properties.setProperty(XillioConstants.ENDPOINT, System.getProperty("XILLIO.TEST.ENDPOINT", "https://sandbox.xill.io"));
        properties.setProperty(XillioConstants.IDENTITY, "test");
        contextBuilder.overrides(properties);

        BlobStoreContext blobStoreContext = contextBuilder.buildView(BlobStoreContext.class);
        BlobStore blobStore = blobStoreContext.getBlobStore();

        return blobStore;
    }
}