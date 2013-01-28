/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelPackageImpl.java,v 1.49 2006/02/23 00:05:14 dacostae Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.CoremodelPackageImpl;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.componentmodel.impl.ComponentmodelPackageImpl;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.editormodel.util.EditormodelValidator;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;
import org.isistan.flabot.edit.ucmmodel.impl.UcmmodelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditormodelPackageImpl extends EPackageImpl implements EditormodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flabotFileModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionBendpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionVisualModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeVisualModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringToEObjectMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualDiagramJumpEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.isistan.flabot.edit.editormodel.EditormodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EditormodelPackageImpl() {
		super(eNS_URI, EditormodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EditormodelPackage init() {
		if (isInited) return (EditormodelPackage)EPackage.Registry.INSTANCE.getEPackage(EditormodelPackage.eNS_URI);

		// Obtain or create and register package
		EditormodelPackageImpl theEditormodelPackage = (EditormodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EditormodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EditormodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ComponentmodelPackageImpl theComponentmodelPackage = (ComponentmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) instanceof ComponentmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComponentmodelPackage.eNS_URI) : ComponentmodelPackage.eINSTANCE);
		UcmmodelPackageImpl theUcmmodelPackage = (UcmmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) instanceof UcmmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmmodelPackage.eNS_URI) : UcmmodelPackage.eINSTANCE);
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) instanceof CoremodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI) : CoremodelPackage.eINSTANCE);

		// Create package meta-data objects
		theEditormodelPackage.createPackageContents();
		theComponentmodelPackage.createPackageContents();
		theUcmmodelPackage.createPackageContents();
		theCoremodelPackage.createPackageContents();

		// Initialize created meta-data
		theEditormodelPackage.initializePackageContents();
		theComponentmodelPackage.initializePackageContents();
		theUcmmodelPackage.initializePackageContents();
		theCoremodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEditormodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return EditormodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theEditormodelPackage.freeze();

		return theEditormodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagram_CoreModel() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagram_Notes() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagram_Children() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagram_Folder() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagram_GridEnabled() {
		return (EAttribute)diagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagram_SnapToGeometryEnabled() {
		return (EAttribute)diagramEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlabotFileModel() {
		return flabotFileModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlabotFileModel_CoreModel() {
		return (EReference)flabotFileModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlabotFileModel_Diagrams() {
		return (EReference)flabotFileModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlabotFileModel_ImportedFiles() {
		return (EReference)flabotFileModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlabotFileModel_Id() {
		return (EAttribute)flabotFileModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlabotFileModel_Version() {
		return (EAttribute)flabotFileModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlabotFileModel_Name() {
		return (EAttribute)flabotFileModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlabotFileModel_Provider() {
		return (EAttribute)flabotFileModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlabotFileModel_Folder() {
		return (EReference)flabotFileModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlabotFileModel_OpenDiagrams() {
		return (EReference)flabotFileModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisualModel() {
		return visualModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_Children() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_Parent() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_SemanticModel() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_Location() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_Size() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_Diagram() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_BackgroundColor() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualModel_ForegroundColor() {
		return (EReference)visualModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualModel_LineStyle() {
		return (EAttribute)visualModelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualModel_LineWidth() {
		return (EAttribute)visualModelEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualModel_DetailLevel() {
		return (EAttribute)visualModelEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdapter() {
		return adapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionBendpoint() {
		return connectionBendpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionBendpoint_FirstRelativeDimension() {
		return (EReference)connectionBendpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionBendpoint_SecondRelativeDimension() {
		return (EReference)connectionBendpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionBendpoint_Weight() {
		return (EAttribute)connectionBendpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionVisualModel() {
		return connectionVisualModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionVisualModel_SourceTerminal() {
		return (EAttribute)connectionVisualModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionVisualModel_TargetTerminal() {
		return (EAttribute)connectionVisualModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionVisualModel_Bendpoints() {
		return (EReference)connectionVisualModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionVisualModel_Source() {
		return (EReference)connectionVisualModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionVisualModel_Target() {
		return (EReference)connectionVisualModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeVisualModel() {
		return nodeVisualModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeVisualModel_SourceConnections() {
		return (EReference)nodeVisualModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeVisualModel_TargetConnections() {
		return (EReference)nodeVisualModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeVisualModel_Rotation() {
		return (EAttribute)nodeVisualModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFolder_Name() {
		return (EAttribute)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Folders() {
		return (EReference)folderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Diagrams() {
		return (EReference)folderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Parent() {
		return (EReference)folderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_FileModel() {
		return (EReference)folderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColor() {
		return colorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColor_Red() {
		return (EAttribute)colorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColor_Green() {
		return (EAttribute)colorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColor_Blue() {
		return (EAttribute)colorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Width() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Height() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringToEObjectMapEntry() {
		return eStringToEObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringToEObjectMapEntry_Key() {
		return (EAttribute)eStringToEObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEStringToEObjectMapEntry_Value() {
		return (EReference)eStringToEObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisualDiagramJump() {
		return visualDiagramJumpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualDiagramJump_SourceDiagram() {
		return (EReference)visualDiagramJumpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualDiagramJump_TargetDiagram() {
		return (EReference)visualDiagramJumpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualDiagramJump_TargetVisualNode() {
		return (EReference)visualDiagramJumpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualDiagramJump_To() {
		return (EAttribute)visualDiagramJumpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditormodelFactory getEditormodelFactory() {
		return (EditormodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diagramEClass = createEClass(DIAGRAM);
		createEReference(diagramEClass, DIAGRAM__CORE_MODEL);
		createEReference(diagramEClass, DIAGRAM__NOTES);
		createEReference(diagramEClass, DIAGRAM__CHILDREN);
		createEReference(diagramEClass, DIAGRAM__FOLDER);
		createEAttribute(diagramEClass, DIAGRAM__GRID_ENABLED);
		createEAttribute(diagramEClass, DIAGRAM__SNAP_TO_GEOMETRY_ENABLED);

		flabotFileModelEClass = createEClass(FLABOT_FILE_MODEL);
		createEReference(flabotFileModelEClass, FLABOT_FILE_MODEL__CORE_MODEL);
		createEReference(flabotFileModelEClass, FLABOT_FILE_MODEL__DIAGRAMS);
		createEReference(flabotFileModelEClass, FLABOT_FILE_MODEL__IMPORTED_FILES);
		createEAttribute(flabotFileModelEClass, FLABOT_FILE_MODEL__ID);
		createEAttribute(flabotFileModelEClass, FLABOT_FILE_MODEL__VERSION);
		createEAttribute(flabotFileModelEClass, FLABOT_FILE_MODEL__NAME);
		createEAttribute(flabotFileModelEClass, FLABOT_FILE_MODEL__PROVIDER);
		createEReference(flabotFileModelEClass, FLABOT_FILE_MODEL__FOLDER);
		createEReference(flabotFileModelEClass, FLABOT_FILE_MODEL__OPEN_DIAGRAMS);

		visualModelEClass = createEClass(VISUAL_MODEL);
		createEReference(visualModelEClass, VISUAL_MODEL__CHILDREN);
		createEReference(visualModelEClass, VISUAL_MODEL__PARENT);
		createEReference(visualModelEClass, VISUAL_MODEL__SEMANTIC_MODEL);
		createEReference(visualModelEClass, VISUAL_MODEL__LOCATION);
		createEReference(visualModelEClass, VISUAL_MODEL__SIZE);
		createEReference(visualModelEClass, VISUAL_MODEL__DIAGRAM);
		createEReference(visualModelEClass, VISUAL_MODEL__BACKGROUND_COLOR);
		createEReference(visualModelEClass, VISUAL_MODEL__FOREGROUND_COLOR);
		createEAttribute(visualModelEClass, VISUAL_MODEL__LINE_STYLE);
		createEAttribute(visualModelEClass, VISUAL_MODEL__LINE_WIDTH);
		createEAttribute(visualModelEClass, VISUAL_MODEL__DETAIL_LEVEL);

		adapterEClass = createEClass(ADAPTER);

		connectionBendpointEClass = createEClass(CONNECTION_BENDPOINT);
		createEReference(connectionBendpointEClass, CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION);
		createEReference(connectionBendpointEClass, CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION);
		createEAttribute(connectionBendpointEClass, CONNECTION_BENDPOINT__WEIGHT);

		connectionVisualModelEClass = createEClass(CONNECTION_VISUAL_MODEL);
		createEAttribute(connectionVisualModelEClass, CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL);
		createEAttribute(connectionVisualModelEClass, CONNECTION_VISUAL_MODEL__TARGET_TERMINAL);
		createEReference(connectionVisualModelEClass, CONNECTION_VISUAL_MODEL__BENDPOINTS);
		createEReference(connectionVisualModelEClass, CONNECTION_VISUAL_MODEL__SOURCE);
		createEReference(connectionVisualModelEClass, CONNECTION_VISUAL_MODEL__TARGET);

		nodeVisualModelEClass = createEClass(NODE_VISUAL_MODEL);
		createEReference(nodeVisualModelEClass, NODE_VISUAL_MODEL__SOURCE_CONNECTIONS);
		createEReference(nodeVisualModelEClass, NODE_VISUAL_MODEL__TARGET_CONNECTIONS);
		createEAttribute(nodeVisualModelEClass, NODE_VISUAL_MODEL__ROTATION);

		folderEClass = createEClass(FOLDER);
		createEAttribute(folderEClass, FOLDER__NAME);
		createEReference(folderEClass, FOLDER__FOLDERS);
		createEReference(folderEClass, FOLDER__DIAGRAMS);
		createEReference(folderEClass, FOLDER__PARENT);
		createEReference(folderEClass, FOLDER__FILE_MODEL);

		colorEClass = createEClass(COLOR);
		createEAttribute(colorEClass, COLOR__RED);
		createEAttribute(colorEClass, COLOR__GREEN);
		createEAttribute(colorEClass, COLOR__BLUE);

		dimensionEClass = createEClass(DIMENSION);
		createEAttribute(dimensionEClass, DIMENSION__WIDTH);
		createEAttribute(dimensionEClass, DIMENSION__HEIGHT);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);

		eStringToEObjectMapEntryEClass = createEClass(ESTRING_TO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__KEY);
		createEReference(eStringToEObjectMapEntryEClass, ESTRING_TO_EOBJECT_MAP_ENTRY__VALUE);

		visualDiagramJumpEClass = createEClass(VISUAL_DIAGRAM_JUMP);
		createEReference(visualDiagramJumpEClass, VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM);
		createEReference(visualDiagramJumpEClass, VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM);
		createEReference(visualDiagramJumpEClass, VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE);
		createEAttribute(visualDiagramJumpEClass, VISUAL_DIAGRAM_JUMP__TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CoremodelPackageImpl theCoremodelPackage = (CoremodelPackageImpl)EPackage.Registry.INSTANCE.getEPackage(CoremodelPackage.eNS_URI);

		// Add supertypes to classes
		diagramEClass.getESuperTypes().add(theCoremodelPackage.getNamedElementModel());
		flabotFileModelEClass.getESuperTypes().add(theCoremodelPackage.getExtensibleElement());
		visualModelEClass.getESuperTypes().add(this.getAdapter());
		connectionVisualModelEClass.getESuperTypes().add(this.getNodeVisualModel());
		nodeVisualModelEClass.getESuperTypes().add(this.getVisualModel());
		visualDiagramJumpEClass.getESuperTypes().add(this.getNodeVisualModel());

		// Initialize classes and features; add operations and parameters
		initEClass(diagramEClass, Diagram.class, "Diagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagram_CoreModel(), theCoremodelPackage.getCoreModel(), null, "coreModel", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagram_Notes(), theCoremodelPackage.getNote(), null, "notes", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagram_Children(), this.getVisualModel(), this.getVisualModel_Diagram(), "children", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagram_Folder(), this.getFolder(), this.getFolder_Diagrams(), "folder", null, 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagram_GridEnabled(), ecorePackage.getEBooleanObject(), "gridEnabled", "false", 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagram_SnapToGeometryEnabled(), ecorePackage.getEBooleanObject(), "snapToGeometryEnabled", "false", 0, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flabotFileModelEClass, FlabotFileModel.class, "FlabotFileModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlabotFileModel_CoreModel(), theCoremodelPackage.getCoreModel(), theCoremodelPackage.getCoreModel_File(), "coreModel", null, 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlabotFileModel_Diagrams(), this.getDiagram(), null, "diagrams", null, 0, -1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlabotFileModel_ImportedFiles(), this.getFlabotFileModel(), null, "importedFiles", null, 0, -1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlabotFileModel_Id(), ecorePackage.getEString(), "id", "", 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlabotFileModel_Version(), ecorePackage.getEString(), "version", "0.0.1", 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlabotFileModel_Name(), ecorePackage.getEString(), "name", "", 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlabotFileModel_Provider(), ecorePackage.getEString(), "provider", "", 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlabotFileModel_Folder(), this.getFolder(), null, "folder", null, 0, 1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlabotFileModel_OpenDiagrams(), this.getDiagram(), null, "openDiagrams", null, 0, -1, FlabotFileModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visualModelEClass, VisualModel.class, "VisualModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisualModel_Children(), this.getVisualModel(), this.getVisualModel_Parent(), "children", null, 0, -1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_Parent(), this.getVisualModel(), this.getVisualModel_Children(), "parent", null, 0, 1, VisualModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_SemanticModel(), ecorePackage.getEObject(), null, "semanticModel", null, 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_Location(), this.getPoint(), null, "location", null, 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_Size(), this.getDimension(), null, "size", null, 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_Diagram(), this.getDiagram(), this.getDiagram_Children(), "diagram", null, 0, 1, VisualModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_BackgroundColor(), this.getColor(), null, "backgroundColor", null, 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualModel_ForegroundColor(), this.getColor(), null, "foregroundColor", null, 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualModel_LineStyle(), ecorePackage.getEInt(), "lineStyle", "org.eclipse.draw2d.Graphics.LINE_SOLID", 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualModel_LineWidth(), ecorePackage.getEInt(), "lineWidth", "1", 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualModel_DetailLevel(), ecorePackage.getEInt(), "detailLevel", "0", 0, 1, VisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adapterEClass, Adapter.class, "Adapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectionBendpointEClass, ConnectionBendpoint.class, "ConnectionBendpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionBendpoint_FirstRelativeDimension(), this.getDimension(), null, "firstRelativeDimension", null, 0, 1, ConnectionBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionBendpoint_SecondRelativeDimension(), this.getDimension(), null, "secondRelativeDimension", null, 0, 1, ConnectionBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionBendpoint_Weight(), ecorePackage.getEFloat(), "weight", "0.5f", 0, 1, ConnectionBendpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionVisualModelEClass, ConnectionVisualModel.class, "ConnectionVisualModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionVisualModel_SourceTerminal(), ecorePackage.getEString(), "sourceTerminal", "", 0, 1, ConnectionVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionVisualModel_TargetTerminal(), ecorePackage.getEString(), "targetTerminal", "", 0, 1, ConnectionVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionVisualModel_Bendpoints(), this.getConnectionBendpoint(), null, "bendpoints", null, 0, -1, ConnectionVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionVisualModel_Source(), this.getNodeVisualModel(), this.getNodeVisualModel_SourceConnections(), "source", null, 0, 1, ConnectionVisualModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionVisualModel_Target(), this.getNodeVisualModel(), this.getNodeVisualModel_TargetConnections(), "target", null, 0, 1, ConnectionVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeVisualModelEClass, NodeVisualModel.class, "NodeVisualModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeVisualModel_SourceConnections(), this.getConnectionVisualModel(), this.getConnectionVisualModel_Source(), "sourceConnections", null, 0, -1, NodeVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeVisualModel_TargetConnections(), this.getConnectionVisualModel(), this.getConnectionVisualModel_Target(), "targetConnections", null, 0, -1, NodeVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeVisualModel_Rotation(), ecorePackage.getEString(), "rotation", "", 0, 1, NodeVisualModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFolder_Name(), ecorePackage.getEString(), "name", "", 0, 1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_Folders(), this.getFolder(), this.getFolder_Parent(), "folders", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_Diagrams(), this.getDiagram(), this.getDiagram_Folder(), "diagrams", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_Parent(), this.getFolder(), this.getFolder_Folders(), "parent", null, 0, 1, Folder.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFolder_FileModel(), this.getFlabotFileModel(), null, "fileModel", null, 0, 1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorEClass, Color.class, "Color", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColor_Red(), ecorePackage.getEInt(), "red", null, 0, 1, Color.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColor_Green(), ecorePackage.getEInt(), "green", null, 0, 1, Color.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColor_Blue(), ecorePackage.getEInt(), "blue", null, 0, 1, Color.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDimension_Width(), ecorePackage.getEInt(), "width", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Height(), ecorePackage.getEInt(), "height", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), ecorePackage.getEInt(), "x", null, 0, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoint_Y(), ecorePackage.getEInt(), "y", null, 0, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eStringToEObjectMapEntryEClass, Map.Entry.class, "EStringToEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringToEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEStringToEObjectMapEntry_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(visualDiagramJumpEClass, VisualDiagramJump.class, "VisualDiagramJump", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisualDiagramJump_SourceDiagram(), this.getDiagram(), null, "sourceDiagram", null, 0, 1, VisualDiagramJump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualDiagramJump_TargetDiagram(), this.getDiagram(), null, "targetDiagram", null, 0, 1, VisualDiagramJump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualDiagramJump_TargetVisualNode(), this.getNodeVisualModel(), null, "targetVisualNode", null, 0, 1, VisualDiagramJump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVisualDiagramJump_To(), ecorePackage.getEBooleanObject(), "to", "false", 0, 1, VisualDiagramJump.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (flabotFileModelEClass, 
		   source, 
		   new String[] {
			 "constraints", "InterfaceLinkMappedToPathGeneral ComponentUniqueName"
		   });
	}

} //EditormodelPackageImpl
