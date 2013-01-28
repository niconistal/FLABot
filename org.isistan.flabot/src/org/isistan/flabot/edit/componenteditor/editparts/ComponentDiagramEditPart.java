/**
 * $Id: ComponentDiagramEditPart.java,v 1.40 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.editparts;

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
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.SWT;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.componenteditor.commands.DeleteComponentDiagramCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddComponentCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.ComponentSetConstraintCommand;
import org.isistan.flabot.edit.componenteditor.properties.ComponentDiagramProperty;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.FlabotCommandStack;
import org.isistan.flabot.edit.editor.commands.AddNoteCommand;
import org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.multipage.dnd.ComponentDropFactory;
import org.isistan.flabot.edit.multipage.dnd.ComponentDropListener;
import org.isistan.flabot.messages.Messages;

/**
 * ComponentDiagramEditPart
 * -	Edit part for visual model class ComponentDiagram.
 * -	Hooks into ComponentDiagram and FlabotFileModel events and gets notified of changes referring to the diagram deletion to destroy itself. All event received are rippled to its children edit parts.
 * -	Creates the figure that represents the diagram using ComponentDiagram.
 * -	Provides an adapter for IPropertySource class instantiating ComponentDiagramProperty.
 *
 * @author $Author: franco $
 *
 */
public class ComponentDiagramEditPart extends AbstractGraphicalEditPart implements Adapter {
	
	private Notifier target;	
	private ComponentDropListener dropListener;
	
	private ComponentDropListener getDropListener() {
		if (dropListener == null)
			dropListener = new ComponentDropListener(getViewer(), new ComponentDropFactory(getCastedModel().getCoreModel().getFile()));
		return dropListener;
	}	
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			hookIntoModel(getCastedModel().getCoreModel().getFile());
			hookIntoModel(getCastedModel());
			getViewer().addDropTargetListener(getDropListener());
			super.activate();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {

		installEditPolicy(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart.snapFeedbakcEditPolicy"), new SnapFeedbackPolicy()); //$NON-NLS-1$
		
		// handles constraint changes (e.g. moving and/or resizing) of model elements
		// and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  new XYLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {			
				return super.createChildEditPolicy(child);
			}
			
			protected Command createAddCommand(EditPart child, Object constraint) {
				return null;
			}
			
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
					EditPart child, Object constraint) {
				if (child instanceof ComponentEditPart && constraint instanceof Rectangle) {
					// return a command that can move and/or resize a Shape
					return new ComponentSetConstraintCommand((VisualModel) child.getModel(), (Rectangle) constraint);
				} else if (child instanceof NoteEditPart && constraint instanceof Rectangle) {
					return new NoteSetConstraintCommand((VisualModel) child.getModel(), (Rectangle) constraint);
				}
				return super.createChangeConstraintCommand(request, child, constraint);
			}
			
			protected Command createChangeConstraintCommand(EditPart child,
					Object constraint) {
				// not used in this example
				return null;
			}
			
			protected Command getCreateCommand(CreateRequest request) {
				Object childClass = request.getNewObjectType();
				if (childClass == ComponentModel.class) {
					return new AddComponentCommand( (NodeVisualModel) request.getNewObject(),
													(ComponentDiagram) getHost().getModel(), 
							                        (Rectangle)getConstraintFor(request));
				} 
				if (childClass == Note.class) {
					return new AddNoteCommand( (NodeVisualModel) request.getNewObject(), 
											   (ComponentDiagram) getHost().getModel(), 
							                   (Rectangle)getConstraintFor(request));
				}
				return null;
			}
			
			protected Command getDeleteDependantCommand(Request request) {
				return null;
			}
			
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		IFigure f = new FreeformLayer();
		f.setBorder(new MarginBorder(3));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(getCastedModel().getCoreModel().getFile());
			unhookFromModel(getCastedModel());
			getViewer().removeDropTargetListener(getDropListener());
			super.deactivate();
		}
	}
	
	private ComponentDiagram getCastedModel() {
		return (ComponentDiagram) getModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
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
		int featureId = notification.getFeatureID(EditormodelPackage.class);
		if(type == Notification.REMOVE) {
			switch(featureId) {
			case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
				if (notification.getOldValue() == getCastedModel())
					appendToLastAndExecuteCommand(new DeleteComponentDiagramCommand(this));

				break;
			}
		}
		
		if(type == Notification.ADD || type == Notification.REMOVE) {
			switch(featureId) {
			case EditormodelPackage.DIAGRAM__CHILDREN:
				refreshChildren();
				break;
			}
		}
	}
	
	protected void appendToLastAndExecuteCommand(Command command) {
		FlabotCommandStack commandStack = (FlabotCommandStack)
			getViewer().getEditDomain().getCommandStack();
		commandStack.appendToLastAndExecute(command);
		
		FlabotPlugin.getDefault().getLogger()
		.warn(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart.warmMessage", command.getLabel(), commandStack.getCurrentCommandLabel())); //$NON-NLS-1$
	}
	
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
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new ComponentDiagramProperty((ComponentDiagram)getModel());
		
		if (key == SnapToHelper.class) {
			List snapStrategies = new ArrayList();
			Boolean val = (Boolean)getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGeometry(this));
			val = (Boolean)getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGrid(this));
			
			if (snapStrategies.size() == 0)
				return null;
			if (snapStrategies.size() == 1)
				return (SnapToHelper)snapStrategies.get(0);

			SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
			for (int i = 0; i < snapStrategies.size(); i++)
				ss[i] = (SnapToHelper)snapStrategies.get(i);
			return new CompoundSnapToHelper(ss);
		}
		return super.getAdapter(key);
	}
}