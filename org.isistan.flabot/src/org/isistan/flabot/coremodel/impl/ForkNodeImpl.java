/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForkNodeImpl.java,v 1.29 2006/04/06 03:19:38 apersson Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.ForkCondition;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fork Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ForkNodeImpl#getForkType <em>Fork Type</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ForkNodeImpl#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkNodeImpl extends ResponsibilityNodeImpl implements ForkNode {
	/**
	 * The default value of the '{@link #getForkType() <em>Fork Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForkType()
	 * @generated
	 * @ordered
	 */
	protected static final int FORK_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getForkType() <em>Fork Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForkType()
	 * @generated
	 * @ordered
	 */
	protected int forkType = FORK_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList conditions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.FORK_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getForkType() {
		return forkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForkType(int newForkType) {
		int oldForkType = forkType;
		forkType = newForkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.FORK_NODE__FORK_TYPE, oldForkType, forkType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList(ForkCondition.class, this, CoremodelPackage.FORK_NODE__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.FORK_NODE__CONDITIONS:
				return ((InternalEList)getConditions()).basicRemove(otherEnd, msgs);
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
			case CoremodelPackage.FORK_NODE__FORK_TYPE:
				return new Integer(getForkType());
			case CoremodelPackage.FORK_NODE__CONDITIONS:
				return getConditions();
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
			case CoremodelPackage.FORK_NODE__FORK_TYPE:
				setForkType(((Integer)newValue).intValue());
				return;
			case CoremodelPackage.FORK_NODE__CONDITIONS:
				getConditions().clear();
				getConditions().addAll((Collection)newValue);
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
			case CoremodelPackage.FORK_NODE__FORK_TYPE:
				setForkType(FORK_TYPE_EDEFAULT);
				return;
			case CoremodelPackage.FORK_NODE__CONDITIONS:
				getConditions().clear();
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
			case CoremodelPackage.FORK_NODE__FORK_TYPE:
				return forkType != FORK_TYPE_EDEFAULT;
			case CoremodelPackage.FORK_NODE__CONDITIONS:
				return conditions != null && !conditions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (forkType: ");
		result.append(forkType);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.coremodel.impl.PathNodeImpl#getPreviousMax()
	 */
	@Override
	protected int getPreviousMax() {
		return 1;
	}

	@Override
	protected int getPreviousMin() {
		return 0;
	}

	@Override
	protected int getNextMax() {
		return 2;
	}

	@Override
	protected int getNextMin() {
		return 0;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public Vector getPrologCode(Object value) {
		Vector prologCode = new Vector();
		String ret = ""; //$NON-NLS-1$
	    String head = "assert(fork("; //$NON-NLS-1$
	    String tail = ",Scenario,object,"+this.getRole().getID()+"))."; //$NON-NLS-1$
	    ret += head + this.getID() + tail;
	    prologCode.add(ret);
	    Hashtable responsibilities = (Hashtable) value;
	    Responsibility responsibility = this.getResponsibility();
		for (int i=0; i < this.uGetPrevious().size(); i++ ){
		    SimplePathNode responsibilityPreviousNode = getPrevious((SimplePathNode)this.uGetPrevious().get(i));  
			if (responsibilityPreviousNode != null){
				prologCode.add(getPreviousResponsibilityProlog(this,responsibilityPreviousNode,this.getMap().getID()));
				if (!responsibilities.containsKey(responsibilityPreviousNode)){
					responsibilities.put(responsibilityPreviousNode,responsibilityPreviousNode);
					prologCode.addAll(responsibilityPreviousNode.getPrologCode(responsibilities));
				}
			}
			if (responsibility!=null){
				for (int j=0; j < responsibility.getPreconditions().size(); j++){
					Condition condition = ((Condition)responsibility.getPreconditions().get(j));
					prologCode.addAll(condition.getPrologCode(this));
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

	
	

} //ForkNodeImpl
