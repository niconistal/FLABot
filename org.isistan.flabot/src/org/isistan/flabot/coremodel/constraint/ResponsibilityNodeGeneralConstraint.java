package org.isistan.flabot.coremodel.constraint;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

public class ResponsibilityNodeGeneralConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "ResponsibilityNode_General"; //$NON-NLS-1$

	private String rName = Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeGeneralConstraint.ResponsibilityNodeGeneralConstraint.noName"); //$NON-NLS-1$
	private String rMapName = Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeGeneralConstraint.ResponsibilityNodeGeneralConstraint.noMap"); //$NON-NLS-1$
	private String rRoleName = Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeGeneralConstraint.ResponsibilityNodeGeneralConstraint.noRole"); //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		
		ResponsibilityNode responsibilityNode = (ResponsibilityNode) model;		
		if (diagnostics != null) {			
			rName = responsibilityNode.getName();
			if (responsibilityNode.getMap() != null)
				rMapName = responsibilityNode.getMap().getName();
			if (responsibilityNode.getRole() != null)
				rRoleName = responsibilityNode.getRole().getName();
			
			fault |= checkHasRole(responsibilityNode, diagnostics);
			fault |= checkHasResponsibility(responsibilityNode, diagnostics);
			fault |= checkHasMap(responsibilityNode, diagnostics);
			fault |= checkHasValidResponsibilityAssigned(responsibilityNode, diagnostics);
			fault |= checkHasValidPreconditionsAssigned(responsibilityNode, diagnostics);
		}
		return fault;
	}
	
	private boolean checkHasValidPreconditionsAssigned(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics) {
		for (int i=0; i < responsibilityNode.getResponsibility().getPreconditions().size(); i++){
			Condition condition = (Condition) responsibilityNode.getResponsibility().getPreconditions().get(i);
			if (!condition.getType().equals(Condition.mappingCondition)&&!condition.getDependencyResponsibility().getMap().getLevelInfo().equals(responsibilityNode.getMap().getLevelInfo())){
				diagnostics.add
				(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "org.isistan.flabot.coremodel", //$NON-NLS-1$
						 0,
						 Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeConditionMapLevelInfoMustEqual", responsibilityNode.getMap().getName(), condition.getDependencyResponsibility().getMap().getName()), //$NON-NLS-1$
						 new Object[] { condition, responsibilityNode }));
				return true;
			}
			else if (condition.getType().equals(Condition.mappingCondition)&&!condition.getDependencyResponsibility().getMap().getLevelInfo().equals(UseCaseMap.architecturalLevel)){
				diagnostics.add
				(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "org.isistan.flabot.coremodel", //$NON-NLS-1$
						 0,
						 Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeConditionMapLevelInfo", condition.getDependencyResponsibility().getMap().getName()), //$NON-NLS-1$
						 new Object[] { condition, responsibilityNode }));
				return true;
			}
		}
		return false;
	}

	private boolean checkHasRole(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics) {
		boolean isFaulty = (responsibilityNode.getRole()== null);
		
		if (isFaulty) {
			diagnostics.add
				(new BasicDiagnostic
						(Diagnostic.ERROR,
						 "org.isistan.flabot.coremodel", //$NON-NLS-1$
						 0,
						 Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeMustHaveRole", rName, rMapName), //$NON-NLS-1$
						 new Object[] { responsibilityNode }));
		}
		return isFaulty;
	}
	
	private boolean checkHasResponsibility(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics) {
		boolean isFaulty = (responsibilityNode.getResponsibility() == null);
		
		if (isFaulty) {
			diagnostics.add
				(new BasicDiagnostic
						(Diagnostic.ERROR,
						"org.isistan.flabot.coremodel", //$NON-NLS-1$
						0,
						Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeMustHaveResponsibility", rName, rRoleName, rMapName), //$NON-NLS-1$
						new Object[] { responsibilityNode }));
		}
		return isFaulty;
	}
	
	private boolean checkHasMap(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics) {
		boolean isFaulty = (responsibilityNode.getMap()== null);
		
		if (isFaulty) {
			diagnostics.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
					 "org.isistan.flabot.coremodel", //$NON-NLS-1$
					 0,
					 Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeMustHaveMap", rName, rRoleName), //$NON-NLS-1$
					 new Object[] { responsibilityNode }));		
		}
		return isFaulty;
	}
	
	private boolean checkHasValidResponsibilityAssigned(ResponsibilityNode responsibilityNode, DiagnosticChain diagnostics) {
		ComponentRole role = responsibilityNode.getRole();
		ComponentModel component = null;
		if (role != null)
			component  = role.getComponent();
		Responsibility responsibility = responsibilityNode.getResponsibility();
		
		boolean isFaulty = (component != null && !component.getFeatures().contains(responsibility)); 
		if (isFaulty) {
			diagnostics.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
					 "org.isistan.flabot.coremodel", //$NON-NLS-1$
					 0,
					 Messages.getString("org.isistan.flabot.coremodel.constraint.ResponsibilityNodeHasRoleConstraint.responsibilityNodeMustHaveValidResponsibility", rName, rMapName, component.getName()), //$NON-NLS-1$
					 new Object[] { responsibilityNode }));
		}
		return isFaulty;
	}
}