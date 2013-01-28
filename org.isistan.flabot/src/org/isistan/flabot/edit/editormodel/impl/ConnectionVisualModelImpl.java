/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectionVisualModelImpl.java,v 1.7 2005/12/06 02:19:36 franco Exp $
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Visual Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl#getSourceTerminal <em>Source Terminal</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl#getTargetTerminal <em>Target Terminal</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionVisualModelImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionVisualModelImpl extends NodeVisualModelImpl implements ConnectionVisualModel {
	/**
	 * The default value of the '{@link #getSourceTerminal() <em>Source Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TERMINAL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSourceTerminal() <em>Source Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTerminal()
	 * @generated
	 * @ordered
	 */
	protected String sourceTerminal = SOURCE_TERMINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetTerminal() <em>Target Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTerminal()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TERMINAL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTargetTerminal() <em>Target Terminal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTerminal()
	 * @generated
	 * @ordered
	 */
	protected String targetTerminal = TARGET_TERMINAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList bendpoints = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected NodeVisualModel target = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionVisualModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getConnectionVisualModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceTerminal() {
		return sourceTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceTerminal(String newSourceTerminal) {
		String oldSourceTerminal = sourceTerminal;
		sourceTerminal = newSourceTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL, oldSourceTerminal, sourceTerminal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetTerminal() {
		return targetTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetTerminal(String newTargetTerminal) {
		String oldTargetTerminal = targetTerminal;
		targetTerminal = newTargetTerminal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL, oldTargetTerminal, targetTerminal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList(ConnectionBendpoint.class, this, EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel getSource() {
		if (eContainerFeatureID != EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE) return null;
		return (NodeVisualModel)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(NodeVisualModel newSource) {
		if (newSource != eContainer || (eContainerFeatureID != EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS, NodeVisualModel.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newSource, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel getTarget() {
		if (target != null && target.eIsProxy()) {
			NodeVisualModel oldTarget = target;
			target = (NodeVisualModel)eResolveProxy((InternalEObject)target);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeVisualModel basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(NodeVisualModel newTarget, NotificationChain msgs) {
		NodeVisualModel oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(NodeVisualModel newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS, NodeVisualModel.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS, NodeVisualModel.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
					return ((InternalEList)getTargetConnections()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
					if (target != null)
						msgs = ((InternalEObject)target).eInverseRemove(this, EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS, NodeVisualModel.class, msgs);
					return basicSetTarget((NodeVisualModel)otherEnd, msgs);
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
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
					return eBasicSetContainer(null, EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__LOCATION:
					return basicSetLocation(null, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SIZE:
					return basicSetSize(null, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
					return eBasicSetContainer(null, EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR:
					return basicSetBackgroundColor(null, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR:
					return basicSetForegroundColor(null, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
					return ((InternalEList)getSourceConnections()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
					return ((InternalEList)getTargetConnections()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS:
					return ((InternalEList)getBendpoints()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
					return eBasicSetContainer(null, EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
					return basicSetTarget(null, msgs);
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
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
					return eContainer.eInverseRemove(this, EditormodelPackage.VISUAL_MODEL__CHILDREN, VisualModel.class, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
					return eContainer.eInverseRemove(this, EditormodelPackage.DIAGRAM__CHILDREN, Diagram.class, msgs);
				case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
					return eContainer.eInverseRemove(this, EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS, NodeVisualModel.class, msgs);
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
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
				return getChildren();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
				return getParent();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SEMANTIC_MODEL:
				if (resolve) return getSemanticModel();
				return basicGetSemanticModel();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LOCATION:
				return getLocation();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SIZE:
				return getSize();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
				return getDiagram();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR:
				return getBackgroundColor();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR:
				return getForegroundColor();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_STYLE:
				return new Integer(getLineStyle());
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_WIDTH:
				return new Integer(getLineWidth());
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DETAIL_LEVEL:
				return new Integer(getDetailLevel());
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
				return getSourceConnections();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
				return getTargetConnections();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__ROTATION:
				return getRotation();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL:
				return getSourceTerminal();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL:
				return getTargetTerminal();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS:
				return getBendpoints();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
				return getSource();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
				setParent((VisualModel)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LOCATION:
				setLocation((Point)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SIZE:
				setSize((Dimension)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_STYLE:
				setLineStyle(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				getSourceConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				getTargetConnections().addAll((Collection)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__ROTATION:
				setRotation((String)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL:
				setSourceTerminal((String)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL:
				setTargetTerminal((String)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS:
				getBendpoints().clear();
				getBendpoints().addAll((Collection)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
				setSource((NodeVisualModel)newValue);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
				setTarget((NodeVisualModel)newValue);
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
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
				setParent((VisualModel)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LOCATION:
				setLocation((Point)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SIZE:
				setSize((Dimension)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(DETAIL_LEVEL_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
				getSourceConnections().clear();
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
				getTargetConnections().clear();
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__ROTATION:
				setRotation(ROTATION_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL:
				setSourceTerminal(SOURCE_TERMINAL_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL:
				setTargetTerminal(TARGET_TERMINAL_EDEFAULT);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS:
				getBendpoints().clear();
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
				setSource((NodeVisualModel)null);
				return;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
				setTarget((NodeVisualModel)null);
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
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__CHILDREN:
				return children != null && !children.isEmpty();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__PARENT:
				return getParent() != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SEMANTIC_MODEL:
				return semanticModel != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LOCATION:
				return location != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SIZE:
				return size != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DIAGRAM:
				return getDiagram() != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BACKGROUND_COLOR:
				return backgroundColor != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__FOREGROUND_COLOR:
				return foregroundColor != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__DETAIL_LEVEL:
				return detailLevel != DETAIL_LEVEL_EDEFAULT;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_CONNECTIONS:
				return sourceConnections != null && !sourceConnections.isEmpty();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_CONNECTIONS:
				return targetConnections != null && !targetConnections.isEmpty();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__ROTATION:
				return ROTATION_EDEFAULT == null ? rotation != null : !ROTATION_EDEFAULT.equals(rotation);
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE_TERMINAL:
				return SOURCE_TERMINAL_EDEFAULT == null ? sourceTerminal != null : !SOURCE_TERMINAL_EDEFAULT.equals(sourceTerminal);
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET_TERMINAL:
				return TARGET_TERMINAL_EDEFAULT == null ? targetTerminal != null : !TARGET_TERMINAL_EDEFAULT.equals(targetTerminal);
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__BENDPOINTS:
				return bendpoints != null && !bendpoints.isEmpty();
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__SOURCE:
				return getSource() != null;
			case EditormodelPackage.CONNECTION_VISUAL_MODEL__TARGET:
				return target != null;
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
		result.append(" (sourceTerminal: ");
		result.append(sourceTerminal);
		result.append(", targetTerminal: ");
		result.append(targetTerminal);
		result.append(')');
		return result.toString();
	}

} //ConnectionVisualModelImpl
