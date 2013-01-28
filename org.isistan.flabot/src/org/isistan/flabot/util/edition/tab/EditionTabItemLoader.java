package org.isistan.flabot.util.edition.tab;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.editor.TabItemComparator;
import org.isistan.flabot.util.extension.ClassInstantiator;
import org.isistan.flabot.util.extension.ConfigurationElementHandler;
import org.isistan.flabot.util.extension.ExtensionPointHandler;
import org.isistan.flabot.util.extension.NoMatchingConstructorFoundException;
import org.isistan.flabot.util.extension.PropertiesReader;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;

/**
 * Loads contributed edition tabs
 * @author $Author: dacostae $
 *
 */
public class EditionTabItemLoader<T> {
	private ClassInstantiator<T> instantiator=new ClassInstantiator<T>(
			new Class[] {Map.class},
			new Class[] {});
	
	private String extensionPointId;
	private String tabTag;
	private String classAttribute;
	private String orderAttribute;
	private PropertiesReader propertiesReader;
	
	private TabItemComparator tabItemComparator;

	public EditionTabItemLoader(String extensionPointId,
			String tabTag,
			String classAttribute,
			String orderAttribute,
			PropertiesReader propertiesReader) {
		this.extensionPointId=extensionPointId;
		this.tabTag=tabTag;
		this.classAttribute=classAttribute;
		this.orderAttribute=orderAttribute;
		this.propertiesReader=propertiesReader;
		this.tabItemComparator = new TabItemComparator(this.orderAttribute);
	}
	
	/**
	 * Returns all contributed edition tabs
	 * @param messageAccumulator
	 * @return
	 */
	public Collection<T> getEditionItems(
			MessageAccumulator messageAccumulator) {
		ExtensionPointHandler extensionPoint=new ExtensionPointHandler(
				extensionPointId);
		ConfigurationElementHandler[] configurationElements=
			extensionPoint.getAllConfigurationElementHandlers(
					tabTag);
		
		//Sorts the tab items, according to the value of the order attribute
		Arrays.sort(configurationElements, tabItemComparator);

		List<T> componentEditionTabItems=
			new LinkedList<T>();
		
		for (ConfigurationElementHandler configurationElement : configurationElements) {
			
			try {
				Class<? extends T> clazz=
					configurationElement.<T>getClass(
							classAttribute);
				Map<String, String> properties=propertiesReader.readProperties(configurationElement);
				T instance=instantiator.instantiate(clazz,
						new Object[] {properties},
						new Object[] {});
				componentEditionTabItems.add(instance);
			} catch (ClassNotFoundException e) {
				handleError(messageAccumulator, configurationElement,
						"Class " + configurationElement.getString(classAttribute) + " not found.", 
						e);

			} catch (InstantiationException e) {
				handleError(messageAccumulator, configurationElement,
						"Cannot instantiate " + configurationElement.getString(classAttribute) + ".", 
						e);
			} catch (IllegalAccessException e) {
				handleError(messageAccumulator, configurationElement,
						"Cannot access constructor for " + configurationElement.getString(classAttribute) + ".", 
						e);
			} catch (IllegalArgumentException e) {
				handleError(messageAccumulator, configurationElement,
						"Bad arguments for constructor of " + configurationElement.getString(classAttribute) + ".", 
						e);
			} catch (NoMatchingConstructorFoundException e) {
				handleError(messageAccumulator, configurationElement,
						"No matching constructor found for " + configurationElement.getString(classAttribute) + ".", 
						e);
			} catch (InvocationTargetException e) {
				handleError(messageAccumulator, configurationElement,
						"Exception in target constructor " + configurationElement.getString(classAttribute) + ".", 
						e);
			}
		}
		return componentEditionTabItems;
	}

	private void handleError(MessageAccumulator messageAccumulator, ConfigurationElementHandler configurationElement, String description, Throwable e) {
		messageAccumulator.addMessage(new DefaultMessage(
				FlabotPlugin.getDefault(),
				FlabotPlugin.SYMBOLIC_NAME,
				MessageSeverity.ERROR,
				"Error loading contributed edition tab item from " + configurationElement.getNamespace(),
				description,
				e));
	}
}
