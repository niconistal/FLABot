/**
 * $Id: AddPortPasteCommand.java,v 1.8 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddPortCommand;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddPortPasteCommand extends AddPortCommand implements RetargetParentPasteCommand {

	private VisualModel copyVisualModel;
	private CompoundCommand dependantCommands;
	
	public AddPortPasteCommand(VisualModel copyVisualModel, Point location, CompoundCommand dependantCommands) {
		super(null, null, location);
		this.copyVisualModel = copyVisualModel;
		this.dependantCommands = dependantCommands;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddPortPasteCommand.label")); //$NON-NLS-1$
	}
	
	public AddPortPasteCommand(VisualModel copyVisualModel, Point location, CompoundCommand dependantCommands, VisualModel parent) {
		this(copyVisualModel, location, dependantCommands);
		this.parent = parent;
	}
	
	public boolean canExecute() {
		return (copyVisualModel != null && location != null);
	}
	
	public void setParent(Object object) {
		parent = (VisualModel) object;
	}
	
	public boolean isValidParent(Object object) {
		if (object instanceof VisualModel) {
			VisualModel v = (VisualModel) object;
			return (v.getSemanticModel() instanceof ComponentModel);
		}
		return false;
	}
		
	public VisualModel getNewVisualModel() {
		return visualModel;
	}
	
	public VisualModel getCopyVisualModel() {
		return copyVisualModel;
	}
	
	private void updateDependantCommands(VisualModel parentVisualModel) {
		if (dependantCommands!= null) {
			for (Iterator iter = dependantCommands.getCommands().iterator(); iter.hasNext(); ) {
				RetargetParentPasteCommand command = (RetargetParentPasteCommand)iter.next();
				command.setParent(parentVisualModel);				
			}
		}		
	}
	
	public void execute() {
		visualModel = EditormodelFactory.eINSTANCE.createVisualModel();
		portModel = CoremodelFactory.eINSTANCE.createPortModel((PortModel)copyVisualModel.getSemanticModel());
		visualModel.setSemanticModel(portModel);		
		visualModel.setSize(Util.getDimension(40,25));
		visualModel.setLocation(Util.getPoint(location));
		updateDependantCommands(visualModel);
		dependantCommands.execute();
		
		super.redo();				
	}
	
	public Command clone() {
		return new AddPortPasteCommand(copyVisualModel, location, clone(dependantCommands), parent);
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
	
	public void redo() {
		super.redo();
		dependantCommands.redo();
	}
	
	public void undo() {
		dependantCommands.undo();
		super.undo();
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command){}
	
	public List getDependantCommands() {
		return dependantCommands.getCommands();
	}
}