package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDirectionArrowCommand;
import org.isistan.flabot.edit.ucmeditor.figures.DirectionArrowFigure;

public class DirectionArrowNodeEditPart extends PathNodeEditPart {

	@Override
	protected IFigure createFigure() {
		DirectionArrowFigure f = new DirectionArrowFigure(getCastedModel()
				.getRotation(), Util.getSWTRGB(getCastedModel()
				.getForegroundColor()));
		f.setNamePoint(((DirectionArrowNode) getCastedVisualModel()
				.getSemanticModel()).getName());

		return f;
	}

	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {

		// int featureID = notification.getFeatureID(CoremodelPackage.class);

		super.notifyChanged(notification);

		switch (notification.getEventType()) {
		case Notification.SET: {
			if (notification.getFeatureID(EditormodelPackage.class) != EditormodelPackage.NODE_VISUAL_MODEL__ROTATION) {
				InsertDirectionArrowCommand command = new InsertDirectionArrowCommand(
						getCastedModel(), (DirectionArrowNode) getSemanticModel());
				String rotation = command.getDirectionArrowRotation();
				getCastedModel().setRotation(rotation);
			}
			getCastedFigure().setRotation(getCastedModel().getRotation());
			this.getCastedFigure().revalidate();
			
			break;
		}
//		case Notification.UNSET:
//			if (notification.getFeatureID(EditormodelPackage.class) != EditormodelPackage.NODE_VISUAL_MODEL__ROTATION) {
//				InsertDirectionArrowCommand command = new InsertDirectionArrowCommand(
//						getCastedModel(), (DirectionArrowNode) getSemanticModel());
//				String rotation = command.getDirectionArrowRotation();
//				getCastedModel().setRotation(rotation);
//			}
//			
//			getCastedFigure().setRotation(getCastedModel().getRotation());
//			this.getCastedFigure().revalidate();
//			break;
		// switch(notification.getFeatureID(EditormodelPackage.class)) {
		// case EditormodelPackage.:
		// getCastedFigure().setRotation(getCastedModel().getRotation());
		// refreshVisuals();
		// break;
		// }
		}

		// if (notification.getNotifier() instanceof SimplePathNode) {
		// if (notification.getEventType() == Notification.SET && featureID ==
		// CoremodelPackage.SIMPLE_PATH_NODE__NAME) {
		// TimerNode timer = (TimerNode) getCastedModel().getSemanticModel();
		// getCastedFigure().setNamePoint(timer.getName());
		// }
		// return;
		// }

		// if (notification.getNotifier() instanceof Responsibility) {
		// if (featureID == CoremodelPackage.RESPONSIBILITY__NAME){
		// TimerNode timer = (TimerNode) getCastedModel().getSemanticModel();
		// getCastedFigure().setNamePoint(timer.getName());
		// }
		// return;
		// }
	}

	// private void forceDeleteTimer() {
	// //if the stub is still in a diagram
	// if (getCastedModel().getDiagram() != null && getParent() != null)
	// appendToLastAndExecuteCommand(getDeletePathNodeCommand());
	// }
	//	
	// @Override
	// protected Command getDeletePathNodeCommand() {
	//		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart.commandLabel"));		 //$NON-NLS-1$
	// commands.add(getConnectionsDeleteCommand(getTargetConnections()));
	// if (this.getTimerNodeType() == TimerNode.TIMER_TYPE)
	// commands.add(new DeleteTimerCommand(getCastedModel()));
	// else if (this.getTimerNodeType() == TimerNode.WAITING_PLACE_TYPE)
	// commands.add(new DeleteWaitingPlaceCommand(getCastedModel()));
	// return commands;
	// }

	private DirectionArrowFigure getCastedFigure() {
		return (DirectionArrowFigure) getFigure();
	}

	// private void registerNewNode(SimplePathNode oldNode, SimplePathNode
	// newNode) {
	// if (oldNode != newNode) {
	// unhookFromModel(oldNode);
	// hookIntoModel(newNode);
	//			
	// Path oldPath = null;
	// if (oldNode != null) oldPath = oldNode.getPath();
	// Path newPath = null;
	// if (newNode != null) newPath = newNode.getPath();
	//			
	// if (oldPath != newPath){
	// hookIntoModel(oldPath);
	// unhookFromModel(newPath);
	// }
	// }
	// }

	// public Object getAdapter(Class key) {
	// if (IPropertySource.class == key)
	//			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart.namePropertyView"), (TimerNode)getCastedModel().getSemanticModel()); //$NON-NLS-1$
	// return super.getAdapter(key);
	// }

	protected AbstractGraphicalEditPart getCorrectParent() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) getParent();
		if (getCastedModel().getParent() != null)
			part = (AbstractGraphicalEditPart) part.getParent();
		return part;
	}
}
