package org.isistan.flabot.edit.ucmeditor.commands.model;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.impl.TimerNodeImpl;
import org.isistan.flabot.messages.Messages;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class ModifyTimerCommand extends Command {

	TimerNode originalTimer;
	TimerNode newTimer;
	TimerNode oldTimer;
		
	/**
	 * Instantiates a command that modifies all the properties of a timer.
	 * @param visualTimer the timer to modify
	 * @param newTimer the timer from where the new properties are taken  
	 */
	public ModifyTimerCommand(TimerNode originalTimer, TimerNode newTimer) {
		this.originalTimer = originalTimer;
		this.newTimer = newTimer;
		this.oldTimer = (TimerNode) EcoreUtil.copy(originalTimer);
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.model.ModifyTimerCommand.label")); //$NON-NLS-1$
	}
	
	/**
	 * Verifies that the command can be executed.
	 * @return <code>true</code> if the command can be executed	
	 */
	public boolean canExecute() {
		return (originalTimer != null && newTimer != null);
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
		setValues(newTimer);
	}
	
	/**
	 * Set the values on original timer variable, copying data from timer Node Copy
	 * @param timerNodeCopy
	 */
	private void setValues(TimerNode timerNodeCopy) {
		this.copyValues(originalTimer, timerNodeCopy);
	}
	
	private void copyValues(TimerNode newTimer, TimerNode timerNodeCopy)
	{
		newTimer.setResponsibility(timerNodeCopy.getResponsibility());
		newTimer.setName(timerNodeCopy.getName());
		newTimer.setTimerName(timerNodeCopy.getTimerName());
		newTimer.setTimerDescription(timerNodeCopy.getTimerDescription());
		newTimer.setTimerType(timerNodeCopy.getTimerType());
		newTimer.setTimerTimeOut(timerNodeCopy.getTimerTimeOut());
		newTimer.setTimerTimeOutUnity(timerNodeCopy.getTimerTimeOutUnity());	
	}

	/**
	 * The old properties are restored in the stub (including its name, map, start and end nodes).
	 */
	public void undo() {
		setValues(oldTimer);	
	}
}
