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

package org.jclouds.xillio.engine.binders;

import com.google.inject.Inject;
import org.jclouds.http.HttpRequest;
import org.jclouds.io.Payload;
import org.jclouds.io.Payloads;
import org.jclouds.io.payloads.MultipartForm;
import org.jclouds.io.payloads.Part;
import org.jclouds.io.payloads.StringPayload;
import org.jclouds.json.Json;
import org.jclouds.rest.MapBinder;
import org.jclouds.xillio.engine.model.Entity;

import java.util.Map;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;

public final class MultipartUploadBinder implements MapBinder {
    private static final String BOUNDARY_HEADER = "multipart_boundary";

    private final Json json;

    @Inject
    MultipartUploadBinder(Json json) {
        this.json = json;
    }

    @Override
    public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
        Entity entity = (Entity) postParams.get("entity");
        Payload contentsPayload = (Payload) postParams.get("contents");

//      String contentType = checkNotNull(entity.contentType(), "contentType");
//      Long length = checkNotNull(entity.size(), "contentLength");

        String entityJson = json.toJson(entity);
        long entityLength = entityJson.length();
        StringPayload jsonPayload = Payloads.newStringPayload(entityJson);
        jsonPayload.getContentMetadata().setContentLength(entityLength);

//      contentsPayload.getContentMetadata().setContentLength(length);

        Part entityPart = Part.create("entity", jsonPayload, new Part.PartOptions().contentType(APPLICATION_JSON));
        if (contentsPayload != null) {
            Part contentsPart = Part.create("contents", contentsPayload, new Part.PartOptions().contentType(APPLICATION_OCTET_STREAM));
            request.setPayload(new MultipartForm(BOUNDARY_HEADER, entityPart, contentsPart));
        } else {
            request.setPayload(new MultipartForm(BOUNDARY_HEADER, entityPart));
        }
        // HeaderPart
        request.toBuilder().replaceHeader(CONTENT_TYPE, "Multipart/related; boundary= " + BOUNDARY_HEADER).build();
        return request;
    }

    @Override
    public <R extends HttpRequest> R bindToRequest(R request, Object input) {
        return request;
    }
}