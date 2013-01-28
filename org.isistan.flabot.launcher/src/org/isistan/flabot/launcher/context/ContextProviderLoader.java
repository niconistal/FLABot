package org.isistan.flabot.launcher.context;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.isistan.flabot.launcher.ExtensionPointConstants;
import org.isistan.flabot.util.extension.ClassExtensionLoader;
import org.isistan.flabot.util.extension.ClassInstantiator;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;

public class ContextProviderLoader {

	private static final ClassInstantiator<ContextProvider> launcherInstantiator=
		new ClassInstantiator<ContextProvider>();

	private static final ClassInstantiator<ILaunchConfigurationTab> launcherTabInstantiator=
		new ClassInstantiator<ILaunchConfigurationTab>();
	
	public static IConfigurationElement[] getContextProviderConfigurationElements(IExtension contextProviderExtension) {
		
		List<IConfigurationElement> contextProviders=new LinkedList<IConfigurationElement>();
		for(IConfigurationElement contextProvider: contextProviderExtension.getConfigurationElements()) {
			if(contextProvider.getName().equals(ExtensionPointConstants.CONTEXT_PROVIDER__PROVIDER_TAG)) {
				contextProviders.add(contextProvider);
			}
		}
		return contextProviders.toArray(new IConfigurationElement[contextProviders.size()]);
	}

	
	public static IConfigurationElement[] getAllContextProviderConfigurationElements() {
		
		List<IConfigurationElement> contextProviders=new LinkedList<IConfigurationElement>();

		IExtensionPoint contextProviderExtensionPoint =
			Platform.getExtensionRegistry().getExtensionPoint(ExtensionPointConstants.CONTEXT_PROVIDER);
		
		
		IExtension[] extensions = contextProviderExtensionPoint.getExtensions();
		for (IExtension extension: extensions) {
			IConfigurationElement[] extensionCollectionAction=getContextProviderConfigurationElements(extension);
			for (IConfigurationElement contextProvider : extensionCollectionAction) {
				contextProviders.add(contextProvider);
			}
		}
		return contextProviders.toArray(new IConfigurationElement[contextProviders.size()]);
	}

	public static IConfigurationElement getContextProviderConfigurationElement(String contextProviderId) {
		IConfigurationElement[] contextProviders=getAllContextProviderConfigurationElements();
		for (IConfigurationElement contextProvider : contextProviders) {
			if(contextProvider.getAttribute(ExtensionPointConstants.CONTEXT_PROVIDER__ID_ATTRIBUTE).equals(contextProviderId)) {
				return contextProvider;
			}
		}
		return null;
	}
	
	public static ContextProvider loadContextProvider(String contextProviderId) throws IllegalArgumentException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		IConfigurationElement contextProvider=getContextProviderConfigurationElement(contextProviderId);
		if(contextProvider==null) {
			throw new IllegalArgumentException("contextProviderId not found");
		}
		
		Class<? extends ContextProvider> clazz=ClassExtensionLoader.<ContextProvider>loadClass(
				contextProvider, ExtensionPointConstants.CONTEXT_PROVIDER__PROVIDER_CLASS_ATTRIBUTE);
		return launcherInstantiator.instantiate(clazz);
	}


	
	public static ILaunchConfigurationTab loadTab(String contextProviderId) throws IllegalArgumentException, ClassNotFoundException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		IConfigurationElement contextProvider=getContextProviderConfigurationElement(contextProviderId);
		if(contextProvider==null) {
			throw new IllegalArgumentException("contextProviderId not found:" + contextProviderId);
		}
		return loadTab(contextProvider);
	}

	public static ILaunchConfigurationTab loadTab(IConfigurationElement tabConfigurationElement) throws ClassNotFoundException, IllegalArgumentException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		String className=tabConfigurationElement.getAttribute(ExtensionPointConstants.CONTEXT_PROVIDER__PROVIDER_TAB_CLASS_ATTRIBUTE);
		if(className==null || className.trim().length()==0)
			return null;
		
		Class<? extends ILaunchConfigurationTab> clazz=
			ClassExtensionLoader.<ILaunchConfigurationTab>loadClass(
				tabConfigurationElement, ExtensionPointConstants.CONTEXT_PROVIDER__PROVIDER_TAB_CLASS_ATTRIBUTE);
		return launcherTabInstantiator.instantiate(clazz);
	}

}
