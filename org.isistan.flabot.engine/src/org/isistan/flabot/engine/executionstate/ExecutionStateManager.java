package org.isistan.flabot.engine.executionstate;

import java.util.Map;

import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.Loader;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogTraceInferenceStrategy;
import org.isistan.flabot.engine.executionstate.javalogtrace.JavalogtraceFactory;

/**
 * Useful class to operate with state determination strategy.
 * @author usuario
 *
 */
public class ExecutionStateManager {
	/**
	 * Element id that is used to store elements in the extended data map
	 */
	public static final String STATE_DETERMINATION_STRATEGY_ELEMENT_ID="stateDeterminationStrategy";
	
	public static final String PROLOG_PROVIDER_STRATEGY_ELEMENT_ID="prologProviderStrategy";
	
	public static final String GENERAL_LOG_FILTER_STRATEGY_ELEMENT_ID="generalLogFilterStrategy";
	
	/**
	 * Default state determination strategy
	 */
	public static final StateDeterminationStrategy defaultStateDeterminationStrategy=ExecutionstateFactory.eINSTANCE.createManualStateDeterminationStrategy();

	/**
	 * Returns the state determination strategy associated with the given responsibility.
	 * @param responsibility
	 * @return
	 */
	public static StateDeterminationStrategy getStateDeterminationStrategy(Responsibility responsibility) {
		if(responsibility==null) {
			throw new IllegalArgumentException("responsibility cannot be null.");
		}
		StateDeterminationStrategy stateDeterminationStrategy = (StateDeterminationStrategy) responsibility.getExtendedData(EnginePlugin.SYMBOLIC_NAME, STATE_DETERMINATION_STRATEGY_ELEMENT_ID);
		if(stateDeterminationStrategy==null) {
			stateDeterminationStrategy=ExecutionstateFactory.eINSTANCE.createTraceBasedStateDeterminationStrategy();
			JavalogTraceInferenceStrategy traceInferenceStrategy = JavalogtraceFactory.eINSTANCE.createJavalogTraceInferenceStrategy();
			((TraceBasedStateDeterminationStrategy)stateDeterminationStrategy).setTraceInferenceStrategy(traceInferenceStrategy);
			responsibility.putExtendedData(EnginePlugin.SYMBOLIC_NAME, STATE_DETERMINATION_STRATEGY_ELEMENT_ID, stateDeterminationStrategy);
		}
		return stateDeterminationStrategy;
	}
	
	public static PrologProviderStrategy getPrologProviderStrategy(ConditionEvent conditionEvent) {
		if(conditionEvent==null) {
			throw new IllegalArgumentException("conditionEvent cannot be null.");
		}
		PrologProviderStrategy prologProviderStrategy = (PrologProviderStrategy) conditionEvent.getExtendedData(EnginePlugin.SYMBOLIC_NAME, PROLOG_PROVIDER_STRATEGY_ELEMENT_ID);
		if(prologProviderStrategy==null) {
			prologProviderStrategy= ExecutionstateFactory.eINSTANCE.createSimplePrologProviderStrategy();
			conditionEvent.putExtendedData(EnginePlugin.SYMBOLIC_NAME, PROLOG_PROVIDER_STRATEGY_ELEMENT_ID, prologProviderStrategy);
		}
		return prologProviderStrategy;
	}
	
	public static GeneralLogFilterStrategy getGeneralLogFilterStrategy(FlabotFileModel flabotFileModel) {
		if(flabotFileModel==null) {
			throw new IllegalArgumentException("flabot file model cannot be null.");
		}
		GeneralLogFilterStrategy generalLogFilterStrategy = (GeneralLogFilterStrategy) flabotFileModel.getExtendedData(EnginePlugin.SYMBOLIC_NAME, GENERAL_LOG_FILTER_STRATEGY_ELEMENT_ID);
		if(generalLogFilterStrategy==null) {
			generalLogFilterStrategy= ExecutionstateFactory.eINSTANCE.createSimpleGeneralLogFilterStrategy();
			flabotFileModel.putExtendedData(EnginePlugin.SYMBOLIC_NAME, GENERAL_LOG_FILTER_STRATEGY_ELEMENT_ID, generalLogFilterStrategy);
		}
		return generalLogFilterStrategy;
	}
	
	/**
	 * Sets the state determination strategy associated with the given responsibility.
	 * Returns the previous set mapping or null if not set.
	 * 
	 * @param responsibility
	 * @param mapping
	 * @return
	 */
	public static StateDeterminationStrategy setStateDeterminationStrategy(Responsibility responsibility, StateDeterminationStrategy stateDeterminationStrategy) {
		return (StateDeterminationStrategy) responsibility.putExtendedData(EnginePlugin.SYMBOLIC_NAME, STATE_DETERMINATION_STRATEGY_ELEMENT_ID, stateDeterminationStrategy);
	}
	
	public static PrologProviderStrategy setPrologProviderStrategy(ConditionEvent conditionEvent, PrologProviderStrategy prologProviderStrategy) {
		return (PrologProviderStrategy) conditionEvent.putExtendedData(EnginePlugin.SYMBOLIC_NAME, PROLOG_PROVIDER_STRATEGY_ELEMENT_ID, prologProviderStrategy);
	}
	
	public static GeneralLogFilterStrategy setGeneralLogFilterStrategy(FlabotFileModel flabotFileModel, GeneralLogFilterStrategy generalLogFilterStrategy) {
		return (GeneralLogFilterStrategy) flabotFileModel.putExtendedData(EnginePlugin.SYMBOLIC_NAME, GENERAL_LOG_FILTER_STRATEGY_ELEMENT_ID, generalLogFilterStrategy);
	}

	/**
	 * Get the state for the given responsibility node. This method is the only
	 * reasonable usage for this class in a normal environment.
	 * @param responsibilityNode the responsibility node whose state must be determined
	 * @param engineContext the engine's context parameters
	 * @param loader the engine's loader
	 * @return
	 * @throws StateDeterminationException 
	 */
	public static Diagnostic getState(ResponsibilityNode responsibilityNode,
			Map engineContext, Loader loader) {
		StateDeterminationStrategy strategy = 
			getStateDeterminationStrategy(responsibilityNode.getResponsibility());

		try {
			return strategy.getState(responsibilityNode, engineContext, loader);
		} catch (StateDeterminationException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Exception calling state determination strategy:\n{}\n" +
					"Falling back to default state determination strategy",
					e);
			try {
				return defaultStateDeterminationStrategy.getState(responsibilityNode, engineContext, loader);
			} catch (StateDeterminationException e1) {
				EnginePlugin.getDefault().getLogger().error(
						"Exception calling default state determination strategy:\n{}" +
						"\nReturning 'Executed' state for responsibility as ultimate fallback",
						e);
				Diagnostic diagnostic = ExecutionstateFactory.eINSTANCE.createDiagnostic();
				diagnostic.setState(ExecutionState.EXECUTED_LITERAL);
				diagnostic.setDescription("Forced execution state because the default state determination strategy threw an exception.");
				return diagnostic;
			}
		}
	}
}
