/**
 * $Id: AddRelationshipConnectionPasteCommand.java,v 1.5 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddRelationshipConnectionCommand;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddRelationshipConnectionPasteCommand extends AddRelationshipConnectionCommand implements RetargetConnectionPasteCommand {
	
	private RetargetParentPasteCommand commandSource;
	private RetargetParentPasteCommand commandTarget;
	
	private ConnectionVisualModel copyConnectionModel;

	public AddRelationshipConnectionPasteCommand(ConnectionVisualModel copyConnectionModel) {
		super(null, null, null);
		this.copyConnectionModel = copyConnectionModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddRelationshipConnectionPasteCommand.label")); //$NON-NLS-1$
	}
	
	AddRelationshipConnectionPasteCommand(ConnectionVisualModel copyConnectionModel, RetargetParentPasteCommand commandSource, RetargetParentPasteCommand commandTarget, ComponentDiagram diagram) {
		this(copyConnectionModel);
		this.commandSource = commandSource;
		this.commandTarget = commandTarget;
		this.diagram = diagram;
	}
	
	public void setParent(Object object) {
		diagram = (ComponentDiagram) object;
	}
	
	public boolean isValidParent(Object object) {
		return (object instanceof ComponentDiagram);
	}
	
	public VisualModel getNewVisualModel() {
		return connection;
	}	
	
	public VisualModel getCopyVisualModel() {
		return copyConnectionModel;
	}
		
	public void setCommandSource(RetargetParentPasteCommand commandSource) {
		this.commandSource = commandSource;
	}
	
	public void setCommandTarget(RetargetParentPasteCommand commandTarget) {
		this.commandTarget = commandTarget;
	}
	
	public boolean canExecute() {
		return true;
	}	
	
	public void execute() {
		source = (NodeVisualModel)commandSource.getNewVisualModel();
		target = (NodeVisualModel)commandTarget.getNewVisualModel();
		
		connection = EditormodelFactory.eINSTANCE.createConnectionVisualModel(copyConnectionModel);
		connection.setSemanticModel(CoremodelFactory.eINSTANCE.createRelationship((Relationship)copyConnectionModel.getSemanticModel()));
		
		super.execute();
	}
	
	public Command clone() {
		return new AddRelationshipConnectionPasteCommand(copyConnectionModel, commandSource, commandTarget, diagram);
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command) {}
	
	public List getDependantCommands() {
		return new ArrayList();
	}
}