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

import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import org.jclouds.ContextBuilder;
import org.jclouds.domain.Credentials;
import org.jclouds.domain.LoginCredentials;
import org.jclouds.http.HttpException;
import org.jclouds.http.HttpRequest;
import org.jclouds.http.HttpRequestFilter;
import org.jclouds.location.Provider;
import org.jclouds.logging.Logger;
import org.jclouds.logging.slf4j.SLF4JLogger;
import org.jclouds.oauth.v2.domain.Claims;
import org.jclouds.oauth.v2.domain.Token;
import org.jclouds.xillio.engine.AuthorizationApi;
import org.jclouds.xillio.engine.reference.XillioConstants;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class RequestHeaderFilter implements HttpRequestFilter {

    private static final Logger logger = new SLF4JLogger.SLF4JLoggerFactory().getLogger(RequestHeaderFilter.class.getName());

    private final Supplier<Credentials> credentialsSupplier;

    @Inject
    public RequestHeaderFilter(@Provider Supplier<Credentials> credentialsSupplier) {
        this.credentialsSupplier = credentialsSupplier;
    }

    @Override
    public HttpRequest filter(HttpRequest request) throws HttpException {
        Credentials credentials = credentialsSupplier.get();
        if (credentials == null || !LoginCredentials.class.isAssignableFrom(credentials.getClass())) {
            throw new SecurityException("Please provide login credentials for Xillio Engine");
        }
        LoginCredentials loginCredentials = (LoginCredentials) credentials;
        HttpRequest.Builder builder = request.toBuilder();
        if (request.getEndpoint().getPath().endsWith("/oauth/token")) {
            builder.replaceHeader(HttpHeaders.ACCEPT, MediaType.ANY_TYPE.type());
            builder.replaceHeader(HttpHeaders.AUTHORIZATION, String.format("%s:%s", loginCredentials.getUser(), loginCredentials.getOptionalPassword().get()));
        } else {
            Token token = retrieveToken(loginCredentials);
            builder.replaceHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", token.accessToken()));
        }
        request = builder.build();
        logger.debug("<< %s", request);
        return request;
    }

    Token retrieveToken(LoginCredentials loginCredentials) throws IOException {


        AuthorizationApi oauth = ContextBuilder.newBuilder(XillioConstants.XILLIO_ENGINE).credentialsSupplier(credentialsSupplier).buildApi(AuthorizationApi.class);

        try {
            long nowInSeconds = System.currentTimeMillis() / 1000;
            Claims claims = Claims.create(
                    credentialsSupplier.get().identity, // issuer
                    "https://www.googleapis.com/auth/compute", // write scope
                    "https://accounts.google.com/o/oauth2/token", // audience
                    nowInSeconds + 60, // token expiration (seconds)
                    nowInSeconds // current time (secods)
            );
            Token token = oauth.authorizeClientSecret(loginCredentials.identity, loginCredentials.credential);
            System.out.println(token);
            return token;
        } finally {
            oauth.close();
        }
    }
}
