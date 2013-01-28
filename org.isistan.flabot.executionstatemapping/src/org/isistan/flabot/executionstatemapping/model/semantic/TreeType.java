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
 * A representation of the literals of the enumeration '<em><b>Tree Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getTreeType()
 * @model
 * @generated
 */
public enum TreeType implements Enumerator
{
	/**
	 * The '<em><b>CONTAINER TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINER_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINER_TYPE(0, "CONTAINER_TYPE", "CONTAINER_TYPE"), /**
	 * The '<em><b>PROJECT TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROJECT_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	PROJECT_TYPE(1, "PROJECT_TYPE", "PROJECT_TYPE"),

	/**
	 * The '<em><b>PACKAGE ROOT TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_ROOT_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	PACKAGE_ROOT_TYPE(2, "PACKAGE_ROOT_TYPE", "PACKAGE_ROOT_TYPE"),

	/**
	 * The '<em><b>PACKAGE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	PACKAGE_TYPE(3, "PACKAGE_TYPE", "PACKAGE_TYPE"),

	/**
	 * The '<em><b>CLASS TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASS_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_TYPE(4, "CLASS_TYPE", "CLASS_TYPE"), /**
	 * The '<em><b>EXECUTION CONDITION TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTION_CONDITION_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTION_CONDITION_TYPE(5, "EXECUTION_CONDITION_TYPE", "EXECUTION_CONDITION_TYPE"), /**
	 * The '<em><b>STATE DIAGRAM TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_DIAGRAM_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	STATE_DIAGRAM_TYPE(6, "STATE_DIAGRAM_TYPE", "STATE_DIAGRAM_TYPE"), /**
	 * The '<em><b>FOLDER STATE DIAGRAM TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDER_STATE_DIAGRAM_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDER_STATE_DIAGRAM_TYPE(7, "FOLDER_STATE_DIAGRAM_TYPE", "FOLDER_STATE_DIAGRAM_TYPE"), /**
	 * The '<em><b>FOLDER GENERAL EXECUTION CONDITION TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDER_GENERAL_EXECUTION_CONDITION_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDER_GENERAL_EXECUTION_CONDITION_TYPE(8, "FOLDER_GENERAL_EXECUTION_CONDITION_TYPE", "FOLDER_GENERAL_EXECUTION_CONDITION_TYPE");

	/**
	 * The '<em><b>CONTAINER TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTAINER TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINER_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINER_TYPE_VALUE = 0;

	/**
	 * The '<em><b>PROJECT TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROJECT TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROJECT_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROJECT_TYPE_VALUE = 1;

	/**
	 * The '<em><b>PACKAGE ROOT TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PACKAGE ROOT TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_ROOT_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_ROOT_TYPE_VALUE = 2;

	/**
	 * The '<em><b>PACKAGE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PACKAGE TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PACKAGE_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PACKAGE_TYPE_VALUE = 3;

	/**
	 * The '<em><b>CLASS TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASS TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASS_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_TYPE_VALUE = 4;

	/**
	 * The '<em><b>EXECUTION CONDITION TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXECUTION CONDITION TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXECUTION_CONDITION_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION_CONDITION_TYPE_VALUE = 5;

	/**
	 * The '<em><b>STATE DIAGRAM TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STATE DIAGRAM TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATE_DIAGRAM_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STATE_DIAGRAM_TYPE_VALUE = 6;

	/**
	 * The '<em><b>FOLDER STATE DIAGRAM TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDER STATE DIAGRAM TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDER_STATE_DIAGRAM_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDER_STATE_DIAGRAM_TYPE_VALUE = 7;

	/**
	 * The '<em><b>FOLDER GENERAL EXECUTION CONDITION TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOLDER GENERAL EXECUTION CONDITION TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDER_GENERAL_EXECUTION_CONDITION_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FOLDER_GENERAL_EXECUTION_CONDITION_TYPE_VALUE = 8;

	/**
	 * An array of all the '<em><b>Tree Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TreeType[] VALUES_ARRAY =
		new TreeType[] {
			CONTAINER_TYPE,
			PROJECT_TYPE,
			PACKAGE_ROOT_TYPE,
			PACKAGE_TYPE,
			CLASS_TYPE,
			EXECUTION_CONDITION_TYPE,
			STATE_DIAGRAM_TYPE,
			FOLDER_STATE_DIAGRAM_TYPE,
			FOLDER_GENERAL_EXECUTION_CONDITION_TYPE,
		};

	/**
	 * A public read-only list of all the '<em><b>Tree Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TreeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tree Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreeType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TreeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tree Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreeType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TreeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tree Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreeType get(int value)
	{
		switch (value) {
			case CONTAINER_TYPE_VALUE: return CONTAINER_TYPE;
			case PROJECT_TYPE_VALUE: return PROJECT_TYPE;
			case PACKAGE_ROOT_TYPE_VALUE: return PACKAGE_ROOT_TYPE;
			case PACKAGE_TYPE_VALUE: return PACKAGE_TYPE;
			case CLASS_TYPE_VALUE: return CLASS_TYPE;
			case EXECUTION_CONDITION_TYPE_VALUE: return EXECUTION_CONDITION_TYPE;
			case STATE_DIAGRAM_TYPE_VALUE: return STATE_DIAGRAM_TYPE;
			case FOLDER_STATE_DIAGRAM_TYPE_VALUE: return FOLDER_STATE_DIAGRAM_TYPE;
			case FOLDER_GENERAL_EXECUTION_CONDITION_TYPE_VALUE: return FOLDER_GENERAL_EXECUTION_CONDITION_TYPE;
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
	private TreeType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //TreeType
