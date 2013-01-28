/**
 * 
 */
package org.isistan.flabot.engine.executionstate;

/**
 * This state determination strategy always returns the "StateFromMapping"
 * execution state so that the engine takes the execution state from the
 * mapped architectural responsibility.
 * @author mblech
 * @model
 *
 */
public interface StateFromMappingStateDeterminationStrategy extends
		StateDeterminationStrategy {

}
