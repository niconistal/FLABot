package org.isistan.flabot.executionstatemapping.editor.editparts;

import org.eclipse.draw2d.ColorConstants;import org.eclipse.draw2d.IFigure;import org.eclipse.draw2d.Label;import org.eclipse.draw2d.PolylineDecoration;import org.eclipse.emf.common.notify.Notification;import org.eclipse.emf.ecore.EObject;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.Request;import org.eclipse.gef.RequestConstants;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editparts.AbstractGraphicalEditPart;import org.eclipse.gef.editpolicies.ConnectionEditPolicy;import org.eclipse.gef.requests.GroupRequest;import org.eclipse.swt.custom.BusyIndicator;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.internal.Workbench;import org.isistan.flabot.edit.componenteditor.editparts.ConnectionToConnectionEditPart;import org.isistan.flabot.edit.editor.FlabotCommandStack;import org.isistan.flabot.edit.editor.figures.BendpointLocator;import org.isistan.flabot.edit.editor.figures.LineConnection;import org.isistan.flabot.edit.editormodel.Util;import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;import org.isistan.flabot.executionstatemapping.InterfacePluginExecutionStateMapping;import org.isistan.flabot.executionstatemapping.commands.diagram.DeleteTransitionConditionConnectionCommand;import org.isistan.flabot.executionstatemapping.dialogs.common.ExecutionConditionEditorBuilder;import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;public class TransitionConditionConnectionEditPart extends ConnectionToConnectionEditPart {
	
	private Label name = new Label();		
			
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int featureId = notification.getFeatureID(SemanticPackage.class);
		switch(featureId) {			case Notification.SET:					case SemanticPackage.EXECUTION_CONDITION__NAME:				{										updateName((LineConnection) getFigure());					break;				}
								case SemanticPackage.TRANSITION_CONDITION__EXECUTION_CONDITION:				{					if (notification.getNewValue() == null)					{						unhookFromModel((EObject)notification.getOldValue());					}					else					{						hookIntoModel((EObject)notification.getNewValue());					}
					updateName((LineConnection) getFigure());
					break;				}
		}
	}	
	
	protected TransitionCondition getSemanticModel() {
		return (TransitionCondition) getCastedModel().getSemanticModel();
	}
		@Override	public void performRequest(Request request){		if (request.getType() == RequestConstants.REQ_OPEN)		{			if (getSemanticModel().getExecutionCondition() != null)			{				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {					public void run() {						Command command = ExecutionConditionEditorBuilder.showEditExecutionConditionDialog(getSemanticModel().getExecutionCondition(), InterfacePluginExecutionStateMapping.getFileModel(getEditor()));						if (command != null)						{							FlabotCommandStack commandStack = (FlabotCommandStack)							getViewer().getEditDomain().getCommandStack();							commandStack.execute(command);						}					}				});			}		}		super.performRequest(request);	}		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();	
		
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			@Override			protected Command getDeleteCommand(GroupRequest request) {
				AbstractGraphicalEditPart c = (AbstractGraphicalEditPart) getHost();
				CompoundCommand commands = new CompoundCommand();
				commands.add(getConnectionsDeleteCommand(c.getTargetConnections()));
				commands.add(new DeleteTransitionConditionConnectionCommand(getCastedModel()));
				return commands;
			}
		});				
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override	protected IFigure createFigure() {
		LineConnection connection = new LineConnection(
				getCastedModel().getLineStyle(), 
				1,
				Util.getSWRColor(Display.getCurrent(), getCastedModel().getForegroundColor()));		
		name.setOpaque(true);
		name.setBackgroundColor(ColorConstants.buttonLightest);		PolylineDecoration p = new PolylineDecoration();		p.setScale(12, 4);		connection.setTargetDecoration(p);		
		updateName(connection);		return connection;
	}
	
	private void updateName(LineConnection connection) {
		// workaround for bug 0000613: an empty label is never added to the connection
		TransitionCondition relation = getSemanticModel();
		if (relation.getExecutionCondition() == null)		{			name.setText(""); //$NON-NLS-1$		}		else		{					name.setText("{" + relation.getExecutionCondition().getName() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		connection.add(name, new BendpointLocator(connection));
	}		@SuppressWarnings("restriction") //$NON-NLS-1$	private FlabotMultiPageEditor getEditor()	{		return (FlabotMultiPageEditor) Workbench.getInstance().getActiveWorkbenchWindow().getActivePage().getActiveEditor();	}
}