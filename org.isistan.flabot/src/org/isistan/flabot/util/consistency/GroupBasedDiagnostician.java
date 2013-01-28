/**
 * $Id: GroupBasedDiagnostician.java,v 1.4 2006/03/21 02:57:52 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.util.consistency;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Utility class for specifying a group in the context to the default
 * EMF Diagnostician
 * @author $Author: franco $
 *
 */
public class GroupBasedDiagnostician {
	/**
	 * the singleton instance
	 */
	public static final GroupBasedDiagnostician INSTANCE =
		new GroupBasedDiagnostician();
	
	/**
	 * Validate the given EObject with the given groupKey in the context
	 * @param eObject
	 * @param groupKey
	 * @return
	 */
	public Diagnostic validate(EObject eObject, Object groupKey) {
		Map context = new HashMap();
	    context.put(EValidator.SubstitutionLabelProvider.class, Diagnostician.INSTANCE);
	    context.put(EValidator.class, Diagnostician.INSTANCE);
	    if (groupKey != null)
	    	context.put(GroupBasedConsistencyManagerImpl.CONTEXT_KEY_GROUP,
	    			groupKey);
	    BasicDiagnostic diagnostics = 
	      new BasicDiagnostic
	        (EObjectValidator.DIAGNOSTIC_SOURCE,
	         0,
	         EcorePlugin.INSTANCE.getString
	           ("_UI_DiagnosticRoot_diagnostic",  //$NON-NLS-1$
	            new Object [] { EcoreUtil.getIdentification(eObject) }),
	         new Object [] { eObject });
		Diagnostician.INSTANCE.validate(eObject, diagnostics, context);
		return diagnostics;
	}
}
