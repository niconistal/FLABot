package org.isistan.flabot.executionstatemapping.commands.executioncondition;

import org.eclipse.gef.commands.CompoundCommand;

public abstract class CompoundManageCommand extends CompoundCommand {

	protected boolean wasExecuted;
	
	protected boolean addCommand;
	
	public CompoundManageCommand(boolean addCommand)
	{
		this.addCommand = addCommand;
	}
	
	protected abstract void add();
	
	protected abstract void remove();	
	
	@Override
	public boolean canUndo()
	{
		return wasExecuted;
	}
	
	@Override
	public boolean canExecute()
	{
		return true;
	}
	
	@Override
	public void execute()
	{
		super.execute();

		if (addCommand)
		{
			add();
		}
		else
		{
			remove();
		}
	}
	
	@Override
	public void redo() {
		super.redo();
		if(addCommand)
		{
			add();
		}
		else
		{
			remove();
		}
	}

	@Override
	public void undo() {
		if(addCommand)
		{
			remove();
		}
		else
		{
			add();
		}
		super.undo();
	}	
}