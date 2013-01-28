package org.isistan.flabot.executionstatemapping.editor.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.model.semantic.State;
import org.isistan.flabot.executionstatemapping.model.semantic.TransitionCondition;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class StateEditPartFactory implements EditPartFactory
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart,
	 *      java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object modelElement)
	{
		// get EditPart for model element
		EditPart part = getPartForElement(modelElement);
		// store model element in EditPart
		part.setModel(modelElement);
		return part;
	}

	/**
	 * Maps an object to an EditPart.
	 * 
	 * @throws RuntimeException
	 *             if no match was found (programming error)
	 */
	private EditPart getPartForElement(Object modelElement)
	{
		if (modelElement instanceof StateDiagram)
			return new StateDiagramEditPart();

		else if (modelElement instanceof ConnectionVisualModel)
		{
			EObject semanticModel = ((ConnectionVisualModel) modelElement)
					.getSemanticModel();
			if (semanticModel instanceof TransitionCondition)
				return new TransitionConditionConnectionEditPart();
			
			if (semanticModel instanceof Note) 
				return new NoteConnectionEditPart();			 

		} else if (modelElement instanceof VisualModel)
		{

			EObject semanticModel = ((VisualModel) modelElement)
					.getSemanticModel();
			if (semanticModel instanceof State)
				return new StateEditPart();
			
			if (semanticModel instanceof Note) 
				return new NoteEditPart();
			 
		}
		throw new RuntimeException("Can't create part for model element: " //$NON-NLS-1$
				+ ((modelElement != null) ? modelElement.getClass().getName()
						: "null")); //$NON-NLS-1$
	}
}