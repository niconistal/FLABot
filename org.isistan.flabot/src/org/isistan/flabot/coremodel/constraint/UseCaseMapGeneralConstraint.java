/**
 * $Id: UseCaseMapGeneralConstraint.java,v 1.6 2006/03/29 01:53:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in a map if has a Name and if 
 * all Component Roles have a Role and a Name
 * @author $Author: franco $
 *
 */
public class UseCaseMapGeneralConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "UseCaseMap_UseCaseMapGeneral"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		
		UseCaseMap map = (UseCaseMap) model;		
		if (diagnostics != null) {
			
			if (map.getName().length() <= 0)
				diagnostics.add
					(new BasicDiagnostic
							(Diagnostic.WARNING,
							"org.isistan.flabot.coremodel", //$NON-NLS-1$
							0,
							Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.mapMustHaveName"), //$NON-NLS-1$
							new Object[] { map }));
				fault = true;
			}
			
			List roles = map.getComponentRoles();
			for (Iterator iterRoles = roles.iterator(); iterRoles.hasNext();) {
				ComponentRole role = (ComponentRole) iterRoles.next();								
				String roleName = Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.noRole"); //$NON-NLS-1$
				if (role.getName().length() > 0)
					roleName = role.getName();
				
				String componentName = Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.noComponentName"); //$NON-NLS-1$
				if (role.getComponent() == null) {					
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
								 "org.isistan.flabot.coremodel", //$NON-NLS-1$
					             0,
					             Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.ucmComponentMustHaveName", roleName, map.getName()), //$NON-NLS-1$
					             new Object[] { role }));
					
					fault = true;
				} else
					componentName = role.getComponent().getName();
				
				if (role.getName().length() <= 0) {
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.WARNING,
								 "org.isistan.flabot.coremodel", //$NON-NLS-1$
								 0,
					             Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.ucmComponentMustHaveRole", componentName, map.getName()), //$NON-NLS-1$
								 new Object[] { role }));
					fault = true;
				}

		}
		return fault;
	}
}
