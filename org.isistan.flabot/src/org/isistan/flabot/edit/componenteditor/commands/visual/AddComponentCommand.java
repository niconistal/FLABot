/**
 * $Id: AddComponentCommand.java,v 1.2 2006/03/20 19:54:40 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.componenteditor.figures.ComponentFigure;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;


/**
 * AddComponentCommand
 * -	Adds a component to a components diagram.
 * -	If it is a new component (that is, was creted from palette) a new component is added to the semantic model, otherwise (that is, comes from outline drag and drop) it is just added and assigned to the visual component.
 * -	If dropped from outline, the DropComponentFactory creates the visual model with all components ports and interfaces so this command just adds the visual model to the diagram.
 * 
 * @author $Author: franco $
 *
 */
public class AddComponentCommand extends Command {
	
	protected ComponentDiagram diagram;
	protected NodeVisualModel visualModel = null;
	protected Rectangle bounds = null;
	private boolean addedToCore;
	
	/**
	 * Instantiates a command that can add a component to a components diagram.
	 * @param visualModel the visual model of the component to add
	 * @param diagram the component diagram where the component will be added
	 * @param bounds the bounds (size and location) of the component in the diagram
	 */
	public AddComponentCommand(NodeVisualModel visualModel, ComponentDiagram diagram, Rectangle bounds) {
		this.diagram = diagram;
		this.visualModel = visualModel;
		this.bounds = bounds;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddComponentCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * The component must not be duplicated.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		boolean valid = (visualModel != null && diagram != null && bounds != null);
		
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
			            Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddComponentCommand.label"), //$NON-NLS-1$
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

		updateBounds();			
		redo();
	}
	
	/**
	 * Verifies that the bounds of the component are correct.
	 * If not, sets the bounds to the minimum value.
	 */	
	protected void updateBounds() {
		Point location = bounds.getLocation();
		location.x -= ComponentFigure.offset; 
		visualModel.setLocation(Util.getPoint(location));		
	
		Dimension d = ComponentFigure.defaultsize;
		if (visualModel.getSize().getWidth() < d.width && visualModel.getSize().getHeight() < d.height)
			visualModel.setSize(Util.getDimension(d.width, d.height));
	}

	/**
	 * Adds the semantic component to the core model.
	 * Adds the visual component to the component diagram.
	 */	
	public void redo() {
		addedToCore = diagram.getCoreModel().getComponents().add(visualModel.getSemanticModel());
		visualModel.setDiagram(diagram);
	}		

	/**
	 * Removes the semantic component from the core model, if it was added. It could not have been added to the core model if the command was executed from an outline drag and drop.
	 * Removes the added visual component from the component diagram.
	 */	
	public void undo() {
		visualModel.setDiagram(null);
		//Component must be deleted from Outline View
		if (addedToCore)
			diagram.getCoreModel().getComponents().remove(visualModel.getSemanticModel());				
	}
}