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

package org.jclouds.xillio.engine.blobstore.functions;

import com.google.common.base.Function;
import org.jclouds.blobstore.options.ListContainerOptions;
import org.jclouds.xillio.engine.domain.DomainResourceReferences;
import org.jclouds.xillio.engine.options.EntityQueryOptions;

import java.util.EnumSet;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListContainerOptionsToEntityQueryOptions implements Function<ListContainerOptions, EntityQueryOptions> {
    public EntityQueryOptions apply(ListContainerOptions from) {
        if (from.getDir() != null && (from.getPrefix() != null || from.getDelimiter() != null)) {
            throw new IllegalArgumentException("Cannot pass both directory and prefix/delimiter");
        }
        checkNotNull(from, "set options to instance NONE instead of passing null");

        EntityQueryOptions queryOptions = new EntityQueryOptions();
        queryOptions.scope(EnumSet.of(DomainResourceReferences.Scope.ENTITY
                , DomainResourceReferences.Scope.CHILDREN));

        // // TODO: 13-11-2017 ?
/*
        if (!from.isRecursive() && from.getDelimiter() == null) {
            queryOptions = queryOptions.delimiter("/");
        }
        if (from.getDelimiter() != null) {
            queryOptions = queryOptions.delimiter(from.getDelimiter());
        }
        if (from.getDir() != null) {
            String path = from.getDir();
            if (!path.endsWith("/"))
                path += "/";
            queryOptions = queryOptions.prefix(path);
        }
        if (from.getPrefix() != null) {
            queryOptions.prefix(from.getPrefix());
        }
        if (from.getMarker() != null) {
            queryOptions = queryOptions.pageToken(from.getMarker());
        }
        if (from.getMaxResults() != null) {
            queryOptions = queryOptions.maxResults(from.getMaxResults());
        }*/
        return queryOptions;
    }
}