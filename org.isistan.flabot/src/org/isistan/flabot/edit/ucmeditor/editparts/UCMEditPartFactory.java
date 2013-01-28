/** * $Id: UCMEditPartFactory.java,v 1.11 2006/03/21 02:34:07 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.emf.ecore.EObject;import org.eclipse.gef.EditPart;import org.eclipse.gef.EditPartFactory;import org.isistan.flabot.coremodel.ComponentRole;import org.isistan.flabot.coremodel.Condition;import org.isistan.flabot.coremodel.DirectionArrowNode;import org.isistan.flabot.coremodel.DynamicStubNode;import org.isistan.flabot.coremodel.ForkNode;import org.isistan.flabot.coremodel.JoinNode;import org.isistan.flabot.coremodel.Note;import org.isistan.flabot.coremodel.Path;import org.isistan.flabot.coremodel.PathNode;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.coremodel.StubNode;import org.isistan.flabot.coremodel.TimerNode;import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;import org.isistan.flabot.edit.editor.editparts.NoteEditPart;import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.VisualDiagramJump;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.edit.ucmmodel.UCMDiagram;public class UCMEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		// get EditPart for model element
		EditPart part = getPartForElement(model);
		// store model element in EditPart
		part.setModel(model);
		return part;
	}

	private EditPart getPartForElement(Object model) {
		if (model instanceof UCMDiagram)
			return new UCMDiagramEditPart();
		
		if (model instanceof ConnectionVisualModel) {
			EObject semanticModel = ((VisualModel)model).getSemanticModel();
			if (semanticModel instanceof Path)
				return new PathSegmentEditPart();
			if (semanticModel instanceof Note)
				return new NoteConnectionEditPart();			if (semanticModel instanceof Condition)				return new ConditionConnectionEditPart();
		}
		
		if (model instanceof NodeVisualModel) {
			// since many semantic models may have the same visual model
			// but different editparts and figures, further discrimination is
			// required to create the right EditPart
			EObject semanticModel = ((VisualModel)model).getSemanticModel();
			if (semanticModel instanceof ComponentRole)
				return new ComponentEditPart();
			if (semanticModel instanceof ForkNode)
				return new ForkNodeEditPart();
			if (semanticModel instanceof JoinNode)
				return new JoinNodeEditPart();			if (semanticModel instanceof TimerNode)				return new TimerNodeEditPart();			if (semanticModel instanceof DirectionArrowNode)				return new DirectionArrowNodeEditPart();			if (semanticModel instanceof StubNode)				return new StubNodeEditPart();			if (semanticModel instanceof DynamicStubNode)				return new DynamicStubNodeEditPart();
			if (semanticModel instanceof ResponsibilityNode)
				return new ResponsibilityNodeEditPart();
			if (semanticModel instanceof PathNode)
				return new PathNodeEditPart();
			if (semanticModel instanceof Note)
				return new NoteEditPart();
		}
				if (model instanceof VisualDiagramJump)			return new VisualDiagramJumpEditPart();		
		throw new RuntimeException(
			"Can't create part for model element: " //$NON-NLS-1$
			+ ((model != null) ? model.getClass().getName() : "null")); //$NON-NLS-1$
	}
}