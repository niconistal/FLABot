/**
 * <copyright>
 * </copyright>
 *
 * $Id: StubNodeImpl.java,v 1.12 2006/02/23 23:34:50 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stub Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.StubNodeImpl#getStartPointReference <em>Start Point Reference</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.StubNodeImpl#getEndPointReference <em>End Point Reference</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.StubNodeImpl#getReferencedMap <em>Referenced Map</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.StubNodeImpl#getFamily <em>Family</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StubNodeImpl extends SimplePathNodeImpl implements StubNode {
	/**
	 * The cached value of the '{@link #getStartPointReference() <em>Start Point Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPointReference()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode startPointReference;

	/**
	 * The cached value of the '{@link #getEndPointReference() <em>End Point Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPointReference()
	 * @generated
	 * @ordered
	 */
	protected SimplePathNode endPointReference;

	/**
	 * The cached value of the '{@link #getReferencedMap() <em>Referenced Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedMap()
	 * @generated
	 * @ordered
	 */
	protected UseCaseMap referencedMap;

	/**
	 * The cached value of the '{@link #getFamily() <em>Family</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamily()
	 * @generated
	 * @ordered
	 */
	protected Family family;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StubNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.STUB_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getStartPointReference() {
		if (startPointReference != null && startPointReference.eIsProxy()) {
			InternalEObject oldStartPointReference = (InternalEObject)startPointReference;
			startPointReference = (SimplePathNode)eResolveProxy(oldStartPointReference);
			if (startPointReference != oldStartPointReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.STUB_NODE__START_POINT_REFERENCE, oldStartPointReference, startPointReference));
			}
		}
		return startPointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetStartPointReference() {
		return startPointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPointReference(SimplePathNode newStartPointReference) {
		SimplePathNode oldStartPointReference = startPointReference;
		startPointReference = newStartPointReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.STUB_NODE__START_POINT_REFERENCE, oldStartPointReference, startPointReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode getEndPointReference() {
		if (endPointReference != null && endPointReference.eIsProxy()) {
			InternalEObject oldEndPointReference = (InternalEObject)endPointReference;
			endPointReference = (SimplePathNode)eResolveProxy(oldEndPointReference);
			if (endPointReference != oldEndPointReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.STUB_NODE__END_POINT_REFERENCE, oldEndPointReference, endPointReference));
			}
		}
		return endPointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePathNode basicGetEndPointReference() {
		return endPointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPointReference(SimplePathNode newEndPointReference) {
		SimplePathNode oldEndPointReference = endPointReference;
		endPointReference = newEndPointReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.STUB_NODE__END_POINT_REFERENCE, oldEndPointReference, endPointReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap getReferencedMap() {
		if (referencedMap != null && referencedMap.eIsProxy()) {
			InternalEObject oldReferencedMap = (InternalEObject)referencedMap;
			referencedMap = (UseCaseMap)eResolveProxy(oldReferencedMap);
			if (referencedMap != oldReferencedMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.STUB_NODE__REFERENCED_MAP, oldReferencedMap, referencedMap));
			}
		}
		return referencedMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMap basicGetReferencedMap() {
		return referencedMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedMap(UseCaseMap newReferencedMap) {
		UseCaseMap oldReferencedMap = referencedMap;
		referencedMap = newReferencedMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.STUB_NODE__REFERENCED_MAP, oldReferencedMap, referencedMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family getFamily() {
		if (family != null && family.eIsProxy()) {
			InternalEObject oldFamily = (InternalEObject)family;
			family = (Family)eResolveProxy(oldFamily);
			if (family != oldFamily) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.STUB_NODE__FAMILY, oldFamily, family));
			}
		}
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Family basicGetFamily() {
		return family;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFamily(Family newFamily) {
		Family oldFamily = family;
		family = newFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.STUB_NODE__FAMILY, oldFamily, family));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.STUB_NODE__START_POINT_REFERENCE:
				if (resolve) return getStartPointReference();
				return basicGetStartPointReference();
			case CoremodelPackage.STUB_NODE__END_POINT_REFERENCE:
				if (resolve) return getEndPointReference();
				return basicGetEndPointReference();
			case CoremodelPackage.STUB_NODE__REFERENCED_MAP:
				if (resolve) return getReferencedMap();
				return basicGetReferencedMap();
			case CoremodelPackage.STUB_NODE__FAMILY:
				if (resolve) return getFamily();
				return basicGetFamily();
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
			case CoremodelPackage.STUB_NODE__START_POINT_REFERENCE:
				setStartPointReference((SimplePathNode)newValue);
				return;
			case CoremodelPackage.STUB_NODE__END_POINT_REFERENCE:
				setEndPointReference((SimplePathNode)newValue);
				return;
			case CoremodelPackage.STUB_NODE__REFERENCED_MAP:
				setReferencedMap((UseCaseMap)newValue);
				return;
			case CoremodelPackage.STUB_NODE__FAMILY:
				setFamily((Family)newValue);
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
			case CoremodelPackage.STUB_NODE__START_POINT_REFERENCE:
				setStartPointReference((SimplePathNode)null);
				return;
			case CoremodelPackage.STUB_NODE__END_POINT_REFERENCE:
				setEndPointReference((SimplePathNode)null);
				return;
			case CoremodelPackage.STUB_NODE__REFERENCED_MAP:
				setReferencedMap((UseCaseMap)null);
				return;
			case CoremodelPackage.STUB_NODE__FAMILY:
				setFamily((Family)null);
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
			case CoremodelPackage.STUB_NODE__START_POINT_REFERENCE:
				return startPointReference != null;
			case CoremodelPackage.STUB_NODE__END_POINT_REFERENCE:
				return endPointReference != null;
			case CoremodelPackage.STUB_NODE__REFERENCED_MAP:
				return referencedMap != null;
			case CoremodelPackage.STUB_NODE__FAMILY:
				return family != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public Vector getPrologCode(Object value) {
		Vector prologCode = new Vector();
		prologCode.add("assert(stub("+this.getID()+")).");
		prologCode.add("assert(stubStartPoint("+this.getID()+","+this.getStartPointReference().getID()+")).");
		prologCode.add("assert(stubEndPoint("+this.getID()+","+this.getEndPointReference().getID()+")).");
		Hashtable responsibilities = (Hashtable) value;
		for (int i=0; i < this.uGetPrevious().size(); i++ ){
		    SimplePathNode responsibilityPreviousNode = getPrevious((SimplePathNode)this.uGetPrevious().get(i));  
			if (responsibilityPreviousNode != null){
				prologCode.add(getPreviousResponsibilityProlog(this,responsibilityPreviousNode,this.getMap().getID()));
				if (!responsibilities.containsKey(responsibilityPreviousNode)){
					responsibilities.put(responsibilityPreviousNode,responsibilityPreviousNode);
					prologCode.addAll(responsibilityPreviousNode.getPrologCode(responsibilities));
				}
			}
		}
		return prologCode;
	}
		
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	private String getPreviousResponsibilityProlog (SimplePathNode responsibility, SimplePathNode responsibilityPrevious, String nameUCM){
		String head = "assert(previous(" + responsibility.getID() + ",";
	    String nextRespCode="";
	    String nextRespBody = ",Event,PrevEvent):- getEventFor(";
	    String nextRespEnd = ",Event,PrevEvent)).";
	    String prevRespID=responsibilityPrevious.getID()+",";
	    String respId=responsibility.getID()+",";
	    nextRespCode += head + responsibilityPrevious.getID() +"," +nameUCM+ nextRespBody +prevRespID+respId+ nameUCM + nextRespEnd;
	    return nextRespCode; 
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	private SimplePathNode getPrevious (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node);
		}	
		else
			if (node.uGetPrevious().size() > 0){
				return getPrevious ((SimplePathNode)node.uGetPrevious().get(0));
			}
			else {
				return null;
			}
	}		


} //StubNodeImpl
