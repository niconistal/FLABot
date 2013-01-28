/**
 * $Id: VisualDiagramJump.java,v 1.1 2006/02/21 00:46:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editormodel;

/**
 * VisualDiagramJump
 * -	Extends NodeVisualModel.
 * -	Represents a visual model that is a visual jump between two different diagrams.
 * 
 * @author $Author: franco $
 * @model
 */
public interface VisualDiagramJump extends NodeVisualModel{
	
	/**
	 * @model
	 */
	Diagram getSourceDiagram();
	
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getSourceDiagram <em>Source Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Diagram</em>' reference.
	 * @see #getSourceDiagram()
	 * @generated
	 */
	void setSourceDiagram(Diagram value);

	/**
	 * @model
	 */
	Diagram getTargetDiagram();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetDiagram <em>Target Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Diagram</em>' reference.
	 * @see #getTargetDiagram()
	 * @generated
	 */
	void setTargetDiagram(Diagram value);

	/**
	 * @model
	 */
	NodeVisualModel getTargetVisualNode();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetVisualNode <em>Target Visual Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Visual Node</em>' reference.
	 * @see #getTargetVisualNode()
	 * @generated
	 */
	void setTargetVisualNode(NodeVisualModel value);

	/**
	 * @model default="false"
	 */
	Boolean getTo();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Boolean value);

}
