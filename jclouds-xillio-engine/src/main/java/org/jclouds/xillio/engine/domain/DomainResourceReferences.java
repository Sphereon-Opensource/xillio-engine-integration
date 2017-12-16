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

package org.jclouds.xillio.engine.domain;

import org.jclouds.xillio.engine.model.ContainerDecorator;
import org.jclouds.xillio.engine.model.CreatedDecorator;
import org.jclouds.xillio.engine.model.DescriptionDecorator;
import org.jclouds.xillio.engine.model.FileDecorator;
import org.jclouds.xillio.engine.model.FileSystemDecorator;
import org.jclouds.xillio.engine.model.HashDecorator;
import org.jclouds.xillio.engine.model.MimeTypeDecorator;
import org.jclouds.xillio.engine.model.ModifiedDecorator;
import org.jclouds.xillio.engine.model.NameDecorator;
import org.jclouds.xillio.engine.model.ParentDecorator;
import org.jclouds.xillio.engine.model.PreviewDecorator;
import org.jclouds.xillio.engine.model.PropertiesDecorator;
import org.jclouds.xillio.engine.model.VersionDecorator;

public class DomainResourceReferences {

    public enum Scope {ENTITY, CHILDREN}

    public enum DecoratorNames {
        CONTAINER(ContainerDecorator.class),
        CREATED(CreatedDecorator.class),
        DESCRIPTION(DescriptionDecorator.class),
        FILE(FileDecorator.class),
        FILESYSTEM(FileSystemDecorator.class),
        HASH(HashDecorator.class),
        MIMETYPE(MimeTypeDecorator.class),
        MODIFIED(ModifiedDecorator.class),
        NAME(NameDecorator.class),
        PARENT(ParentDecorator.class),
        PREVIEW(PreviewDecorator.class),
        PROPERTIES(PropertiesDecorator.class),
        VERSION(VersionDecorator.class);


        public Class<?> getDecoratorClass() {
            return decoratorClass;
        }

        public String queryParamValue() {
            return name().toLowerCase();
        }

        public static String getProjections(DecoratorNames... decoratorNames) {
            String projections = "";
            if (decoratorNames == null || decoratorNames.length == 0) {
                return projections;
            } else if (decoratorNames.length == 1) {
                return decoratorNames[0].queryParamValue();
            }
            for (DecoratorNames decoratorName : decoratorNames) {
                projections += decoratorName + ",";
            }
            return projections.substring(0, projections.length() - 1);

        }

        private final Class<?> decoratorClass;

        DecoratorNames(Class<?> decorator) {
            this.decoratorClass = decorator;
        }
    }
}
