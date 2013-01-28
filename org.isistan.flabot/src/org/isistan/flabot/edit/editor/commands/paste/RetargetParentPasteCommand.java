/**
 * $Id: RetargetParentPasteCommand.java,v 1.3 2005/12/09 21:48:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.VisualModel;


/**
 * @author $Author: franco $
 *
 */
public interface RetargetParentPasteCommand {
	
	public void setParent(Object parent);
	
	public boolean isValidParent(Object parent);
	
	public VisualModel getNewVisualModel();
	
	public VisualModel getCopyVisualModel();
	
	public Command clone();
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command);
	
	public List getDependantCommands();
}
