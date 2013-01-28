package org.isistan.flabot.util.extension.dialog;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.util.SelectionDialog;
import org.isistan.flabot.util.extension.ConfigurationElementHandler;
import org.isistan.flabot.util.extension.dialog.label.ConfigurationElementHandlerProvider;

/**
 * Utility class to show file selection dialogs
 * @author da Costa Cambio
 */
public class ExtensionSelectionDialog extends SelectionDialog<ConfigurationElementHandler> {



	/**
	 * Chreates
	 * @param labelProvider
	 * @param validator
	 */
	public ExtensionSelectionDialog(
			ConfigurationElementHandlerProvider labelProvider,
			ISelectionStatusValidator validator) {
		super(new ExtensionLabelProvider(labelProvider), validator);
	}
		
	static private class ExtensionLabelProvider implements ILabelProvider {

		private ConfigurationElementHandlerProvider labelProvider;

		public ExtensionLabelProvider(ConfigurationElementHandlerProvider labelProvider) {
			this.labelProvider=labelProvider;
		}

		public Image getImage(Object element) {
			ConfigurationElementHandler configurationElement;
			if(element instanceof ConfigurationElementHandler) {
				configurationElement=(ConfigurationElementHandler) element;
			} else if(element instanceof IConfigurationElement) {
				configurationElement=new ConfigurationElementHandler((IConfigurationElement) element);
			} else {
				return null;
			}
			return labelProvider.getImage(configurationElement);
		}

		public String getText(Object element) {
			ConfigurationElementHandler configurationElement;
			if(element instanceof ConfigurationElementHandler) {
				configurationElement=(ConfigurationElementHandler) element;
			} else if(element instanceof IConfigurationElement) {
				configurationElement=new ConfigurationElementHandler((IConfigurationElement) element);
			} else {
				return null;
			}
			return labelProvider.getText(configurationElement);
		}

		public void addListener(ILabelProviderListener listener) {
			
		}

		public void dispose() {
			
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			
		}
		
	}
}
