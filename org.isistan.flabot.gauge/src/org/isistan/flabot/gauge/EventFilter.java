/** * $Id: EventFilter.java,v 1.1 2006/03/24 03:35:03 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

/**
 * Filter for events to be installed as TraceBasedStateDeterminationStrategy needs
 */
public interface EventFilter{

	/**	 * Determines if a particular event is interesting	 * @param gauge	 * @return	 */	boolean passes(Event event);
}
