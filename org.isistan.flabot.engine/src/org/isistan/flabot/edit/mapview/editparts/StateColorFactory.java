/**
 * $Id: StateColorFactory.java,v 1.4 2006/03/28 21:59:48 apersson Exp $
 * $Author: apersson $
 */
package org.isistan.flabot.edit.mapview.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.isistan.flabot.engine.executionstate.ExecutionState;

/**
 * Contains the color that a responsibility nodes can have according to its state during the execution of the Engine
 * 
 * @author $Author: apersson $
 */
public class StateColorFactory {

	private static final Map<ExecutionState,Color> stateColorsMapping = new HashMap<ExecutionState,Color>();

	static {
		stateColorsMapping.put(ExecutionState.NO_ACTION_STATE_LITERAL, ColorConstants.black);
		stateColorsMapping.put(ExecutionState.FAULTY_LITERAL, ColorConstants.red);
		stateColorsMapping.put(ExecutionState.EXECUTED_LITERAL, ColorConstants.green);
		stateColorsMapping.put(ExecutionState.NOT_EXECUTED_LITERAL, ColorConstants.cyan);
		stateColorsMapping.put(ExecutionState.FAULTY_CURRENT_LITERAL, ColorConstants.white);
		stateColorsMapping.put(ExecutionState.FAULTY_PREVIOUS_LITERAL, ColorConstants.orange);
		stateColorsMapping.put(ExecutionState.FAULTY_NEXT_LEVELS_LITERAL, ColorConstants.yellow);
		stateColorsMapping.put(ExecutionState.FAULTY_PRECONDITION_LITERAL, ColorConstants.blue);
		stateColorsMapping.put(ExecutionState.FAULTY_CONSTRAIN_LITERAL, ColorConstants.gray);
		stateColorsMapping.put(ExecutionState.FAULTY_CONSTRAINT_START_LITERAL, ColorConstants.lightGray);
		stateColorsMapping.put(ExecutionState.MULTIPLE_ERRORS_LITERAL, ColorConstants.darkBlue);
	}

	/**
	 * Returns the color used to represent the current state of a responsibility
	 * 
	 * @param stateCode the code of teh state (specified in isistan.model.Component)
	 * @return color the color used to represent the current state
	 */
	public static Color getStateColor(ExecutionState stateCode){
		Color color = (Color)StateColorFactory.stateColorsMapping.get(stateCode); 
		if (color == null)
			color = ColorConstants.black;
		return color;
	}
}