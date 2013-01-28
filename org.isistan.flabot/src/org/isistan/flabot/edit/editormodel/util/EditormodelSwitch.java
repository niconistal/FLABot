/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditormodelSwitch.java,v 1.59 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.NamedElementModel;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.editormodel.EditormodelPackage
 * @generated
 */
public class EditormodelSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EditormodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditormodelSwitch() {
		if (modelPackage == null) {
			modelPackage = EditormodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EditormodelPackage.DIAGRAM: {
				Diagram diagram = (Diagram)theEObject;
				Object result = caseDiagram(diagram);
				if (result == null) result = caseNamedElementModel(diagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.FLABOT_FILE_MODEL: {
				FlabotFileModel flabotFileModel = (FlabotFileModel)theEObject;
				Object result = caseFlabotFileModel(flabotFileModel);
				if (result == null) result = caseExtensibleElement(flabotFileModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.VISUAL_MODEL: {
				VisualModel visualModel = (VisualModel)theEObject;
				Object result = caseVisualModel(visualModel);
				if (result == null) result = caseAdapter(visualModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.CONNECTION_BENDPOINT: {
				ConnectionBendpoint connectionBendpoint = (ConnectionBendpoint)theEObject;
				Object result = caseConnectionBendpoint(connectionBendpoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.CONNECTION_VISUAL_MODEL: {
				ConnectionVisualModel connectionVisualModel = (ConnectionVisualModel)theEObject;
				Object result = caseConnectionVisualModel(connectionVisualModel);
				if (result == null) result = caseNodeVisualModel(connectionVisualModel);
				if (result == null) result = caseVisualModel(connectionVisualModel);
				if (result == null) result = caseAdapter(connectionVisualModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.NODE_VISUAL_MODEL: {
				NodeVisualModel nodeVisualModel = (NodeVisualModel)theEObject;
				Object result = caseNodeVisualModel(nodeVisualModel);
				if (result == null) result = caseVisualModel(nodeVisualModel);
				if (result == null) result = caseAdapter(nodeVisualModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.FOLDER: {
				Folder folder = (Folder)theEObject;
				Object result = caseFolder(folder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.COLOR: {
				Color color = (Color)theEObject;
				Object result = caseColor(color);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.DIMENSION: {
				Dimension dimension = (Dimension)theEObject;
				Object result = caseDimension(dimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.POINT: {
				Point point = (Point)theEObject;
				Object result = casePoint(point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.ESTRING_TO_EOBJECT_MAP_ENTRY: {
				Map.Entry eStringToEObjectMapEntry = (Map.Entry)theEObject;
				Object result = caseEStringToEObjectMapEntry(eStringToEObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP: {
				VisualDiagramJump visualDiagramJump = (VisualDiagramJump)theEObject;
				Object result = caseVisualDiagramJump(visualDiagramJump);
				if (result == null) result = caseNodeVisualModel(visualDiagramJump);
				if (result == null) result = caseVisualModel(visualDiagramJump);
				if (result == null) result = caseAdapter(visualDiagramJump);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flabot File Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flabot File Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlabotFileModel(FlabotFileModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visual Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisualModel(VisualModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAdapter(Adapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Bendpoint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Bendpoint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConnectionBendpoint(ConnectionBendpoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Visual Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConnectionVisualModel(ConnectionVisualModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Visual Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Visual Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNodeVisualModel(NodeVisualModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFolder(Folder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseColor(Color object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDimension(Dimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EString To EObject Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEStringToEObjectMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visual Diagram Jump</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visual Diagram Jump</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisualDiagramJump(VisualDiagramJump object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNamedElementModel(NamedElementModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //EditormodelSwitch
