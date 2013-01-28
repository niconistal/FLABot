/** * $Id: ResponsibilityNodeReparentCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.edit.editormodel.NodeVisualModel;public class ResponsibilityNodeReparentCommand extends PathNodeReparentCommand {
	private ResponsibilityNode responsibilityNode;
	
	public ResponsibilityNodeReparentCommand(NodeVisualModel newParent,
			NodeVisualModel visual, Rectangle bounds) {
		super(newParent, visual, bounds);
		this.responsibilityNode = (ResponsibilityNode)visual.getSemanticModel();		
	}
	
	public boolean canExecute() {
		if (!super.canExecute() || responsibilityNode == null)
			return false;
		if (newParent != null) {
			ComponentRole role = (ComponentRole) newParent.getSemanticModel();
			if (role.getComponent() == null)
				return false;
			return role.getComponent().getFeatures().contains(responsibilityNode.getResponsibility());
		}
		return true;
	}
	
	public void execute() {
		super.execute();
		redo();
	}
	
	public void redo() {
		super.redo();
		if (newParent == null)
			responsibilityNode.setRole(null);
		else
			responsibilityNode.setRole((ComponentRole) newParent.getSemanticModel());		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if (oldParent == null)
			responsibilityNode.setRole(null);
		else
			responsibilityNode.setRole((ComponentRole) oldParent.getSemanticModel());	
	}
}