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

import org.jclouds.domain.Credentials;

import static com.google.common.base.Preconditions.checkNotNull;

public class XillioCredentials extends Credentials {

    private final String user;
    private final String password;

    private XillioCredentials(String user, String password, String identity, String credential) {
        super(identity, credential);
        this.user = checkNotNull(user, "user");
        this.password = checkNotNull(password, "password");
    }


    public static XillioCredentials fromCredentials(Credentials creds) {
        if (creds == null) {
            return null;
        } else if (creds instanceof XillioCredentials) {
            return XillioCredentials.class.cast(creds);
        } else {
            return builder(creds).build();
        }
    }

    public static Builder builder(Credentials creds) {
        if (creds == null) {
            return builder();
        } else if (creds instanceof XillioCredentials) {
            return XillioCredentials.class.cast(creds).toBuilder();
        } else {
            return builder().identity(creds.identity).credential(creds.credential);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Credentials.Builder<XillioCredentials> {
        private String user;
        private String password;

        public Builder identity(String identity) {
            return Builder.class.cast(super.identity(identity));
        }


        public Builder credential(String credential) {
            return Builder.class.cast(super.credential(credential));
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public XillioCredentials build() {
            return new XillioCredentials(user, password, identity, credential);
        }
    }


    /**
     * @return the login user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the password of the login user
     */
    public String getPassword() {
        return password;
    }

    @Override
    public Builder toBuilder() {
        Builder builder = new Builder().user(user).password(password).identity(identity).credential(credential);
        return builder;
    }

    @Override
    public String toString() {
        return "XillioCredentials{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", credential='" + credential + '\'' +
                '}';
    }
}
