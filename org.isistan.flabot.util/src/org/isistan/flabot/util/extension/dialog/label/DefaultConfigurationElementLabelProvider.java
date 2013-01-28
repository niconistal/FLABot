package org.isistan.flabot.util.extension.dialog.label;

import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.util.extension.ConfigurationElementHandler;

public class DefaultConfigurationElementLabelProvider implements
		ConfigurationElementHandlerProvider {

	private String iconAttribute;
	private String nameAttribute;
	private String descriptionAttribute;

	public DefaultConfigurationElementLabelProvider(String iconAttribute, String nameAttribute, String descriptionAttribute) {
		this.iconAttribute=iconAttribute;
		this.nameAttribute=nameAttribute;
		this.descriptionAttribute=descriptionAttribute;
	}


	public Image getImage(ConfigurationElementHandler configurationElement) {
		if(iconAttribute==null || iconAttribute.trim().length()==0)
			return null;
		Image image=configurationElement.getImage(iconAttribute);
		return image;
	}

	public String getText(ConfigurationElementHandler configurationElement) {
		String name;
		if(nameAttribute==null || nameAttribute.trim().length()==0) {
			name=null;
		} else {
			name=configurationElement.getString(nameAttribute);
			if(name!=null && name.trim().length()==0)
				name=null;
		}
		String description;
		if(descriptionAttribute==null || descriptionAttribute.trim().length()==0) {
			description=configurationElement.getNamespace();
		} else {
			description=configurationElement.getString(descriptionAttribute);
			if(description==null || description.trim().length()==0)
				description=configurationElement.getNamespace();
		}

		String text;
		if(name==null) {
			text=description;
		} else {
			text=description + " - " + name;
		}
		
		return text;
	}
}
