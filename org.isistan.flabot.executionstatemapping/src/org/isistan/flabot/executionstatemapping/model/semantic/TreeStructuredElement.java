package org.isistan.flabot.executionstatemapping.model.semantic;

import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 */
public interface TreeStructuredElement extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Tree Structured Elements</b></em>' reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement}.
	 * It is bidirectional and its opposite is '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Structured Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree Structured Elements</em>' reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getTreeStructuredElement_TreeStructuredElements()
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getParent
	 * @model opposite="parent" transient="true"
	 * @generated
	 */
	EList<TreeStructuredElement> getTreeStructuredElements();

	/**
	 * @model opposite="children"
	 */
	TreeStructuredElement getParent();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TreeStructuredElement value);
	
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.isistan.flabot.executionstatemapping.model.semantic.TreeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeType
	 * @see #setType(TreeType)
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getTreeStructuredElement_Type()
	 * @model
	 * @generated
	 */
	TreeType getType();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.TreeType
	 * @see #getType()
	 * @generated
	 */
	void setType(TreeType value);

	/**
	 * Returns the value of the '<em><b>Persistent List</b></em>' containment reference list.
	 * The list contents are of type {@link org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistent List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistent List</em>' containment reference list.
	 * @see org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage#getTreeStructuredElement_PersistentList()
	 * @model containment="true"
	 * @generated
	 */
	EList<TreeStructuredElement> getPersistentList();

	boolean addPersistentTreeStructuredElement(TreeStructuredElement treeStructuredElement);
	
	boolean removePersistentTreeStructuredElement(TreeStructuredElement treeStructuredElement);
	
	boolean addTreeStructuredElement(TreeStructuredElement treeStructuredElement);
    
    boolean removeTreeStructuredElement(TreeStructuredElement treeStructuredElement);
       
    List<TreeStructuredElement> uGetTreeStructuredElements();
    
    TreeStructuredElement getAntecesor(TreeType type);
}
