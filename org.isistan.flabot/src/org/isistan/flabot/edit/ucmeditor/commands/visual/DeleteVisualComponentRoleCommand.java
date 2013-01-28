/**
 * $Id: DeleteVisualComponentRoleCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteVisualComponentRoleCommand extends CompoundCommand {
	
	private NodeVisualModel componentVisual;
	private Diagram visualDiagram;
	
	public DeleteVisualComponentRoleCommand(NodeVisualModel componentVisual)  {
		this.componentVisual = componentVisual;
		this.visualDiagram = componentVisual.getDiagram();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteVisualComponentRoleCommand.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (componentVisual != null && visualDiagram != null && componentVisual.getDiagram() != null);
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void execute() {
		Point componentLocation = Util.getDraw2DPoint(componentVisual.getLocation());
		List l = componentVisual.getChildren();
		for (int i=0; i<l.size(); i++) {
			NodeVisualModel nvm = (NodeVisualModel)l.get(i);
			org.isistan.flabot.edit.editormodel.Point location = Util.getPoint(componentLocation.x + nvm.getLocation().getX(), componentLocation.y + nvm.getLocation().getY());
			if (nvm.getSemanticModel() instanceof ResponsibilityNode)
				add(new ResponsibilityNodeReparentCommand(null, nvm, Util.getDraw2DRectangle(location, nvm.getSize())));
			else
				add(new PathNodeReparentCommand(null, nvm, Util.getDraw2DRectangle(location, nvm.getSize())));
		}
		super.execute();
		
		doDeleteComponent();
	}
		
	private void doDeleteComponent() {
		componentVisual.setDiagram(null);
	}
	
	private void undoDeleteComponent() {
		componentVisual.setDiagram(visualDiagram);
	}
	
	public void redo() {
		super.redo();
		doDeleteComponent();
	}
	
	public void undo() {
		undoDeleteComponent();
		super.undo();
	}
}