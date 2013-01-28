/**
 * $Id: UCMDiagramEditPart.java,v 1.44 2006/03/30 01:38:59 franco Exp $
 */

package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AutomaticRouter;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.FlabotCommandStack;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.commands.AddNoteCommand;
import org.isistan.flabot.edit.editor.commands.DeleteDiagramCommand;
import org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.multipage.dnd.ComponentDropListener;
import org.isistan.flabot.edit.multipage.dnd.DropComponentRoleFactory;
import org.isistan.flabot.edit.ucmeditor.commands.DeleteUCMDiagramCommand;
import org.isistan.flabot.edit.ucmeditor.commands.model.ModifyUseCaseMapLevelInfoCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.ComponentSetConstraintCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertComponentRoleCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeCreateCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeReparentCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeSetConstraintCommand;
import org.isistan.flabot.edit.ucmeditor.figures.CurveDiagramLayer;
import org.isistan.flabot.edit.ucmeditor.properties.MapPropertySource;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * The root edit part for the diagram
 * 
 * UCMDiagramEditPart:
 * -	Edit part for visual model class UCMDiagram.
 * -	Hooks into UCMDiagram, CoreModel and FlabotFileModel events and gets notified of changes referring to the diagram deletion to destroy itself. All event received are rippled to its children edit parts.
 * -	Creates the figure that represents the diagram using CurveDiagramLayer.
 * -	Provides an adapter for IPropertySource class instantiating MapPropertySource.
 * 
 * @author $Author: franco $
 *
 */
public class UCMDiagramEditPart extends AbstractGraphicalEditPart
	implements Adapter {
	
	private Notifier target;
	private ComponentDropListener dropListener;
	
	UCMDiagram getCastedModel() {
		return (UCMDiagram)getModel();
	}
	
	private ComponentDropListener getDropListener() {
		if (dropListener == null)
			dropListener = new ComponentDropListener(getViewer(), new DropComponentRoleFactory(getCastedModel().getCoreModel().getFile()));
		return dropListener;
	}
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {		
		if (!isActive()) {			
			getViewer().addDropTargetListener(getDropListener());
			getCastedModel().getCoreModel().eAdapters().add(this);
			getCastedModel().getCoreModel().getFile().eAdapters().add(this);
			getCastedModel().eAdapters().add(this);
			super.activate();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		IFigure f = new CurveDiagramLayer();
		f.setBorder(new MarginBorder(3));
		f.setLayoutManager(new FreeformLayout());
		return f;
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			getViewer().removeDropTargetListener(getDropListener());
			getCastedModel().eAdapters().remove(this);
			getCastedModel().getCoreModel().eAdapters().remove(this);
			getCastedModel().getCoreModel().getFile().eAdapters().remove(this);
			super.deactivate();			
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		installEditPolicy(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart.snapFeedbackEditPolicy"), new SnapFeedbackPolicy()); //$NON-NLS-1$
		
		// handles constraint changes (e.g. moving and/or resizing) of model elements
		// and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  new UCMXYLayoutEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	protected List getModelChildren() {
		return getCastedModel().getChildren(); // return a list of visual models
	}
	
	/**
	 * @see GraphicalEditPart#setLayoutConstraint(EditPart, IFigure, Object)
	 */
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		super.setLayoutConstraint(child, childFigure, constraint);
		
		Object semantic = ((NodeVisualModel)child.getModel()).getSemanticModel();
		if (semantic instanceof PathNode) {			
			PathNode node = (PathNode)((NodeVisualModel)child.getModel()).getSemanticModel();
			if (semantic != null && node.getPath() != null)
				((CurveDiagramLayer) getFigure()).updateInicial(getChildren(), node.getPath().getStartNodes(), node.getPath().getEndNodes());
		}
		getFigure().repaint();		
	}
	
	
	
	/**
	 * Adapter implementation
	 */
	public void notifyChanged(Notification notification) {

		if (notification.getNotifier() instanceof CoreModel) {
			int featureID = notification.getFeatureID(CoremodelPackage.class);
			if (notification.getEventType() == Notification.REMOVE && 
					featureID == CoremodelPackage.CORE_MODEL__USE_CASE_MAPS) {
				if (notification.getOldValue() == getCastedModel().getMap() && getCastedModel().getCoreModel().getFile().getDiagrams().contains(getCastedModel())) {
					closeDiagram();
					appendToLastAndExecuteCommand(new DeleteDiagramCommand(getCastedModel().getCoreModel().getFile(), getCastedModel()));
				}
			
			}
			
			if (notification.getEventType() == Notification.SET &&
					featureID == CoremodelPackage.USE_CASE_MAP__LEVEL_INFO) {
				if (notification.getOldValue() != notification.getNewValue())
					appendToLastAndExecuteCommand(new ModifyUseCaseMapLevelInfoCommand(getCastedModel().getCoreModel(),getCastedModel().getMap()));
			}			
			return;		
		}
		
		if (notification.getNotifier() instanceof FlabotFileModel) {
			int featureID = notification.getFeatureID(EditormodelPackage.class);
			if (notification.getEventType() == Notification.REMOVE && 
				featureID == EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS) {
				if (notification.getOldValue() == getCastedModel()) {
					closeDiagram();
					appendToLastAndExecuteCommand(new DeleteUCMDiagramCommand(this));
				}
			}
			return;	
		}
				
		switch (notification.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
			case Notification.MOVE:
				refreshChildren();
				break;
		}		
	}

	protected void appendToLastAndExecuteCommand(Command command) {
		FlabotCommandStack commandStack = (FlabotCommandStack)
			getViewer().getEditDomain().getCommandStack();
		commandStack.appendToLastAndExecute(command);
	}
	
	private FlabotGraphicalEditor getEditor() {
		IEditorPart editor = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
		if (editor instanceof FlabotGraphicalEditor)
			return (FlabotGraphicalEditor) editor;
		
		return null;
	}
	
	private void closeDiagram() {
		FlabotGraphicalEditor editor = getEditor();
		if (editor != null)
			editor.closeDiagram(getCastedModel());
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
	
	protected void refreshVisuals() {
		ConnectionLayer cLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		if (!SWT.getPlatform().startsWith("gtk")) // workaround for bug 0000648 //$NON-NLS-1$
			cLayer.setAntialias(SWT.ON);

		AutomaticRouter router = new FanRouter();
		router.setNextRouter(new BendpointConnectionRouter());
		cLayer.setConnectionRouter(router);
	}
	
	/**
	 * EditPolicy for the Figure used by this edit part.
	 */
	private class UCMXYLayoutEditPolicy extends XYLayoutEditPolicy {

		@Override
		protected EditPolicy createChildEditPolicy(EditPart child) {
			if (child instanceof PathNodeEditPart || child instanceof VisualDiagramJumpEditPart)
				return new NonResizableEditPolicy();
			
			return super.createChildEditPolicy(child);
		}

		@Override
		protected Command createAddCommand(EditPart child, Object constraint) {
			if (child.getModel() instanceof NodeVisualModel && constraint instanceof Rectangle) {
				NodeVisualModel visual = (NodeVisualModel) child.getModel();
				if (visual.getSemanticModel() instanceof PathNode && !(visual.getSemanticModel() instanceof ResponsibilityNode)) {
					VisualModel parent = visual.getParent();
					if (!insideParent(parent, (Rectangle) constraint))
						return new PathNodeReparentCommand(null, visual, (Rectangle) constraint);
					else
						return getSetConstraintCommand(visual, (Rectangle) constraint);
				}
			}
			return null;
		}
		
		private Command getSetConstraintCommand(NodeVisualModel visual, Rectangle constraint) {
			Rectangle rectangle = constraint.getCopy();
			rectangle.x -= visual.getParent().getLocation().getX();
			rectangle.y -= visual.getParent().getLocation().getY();
			
			return new PathNodeSetConstraintCommand(visual, rectangle);
		}
		
		private boolean insideParent(VisualModel parent, Rectangle constraint) {
			if (parent != null) {
				Point location = Util.getDraw2DPoint(parent.getLocation());
				Dimension dimension = Util.getDraw2DDimension(parent.getSize());
				return (constraint.x >= location.x && constraint.x <= location.x + dimension.width && 
						constraint.y >= location.y && constraint.y <= location.y + dimension.height);
			}
			return false;
		}
		
		@Override
		protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
				EditPart child, Object constraint) {
			if (constraint instanceof Rectangle) {
				// return a command that can move and/or resize a Component
				if (child instanceof ComponentEditPart)
					return new ComponentSetConstraintCommand((NodeVisualModel)child.getModel(), (Rectangle)constraint);
				
				// return a command that can move and/or resize a PathNode
				if (child instanceof PathNodeEditPart || child instanceof VisualDiagramJumpEditPart)				
					return new PathNodeSetConstraintCommand((NodeVisualModel)child.getModel(), (Rectangle)constraint);
				
				// return a command that can move and/or resize a Note
				if (child instanceof NoteEditPart)
					return new NoteSetConstraintCommand((VisualModel) child.getModel(), (Rectangle) constraint);
			}							
			return super.createChangeConstraintCommand(request, child, constraint);
		}

		@Override
		protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
			// not used
			return null;
		}

		@Override
		protected Command getCreateCommand(CreateRequest request) {
			Class childClass = (Class) request.getNewObjectType();
			if (childClass == ComponentRole.class) {
				return new InsertComponentRoleCommand((NodeVisualModel)request.getNewObject(), 
						(UCMDiagram)getHost().getModel(), (Rectangle)getConstraintFor(request));
			}
			if (childClass == PathNode.class) {
				// find the currently selected node
				NodeVisualModel selectedNode = null;
				List selectedEditParts = getHost().getViewer().getSelectedEditParts();
				if (selectedEditParts.size()>0) {
					EditPart editPart = (EditPart) selectedEditParts.get(selectedEditParts.size()-1);
					if (editPart instanceof PathNodeEditPart)
						selectedNode = (NodeVisualModel) editPart.getModel();
				}
				//
				return new PathNodeCreateCommand((NodeVisualModel)request.getNewObject(),
						(Rectangle)getConstraintFor(request),
						selectedNode, (UCMDiagram)getHost().getModel());			
			}
			if (childClass == Note.class) {
				return new AddNoteCommand( (NodeVisualModel) request.getNewObject(),
										   (Diagram) getHost().getModel(), 
						                   (Rectangle)getConstraintFor(request));
			}
			return null;
		}

		@Override
		protected Command getDeleteDependantCommand(Request request) {
			// do nothing for now
			return null;
		}
		
	}
	
	@Override
	public Object getAdapter(Class key) {
		if (IPropertySource.class.isAssignableFrom(key)) {
			return new MapPropertySource(getCastedModel());
		}
		
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