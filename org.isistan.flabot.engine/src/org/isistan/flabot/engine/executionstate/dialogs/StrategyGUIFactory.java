/**
 * $Id: StrategyGUIFactory.java,v 1.6 2006/04/08 01:45:31 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.util.edition.EditionItemStatus;

/**
 * State determination strategies that need some kind of configuration
 * GUI must provide an implementation of this interface and register it
 * in StateDeterminationStrategyDialog.configGUIBuilderRegistry
 * @author $Author: franco $
 *
 */
public interface StrategyGUIFactory<T, V> {
	
	/**
	 * Create an instance of StateDeterminationStrategy
	 * @return
	 */
	V createStrategy(T element);
	
	/**
	 * Build the configuration GUI on the given SWT composite
	 * @param c
	 */
	public void build(Composite c, T element, V strategy, ChangeNotifier changeListener);
	
	/**
	 * Get the name of the strategy this factory builds
	 * @return
	 */
	String getStrategyName();
	
	/**
	 * Get the instance class of the elements this factory builds
	 * @return
	 */
	Class<? extends V> getReturnType();
	
	/**
	 * Get the status
	 * @return
	 */
	EditionItemStatus getStatus();
	
	/**
	 * Get the status
	 * @return
	 */
	void finishFactory();
	
	
	boolean isAssignable(V strategy);
	
	Command getCommand();

}