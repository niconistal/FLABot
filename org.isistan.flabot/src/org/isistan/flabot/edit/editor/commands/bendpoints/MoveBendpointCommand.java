/**

import org.isistan.flabot.FlabotPlugin;

	private ConnectionBendpoint oldBendpoint;

	public void execute() {
		ConnectionBendpoint bp = EditormodelFactory.eINSTANCE.createConnectionBendpoint();;
		bp.setFirstRelativeDimension(Util.getDimension(getFirstRelativeDimension())); 
		bp.setSecondRelativeDimension(Util.getDimension(getSecondRelativeDimension()));
		try {
			setOldBendpoint((ConnectionBendpoint)getConnection().getBendpoints().get(getIndex()));
		} catch (Exception e) {
			FlabotPlugin.getDefault().getLogger()
			.error("__error_message__: {}", e); //$NON-NLS-1$
		}
		getConnection().getBendpoints().set(getIndex(), bp);
		super.execute();
	}

	protected ConnectionBendpoint getOldBendpoint() {
		return oldBendpoint;
	}

	public void setOldBendpoint(ConnectionBendpoint bp) {
		oldBendpoint = bp;
	}

	public void undo() {
		super.undo();
		getConnection().getBendpoints().set(getIndex(), getOldBendpoint());
	}
}