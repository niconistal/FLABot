/**
 * <copyright>
 * </copyright>
 *
 * $Id: VisualDiagramJumpImpl.java,v 1.1 2006/02/21 00:46:22 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visual Diagram Jump</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl#getSourceDiagram <em>Source Diagram</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl#getTargetDiagram <em>Target Diagram</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl#getTargetVisualNode <em>Target Visual Node</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualDiagramJumpImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisualDiagramJumpImpl extends NodeVisualModelImpl implements VisualDiagramJump {
	/**
	 * The cached value of the '{@link #getSourceDiagram() <em>Source Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram sourceDiagram = null;

	/**
	 * The cached value of the '{@link #getTargetDiagram() <em>Target Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram targetDiagram = null;

	/**
	 * The cached value of the '{@link #getTargetVisualNode() <em>Target Visual Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVisualNode()
	 * @generated
	 * @ordered
	 */
	protected NodeVisualModel targetVisualNode = null;

	/**
	 * The default value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean TO_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Boolean to = TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualDiagramJumpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getVisualDiagramJump();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getSourceDiagram() {
		if (sourceDiagram != null && sourceDiagram.eIsProxy()) {
			Diagram oldSourceDiagram = sourceDiagram;
			sourceDiagram = (Diagram)eResolveProxy((InternalEObject)sourceDiagram);
			if (sourceDiagram != oldSourceDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM, oldSourceDiagram, sourceDiagram));
			}
		}
		return sourceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetSourceDiagram() {
		return sourceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceDiagram(Diagram newSourceDiagram) {
		Diagram oldSourceDiagram = sourceDiagram;
		sourceDiagram = newSourceDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM, oldSourceDiagram, sourceDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getTargetDiagram() {
		if (targetDiagram != null && targetDiagram.eIsProxy()) {
			Diagram oldTargetDiagram = targetDiagram;
			targetDiagram = (Diagram)eResolveProxy((InternalEObject)targetDiagram);
			if (targetDiagram != oldTargetDiagram) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM, oldTargetDiagram, targetDiagram));
			}
		}
		return targetDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetTargetDiagram() {
		return targetDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetDiagram(Diagram newTargetDiagram) {
		Diagram oldTargetDiagram = targetDiagram;
		targetDiagram = newTargetDiagram;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM, oldTargetDiagram, targetDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel getTargetVisualNode() {
		if (targetVisualNode != null && targetVisualNode.eIsProxy()) {
			NodeVisualModel oldTargetVisualNode = targetVisualNode;
			targetVisualNode = (NodeVisualModel)eResolveProxy((InternalEObject)targetVisualNode);
			if (targetVisualNode != oldTargetVisualNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE, oldTargetVisualNode, targetVisualNode));
			}
		}
		return targetVisualNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel basicGetTargetVisualNode() {
		return targetVisualNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetVisualNode(NodeVisualModel newTargetVisualNode) {
		NodeVisualModel oldTargetVisualNode = targetVisualNode;
		targetVisualNode = newTargetVisualNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE, oldTargetVisualNode, targetVisualNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(Boolean newTo) {
		Boolean oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_DIAGRAM_JUMP__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
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
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
					return eBasicSetContainer(null, EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LOCATION:
					return basicSetLocation(null, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SIZE:
					return basicSetSize(null, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
					return eBasicSetContainer(null, EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR:
					return basicSetBackgroundColor(null, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR:
					return basicSetForegroundColor(null, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
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
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
					return eContainer.eInverseRemove(this, EditormodelPackage.VISUAL_MODEL__CHILDREN, VisualModel.class, msgs);
				case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
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
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
				return getChildren();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
				return getParent();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SEMANTIC_MODEL:
				if (resolve) return getSemanticModel();
				return basicGetSemanticModel();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LOCATION:
				return getLocation();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SIZE:
				return getSize();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
				return getDiagram();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR:
				return getBackgroundColor();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR:
				return getForegroundColor();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_STYLE:
				return new Integer(getLineStyle());
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_WIDTH:
				return new Integer(getLineWidth());
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DETAIL_LEVEL:
				return new Integer(getDetailLevel());
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
				return getSourceConnections();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
				return getTargetConnections();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__ROTATION:
				return getRotation();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM:
				if (resolve) return getSourceDiagram();
				return basicGetSourceDiagram();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM:
				if (resolve) return getTargetDiagram();
				return basicGetTargetDiagram();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE:
				if (resolve) return getTargetVisualNode();
				return basicGetTargetVisualNode();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TO:
				return getTo();
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
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
				setParent((VisualModel)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SEMANTIC_MODEL:
				setSemanticModel((EObject)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LOCATION:
				setLocation((Point)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SIZE:
				setSize((Dimension)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
				setDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_STYLE:
				setLineStyle(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_WIDTH:
				setLineWidth(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DETAIL_LEVEL:
				setDetailLevel(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				getSourceConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				getTargetConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__ROTATION:
				setRotation((String)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM:
				setSourceDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM:
				setTargetDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE:
				setTargetVisualNode((NodeVisualModel)newValue);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TO:
				setTo((Boolean)newValue);
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
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
				getChildren().clear();
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
				setParent((VisualModel)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SEMANTIC_MODEL:
				setSemanticModel((EObject)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LOCATION:
				setLocation((Point)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SIZE:
				setSize((Dimension)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
				setDiagram((Diagram)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DETAIL_LEVEL:
				setDetailLevel(DETAIL_LEVEL_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__ROTATION:
				setRotation(ROTATION_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM:
				setSourceDiagram((Diagram)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM:
				setTargetDiagram((Diagram)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE:
				setTargetVisualNode((NodeVisualModel)null);
				return;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TO:
				setTo(TO_EDEFAULT);
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
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__CHILDREN:
				return children != null && !children.isEmpty();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__PARENT:
				return getParent() != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SEMANTIC_MODEL:
				return semanticModel != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LOCATION:
				return location != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SIZE:
				return size != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DIAGRAM:
				return getDiagram() != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__BACKGROUND_COLOR:
				return backgroundColor != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__FOREGROUND_COLOR:
				return foregroundColor != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__DETAIL_LEVEL:
				return detailLevel != DETAIL_LEVEL_EDEFAULT;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_CONNECTIONS:
				return sourceConnections != null && !sourceConnections.isEmpty();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_CONNECTIONS:
				return targetConnections != null && !targetConnections.isEmpty();
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__ROTATION:
				return ROTATION_EDEFAULT == null ? rotation != null : !ROTATION_EDEFAULT.equals(rotation);
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__SOURCE_DIAGRAM:
				return sourceDiagram != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_DIAGRAM:
				return targetDiagram != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TARGET_VISUAL_NODE:
				return targetVisualNode != null;
			case EditormodelPackage.VISUAL_DIAGRAM_JUMP__TO:
				return TO_EDEFAULT == null ? to != null : !TO_EDEFAULT.equals(to);
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
		result.append(" (to: ");
		result.append(to);
		result.append(')');
		return result.toString();
	}

} //VisualDiagramJumpImpl
