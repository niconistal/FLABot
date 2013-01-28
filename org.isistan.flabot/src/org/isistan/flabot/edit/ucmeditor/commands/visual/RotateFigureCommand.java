/**
 * $Id: RotateFigureCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class RotateFigureCommand extends Command {

	private NodeVisualModel node;
	private String newRotate;
	private String oldRotate;
	
	public RotateFigureCommand(NodeVisualModel node, String newRotate) {
		this.node  = node;
		this.newRotate = newRotate;
		this.setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.RotateFigureCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (node != null);
	}
	
	public void execute() {
		oldRotate = node.getRotation();
		redo();
	}
	
	public void redo() {
		node.setRotation(newRotate);
		node.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(node.getRotation())));
	}
	
	public void undo() {
		node.setRotation(oldRotate);
		node.setSize(Util.getDimension(ThreeConnectionFigure.getPreferedSize(node.getRotation())));
	}
}