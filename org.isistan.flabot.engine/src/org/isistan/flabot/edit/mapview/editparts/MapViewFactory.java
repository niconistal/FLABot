/**
 * $Id: MapViewFactory.java,v 1.8 2006/03/21 03:18:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.editparts.ConditionConnectionEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.ForkNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.JoinNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.PathSegmentEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.ResponsibilityNodeEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.StubNodeEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;

/**
 * @author $Author: franco $
 *
 */
public class MapViewFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		// get EditPart for model element
		EditPart part = getPartForElement(model);
		// store model element in EditPart
		part.setModel(model);
		return part;
	}

	private EditPart getPartForElement(Object model) {
		if (model instanceof UCMDiagram)
			return new MapViewDiagramEditPart();
		
		
		if (model instanceof VisualDiagramJump)
			return new MapViewVisualJumpEditPart();
		
		if (model instanceof ConnectionVisualModel) {
			EObject semanticModel = ((VisualModel)model).getSemanticModel();
			if (semanticModel instanceof Path)
				return new PathSegmentEditPart();
			if (semanticModel instanceof Note)
				return new NoteConnectionEditPart();
			
			return new ConditionConnectionEditPart();
		}
		
		if (model instanceof NodeVisualModel) {
			// since many semantic models may have the same visual model
			// but different editparts and figures, further discrimination is
			// required to create the right EditPart
			EObject semanticModel = ((VisualModel)model).getSemanticModel();
			if (semanticModel instanceof ComponentRole)
				return new MapViewComponentEditPart(); 
			if (semanticModel instanceof ForkNode)
				return new ForkNodeEditPart();
			if (semanticModel instanceof JoinNode)
				return new JoinNodeEditPart();
			if (semanticModel instanceof ResponsibilityNode)
				return new ResponsibilityNodeEditPart();
			if (semanticModel instanceof StubNode)
				return new StubNodeEditPart();
			if (semanticModel instanceof PathNode)
				return new PathNodeEditPart();
			if (semanticModel instanceof Note)
				return new NoteEditPart();
			
			return new EllipseEditPart();				
		}

		
		
		throw new RuntimeException(
			"Can't create part for model element:" //$NON-NLS-1$
			+ ((model != null) ? model.getClass().getName() : "null")); //$NON-NLS-1$
	}
}