/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prolog Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement#getPredicateName <em>Predicate Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage#getPrologElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PrologElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate Name</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage#getPrologElement_PredicateName()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	String getPredicateName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPredicateFunctor(String functor, String parameters);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resetPredicateName();

} // PrologElement
