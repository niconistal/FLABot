/**
 * $Id: AddInterfaceCommand.java,v 1.2 2006/04/01 03:41:25 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.visual;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.editparts.ProvidedInterfaceEditPart;
import org.isistan.flabot.edit.componenteditor.figures.InterfaceFigure;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * AddInterfaceCommand
 * -	Adds an interface model to core model.
 * -	Adds a visual model to the diagram and assigns its semantic model to the interface model.
 * -	Adds the interface to the list of required or provided interfaces of the components port.
 * 
 * @author $Author: franco $
 *
 */
public class AddInterfaceCommand extends Command {
	
	protected VisualModel parent;
	protected InterfaceModel interfaceModel;
	protected NodeVisualModel visualModel;
	protected String type;
	private boolean addedToCore;
	
	/**
	 * Instantiates a command that can add an interface to a port.
	 * @param parent the visual model of the port where the interface will be added
	 * @param visualModel the visual model of the interface that will be added 
	 * @param type the type of the interface that will be added (provided or required)
	 */
	public AddInterfaceCommand(VisualModel parent, NodeVisualModel visualModel, String type) {
		this.parent = parent;
		this.type = type;
		this.visualModel = visualModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddInterfaceCommand.label")); //$NON-NLS-1$
	}	
	
	/**
	 * The command can be undone if the port contains the visual model of the interface.
	 * @return <code>true</code> if the command can be undone
	 */
	public boolean canUndo() {
		return parent.getChildren().contains(visualModel);
	}
	
	/**
	 * Verifies that the command can be executed.
	 * The interface must not be duplicated.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (parent != null && visualModel != null &&
				!isDuplicated((InterfaceModel)visualModel.getSemanticModel()));
	}
	
	/**
	 * Verifies that the interface does not exist in the port.
	 * @param inter the interface to check for duplication
	 */
	private boolean isDuplicated(InterfaceModel inter) {
		for (Iterator iter=parent.getChildren().iterator(); iter.hasNext();) {
			VisualModel visual = (VisualModel) iter.next();
			if (visual.getSemanticModel() == inter) {
				MessageDialog dlg = new MessageDialog(
						Display.getCurrent().getActiveShell(),
			            Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddInterfaceCommand.label"), //$NON-NLS-1$
			            null,
			            Messages.getString("org.isistan.flabot.edit.componenteditor.commands.AddInterfaceCommand.interfaceAlreadyInPort"), //$NON-NLS-1$
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
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {	
		interfaceModel = (InterfaceModel)visualModel.getSemanticModel();
		if (interfaceModel == null)
			interfaceModel = CoremodelFactory.eINSTANCE.createInterfaceModel();			
		visualModel.setSemanticModel(interfaceModel);
		interfaceModel.setPort((PortModel)parent.getSemanticModel());
		
		updateBoundsAndName();
		redo();
	}

	/**
	 * Sets the correct location and size of the interface in the port according to the other existing interfaces.
	 */	
	protected void updateBoundsAndName() {
		visualModel.setLocation(Util.getPoint(2, 2 + 25 *  (parent.getChildren().size())));		
		visualModel.setSize(Util.getDimension(InterfaceFigure.defaultsize));
	}
	
	/**
	 * Adds the semantic interface to the port model, according to its type.
	 * Adds the visual interface to the visual port.
	 */	
	public void redo() {		
		if (type.equals(ProvidedInterfaceEditPart.PROVIDED_INTERFACE))
			addedToCore = ((PortModel)parent.getSemanticModel()).getProvideds().add(interfaceModel);
		else
			addedToCore = ((PortModel)parent.getSemanticModel()).getRequireds().add(interfaceModel);
		
		parent.getChildren().add(visualModel);	
	}

	/**
	 * Removes the semantic interface from the port model.
	 * Removes the added visual Interface from the visual port.
	 */	
	public void undo() {
		parent.getChildren().remove(visualModel);
		if (addedToCore) {
			if (type.equals(ProvidedInterfaceEditPart.PROVIDED_INTERFACE))
				((PortModel)parent.getSemanticModel()).getProvideds().remove(visualModel.getSemanticModel());
			else
				((PortModel)parent.getSemanticModel()).getRequireds().remove(visualModel.getSemanticModel());
		}				
	}
}