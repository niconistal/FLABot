/** * $Id: FailureLocatedAction.java,v 1.3 2006/03/29 20:41:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.engine.failurelocatedaction;

import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.util.problems.MessageAccumulator;/** * An action to be taken when the cause of a failure is found. * Implementors must provide a default constructor for the * FailureLocatedActionLocator to be able to instantiate it. *  * @author $Author: dacostae $ * */
public interface FailureLocatedAction {	/**	 * Executes the action to be taken	 * @param responsibilityNode	 * @param messageAccumulator	 */
	 public void execute(ResponsibilityNode responsibilityNode, ComponentRole role, MessageAccumulator messageAccumulator); 
}
