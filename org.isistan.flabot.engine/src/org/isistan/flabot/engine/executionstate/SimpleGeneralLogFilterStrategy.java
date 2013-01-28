/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.engine.executionstate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple General Log Filter Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy#getPrologCodeText <em>Prolog Code Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage#getSimpleGeneralLogFilterStrategy()
 * @model
 * @generated
 */
public interface SimpleGeneralLogFilterStrategy extends GeneralLogFilterStrategy{
	/**
	 * Returns the value of the '<em><b>Prolog Code Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prolog Code Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prolog Code Text</em>' attribute.
	 * @see #setPrologCodeText(String)
	 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage#getSimpleGeneralLogFilterStrategy_PrologCodeText()
	 * @model
	 * @generated
	 */
	String getPrologCodeText();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy#getPrologCodeText <em>Prolog Code Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prolog Code Text</em>' attribute.
	 * @see #getPrologCodeText()
	 * @generated
	 */
	void setPrologCodeText(String value);

} // SimpleGeneralLogFilterStrategy
