/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>State Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getStateType()
 * @model
 * @generated
 */
public enum StateType implements Enumerator {
	/**
	 * The '<em><b>INITIAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIAL_VALUE
	 * @generated
	 * @ordered
	 */
	INITIAL(0, "INITIAL", "INITIAL"),

	/**
	 * The '<em><b>NORMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	NORMAL(1, "NORMAL", "NORMAL"),

	/**
	 * The '<em><b>FINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINAL_VALUE
	 * @generated
	 * @ordered
	 */
	FINAL(2, "FINAL", "FINAL");

	/**
	 * The '<em><b>INITIAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INITIAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INITIAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INITIAL_VALUE = 0;

	/**
	 * The '<em><b>NORMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NORMAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORMAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NORMAL_VALUE = 1;

	/**
	 * The '<em><b>FINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FINAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FINAL_VALUE = 2;

	/**
	 * An array of all the '<em><b>State Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final StateType[] VALUES_ARRAY =
		new StateType[] {
			INITIAL,
			NORMAL,
			FINAL,
		};

	/**
	 * A public read-only list of all the '<em><b>State Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<StateType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>State Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StateType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StateType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StateType get(int value) {
		switch (value) {
			case INITIAL_VALUE: return INITIAL;
			case NORMAL_VALUE: return NORMAL;
			case FINAL_VALUE: return FINAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private StateType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //StateType
