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

import com.google.common.base.Supplier;
import org.jclouds.domain.Credentials;
import org.jclouds.xillio.engine.reference.XillioConstants;

import java.util.Properties;

public class XillioCredentialsSupplier implements Supplier<Credentials> {
    private final Properties properties;

    public XillioCredentialsSupplier(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Credentials get() {
        return XillioCredentials.builder().
                user((String) properties.get(XillioConstants.USERNAME)).
                password((String) properties.get(XillioConstants.PASSWORD)).
                identity((String) properties.get(XillioConstants.CLIENT_ID)).
                credential((String) properties.get(XillioConstants.CLIENT_SECRET)).
                build();
    }
}
