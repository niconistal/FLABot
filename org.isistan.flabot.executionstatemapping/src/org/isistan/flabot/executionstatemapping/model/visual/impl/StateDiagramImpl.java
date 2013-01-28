/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.isistan.flabot.edit.editormodel.impl.DiagramImpl;

import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.visual.impl.StateDiagramImpl#getSemanticModel <em>Semantic Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateDiagramImpl extends DiagramImpl implements StateDiagram {
	/**
	 * The cached value of the '{@link #getSemanticModel() <em>Semantic Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticModel()
	 * @generated
	 * @ordered
	 */
	protected EObject semanticModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualPackage.Literals.STATE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSemanticModel() {
		if (semanticModel != null && semanticModel.eIsProxy()) {
			InternalEObject oldSemanticModel = (InternalEObject)semanticModel;
			semanticModel = eResolveProxy(oldSemanticModel);
			if (semanticModel != oldSemanticModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL, oldSemanticModel, semanticModel));
			}
		}
		return semanticModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSemanticModel() {
		return semanticModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticModel(EObject newSemanticModel) {
		EObject oldSemanticModel = semanticModel;
		semanticModel = newSemanticModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL, oldSemanticModel, semanticModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
				if (resolve) return getSemanticModel();
				return basicGetSemanticModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
				setSemanticModel((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
				setSemanticModel((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
				return semanticModel != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
				return getSemanticModel();
		}
		return super.eGet(eFeature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
			setSemanticModel((EObject)newValue);
			return;
		}
		super.eSet(eFeature, newValue);
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
			setSemanticModel((EObject)null);
			return;
		}
		super.eUnset(eFeature);
	}

	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case VisualPackage.STATE_DIAGRAM__SEMANTIC_MODEL:
			return semanticModel != null;
		}
		return super.eIsSet(eFeature);
	}

} //StateDiagramImpl
