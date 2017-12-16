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

package org.jclouds.xillio.engine.handlers;

import com.google.inject.Singleton;
import org.jclouds.http.HttpCommand;
import org.jclouds.http.HttpErrorHandler;
import org.jclouds.http.HttpResponse;
import org.jclouds.http.HttpResponseException;
import org.jclouds.rest.AuthorizationException;
import org.jclouds.rest.ResourceAlreadyExistsException;
import org.jclouds.rest.ResourceNotFoundException;

import static org.jclouds.http.HttpUtils.closeClientButKeepContentStream;

@Singleton
public class XillioEngineErrorHandler implements HttpErrorHandler {
    public void handleError(HttpCommand command, HttpResponse response) {
        // it is important to always read fully and close streams
        byte[] data = closeClientButKeepContentStream(response);
        String message = data != null ? new String(data) : null;

        Exception exception = message != null ? new HttpResponseException(command, response, message)
                : new HttpResponseException(command, response);
        message = message != null ? message : String.format("%s -> %s", command.getCurrentRequest().getRequestLine(),
                response.getStatusLine());
        switch (response.getStatusCode()) {
            case 401:
            case 403:
                exception = new AuthorizationException(message, exception);
                break;
            case 404:
                exception = new ResourceNotFoundException(message, exception);
                break;
            case 409:
                exception = new ResourceAlreadyExistsException(message, exception);
                break;
            default:
                exception = new IllegalStateException(message, exception);
        }
        command.setException(exception);
    }
}