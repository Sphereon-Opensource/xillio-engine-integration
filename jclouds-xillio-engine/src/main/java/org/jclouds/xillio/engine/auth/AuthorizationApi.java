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
package org.jclouds.xillio.engine.auth;

import org.jclouds.oauth.v2.OAuthFallbacks.AuthorizationExceptionOn4xx;
import org.jclouds.oauth.v2.config.Authorization;
import org.jclouds.rest.annotations.Endpoint;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.FormParams;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import java.io.Closeable;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Endpoint(Authorization.class)
public interface AuthorizationApi extends Closeable {

   @Named("oauth2:authorize_password")
   @POST
   @FormParams(keys = {"grant_type"}, values = {"password"})
   @Consumes(APPLICATION_JSON)
   @Fallback(AuthorizationExceptionOn4xx.class)
   XillioJWTToken authorize(
           @HeaderParam("Authorization") String basicAuthOfClientIdAndSecret,
           @FormParam("username") String username,
           @FormParam("password") String password
   );
}
