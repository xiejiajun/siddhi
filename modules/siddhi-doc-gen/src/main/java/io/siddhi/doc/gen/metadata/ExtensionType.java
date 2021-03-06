/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.siddhi.doc.gen.metadata;

import io.siddhi.core.executor.function.FunctionExecutor;
import io.siddhi.core.function.Script;
import io.siddhi.core.query.processor.stream.StreamProcessor;
import io.siddhi.core.query.processor.stream.function.StreamFunctionProcessor;
import io.siddhi.core.query.processor.stream.window.WindowProcessor;
import io.siddhi.core.query.selector.attribute.aggregator.AttributeAggregatorExecutor;
import io.siddhi.core.stream.input.source.Source;
import io.siddhi.core.stream.input.source.SourceMapper;
import io.siddhi.core.stream.output.sink.Sink;
import io.siddhi.core.stream.output.sink.SinkMapper;
import io.siddhi.core.table.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for holding extension types supported by the doc generator and the free marker templates
 * <p>
 * The enum values should be changed to match the names used in the documentation
 * The enum values will affect the names used in the documentation as well as the hyperlinks
 * <p>
 * These enum values will be passed onto the freemarker templates as a map
 * The other members of the enum class will not be accessible from the freemarker templates
 * These can be accesses using the EXTENSION_TYPE variable
 * eg:- EXTENSION_TYPE.FUNCTION
 */
public enum ExtensionType {
    FUNCTION("Function"),
    ATTRIBUTE_AGGREGATOR("Aggregate Function"),
    WINDOW("Window"),
    STREAM_FUNCTION("Stream Function"),
    STREAM_PROCESSOR("Stream Processor"),
    SOURCE("Source"),
    SINK("Sink"),
    SOURCE_MAPPER("Source Mapper"),
    SINK_MAPPER("Sink Mapper"),
    STORE("Store"),
    SCRIPT("Script");

    /**
     * The map from extension class type to super class
     */
    private static final Map<ExtensionType, Class<?>> superClassMap;

    static {
        // Populating the processor super class map
        superClassMap = new HashMap<>();
        superClassMap.put(ExtensionType.FUNCTION, FunctionExecutor.class);
        superClassMap.put(ExtensionType.ATTRIBUTE_AGGREGATOR, AttributeAggregatorExecutor.class);
        superClassMap.put(ExtensionType.WINDOW, WindowProcessor.class);
        superClassMap.put(ExtensionType.STREAM_FUNCTION, StreamFunctionProcessor.class);
        superClassMap.put(ExtensionType.STREAM_PROCESSOR, StreamProcessor.class);
        superClassMap.put(ExtensionType.SOURCE, Source.class);
        superClassMap.put(ExtensionType.SINK, Sink.class);
        superClassMap.put(ExtensionType.SOURCE_MAPPER, SourceMapper.class);
        superClassMap.put(ExtensionType.SINK_MAPPER, SinkMapper.class);
        superClassMap.put(ExtensionType.STORE, Table.class);
        superClassMap.put(ExtensionType.SCRIPT, Script.class);
    }

    /**
     * Contains the name to be displayed as the extension type
     */
    private final String value;

    ExtensionType(String value) {
        this.value = value;
    }

    public static Map<ExtensionType, Class<?>> getSuperClassMap() {
        return superClassMap;
    }

    public String getValue() {
        return value;
    }
}
