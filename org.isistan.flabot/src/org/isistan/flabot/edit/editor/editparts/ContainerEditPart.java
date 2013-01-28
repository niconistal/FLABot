/**

import java.util.List;
	extends AbstractGraphicalEditPart 
	implements Adapter {
	
	private Notifier target;
	
	/**
	 * Upon activation, attach to visual model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getCastedVisualModel());
			super.activate();
		}
	}
	
	/**
	 * Upon deactivation, detach from the visual model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getCastedVisualModel());
			super.deactivate();
		}
	}
	
	protected void hookIntoModel(EObject model) {
		if(model != null) {
			model.eAdapters().add(this);
		}
	}
	
	protected void unhookFromModel(EObject model) {
		if(model != null) {
			model.eAdapters().remove(this);
		}
	}
	
	protected List getModelChildren() {
		return getCastedVisualModel().getChildren();
	}
	
	protected VisualModel getCastedVisualModel() {
		return (VisualModel) getModel();
	}
	
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		Rectangle bounds = Util.getDraw2DRectangle(
				getCastedVisualModel().getLocation(),
				getCastedVisualModel().getSize());
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);		
	
	public void notifyChanged(Notification notification) {
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(EditormodelPackage.class);			
		switch(type) {
		case Notification.SET:
			switch(featureId) {
				case EditormodelPackage.VISUAL_MODEL__SIZE:
				case EditormodelPackage.VISUAL_MODEL__LOCATION:
					refreshVisuals();
					refreshChildren();
					break;
				case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
					getFigure().setBackgroundColor(Util.getSWRColor(Display.getCurrent(), getCastedVisualModel().getBackgroundColor()));
					break;
				case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
					getFigure().setForegroundColor(Util.getSWRColor(Display.getCurrent(), getCastedVisualModel().getForegroundColor()));
					break;
				case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
					((Shape)getFigure()).setLineStyle(getCastedVisualModel().getLineStyle());
					break;
				case EditormodelPackage.VISUAL_MODEL__CHILDREN:
					refreshVisuals();
					refreshChildren();
					break;
			}								
		case Notification.ADD:
		case Notification.REMOVE:
			switch(featureId) {
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				refreshChildren();
				break;
			case EditormodelPackage.VISUAL_MODEL:
				refreshVisuals();
				break;
			}
		}
	}
	
	public Notifier getTarget() {
		return target;
	}
	
	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}
	
	public boolean isAdapterForType(Object type) {
		return getModel() == type;
	}
}