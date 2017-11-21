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

package org.jclouds.xillio.engine.options;

import org.jclouds.http.options.BaseHttpRequestOptions;
import org.jclouds.xillio.engine.domain.DomainResourceReferences;

import java.util.EnumSet;
import java.util.stream.Collectors;

public class EntityQueryOptions extends BaseHttpRequestOptions {
    public EntityQueryOptions scope(EnumSet<DomainResourceReferences.Scope> scopes) {
        this.queryParameters.put("scope", scopes.stream().map(v -> v.name().toLowerCase()).collect(Collectors.joining(",")));
        return this;
    }

    public EntityQueryOptions excludes(DomainResourceReferences.DecoratorNames... decoratorNames) {
        this.queryParameters.put("excludes", DomainResourceReferences.DecoratorNames.getProjections(decoratorNames));
        return this;
    }

    public EntityQueryOptions includes(DomainResourceReferences.DecoratorNames... decoratorNames) {
        this.queryParameters.put("includes", DomainResourceReferences.DecoratorNames.getProjections(decoratorNames));
        return this;
    }
}
