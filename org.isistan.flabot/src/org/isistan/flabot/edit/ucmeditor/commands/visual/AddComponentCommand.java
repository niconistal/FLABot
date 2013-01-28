package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.componenteditor.figures.ComponentFigure;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class AddComponentCommand extends Command {
	
	protected UCMDiagram diagram;
	protected NodeVisualModel visualModel = null;
	
	private boolean addedToCore;
	
	/**
	 * Instantiates a command that can add a component to a UCM diagram.
	 * @param visualModel the visual model of the component to add
	 * @param diagram the UCM diagram where the component will be added
	 */
	public AddComponentCommand(NodeVisualModel visualModel, UCMDiagram diagram) {
		this.diagram = diagram;
		this.visualModel = visualModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.AddComponentCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * The component must not be duplicated.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		boolean valid = (visualModel != null && diagram != null);
		
		if (visualModel != null && visualModel.getSemanticModel() != null) {
			ComponentModel component = (ComponentModel)visualModel.getSemanticModel();
			return (!isDuplicated(component) && valid);		
		}
		return valid;
	}
	
	/**
	 * Verifies that the component does not exist in the diagram.
	 * @param component the component to check for duplication
	 */
	private boolean isDuplicated(ComponentModel component) {
		for (Iterator iter=diagram.getChildren().iterator(); iter.hasNext();) {
			VisualModel visual = (VisualModel) iter.next();
			if (visual.getSemanticModel() == component)  {
				MessageDialog dlg = new MessageDialog(
						Display.getCurrent().getActiveShell(),
			            Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.AddComponentCommand.label"), //$NON-NLS-1$
			            null,
			            Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddComponentCommand.componentAlreadyInDiagram"), //$NON-NLS-1$
			            MessageDialog.ERROR,
			            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$
			            0);
			    dlg.open();
			   
			    return true;
			}			
		}
		return false;
	}	
	
	/**
	 * Executes the command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {		
		ComponentModel component = (ComponentModel)visualModel.getSemanticModel();
		if (component == null)
			component = CoremodelFactory.eINSTANCE.createComponentModel();
		
		visualModel.setSemanticModel(component);
		redo();
	}

	/**
	 * Adds the semantic component to the core model.
	 */	
	public void redo() {		
		addedToCore = diagram.getCoreModel().getComponents().add((ComponentModel)visualModel.getSemanticModel());
	}		

	/**
	 * Removes the semantic component from the core model, if it was added. It could not have been added to the core model if the command was executed from an outline drag and drop.
	 * Removes the added visual component from the UCM diagram.
	 */	
	public void undo() {		
		
		if (addedToCore)
			diagram.getCoreModel().getComponents().remove((ComponentModel)visualModel.getSemanticModel());			
	}

}
