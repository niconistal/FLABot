/**
 * $Id: StubMustHaveFamilyConstraint.java,v 1.1 2006/03/31 02:20:31 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in Core Model if 
 * components have different names
 * @author $Author: apersson $
 *
 */
public class StubMustHaveFamilyConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "FlabotFileModel_StubMustHaveFamily"; //$NON-NLS-1$

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		boolean fault = false;
		StubNode stub = (StubNode) model;
		if (stub.getReferencedMap().getLevelInfo().equals(UseCaseMap.architecturalLevel) && stub.getFamily()==null){
			diagnostics.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
					"org.isistan.flabot.coremodel", //$NON-NLS-1$
					0,
					Messages.getString("org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint.stubMustHaveFamily",stub.getName(),stub.getReferencedMap().getName()), //$NON-NLS-1$
					new Object[] { stub }));
			fault = true;
		}
		return fault;
	}
}