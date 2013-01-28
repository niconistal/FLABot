/**
 * <copyright>
 * </copyright>
 * $Id: UcmmodelFactoryImpl.java,v 1.67 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.edit.ucmmodel.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelFactory;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UcmmodelFactoryImpl extends EFactoryImpl implements UcmmodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UcmmodelPackage.UCM_DIAGRAM: return createUCMDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UcmmodelPackage.NOTIFIER:
				return createNotifierFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UcmmodelPackage.NOTIFIER:
				return convertNotifierToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCMDiagram createUCMDiagram() {
		UCMDiagramImpl ucmDiagram = new UCMDiagramImpl();
		return ucmDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notifier createNotifierFromString(EDataType eDataType, String initialValue) {
		return (Notifier)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotifierToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmmodelPackage getUcmmodelPackage() {
		return (UcmmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static UcmmodelPackage getPackage() {
		return UcmmodelPackage.eINSTANCE;
	}

} //UcmmodelFactoryImpl
