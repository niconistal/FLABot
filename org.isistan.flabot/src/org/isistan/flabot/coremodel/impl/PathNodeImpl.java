/**
 * <copyright>
 * </copyright>
 *
 * $Id: PathNodeImpl.java,v 1.14 2006/02/24 01:54:50 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ExtensibleElement;
import org.isistan.flabot.coremodel.InterfacePrologCode;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathNodeImpl#getExtendedData <em>Extended Data</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathNodeImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathNodeImpl#getPrevious <em>Previous</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.PathNodeImpl#getNext <em>Next</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PathNodeImpl extends NoteElementModelImpl implements PathNode {
	/**
	 * The cached value of the '{@link #getExtendedData() <em>Extended Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedData()
	 * @generated
	 * @ordered
	 */
	protected EMap extendedData;

	/**
	 * The cached value of the '{@link #getPrevious() <em>Previous</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevious()
	 * @generated
	 * @ordered
	 */
	protected EList previous;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected EList next;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.PATH_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getExtendedData() {
		if (extendedData == null) {
			extendedData = new EcoreEMap(CoremodelPackage.Literals.ESTRING_TO_EOBJECT_MAP_ENTRY, EStringToEObjectMapEntryImpl.class, this, CoremodelPackage.PATH_NODE__EXTENDED_DATA);
		}
		return extendedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Path getPath() {
		if (eContainerFeatureID() != CoremodelPackage.PATH_NODE__PATH) return null;
		return (Path)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPath(Path newPath, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPath, CoremodelPackage.PATH_NODE__PATH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(Path newPath) {
		if (newPath != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.PATH_NODE__PATH && newPath != null)) {
			if (EcoreUtil.isAncestor(this, newPath))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPath != null)
				msgs = ((InternalEObject)newPath).eInverseAdd(this, CoremodelPackage.PATH__NODES, Path.class, msgs);
			msgs = basicSetPath(newPath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.PATH_NODE__PATH, newPath, newPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPrevious() {
		if (previous == null) {
			previous = new EObjectWithInverseResolvingEList.ManyInverse(PathNode.class, this, CoremodelPackage.PATH_NODE__PREVIOUS, CoremodelPackage.PATH_NODE__NEXT);
		}
		return previous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNext() {
		if (next == null) {
			next = new EObjectWithInverseResolvingEList.ManyInverse(PathNode.class, this, CoremodelPackage.PATH_NODE__NEXT, CoremodelPackage.PATH_NODE__PREVIOUS);
		}
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.PATH_NODE__PATH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPath((Path)otherEnd, msgs);
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				return ((InternalEList)getPrevious()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.PATH_NODE__NEXT:
				return ((InternalEList)getNext()).basicAdd(otherEnd, msgs);
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
			case CoremodelPackage.PATH_NODE__EXTENDED_DATA:
				return ((InternalEList)getExtendedData()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.PATH_NODE__PATH:
				return basicSetPath(null, msgs);
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				return ((InternalEList)getPrevious()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.PATH_NODE__NEXT:
				return ((InternalEList)getNext()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CoremodelPackage.PATH_NODE__PATH:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.PATH__NODES, Path.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.PATH_NODE__EXTENDED_DATA:
				if (coreType) return getExtendedData();
				else return getExtendedData().map();
			case CoremodelPackage.PATH_NODE__PATH:
				return getPath();
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				return getPrevious();
			case CoremodelPackage.PATH_NODE__NEXT:
				return getNext();
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
			case CoremodelPackage.PATH_NODE__EXTENDED_DATA:
				((EStructuralFeature.Setting)getExtendedData()).set(newValue);
				return;
			case CoremodelPackage.PATH_NODE__PATH:
				setPath((Path)newValue);
				return;
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				getPrevious().clear();
				getPrevious().addAll((Collection)newValue);
				return;
			case CoremodelPackage.PATH_NODE__NEXT:
				getNext().clear();
				getNext().addAll((Collection)newValue);
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
			case CoremodelPackage.PATH_NODE__EXTENDED_DATA:
				getExtendedData().clear();
				return;
			case CoremodelPackage.PATH_NODE__PATH:
				setPath((Path)null);
				return;
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				getPrevious().clear();
				return;
			case CoremodelPackage.PATH_NODE__NEXT:
				getNext().clear();
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
			case CoremodelPackage.PATH_NODE__EXTENDED_DATA:
				return extendedData != null && !extendedData.isEmpty();
			case CoremodelPackage.PATH_NODE__PATH:
				return getPath() != null;
			case CoremodelPackage.PATH_NODE__PREVIOUS:
				return previous != null && !previous.isEmpty();
			case CoremodelPackage.PATH_NODE__NEXT:
				return next != null && !next.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == InterfacePrologCode.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.PATH_NODE__EXTENDED_DATA: return CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == InterfacePrologCode.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.EXTENSIBLE_ELEMENT__EXTENDED_DATA: return CoremodelPackage.PATH_NODE__EXTENDED_DATA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#addPrevious(org.isistan.flabot.coremodel.PathNode)
	 */
	public boolean addPrevious(PathNode previous) {
//		if (getPrevious().size() >= getPreviousMax())
	//		throw new UnsupportedOperationException();
		return getPrevious().add(previous);
	}

	
	/**
	 * This method must be implemented to specify how many
	 * previous nodes this type of node may have as maximum.
	 * @return
	 */
	protected abstract int getPreviousMax();

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#removePrevious(org.isistan.flabot.coremodel.PathNode)
	 */
	public boolean removePrevious(PathNode previous) {
//		if (getPrevious().size() <= getPreviousMin())
	//		throw new UnsupportedOperationException();
		return getPrevious().remove(previous);
	}
	
	/**
	 * This method must be implemented to specify how many
	 * previous nodes this type of node may have as minimum.
	 * @return
	 */
	protected abstract int getPreviousMin();

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#addNext(org.isistan.flabot.coremodel.PathNode)
	 */
	public boolean addNext(PathNode next) {
	//	if (getNext().size() >= getNextMax())
		//	throw new UnsupportedOperationException();
		return getNext().add(next);
	}
	
	/**
	 * This method must be implemented to specify how many
	 * next nodes this type of node may have as maximum
	 * @return
	 */
	protected abstract int getNextMax();

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#removeNext(org.isistan.flabot.coremodel.PathNode)
	 */
	public boolean removeNext(PathNode next) {
	//	if (getNext().size() <= getNextMin())
		//	throw new UnsupportedOperationException();
		return getNext().remove(next);
	}

	/**
	 * This method must be implemented to specify how many
	 * next nodes this type of node may have as minimum
	 * @return
	 */
	protected abstract int getNextMin();

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#uGetPrevious()
	 */
	public EList uGetPrevious() {
		return ECollections.unmodifiableEList(getPrevious());
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#uGetNext()
	 */
	public EList uGetNext() {
		return ECollections.unmodifiableEList(getNext());
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#isEnd()
	 */
	public boolean isEnd() {
		return getNext().size() == 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.PathNode#isStart()
	 */
	public boolean isStart() {
		return getPrevious().size() == 0;
	}
	
} //PathNodeImpl
