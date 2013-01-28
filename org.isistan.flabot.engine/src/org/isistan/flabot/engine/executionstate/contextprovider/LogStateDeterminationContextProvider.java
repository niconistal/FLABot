/**
 * 
 */
package org.isistan.flabot.engine.executionstate.contextprovider;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.executionstate.ContextCreationException;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.engine.executionstate.TraceBasedStateDeterminationStrategy;
import org.isistan.flabot.trace.config.Context;

/**
 * Contexts provider that extracts contexts from all the
 * active state determination strategies.
 * @author mblech
 *
 */
public class LogStateDeterminationContextProvider extends
		FlabotFileContextProvider {

	@Override
	protected Context[] extractContexts(FlabotFileModel fileModel) {
		List<Context> contexts = new LinkedList<Context>();
		List<Responsibility> responsibilities = fileModel.getCoreModel().getResponsibilities();
		for (Responsibility responsibility: responsibilities) {
			StateDeterminationStrategy strategy = ExecutionStateManager.getStateDeterminationStrategy(responsibility);
			if (strategy instanceof TraceBasedStateDeterminationStrategy) {
				TraceBasedStateDeterminationStrategy tbsds =
					(TraceBasedStateDeterminationStrategy) strategy;
				tbsds.setResponsibility(responsibility);
				Context context;
				try {
					context = tbsds.getContext();
					contexts.add(context);
				} catch (ContextCreationException e) {
					EnginePlugin.getDefault().getLogger().warn(e.toString(), e);
				}
			}
		}
		return contexts.toArray(new Context[contexts.size()]);
	}

}
