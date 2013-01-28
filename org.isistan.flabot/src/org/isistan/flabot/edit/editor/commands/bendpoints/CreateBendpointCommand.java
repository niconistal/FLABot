/** * $Id: CreateBendpointCommand.java,v 1.5 2006/01/27 00:09:19 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editor.commands.bendpoints;

import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;import org.isistan.flabot.edit.editormodel.EditormodelFactory;import org.isistan.flabot.edit.editormodel.Util;public class CreateBendpointCommand extends BendpointCommand {

	public void execute() {
		ConnectionBendpoint wbp = EditormodelFactory.eINSTANCE.createConnectionBendpoint();
		wbp.setFirstRelativeDimension(Util.getDimension(getFirstRelativeDimension()));
		wbp.setSecondRelativeDimension(Util.getDimension(getSecondRelativeDimension())); 
		getConnection().getBendpoints().add(getIndex(), wbp);
		super.execute();
	}

	public void undo() {
		super.undo();
		getConnection().getBendpoints().remove(getIndex());
	}

}
