/*
 * This file is part of CycloneDX Core (Java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.cyclonedx.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import org.cyclonedx.util.ExtensibleTypesSerializer;

@JsonInclude(Include.NON_NULL)
public abstract class ExtensibleElement {

    private Map<String, String> extensions;

    private List<ExtensibleType> extensibleTypes;

    @JsonSerialize(using = ExtensibleTypesSerializer.class)
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<ExtensibleType> getExtensibleTypes() {
        return extensibleTypes;
    }

    public void setExtensibleTypes(List<ExtensibleType> extensibleTypes) {
        this.extensibleTypes = extensibleTypes;
    }

    public void addExtensibleType(ExtensibleType extensibleType) {
        if (this.extensibleTypes == null) {
            this.extensibleTypes = new ArrayList<>();
        }
        this.extensibleTypes.add(extensibleType);
    }

    @JsonAnyGetter
    public Map<String, String> getExtensions() {
        return extensions;
    }

    @JsonAnySetter
    public void setExtensions(final Map<String, String> extensions) {
        this.extensions = extensions;
    }
}
