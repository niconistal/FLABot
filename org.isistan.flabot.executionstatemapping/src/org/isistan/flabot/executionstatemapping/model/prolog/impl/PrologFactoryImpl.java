/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrologFactoryImpl extends EFactoryImpl implements PrologFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrologFactory init() {
		try {
			PrologFactory thePrologFactory = (PrologFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/isistan/flabot/executionstatemapping/model.ecore#//prolog"); 
			if (thePrologFactory != null) {
				return thePrologFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PrologFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PrologPackage.PROLOG_CODE_FACTORY: return createPrologCodeFactory();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologCodeFactory createPrologCodeFactory() {
		PrologCodeFactoryImpl prologCodeFactory = new PrologCodeFactoryImpl();
		return prologCodeFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologPackage getPrologPackage() {
		return (PrologPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PrologPackage getPackage() {
		return PrologPackage.eINSTANCE;
	}

} //PrologFactoryImpl
