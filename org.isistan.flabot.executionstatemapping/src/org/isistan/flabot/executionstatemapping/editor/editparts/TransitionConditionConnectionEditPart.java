package org.isistan.flabot.executionstatemapping.editor.editparts;

import org.eclipse.draw2d.ColorConstants;
	
	private Label name = new Label();		
			
	/**
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
		super.notifyChanged(notification);
		int featureId = notification.getFeatureID(SemanticPackage.class);
		switch(featureId) {
				
					updateName((LineConnection) getFigure());
					break;
		}
	}	
	
	protected TransitionCondition getSemanticModel() {
		return (TransitionCondition) getCastedModel().getSemanticModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		super.createEditPolicies();	
		
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			@Override
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
	@Override
		LineConnection connection = new LineConnection(
				getCastedModel().getLineStyle(), 
				1,
				Util.getSWRColor(Display.getCurrent(), getCastedModel().getForegroundColor()));		
		name.setOpaque(true);
		name.setBackgroundColor(ColorConstants.buttonLightest);
		updateName(connection);
	}
	
	private void updateName(LineConnection connection) {
		// workaround for bug 0000613: an empty label is never added to the connection
		TransitionCondition relation = getSemanticModel();
		if (relation.getExecutionCondition() == null)
		}
		connection.add(name, new BendpointLocator(connection));
	}
}