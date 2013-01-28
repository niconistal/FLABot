/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog;

import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.SimpleExecutionConditionConfiguration;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage#getPrologCodeFactory()
 * @model
 * @generated
 */
public interface PrologCodeFactory extends VisitorExpressionProlog {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getPrologCode(StateContainer stateContainer, TagProvider tagProvider);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getPrologCode(SimpleExecutionConditionConfiguration simpleExecutionConditionConfiguration, TagProvider tagProvider);

	
	String getPrologCode(ExecutionCondition executionCondition);
} // PrologCodeFactory
