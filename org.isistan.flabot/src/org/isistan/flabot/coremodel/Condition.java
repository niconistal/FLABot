/**
 * $Id: Condition.java,v 1.10 2006/04/12 02:24:57 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.coremodel;

/**
 * Represents a condition to be used in responsibilities' pre and
 * postconditions
 * @author $Author: apersson $
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ConditionMappingHasCorrectFamily'"
 * @model
 */
public interface Condition extends NamedElementModel, InterfacePrologCode{
		
	//the default dependency
	public static final String previous = "previous";  //$NON-NLS-1$
	
	public static final String preconditionCondition = "precondition";  //$NON-NLS-1$
	public static final String constraintCondition = "constraint";  //$NON-NLS-1$
	public static final String mappingCondition = "mapping";  //$NON-NLS-1$
	public static final String previousEvent = "previousEvent";  //$NON-NLS-1$
	
	/**
	 * The value of the condition
	 * @model default=""
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * The responsibility of the condition
	 * @model
	 */
	ResponsibilityNode getSourceResponsibility();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getSourceResponsibility <em>Source Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Responsibility</em>' reference.
	 * @see #getSourceResponsibility()
	 * @generated
	 */
	void setSourceResponsibility(ResponsibilityNode value);

	/**
	 * The Scenario of the condition
	 * @model
	 */
	UseCaseMap getUseCaseMap();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getUseCaseMap <em>Use Case Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case Map</em>' reference.
	 * @see #getUseCaseMap()
	 * @generated
	 */
	void setUseCaseMap(UseCaseMap value);

	/**
	 * The event of the condition
	 * @model
	 */
	ConditionEvent getEvent();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(ConditionEvent value);

	/**
	 * The Family of the condition
	 * @model
	 */
	Family getFamily();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getFamily <em>Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family</em>' reference.
	 * @see #getFamily()
	 * @generated
	 */
	void setFamily(Family value);

	/**
	 * @model default="precondition"
	 */
	String getType();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * @model 
	 */
	ResponsibilityNode getDependencyResponsibility();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.Condition#getDependencyResponsibility <em>Dependency Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency Responsibility</em>' reference.
	 * @see #getDependencyResponsibility()
	 * @generated
	 */
	void setDependencyResponsibility(ResponsibilityNode value);

}
