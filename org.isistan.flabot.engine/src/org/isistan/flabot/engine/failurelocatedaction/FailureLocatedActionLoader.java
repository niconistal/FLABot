package org.isistan.flabot.engine.failurelocatedaction;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.ExtensionPointConstants;
import org.isistan.flabot.util.extension.ConfigurationElementHandler;
import org.isistan.flabot.util.extension.ExtensionPointHandler;
import org.isistan.flabot.util.extension.dialog.ExtensionSelectionDialog;
import org.isistan.flabot.util.extension.dialog.label.ConfigurationElementHandlerProvider;
import org.isistan.flabot.util.extension.dialog.label.DefaultConfigurationElementLabelProvider;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;
import org.isistan.flabot.util.resource.validator.SelectionSizeValidator;

/**
 * Loads contributed failure located actions
 * @author $Author: dacostae $
 *
 */
public class FailureLocatedActionLoader {

	/**
	 * Returns failure located actions contributed in the given configuration elements
	 * @param messageAccumulator
	 * @return
	 */
	public static FailureLocatedAction[] getFailureLocatedActions(
			ConfigurationElementHandler[] failureLocatedActionConfigurationElements,
			MessageAccumulator messageAccumulator) {

		List<FailureLocatedAction> failureLocatedActions=new LinkedList<FailureLocatedAction>();
		
		for (ConfigurationElementHandler configurationElement : failureLocatedActionConfigurationElements) {
			
			try {
				Class<? extends FailureLocatedAction> clazz=
					configurationElement.<FailureLocatedAction>getClass(
							ExtensionPointConstants.FAILURE_LOCATED_ACTION__CLASS_ATTRIBUTE);
				failureLocatedActions.add(clazz.newInstance());
			} catch (ClassNotFoundException e) {
				handleError(messageAccumulator, configurationElement,
						"Class " + configurationElement.getString(ExtensionPointConstants.FAILURE_LOCATED_ACTION__CLASS_ATTRIBUTE) + " not found.", 
						e);

			} catch (InstantiationException e) {
				handleError(messageAccumulator, configurationElement,
						"Cannot instantiate " + configurationElement.getString(ExtensionPointConstants.FAILURE_LOCATED_ACTION__CLASS_ATTRIBUTE) + ".", 
						e);
			} catch (IllegalAccessException e) {
				handleError(messageAccumulator, configurationElement,
						"Cannot access constructor for " + configurationElement.getString(ExtensionPointConstants.FAILURE_LOCATED_ACTION__CLASS_ATTRIBUTE) + ".", 
						e);
			}
		}
		return failureLocatedActions.toArray(new FailureLocatedAction[failureLocatedActions.size()]);
	}
	
	/**
	 * Returns true if there are actions available
	 * @return
	 */
	public static boolean areFailureLocatedActions() {
		ExtensionPointHandler extensionPoint=new ExtensionPointHandler(
				ExtensionPointConstants.FAILURE_LOCATED_ACTION);
		return extensionPoint.getExtensions().length!=0;
	}
	/**
	 * Returns all configuration elements for contributed failure located actions
	 * @param messageAccumulator
	 * @return
	 */
	public static ConfigurationElementHandler[] getFailureLocatedActionConfigurationElementHandlers(
			MessageAccumulator messageAccumulator) {
		ExtensionPointHandler extensionPoint=new ExtensionPointHandler(
				ExtensionPointConstants.FAILURE_LOCATED_ACTION);
		ConfigurationElementHandler[] configurationElements=
			extensionPoint.getAllConfigurationElementHandlers(
					ExtensionPointConstants.FAILURE_LOCATED_ACTION__ACTION_TAG);
		return configurationElements;
	}

	private static void handleError(MessageAccumulator messageAccumulator, ConfigurationElementHandler configurationElement, String description, Throwable e) {
		messageAccumulator.addMessage(new DefaultMessage(
				FlabotPlugin.getDefault(),
				FlabotPlugin.SYMBOLIC_NAME,
				MessageSeverity.ERROR,
				"Error loading contributed responsibility edition tab item from " + configurationElement.getNamespace(),
				description,
				e));
	}
	
	
	private static ExtensionSelectionDialog selectionDialog=null;
	/**
	 * Shows a selecion dialog to let the user select some failure located actions
	 * @param shell
	 * @return
	 */
	public static FailureLocatedAction[] getUserSelectedFailureLocatedActions(Shell shell, MessageAccumulator messageAccumulator) {
		ConfigurationElementHandler[] actionConfigurationElements=
			FailureLocatedActionLoader.getFailureLocatedActionConfigurationElementHandlers(
					messageAccumulator);
		ConfigurationElementHandlerProvider labelProvider=
			new DefaultConfigurationElementLabelProvider(
				ExtensionPointConstants.FAILURE_LOCATED_ACTION__ICON_ATTRIBUTE,
				ExtensionPointConstants.FAILURE_LOCATED_ACTION__NAME_ATTRIBUTE,
				ExtensionPointConstants.FAILURE_LOCATED_ACTION__DESCRIPTION_ATTRIBUTE
				);
		if(selectionDialog==null) {
			selectionDialog=new ExtensionSelectionDialog(labelProvider,
					new SelectionSizeValidator(EnginePlugin.SYMBOLIC_NAME, 1));
		}

		Collection<ConfigurationElementHandler> selectedActionConfigurationElements=
			selectionDialog.openMultiple(
				shell, "Failure Located Action Selection",
				"Select one or more actions to be taken.",
				actionConfigurationElements,
				null);
		if(selectedActionConfigurationElements==null) {
			return new FailureLocatedAction[0];
		}
		return FailureLocatedActionLoader.getFailureLocatedActions(
				selectedActionConfigurationElements.toArray(new ConfigurationElementHandler[selectedActionConfigurationElements.size()]),
				messageAccumulator);
	}
}
