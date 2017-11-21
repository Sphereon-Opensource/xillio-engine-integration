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

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;
import org.jclouds.blobstore.BlobStoreContext;
import org.jclouds.rest.internal.BaseHttpApiMetadata;
import org.jclouds.xillio.engine.blobstore.config.BlobStoreContextModule;
import org.jclouds.xillio.engine.config.XillioEngineHttpApiModule;

import javax.inject.Named;
import java.net.URI;
import java.util.Properties;

import static org.jclouds.reflect.Reflection2.typeToken;

/**
 * FIXME: 2-11-2017 Quick hack jclouds provider using SDK instead of Jclouds internal mechs
 */
public class XillioEngineApiMetadata extends BaseHttpApiMetadata<XillioEngineApi> {


    public static final String API_VERSION = "0.1";


    @Override
    public Builder toBuilder() {
        return new Builder().fromApiMetadata(this);
    }


    @Named
    public XillioEngineApiMetadata() {
        this(new Builder());
    }


    protected XillioEngineApiMetadata(Builder builder) {
        super(builder);
    }


    public static Properties defaultProperties() {
        Properties properties = BaseHttpApiMetadata.defaultProperties();
        return properties;
    }


    public static class Builder extends BaseHttpApiMetadata.Builder<XillioEngineApi, Builder> {
        protected Builder() {
            id("xillio-engine")
                    .name("Xillio Engine")
                    .identityName("API User") // TODO
//                    .credentialName("API Password")
                    .documentation(URI.create("https://xill.io"))
                    .version(API_VERSION)
                    .defaultEndpoint("https://sandbox.xill.io")
                    .defaultProperties(XillioEngineApiMetadata.defaultProperties())
                    .view(typeToken(BlobStoreContext.class))
//                    .view()
                    .defaultModules(ImmutableSet.<Class<? extends Module>>builder()
//                            .add(EnterpriseConfigurationModule.class)
//                            .add(JodaDateServiceModule.class)
                            .add(XillioEngineHttpApiModule.class)
                            .add(BlobStoreContextModule.class).build());
        }


        @Override
        public XillioEngineApiMetadata build() {
            return new XillioEngineApiMetadata(this);
        }


        @Override
        protected Builder self() {
            return this;
        }
    }
}