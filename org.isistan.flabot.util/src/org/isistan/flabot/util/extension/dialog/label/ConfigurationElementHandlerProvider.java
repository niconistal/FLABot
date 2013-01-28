package org.isistan.flabot.util.extension.dialog.label;

import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.util.extension.ConfigurationElementHandler;

public interface ConfigurationElementHandlerProvider {
	
	String getText(ConfigurationElementHandler configurationElement);


	Image getImage(ConfigurationElementHandler configurationElement);
}
