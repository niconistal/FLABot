/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeVisualModelImpl.java,v 1.6 2005/12/06 02:19:36 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Visual Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.NodeVisualModelImpl#getSourceConnections <em>Source Connections</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.NodeVisualModelImpl#getTargetConnections <em>Target Connections</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.NodeVisualModelImpl#getRotation <em>Rotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeVisualModelImpl extends VisualModelImpl implements NodeVisualModel {
	/**
	 * The cached value of the '{@link #getSourceConnections() <em>Source Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceConnections()
	 * @generated
	 * @ordered
	 */
	protected EList sourceConnections = null;

	/**
	 * The cached value of the '{@link #getTargetConnections() <em>Target Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetConnections()
	 * @generated
	 * @ordered
	 */
	protected EList targetConnections = null;

	/**
	 * The default value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected static final String ROTATION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getRotation() <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotation()
	 * @generated
	 * @ordered
	 */
	protected String rotation = ROTATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeVisualModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getNodeVisualModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSourceConnections() {
		if (sourceConnections == null) {
			sourceConnections = new EObjectContainmentWithInverseEList(ConnectionVisualModel.class, this, EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE);
		}
		return sourceConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTargetConnections() {
		if (targetConnections == null) {
			targetConnections = new EObjectWithInverseResolvingEList(ConnectionVisualModel.class, this, EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS, EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET);
		}
		return targetConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotation() {
		return rotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotation(String newRotation) {
		String oldRotation = rotation;
		rotation = newRotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.NODE_VISUAL_MODEL__ROTATION, oldRotation, rotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.NODE_VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
					return ((InternalEList)getTargetConnections()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
					return eBasicSetContainer(null, EditormodelPackage.NODE_VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__LOCATION:
					return basicSetLocation(null, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__SIZE:
					return basicSetSize(null, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
					return eBasicSetContainer(null, EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__BACKGROUND_COLOR:
					return basicSetBackgroundColor(null, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__FOREGROUND_COLOR:
					return basicSetForegroundColor(null, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
					return ((InternalEList)getTargetConnections()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
					return eContainer.eInverseRemove(this, EditormodelPackage.VISUAL_MODEL__CHILDREN, VisualModel.class, msgs);
				case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
					return eContainer.eInverseRemove(this, EditormodelPackage.DIAGRAM__CHILDREN, Diagram.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
				return getChildren();
			case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
				return getParent();
			case EditormodelPackage.NODE_VISUAL_MODEL__SEMANTIC_MODEL:
				if (resolve) return getSemanticModel();
				return basicGetSemanticModel();
			case EditormodelPackage.NODE_VISUAL_MODEL__LOCATION:
				return getLocation();
			case EditormodelPackage.NODE_VISUAL_MODEL__SIZE:
				return getSize();
			case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
				return getDiagram();
			case EditormodelPackage.NODE_VISUAL_MODEL__BACKGROUND_COLOR:
				return getBackgroundColor();
			case EditormodelPackage.NODE_VISUAL_MODEL__FOREGROUND_COLOR:
				return getForegroundColor();
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_STYLE:
				return new Integer(getLineStyle());
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_WIDTH:
				return new Integer(getLineWidth());
			case EditormodelPackage.NODE_VISUAL_MODEL__DETAIL_LEVEL:
				return new Integer(getDetailLevel());
			case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
				return getSourceConnections();
			case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
				return getTargetConnections();
			case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
				return getRotation();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
				setParent((VisualModel)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LOCATION:
				setLocation((Point)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SIZE:
				setSize((Dimension)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_STYLE:
				setLineStyle(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				getSourceConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				getTargetConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
				setRotation((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
				setParent((VisualModel)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LOCATION:
				setLocation((Point)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SIZE:
				setSize((Dimension)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(DETAIL_LEVEL_EDEFAULT);
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				return;
			case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
				setRotation(ROTATION_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.NODE_VISUAL_MODEL__CHILDREN:
				return children != null && !children.isEmpty();
			case EditormodelPackage.NODE_VISUAL_MODEL__PARENT:
				return getParent() != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__SEMANTIC_MODEL:
				return semanticModel != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__LOCATION:
				return location != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__SIZE:
				return size != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__DIAGRAM:
				return getDiagram() != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__BACKGROUND_COLOR:
				return backgroundColor != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__FOREGROUND_COLOR:
				return foregroundColor != null;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case EditormodelPackage.NODE_VISUAL_MODEL__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case EditormodelPackage.NODE_VISUAL_MODEL__DETAIL_LEVEL:
				return detailLevel != DETAIL_LEVEL_EDEFAULT;
			case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
				return sourceConnections != null && !sourceConnections.isEmpty();
			case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
				return targetConnections != null && !targetConnections.isEmpty();
			case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
				return ROTATION_EDEFAULT == null ? rotation != null : !ROTATION_EDEFAULT.equals(rotation);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rotation: ");
		result.append(rotation);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.ucmmodel.NodeVisualModel#getAbsoluteLocation()
	 */
	public Point getAbsoluteLocation() {
		Point parentLocation = null;
		VisualModel parent = getParent();
		if (parent != null && parent instanceof NodeVisualModel) {
			parentLocation =
				((NodeVisualModel)parent).getAbsoluteLocation();
		}
		if (parentLocation != null) {
			Point absoluteLocation=EditormodelFactory.eINSTANCE.createPoint();
			absoluteLocation.setX(parentLocation.getX() + getLocation().getX());
			absoluteLocation.setY(parentLocation.getY() + getLocation().getY());
			return absoluteLocation;
		}
		else
			return getLocation();
	}

} //NodeVisualModelImpl
