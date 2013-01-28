/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponsibilityNodeImpl.java,v 1.23 2006/02/23 00:05:13 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Responsibility Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl#getResponsibility <em>Responsibility</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl#getRole <em>Role</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl#getInputsCount <em>Inputs Count</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ResponsibilityNodeImpl#getOutputsCount <em>Outputs Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponsibilityNodeImpl extends SimplePathNodeImpl implements ResponsibilityNode {
	/**
	 * The cached value of the '{@link #getResponsibility() <em>Responsibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibility()
	 * @generated
	 * @ordered
	 */
	protected Responsibility responsibility;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected ComponentRole role;

	/**
	 * The default value of the '{@link #getInputsCount() <em>Inputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INPUTS_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getInputsCount() <em>Inputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputsCount()
	 * @generated
	 * @ordered
	 */
	protected int inputsCount = INPUTS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputsCount() <em>Outputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int OUTPUTS_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getOutputsCount() <em>Outputs Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputsCount()
	 * @generated
	 * @ordered
	 */
	protected int outputsCount = OUTPUTS_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponsibilityNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.RESPONSIBILITY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public Vector getPrologCode(Object value) {
		String ret = ""; //$NON-NLS-1$
	    String head = "assert(responsibility("; //$NON-NLS-1$
	    String tail = ",Scenario,object))."; //$NON-NLS-1$
	    ret += head +this.getID()+"," + this.getRole().getID()+tail; //$NON-NLS-1$
		Hashtable responsibilities = (Hashtable) value;
		Responsibility responsibility = this.getResponsibility();
		Vector prologCode = new Vector();
		prologCode.add(ret);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility getResponsibility() {
		if (responsibility != null && responsibility.eIsProxy()) {
			InternalEObject oldResponsibility = (InternalEObject)responsibility;
			responsibility = (Responsibility)eResolveProxy(oldResponsibility);
			if (responsibility != oldResponsibility) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY, oldResponsibility, responsibility));
			}
		}
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Responsibility basicGetResponsibility() {
		return responsibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsibilityGen(Responsibility newResponsibility) {
		Responsibility oldResponsibility = responsibility;
		responsibility = newResponsibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY, oldResponsibility, responsibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setResponsibility(Responsibility newResponsibility) {
		EObject oldResponsibility = responsibility;
		setResponsibilityGen(newResponsibility);
		if (oldResponsibility != null)
			oldResponsibility.eAdapters().remove(this);
		if (newResponsibility != null)
			newResponsibility.eAdapters().add(this);}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (ComponentRole)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.RESPONSIBILITY_NODE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentRole basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(ComponentRole newRole) {
		ComponentRole oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY_NODE__ROLE, oldRole, role));
	}

	public int getInputsCount() {
		return inputsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputsCount(int newInputsCount) {
		int oldInputsCount = inputsCount;
		inputsCount = newInputsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY_NODE__INPUTS_COUNT, oldInputsCount, inputsCount));
	}

	public int getOutputsCount() {
		return outputsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputsCount(int newOutputsCount) {
		int oldOutputsCount = outputsCount;
		outputsCount = newOutputsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RESPONSIBILITY_NODE__OUTPUTS_COUNT, oldOutputsCount, outputsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY:
				if (resolve) return getResponsibility();
				return basicGetResponsibility();
			case CoremodelPackage.RESPONSIBILITY_NODE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
			case CoremodelPackage.RESPONSIBILITY_NODE__INPUTS_COUNT:
				return new Integer(getInputsCount());
			case CoremodelPackage.RESPONSIBILITY_NODE__OUTPUTS_COUNT:
				return new Integer(getOutputsCount());
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
			case CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY:
				setResponsibility((Responsibility)newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__ROLE:
				setRole((ComponentRole)newValue);
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__INPUTS_COUNT:
				setInputsCount(((Integer)newValue).intValue());
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__OUTPUTS_COUNT:
				setOutputsCount(((Integer)newValue).intValue());
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
			case CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY:
				setResponsibility((Responsibility)null);
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__ROLE:
				setRole((ComponentRole)null);
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__INPUTS_COUNT:
				setInputsCount(INPUTS_COUNT_EDEFAULT);
				return;
			case CoremodelPackage.RESPONSIBILITY_NODE__OUTPUTS_COUNT:
				setOutputsCount(OUTPUTS_COUNT_EDEFAULT);
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
			case CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY:
				return responsibility != null;
			case CoremodelPackage.RESPONSIBILITY_NODE__ROLE:
				return role != null;
			case CoremodelPackage.RESPONSIBILITY_NODE__INPUTS_COUNT:
				return inputsCount != INPUTS_COUNT_EDEFAULT;
			case CoremodelPackage.RESPONSIBILITY_NODE__OUTPUTS_COUNT:
				return outputsCount != OUTPUTS_COUNT_EDEFAULT;
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
		result.append(" (inputsCount: ");
		result.append(inputsCount);
		result.append(", outputsCount: ");
		result.append(outputsCount);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if (this.getResponsibility()!=null)
			return this.getResponsibility().getName();
		return "";
	}
	
	/**
	 * Adapter implementation
	 */

	public void notifyChanged(Notification notification) {
		if (eNotificationRequired())
			eNotify(notification);
	}

	public Notifier getTarget() {
		return getResponsibility();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return Notifier.class.isAssignableFrom((Class)type);
	}
	

} //ResponsibilityNodeImpl
