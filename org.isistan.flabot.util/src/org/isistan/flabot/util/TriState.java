/** * $Id: TriState.java,v 1.1 2006/01/27 18:45:32 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util;

import org.isistan.flabot.util.enums.Enum;public class TriState extends Enum {
	public static final TriState FALSE=new TriState("FALSE");
	public static final TriState TRUE=new TriState("TRUE");
	public static final TriState UNDEFINED=new TriState("UNDEFINED");
	
	
	private TriState(String name) {
		super(name);
	}
	
	/**
	 * Returns the TriState corresponding to the given boolean
	 * @param state
	 * @return TRUE if state is true, FALSE if state is false
	 */
	public static TriState fromBoolean(boolean state) {
		if(state) {
			return TRUE;
		} else {
			return FALSE;
		}
	}
	
	/**
	 * Returns the boolean corresponding to the given TriState, or defaultState if TriState is UNDEFINED
	 * @param state
	 * @param defaultState
	 * @return true if state is TRUE or if state is UNDEFINED and defaultState is true, false otherwise.
	 */
	public static boolean toBoolean(TriState state, boolean defaultState) {
		if(state==TRUE) {
			return true;
		} else if(state==FALSE) {
			return false;
		} else {
			return defaultState;
		}
	}
	
	/**
	 * Returns the boolean corresponding to this TriState, or defaultState if this TriState is UNDEFINED
	 * @param defaultState
	 * @return true if this is TRUE or if this is UNDEFINED and defaultState is true, false otherwise.
	 */
	public boolean toBoolean(boolean defaultState) {
		return toBoolean(this, defaultState);
	}
	
	/**
	 * Returns the boolean corresponding to the given TriState, throws an IllegalArgumentException if TriState is UNDEFINED
	 * @param state
	 * @return true if state is TRUE, false if state is FALSE.
	 * @throws IllegalArgumentException if state is UNDEFINED
	 */
	public static boolean toBoolean(TriState state) {
		if(state==TRUE) {
			return true;
		} else if(state==FALSE) {
			return false;
		} else {
			throw new IllegalArgumentException("State was undefined.");
		}
	}
	
	/**
	 * Returns the boolean corresponding to this TriState, throws an IllegalArgumentException if this is UNDEFINED
	 * @return true if state is TRUE, false if state is FALSE.
	 * @throws IllegalArgumentException if this is UNDEFINED
	 */
	public boolean toBoolean() {
		return toBoolean(this);
	}

}
