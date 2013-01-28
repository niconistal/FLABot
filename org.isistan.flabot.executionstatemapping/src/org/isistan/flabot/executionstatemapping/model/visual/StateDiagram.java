/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual;

import org.eclipse.emf.ecore.EObject;

import org.isistan.flabot.edit.editormodel.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.visual.StateDiagram#getSemanticModel <em>Semantic Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.executionstatemapping.model.visual.VisualPackage#getStateDiagram()
 * @model
 * @generated
 */
public interface StateDiagram extends Diagram {
	/**
	 * Returns the value of the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantic Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Model</em>' reference.
	 * @see #setSemanticModel(EObject)
	 * @see org.isistan.flabot.executionstatemapping.model.visual.VisualPackage#getStateDiagram_SemanticModel()
	 * @model
	 * @generated
	 */
	EObject getSemanticModel();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.visual.StateDiagram#getSemanticModel <em>Semantic Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantic Model</em>' reference.
	 * @see #getSemanticModel()
	 * @generated
	 */
	void setSemanticModel(EObject value);

} // StateDiagram
