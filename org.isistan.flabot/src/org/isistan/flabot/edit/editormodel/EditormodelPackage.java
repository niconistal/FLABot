/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelPackage.java,v 1.27 2006/02/23 00:05:13 dacostae Exp $
 */
package org.isistan.flabot.edit.editormodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.isistan.flabot.coremodel.CoremodelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.editormodel.EditormodelFactory
 * @model kind="package"
 * @generated
 */
public interface EditormodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editormodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/edit/editormodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.edit.editormodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditormodelPackage eINSTANCE = org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.DiagramImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NAME = CoremodelPackage.NAMED_ELEMENT_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__CORE_MODEL = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NOTES = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__CHILDREN = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__FOLDER = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Grid Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__GRID_ENABLED = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Snap To Geometry Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__SNAP_TO_GEOMETRY_ENABLED = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = CoremodelPackage.NAMED_ELEMENT_MODEL_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl <em>Flabot File Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getFlabotFileModel()
	 * @generated
	 */
	int FLABOT_FILE_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Extended Data</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__EXTENDED_DATA = CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA;

	/**
	 * The feature id for the '<em><b>Core Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__CORE_MODEL = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__DIAGRAMS = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Imported Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__IMPORTED_FILES = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__ID = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__VERSION = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__NAME = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__PROVIDER = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__FOLDER = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Open Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL__OPEN_DIAGRAMS = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Flabot File Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLABOT_FILE_MODEL_FEATURE_COUNT = CoremodelPackage.EXTENSIBLE_ELEMENT_FEATURE_COUNT + 9;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 3;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl <em>Visual Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.VisualModelImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getVisualModel()
	 * @generated
	 */
	int VISUAL_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__CHILDREN = ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__PARENT = ADAPTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__SEMANTIC_MODEL = ADAPTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__LOCATION = ADAPTER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__SIZE = ADAPTER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__DIAGRAM = ADAPTER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__BACKGROUND_COLOR = ADAPTER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__FOREGROUND_COLOR = ADAPTER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__LINE_STYLE = ADAPTER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__LINE_WIDTH = ADAPTER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Detail Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL__DETAIL_LEVEL = ADAPTER_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Visual Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_MODEL_FEATURE_COUNT = ADAPTER_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.ConnectionBendpointImpl <em>Connection Bendpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.ConnectionBendpointImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getConnectionBendpoint()
	 * @generated
	 */
	int CONNECTION_BENDPOINT = 4;

	/**
	 * The feature id for the '<em><b>First Relative Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION = 0;

	/**
	 * The feature id for the '<em><b>Second Relative Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_BENDPOINT__WEIGHT = 2;

	/**
	 * The number of structural features of the '<em>Connection Bendpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_BENDPOINT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl <em>Connection Visual Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getConnectionVisualModel()
	 * @generated
	 */
	int CONNECTION_VISUAL_MODEL = 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.NodeVisualModelImpl <em>Node Visual Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.NodeVisualModelImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getNodeVisualModel()
	 * @generated
	 */
	int NODE_VISUAL_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__CHILDREN = VISUAL_MODEL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__PARENT = VISUAL_MODEL__PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__SEMANTIC_MODEL = VISUAL_MODEL__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__LOCATION = VISUAL_MODEL__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__SIZE = VISUAL_MODEL__SIZE;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__DIAGRAM = VISUAL_MODEL__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__BACKGROUND_COLOR = VISUAL_MODEL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__FOREGROUND_COLOR = VISUAL_MODEL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__LINE_STYLE = VISUAL_MODEL__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__LINE_WIDTH = VISUAL_MODEL__LINE_WIDTH;

	/**
	 * The feature id for the '<em><b>Detail Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__DETAIL_LEVEL = VISUAL_MODEL__DETAIL_LEVEL;

	/**
	 * The feature id for the '<em><b>Source Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__SOURCE_CONNECTIONS = VISUAL_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__TARGET_CONNECTIONS = VISUAL_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL__ROTATION = VISUAL_MODEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node Visual Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_VISUAL_MODEL_FEATURE_COUNT = VISUAL_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__CHILDREN = NODE_VISUAL_MODEL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__PARENT = NODE_VISUAL_MODEL__PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__SEMANTIC_MODEL = NODE_VISUAL_MODEL__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__LOCATION = NODE_VISUAL_MODEL__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__SIZE = NODE_VISUAL_MODEL__SIZE;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__DIAGRAM = NODE_VISUAL_MODEL__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR = NODE_VISUAL_MODEL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR = NODE_VISUAL_MODEL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__LINE_STYLE = NODE_VISUAL_MODEL__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__LINE_WIDTH = NODE_VISUAL_MODEL__LINE_WIDTH;

	/**
	 * The feature id for the '<em><b>Detail Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__DETAIL_LEVEL = NODE_VISUAL_MODEL__DETAIL_LEVEL;

	/**
	 * The feature id for the '<em><b>Source Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS = NODE_VISUAL_MODEL__SOURCE_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Target Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS = NODE_VISUAL_MODEL__TARGET_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__ROTATION = NODE_VISUAL_MODEL__ROTATION;

	/**
	 * The feature id for the '<em><b>Source Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL = NODE_VISUAL_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__TARGET_TERMINAL = NODE_VISUAL_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__BENDPOINTS = NODE_VISUAL_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__SOURCE = NODE_VISUAL_MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL__TARGET = NODE_VISUAL_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Connection Visual Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VISUAL_MODEL_FEATURE_COUNT = NODE_VISUAL_MODEL_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.FolderImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Folders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__FOLDERS = 1;

	/**
	 * The feature id for the '<em><b>Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__DIAGRAMS = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__PARENT = 3;

	/**
	 * The feature id for the '<em><b>File Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__FILE_MODEL = 4;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.ColorImpl <em>Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.ColorImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 8;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__RED = 0;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__GREEN = 1;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__BLUE = 2;

	/**
	 * The number of structural features of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.DimensionImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 9;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HEIGHT = 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.PointImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 10;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.EStringToEObjectMapEntryImpl <em>EString To EObject Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.EStringToEObjectMapEntryImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getEStringToEObjectMapEntry()
	 * @generated
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To EObject Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_EOBJECT_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl <em>Visual Diagram Jump</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl
	 * @see org.isistan.flabot.edit.editormodel.impl.EditormodelPackageImpl#getVisualDiagramJump()
	 * @generated
	 */
	int VISUAL_DIAGRAM_JUMP = 12;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__CHILDREN = NODE_VISUAL_MODEL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__PARENT = NODE_VISUAL_MODEL__PARENT;

	/**
	 * The feature id for the '<em><b>Semantic Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__SEMANTIC_MODEL = NODE_VISUAL_MODEL__SEMANTIC_MODEL;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__LOCATION = NODE_VISUAL_MODEL__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__SIZE = NODE_VISUAL_MODEL__SIZE;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__DIAGRAM = NODE_VISUAL_MODEL__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR = NODE_VISUAL_MODEL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR = NODE_VISUAL_MODEL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__LINE_STYLE = NODE_VISUAL_MODEL__LINE_STYLE;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__LINE_WIDTH = NODE_VISUAL_MODEL__LINE_WIDTH;

	/**
	 * The feature id for the '<em><b>Detail Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__DETAIL_LEVEL = NODE_VISUAL_MODEL__DETAIL_LEVEL;

	/**
	 * The feature id for the '<em><b>Source Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS = NODE_VISUAL_MODEL__SOURCE_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Target Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS = NODE_VISUAL_MODEL__TARGET_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__ROTATION = NODE_VISUAL_MODEL__ROTATION;

	/**
	 * The feature id for the '<em><b>Source Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM = NODE_VISUAL_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM = NODE_VISUAL_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Visual Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE = NODE_VISUAL_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP__TO = NODE_VISUAL_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Visual Diagram Jump</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUAL_DIAGRAM_JUMP_FEATURE_COUNT = NODE_VISUAL_MODEL_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.Diagram#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Core Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getCoreModel()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_CoreModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.Diagram#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notes</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getNotes()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Notes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.Diagram#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getChildren()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Children();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.Diagram#getFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Folder</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getFolder()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_Folder();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Diagram#getGridEnabled <em>Grid Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grid Enabled</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getGridEnabled()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_GridEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Diagram#getSnapToGeometryEnabled <em>Snap To Geometry Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snap To Geometry Enabled</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Diagram#getSnapToGeometryEnabled()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_SnapToGeometryEnabled();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel <em>Flabot File Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flabot File Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel
	 * @generated
	 */
	EClass getFlabotFileModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getCoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Core Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getCoreModel()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EReference getFlabotFileModel_CoreModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagrams</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getDiagrams()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EReference getFlabotFileModel_Diagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getImportedFiles <em>Imported Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imported Files</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getImportedFiles()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EReference getFlabotFileModel_ImportedFiles();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getId()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EAttribute getFlabotFileModel_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getVersion()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EAttribute getFlabotFileModel_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getName()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EAttribute getFlabotFileModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getProvider()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EAttribute getFlabotFileModel_Provider();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Folder</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getFolder()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EReference getFlabotFileModel_Folder();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.edit.editormodel.FlabotFileModel#getOpenDiagrams <em>Open Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Open Diagrams</em>'.
	 * @see org.isistan.flabot.edit.editormodel.FlabotFileModel#getOpenDiagrams()
	 * @see #getFlabotFileModel()
	 * @generated
	 */
	EReference getFlabotFileModel_OpenDiagrams();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.VisualModel <em>Visual Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visual Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel
	 * @generated
	 */
	EClass getVisualModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.VisualModel#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getChildren()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_Children();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getParent()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getSemanticModel <em>Semantic Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Semantic Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getSemanticModel()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_SemanticModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getLocation()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_Location();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getSize()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_Size();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Diagram</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getDiagram()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_Diagram();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getBackgroundColor()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.VisualModel#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getForegroundColor()
	 * @see #getVisualModel()
	 * @generated
	 */
	EReference getVisualModel_ForegroundColor();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLineStyle <em>Line Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Style</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getLineStyle()
	 * @see #getVisualModel()
	 * @generated
	 */
	EAttribute getVisualModel_LineStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.VisualModel#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getLineWidth()
	 * @see #getVisualModel()
	 * @generated
	 */
	EAttribute getVisualModel_LineWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.VisualModel#getDetailLevel <em>Detail Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detail Level</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualModel#getDetailLevel()
	 * @see #getVisualModel()
	 * @generated
	 */
	EAttribute getVisualModel_DetailLevel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint <em>Connection Bendpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Bendpoint</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionBendpoint
	 * @generated
	 */
	EClass getConnectionBendpoint();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getFirstRelativeDimension <em>First Relative Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Relative Dimension</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getFirstRelativeDimension()
	 * @see #getConnectionBendpoint()
	 * @generated
	 */
	EReference getConnectionBendpoint_FirstRelativeDimension();

	/**
	 * Returns the meta object for the containment reference '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getSecondRelativeDimension <em>Second Relative Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Relative Dimension</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getSecondRelativeDimension()
	 * @see #getConnectionBendpoint()
	 * @generated
	 */
	EReference getConnectionBendpoint_SecondRelativeDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionBendpoint#getWeight()
	 * @see #getConnectionBendpoint()
	 * @generated
	 */
	EAttribute getConnectionBendpoint_Weight();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel <em>Connection Visual Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Visual Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel
	 * @generated
	 */
	EClass getConnectionVisualModel();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSourceTerminal <em>Source Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Terminal</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSourceTerminal()
	 * @see #getConnectionVisualModel()
	 * @generated
	 */
	EAttribute getConnectionVisualModel_SourceTerminal();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTargetTerminal <em>Target Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Terminal</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTargetTerminal()
	 * @see #getConnectionVisualModel()
	 * @generated
	 */
	EAttribute getConnectionVisualModel_TargetTerminal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getBendpoints <em>Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bendpoints</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getBendpoints()
	 * @see #getConnectionVisualModel()
	 * @generated
	 */
	EReference getConnectionVisualModel_Bendpoints();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getSource()
	 * @see #getConnectionVisualModel()
	 * @generated
	 */
	EReference getConnectionVisualModel_Source();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.isistan.flabot.edit.editormodel.ConnectionVisualModel#getTarget()
	 * @see #getConnectionVisualModel()
	 * @generated
	 */
	EReference getConnectionVisualModel_Target();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.NodeVisualModel <em>Node Visual Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Visual Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.NodeVisualModel
	 * @generated
	 */
	EClass getNodeVisualModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.NodeVisualModel#getSourceConnections <em>Source Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Connections</em>'.
	 * @see org.isistan.flabot.edit.editormodel.NodeVisualModel#getSourceConnections()
	 * @see #getNodeVisualModel()
	 * @generated
	 */
	EReference getNodeVisualModel_SourceConnections();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.edit.editormodel.NodeVisualModel#getTargetConnections <em>Target Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Connections</em>'.
	 * @see org.isistan.flabot.edit.editormodel.NodeVisualModel#getTargetConnections()
	 * @see #getNodeVisualModel()
	 * @generated
	 */
	EReference getNodeVisualModel_TargetConnections();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.NodeVisualModel#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see org.isistan.flabot.edit.editormodel.NodeVisualModel#getRotation()
	 * @see #getNodeVisualModel()
	 * @generated
	 */
	EAttribute getNodeVisualModel_Rotation();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Folder#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder#getName()
	 * @see #getFolder()
	 * @generated
	 */
	EAttribute getFolder_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.edit.editormodel.Folder#getFolders <em>Folders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Folders</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder#getFolders()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Folders();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.edit.editormodel.Folder#getDiagrams <em>Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Diagrams</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder#getDiagrams()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Diagrams();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.edit.editormodel.Folder#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder#getParent()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.Folder#getFileModel <em>File Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File Model</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Folder#getFileModel()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_FileModel();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Color
	 * @generated
	 */
	EClass getColor();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Color#getRed <em>Red</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Color#getRed()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Red();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Color#getGreen <em>Green</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Color#getGreen()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Green();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Color#getBlue <em>Blue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Color#getBlue()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Blue();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Dimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Dimension#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Dimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Dimension#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Height();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.isistan.flabot.edit.editormodel.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To EObject Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To EObject Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="java.lang.String"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true" valueResolveProxies="false"
	 * @generated
	 */
	EClass getEStringToEObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EAttribute getEStringToEObjectMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToEObjectMapEntry()
	 * @generated
	 */
	EReference getEStringToEObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump <em>Visual Diagram Jump</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visual Diagram Jump</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualDiagramJump
	 * @generated
	 */
	EClass getVisualDiagramJump();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getSourceDiagram <em>Source Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Diagram</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualDiagramJump#getSourceDiagram()
	 * @see #getVisualDiagramJump()
	 * @generated
	 */
	EReference getVisualDiagramJump_SourceDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetDiagram <em>Target Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Diagram</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetDiagram()
	 * @see #getVisualDiagramJump()
	 * @generated
	 */
	EReference getVisualDiagramJump_TargetDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetVisualNode <em>Target Visual Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Visual Node</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTargetVisualNode()
	 * @see #getVisualDiagramJump()
	 * @generated
	 */
	EReference getVisualDiagramJump_TargetVisualNode();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see org.isistan.flabot.edit.editormodel.VisualDiagramJump#getTo()
	 * @see #getVisualDiagramJump()
	 * @generated
	 */
	EAttribute getVisualDiagramJump_To();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EditormodelFactory getEditormodelFactory();

} //EditormodelPackage
