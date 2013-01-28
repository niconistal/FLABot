/**
 * $Id: InsertResponsibilityCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.ResponsibilityNodeFigure;
import org.isistan.flabot.messages.Messages;

/**
 * Command that inserts a responsibility node in a path
 * 
 * InsertResponsibilityCommand
 * -	Extends InsertPathNodeCommand.
 * -	Inserts a responsibility node into an existing path.
 * 
 * @author $Author: franco $
 *
 */
public class InsertResponsibilityCommand extends InsertPathNodeCommand {
	
	/**
	 * Create an instance of this command that will insert a responsibility
	 * on the selected visual node
	 * @param visualNode
	 */
	public InsertResponsibilityCommand(NodeVisualModel visualNode,
			ResponsibilityNode responsibilityNode) {		
		super(visualNode, responsibilityNode, ResponsibilityNodeFigure.defaultsize);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertResponsibilityCommand.label")); //$NON-NLS-1$
	}
}