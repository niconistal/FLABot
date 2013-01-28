/**

import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;

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