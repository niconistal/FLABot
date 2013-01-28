/**
 * $Id: ConditionEventGeneralConstraint.java,v 1.1 2006/04/11 23:31:51 franco Exp $
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
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * @author $Author: franco $
 *
 */
public class ConditionEventGeneralConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "ConnditionEvent_ConditionEventGeneral"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		
		HashMap hash = new HashMap();
		CoreModel core = (CoreModel) model;		
		if (diagnostics != null) {
			List events = core.getEvents();
			for (Iterator iter=events.iterator(); iter.hasNext();) {
				ConditionEvent ce = (ConditionEvent) iter.next();
				String name = ce.getName().toLowerCase();
				if (hash.get(name) != null) {
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
								"org.isistan.flabot.coremodel", //$NON-NLS-1$
								0,
								Messages.getString("org.isistan.flabot.coremodel.constraint.EventGeneralConstraint.conditionEventHasDuplicateName", ce.getName()), //$NON-NLS-1$
								new Object[] { ce }));
					fault = true;
				}
				hash.put(name, ce);
			}
		}
		return fault;
	}
}