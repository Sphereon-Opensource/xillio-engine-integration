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

import com.google.inject.name.Named;
import org.jclouds.Fallbacks;
import org.jclouds.blobstore.options.ListContainerOptions;
import org.jclouds.io.Payload;
import org.jclouds.io.PayloadEnclosing;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.ResponseParser;
import org.jclouds.xillio.engine.binders.MultipartUploadBinder;
import org.jclouds.xillio.engine.filters.XillioSecretFlow;
import org.jclouds.xillio.engine.model.Entity;
import org.jclouds.xillio.engine.model.EntityResponse;
import org.jclouds.xillio.engine.options.EntityQueryOptions;
import org.jclouds.xillio.engine.parsers.ParseEntityResponse;
import org.jclouds.xillio.engine.parsers.ParseToPayloadEnclosing;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.Closeable;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;

@RequestFilters({XillioSecretFlow.class})
public interface XillioEngineApi extends Closeable {

    @Named("ListRepositories")
    @GET
    @Path("v2/entities")
    @QueryParams(keys = "scope", values = "children")
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse listRepositories(ListContainerOptions... listOptions);

    @Named("GetEntity")
    @GET
    @Path("v2/entities/{configurationId}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse getRepository(@PathParam("configurationId") String configurationId);

    @Named("GetEntity")
    @GET
    @Path("v2/entities/{configurationId}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse getRepository(@PathParam("configurationId") String configurationId, EntityQueryOptions entityQueryOptions);

    @Named("GetEntity")
    @GET
    @Path("v2/entities/{configurationId}/{path}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse getEntity(@PathParam("configurationId") String configurationId, @PathParam("path") String path);

    @Named("GetEntity")
    @GET
    @Path("v2/entities/{configurationId}/{path}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse getEntity(@PathParam("configurationId") String configurationId, @PathParam("path") String path, EntityQueryOptions entityQueryOptions);


    @Named("CreateEntity")
    @POST
    @Path("v2/entities/{configurationId}/{path}")
    @MapBinder(MultipartUploadBinder.class)
//    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Consumes(APPLICATION_JSON)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse createEntity(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path,
                                @PayloadParam("entity") Entity entity,
                                @Nullable @PayloadParam("contents") Payload contents);

    @Named("CreateEntity")
    @POST
    @Path("v2/entities/{configurationId}/{path}")
    @MapBinder(MultipartUploadBinder.class)
//    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Consumes(APPLICATION_JSON)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse createEntity(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path,
                                @PayloadParam("entity") Entity entity,
                                @Nullable @PayloadParam("contents") Payload contents, EntityQueryOptions entityQueryOptions);

    @Named("UpdateEntity")
    @PUT
    @Path("v2/entities/{configurationId}/{path}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Consumes(APPLICATION_JSON)
    @Nullable
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse updateEntity(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path, Payload payload);

    @Named("UpdateEntity")
    @PUT
    @Path("v2/entities/{configurationId}/{path}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Nullable
    @Consumes(APPLICATION_JSON)
    @ResponseParser(ParseEntityResponse.class)
    EntityResponse updateEntity(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path, Payload payload, EntityQueryOptions entityQueryOptions);

    @Named("DeleteEntity")
    @DELETE
    @Path("v2/entities/{configurationId}/{path}")
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    @Consumes(APPLICATION_JSON)
    void deleteEntity(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path);

    @Named("ConfigurationExists")
    @GET
    @Path("v2/entities/{configurationId}")
    @QueryParams(keys = "scope", values = "entity")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean configurationExists(@PathParam("configurationId") String configurationId);


    @Named("EntityExists")
    @GET
    @Path("v2/entities/{configurationId}/{path}")
    @QueryParams(keys = "scope", values = "entity")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean entityExists(@PathParam("configurationId") String configurationId, @PathParam("path") String path);


    @Named("UpdateContents")
    @PUT
    @Path("v2/contents/{configurationId}/{path}")
    @Consumes(APPLICATION_OCTET_STREAM)
    void updateContents(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path, Payload payload);

    @Named("GetContents")
    @GET
    @Path("v2/contents/{configurationId}/{path}")
    @ResponseParser(ParseToPayloadEnclosing.class)
    @Nullable
    PayloadEnclosing getContents(@PathParam("configurationId") String configurationId, @Encoded @PathParam("path") String path);

}
