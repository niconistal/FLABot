/**
 * $Id: AddComponentPasteCommand.java,v 1.7 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddComponentCommand;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddComponentPasteCommand extends AddComponentCommand implements RetargetParentPasteCommand{
	
	private HashMap connections = new HashMap();
	private NodeVisualModel copyVisualModel;	
	private CompoundCommand dependantCommands;

	public AddComponentPasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds, CompoundCommand dependantCommands) {
		super(null, null, bounds);
		this.copyVisualModel = copyVisualModel;
		this.dependantCommands = dependantCommands;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddComponentPasteCommand.label")); //$NON-NLS-1$
	}	
	
	AddComponentPasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds, CompoundCommand dependantsCommands, ComponentDiagram diagram) {
		this(copyVisualModel, bounds, dependantsCommands);
		this.diagram = diagram;
	}
	
	public boolean canExecute() {
		return (copyVisualModel != null && bounds != null);
	}
	
	public VisualModel getNewVisualModel() {
		return visualModel;
	}
	
	public VisualModel getCopyVisualModel() {
		return copyVisualModel;
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command) {
		connections.put(command, new Boolean(source));
	}
	
	public void setParent(Object object) {
		diagram = (ComponentDiagram) object;
	}
	
	public boolean isValidParent(Object object) {
		return (object instanceof ComponentDiagram);
	}
	
	private void updateDependantCommands(NodeVisualModel parentVisualModel) {
		if (dependantCommands!= null) {
			for (Iterator iter = dependantCommands.getCommands().iterator(); iter.hasNext(); ) {
				RetargetParentPasteCommand command = (RetargetParentPasteCommand)iter.next();
				command.setParent(parentVisualModel);				
			}
		}		
	}
	
	public void execute() {
		visualModel = EditormodelFactory.eINSTANCE.createNodeVisualModel(copyVisualModel);
		visualModel.setSemanticModel(CoremodelFactory.eINSTANCE.createComponentModel((ComponentModel)copyVisualModel.getSemanticModel()));		
		
		updateBounds();
		updateDependantCommands(visualModel);
		dependantCommands.execute();
		
		super.redo();
	}
	
	public Command clone() {
		Rectangle newBounds = new Rectangle(bounds.x + 10, bounds.y + 10, bounds.width, bounds.height);
		AddComponentPasteCommand clone = new AddComponentPasteCommand(copyVisualModel, newBounds, clone(dependantCommands), diagram);
		updateConnectionsDependants(clone);
		return clone;
	}

	private CompoundCommand clone(CompoundCommand commands) {
		CompoundCommand ret = new CompoundCommand();
		if (dependantCommands!= null) {
			for (Iterator iter = commands.getCommands().iterator(); iter.hasNext(); ) {
				RetargetParentPasteCommand command = (RetargetParentPasteCommand)iter.next();
				ret.add(command.clone());
			}
		}	
		return ret;
	}
	
	private void updateConnectionsDependants(AddComponentPasteCommand clone) {
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
	
	public void redo() {
		super.redo();
		dependantCommands.redo();
	}
	
	public void undo() {
		dependantCommands.undo();
		super.undo();
	}
	
	public List getDependantCommands() {
		return dependantCommands.getCommands();
	}
}