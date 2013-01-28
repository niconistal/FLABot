package org.isistan.flabot.mapping;

import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.mapping.mappingmodel.Mapping;

/**
 * Useful class to operate with mapping.
 * @author usuario
 *
 */
public class MappingManager {
	/**
	 * Element id that is used to store elements in the extended data map
	 */
	public static final String MAPPING_ELEMENT_ID="mapping";
	
	/**
	 * Returns the mapping associated with the given mappeable element.
	 * @param responsibility
	 * @return
	 */
	public static Mapping getMapping(ExtensibleElement mappeableElement) {
		if(mappeableElement==null) {
			throw new IllegalArgumentException("mappeableElement cannot be null.");
		}
		Mapping mapping = (Mapping) mappeableElement.getExtendedData(MappingPlugin.SYMBOLIC_NAME, MAPPING_ELEMENT_ID);
		return mapping;
	}
	
	/**
	 * Sets the mapping associated with the given mappeable element.
	 * Returns the previous set mapping or null if not set.
	 * 
	 * @param responsibility
	 * @param mapping
	 * @return
	 */
	public static Mapping setMapping(ExtensibleElement mappeableElement, Mapping mapping) {
		if(mappeableElement==null) {
			throw new IllegalArgumentException("mappeableElement cannot be null.");
		}
		return (Mapping) mappeableElement.putExtendedData(MappingPlugin.SYMBOLIC_NAME, MAPPING_ELEMENT_ID, mapping);
	}
}
