/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.functions.fs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Function Configuration.
 */
@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class FunctionConfig {
    // tenant that the function resides in
    private String tenant;
    // namespace that the function belongs to
    private String nameSpace;
    // function name
    private String name;
    // Function version
    private String version;
    // function class name
    private String className;
    // input serde class name
    private String inputSerdeClassName;
    // output serde class name
    private String outputSerdeClassName;
    // source topic
    private String sourceTopic;
    // sink topic
    private String sinkTopic;

    public static FunctionConfig load(String yamlFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(yamlFile), FunctionConfig.class);
    }
}