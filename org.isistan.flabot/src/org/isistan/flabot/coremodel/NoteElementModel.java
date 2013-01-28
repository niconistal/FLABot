/** * $Id: NoteElementModel.java,v 1.4 2006/01/27 00:09:14 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.coremodel;

import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;/**
 * @model
 */
public interface NoteElementModel extends EObject {

	/**
	 * @model type="Note"
	 */
	EList getNotes();
}
