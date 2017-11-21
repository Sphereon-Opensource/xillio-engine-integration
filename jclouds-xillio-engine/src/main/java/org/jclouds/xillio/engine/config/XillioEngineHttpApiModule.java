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

import com.google.inject.Inject;
import org.jclouds.http.HttpErrorHandler;
import org.jclouds.http.annotation.ClientError;
import org.jclouds.http.annotation.Redirection;
import org.jclouds.http.annotation.ServerError;
import org.jclouds.json.config.GsonModule;
import org.jclouds.rest.ConfiguresHttpApi;
import org.jclouds.rest.config.HttpApiModule;
import org.jclouds.xillio.engine.XillioEngineApi;
import org.jclouds.xillio.engine.handlers.XillioEngineErrorHandler;

@ConfiguresHttpApi
public class XillioEngineHttpApiModule extends HttpApiModule<XillioEngineApi> {
    @Inject
    GsonModule.JsonAdapterBindings jsonAdapterBindings;

    @Override
    protected void configure() {
//        binder().requestStaticInjection(GsonModule.JsonAdapterBindings.class);
        super.configure();

//        jsonAdapterBindings.getFactories().add(new OffsetDateTimeTypeAdapterFactory());
    }

    @Override
    protected void bindErrorHandlers() {
        bind(HttpErrorHandler.class).annotatedWith(Redirection.class).to(XillioEngineErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ClientError.class).to(XillioEngineErrorHandler.class);
        bind(HttpErrorHandler.class).annotatedWith(ServerError.class).to(XillioEngineErrorHandler.class);
    }

}