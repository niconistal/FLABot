/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.Note;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Noted Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.NotedElement#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getNotedElement()
 * @model
 * @generated
 */
public interface NotedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Notes</b></em>' reference list.
	 * The list contents are of type {@link org.isistan.flabot.coremodel.Note}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getNotedElement_Notes()
	 * @model
	 * @generated
	 */
	EList<Note> getNotes();

} // NotedElement
