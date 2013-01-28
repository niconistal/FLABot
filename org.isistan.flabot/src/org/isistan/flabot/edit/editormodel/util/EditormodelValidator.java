/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelValidator.java,v 1.39 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.isistan.flabot.coremodel.constraint.ComponentUniqueNameConstraint;
import org.isistan.flabot.coremodel.constraint.InterfaceLinkMappedToPathGeneralConstraint;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.util.consistency.ConsistencyManager;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.editormodel.EditormodelPackage
 * @generated
 */
public class EditormodelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EditormodelValidator INSTANCE = new EditormodelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.isistan.flabot.edit.editormodel"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditormodelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPackage getEPackage() {
	  return EditormodelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map context) {
		switch (classifierID) {
			case EditormodelPackage.DIAGRAM:
				return validateDiagram((Diagram)value, diagnostics, context);
			case EditormodelPackage.FLABOT_FILE_MODEL:
				return validateFlabotFileModel((FlabotFileModel)value, diagnostics, context);
			case EditormodelPackage.VISUAL_MODEL:
				return validateVisualModel((VisualModel)value, diagnostics, context);
			case EditormodelPackage.ADAPTER:
				return validateAdapter((Adapter)value, diagnostics, context);
			case EditormodelPackage.CONNECTION_BENDPOINT:
				return validateConnectionBendpoint((ConnectionBendpoint)value, diagnostics, context);
			case EditormodelPackage.CONNECTION_VISUAL_MODEL:
				return validateConnectionVisualModel((ConnectionVisualModel)value, diagnostics, context);
			case EditormodelPackage.NODE_VISUAL_MODEL:
				return validateNodeVisualModel((NodeVisualModel)value, diagnostics, context);
			case EditormodelPackage.FOLDER:
				return validateFolder((Folder)value, diagnostics, context);
			case EditormodelPackage.COLOR:
				return validateColor((Color)value, diagnostics, context);
			case EditormodelPackage.DIMENSION:
				return validateDimension((Dimension)value, diagnostics, context);
			case EditormodelPackage.POINT:
				return validatePoint((Point)value, diagnostics, context);
			case EditormodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY:
				return validateEStringToEObjectMapEntry((Map.Entry)value, diagnostics, context);
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP:
				return validateVisualDiagramJump((VisualDiagramJump)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDiagram(Diagram diagram, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(diagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlabotFileModel(FlabotFileModel flabotFileModel, DiagnosticChain diagnostics, Map context) {
		boolean result = validate_EveryMultiplicityConforms(flabotFileModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(flabotFileModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(flabotFileModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(flabotFileModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlabotFileModel_InterfaceLinkMappedToPathGeneral(flabotFileModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlabotFileModel_ComponentUniqueName(flabotFileModel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the InterfaceLinkMappedToPathGeneral constraint of '<em>Flabot File Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFlabotFileModel_InterfaceLinkMappedToPathGeneral(FlabotFileModel flabotFileModel, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				InterfaceLinkMappedToPathGeneralConstraint.CONSTRAINT_KEY,
				flabotFileModel, diagnostics, context);
	}

	/**
	 * Validates the ComponentUniqueName constraint of '<em>Flabot File Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFlabotFileModel_ComponentUniqueName(FlabotFileModel flabotFileModel, DiagnosticChain diagnostics, Map context) {
		// Delegate this to the consistency manager
		return ConsistencyManager.INSTANCE.validate(
				ComponentUniqueNameConstraint.CONSTRAINT_KEY,
				flabotFileModel, diagnostics, context);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisualModel(VisualModel visualModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(visualModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateAdapter(Adapter adapter, DiagnosticChain diagnostics, Map context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionBendpoint(ConnectionBendpoint connectionBendpoint, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(connectionBendpoint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnectionVisualModel(ConnectionVisualModel connectionVisualModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(connectionVisualModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeVisualModel(NodeVisualModel nodeVisualModel, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(nodeVisualModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFolder(Folder folder, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(folder, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateColor(Color color, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(color, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDimension(Dimension dimension, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(dimension, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePoint(Point point, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(point, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEStringToEObjectMapEntry(Map.Entry eStringToEObjectMapEntry, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint((EObject)eStringToEObjectMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVisualDiagramJump(VisualDiagramJump visualDiagramJump, DiagnosticChain diagnostics, Map context) {
		return validate_EveryDefaultConstraint(visualDiagramJump, diagnostics, context);
	}

} //EditormodelValidator
