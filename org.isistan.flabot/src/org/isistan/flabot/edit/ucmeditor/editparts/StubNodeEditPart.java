/**
 * $Id: StubNodeEditPart.java,v 1.19 2006/03/21 02:34:08 franco Exp $
 * $Header: /var/cvsroot/org.isistan.flabot/src/org/isistan/flabot/edit/ucmeditor/editparts/StubNodeEditPart.java,v 1.19 2006/03/21 02:34:08 franco Exp $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.properties.NamedElementPropertySource;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteStubCommand;
import org.isistan.flabot.edit.ucmeditor.figures.StubFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * StubNodeEditPart:
 * -	Edit part for Stub Nodes.
 * -	Hooks into CoreModel events and gets notified when the map of the stub is deleted, the stub is deleted too.
 * -	Hooks into start and end point references events and gets notified when their names is changed, the figure of the stub is updated.
 * -	Creates the figure that represents the stub using StubFigure.
 * 
 * @author $Author: franco $
 *
 */
public class StubNodeEditPart extends PathNodeEditPart {
	
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			if (getCastedModel().getDiagram() != null)
				hookIntoModel(getCastedModel().getDiagram().getCoreModel());
						
			StubNode stub = (StubNode) getCastedModel().getSemanticModel(); 
			hookIntoModel(stub.getStartPointReference());
			hookIntoModel(stub.getEndPointReference());
			if (stub.getStartPointReference() != null)
				hookIntoModel(stub.getStartPointReference().getPath());
			super.activate();
		}
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			if (getCastedModel().getDiagram() != null)
				unhookFromModel(getCastedModel().getDiagram().getCoreModel());
			StubNode stub = (StubNode) getCastedModel().getSemanticModel();
			unhookFromModel(stub.getStartPointReference());
			unhookFromModel(stub.getEndPointReference());
			if (stub.getStartPointReference() != null)
				unhookFromModel(stub.getStartPointReference().getPath());
			super.deactivate();
		}
	}
	
	@Override
	protected IFigure createFigure() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) getParent();
		if (getCastedModel().getParent() != null)
			part = (AbstractGraphicalEditPart)part.getParent();
		StubFigure f = new StubFigure(
				Util.getSWTRGB(getCastedModel().getForegroundColor()),
				part.getFigure(),
				getCastedModel()
				);		
		
		StubNode stub = (StubNode) getCastedModel().getSemanticModel();
		f.setNamePoint(stub.getName());		
		updateInText(stub.getStartPointReference(), f);		
		updateOutText(stub.getEndPointReference(), f);		
		return f;
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#performRequest(org.eclipse.gef.Request)
	 */
	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			// if the stub is double-clicked, open its respective use case map diagram
			if (getViewer().getEditDomain() instanceof DefaultEditDomain) {
				IEditorPart editor = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
				FlabotGraphicalEditor mpEditor = (FlabotGraphicalEditor) editor;
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				Diagram diagram = getCorrectDiagram(getCastedModel().getDiagram().getCoreModel().getFile(), stub.getReferencedMap());
				if (diagram != null) {
					List selection = new ArrayList();
					selection.add(getVisualForModel(diagram.getChildren(), stub.getStartPointReference()));
					selection.add(getVisualForModel(diagram.getChildren(), stub.getEndPointReference()));
					mpEditor.openDiagramAndSelect(diagram, selection);
				} else
					MessageDialog.openError(Display.getCurrent().getActiveShell(),
							Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart.errorDialogName"), Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart.errorDialogDescription")); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		super.performRequest(req);
	}

	
	private Diagram getCorrectDiagram(FlabotFileModel model, UseCaseMap map) {
		for(Iterator iter=model.getDiagrams().iterator(); iter.hasNext();) {
			Diagram d = (Diagram) iter.next();
			if (d instanceof UCMDiagram) {
				if (((UCMDiagram)d).getMap() == map)
					return d;
			}
		}
		return null;
	}
	
	private VisualModel getVisualForModel(List children, Object model) {
		VisualModel retVisual = null;
		for (Iterator iter=children.iterator(); iter.hasNext() && retVisual == null;) {
			VisualModel visual = (VisualModel) iter.next();
			if (visual.getSemanticModel() == model)
				retVisual = visual;
			else
				retVisual = getVisualForModel(visual.getChildren(), model);
		}		
		return retVisual;
	}
	
	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {
		
		int featureID = notification.getFeatureID(CoremodelPackage.class);
		
		if (notification.getNotifier() instanceof CoreModel) {					
			if (notification.getEventType() == Notification.REMOVE && featureID == CoremodelPackage.CORE_MODEL__STUBS) {
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				if (notification.getOldValue() == stub)
					forceDeleteStub();
				return;
			}
			
			if (notification.getEventType() == Notification.REMOVE &&  featureID == CoremodelPackage.CORE_MODEL__USE_CASE_MAPS) {
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				if (notification.getOldValue() == stub.getMap() || notification.getOldValue() == stub.getReferencedMap())
					forceDeleteStub();
				return;
			}
			
			return;
		}
				
		if (notification.getNotifier() instanceof Path) {
			if (notification.getEventType() == Notification.REMOVE && featureID == CoremodelPackage.PATH__NODES) {
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				if (notification.getOldValue() == stub.getStartPointReference() || notification.getOldValue() == stub.getEndPointReference())
					forceDeleteStub();
				return;
			}
			
			if (notification.getEventType() == Notification.REMOVE && featureID == CoremodelPackage.PATH__END_NODES) {
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				if (notification.getOldValue() == stub.getEndPointReference())
					forceDeleteStub();
				return;
			}
			
			return;
		}		
		
		super.notifyChanged(notification);
		
		if (notification.getNotifier() instanceof StubNode) {					
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.STUB_NODE__START_POINT_REFERENCE) {
				registerNewNode((SimplePathNode) notification.getOldValue(), (SimplePathNode) notification.getNewValue());
				updateInText((SimplePathNode) notification.getNewValue(), getCastedFigure());
			}
						
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.STUB_NODE__END_POINT_REFERENCE) {
				registerNewNode((SimplePathNode) notification.getOldValue(), (SimplePathNode) notification.getNewValue());
				updateOutText((SimplePathNode) notification.getNewValue(), getCastedFigure());
			}
			return;
		}
		
		if (notification.getNotifier() instanceof SimplePathNode) {
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.SIMPLE_PATH_NODE__NAME) {
				StubNode stub = (StubNode) getCastedModel().getSemanticModel();
				if (notification.getNotifier() == stub.getStartPointReference())
					updateInText((SimplePathNode) notification.getNotifier(), getCastedFigure());
				else
					updateOutText((SimplePathNode) notification.getNotifier(), getCastedFigure());
				getCastedFigure().setNamePoint(stub.getName());
			}
			return;
		}		
	}
		
	private void forceDeleteStub() {
		//if the stub is still in a diagram
		if (getCastedModel().getDiagram() != null && getParent() != null)
			appendToLastAndExecuteCommand(getDeletePathNodeCommand());
	}
	
	protected Command getDeletePathNodeCommand()  {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart.commandLabel"));		 //$NON-NLS-1$
		commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		commands.add(new DeleteStubCommand(getCastedModel()));
		return commands;
	}
	
	private void updateInText(SimplePathNode node, StubFigure figure) {
		if (node != null)
			figure.setInText(node.getName());
	}
	
	private void updateOutText(SimplePathNode node, StubFigure figure) {
		if (node != null)
			figure.setOutText(node.getName());
	}

	private StubFigure getCastedFigure() {
		return (StubFigure) getFigure();
	}
	
	private void registerNewNode(SimplePathNode oldNode, SimplePathNode newNode) {
		if (oldNode != newNode) {			
			unhookFromModel(oldNode);
			hookIntoModel(newNode);
			
			Path oldPath = null;
			if (oldNode != null) oldPath = oldNode.getPath();
			Path newPath = null;
			if (newNode != null) newPath = newNode.getPath();		
			
			if (oldPath != newPath){
				hookIntoModel(oldPath);
				unhookFromModel(newPath);				
			}
		}				
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart.namePropertyView"), (StubNode)getCastedModel().getSemanticModel()); //$NON-NLS-1$
		return super.getAdapter(key);
	}
}