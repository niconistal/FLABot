/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstateSwitch.java,v 1.20 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.Registrable;
import org.isistan.flabot.engine.executionstate.*;

import org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionstatePackage;
import org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.MappingBasedFilter;
import org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry;
import org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceInferenceStrategy;
import org.isistan.flabot.gauge.GaugeFilter;
import org.isistan.flabot.trace.config.Filter;

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
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage
 * @generated
 */
public class ExecutionstateSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionstatePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionstateSwitch() {
		if (modelPackage == null) {
			modelPackage = ExecutionstatePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExecutionstatePackage.BASIC_MAPPING_BASED_FILTER: {
				BasicMappingBasedFilter basicMappingBasedFilter = (BasicMappingBasedFilter)theEObject;
				Object result = caseBasicMappingBasedFilter(basicMappingBasedFilter);
				if (result == null) result = caseMappingBasedFilter(basicMappingBasedFilter);
				if (result == null) result = caseFilter(basicMappingBasedFilter);
				if (result == null) result = caseFilter_1(basicMappingBasedFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.DIAGNOSTIC: {
				Diagnostic diagnostic = (Diagnostic)theEObject;
				Object result = caseDiagnostic(diagnostic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.MANUAL_STATE_DETERMINATION_STRATEGY: {
				ManualStateDeterminationStrategy manualStateDeterminationStrategy = (ManualStateDeterminationStrategy)theEObject;
				Object result = caseManualStateDeterminationStrategy(manualStateDeterminationStrategy);
				if (result == null) result = caseStateDeterminationStrategy(manualStateDeterminationStrategy);
				if (result == null) result = caseRegistrable(manualStateDeterminationStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.MANUAL_TRACE_INFERENCE_STRATEGY: {
				ManualTraceInferenceStrategy manualTraceInferenceStrategy = (ManualTraceInferenceStrategy)theEObject;
				Object result = caseManualTraceInferenceStrategy(manualTraceInferenceStrategy);
				if (result == null) result = caseTraceInferenceStrategy(manualTraceInferenceStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.MAPPING_BASED_FILTER: {
				MappingBasedFilter mappingBasedFilter = (MappingBasedFilter)theEObject;
				Object result = caseMappingBasedFilter(mappingBasedFilter);
				if (result == null) result = caseFilter(mappingBasedFilter);
				if (result == null) result = caseFilter_1(mappingBasedFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.SIMPLE_TRACE_INFERENCE_STRATEGY: {
				SimpleTraceInferenceStrategy simpleTraceInferenceStrategy = (SimpleTraceInferenceStrategy)theEObject;
				Object result = caseSimpleTraceInferenceStrategy(simpleTraceInferenceStrategy);
				if (result == null) result = caseTraceInferenceStrategy(simpleTraceInferenceStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY: {
				StateDeterminationStrategy stateDeterminationStrategy = (StateDeterminationStrategy)theEObject;
				Object result = caseStateDeterminationStrategy(stateDeterminationStrategy);
				if (result == null) result = caseRegistrable(stateDeterminationStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.STATE_DETERMINATION_STRATEGY_REGISTRY: {
				StateDeterminationStrategyRegistry stateDeterminationStrategyRegistry = (StateDeterminationStrategyRegistry)theEObject;
				Object result = caseStateDeterminationStrategyRegistry(stateDeterminationStrategyRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.TRACE_BASED_STATE_DETERMINATION_STRATEGY: {
				TraceBasedStateDeterminationStrategy traceBasedStateDeterminationStrategy = (TraceBasedStateDeterminationStrategy)theEObject;
				Object result = caseTraceBasedStateDeterminationStrategy(traceBasedStateDeterminationStrategy);
				if (result == null) result = caseStateDeterminationStrategy(traceBasedStateDeterminationStrategy);
				if (result == null) result = caseRegistrable(traceBasedStateDeterminationStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.TRACE_INFERENCE_STRATEGY: {
				TraceInferenceStrategy traceInferenceStrategy = (TraceInferenceStrategy)theEObject;
				Object result = caseTraceInferenceStrategy(traceInferenceStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.RESPONSIBILITY_TO_STATE_DETERMINATION_STRATEGY_MAP_ENTRY: {
				Map.Entry responsibilityToStateDeterminationStrategyMapEntry = (Map.Entry)theEObject;
				Object result = caseResponsibilityToStateDeterminationStrategyMapEntry(responsibilityToStateDeterminationStrategyMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.ESTRING_TO_EJAVA_OBJECT_MAP_ENTRY: {
				Map.Entry eStringToEJavaObjectMapEntry = (Map.Entry)theEObject;
				Object result = caseEStringToEJavaObjectMapEntry(eStringToEJavaObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.STATE_FROM_MAPPING_STATE_DETERMINATION_STRATEGY: {
				StateFromMappingStateDeterminationStrategy stateFromMappingStateDeterminationStrategy = (StateFromMappingStateDeterminationStrategy)theEObject;
				Object result = caseStateFromMappingStateDeterminationStrategy(stateFromMappingStateDeterminationStrategy);
				if (result == null) result = caseStateDeterminationStrategy(stateFromMappingStateDeterminationStrategy);
				if (result == null) result = caseRegistrable(stateFromMappingStateDeterminationStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.OR_FILTER: {
				OrFilter orFilter = (OrFilter)theEObject;
				Object result = caseOrFilter(orFilter);
				if (result == null) result = caseFilter(orFilter);
				if (result == null) result = caseFilter_1(orFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.PROLOG_PROVIDER_STRATEGY: {
				PrologProviderStrategy prologProviderStrategy = (PrologProviderStrategy)theEObject;
				Object result = casePrologProviderStrategy(prologProviderStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.SIMPLE_PROLOG_PROVIDER_STRATEGY: {
				SimplePrologProviderStrategy simplePrologProviderStrategy = (SimplePrologProviderStrategy)theEObject;
				Object result = caseSimplePrologProviderStrategy(simplePrologProviderStrategy);
				if (result == null) result = casePrologProviderStrategy(simplePrologProviderStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.GENERAL_LOG_FILTER_STRATEGY: {
				GeneralLogFilterStrategy generalLogFilterStrategy = (GeneralLogFilterStrategy)theEObject;
				Object result = caseGeneralLogFilterStrategy(generalLogFilterStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionstatePackage.SIMPLE_GENERAL_LOG_FILTER_STRATEGY: {
				SimpleGeneralLogFilterStrategy simpleGeneralLogFilterStrategy = (SimpleGeneralLogFilterStrategy)theEObject;
				Object result = caseSimpleGeneralLogFilterStrategy(simpleGeneralLogFilterStrategy);
				if (result == null) result = caseGeneralLogFilterStrategy(simpleGeneralLogFilterStrategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State Determination Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateDeterminationStrategy(StateDeterminationStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Responsibility To State Determination Strategy Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Responsibility To State Determination Strategy Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponsibilityToStateDeterminationStrategyMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State Determination Strategy Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State Determination Strategy Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateDeterminationStrategyRegistry(StateDeterminationStrategyRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Manual State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Manual State Determination Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManualStateDeterminationStrategy(ManualStateDeterminationStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Trace Based State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Trace Based State Determination Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTraceBasedStateDeterminationStrategy(TraceBasedStateDeterminationStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTraceInferenceStrategy(TraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Manual Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Manual Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManualTraceInferenceStrategy(ManualTraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Simple Trace Inference Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Simple Trace Inference Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimpleTraceInferenceStrategy(SimpleTraceInferenceStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Mapping Based Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Mapping Based Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMappingBasedFilter(MappingBasedFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Diagnostic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Diagnostic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDiagnostic(Diagnostic object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EString To EJava Object Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EString To EJava Object Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseEStringToEJavaObjectMapEntry(Map.Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State From Mapping State Determination Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State From Mapping State Determination Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateFromMappingStateDeterminationStrategy(StateFromMappingStateDeterminationStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Or Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Or Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrFilter(OrFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Prolog Provider Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Prolog Provider Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePrologProviderStrategy(PrologProviderStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Simple Prolog Provider Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Simple Prolog Provider Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimplePrologProviderStrategy(SimplePrologProviderStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>General Log Filter Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGeneralLogFilterStrategy(GeneralLogFilterStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Simple General Log Filter Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Simple General Log Filter Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSimpleGeneralLogFilterStrategy(SimpleGeneralLogFilterStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Filter 1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Filter 1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFilter_1(GaugeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFilter(Filter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Basic Mapping Based Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Basic Mapping Based Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBasicMappingBasedFilter(BasicMappingBasedFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Registrable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Registrable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRegistrable(Registrable object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ExecutionstateSwitch
