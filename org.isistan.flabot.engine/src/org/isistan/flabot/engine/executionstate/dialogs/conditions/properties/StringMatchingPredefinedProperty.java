/**
 * $Id: StringMatchingPredefinedProperty.java,v 1.3 2006/04/11 03:19:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions.properties;

import org.isistan.flabot.engine.executionstate.dialogs.conditions.DefaultPredefinedCondition;

/**
 * @author usuario
 *
 */
public class StringMatchingPredefinedProperty extends DefaultPredefinedCondition {
	
	public static String FULL_MATCHING = "stringsEqual"; //$NON-NLS-1$
	
	public static String SUBSTRING_MATCHING = "stringContains"; //$NON-NLS-1$
	
	public static String REGEX_MATCHING = "regexMatch";	 //$NON-NLS-1$
	
	private String matchingStringType = FULL_MATCHING;
	
	private String fieldName = "(NOT-SET)"; //$NON-NLS-1$
	
	private String fieldValue = "(NOT-SET)"; //$NON-NLS-1$
	
	private boolean isNegative = false;
	
	public StringMatchingPredefinedProperty(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public void setMatchingStringType(String matchingStringType) {
		this.matchingStringType = matchingStringType;
	}
		
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public void setNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}
	
	public boolean isNegative() {
		return isNegative;
	}
	
	public String getFieldValue() {
		return fieldValue;
	}
	
	public String getMatchingStringType() {
		return matchingStringType;
	}
	
	public String getPrologCode() {		
		String predefined = matchingStringType + "(" + fieldName + ", '" + fieldValue + "')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (isNegative())
			predefined = "not(" + predefined  + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		return predefined;
	}
	
	public boolean acceptProperty(int property) {
		return false;
	}
	
	public String getFieldName() {
		return ""; //$NON-NLS-1$
	}
}