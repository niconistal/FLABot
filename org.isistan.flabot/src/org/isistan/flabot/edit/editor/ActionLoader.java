package org.isistan.flabot.edit.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.extension.ClassExtensionLoader;
import org.isistan.flabot.util.extension.ClassInstantiator;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;
import org.isistan.flabot.util.extension.PropertiesReader;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;

/**
 * Loads contributed actions
 * @author da Costa Cambio
 *
 */
public class ActionLoader {

	private static final ClassInstantiator<IAction> instantiator=new ClassInstantiator<IAction>(
			new Class<?>[] {IWorkbenchPart.class, Map.class},
			new Class<?>[] {IWorkbenchPart.class},
			new Class<?>[] {Map.class},
			new Class<?>[] {}
		);

	
	public static IAction loadAction(IWorkbenchPart workbenchPart, 
			IConfigurationElement actionConfigurationElement) throws ClassNotFoundException, 
			IllegalArgumentException, InstantiationException, IllegalAccessException, 
			InvocationTargetException, NoMatchingConstructorFoundException {
		
		
		Class<? extends IAction> clazz=ClassExtensionLoader.<IAction>loadClass(
				actionConfigurationElement, ExtensionPointConstants.UCM_EDITOR_CONTEXT_MENU_ACTION__CLASS_ATTRIBUTE);
		Map<String, String> properties=PropertiesReader.getDefault()
				.readProperties(actionConfigurationElement);
		return instantiator.instantiate(clazz,
				new Object[] {workbenchPart, properties},
				new Object[] {workbenchPart},
				new Object[] {properties},
				new Object[] {}
			);
	}
	
	public static IAction[] loadActions(IWorkbenchPart workbenchPart, 
			IExtension actionExtension, MessageAccumulator messageAccumulator) {
		
		List<IAction> actions=new LinkedList<IAction>();
		for(IConfigurationElement actionConfigurationElement: actionExtension.getConfigurationElements()) {
			if(actionConfigurationElement.getName().equals(ExtensionPointConstants.UCM_EDITOR_CONTEXT_MENU_ACTION__ACTION_TAG)) {
				try {
					IAction action=loadAction(workbenchPart, actionConfigurationElement);
					actions.add(action);
				} catch (Exception e) {
					messageAccumulator.addMessage(new DefaultMessage(
							FlabotPlugin.getDefault(),
							FlabotPlugin.SYMBOLIC_NAME,
							MessageSeverity.ERROR, 
							Messages.getString("org.isistan.flabot.edit.editor.ActionLoader.ErrorLoadingAction"),  //$NON-NLS-1$
							"[" + e.getClass().getName() + "] " + (e.getMessage()!=null? e.getMessage(): ""), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							e)
						);
				}
				
			}
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	
	public static IAction[] loadAllActions(IWorkbenchPart workbenchPart, 
			String extensionPointId, MessageAccumulator messageAccumulator) {
		
		List<IAction> actions=new LinkedList<IAction>();

		IExtensionPoint extensionPoint =
			Platform.getExtensionRegistry().getExtensionPoint(
					extensionPointId
				);
		if(extensionPoint==null) {
			messageAccumulator.addMessage(new DefaultMessage(
					FlabotPlugin.getDefault(),
					FlabotPlugin.SYMBOLIC_NAME,
					MessageSeverity.ERROR, 
					Messages.getString("org.isistan.flabot.edit.editor.ActionLoader.InvalidExtensionPoint"),  //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.editor.ActionLoader.ExtensionPointNotFound", extensionPointId)  //$NON-NLS-1$
					)
				);
			return new IAction[0];
		}
		IExtension[] extensions = extensionPoint.getExtensions();
		for (IExtension extension: extensions) {
			IAction[] extensionActions=loadActions(workbenchPart, extension, messageAccumulator);
			for (IAction action : extensionActions) {
				actions.add(action);
			}
		}
		return actions.toArray(new IAction[actions.size()]);
	}
}
