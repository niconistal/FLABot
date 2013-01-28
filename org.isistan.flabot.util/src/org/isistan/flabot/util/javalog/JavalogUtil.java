/**
 * 
 */
package org.isistan.flabot.util.javalog;

import java.util.List;

import JavaLog.PlClause;
import JavaLog.PlList;
import JavaLog.PlObject;

/**
 * Javalog utilities
 * @author mblech
 *
 */
public interface JavalogUtil {
	
	/**
	 * The singleton instance of JavalogUtil
	 */
	public static final JavalogUtil INSTANCE = new DefaultJavalogUtil();
	
	/**
	 * Fix the given PlObject argument
	 * @param plo the PlObject argument
	 * @return if it's a PlUVar, the contents, else the same given object
	 */
	PlObject fixArg(PlObject plo);

	/**
	 * Create a PlClause from the given PlObject
	 * @param object
	 * @return
	 */
	PlClause mkClause(PlObject object);
	
	/**
	 * Split the given prolog in individual per-clause strings
	 * @param prologCode
	 * @return
	 */
	List<String> splitClauses(String prologCode);
	
	/**
	 * Validate the given prolog code
	 * @param prologCode
	 * @return the diagnostic (null if code correct)
	 */
	String validatePrologCode(String prologCode);
	
	/**
	 * Escape the given prolog string's beginning and ending single quotes (')
	 * @param prologString the prolog string
	 * @return the prolog string without the beginning and ending single quotes
	 */
	String escapePrologString(String prologString);
	
	/**
	 * Create a PlList from the given List
	 * @param list the original list
	 * @return an instance of PlList representing in javalog the given List
	 */
	PlList createPlList(List list);
}
