/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Stub Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.DynamicStubNode#getConditionedStubs <em>Conditioned Stubs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.coremodel.CoremodelPackage#getDynamicStubNode()
 * @model
 * @generated
 */
public interface DynamicStubNode extends SimplePathNode {
	/**
	 * Returns the value of the '<em><b>Conditioned Stubs</b></em>' reference list.
	 * The list contents are of type {@link org.isistan.flabot.coremodel.ConditionedStub}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditioned Stubs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditioned Stubs</em>' reference list.
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getDynamicStubNode_ConditionedStubs()
	 * @model type="org.isistan.flabot.coremodel.ConditionedStub"
	 * @generated
	 */
	EList getConditionedStubs();

} // DynamicStubNode
