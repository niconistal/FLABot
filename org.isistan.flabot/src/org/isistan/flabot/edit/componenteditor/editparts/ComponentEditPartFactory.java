/**
 * $Id: ComponentEditPartFactory.java,v 1.8 2006/01/25 01:14:48 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.componenteditor.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.VisualModel;

public class ComponentEditPartFactory implements EditPartFactory {
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object modelElement) {
		// get EditPart for model element
		EditPart part = getPartForElement(modelElement);
		// store model element in EditPart
		part.setModel(modelElement);
		return part;
	}
	
	/**
	 * Maps an object to an EditPart. 
	 * @throws RuntimeException if no match was found (programming error)
	 */
	private EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof ComponentDiagram)
			return new ComponentDiagramEditPart();
		
		else if (modelElement instanceof ConnectionVisualModel) {
			EObject semanticModel = ((ConnectionVisualModel) modelElement).getSemanticModel();
			if (semanticModel instanceof Relationship)
				return new RelationshipConnectionEditPart();
			if (semanticModel instanceof InterfaceLink)
				return new InterfaceConnectionEditPart();
			if (semanticModel instanceof Note)
				return new NoteConnectionEditPart();

		} else if (modelElement instanceof VisualModel) {
			
			EObject semanticModel = ((VisualModel) modelElement).getSemanticModel();
			if (semanticModel instanceof ComponentModel)
				return new ComponentEditPart();
			if (semanticModel instanceof PortModel)
				return new PortEditPart();
			if (semanticModel instanceof InterfaceModel) {
				InterfaceModel interfaceModel = (InterfaceModel) semanticModel;
				PortModel portModel = (PortModel) ((VisualModel) modelElement).getParent().getSemanticModel();
				if (portModel.getProvideds().contains(interfaceModel))
					return new ProvidedInterfaceEditPart();
				if (portModel.getRequireds().contains(interfaceModel))
					return new RequiredInterfaceEditPart();		
			} 
			if (semanticModel instanceof Note)
				return new NoteEditPart(); 						
		}
		throw new RuntimeException(
				"Can't create part for model element: " //$NON-NLS-1$
				+ ((modelElement != null) ? modelElement.getClass().getName() : "null")); //$NON-NLS-1$
	}
}