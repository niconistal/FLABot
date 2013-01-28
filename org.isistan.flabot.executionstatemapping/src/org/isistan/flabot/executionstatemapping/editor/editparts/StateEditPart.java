package org.isistan.flabot.executionstatemapping.editor.editparts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.commands.diagram.AddTransitionConditionConnectionCommand;
import org.isistan.flabot.executionstatemapping.commands.diagram.DeleteStateCommand;
import org.isistan.flabot.executionstatemapping.commands.diagram.ModifyNamedElementCommand;
import org.isistan.flabot.executionstatemapping.editor.figures.FinalStateFigure;
import org.isistan.flabot.executionstatemapping.editor.figures.InitialStateFigure;
import org.isistan.flabot.executionstatemapping.editor.figures.StateBoxAnchor;
import org.isistan.flabot.executionstatemapping.editor.figures.StateCellEditorLocator;
import org.isistan.flabot.executionstatemapping.editor.figures.StateFigure;
import org.isistan.flabot.executionstatemapping.editor.properties.StateProperty;
import org.isistan.flabot.executionstatemapping.model.semantic.FinalState;
import org.isistan.flabot.executionstatemapping.model.semantic.NamedElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.StateType;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class StateEditPart extends ConnectedEditPart {

	private DirectEditManager manager;
	
	private void performDirectEdit(){				
		if(manager == null)
			manager = new StateEditManager(
					this, new StateCellEditorLocator((HandleBounds)getFigure()));		
		
		if (getCastedFigure().wasValidClick())
			manager.show();
	}

	@Override
	public void activate() {
		if (!isActive()) {			
			super.activate();						
		}
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	@Override
	public void deactivate() {
		if (isActive()) {						
			super.deactivate();
		}
	}
		
	@Override
	public void performRequest(Request request){
		if (request.getType() == RequestConstants.REQ_OPEN)
			performDirectEdit();
	}
	
	@Override
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				if (getCastedSemanticModel().getStateType() == StateType.INITIAL)
					return null;
				
				CompoundCommand commands = new CompoundCommand();
				if (getSourceConnections().size() > 0)
					commands.add(getConnectionsDeleteCommand(getSourceConnections()));
				if (getTargetConnections().size() > 0)
					commands.add(getConnectionsDeleteCommand(getTargetConnections()));				
				commands.add(new DeleteStateCommand((StateDiagram) getHost().getParent().getModel(), (NodeVisualModel) getHost().getModel()));
				return commands;
			}	
		});
				
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			@Override
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				Object type = request.getNewObjectType();
				if (type == TransitionCondition.class) {
					NodeVisualModel nodeTarget = (NodeVisualModel) getHost().getModel();
					if ( ((State)nodeTarget.getSemanticModel()).getStateType() == StateType.INITIAL)
						return null;
					
					AddTransitionConditionConnectionCommand cmd = (AddTransitionConditionConnectionCommand) request.getStartCommand();
					cmd.setTarget(nodeTarget);
					return cmd;
				} else if (request.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION)) {
					AddNoteConnectionCommand cmd = (AddNoteConnectionCommand) request.getStartCommand();
					cmd.setTarget((NodeVisualModel) getHost().getModel());
					return cmd;
				} 
				
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			@Override
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {	
				if (request.getNewObjectType() == TransitionCondition.class) {
					NodeVisualModel source = (NodeVisualModel) getHost().getModel();
					//Si el nodo es una estado final no puedo agregar source connections.
					if ( ((State) source.getSemanticModel()).getStateType() == StateType.FINAL)
						return null;
					
					StateDiagramEditPart diagram = (StateDiagramEditPart)getHost().getParent();
					AddTransitionConditionConnectionCommand cmd = 
						new AddTransitionConditionConnectionCommand((StateDiagram)diagram.getModel(), source, (ConnectionVisualModel)request.getNewObject());
					request.setStartCommand(cmd);
					return cmd;
				}
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			@Override
			protected Command getReconnectSourceCommand(ReconnectRequest request) {				
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			@Override
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				return null;
			}
		});
				
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {

			/**
			 * @see DirectEditPolicy#getDirectEditCommand(DirectEditRequest)
			 */
			@Override
			protected Command getDirectEditCommand(DirectEditRequest edit) {
				String labelText = (String)edit.getCellEditor().getValue();
				labelText = labelText.replace('\n', ' ');
				labelText = labelText.replace('\r', ' ');
				NodeVisualModel model = (NodeVisualModel)getHost().getModel();
				ModifyNamedElementCommand command = new ModifyNamedElementCommand((NamedElement)model.getSemanticModel(), labelText);
				return command;
			}

			/**
			 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
			 */
			@Override
			protected void showCurrentEditValue(DirectEditRequest request) {
				//hack to prevent async layout from placing the cell editor twice.
				getHostFigure().getUpdateManager().performUpdate();				
			}
			
		});
	}

	/*(non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {		
		
		if (getCastedSemanticModel().getStateType() == StateType.NORMAL)
		{
			StateFigure figure = new StateFigure(
					Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
					Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
					getCastedVisualModel().getLineStyle());
			figure.setText(getCastedSemanticModel().getName());
			return figure;
		}
		
		if (getCastedSemanticModel().getStateType() == StateType.FINAL)
		{
			FinalStateFigure figure = new FinalStateFigure(
					Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
					Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
					getCastedVisualModel().getLineStyle());
			figure.setText(getCastedSemanticModel().getName());
			figure.setFinalStateText(((FinalState)getCastedSemanticModel()).getExecutionState().getInternacionalizedName());
			return figure;	
		}
		
		InitialStateFigure figure = new InitialStateFigure(
					Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
					Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
					getCastedVisualModel().getLineStyle());
			figure.setText(getCastedSemanticModel().getName());
			return figure;
	}
	
	@Override
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
		{
			return new StateProperty((VisualModel)getModel(), getMinBounds().getSize());
		}
		return super.getAdapter(key);
	}
	
	private Rectangle getMinBounds() {
		Dimension size = new Dimension(
				getCastedVisualModel().getSize().getWidth(), 
				getCastedVisualModel().getSize().getHeight()
				);
		Point location = new Point(
				getCastedVisualModel().getLocation().getX(),
				getCastedVisualModel().getLocation().getY()
				);
		
		Rectangle bounds = new Rectangle(location, size)
			.union(getFigure().getMinimumSize());
		
		if (bounds.getSize() != size) {
			getCastedVisualModel().getSize().setWidth(bounds.width);
			getCastedVisualModel().getSize().setHeight(bounds.height);						
		}		
		return bounds;
	}
			
	@Override
	public void notifyChanged(Notification notification) {		
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(SemanticPackage.class);					
			
		if (notification.getNotifier() instanceof State) 
		{
			switch(type) {							
			case Notification.SET:
				switch(featureId) {				
				case SemanticPackage.NAMED_ELEMENT__NAME:
					getCastedFigure().setText(getCastedSemanticModel().getName());
					refreshVisuals();
					break;
				case SemanticPackage.FINAL_STATE__EXECUTION_STATE:
					if (getCastedSemanticModel().getStateType() == StateType.FINAL)
					{
						((FinalStateFigure) getFigure()).setFinalStateText( ((FinalState)getCastedSemanticModel()).getExecutionState().getInternacionalizedName());
						refreshVisuals();
					}
					break;
		
				}			
			}
			return;
		}
		
		//VisualModel
		featureId = notification.getFeatureID(EditormodelPackage.class);				
		switch(type) {
			case Notification.ADD:
			case Notification.REMOVE:
				if (featureId == EditormodelPackage.VISUAL_MODEL__CHILDREN)
					refreshVisuals();
				break;
		}
		super.notifyChanged(notification);
	}
		
	private State getCastedSemanticModel() {
		return (State) getCastedVisualModel().getSemanticModel();
	}
	
	private StateFigure getCastedFigure() {
		return (StateFigure) getFigure();
	}
	
	@Override
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new StateBoxAnchor((HandleBounds)getFigure());
		return anchor;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.				
		Rectangle min = getMinBounds();
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), min);
	}
	

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		CreateConnectionRequest r = (CreateConnectionRequest) request;
		if (r.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION) || r.getNewObjectType() == TransitionCondition.class)
			return getConnectionAnchor();
		return null;
	}
}