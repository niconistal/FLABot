/**
 * $Id: SequenceViewFactory.java,v 1.1 2006/03/29 20:21:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.sequenceview.editparts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

/**
 * The factory used for the edit parts in the Sequence View.
 * 
 * @author $Author: franco $
 *
 */
public class SequenceViewFactory implements EditPartFactory {
	
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
	 * Maps an object to an EditPart. In this view only one edit part is used SequenceViewEditPart 
	 */
	private EditPart getPartForElement(Object modelElement) {			
		return new SequenceViewEditPart(); 						
	}
}