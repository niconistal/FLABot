/**
 * <copyright>
 * </copyright>
 * $Id: UcmmodelAdapterFactory.java,v 1.64 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.edit.ucmmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.ucmmodel.*;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.edit.ucmmodel.UcmmodelPackage
 * @generated
 */
public class UcmmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UcmmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UcmmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UcmmodelSwitch modelSwitch =
		new UcmmodelSwitch() {
			public Object caseUCMDiagram(UCMDiagram object) {
				return createUCMDiagramAdapter();
			}
			public Object caseAdapter(Adapter object) {
				return createAdapterAdapter();
			}
			public Object caseNamedElementModel(NamedElementModel object) {
				return createNamedElementModelAdapter();
			}
			public Object caseDiagram(Diagram object) {
				return createDiagramAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.edit.ucmmodel.UCMDiagram <em>UCM Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.edit.ucmmodel.UCMDiagram
	 * @generated
	 */
	public Adapter createUCMDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @generated
	 */
	public Adapter createAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.NamedElementModel <em>Named Element Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.NamedElementModel
	 * @generated
	 */
	public Adapter createNamedElementModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.edit.editormodel.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.edit.editormodel.Diagram
	 * @generated
	 */
	public Adapter createDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UcmmodelAdapterFactory
