package org.isistan.flabot.executionstatemapping.editor.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AutomaticRouter;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.SWT;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editor.commands.AddNoteCommand;
import org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.commands.diagram.AddStateCommand;
import org.isistan.flabot.executionstatemapping.commands.diagram.StateSetConstraintCommand;
import org.isistan.flabot.executionstatemapping.editor.properties.StateDiagramProperty;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;

public class StateDiagramEditPart extends AbstractGraphicalEditPart implements Adapter {
	
	private Notifier target;
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getCastedModel());
			super.activate();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {

		installEditPolicy(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart.snapFeedbakcEditPolicy"), new SnapFeedbackPolicy()); //$NON-NLS-1$
		
		// disallows the removal of this edit part from its parent
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		
		// handles constraint changes (e.g. moving and/or resizing) of model elements
		// and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  new XYLayoutEditPolicy() {

			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {			
				return super.createChildEditPolicy(child);
			}
			
			@Override
			protected Command createAddCommand(EditPart child, Object constraint) {
				return null;
			}
			
			@Override
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
					EditPart child, Object constraint) {
				if (child instanceof StateEditPart && constraint instanceof Rectangle) {
					// return a command that can move and/or resize a Shape
					return new StateSetConstraintCommand((VisualModel) child.getModel(), (Rectangle) constraint);
				} else if (child instanceof NoteEditPart && constraint instanceof Rectangle) {
					return new NoteSetConstraintCommand((VisualModel) child.getModel(), (Rectangle) constraint);
				}
				return super.createChangeConstraintCommand(request, child, constraint);
			}
			
			@Override
			protected Command createChangeConstraintCommand(EditPart child,
					Object constraint) {
				// not used in this example
				return null;
			}
			
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				Object childClass = request.getNewObjectType();
				if (childClass == State.class) {
					return new AddStateCommand( (NodeVisualModel) request.getNewObject(),
													(StateDiagram) getHost().getModel(), 
							                        (Rectangle)getConstraintFor(request));
				} 
				if (childClass == Note.class) {
					return new AddNoteCommand( (NodeVisualModel) request.getNewObject(), 
											   (StateDiagram) getHost().getModel(), 
							                   (Rectangle)getConstraintFor(request));
				}
				return null;
			}
			
			@Override
			protected Command getDeleteDependantCommand(Request request) {
				return null;
			}
			
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure f = new FreeformLayer();
		f.setBorder(new MarginBorder(3));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	@Override
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getCastedModel());
			super.deactivate();
		}
	}
	
	private StateDiagram getCastedModel() {
		return (StateDiagram) getModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List getModelChildren() {
		return getCastedModel().getChildren();
	}
	

	private void hookIntoModel(EObject model) {
		if(model != null) {
			model.eAdapters().add(this);
		}
	}

	private void unhookFromModel(EObject model) {
		if(model != null) {
			model.eAdapters().remove(this);
		}
	}

	public void notifyChanged(Notification notification) {
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(VisualPackage.class);		

		if(type == Notification.ADD || type == Notification.REMOVE) 
		{
			switch(featureId) {
			case VisualPackage.STATE_DIAGRAM__CHILDREN:
				refreshChildren();
				break;
			}
		}
	}
		
	@Override
	protected void refreshVisuals() {
		ConnectionLayer cLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		if (!SWT.getPlatform().startsWith("gtk")) // workaround for bug 0000648 //$NON-NLS-1$
			cLayer.setAntialias(SWT.ON);

		AutomaticRouter router = new FanRouter();
		router.setNextRouter(new BendpointConnectionRouter());
		cLayer.setConnectionRouter(router);
	}
	
	public Notifier getTarget() {
		return target;
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public boolean isAdapterForType(Object type) {
		return (getModel().getClass() == type);
	}
	
	@Override
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new StateDiagramProperty((StateDiagram)getModel());
		
		if (key == SnapToHelper.class) {
			List<SnapToHelper> snapStrategies = new ArrayList<SnapToHelper>();
			Boolean val = (Boolean)getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGeometry(this));
			val = (Boolean)getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGrid(this));
			
			if (snapStrategies.size() == 0)
				return null;
			if (snapStrategies.size() == 1)
				return snapStrategies.get(0);

			SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
			for (int i = 0; i < snapStrategies.size(); i++)
				ss[i] = (SnapToHelper)snapStrategies.get(i);
			return new CompoundSnapToHelper(ss);
		}
		return super.getAdapter(key);
	}
}