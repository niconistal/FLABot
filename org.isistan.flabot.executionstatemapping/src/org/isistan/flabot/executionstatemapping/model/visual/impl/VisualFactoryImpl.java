/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.visual.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;
import org.isistan.flabot.executionstatemapping.model.visual.VisualFactory;
import org.isistan.flabot.executionstatemapping.model.visual.VisualPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualFactoryImpl extends EFactoryImpl implements VisualFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualFactory init() {
		try {
			VisualFactory theVisualFactory = (VisualFactory)EPackage.Registry.INSTANCE.getEFactory("http:///org/isistan/flabot/executionstatemapping/model.ecore#//visual"); 
			if (theVisualFactory != null) {
				return theVisualFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VisualFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualFactoryImpl() {
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
			case VisualPackage.STATE_DIAGRAM: return createStateDiagram();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDiagram createStateDiagram() {
		StateDiagramImpl stateDiagram = new StateDiagramImpl();
		return stateDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualPackage getVisualPackage() {
		return (VisualPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VisualPackage getPackage() {
		return VisualPackage.eINSTANCE;
	}

} //VisualFactoryImpl
