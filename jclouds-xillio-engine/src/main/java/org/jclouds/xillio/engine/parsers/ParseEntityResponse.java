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

package org.jclouds.xillio.engine.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import org.jclouds.http.functions.ParseJson;
import org.jclouds.json.internal.GsonWrapper;
import org.jclouds.xillio.engine.blobstore.config.OffsetDateTimeTypeAdapter;
import org.jclouds.xillio.engine.model.EntityResponse;

import java.time.OffsetDateTime;

public class ParseEntityResponse extends ParseJson<EntityResponse> {

    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter()).create();

    @Inject
    public ParseEntityResponse(GsonWrapper json, TypeLiteral<EntityResponse> type) {
        super(new GsonWrapper(GSON), type);

    }
}
