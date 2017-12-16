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

import com.google.auto.service.AutoService;
import org.jclouds.providers.ProviderMetadata;
import org.jclouds.providers.internal.BaseProviderMetadata;

import java.net.URI;
import java.util.Properties;

/**
 * Implementation of {@link ProviderMetadata} for Xillio Engine.
 */

/**
 * FIXME: 2-11-2017 Quick hack jclouds provider using SDK instead of Jclouds internal mechs
 */
@AutoService(ProviderMetadata.class)
public class XillioEngineProviderMetadata extends BaseProviderMetadata {

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public Builder toBuilder() {
        return builder().fromProviderMetadata(this);
    }


    public XillioEngineProviderMetadata() {
        super(builder());
    }


    public XillioEngineProviderMetadata(Builder builder) {
        super(builder);
    }


    public static Properties defaultProperties() {
        return new Properties(); // currently all are set in the api metadata class.
    }


    public static final class Builder extends BaseProviderMetadata.Builder {

        private Builder() {
            id("xillio-engine")
                    .name("Xillio Engine")
                    .apiMetadata(new XillioEngineApiMetadata())
                    .homepage(URI.create("https://sphereon.com"))
                    .console(URI.create("https://store.sphereon.com/store"))
                    .defaultProperties(XillioEngineProviderMetadata.defaultProperties());
        }


        @Override
        public XillioEngineProviderMetadata build() {
            return new XillioEngineProviderMetadata(this);
        }


        @Override
        public Builder fromProviderMetadata(ProviderMetadata in) {
            super.fromProviderMetadata(in);
            return this;
        }
    }
}