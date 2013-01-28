package org.isistan.flabot.launcher.collection;

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

public class CollectionLauncherLoader {

	private static final ClassInstantiator<CollectionLauncher> launcherInstantiator=
		new ClassInstantiator<CollectionLauncher>();

	private static final ClassInstantiator<ILaunchConfigurationTab> launcherTabInstantiator=
		new ClassInstantiator<ILaunchConfigurationTab>();
	
	public static IConfigurationElement[] getCollectionLauncherConfigurationElements(IExtension collectionLauncherExtension) {
		
		List<IConfigurationElement> collectionLaunchers=new LinkedList<IConfigurationElement>();
		for(IConfigurationElement collectionLauncher: collectionLauncherExtension.getConfigurationElements()) {
			if(collectionLauncher.getName().equals(ExtensionPointConstants.COLLECTION_LAUNCHER__LAUNCHER_TAG)) {
				collectionLaunchers.add(collectionLauncher);
			}
		}
		return collectionLaunchers.toArray(new IConfigurationElement[collectionLaunchers.size()]);
	}

	
	public static IConfigurationElement[] getAllCollectionLauncherConfigurationElements() {
		
		List<IConfigurationElement> collectionLaunchers=new LinkedList<IConfigurationElement>();

		IExtensionPoint collectionLauncherExtensionPoint =
			Platform.getExtensionRegistry().getExtensionPoint(ExtensionPointConstants.COLLECTION_LAUNCHER);
		
		
		IExtension[] extensions = collectionLauncherExtensionPoint.getExtensions();
		for (IExtension extension: extensions) {
			IConfigurationElement[] extensionCollectionAction=getCollectionLauncherConfigurationElements(extension);
			for (IConfigurationElement collectionLauncher : extensionCollectionAction) {
				collectionLaunchers.add(collectionLauncher);
			}
		}
		return collectionLaunchers.toArray(new IConfigurationElement[collectionLaunchers.size()]);
	}

	public static IConfigurationElement getCollectionLauncherConfigurationElement(String collectionLauncherId) {
		IConfigurationElement[] collectionLaunchers=getAllCollectionLauncherConfigurationElements();
		for (IConfigurationElement collectionLauncher : collectionLaunchers) {
			if(collectionLauncher.getAttribute(ExtensionPointConstants.COLLECTION_LAUNCHER__ID_ATTRIBUTE).equals(collectionLauncherId)) {
				return collectionLauncher;
			}
		}
		return null;
	}
	
	public static CollectionLauncher loadCollectionLauncher(String collectionLauncherId) throws IllegalArgumentException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		IConfigurationElement collectionLauncher=getCollectionLauncherConfigurationElement(collectionLauncherId);
		if(collectionLauncher==null) {
			throw new IllegalArgumentException("collectionLauncherId not found");
		}
		
		Class<? extends CollectionLauncher> clazz=ClassExtensionLoader.<CollectionLauncher>loadClass(
				collectionLauncher, ExtensionPointConstants.COLLECTION_LAUNCHER__LAUNCHER_CLASS_ATTRIBUTE);
		return launcherInstantiator.instantiate(clazz);
	}


	
	public static ILaunchConfigurationTab loadTab(String collectionLauncherId) throws IllegalArgumentException, ClassNotFoundException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		IConfigurationElement collectionLauncher=getCollectionLauncherConfigurationElement(collectionLauncherId);
		if(collectionLauncher==null) {
			throw new IllegalArgumentException("collectionLauncherId not found:" + collectionLauncherId);
		}
		return loadTab(collectionLauncher);
	}

	public static ILaunchConfigurationTab loadTab(IConfigurationElement tabConfigurationElement) throws ClassNotFoundException, IllegalArgumentException, NoMatchingConstructorFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		String className=tabConfigurationElement.getAttribute(ExtensionPointConstants.COLLECTION_LAUNCHER__LAUNCHER_TAB_CLASS_ATTRIBUTE);
		if(className==null || className.trim().length()==0)
			return null;
		
		Class<? extends ILaunchConfigurationTab> clazz=
			ClassExtensionLoader.<ILaunchConfigurationTab>loadClass(
				tabConfigurationElement, ExtensionPointConstants.COLLECTION_LAUNCHER__LAUNCHER_TAB_CLASS_ATTRIBUTE);
		return launcherTabInstantiator.instantiate(clazz);
	}

}
