/**

import org.eclipse.emf.common.util.BasicEList;
	
	public final static String BRING_TO_FRONT = "BRING_TO_FRONT"; //$NON-NLS-1$
	public final static String BRING_FORWARD = "BRING_FORWARD"; //$NON-NLS-1$
	public final static String SEND_BACKWARD = "SEND_BACKWARD"; //$NON-NLS-1$
	public final static String SEND_TO_BACK = "SEND_TO_BACK"; //$NON-NLS-1$
	
	private VisualModel nodeVisual;
	private EList oldList = new BasicEList();
		
	private String arrange;
	
	public ArrangeCommand(VisualModel visualModel, String arrange) {
		this.nodeVisual = visualModel;
		this.arrange = arrange;
		copyList(visualModel.getDiagram().getChildren(),(EList)oldList);
		this.setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands-ArrangeCommand.label")); //$NON-NLS-1$
		
	}
	
	private void copyList(EList children, EList list2) {
		for (int i=0; i<children.size();i++){
			list2.add(children.get(i));
		}		
	}
	
	public boolean canExecute() {
		return (nodeVisual != null);
	}
	
	public void execute() {
		redo();
	}
	
	protected void doSendBackward() {
		EList list = nodeVisual.getDiagram().getChildren();
		int index = list.indexOf(nodeVisual);
		list.remove(nodeVisual);
		if (index > 0)
			list.add(index-1,nodeVisual);
		else
			list.add(index,nodeVisual);
	}
	
	protected void doBringToFront() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.remove(nodeVisual);
		list.add(nodeVisual);
	}
	
	protected void doBringToBack() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.remove(nodeVisual);
		list.add(0,nodeVisual);
	}
	
	protected void doSendForward() {
		EList list = nodeVisual.getDiagram().getChildren();
		int index = list.indexOf(nodeVisual);
		list.remove(nodeVisual);	
		if (index < list.size())
			list.add(index+1,nodeVisual);
		else
			list.add(index,nodeVisual);	
	}
	
	public void redo() {
		if (BRING_FORWARD.equals(arrange))
			doSendForward();
		else if (BRING_TO_FRONT.equals(arrange))
			doBringToFront();
		else if (SEND_TO_BACK.equals(arrange))
			doBringToBack();
		else if (SEND_BACKWARD.equals(arrange))
			doSendBackward();
	}
	
	public void undo() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.clear();
		copyList((EList)oldList,list);
	}	
}