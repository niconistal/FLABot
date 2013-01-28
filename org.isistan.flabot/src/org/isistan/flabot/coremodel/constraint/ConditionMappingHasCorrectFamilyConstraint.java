/**
 * $Id: ConditionMappingHasCorrectFamilyConstraint.java,v 1.2 2006/04/13 01:41:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * @author $Author: franco $
 *
 */
public class ConditionMappingHasCorrectFamilyConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "Condition_MappingHasCorrectFamily"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;

		Condition condition = (Condition) model;
		
		
		if (diagnostics != null) {
			if (condition.getSourceResponsibility() == null) {
				diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
				    "org.isistan.flabot.coremodel", //$NON-NLS-1$
				    0,
				    Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.ConditionMappingHasCorrectFamilyConstraint.sourceResponsibilityNull", condition.getName()), //$NON-NLS-1$				    
				    new Object[] { condition }));
				return fault;
			}
			
			if (condition.getType().equals(Condition.mappingCondition)) {
				Family family = condition.getFamily();			
				if (family == null) {
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
								"org.isistan.flabot.coremodel", //$NON-NLS-1$
								0,
								Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.ConditionMappingHasCorrectFamilyConstraint.familyNull", condition.getName(), condition.getSourceResponsibility().getName(), condition.getSourceResponsibility().getMap()), //$NON-NLS-1$
								new Object[] { condition }));
					fault = true;
				} else {						
									
					if (!family.getAssociatedResponsibilities().contains(condition.getSourceResponsibility())) {
						diagnostics.add
						(new BasicDiagnostic
							(Diagnostic.ERROR,
						    "org.isistan.flabot.coremodel", //$NON-NLS-1$
						    0,
						    Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.ConditionMappingHasCorrectFamilyConstraint.familyNotContainsResponsibilityNode", family.getName(), condition.getSourceResponsibility().getName(), condition.getName(), condition.getSourceResponsibility().getName()), //$NON-NLS-1$
						    new Object[] { condition }));
							fault = true;
					}
										
					if (!hasMappedComponent(family, condition.getSourceResponsibility().getRole())) {
						diagnostics.add
							(new BasicDiagnostic
								(Diagnostic.ERROR,
							    "org.isistan.flabot.coremodel", //$NON-NLS-1$
							    0,
							    Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint.ConditionMappingHasCorrectFamilyConstraint.familyNotContainsRole", family.getName(), condition.getSourceResponsibility().getRole().getName(), condition.getName(), condition.getSourceResponsibility().getName()), //$NON-NLS-1$
							    new Object[] { condition }));
						fault = true;
					}
				}
			}
		}
		return fault;
	}
	
	private boolean hasMappedComponent(Family family, ComponentRole component) {
		for (Iterator iter=family.getFamilyElement().iterator(); iter.hasNext();) {
			FamilyElement familyElement = (FamilyElement) iter.next();
			if (familyElement.getFunctionalComponent() == component)
				return true;
		}		
		return false;
	}
}