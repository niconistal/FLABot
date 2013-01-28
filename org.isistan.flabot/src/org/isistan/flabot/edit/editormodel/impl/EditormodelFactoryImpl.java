/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelFactoryImpl.java,v 1.66 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditormodelFactoryImpl extends EFactoryImpl implements EditormodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditormodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EditormodelPackage.FLABOT_FILE_MODEL: return createFlabotFileModel();
			case EditormodelPackage.VISUAL_MODEL: return createVisualModel();
			case EditormodelPackage.CONNECTION_BENDPOINT: return createConnectionBendpoint();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL: return createConnectionVisualModel();
			case EditormodelPackage.NODE_VISUAL_MODEL: return createNodeVisualModel();
			case EditormodelPackage.FOLDER: return createFolder();
			case EditormodelPackage.COLOR: return createColor();
			case EditormodelPackage.DIMENSION: return createDimension();
			case EditormodelPackage.POINT: return createPoint();
			case EditormodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: return (EObject)createEStringToEObjectMapEntry();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP: return createVisualDiagramJump();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel createFlabotFileModel() {
		FlabotFileModelImpl flabotFileModel = new FlabotFileModelImpl();
		return flabotFileModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualModel createVisualModel() {
		VisualModelImpl visualModel = new VisualModelImpl();
		return visualModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VisualModel createVisualModel(VisualModel copyVisualModel) {
		if (copyVisualModel == null)
			return createVisualModel();
		
		VisualModelImpl visualModel = new VisualModelImpl();
		visualModel.setLocation(copyVisualModel.getLocation().clone());		
		visualModel.setSize(copyVisualModel.getSize().clone());
		visualModel.setBackgroundColor(copyVisualModel.getBackgroundColor().clone());
		visualModel.setForegroundColor(copyVisualModel.getForegroundColor().clone());
		visualModel.setLineStyle(copyVisualModel.getLineStyle());
		visualModel.setLineWidth(copyVisualModel.getLineWidth());
		visualModel.setDetailLevel(copyVisualModel.getDetailLevel());
		return visualModel;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionBendpoint createConnectionBendpoint() {
		ConnectionBendpointImpl connectionBendpoint = new ConnectionBendpointImpl();
		return connectionBendpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionVisualModel createConnectionVisualModel() {
		ConnectionVisualModelImpl connectionVisualModel = new ConnectionVisualModelImpl();
		return connectionVisualModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel createNodeVisualModel() {
		NodeVisualModelImpl nodeVisualModel = new NodeVisualModelImpl();
		return nodeVisualModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color createColor() {
		ColorImpl color = new ColorImpl();
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createDimension() {
		DimensionImpl dimension = new DimensionImpl();
		return dimension;
	}

	/**
	 * Returns a new object of class '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dimension</em>'.
	 * @generated NOT
	 */
	public Dimension createDimension(int width, int height) {
		Dimension dimension = createDimension();
		dimension.setWidth(width);
		dimension.setHeight(height);
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createEStringToEObjectMapEntry() {
		EStringToEObjectMapEntryImpl eStringToEObjectMapEntry = new EStringToEObjectMapEntryImpl();
		return eStringToEObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualDiagramJump createVisualDiagramJump() {
		VisualDiagramJumpImpl visualDiagramJump = new VisualDiagramJumpImpl();
		return visualDiagramJump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Folder createFolder(String name) {
		FolderImpl folder = new FolderImpl();
		folder.setName(name);
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NodeVisualModel createNodeVisualModel(NodeVisualModel copyConnectedVisualModel) {
		if (copyConnectedVisualModel == null)
			return createNodeVisualModel();
		
		NodeVisualModel connectedVisualModel = createNodeVisualModel();
		connectedVisualModel.setLocation(copyConnectedVisualModel.getLocation().clone());		
		connectedVisualModel.setSize(copyConnectedVisualModel.getSize().clone());
		connectedVisualModel.setBackgroundColor(copyConnectedVisualModel.getBackgroundColor().clone());
		connectedVisualModel.setForegroundColor(copyConnectedVisualModel.getForegroundColor().clone());
		connectedVisualModel.setLineStyle(copyConnectedVisualModel.getLineStyle());
		connectedVisualModel.setLineWidth(copyConnectedVisualModel.getLineWidth());
		connectedVisualModel.setDetailLevel(copyConnectedVisualModel.getDetailLevel());
		return connectedVisualModel;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionVisualModel createConnectionVisualModel(ConnectionVisualModel copyVisualModel) {
		if (copyVisualModel == null)
			return createConnectionVisualModel();
		
		ConnectionVisualModelImpl connectionVisualModel = new ConnectionVisualModelImpl();				
		connectionVisualModel.setLocation(copyVisualModel.getLocation().clone());		
		connectionVisualModel.setSize(copyVisualModel.getSize().clone());
		connectionVisualModel.setBackgroundColor(copyVisualModel.getBackgroundColor().clone());
		connectionVisualModel.setForegroundColor(copyVisualModel.getForegroundColor().clone());
		connectionVisualModel.setLineStyle(copyVisualModel.getLineStyle());
		connectionVisualModel.setLineWidth(copyVisualModel.getLineWidth());
		for(Iterator iter = copyVisualModel.getBendpoints().iterator(); iter.hasNext();)
			connectionVisualModel.getBendpoints().add(((ConnectionBendpoint)iter.next()).clone());		

		return connectionVisualModel;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditormodelPackage getEditormodelPackage() {
		return (EditormodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static EditormodelPackage getPackage() {
		return EditormodelPackage.eINSTANCE;
	}

} //EditormodelFactoryImpl
