/**
 * $Id: RetargetConnectionPasteCommand.java,v 1.3 2005/12/09 21:48:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

/**
 * @author $Author: franco $
 *
 */
public interface RetargetConnectionPasteCommand extends RetargetParentPasteCommand {
	
	public void setCommandSource(RetargetParentPasteCommand command);
	
	public void setCommandTarget(RetargetParentPasteCommand command);		
}
