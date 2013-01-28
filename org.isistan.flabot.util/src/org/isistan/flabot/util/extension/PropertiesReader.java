package org.isistan.flabot.util.extension;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;


/**
 * This is a utility class that reads a lists of properties
 * declared as &lt;property key="aKey" value="aValue"/&gt;
 * and puts them in a Map. 
 * @author da Costa Cambio
 *
 */
public class PropertiesReader {
	public static final String DEFAULT_PROPERTY_TAG="property";
	public static final String DEFAULT_PROPERTY_KEY_ATTRIBUTE="key";	
	public static final String DEFAULT_PROPERTY_VALUE_ATTRIBUTE="value";
	
	private String propertyTag=DEFAULT_PROPERTY_TAG;
	private String propertyKeyAttribute=DEFAULT_PROPERTY_TAG;	
	private String propertyValueAttribute=DEFAULT_PROPERTY_VALUE_ATTRIBUTE;
	
	private static PropertiesReader defaultPropertiesReader;
	public static PropertiesReader getDefault() {
		if(defaultPropertiesReader==null) {
			defaultPropertiesReader=new PropertiesReader();
		}
		return defaultPropertiesReader;
	}
	
	/**
	 * Creates a new PropertiesReader with standard property tab and attributes
	 * specification.
	 * getDefault() can be used.
	 *
	 */
	public PropertiesReader() {
	}
	/**
	 * Creates a new PropertiesReader with custom property tab specification.
	 * @param propertyTag
	 */
	public PropertiesReader(String propertyTag) {
		this.propertyTag=propertyTag;
	}

	/**
	 * Creates a new PropertiesReader with custom property tab and attributes
	 * specification.
	 * @param propertyTag
	 * @param propertyKeyAttribute
	 * @param propertyValueAttribute
	 */
	public PropertiesReader(String propertyTag, String propertyKeyAttribute, String propertyValueAttribute) {
		this.propertyTag=propertyTag;
		this.propertyKeyAttribute=propertyKeyAttribute;
		this.propertyValueAttribute=propertyValueAttribute;
	}

	/**
	 * Reads a lists of properties
	 * declared as &lt;property key="aKey" value="aValue"/&gt;
	 * and puts them in a Map.
	 *  - If the key is not present, the property is ignored.
	 *  - If the key is present but the value is not, the property is added with null value. 
	 * @param propertiesContainer The configuration element that contains the list of properties
	 * @return
	 */
	public Map<String, String> readProperties(IConfigurationElement propertiesContainer) {
		Map<String, String> map=new HashMap<String, String>();
		IConfigurationElement[] properties = propertiesContainer.getChildren(propertyTag);
		for (IConfigurationElement property : properties) {
			String key=property.getAttribute(propertyKeyAttribute);
			if(key!=null) {
				String value=property.getAttribute(propertyValueAttribute);
				map.put(key, value);
			}
		}
		return map;
	}
	
	/**
	 * Reads a lists of properties
	 * declared as &lt;property key="aKey" value="aValue"/&gt;
	 * and puts them in a Map.
	 *  - If the key is not present, the property is ignored.
	 *  - If the key is present but the value is not, the property is added with null value. 
	 * @param propertiesContainer The configuration element that contains the list of properties
	 * @return
	 */
	public Map<String, String> readProperties(ConfigurationElementHandler propertiesContainer) {
		return readProperties(propertiesContainer.getConfigurationElement());
	}
}
