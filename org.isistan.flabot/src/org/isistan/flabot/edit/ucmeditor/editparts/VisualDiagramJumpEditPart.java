/**
 * $Id: VisualDiagramJumpEditPart.java,v 1.3 2006/03/01 22:26:40 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.ui.IEditorPart;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.ucmeditor.figures.VisualDiagramJumpFigure;
import org.isistan.flabot.messages.Messages;

/**
 * Represents a jump between two use case map diagrams in the map view during the execution of the engine.
 * When a jump between two diagrams occurs, a new jump edit part is connected to the source responsibility node in one diagram, and another is connected to the target responsiblity node in the target diagram.
 * Besides when the user double-click on this edit part, the target diagram is shown.
 * 
 * @author $Author: franco $
 *
 */
public class VisualDiagramJumpEditPart extends ConnectedEditPart {
	
	@Override
	protected void createEditPolicies() {
		//Do nothing
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			// if the component is double-clicked, open its respective map			
			IEditorPart editor = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
			if (editor instanceof FlabotGraphicalEditor) {
				FlabotGraphicalEditor mpEditor = (FlabotGraphicalEditor) editor;
				NodeVisualModel targetNode = getCastedModel().getTargetVisualNode();
				mpEditor.openDiagramAtPosition(getCastedModel().getTargetDiagram(), targetNode.getAbsoluteLocation().getX(), targetNode.getAbsoluteLocation().getY());
			}		
		}
		super.performRequest(req);
	}
	
	
	@Override
	protected IFigure createFigure() {	
		VisualDiagramJumpFigure figure = new VisualDiagramJumpFigure();
		String start = ""; //$NON-NLS-1$
		if (getCastedModel().getTo().booleanValue())
			start = Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.VisualDiagramJumpEditPart.to"); //$NON-NLS-1$
		else
			start = Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.VisualDiagramJumpEditPart.from"); //$NON-NLS-1$
		figure.setText(start.substring(0,1));		 
		 
		SimplePathNode targetResponsibilityNode = (SimplePathNode)getCastedModel().getTargetVisualNode().getSemanticModel();
		Label tooltip = new Label(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.VisualDiagramJumpEditPart.jumpMessage", start,targetResponsibilityNode.getName(), getCastedModel().getTargetDiagram().getName())); //$NON-NLS-1$
		figure.setToolTip(tooltip);
		return figure;
	}
	
	protected VisualDiagramJump getCastedModel() {
		return (VisualDiagramJump) getModel();
	}
	
	/**
	 * Returns the connection anchor of an ellipse
	 * 
	 * @return the connection anchor of an ellipse
	 */
	@Override
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new EllipseAnchor(getFigure());
		return anchor;
	}
}
