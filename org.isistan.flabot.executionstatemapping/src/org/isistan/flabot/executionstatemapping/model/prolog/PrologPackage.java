/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologFactory
 * @model kind="package"
 * @generated
 */
public interface PrologPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "prolog";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/executionstatemapping/model.ecore#//prolog";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.executionstatemapping.model.prolog";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PrologPackage eINSTANCE = org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologElement
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getPrologElement()
	 * @generated
	 */
	int PROLOG_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_ELEMENT__PREDICATE_NAME = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_ELEMENT_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.TagProvider <em>Tag Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.TagProvider
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getTagProvider()
	 * @generated
	 */
	int TAG_PROVIDER = 1;

	/**
	 * The number of structural features of the '<em>Tag Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_PROVIDER_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologCodeFactoryImpl <em>Code Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologCodeFactoryImpl
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getPrologCodeFactory()
	 * @generated
	 */
	int PROLOG_CODE_FACTORY = 2;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog <em>Visited Expression Prolog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getVisitedExpressionProlog()
	 * @generated
	 */
	int VISITED_EXPRESSION_PROLOG = 3;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog <em>Visitor Expression Prolog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getVisitorExpressionProlog()
	 * @generated
	 */
	int VISITOR_EXPRESSION_PROLOG = 4;

	/**
	 * The number of structural features of the '<em>Visitor Expression Prolog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITOR_EXPRESSION_PROLOG_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Code Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROLOG_CODE_FACTORY_FEATURE_COUNT = VISITOR_EXPRESSION_PROLOG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Visited Expression Prolog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITED_EXPRESSION_PROLOG_FEATURE_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologElement
	 * @generated
	 */
	EClass getPrologElement();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement#getPredicateName <em>Predicate Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Predicate Name</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologElement#getPredicateName()
	 * @see #getPrologElement()
	 * @generated
	 */
	EAttribute getPrologElement_PredicateName();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.prolog.TagProvider <em>Tag Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Provider</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.TagProvider
	 * @generated
	 */
	EClass getTagProvider();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory <em>Code Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Factory</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory
	 * @generated
	 */
	EClass getPrologCodeFactory();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog <em>Visited Expression Prolog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visited Expression Prolog</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog
	 * @generated
	 */
	EClass getVisitedExpressionProlog();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog <em>Visitor Expression Prolog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor Expression Prolog</em>'.
	 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog
	 * @generated
	 */
	EClass getVisitorExpressionProlog();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PrologFactory getPrologFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.PrologElement <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologElement
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getPrologElement()
		 * @generated
		 */
		EClass PROLOG_ELEMENT = eINSTANCE.getPrologElement();

		/**
		 * The meta object literal for the '<em><b>Predicate Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROLOG_ELEMENT__PREDICATE_NAME = eINSTANCE.getPrologElement_PredicateName();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.TagProvider <em>Tag Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.TagProvider
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getTagProvider()
		 * @generated
		 */
		EClass TAG_PROVIDER = eINSTANCE.getTagProvider();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologCodeFactoryImpl <em>Code Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologCodeFactoryImpl
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getPrologCodeFactory()
		 * @generated
		 */
		EClass PROLOG_CODE_FACTORY = eINSTANCE.getPrologCodeFactory();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog <em>Visited Expression Prolog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getVisitedExpressionProlog()
		 * @generated
		 */
		EClass VISITED_EXPRESSION_PROLOG = eINSTANCE.getVisitedExpressionProlog();

		/**
		 * The meta object literal for the '{@link org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog <em>Visitor Expression Prolog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog
		 * @see org.isistan.flabot.executionstatemapping.model.prolog.impl.PrologPackageImpl#getVisitorExpressionProlog()
		 * @generated
		 */
		EClass VISITOR_EXPRESSION_PROLOG = eINSTANCE.getVisitorExpressionProlog();

	}

} //PrologPackage
