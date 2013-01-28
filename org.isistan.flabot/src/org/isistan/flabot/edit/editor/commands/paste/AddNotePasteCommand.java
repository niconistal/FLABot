/**
 * $Id: AddNotePasteCommand.java,v 1.7 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands.paste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editor.commands.AddNoteCommand;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class AddNotePasteCommand extends AddNoteCommand implements RetargetParentPasteCommand {

	private HashMap connections = new HashMap();
	private NodeVisualModel copyVisualModel;
	
	public AddNotePasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds) {
		super(null, null, bounds);
		this.copyVisualModel = copyVisualModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands.paste.AddNotePasteCommand.label")); //$NON-NLS-1$
	}
	
	public AddNotePasteCommand(NodeVisualModel copyVisualModel, Rectangle bounds, Diagram diagram) {
		this(copyVisualModel, bounds);
		this.diagram = diagram;		
	}
	
	public boolean canExecute() {
		return (copyVisualModel != null && bounds != null);
	}
	
	public boolean isValidParent(Object parent) {
		return (parent instanceof Diagram);
	}
	
	public void setParent(Object parent) {
		diagram = (Diagram) parent;
	}
		
	public VisualModel getNewVisualModel() {
		return visualModel;
	}
	
	public VisualModel getCopyVisualModel() {
		return copyVisualModel;
	}

	public void execute() {
		visualModel = EditormodelFactory.eINSTANCE.createNodeVisualModel(copyVisualModel);	
		visualModel.setSemanticModel(CoremodelFactory.eINSTANCE.createNote((Note)copyVisualModel.getSemanticModel()));		
		visualModel.setLocation(Util.getPoint(bounds.getLocation()));		
		visualModel.setSize(copyVisualModel.getSize().clone());
		
		redo();
	}
	
	public Command clone() {
		Rectangle newBounds = new Rectangle(bounds.x + 10, bounds.y + 10, bounds.width, bounds.height);
		AddNotePasteCommand clone = new AddNotePasteCommand(copyVisualModel, newBounds, diagram);
		updateConnectionsDependants(clone);
		return clone;
	}
	
	public void addConnectionDependantCommand(boolean source, RetargetConnectionPasteCommand command){
		connections.put(command, new Boolean(source));
	}
	
	private void updateConnectionsDependants(AddNotePasteCommand clone) {
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