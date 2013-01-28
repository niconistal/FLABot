/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionInfoManagerImpl.java,v 1.2 2006/02/03 21:03:06 dacostae Exp $
 */
package org.isistan.flabot.executionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Info Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoManagerImpl#getExecutions <em>Executions</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoManagerImpl#getCurrentExecution <em>Current Execution</em>}</li>
 *   <li>{@link org.isistan.flabot.executionmodel.impl.ExecutionInfoManagerImpl#getFileModel <em>File Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionInfoManagerImpl extends EObjectImpl implements ExecutionInfoManager {
	/**
	 * The cached value of the '{@link #getExecutions() <em>Executions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutions()
	 * @generated
	 * @ordered
	 */
	protected EList executions = null;

	/**
	 * The cached value of the '{@link #getCurrentExecution() <em>Current Execution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecution()
	 * @generated
	 * @ordered
	 */
	protected ExecutionInfo currentExecution = null;

	/**
	 * The cached value of the '{@link #getFileModel() <em>File Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileModel()
	 * @generated
	 * @ordered
	 */
	protected FlabotFileModel fileModel = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionInfoManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionmodelPackage.eINSTANCE.getExecutionInfoManager();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExecutions() {
		if (executions == null) {
			executions = new EObjectContainmentEList(ExecutionInfo.class, this, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS);
		}
		return executions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionInfo getCurrentExecution() {
		return currentExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCurrentExecution(ExecutionInfo newCurrentExecution, NotificationChain msgs) {
		ExecutionInfo oldCurrentExecution = currentExecution;
		currentExecution = newCurrentExecution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION, oldCurrentExecution, newCurrentExecution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentExecutionGen(ExecutionInfo newCurrentExecution) {
		if (newCurrentExecution != currentExecution) {
			NotificationChain msgs = null;
			if (currentExecution != null)
				msgs = ((InternalEObject)currentExecution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION, null, msgs);
			if (newCurrentExecution != null)
				msgs = ((InternalEObject)newCurrentExecution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION, null, msgs);
			msgs = basicSetCurrentExecution(newCurrentExecution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION, newCurrentExecution, newCurrentExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrentExecution(ExecutionInfo newCurrentExecution) {
		EObject oldCurrentExecution = currentExecution;
		setCurrentExecutionGen(newCurrentExecution);
		if (oldCurrentExecution != null)
			oldCurrentExecution.eAdapters().remove(this);
		if (newCurrentExecution != null)
			newCurrentExecution.eAdapters().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel getFileModel() {
		if (fileModel != null && fileModel.eIsProxy()) {
			FlabotFileModel oldFileModel = fileModel;
			fileModel = (FlabotFileModel)eResolveProxy((InternalEObject)fileModel);
			if (fileModel != oldFileModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL, oldFileModel, fileModel));
			}
		}
		return fileModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel basicGetFileModel() {
		return fileModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileModel(FlabotFileModel newFileModel) {
		FlabotFileModel oldFileModel = fileModel;
		fileModel = newFileModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL, oldFileModel, fileModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS:
					return ((InternalEList)getExecutions()).basicRemove(otherEnd, msgs);
				case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
					return basicSetCurrentExecution(null, msgs);
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
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS:
				return getExecutions();
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
				return getCurrentExecution();
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL:
				if (resolve) return getFileModel();
				return basicGetFileModel();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS:
				getExecutions().clear();
				getExecutions().addAll((Collection)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
				setCurrentExecution((ExecutionInfo)newValue);
				return;
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL:
				setFileModel((FlabotFileModel)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS:
				getExecutions().clear();
				return;
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
				setCurrentExecution((ExecutionInfo)null);
				return;
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL:
				setFileModel((FlabotFileModel)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS:
				return executions != null && !executions.isEmpty();
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
				return currentExecution != null;
			case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__FILE_MODEL:
				return fileModel != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * Adapter implementation
	 */

	public void notifyChanged(Notification notification) {
		if (eNotificationRequired())
			eNotify(notification);
	}

	public org.eclipse.emf.common.notify.Notifier getTarget() {
		return getCurrentExecution();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return Notifier.class.isAssignableFrom((Class)type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	
	public void addExecution() {
		ExecutionInfo executionInfo = ExecutionmodelFactory.eINSTANCE.createExecutionInfo();	
		if (executions == null) {
			executions = new EObjectContainmentEList(ExecutionInfo.class, this, ExecutionmodelPackage.EXECUTION_INFO_MANAGER__EXECUTIONS);
		}
		this.executions.add(executionInfo);
		setCurrentExecution(executionInfo);	
	}

} //ExecutionInfoManagerImpl
