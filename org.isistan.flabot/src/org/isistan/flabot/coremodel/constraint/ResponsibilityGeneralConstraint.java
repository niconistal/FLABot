/**
 * $Id: ResponsibilityGeneralConstraint.java,v 1.4 2006/03/29 01:53:05 franco Exp $
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
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in the Core Model if 
 * all Responsibilities have unique ID and a valid Name
 * @author $Author: franco $
 *
 */
public class ResponsibilityGeneralConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "Responsibility_ResponsibilityGeneral"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		
		HashMap hash = new HashMap();
		CoreModel core = (CoreModel) model;		
		if (diagnostics != null) {
			List responsibilities = core.getResponsibilities();
			for (Iterator iter=responsibilities.iterator(); iter.hasNext();) {
				Responsibility r = (Responsibility) iter.next();
				String id = r.getID();
				if (hash.get(id) != null) {
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
								"org.isistan.flabot.coremodel", //$NON-NLS-1$
								0,
								Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.responsibilityHasDuplicateName", id, r.getName()), //$NON-NLS-1$
								new Object[] { r }));
					fault = true;
				}
				
				if (r.getName().length() <= 0) {
					diagnostics.add
						(new BasicDiagnostic
							(Diagnostic.WARNING,
							"org.isistan.flabot.coremodel", //$NON-NLS-1$
							0,
							Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.responsibilityMustHaveName", id), //$NON-NLS-1$
							new Object[] { r }));
					fault = true;
				}
				hash.put(id, r);
			}
		}
		return fault;
	}
}