/**
 * $Id: InterfacesMustHaveSameNameConstraint.java,v 1.4 2006/03/27 22:46:29 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in an Interface Link if 
 * source and target Interfaces have the same Name
 * @author $Author: franco $
 *
 */
public class InterfacesMustHaveSameNameConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "InterfaceLink_InterfacesMustHaveSameName"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		InterfaceLink interfaceLink = (InterfaceLink) model;
		InterfaceModel source = interfaceLink.getSource();
		InterfaceModel target = interfaceLink.getTarget();
		
		if (source != null && target != null && !source.getName().equals(target.getName())) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.WARNING,
						 "org.isistan.flabot.coremodel", //$NON-NLS-1$
						 0,
						 Messages.getString("org.isistan.flabot.coremodel.constraint.InterfacesMustHaveSameNameConstraint.sourceAndTargetInterfacesMustHaveSameName", source.getName(), target.getName()), //$NON-NLS-1$
						 new Object[] { interfaceLink }));
			}
			return false;
		}
		return true;
	}
}