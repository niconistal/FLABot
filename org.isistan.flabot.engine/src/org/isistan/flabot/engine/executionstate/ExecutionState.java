/**
 * $Id: ExecutionState.java,v 1.6 2006/03/31 00:29:42 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * Enumeration that represents the possible execution states for
 * a responsibility 
 * @author $Author: mblech $
 * @model
 */
public class ExecutionState extends AbstractEnumerator {

   /**
   * @model name="Executed"
   */
  public static final int EXECUTED = 0;

  /**
   * @model name="Faulty"
   */
  public static final int FAULTY = 1;

  /**
   * @model name="NotExecuted"
   */
  public static final int NOT_EXECUTED = 2;
  
  /**
   * @model name="NoActionState"
   */
  public static final int NO_ACTION_STATE = 3; 
	
	/**
	 * @model name="FaultyCurrent"
	 */
	public static final int FAULTY_CURRENT = 4;

	/**
	 * @model name="FaultyConstrain"
	 */
	public static final int FAULTY_CONSTRAIN = 5;

	/**
	 * @model name="FaultyPrevious"
	 */
	public static final int FAULTY_PREVIOUS = 6;

	/**
	 * @model name="FaultyPrecondition"
	 */
	public static final int FAULTY_PRECONDITION = 7;

	/**
	 * @model name="FaultyPath"
	 */
	public static final int FAULTY_PATH = 8;

	/**
	 * @model name="FaultyNextLevels"
	 */
	public static final int FAULTY_NEXT_LEVELS = 9;

	/**
	 * @model name="FaultyConstraintStart"
	 */
	public static final int FAULTY_CONSTRAINT_START = 10;

	/**
	 * @model name="ProbablyFaulty"
	 */
	public static final int PROBABLY_FAULTY = 11;

	/**
	 * @model name="Uncertain"
	 */
	public static final int UNCERTAIN = 12;
	
	/**
	 * @model name="MultipleErrors"
	 */
	public static final int MULTIPLE_ERRORS = 13;
	
	/**
	 * @model name="StateFromMapping"
	 */
	public static final int STATE_FROM_MAPPING = 14;

	/**
	 * The '<em><b>Executed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTED
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState EXECUTED_LITERAL = new ExecutionState(EXECUTED, "Executed");

	/**
	 * The '<em><b>Faulty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_LITERAL = new ExecutionState(FAULTY, "Faulty");

	/**
	 * The '<em><b>Not Executed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EXECUTED
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState NOT_EXECUTED_LITERAL = new ExecutionState(NOT_EXECUTED, "NotExecuted");

	/**
	 * The '<em><b>No Action State</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_ACTION_STATE
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState NO_ACTION_STATE_LITERAL = new ExecutionState(NO_ACTION_STATE, "NoActionState");

	/**
	 * The '<em><b>Faulty Current</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_CURRENT
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_CURRENT_LITERAL = new ExecutionState(FAULTY_CURRENT, "FaultyCurrent");

	/**
	 * The '<em><b>Faulty Constrain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_CONSTRAIN
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_CONSTRAIN_LITERAL = new ExecutionState(FAULTY_CONSTRAIN, "FaultyConstrain");

	/**
	 * The '<em><b>Faulty Previous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_PREVIOUS
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_PREVIOUS_LITERAL = new ExecutionState(FAULTY_PREVIOUS, "FaultyPrevious");

	/**
	 * The '<em><b>Faulty Precondition</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_PRECONDITION
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_PRECONDITION_LITERAL = new ExecutionState(FAULTY_PRECONDITION, "FaultyPrecondition");

	/**
	 * The '<em><b>Faulty Path</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_PATH
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_PATH_LITERAL = new ExecutionState(FAULTY_PATH, "FaultyPath");

	/**
	 * The '<em><b>Faulty Next Levels</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_NEXT_LEVELS
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_NEXT_LEVELS_LITERAL = new ExecutionState(FAULTY_NEXT_LEVELS, "FaultyNextLevels");

	/**
	 * The '<em><b>Faulty Constraint Start</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULTY_CONSTRAINT_START
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState FAULTY_CONSTRAINT_START_LITERAL = new ExecutionState(FAULTY_CONSTRAINT_START, "FaultyConstraintStart");

	/**
	 * The '<em><b>Probably Faulty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROBABLY_FAULTY
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState PROBABLY_FAULTY_LITERAL = new ExecutionState(PROBABLY_FAULTY, "ProbablyFaulty");

	/**
	 * The '<em><b>Uncertain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNCERTAIN
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState UNCERTAIN_LITERAL = new ExecutionState(UNCERTAIN, "Uncertain");
	
	/**
	 * The '<em><b>Multiple Errors</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTIPLE_ERRORS
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState MULTIPLE_ERRORS_LITERAL = new ExecutionState(MULTIPLE_ERRORS, "MultipleErrors");
	
	/**
	 * The '<em><b>State From Mapping</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATE_FROM_MAPPING
	 * @generated
	 * @ordered
	 */
	public static final ExecutionState STATE_FROM_MAPPING_LITERAL = new ExecutionState(STATE_FROM_MAPPING, "StateFromMapping");

	/**
	 * An array of all the '<em><b>Execution State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExecutionState[] VALUES_ARRAY =
		new ExecutionState[] {
			EXECUTED_LITERAL,
			FAULTY_LITERAL,
			NOT_EXECUTED_LITERAL,
			NO_ACTION_STATE_LITERAL,
			FAULTY_CURRENT_LITERAL,
			FAULTY_CONSTRAIN_LITERAL,
			FAULTY_PREVIOUS_LITERAL,
			FAULTY_PRECONDITION_LITERAL,
			FAULTY_PATH_LITERAL,
			FAULTY_NEXT_LEVELS_LITERAL,
			FAULTY_CONSTRAINT_START_LITERAL,
			PROBABLY_FAULTY_LITERAL,
			UNCERTAIN_LITERAL,
			MULTIPLE_ERRORS_LITERAL,
			STATE_FROM_MAPPING_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Execution State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Execution State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionState get(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionState result = VALUES_ARRAY[i];
			if (result.toString().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution State</b></em>' literal with the specified value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionState get(int value) {
		switch (value) {
			case EXECUTED: return EXECUTED_LITERAL;
			case FAULTY: return FAULTY_LITERAL;
			case NOT_EXECUTED: return NOT_EXECUTED_LITERAL;
			case NO_ACTION_STATE: return NO_ACTION_STATE_LITERAL;
			case FAULTY_CURRENT: return FAULTY_CURRENT_LITERAL;
			case FAULTY_CONSTRAIN: return FAULTY_CONSTRAIN_LITERAL;
			case FAULTY_PREVIOUS: return FAULTY_PREVIOUS_LITERAL;
			case FAULTY_PRECONDITION: return FAULTY_PRECONDITION_LITERAL;
			case FAULTY_PATH: return FAULTY_PATH_LITERAL;
			case FAULTY_NEXT_LEVELS: return FAULTY_NEXT_LEVELS_LITERAL;
			case FAULTY_CONSTRAINT_START: return FAULTY_CONSTRAINT_START_LITERAL;
			case PROBABLY_FAULTY: return PROBABLY_FAULTY_LITERAL;
			case UNCERTAIN: return UNCERTAIN_LITERAL;
			case MULTIPLE_ERRORS: return MULTIPLE_ERRORS_LITERAL;
			case STATE_FROM_MAPPING: return STATE_FROM_MAPPING_LITERAL;
		}
		return null;	
	}

	private ExecutionState(int value, String name) {
		super(value, name);
	}

}