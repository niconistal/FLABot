/**
 * $Id: InsertComponentRoleCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Header: /var/cvsroot/org.isistan.flabot/src/org/isistan/flabot/edit/ucmeditor/commands/visual/InsertComponentRoleCommand.java,v 1.3 2006/03/21 01:51:55 franco Exp $ 
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * A command that will add a component to the use case map diagram
 *
 * @author $Author: franco $
 */
public class InsertComponentRoleCommand extends Command {

	protected NodeVisualModel visual;
	protected ComponentRole componentRole;
	protected Rectangle bounds;
	protected UCMDiagram diagram;
	
	/**
	 * Create a new command that will add a component to a use case map diagram
	 * @param model the visual model of the component
	 * @param diagram the diagram which the component will be added to
	 * @param bounds the requested 
	 */
	public InsertComponentRoleCommand(NodeVisualModel model, UCMDiagram diagram,
			Rectangle bounds) {
		this.visual = model;
		this.diagram = diagram;
		this.bounds = bounds;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertComponentRoleCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Can execute if all the necessary information has been provided. 
	 */
	public boolean canExecute() {
		return (visual != null && diagram != null && bounds != null);
	}
	
	public ComponentRole getRole()  {
		ComponentRole componentRole = null;
		if (visual != null)
			componentRole = (ComponentRole) visual.getSemanticModel();
		return componentRole;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canUndo() {
		return (visual.getDiagram() != null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		componentRole = (ComponentRole)visual.getSemanticModel();
		if (componentRole == null)
			componentRole = CoremodelFactory.eINSTANCE.createComponentRole();		
		
		visual.setSemanticModel(componentRole);		
		updateBounds();		
		redo();
	}

	protected void updateBounds() {
		visual.setLocation(Util.getPoint(bounds.getLocation()));
		Dimension size = visual.getSize();
		if (size != null && size.getWidth() > 0 && size.getHeight() > 0)
			visual.setSize(size.clone());
		else
			visual.setSize(Util.getDimension(ComponentFigure.defaultsize));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		diagram.getMap().getComponentRoles().add(componentRole);
		visual.setSemanticModel(componentRole);		
		componentRole.setMap(diagram.getMap());
		//Added to position 0 so it can be behind all visual nodes.
		//Nodes under the component can be selected easily			
		diagram.getChildren().add(0, visual);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		diagram.getChildren().remove(visual);
		componentRole.setMap(null);
		diagram.getMap().getComponentRoles().remove(componentRole);
	}
}