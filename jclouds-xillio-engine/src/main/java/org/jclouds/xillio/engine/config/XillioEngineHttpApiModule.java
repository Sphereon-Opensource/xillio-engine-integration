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

package org.jclouds.xillio.engine.config;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import org.jclouds.http.HttpErrorHandler;
import org.jclouds.http.annotation.ClientError;
import org.jclouds.http.annotation.Redirection;
import org.jclouds.http.annotation.ServerError;
import org.jclouds.oauth.v2.config.Authorization;
import org.jclouds.rest.ConfiguresHttpApi;
import org.jclouds.rest.config.HttpApiModule;
import org.jclouds.xillio.engine.XillioEngineApi;
import org.jclouds.xillio.engine.auth.AuthorizationApi;
import org.jclouds.xillio.engine.handlers.XillioEngineErrorHandler;
import org.jclouds.xillio.engine.reference.XillioConstants;

import java.net.URI;

import static org.jclouds.rest.config.BinderUtils.bindHttpApi;

@ConfiguresHttpApi
public class XillioEngineHttpApiModule extends HttpApiModule<XillioEngineApi> {

    @Override
    protected void configure() {
        super.configure();
        bindHttpApi(binder(), AuthorizationApi.class);
    }

    @Override
    protected void bindErrorHandlers() {
        bind(HttpErrorHandler.class).annotatedWith(Redirection.class).to(XillioEngineErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ClientError.class).to(XillioEngineErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ServerError.class).to(XillioEngineErrorHandler.class);
    }


    @Provides
    @Authorization
    protected Supplier<URI> oauthEndpoint(@Named(XillioConstants.AUTH_ENDPOINT) String endpoint) {
        return Suppliers.ofInstance(URI.create(endpoint));
    }
}