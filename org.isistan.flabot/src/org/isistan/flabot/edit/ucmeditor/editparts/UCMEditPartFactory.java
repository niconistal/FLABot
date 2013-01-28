/**

import org.eclipse.emf.ecore.EObject;

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
				return new NoteConnectionEditPart();
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
				return new JoinNodeEditPart();
			if (semanticModel instanceof ResponsibilityNode)
				return new ResponsibilityNodeEditPart();
			if (semanticModel instanceof PathNode)
				return new PathNodeEditPart();
			if (semanticModel instanceof Note)
				return new NoteEditPart();
		}
		
		throw new RuntimeException(
			"Can't create part for model element: " //$NON-NLS-1$
			+ ((model != null) ? model.getClass().getName() : "null")); //$NON-NLS-1$
	}
}