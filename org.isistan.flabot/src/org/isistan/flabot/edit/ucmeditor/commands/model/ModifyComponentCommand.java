package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.messages.Messages;

public class ModifyComponentCommand extends Command {

	ComponentModel originalComponent;
	ComponentModel newComponent;
	ComponentModel oldComponent;
		
	/**
	 * Instantiates a command that modifies all the properties of a component.
	 * @param originalcomponent the component to modify
	 * @param newComponent the component from where the new properties are taken  
	 */
	public ModifyComponentCommand(ComponentModel originalcomponent, ComponentModel newComponent) {
		this.originalComponent = originalComponent;
		this.newComponent = newComponent;
		this.oldComponent = (ComponentModel) EcoreUtil.copy(oldComponent);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyComponentCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (originalComponent != null && newComponent != null);
	}
	
	/**
	 * Executes the Command. This method should not be called if the command is not
	 * executable.
	 * 
	 * @see redo()
	 */
	public void execute() {
		redo();		
	}
	
	/**
	 * The new properties are set in the stub (including its name, map, start and end nodes).
	 */
	public void redo() {
		setValues(newComponent);
	}
	
	/**
	 * Set the values on original timer variable, copying data from timer Node Copy
	 * @param timerNodeCopy
	 */
	private void setValues(ComponentModel componentCopy) {
		this.copyValues(originalComponent, componentCopy);
	}
	
	private void copyValues(ComponentModel newComponent, ComponentModel componentCopy)
	{
		newComponent.setName(componentCopy.getName());
		newComponent.setCoreModel(componentCopy.getCoreModel());
	}

	/**
	 * The old properties are restored in the stub (including its name, map, start and end nodes).
	 */
	public void undo() {
		setValues(oldComponent);	
	}

}
