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
 * A representation of the literals of the enumeration '<em><b>Condition Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getConditionValue()
 * @model
 * @generated
 */
public enum ConditionValue implements Enumerator
{
	/**
	 * The '<em><b>EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL(0, "EQUAL", "EQUAL"), /**
	 * The '<em><b>NOT EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUAL(1, "NOT_EQUAL", "NOT_EQUAL"), /**
	 * The '<em><b>GREATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER(2, "GREATER", "GREATER"), /**
	 * The '<em><b>GREATER EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_EQUAL(3, "GREATER_EQUAL", "GREATER_EQUAL"), /**
	 * The '<em><b>LOWER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER(4, "LOWER", "LOWER"), /**
	 * The '<em><b>LOWER EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_EQUAL(5, "LOWER_EQUAL", "LOWER_EQUAL"), /**
	 * The '<em><b>IS NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	IS_NULL(6, "IS_NULL", "IS_NULL"), /**
	 * The '<em><b>NOT NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_NULL(7, "NOT_NULL", "NOT_NULL"), /**
	 * The '<em><b>CONTAINS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINS(8, "CONTAINS", "CONTAINS"), /**
	 * The '<em><b>NOT CONTAINS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_CONTAINS_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_CONTAINS(9, "NOT_CONTAINS", ""), /**
	 * The '<em><b>IS CLASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	IS_CLASS(10, "IS_CLASS", "CLASS_OF"), /**
	 * The '<em><b>NOT IS CLASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_IS_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_IS_CLASS(11, "NOT_IS_CLASS", "NOT_IS_CLASS");
	/**
	 * The '<em><b>EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE = 0;

	/**
	 * The '<em><b>NOT EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUAL_VALUE = 1;

	/**
	 * The '<em><b>GREATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_VALUE = 2;

	/**
	 * The '<em><b>GREATER EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_EQUAL_VALUE = 3;

	/**
	 * The '<em><b>LOWER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_VALUE = 4;

	/**
	 * The '<em><b>LOWER EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_EQUAL_VALUE = 5;

	/**
	 * The '<em><b>IS NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IS NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IS_NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IS_NULL_VALUE = 6;

	/**
	 * The '<em><b>NOT NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_NULL_VALUE = 7;

	/**
	 * The '<em><b>CONTAINS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTAINS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINS_VALUE = 8;

	/**
	 * The '<em><b>NOT CONTAINS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT CONTAINS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_CONTAINS
	 * @model literal=""
	 * @generated
	 * @ordered
	 */
	public static final int NOT_CONTAINS_VALUE = 9;

	/**
	 * The '<em><b>IS CLASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IS CLASS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IS_CLASS
	 * @model literal="CLASS_OF"
	 * @generated
	 * @ordered
	 */
	public static final int IS_CLASS_VALUE = 10;

	/**
	 * The '<em><b>NOT IS CLASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT IS CLASS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_IS_CLASS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_IS_CLASS_VALUE = 11;

	/**
	 * An array of all the '<em><b>Condition Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConditionValue[] VALUES_ARRAY =
		new ConditionValue[] {
			EQUAL,
			NOT_EQUAL,
			GREATER,
			GREATER_EQUAL,
			LOWER,
			LOWER_EQUAL,
			IS_NULL,
			NOT_NULL,
			CONTAINS,
			NOT_CONTAINS,
			IS_CLASS,
			NOT_IS_CLASS,
		};

	/**
	 * A public read-only list of all the '<em><b>Condition Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConditionValue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Condition Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConditionValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Condition Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConditionValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Condition Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConditionValue get(int value) {
		switch (value) {
			case EQUAL_VALUE: return EQUAL;
			case NOT_EQUAL_VALUE: return NOT_EQUAL;
			case GREATER_VALUE: return GREATER;
			case GREATER_EQUAL_VALUE: return GREATER_EQUAL;
			case LOWER_VALUE: return LOWER;
			case LOWER_EQUAL_VALUE: return LOWER_EQUAL;
			case IS_NULL_VALUE: return IS_NULL;
			case NOT_NULL_VALUE: return NOT_NULL;
			case CONTAINS_VALUE: return CONTAINS;
			case NOT_CONTAINS_VALUE: return NOT_CONTAINS;
			case IS_CLASS_VALUE: return IS_CLASS;
			case NOT_IS_CLASS_VALUE: return NOT_IS_CLASS;
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
	private ConditionValue(int value, String name, String literal) {
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
}