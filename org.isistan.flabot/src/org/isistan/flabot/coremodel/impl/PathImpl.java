/**
 * <copyright>
 * </copyright>
 *
 * $Id: PathImpl.java,v 1.3 2005/12/01 19:13:52 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathImpl#getEndNodes <em>End Nodes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathImpl#getStartNodes <em>Start Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathImpl extends NamedElementModelImpl implements Path {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList nodes;

	/**
	 * The cached value of the '{@link #getEndNodes() <em>End Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndNodes()
	 * @generated
	 * @ordered
	 */
	protected EList endNodes;

	/**
	 * The cached value of the '{@link #getStartNodes() <em>Start Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartNodes()
	 * @generated
	 * @ordered
	 */
	protected EList startNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList(PathNode.class, this, CoremodelPackage.PATH__NODES, CoremodelPackage.PATH_NODE__PATH);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEndNodes() {
		if (endNodes == null) {
			endNodes = new EObjectResolvingEList(PathNode.class, this, CoremodelPackage.PATH__END_NODES);
		}
		return endNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStartNodes() {
		if (startNodes == null) {
			startNodes = new EObjectResolvingEList(PathNode.class, this, CoremodelPackage.PATH__START_NODES);
		}
		return startNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				return ((InternalEList)getNodes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				return ((InternalEList)getNodes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				return getNodes();
			case CoremodelPackage.PATH__END_NODES:
				return getEndNodes();
			case CoremodelPackage.PATH__START_NODES:
				return getStartNodes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PATH__END_NODES:
				getEndNodes().clear();
				getEndNodes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PATH__START_NODES:
				getStartNodes().clear();
				getStartNodes().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				getNodes().clear();
				return;
			case CoremodelPackage.PATH__END_NODES:
				getEndNodes().clear();
				return;
			case CoremodelPackage.PATH__START_NODES:
				getStartNodes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CoremodelPackage.PATH__NODES:
				return nodes != null && !nodes.isEmpty();
			case CoremodelPackage.PATH__END_NODES:
				return endNodes != null && !endNodes.isEmpty();
			case CoremodelPackage.PATH__START_NODES:
				return startNodes != null && !startNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PathImpl
