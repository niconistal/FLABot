/**
 * $Id: TagFilterContentProvider.java,v 1.1 2006/03/02 00:52:33 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog.swt;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagTreeModel.Wrapper;

/**
 * @author $Author: franco $
 *
 */
class TagFilterContentProvider implements ITreeContentProvider {

	/**
	 * Gets the children for a wrapper tag or property
	 * 
	 * @param arg0 the wrapper tag or property
	 * @return Object[]
	 */
	public Object[] getChildren(Object arg0) {
		//return children for the Wrapper.
		return ((Wrapper) arg0).getChildren();
	}

	/**
	 * 	Gets the parent team for a player
	 * 
	 * @param arg0 the wrapper
	 * @return Object
	 */
	public Object getParent(Object arg0) {
		return ((Wrapper) arg0).getParent();
	}

	/**
	 * Gets whether this wrapper has children
	 * 			
	 * @param arg0 the tag or property wrapper
	 * @return boolean
	 */
	public boolean hasChildren(Object arg0) {
	  return getChildren(arg0).length > 0;
  	}

  	/**
  	 * Gets the elements for the table
  	 * 
  	 * @param arg0 the Tag Tree Model
  	 * @return Object[]
  	 */
  	public Object[] getElements(Object arg0) {
	  // Returns all root tags in the model
	  return ((TagTreeModel) arg0).getChildren();
  	}

  	/**
  	 * Disposes any resources
  	 */
  	public void dispose() {
	  // We don't create any resources, so we don't dispose any
  	}

  	/**
  	 * Called when the input changes
  	 * 
  	 * @param arg0 the parent viewer
  	 * @param arg1 the old input
  	 * @param arg2 the new input
  	 */
  	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
  		// Nothing to do
  	}
}