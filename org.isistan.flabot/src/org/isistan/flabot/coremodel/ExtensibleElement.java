/**
 * $Id: ExtensibleElement.java,v 1.2 2006/03/21 02:57:52 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
* This interface should be implemented by all model elements whose information
* can be extended by plugin extensions.
* Implementors should use Use ExtensibleElementUtil class to put/get elements.
* @author da Costa Cambio
* @model
*/
public interface ExtensibleElement extends EObject {
	/**
	 * This delimiter should be used to conform the key when putting/getting
	 * elements in the additional data map
	 * e.g.:
	 * for the call:
	 * 	getObject("org.isistan.flabot.extensionxyz", "xzydata");
	 * the key conformed should be:
	 * 	"org.isistan.flabot.extvensionxyz|xzydata"
	 */
	public static final String DELIMITER="|"; //$NON-NLS-1$
	
	/**
	 * Get the extended data map. Plugins and extensions
	 * that must add its own information to flabot files should
	 * add it here as EObjects with a string key.
	 * @model keyType="String" valueType="EObject"
	 * @deprecated this method is deprecated, please use
	 * 	getExtendedData and putExtendedData instead
	 */
	@Deprecated
	EMap getExtendedData();
	
	/**
	 * Get an object from the extended data map
	 * @param pluginId the plugin id
	 * @param objectId the object id
	 * @return
	 */
	EObject getExtendedData(String pluginId, String objectId);
	
	/**
	 * Put an object in the extended data map
	 * @param pluginId
	 * @param objectId
	 * @param object
	 * @return the object that was previously in the given key
	 * (if any)
	 */
	EObject putExtendedData(String pluginId, String objectId, EObject object);
}
