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

import com.google.auto.value.AutoValue;
import org.jclouds.json.SerializedNames;
import org.jclouds.oauth.v2.domain.Token;

/**
 * Claims corresponding to a {@linkplain Token JWT Token} for use when making a password grant request.
 *
 * @see <a href="https://tools.ietf.org/html/draft-ietf-oauth-json-web-token-30#section-4">registered list</a>
 */
@AutoValue
public abstract class XillioJWTToken {
    public abstract String accessToken();


    public abstract String tokenType();

    /**
     * The expiration time, in seconds after which the JWT must not be accepted for processing.
     */
    public abstract long expiresIn();

    public abstract String scope();

    /**
     * "JWT ID", a unique identifier for the JWT.
     */
    public abstract String jti();

    @SerializedNames({"access_token", "token_type", "expires_in", "scope", "jti"})
    public static XillioJWTToken create(String access_token, String token_type, long expires_in, String scope, String jti) {
        return new AutoValue_XillioJWTToken(access_token, token_type, expires_in, scope, jti);
    }

    XillioJWTToken() {
    }
}
