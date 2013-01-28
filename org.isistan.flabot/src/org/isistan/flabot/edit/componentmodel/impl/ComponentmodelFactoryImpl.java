/**
 * <copyright>
 * </copyright>
 * $Id: ComponentmodelFactoryImpl.java,v 1.74 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.edit.componentmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.componentmodel.ComponentmodelFactory;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentmodelFactoryImpl extends EFactoryImpl implements ComponentmodelFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComponentmodelPackage.COMPONENT_DIAGRAM: return createComponentDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentDiagram createComponentDiagram() {
		ComponentDiagramImpl componentDiagram = new ComponentDiagramImpl();
		return componentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentmodelPackage getComponentmodelPackage() {
		return (ComponentmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ComponentmodelPackage getPackage() {
		return ComponentmodelPackage.eINSTANCE;
	}

} //ComponentmodelFactoryImpl
