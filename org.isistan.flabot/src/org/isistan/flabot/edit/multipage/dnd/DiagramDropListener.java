/**

import java.util.ArrayList;
	
	DiagramFactory factory = new DiagramFactory();
	List exclusion = new ArrayList();
	
	public DiagramDropListener(EditPartViewer viewer) {
		super(viewer, TextTransfer.getInstance());
		setExclusionSet();
	}
	
	protected Request createTargetRequest() {
		return new NativeDropRequest();
	}
	
	protected NativeDropRequest getCreateRequest() {
		return (NativeDropRequest)getTargetRequest();
	}

	protected void updateTargetRequest(){
		super.updateTargetEditPart();
		factory.setID((String)getCurrentEvent().data);
		getCreateRequest().setFactory(factory);
	}
	
	public boolean isEnabled(DropTargetEvent event) {
		return (super.isEnabled(event) && getTargetEditPart() instanceof DiagramFolderTreeEditPart);
	}
	
	protected Collection getExclusionSet() {
		return exclusion;
	}
	
	private void setExclusionSet() {
		if (exclusion == null)
			exclusion = new ArrayList();
		exclusion.add(getViewer().getRootEditPart().getContents());
	}
}

class DiagramFactory implements CreationFactory {
	
	private String id;
	
	public void setID(String id) {
		this.id = id;
	}
	
	public Object getObjectType() {
		return String.class;
	}
	
	public Object getNewObject() {
		return id;
	}
}