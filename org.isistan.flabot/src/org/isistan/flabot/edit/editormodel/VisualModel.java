/** * $Id: VisualModel.java,v 1.9 2006/01/27 00:09:20 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.util.EList;import org.eclipse.emf.ecore.EObject;/**
 * VisualModel:
 * -	Abstract model for all Visual Models in flabot to extend from.
 * -	Holds children visual models by contention.
 * -	Contains visual properties such as color, dimension, location, line style, etc.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface VisualModel  extends EObject, Adapter{

	public static final int LOW_DETAIL = 0;
	public static final int MEDIUM_DETAIL = 1;
	public static final int HIGH_DETAIL = 2;
	
	/**
	 * If this visual model isn't contained directly by the diagram,
	 * this method returns the parent's diagram (recursively)
	 * 
	 * @model opposite="children"
	 */
	Diagram getDiagram();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getDiagram <em>Diagram</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Diagram</em>' container reference.	 * @see #getDiagram()	 * @generated	 */
	void setDiagram(Diagram value);

	/**
	 * @model type="VisualModel" containment="true" opposite="parent"
	 */
	EList getChildren();
	
	/**
	 * @model opposite="children"
	 */
	VisualModel getParent();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getParent <em>Parent</em>}' container reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Parent</em>' container reference.	 * @see #getParent()	 * @generated	 */
	void setParent(VisualModel value);

	/**
	 * @model type="EObject"
	 */
	EObject getSemanticModel();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getSemanticModel <em>Semantic Model</em>}' reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Semantic Model</em>' reference.	 * @see #getSemanticModel()	 * @generated	 */
	void setSemanticModel(EObject value);

	/**
	 * @model containment="true"
	 */
	Point getLocation();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLocation <em>Location</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Location</em>' containment reference.	 * @see #getLocation()	 * @generated	 */
	void setLocation(Point value);

	/**
	 * @model containment="true"
	 */
	Dimension getSize();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getSize <em>Size</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Size</em>' containment reference.	 * @see #getSize()	 * @generated	 */
	void setSize(Dimension value);

	/**
	 * @model containment="true"
	 */
	Color getBackgroundColor();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getBackgroundColor <em>Background Color</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Background Color</em>' containment reference.	 * @see #getBackgroundColor()	 * @generated	 */
	void setBackgroundColor(Color value);

	/**
	 * @model containment="true"
	 */
	Color getForegroundColor();
	
	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getForegroundColor <em>Foreground Color</em>}' containment reference.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.	 * @see #getForegroundColor()	 * @generated	 */
	void setForegroundColor(Color value);

	/**
	 * @model default="org.eclipse.draw2d.Graphics.LINE_SOLID"
	 */
	int getLineStyle();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLineStyle <em>Line Style</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Line Style</em>' attribute.	 * @see #getLineStyle()	 * @generated	 */
	void setLineStyle(int value);

	/**
	 * @model default="1"
	 */
	int getLineWidth();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLineWidth <em>Line Width</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Line Width</em>' attribute.	 * @see #getLineWidth()	 * @generated	 */
	void setLineWidth(int value);

	/**
	 * @model default="0"
	 */
	int getDetailLevel();

	/**	 * Sets the value of the '{@link org.isistan.flabot.edit.editormodel.VisualModel#getDetailLevel <em>Detail Level</em>}' attribute.	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->	 * @param value the new value of the '<em>Detail Level</em>' attribute.	 * @see #getDetailLevel()	 * @generated	 */
	void setDetailLevel(int value);

}
