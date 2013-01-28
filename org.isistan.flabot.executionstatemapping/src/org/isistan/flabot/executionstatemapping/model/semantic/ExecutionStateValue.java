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
import org.isistan.flabot.executionstatemapping.messages.Messages;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Execution State Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getExecutionStateValue()
 * @model
 * @generated
 */
public enum ExecutionStateValue implements Enumerator {
	/**
	 * The '<em><b>Faulty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_VALUE
	 * @generated
	 * @ordered
	 */
	FAULTY(0, "Faulty", "Faulty"),

	/**
	 * The '<em><b>Executed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTED_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTED(1, "Executed", "Executed"),

	/**
	 * The '<em><b>Not Executed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EXECUTED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EXECUTED(2, "NotExecuted", "NotExecuted"), /**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(4, "NONE", "NONE");

	/**
	 * The '<em><b>Faulty</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Faulty</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAULTY
	 * @model name="Faulty"
	 * @generated
	 * @ordered
	 */
	public static final int FAULTY_VALUE = 0;

	/**
	 * The '<em><b>Executed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Executed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXECUTED
	 * @model name="Executed"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTED_VALUE = 1;

	/**
	 * The '<em><b>Not Executed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Executed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EXECUTED
	 * @model name="NotExecuted"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EXECUTED_VALUE = 2;

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Execution State Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExecutionStateValue[] VALUES_ARRAY =
		new ExecutionStateValue[] {
			FAULTY,
			EXECUTED,
			NOT_EXECUTED,
			NONE,
		};

	/**
	 * A public read-only list of all the '<em><b>Execution State Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ExecutionStateValue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Execution State Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionStateValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionStateValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution State Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionStateValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionStateValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution State Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionStateValue get(int value) {
		switch (value) {
			case FAULTY_VALUE: return FAULTY;
			case EXECUTED_VALUE: return EXECUTED;
			case NOT_EXECUTED_VALUE: return NOT_EXECUTED;
			case NONE_VALUE: return NONE;
		}
		return null;
	}

	public static ExecutionStateValue[] getExecutionValues()
	{	
		return new ExecutionStateValue[] {
		FAULTY,
		EXECUTED,
		NOT_EXECUTED
		};
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
	private ExecutionStateValue(int value, String name, String literal) {
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
	
	public String getInternacionalizedName()
	{
		switch(this.value)
		{
			case ExecutionStateValue.EXECUTED_VALUE:
				return Messages.getString("org.isistan.flabot.executionmapping.model.semantic.ExecutionStateValue.executed"); //$NON-NLS-1$
			case ExecutionStateValue.NOT_EXECUTED_VALUE:
				return Messages.getString("org.isistan.flabot.executionmapping.model.semantic.ExecutionStateValue.notExecuted"); //$NON-NLS-1$
			case ExecutionStateValue.FAULTY_VALUE:
				return Messages.getString("org.isistan.flabot.executionmapping.model.semantic.ExecutionStateValue.faulty"); //$NON-NLS-1$
		}
		return ""; //$NON-NLS-1$
	}
	
} //ExecutionStateValue
