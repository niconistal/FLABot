/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionstateAdapterFactory.java,v 1.20 2006/07/04 12:42:19 mblech Exp $
 */
package org.isistan.flabot.engine.executionstate.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.engine.executionstate.ExecutionstatePackage
 * @generated
 */
public class ExecutionstateAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionstatePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionstateAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExecutionstatePackage.eINSTANCE;
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
	@Override
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionstateSwitch modelSwitch =
		new ExecutionstateSwitch() {
			public Object caseBasicMappingBasedFilter(BasicMappingBasedFilter object) {
				return createBasicMappingBasedFilterAdapter();
			}
			public Object caseDiagnostic(Diagnostic object) {
				return createDiagnosticAdapter();
			}
			public Object caseManualStateDeterminationStrategy(ManualStateDeterminationStrategy object) {
				return createManualStateDeterminationStrategyAdapter();
			}
			public Object caseManualTraceInferenceStrategy(ManualTraceInferenceStrategy object) {
				return createManualTraceInferenceStrategyAdapter();
			}
			public Object caseMappingBasedFilter(MappingBasedFilter object) {
				return createMappingBasedFilterAdapter();
			}
			public Object caseSimpleTraceInferenceStrategy(SimpleTraceInferenceStrategy object) {
				return createSimpleTraceInferenceStrategyAdapter();
			}
			public Object caseStateDeterminationStrategy(StateDeterminationStrategy object) {
				return createStateDeterminationStrategyAdapter();
			}
			public Object caseStateDeterminationStrategyRegistry(StateDeterminationStrategyRegistry object) {
				return createStateDeterminationStrategyRegistryAdapter();
			}
			public Object caseTraceBasedStateDeterminationStrategy(TraceBasedStateDeterminationStrategy object) {
				return createTraceBasedStateDeterminationStrategyAdapter();
			}
			public Object caseTraceInferenceStrategy(TraceInferenceStrategy object) {
				return createTraceInferenceStrategyAdapter();
			}
			public Object caseResponsibilityToStateDeterminationStrategyMapEntry(Map.Entry object) {
				return createResponsibilityToStateDeterminationStrategyMapEntryAdapter();
			}
			public Object caseEStringToEJavaObjectMapEntry(Map.Entry object) {
				return createEStringToEJavaObjectMapEntryAdapter();
			}
			public Object caseStateFromMappingStateDeterminationStrategy(StateFromMappingStateDeterminationStrategy object) {
				return createStateFromMappingStateDeterminationStrategyAdapter();
			}
			public Object caseOrFilter(OrFilter object) {
				return createOrFilterAdapter();
			}
			public Object casePrologProviderStrategy(PrologProviderStrategy object) {
				return createPrologProviderStrategyAdapter();
			}
			public Object caseSimplePrologProviderStrategy(SimplePrologProviderStrategy object) {
				return createSimplePrologProviderStrategyAdapter();
			}
			public Object caseGeneralLogFilterStrategy(GeneralLogFilterStrategy object) {
				return createGeneralLogFilterStrategyAdapter();
			}
			public Object caseSimpleGeneralLogFilterStrategy(SimpleGeneralLogFilterStrategy object) {
				return createSimpleGeneralLogFilterStrategyAdapter();
			}
			public Object caseFilter_1(GaugeFilter object) {
				return createFilter_1Adapter();
			}
			public Object caseFilter(Filter object) {
				return createFilterAdapter();
			}
			public Object caseRegistrable(Registrable object) {
				return createRegistrableAdapter();
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
	@Override
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategy <em>State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategy
	 * @generated
	 */
	public Adapter createStateDeterminationStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Responsibility To State Determination Strategy Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createResponsibilityToStateDeterminationStrategyMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry <em>State Determination Strategy Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.StateDeterminationStrategyRegistry
	 * @generated
	 */
	public Adapter createStateDeterminationStrategyRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy <em>Manual State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.ManualStateDeterminationStrategy
	 * @generated
	 */
	public Adapter createManualStateDeterminationStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy <em>Trace Based State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy
	 * @generated
	 */
	public Adapter createTraceBasedStateDeterminationStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.TraceInferenceStrategy <em>Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.TraceInferenceStrategy
	 * @generated
	 */
	public Adapter createTraceInferenceStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy <em>Manual Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.ManualTraceInferenceStrategy
	 * @generated
	 */
	public Adapter createManualTraceInferenceStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy <em>Simple Trace Inference Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.SimpleTraceInferenceStrategy
	 * @generated
	 */
	public Adapter createSimpleTraceInferenceStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter <em>Mapping Based Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.MappingBasedFilter
	 * @generated
	 */
	public Adapter createMappingBasedFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.Diagnostic
	 * @generated
	 */
	public Adapter createDiagnosticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString To EJava Object Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEStringToEJavaObjectMapEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy <em>State From Mapping State Determination Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.StateFromMappingStateDeterminationStrategy
	 * @generated
	 */
	public Adapter createStateFromMappingStateDeterminationStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.OrFilter <em>Or Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.OrFilter
	 * @generated
	 */
	public Adapter createOrFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.PrologProviderStrategy <em>Prolog Provider Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.PrologProviderStrategy
	 * @generated
	 */
	public Adapter createPrologProviderStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy <em>Simple Prolog Provider Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.SimplePrologProviderStrategy
	 * @generated
	 */
	public Adapter createSimplePrologProviderStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy <em>General Log Filter Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy
	 * @generated
	 */
	public Adapter createGeneralLogFilterStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy <em>Simple General Log Filter Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.SimpleGeneralLogFilterStrategy
	 * @generated
	 */
	public Adapter createSimpleGeneralLogFilterStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter <em>Basic Mapping Based Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.engine.executionstate.BasicMappingBasedFilter
	 * @generated
	 */
	public Adapter createBasicMappingBasedFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.coremodel.Registrable <em>Registrable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.coremodel.Registrable
	 * @generated
	 */
	public Adapter createRegistrableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.gauge.GaugeFilter <em>Filter 1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.gauge.GaugeFilter
	 * @generated
	 */
	public Adapter createFilter_1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.isistan.flabot.trace.config.Filter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.isistan.flabot.trace.config.Filter
	 * @generated
	 */
	public Adapter createFilterAdapter() {
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

} //ExecutionstateAdapterFactory
