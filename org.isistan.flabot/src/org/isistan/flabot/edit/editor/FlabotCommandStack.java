/**
 * $Id: FlabotCommandStack.java,v 1.10 2006/04/03 21:00:32 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.custom.BusyIndicator;
import org.isistan.flabot.edit.editor.commands.EditorActivatorCommandWrapper;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.messages.Messages;

/**
 * Flabot-specific command stack that handles command management details
 * @author $Author: franco $
 *
 */
public class FlabotCommandStack extends CommandStack implements CommandStackEventListener{
				
	private FlabotMultiPageEditor multipageEditor;
	
	private Command currentCommand;
	
	private Map<Command, CompoundCommand> firedCommandsMap = new HashMap<Command, CompoundCommand>();
	
	/**
	 * Create a new instance of FlabotCommandStack for the given
	 * multipageEditor
	 * @param multipageEditor the flabot multipage editor
	 */
	public FlabotCommandStack(FlabotMultiPageEditor multipageEditor) {
		if (multipageEditor == null)
			throw new IllegalArgumentException(
					Messages.getString("org.isistan.flabot.edit.editor.FlabotCommandStack.errorNullMultipageEditor")); //$NON-NLS-1$
		this.multipageEditor = multipageEditor;
		addCommandStackEventListener(this);
	}

	@Override
	public void execute(Command command) {
		if (command == null)
			return;
		if (!(command instanceof EditorActivatorCommandWrapper)) {
			command = new EditorActivatorCommandWrapper(command,
					multipageEditor);
		}
		if (!(command instanceof CompoundCommand)) {
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.add(command);
			command = compoundCommand;
		}
		
		final Command finalCommand=command;
		BusyIndicator.showWhile(null, new Runnable() {
			public void run() {
				currentCommand = finalCommand;
				FlabotCommandStack.super.execute(finalCommand);
				currentCommand = null;                
			}
		});
	}
	
	public void undo() {
		BusyIndicator.showWhile(null, new Runnable() {
			public void run() {
				FlabotCommandStack.super.undo();			              
			}
		});
	}
	
	public void redo() {
		BusyIndicator.showWhile(null, new Runnable() {
			public void run() {
				FlabotCommandStack.super.redo();			              
			}
		});
	}
	
	public void postUndo(Command command) {		
		undoFiredCommands(command);
	}
	
	public void preRedo(Command command) {
		currentCommand = command;
		redoFiredCommands(currentCommand);		
	}
	
	/**
	 * Chain the given command on the last command and then execute it
	 * @param command
	 */
	public void appendToLastAndExecute(Command command) {
		if (currentCommand != null && command != null && command.canExecute()) {
			addFiredCommand(currentCommand, command);
			command.execute();
		}
	}
	
	private CompoundCommand getFiredCommands(Command c) {
		CompoundCommand firedCompoundCommand = (CompoundCommand) firedCommandsMap.get(c);
		if (firedCompoundCommand == null) {
			firedCompoundCommand = new CompoundCommand();
			firedCommandsMap.put(c, firedCompoundCommand);
		}
		return firedCompoundCommand;		
	}
	
	private void addFiredCommand(Command c, Command firedCommand) {
		CompoundCommand firedCompoundCommand = getFiredCommands(c);
		firedCompoundCommand.add(firedCommand);
	}
	
	private void undoFiredCommands(Command c) {
		CompoundCommand firedCompoundCommand = getFiredCommands(c);		
		firedCompoundCommand.undo();
	}
	
	private void redoFiredCommands(Command c) {	
		firedCommandsMap.remove(c);
	}
	
	public String getCurrentCommandLabel() {
		String currentName = ""; //$NON-NLS-1$
		if (currentCommand != null)
			currentName = currentCommand.getLabel();
		return currentName;
	}
	
	/**
	 * Sent when an event occurs on the command stack.  {@link CommandStackEvent#getDetail()}
	 * can be used to identify the type of event which has occurred.
	 * @since 3.1
	 * @param event the event
	 */
	public void stackChanged(CommandStackEvent event) {
		int detail = event.getDetail();
		switch(detail) {
		case CommandStack.POST_UNDO: {
			postUndo(event.getCommand());
			break;
		}
		case CommandStack.PRE_REDO: {
			preRedo(event.getCommand());
			break;
		}
		}		
	}
}