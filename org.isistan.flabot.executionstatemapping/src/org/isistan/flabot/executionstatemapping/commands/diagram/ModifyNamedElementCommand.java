package org.isistan.flabot.executionstatemapping.commands.diagram;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.NamedElement;

public class ModifyNamedElementCommand extends Command {

	private String newName, oldName;
	
	private NamedElement element;

	public ModifyNamedElementCommand(NamedElement element, String s) {
		this.element = element;
		newName = "";  //$NON-NLS-1$
		if (s != null)
			newName = s;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.diagram.ModifyNamedElementCommand.commandLabel")); //$NON-NLS-1$
	}
	
	@Override
	public boolean canExecute() {	
		return (element != null);
	}
	
	@Override
	public void execute() {
		oldName = new String(element.getName());
		redo();
	}
	
	@Override
	public void redo() {
		element.setName(newName);
	}
	
	@Override
	public void undo() {
		element.setName(oldName);
	}
}