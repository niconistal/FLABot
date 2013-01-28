/** * $Id: ContainerEditPart.java,v 1.15 2006/03/21 02:57:52 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.editor.editparts;

import java.util.List;import org.eclipse.draw2d.Shape;import org.eclipse.draw2d.geometry.Rectangle;import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.notify.AdapterFactory;import org.eclipse.emf.common.notify.Notification;import org.eclipse.emf.common.notify.Notifier;import org.eclipse.emf.ecore.EObject;import org.eclipse.gef.EditPart;import org.eclipse.gef.GraphicalEditPart;import org.eclipse.gef.RequestConstants;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editparts.AbstractGraphicalEditPart;import org.eclipse.gef.requests.GroupRequest;import org.eclipse.swt.widgets.Display;import org.isistan.flabot.FlabotPlugin;import org.isistan.flabot.edit.editor.FlabotCommandStack;import org.isistan.flabot.edit.editormodel.EditormodelPackage;import org.isistan.flabot.edit.editormodel.Util;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;/** * The common abstract edit part used for all edit parts in Flabot (except Connection edit parts) *  * ContainerEditPart: * -	The edit part can contain children. * -	Hooks into VisualModel events and gets notified of. *   * @author $Author: franco $ * */public abstract class ContainerEditPart  
	extends AbstractGraphicalEditPart 
	implements Adapter {
	
	private Notifier target;
	
	/**
	 * Upon activation, attach to visual model element as a property change listener.
	 */	@Override
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getCastedVisualModel());
			super.activate();
		}
	}
	
	/**
	 * Upon deactivation, detach from the visual model element as a property change listener.
	 */	@Override
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getCastedVisualModel());
			super.deactivate();
		}
	}
		/**	 * Upon activation, attach to a model element as a property change listener.	 */
	protected void hookIntoModel(EObject model) {
		if(model != null) {
			model.eAdapters().add(this);
		}
	}
		/**	 * Upon deactivation, detach from a model element as a property change listener.	 */
	protected void unhookFromModel(EObject model) {
		if(model != null) {
			model.eAdapters().remove(this);
		}
	}
		/**	 * Returns the list of children. They are taken from the visual model.	 * 	 * @return the list of children	 */	@Override
	protected List getModelChildren() {
		return getCastedVisualModel().getChildren();
	}
		/**	 * Returns the casted VisualModel	 * 	 * @return the casted VisualModel	 */
	protected VisualModel getCastedVisualModel() {
		return (VisualModel) getModel();
	}
		@Override
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		Rectangle bounds = Util.getDraw2DRectangle(
				getCastedVisualModel().getLocation(),
				getCastedVisualModel().getSize());
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);			}
		/**	 * Appends a command to the Command Stack and executed it.	 * This method is used to execute commands due to the notification of an event.	 * This is an indirect command execution (events caused it).	 * 	 * @param command the command to append	 */	protected void appendToLastAndExecuteCommand(Command command) {		FlabotCommandStack commandStack = (FlabotCommandStack)			getViewer().getEditDomain().getCommandStack();		commandStack.appendToLastAndExecute(command);						FlabotPlugin.getDefault().getLogger()		.warn(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart.warmMessage", command.getLabel(), commandStack.getCurrentCommandLabel()));		 //$NON-NLS-1$	}		/**	 * Returns a command to delete the connections of this edit part.	 * The commands are requested to the connection edit parts.	 * 	 * @param connections the list of connection edit parts	 * @return the deletion commands	 */	public CompoundCommand getConnectionsDeleteCommand(List connections) {		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.editor.editparts.ContainerEditPart.deleteVisualConnectionsCommandLabel")); //$NON-NLS-1$		for (int i=0; i<connections.size(); i++) {			EditPart selectionEditPart = (EditPart)connections.get(i);			GroupRequest request = new GroupRequest();			request.setEditParts(selectionEditPart);			request.setType(RequestConstants.REQ_DELETE);			commands.add(selectionEditPart.getCommand(request));		}		if (commands.size() == 0) return null;		return commands;	}		/*	 * Adapter implementation	 */	/**	 * Notifies that a change to some feature has occurred.	 * Some common events are handle:	 * - Changes of visual properties: size, location, backgroud color,	 * foreground color, line style.	 *	 * - Changes in the children of the model. (Children added/removed) 	 * 	 * @param notification a description of the change.	 */
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
		/**	 * @see AdapterFactory#setTarget	 */
	public Notifier getTarget() {
		return target;
	}
		/**	 * @see AdapterFactory#getTarget	 */
	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}
		/**	 * @see AdapterFactory#isFactoryForType	 */
	public boolean isAdapterForType(Object type) {
		return getModel() == type;
	}
}