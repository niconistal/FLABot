/**
 * $Id: AddInterfacePasteCommand.java,v 1.7 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddInterfaceCommand;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddInterfacePasteCommand extends AddInterfaceCommand implements RetargetParentPasteCommand {
	
	private HashMap connections = new HashMap();
	private NodeVisualModel copyVisualModel;
	
	public AddInterfacePasteCommand(NodeVisualModel copyVisualModel, String type) {
		super(null, null, type);
		this.copyVisualModel = copyVisualModel;	
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddInterfacePasteCommand.label")); //$NON-NLS-1$
	}	
	
	AddInterfacePasteCommand(NodeVisualModel copyVisualModel, String type, VisualModel parent) {
		this(copyVisualModel, type);
		this.parent = parent;

	}
	
	public void setParent(Object object) {
		parent = (VisualModel) object;
	}
	
	public boolean isValidParent(Object object) {
		if (object instanceof VisualModel) {
			VisualModel v = (VisualModel) object;
			return (v.getSemanticModel() instanceof PortModel);
		}
		return false;
	}	
	
	public boolean canExecute() {
		return (copyVisualModel != null);
	}
		
	public VisualModel getNewVisualModel() {
		return visualModel;
	}
	
	public VisualModel getCopyVisualModel() {
		return copyVisualModel;
	}
	
	public void execute() {
		visualModel = EditormodelFactory.eINSTANCE.createNodeVisualModel(copyVisualModel);		
		interfaceModel = CoremodelFactory.eINSTANCE.createInterfaceModel((InterfaceModel)copyVisualModel.getSemanticModel());
		visualModel.setSemanticModel(interfaceModel);
		interfaceModel.setPort((PortModel)parent.getSemanticModel());		
		updateBoundsAndName();
		redo();
	}
	
	public Command clone() {
		AddInterfacePasteCommand clone = new AddInterfacePasteCommand(copyVisualModel, type, parent);
		updateConnectionsDependants(clone);
		return clone;
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command){
		connections.put(command, new Boolean(source));
	}
	
	private void updateConnectionsDependants(AddInterfacePasteCommand clone) {
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
}