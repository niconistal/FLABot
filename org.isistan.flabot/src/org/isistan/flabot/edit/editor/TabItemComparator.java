/**
 * $Id: TabItemComparator.java,v 1.1 2006/03/06 22:16:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor;

import java.util.Comparator;

import org.isistan.flabot.util.extension.ConfigurationElementHandler;

/**
 * Compares two ConfigurationElementHandler with the value of an integer attribute value.
 * 
 * @author $Author: franco $
 *
 */
public class TabItemComparator implements Comparator<ConfigurationElementHandler> {
	
	private String attributeName; 
	
	/**
	 * Creates a new TabItemComparator with the integer attribute name to compare
	 * @param attributeName the name of the integer attribute to compare
	 */
	public TabItemComparator(String attributeName) {
		this.attributeName = attributeName;
	}
	
	/**
	 * Compares two <code>ConfigurationElementHandler</code> by its integer attribute.
	 * 
	 * @param o1 the first ConfigurationElementHandler to compare
	 * @param o2 the second ConfigurationElementHandler to compare
	 *  @return	the value <code>0</code> if this <code>Integer</code> is
     * 		equal to the argument <code>Integer</code>; a value less than
     * 		<code>0</code> if this <code>Integer</code> is numerically less
     * 		than the argument <code>Integer</code>; and a value greater 
     * 		than <code>0</code> if this <code>Integer</code> is numerically
     * 		 greater than the argument <code>Integer</code> (signed
     * 		 comparison).
	 */
	public int compare(ConfigurationElementHandler o1, ConfigurationElementHandler o2) {
		Integer number1 = getOrderNumber(o1);
		Integer number2 = getOrderNumber(o2);		
		return number1.compareTo(number2);
	}
	
	/**
	 * Returns the Integer value of the integer attribute of the ConfigurationElementHandler
	 * 
	 * @param configurationElementHandler the configuration element handler
	 * @return the Integer value
	 */
	private Integer getOrderNumber(ConfigurationElementHandler configurationElementHandler) {
		Integer order = configurationElementHandler.getInteger(attributeName);
		if (order == null)
			order = Integer.MAX_VALUE;
		return order;
	}
}