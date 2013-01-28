/**

import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;

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