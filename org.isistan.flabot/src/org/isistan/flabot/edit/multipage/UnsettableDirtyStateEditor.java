/**
 * $Id: UnsettableDirtyStateEditor.java,v 1.1 2005/11/29 22:37:35 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.edit.multipage;

/**
 * All the editors in flabot must implement this interface so that
 * their dirty state can be unset when the file is saved in the multipage editor
 * @author $Author: mblech $
 *
 */
public interface UnsettableDirtyStateEditor {
	
	void unsetDirty(); 
}
