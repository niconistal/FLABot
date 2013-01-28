/**
 * $Id: EObjectIdGenerator.java,v 1.2 2006/03/21 02:57:52 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Utility class that generates unique ids within the same containment tree
 * @author $Author: franco $
 *
 */
public class EObjectIdGenerator {

	/**
	 * Get a generated id for the given EObject 
	 * @param eObject
	 * @return
	 */
	public static String getGeneratedEMFID(EObject eObject) {
		StringBuffer idBuffer = new StringBuffer("\'"); //$NON-NLS-1$
		generateId(eObject, idBuffer);
		idBuffer.append('\'');
		return idBuffer.toString();
	}

	private static void generateId(EObject eObject, StringBuffer idBuffer) {
		EObject container = eObject.eContainer();
		if (container != null) {
			generateId(container, idBuffer);
			idBuffer.append('\\');
			generatePathElementId(eObject, idBuffer);
		}
		else {
			idBuffer.append('\\');
		}
	}

	private static void generatePathElementId(EObject object,
			StringBuffer idBuffer) {
		EStructuralFeature containingFeature = object.eContainingFeature();
		String containingFeatureName = containingFeature.getName();
		idBuffer.append('@');
		idBuffer.append(containingFeatureName);
		EObject container = object.eContainer();
		Object featureValue = container.eGet(containingFeature, true);
		if (featureValue instanceof List) {
			List list = (List) featureValue;
			idBuffer.append('.');
			idBuffer.append(list.indexOf(object));
		}
	}

}
