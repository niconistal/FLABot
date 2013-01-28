package org.isistan.flabot.executionstatemapping.messages.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class MessagesUtil {
	public static String getStringAsIs(ResourceBundle resourceBundle, String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getString(ResourceBundle resourceBundle, String key) {
		String string=getStringAsIs(resourceBundle, key);
		String converted=SpecialCharactersConverter.convertSpecialCharacters(string);
		return converted;
	}

	   
	public static String getStringAsIs(ResourceBundle resourceBundle, String key, Object... arguments)  {
		String string=getStringAsIs(resourceBundle, key);
		String replaced=ArgumentsReplacer.replace(string, arguments);
		return replaced;
	}
	
	   
	public static String getString(ResourceBundle resourceBundle, String key, Object... arguments)  {
		String string=getString(resourceBundle, key);
		String replaced=ArgumentsReplacer.replace(string, arguments);
		return replaced;
	}
	
}
