/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraceConfigurationImpl.java,v 1.4 2006/03/29 21:21:28 dacostae Exp $
 */
package org.isistan.flabot.trace.config.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.trace.config.ConfigPackage;
import org.isistan.flabot.trace.config.Context;
import org.isistan.flabot.trace.config.TraceConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.config.impl.TraceConfigurationImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.config.impl.TraceConfigurationImpl#getOutputFileName <em>Output File Name</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.config.impl.TraceConfigurationImpl#getStartCollecting <em>Start Collecting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceConfigurationImpl extends EObjectImpl implements TraceConfiguration {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList contexts = null;

	/**
	 * The default value of the '{@link #getOutputFileName() <em>Output File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_FILE_NAME_EDEFAULT = "traceOutput.tracelog";

	/**
	 * The cached value of the '{@link #getOutputFileName() <em>Output File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputFileName()
	 * @generated
	 * @ordered
	 */
	protected String outputFileName = OUTPUT_FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartCollecting() <em>Start Collecting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartCollecting()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean START_COLLECTING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartCollecting() <em>Start Collecting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartCollecting()
	 * @generated
	 * @ordered
	 */
	protected Boolean startCollecting = START_COLLECTING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.eINSTANCE.getTraceConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentWithInverseEList(Context.class, this, ConfigPackage.TRACE_CONFIGURATION__CONTEXTS, ConfigPackage.CONTEXT__TRACE_CONFIGURATION);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputFileName(String newOutputFileName) {
		String oldOutputFileName = outputFileName;
		outputFileName = newOutputFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TRACE_CONFIGURATION__OUTPUT_FILE_NAME, oldOutputFileName, outputFileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean getStartCollecting() {
		if(startCollecting==null) {
			return Boolean.FALSE;
		}
		return startCollecting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartCollecting(Boolean newStartCollecting) {
		Boolean oldStartCollecting = startCollecting;
		startCollecting = newStartCollecting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.TRACE_CONFIGURATION__START_COLLECTING, oldStartCollecting, startCollecting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
					return ((InternalEList)getContexts()).basicAdd(otherEnd, msgs);
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
					return ((InternalEList)getContexts()).basicRemove(otherEnd, msgs);
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
			case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
				return getContexts();
			case ConfigPackage.TRACE_CONFIGURATION__OUTPUT_FILE_NAME:
				return getOutputFileName();
			case ConfigPackage.TRACE_CONFIGURATION__START_COLLECTING:
				return getStartCollecting();
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
			case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection)newValue);
				return;
			case ConfigPackage.TRACE_CONFIGURATION__OUTPUT_FILE_NAME:
				setOutputFileName((String)newValue);
				return;
			case ConfigPackage.TRACE_CONFIGURATION__START_COLLECTING:
				setStartCollecting((Boolean)newValue);
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
			case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
				getContexts().clear();
				return;
			case ConfigPackage.TRACE_CONFIGURATION__OUTPUT_FILE_NAME:
				setOutputFileName(OUTPUT_FILE_NAME_EDEFAULT);
				return;
			case ConfigPackage.TRACE_CONFIGURATION__START_COLLECTING:
				setStartCollecting(START_COLLECTING_EDEFAULT);
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
			case ConfigPackage.TRACE_CONFIGURATION__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case ConfigPackage.TRACE_CONFIGURATION__OUTPUT_FILE_NAME:
				return OUTPUT_FILE_NAME_EDEFAULT == null ? outputFileName != null : !OUTPUT_FILE_NAME_EDEFAULT.equals(outputFileName);
			case ConfigPackage.TRACE_CONFIGURATION__START_COLLECTING:
				return START_COLLECTING_EDEFAULT == null ? startCollecting != null : !START_COLLECTING_EDEFAULT.equals(startCollecting);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (outputFileName: ");
		result.append(outputFileName);
		result.append(", startCollecting: ");
		result.append(startCollecting);
		result.append(')');
		return result.toString();
	}

} //TraceConfigurationImpl
