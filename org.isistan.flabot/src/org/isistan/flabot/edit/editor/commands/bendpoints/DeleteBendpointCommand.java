/** * $Id: DeleteBendpointCommand.java,v 1.5 2006/01/27 00:09:19 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editor.commands.bendpoints;

import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;public class DeleteBendpointCommand extends BendpointCommand  {

	private ConnectionBendpoint bendpoint;

	public void execute() {
		bendpoint = (ConnectionBendpoint)getConnection().getBendpoints().get(getIndex());
		getConnection().getBendpoints().remove(getIndex());
		super.execute();
	}

	public void undo() {
		super.undo();
		getConnection().getBendpoints().add(getIndex(), bendpoint);
	}

}
