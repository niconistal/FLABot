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
 * A representation of the literals of the enumeration '<em><b>Event Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getEventType()
 * @model
 * @generated
 */
public enum EventType implements Enumerator {
	/**
	 * The '<em><b>AND EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AND_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	AND_EVENT(0, "AND_EVENT", "AND_EVENT"),

	/**
	 * The '<em><b>OR EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OR_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	OR_EVENT(1, "OR_EVENT", "OR_EVENT"),

	/**
	 * The '<em><b>SINGLE EVENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SINGLE_EVENT_VALUE
	 * @generated
	 * @ordered
	 */
	SINGLE_EVENT(2, "SINGLE_EVENT", "SINGLE_EVENT");

	/**
	 * The '<em><b>AND EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND EVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AND_EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AND_EVENT_VALUE = 0;

	/**
	 * The '<em><b>OR EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR EVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OR_EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OR_EVENT_VALUE = 1;

	/**
	 * The '<em><b>SINGLE EVENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SINGLE EVENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SINGLE_EVENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SINGLE_EVENT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventType[] VALUES_ARRAY =
		new EventType[] {
			AND_EVENT,
			OR_EVENT,
			SINGLE_EVENT,
		};

	/**
	 * A public read-only list of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(int value) {
		switch (value) {
			case AND_EVENT_VALUE: return AND_EVENT;
			case OR_EVENT_VALUE: return OR_EVENT;
			case SINGLE_EVENT_VALUE: return SINGLE_EVENT;
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
	private EventType(int value, String name, String literal) {
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
	
} //EventType
