/**
 * $Id: AddRoleComponentPasteCommand.java,v 1.9 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertComponentRoleCommand;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddRoleComponentPasteCommand extends InsertComponentRoleCommand implements RetargetParentPasteCommand{
	
	private HashMap connections = new HashMap();
	private NodeVisualModel copyVisualModel;	
	private boolean componentAddedToCore = false;
	
	public AddRoleComponentPasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds) {
		super(null, null, bounds);
		this.copyVisualModel = copyVisualModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddRoleComponentPasteCommand.label")); //$NON-NLS-1$
	}
	
	AddRoleComponentPasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds, UCMDiagram diagram) {
		this(copyVisualModel, bounds);
		this.diagram = diagram;
	}	
		
	public boolean canExecute() {
		return (copyVisualModel != null && bounds != null);
	}
	
	public VisualModel getNewVisualModel() {
		return visual;
	}
	
	public void setParent(Object parent) {
		this.diagram = (UCMDiagram)parent;
	}
	
	public boolean isValidParent(Object parent) {
		return (parent instanceof UCMDiagram);
	}
	
	public VisualModel getCopyVisualModel() {
		return copyVisualModel;
	}
	
	public void execute() {
		visual = EditormodelFactory.eINSTANCE.createNodeVisualModel(copyVisualModel);
		componentRole = CoremodelFactory.eINSTANCE.createComponentRole((ComponentRole)copyVisualModel.getSemanticModel());
		visual.setSemanticModel(componentRole);			
		
		
		updateBounds();
		redo();
	}
	
	public Command clone() {
		Rectangle newBounds = new Rectangle(bounds.x + 10, bounds.y + 10, bounds.width, bounds.height);
		AddRoleComponentPasteCommand clone = new AddRoleComponentPasteCommand(copyVisualModel, newBounds, diagram);
		updateConnectionsDependants(clone);
		return clone;
		
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command){
		connections.put(command, new Boolean(source));
	}
		
	private void updateConnectionsDependants(AddRoleComponentPasteCommand clone) {
		if (connections!= null) {
			for (Iterator iter = connections.keySet().iterator(); iter.hasNext(); ) {
				RetargetConnectionPasteCommand command = (RetargetConnectionPasteCommand)iter.next();
				boolean source = ((Boolean)connections.get(command)).booleanValue();								
				if (source)
					command.setCommandSource(clone);
				else
					command.setCommandTarget(clone);
			}
		}	
	}
	
	public List getDependantCommands() {
		return new ArrayList();
	}
	
	public void redo() {
		componentAddedToCore = false;
		ComponentModel component = ((ComponentRole)copyVisualModel.getSemanticModel()).getComponent();
		if (!diagram.getCoreModel().getComponents().contains(component)) {
			diagram.getCoreModel().getComponents().add(component);
			componentAddedToCore = true;
		}
		super.redo();
	}
	
	public void undo() {
		super.undo();
		if (componentAddedToCore) {
			ComponentModel component = ((ComponentRole)copyVisualModel.getSemanticModel()).getComponent();
			diagram.getCoreModel().getComponents().remove(component);
		}
	}
}