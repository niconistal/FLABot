/** * $Id: RelationshipDirection.java,v 1.4 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import java.util.Arrays;import java.util.Collections;import java.util.List;import org.eclipse.emf.common.util.AbstractEnumerator;/**
 * @model
 */
public class RelationshipDirection extends AbstractEnumerator {
  /**
   * @model name="Unspecified"
   */
  public static final int UNSPECIFIED = 0;

  /**
   * @model name="Source"
   */
  public static final int SOURCE = 1;

  /**
   * @model name="Target"
   */
  public static final int TARGET = 2;

  /**
   * @model name="Bidirectional"
   */
  public static final int BIDIRECTIONAL = 3;
	/**	 * The '<em><b>Unspecified</b></em>' literal object.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @see #UNSPECIFIED	 * @generated	 * @ordered	 */
	public static final RelationshipDirection UNSPECIFIED_LITERAL = new RelationshipDirection(UNSPECIFIED, "Unspecified", "Unspecified");

	/**	 * The '<em><b>Source</b></em>' literal object.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @see #SOURCE	 * @generated	 * @ordered	 */
	public static final RelationshipDirection SOURCE_LITERAL = new RelationshipDirection(SOURCE, "Source", "Source");

	/**	 * The '<em><b>Target</b></em>' literal object.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @see #TARGET	 * @generated	 * @ordered	 */
	public static final RelationshipDirection TARGET_LITERAL = new RelationshipDirection(TARGET, "Target", "Target");

	/**	 * The '<em><b>Bidirectional</b></em>' literal object.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @see #BIDIRECTIONAL	 * @generated	 * @ordered	 */
	public static final RelationshipDirection BIDIRECTIONAL_LITERAL = new RelationshipDirection(BIDIRECTIONAL, "Bidirectional", "Bidirectional");

	/**	 * An array of all the '<em><b>Relationship Direction</b></em>' enumerators.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @generated	 */
	private static final RelationshipDirection[] VALUES_ARRAY =
		new RelationshipDirection[] {			UNSPECIFIED_LITERAL,			SOURCE_LITERAL,			TARGET_LITERAL,			BIDIRECTIONAL_LITERAL,		};

	/**	 * A public read-only list of all the '<em><b>Relationship Direction</b></em>' enumerators.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @generated	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**	 * Returns the '<em><b>Relationship Direction</b></em>' literal with the specified literal value.	 * <!-- begin-user-doc -->	 * <!-- end-user-doc -->	 * @generated	 */	public static RelationshipDirection get(String literal) {		for (int i = 0; i < VALUES_ARRAY.length; ++i) {			RelationshipDirection result = VALUES_ARRAY[i];			if (result.toString().equals(literal)) {				return result;			}		}		return null;	}	/**	 * Returns the '<em><b>Relationship Direction</b></em>' literal with the specified name.	 * <!-- begin-user-doc -->	 * <!-- end-user-doc -->	 * @generated	 */	public static RelationshipDirection getByName(String name) {		for (int i = 0; i < VALUES_ARRAY.length; ++i) {			RelationshipDirection result = VALUES_ARRAY[i];			if (result.getName().equals(name)) {				return result;			}		}		return null;	}	/**	 * Returns the '<em><b>Relationship Direction</b></em>' literal with the specified integer value.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @generated	 */
	public static RelationshipDirection get(int value) {		switch (value) {			case UNSPECIFIED: return UNSPECIFIED_LITERAL;			case SOURCE: return SOURCE_LITERAL;			case TARGET: return TARGET_LITERAL;			case BIDIRECTIONAL: return BIDIRECTIONAL_LITERAL;		}		return null;	}

	/**	 * Only this class can construct instances.	 * <!-- begin-user-doc -->	 * <!-- end-user-doc -->	 * @generated	 */	private RelationshipDirection(int value, String name, String literal) {		super(value, name, literal);	}

}