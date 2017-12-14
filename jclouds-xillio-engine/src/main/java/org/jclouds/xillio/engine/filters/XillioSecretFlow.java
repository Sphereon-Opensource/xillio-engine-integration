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
package org.jclouds.xillio.engine.filters;

import com.google.common.base.Charsets;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Inject;
import org.jclouds.domain.Credentials;
import org.jclouds.http.HttpException;
import org.jclouds.http.HttpRequest;
import org.jclouds.location.Provider;
import org.jclouds.oauth.v2.filters.OAuthFilter;
import org.jclouds.xillio.engine.auth.AuthorizationApi;
import org.jclouds.xillio.engine.auth.XillioCredentials;
import org.jclouds.xillio.engine.auth.XillioCredentialsSupplier;
import org.jclouds.xillio.engine.auth.XillioJWTToken;

import javax.inject.Named;

import java.net.URLEncoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.jclouds.Constants.PROPERTY_SESSION_INTERVAL;

/**
 * Authorizes new Bearer Tokens at runtime by sending a http request to the token endpoint.
 * <p>
 * To retrieve the Bearer Token, a request of grant_type=password is
 * used.  The credential supplied is a password and client_credentials.
 * <p>
 * <h3>Cache</h3>
 * This maintains a time-based Bearer Token cache. By default expires after 59 minutes
 *
 */
public class XillioSecretFlow implements OAuthFilter {
    private final XillioCredentialsSupplier credentialsSupplier;
    private final LoadingCache<XillioCredentials, XillioJWTToken> tokenCache;

    @Inject
    XillioSecretFlow(AuthorizeToken loader, @Named(PROPERTY_SESSION_INTERVAL) long tokenDuration,
                     @Provider Supplier<Credentials> credentialsSupplier) {
        this.credentialsSupplier = (XillioCredentialsSupplier) credentialsSupplier;
        // since the session interval is also the token expiration time requested to the server make the token expire a
        // bit before the deadline to make sure there aren't session expiration exceptions
        long cacheExpirationSeconds = tokenDuration > 30 ? tokenDuration - 30 : tokenDuration;
        this.tokenCache = CacheBuilder.newBuilder().expireAfterWrite(cacheExpirationSeconds, SECONDS).build(loader);
    }

    static final class AuthorizeToken extends CacheLoader<XillioCredentials, XillioJWTToken> {
        private final AuthorizationApi api;

        @Inject
        AuthorizeToken(AuthorizationApi api) {
            this.api = api;
        }

        @Override
        public XillioJWTToken load(XillioCredentials key) throws Exception {
            String authPair = String.format("%s:%s", key.identity, key.credential);
            String basicAuth = "Basic " + Base64.getEncoder().encodeToString(authPair.getBytes(Charsets.ISO_8859_1));
            XillioJWTToken token = api.authorize(basicAuth, key.getUser(), key.getPassword());
            return token;
        }
    }

    @Override
    public HttpRequest filter(HttpRequest request) throws HttpException {
        XillioCredentials credentials = (XillioCredentials) credentialsSupplier.get();
        XillioJWTToken token = tokenCache.getUnchecked(credentials);
        String bearerTokenAuth = String.format("%s %s", token.tokenType(), token.accessToken());
        return request.toBuilder().addHeader("Authorization", bearerTokenAuth).build();
    }
}
