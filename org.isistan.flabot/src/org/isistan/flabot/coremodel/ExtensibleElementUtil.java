/**
 * $Id: ExtensibleElementUtil.java,v 1.2 2006/04/03 21:01:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.messages.Messages;

/**
* This class is intended for ExtensibleElement interface implementors to use
* in order to ensure correct access to their additional data map.
* @author da Costa Cambio
*/
public class ExtensibleElementUtil {
	/**
	 * Conforms the key for the given pluginId and elementId
	 * using the ExtensibleElementDelimiter
	 * @param pluginId
	 * @return
	 */
	public static String conformKey(String pluginId, String elementId) {
		if(pluginId==null || pluginId.trim().length()==0) {
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.coremodel.ExtensibleElementUtil.pluginNullError")); //$NON-NLS-1$
		}
		if(elementId==null || elementId.trim().length()==0) {
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.coremodel.ExtensibleElementUtil.elementIDNullError")); //$NON-NLS-1$
		}
		return pluginId + ExtensibleElement.DELIMITER + elementId;
	}
	
	/**
	 * Get an object from the additional data map
	 * @param extensibleElement the ExtensibleElement where the element is contained
	 * @param pluginId the plugin id
	 * @param elementId the element id
	 * @return
	 */
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public static EObject getExtendedData(ExtensibleElement extensibleElement, String pluginId, String elementId) {
		return (EObject)extensibleElement.getExtendedData().get(
				conformKey(pluginId, elementId));
	}
	
	/**
	 * Put an object in the additional data map
	 * @param extensibleElement the ExtensibleElement where the element is contained
	 * @param pluginId the plugin id
	 * @param elementId the element id
	 * @param element the element to put in the map
	 * @return the element that was previously in the given key
	 * (if any)
	 */
	@SuppressWarnings("deprecation") //$NON-NLS-1$
	public static EObject putExtendedData(ExtensibleElement extensibleElement, String pluginId, String elementId, EObject element) {
		return (EObject)extensibleElement.getExtendedData().put(
				conformKey(pluginId, elementId), element);
	}
}
