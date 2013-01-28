/**
 * $Id: NotifierCommandWrapper.java,v 1.6 2006/03/21 01:51:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.messages.Messages;

/**
 * Wraps a command to notify the user with a message dialog when the wrapped
 * command is executed, redone and undone
 * @author $Author: franco $
 *
 */
public class NotifierCommandWrapper extends Command {

	private Command wrappedCommand;
	private Shell shell;
	
	private String executeMessage;
	private boolean notifyExecute;
	
	private String redoMessage;
	private boolean notifyRedo;
	
	private String undoMessage;
	private boolean notifyUndo;

	/**
	 * Create a new instance of NotifierCommandWrapper for the given command, 
	 * that will display the given messages before the specified events
	 * using the given shell.
	 * 
	 * @param wrappedCommand the wrapped command
	 * @param shell the SWT shell to be used as a parent for the message dialogs
	 * @param executeMessage the message that must be shown before execution
	 * @param redoMessage the message that must be shown before redo
	 * @param undoMessage the message that must be shown before undo
	 * @param notifyExecute whether execution must be notified or not
	 * @param notifyRedo whether redo must be notified or not
	 * @param notifyUndo whether undo must be notified or not
	 */
	public NotifierCommandWrapper(Command wrappedCommand,
			Shell shell, String executeMessage, String redoMessage,
			String undoMessage, boolean notifyExecute, boolean notifyRedo,
			boolean notifyUndo) {
		this.wrappedCommand = wrappedCommand;
		this.shell = shell;
		this.executeMessage = executeMessage;
		this.redoMessage = redoMessage;
		this.undoMessage = undoMessage;
		this.notifyExecute = notifyExecute;
		this.notifyRedo = notifyRedo;
		this.notifyUndo = notifyUndo;
	}
	
	/**
	 * Create an instance of NotifierCommandWrapper for the given command,
	 * that will display default notification messages before the specified
	 * events using the given shell.
	 * 
	 * @param wrappedCommand the wrapped command
	 * @param shell the SWT shell to be used as a parent for the message dialogs
	 * @param notifyExecute whether execution must be notified or not
	 * @param notifyRedo whether redo must be notified or not
	 * @param notifyUndo whether undo must be notified or not
	 */
	public NotifierCommandWrapper(Command wrappedCommand,
			Shell shell, boolean notifyExecute, boolean notifyRedo,
			boolean notifyUndo) {
		this(wrappedCommand, shell,
				Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.executeMessage", wrappedCommand.getLabel()), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.redoMessage", wrappedCommand.getLabel()), //$NON-NLS-1$
				Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.undoMessage", wrappedCommand.getLabel()), //$NON-NLS-1$
				notifyExecute, notifyRedo, notifyUndo);
	}
	
	/**
	 * Create an instance of NotifierCommandWrapper for the given command,
	 * that will display default notification messages before it's executed,
	 * redone and undone.
	 * 
	 * @param wrappedCommand the wrapped command
	 * @param shell the SWT shell to be used as a parent for the message dialogs
	 */
	public NotifierCommandWrapper(Command wrappedCommand,
			Shell shell) {
		this(wrappedCommand, shell, false, true, true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return wrappedCommand != null && wrappedCommand.canExecute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canUndo() {
		return wrappedCommand != null && wrappedCommand.canUndo();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#chain(org.eclipse.gef.commands.Command)
	 */
	public Command chain(Command command) {
		return super.chain(command);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	public void dispose() {
		if (wrappedCommand != null)
			wrappedCommand.dispose();
		super.dispose();
		wrappedCommand = null;
		shell = null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if (notifyExecute)
			MessageDialog.openInformation(
					shell, Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.executeNotification"), executeMessage); //$NON-NLS-1$
		wrappedCommand.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#getDebugLabel()
	 */
	public String getDebugLabel() {
		return Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.debugLabel") + wrappedCommand.getDebugLabel(); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#getLabel()
	 */
	public String getLabel() {
		return wrappedCommand.getLabel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		if (notifyRedo)
			MessageDialog.openInformation(
					shell, Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.redoNotification"), redoMessage); //$NON-NLS-1$
		wrappedCommand.redo();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#setDebugLabel(java.lang.String)
	 */
	public void setDebugLabel(String label) {
		wrappedCommand.setDebugLabel(label);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#setLabel(java.lang.String)
	 */
	public void setLabel(String label) {
		wrappedCommand.setLabel(label);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if (notifyUndo)
			MessageDialog.openInformation(
					shell, Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.undoNotification"), undoMessage); //$NON-NLS-1$
		wrappedCommand.undo();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Messages.getString("org.isistan.flabot.edit.editor.commands.NotifierCommandWrapper.toString") + wrappedCommand.toString(); //$NON-NLS-1$
	}

	/**
	 * @return Returns the executeMessage.
	 */
	public String getExecuteMessage() {
		return executeMessage;
	}

	/**
	 * @param executeMessage The executeMessage to set.
	 */
	public void setExecuteMessage(String executeMessage) {
		this.executeMessage = executeMessage;
	}

	/**
	 * @return Returns the notifyExecute.
	 */
	public boolean isNotifyExecute() {
		return notifyExecute;
	}

	/**
	 * @param notifyExecute The notifyExecute to set.
	 */
	public void setNotifyExecute(boolean notifyExecute) {
		this.notifyExecute = notifyExecute;
	}

	/**
	 * @return Returns the notifyRedo.
	 */
	public boolean isNotifyRedo() {
		return notifyRedo;
	}

	/**
	 * @param notifyRedo The notifyRedo to set.
	 */
	public void setNotifyRedo(boolean notifyRedo) {
		this.notifyRedo = notifyRedo;
	}

	/**
	 * @return Returns the notifyUndo.
	 */
	public boolean isNotifyUndo() {
		return notifyUndo;
	}

	/**
	 * @param notifyUndo The notifyUndo to set.
	 */
	public void setNotifyUndo(boolean notifyUndo) {
		this.notifyUndo = notifyUndo;
	}

	/**
	 * @return Returns the redoMessage.
	 */
	public String getRedoMessage() {
		return redoMessage;
	}

	/**
	 * @param redoMessage The redoMessage to set.
	 */
	public void setRedoMessage(String redoMessage) {
		this.redoMessage = redoMessage;
	}

	/**
	 * @return Returns the shell.
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @param shell The shell to set.
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * @return Returns the undoMessage.
	 */
	public String getUndoMessage() {
		return undoMessage;
	}

	/**
	 * @param undoMessage The undoMessage to set.
	 */
	public void setUndoMessage(String undoMessage) {
		this.undoMessage = undoMessage;
	}

	/**
	 * @return Returns the wrappedCommand.
	 */
	public Command getWrappedCommand() {
		return wrappedCommand;
	}

	/**
	 * @param wrappedCommand The wrappedCommand to set.
	 */
	public void setWrappedCommand(Command wrappedCommand) {
		this.wrappedCommand = wrappedCommand;
	}	
}