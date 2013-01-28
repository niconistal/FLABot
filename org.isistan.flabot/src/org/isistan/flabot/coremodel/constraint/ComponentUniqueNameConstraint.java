/**
 * $Id: ComponentUniqueNameConstraint.java,v 1.5 2006/03/29 01:53:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in Core Model if 
 * components have different names
 * @author $Author: franco $
 *
 */
public class ComponentUniqueNameConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "FlabotFileModel_ComponentUniqueName"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		
		FlabotFileModel ffm = (FlabotFileModel) model;		
		if (diagnostics != null) {			
			List components = ffm.getCoreModel().getComponents();
			List importedFiles = ffm.getAllImportedFiles();
			for (Iterator modelsIter = importedFiles.iterator(); modelsIter.hasNext();) {
				FlabotFileModel f = (FlabotFileModel) modelsIter.next();
				components.addAll(f.getCoreModel().getComponents());
			}		
			
			HashMap hash = new HashMap();
			for (Iterator componentIter = components.iterator(); componentIter.hasNext();) {
				ComponentModel c = (ComponentModel) componentIter.next();
				String componentName = c.getName().toLowerCase();
				if (hash.get(componentName) != null) {
					diagnostics.add
					(new BasicDiagnostic
							(Diagnostic.WARNING,
							"org.isistan.flabot.coremodel", //$NON-NLS-1$
							0,
							Messages.getString("org.isistan.flabot.coremodel.constraint.ComponentUniqueNameConstraint.componentHasDuplicatedName", c.getName()),  //$NON-NLS-1$
							new Object[] { c }));
					fault = true;
				}
				hash.put(componentName, c);
			}
		}
		return fault;
	}
}