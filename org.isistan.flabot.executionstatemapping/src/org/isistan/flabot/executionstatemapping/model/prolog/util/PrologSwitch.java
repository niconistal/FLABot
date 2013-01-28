/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.prolog.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologCodeFactory;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologElement;
import org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage;
import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitedExpressionProlog;
import org.isistan.flabot.executionstatemapping.model.prolog.VisitorExpressionProlog;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.executionstatemapping.model.prolog.PrologPackage
 * @generated
 */
public class PrologSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PrologPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrologSwitch() {
		if (modelPackage == null) {
			modelPackage = PrologPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PrologPackage.PROLOG_ELEMENT: {
				PrologElement prologElement = (PrologElement)theEObject;
				T result = casePrologElement(prologElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrologPackage.TAG_PROVIDER: {
				TagProvider tagProvider = (TagProvider)theEObject;
				T result = caseTagProvider(tagProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrologPackage.PROLOG_CODE_FACTORY: {
				PrologCodeFactory prologCodeFactory = (PrologCodeFactory)theEObject;
				T result = casePrologCodeFactory(prologCodeFactory);
				if (result == null) result = caseVisitorExpressionProlog(prologCodeFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrologPackage.VISITED_EXPRESSION_PROLOG: {
				VisitedExpressionProlog visitedExpressionProlog = (VisitedExpressionProlog)theEObject;
				T result = caseVisitedExpressionProlog(visitedExpressionProlog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrologPackage.VISITOR_EXPRESSION_PROLOG: {
				VisitorExpressionProlog visitorExpressionProlog = (VisitorExpressionProlog)theEObject;
				T result = caseVisitorExpressionProlog(visitorExpressionProlog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrologElement(PrologElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTagProvider(TagProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrologCodeFactory(PrologCodeFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visited Expression Prolog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visited Expression Prolog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitedExpressionProlog(VisitedExpressionProlog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitor Expression Prolog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitor Expression Prolog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitorExpressionProlog(VisitorExpressionProlog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //PrologSwitch
