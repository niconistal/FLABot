package org.isistan.flabot.mapping.builder;

import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.mapping.mappingmodel.Mapping;

public interface MappingBuilder {
	
	Mapping buildMapping(JObject[] elements);
}
