/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelFactory.java,v 1.9 2006/02/21 00:46:20 franco Exp $
 */
package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.editormodel.EditormodelPackage
 * @generated
 */
public interface EditormodelFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditormodelFactory eINSTANCE = new org.isistan.flabot.edit.editormodel.impl.EditormodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Flabot File Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flabot File Model</em>'.
	 * @generated
	 */
	FlabotFileModel createFlabotFileModel();

	/**
	 * Returns a new object of class '<em>Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visual Model</em>'.
	 * @generated
	 */
	VisualModel createVisualModel();

	/**
	 * Returns a new object of class '<em>Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visual Model</em>'.
	 * @generated NOT
	 */
	VisualModel createVisualModel(VisualModel copyVisualModel);

	/**
	 * Returns a new object of class '<em>Connection Bendpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Bendpoint</em>'.
	 * @generated
	 */
	ConnectionBendpoint createConnectionBendpoint();

	/**
	 * Returns a new object of class '<em>Connection Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Visual Model</em>'.
	 * @generated
	 */
	ConnectionVisualModel createConnectionVisualModel();

	/**
	 * Returns a new object of class '<em>Node Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Visual Model</em>'.
	 * @generated
	 */
	NodeVisualModel createNodeVisualModel();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color</em>'.
	 * @generated
	 */
	Color createColor();

	/**
	 * Returns a new object of class '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension</em>'.
	 * @generated
	 */
	Dimension createDimension();

	/**
	 * Returns a new object of class '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension</em>'.
	 * @generated NOT
	 */
	Dimension createDimension(int width, int height);

	/**
	 * Returns a new object of class '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point</em>'.
	 * @generated
	 */
	Point createPoint();

	/**
	 * Returns a new object of class '<em>Visual Diagram Jump</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visual Diagram Jump</em>'.
	 * @generated
	 */
	VisualDiagramJump createVisualDiagramJump();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated NOT
	 */
	Folder createFolder(String name);

	/**
	 * Returns a new object of class '<em>Node Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Visual Model</em>'.
	 * @generated NOT
	 */
	NodeVisualModel createNodeVisualModel(NodeVisualModel copyNodeVisualModel);
	
	/**
	 * Returns a new object of class '<em>Connection Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Visual Model</em>'.
	 * @generated NOT
	 */
	ConnectionVisualModel createConnectionVisualModel(ConnectionVisualModel copyVisualModel);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditormodelPackage getEditormodelPackage();

} //EditormodelFactory
