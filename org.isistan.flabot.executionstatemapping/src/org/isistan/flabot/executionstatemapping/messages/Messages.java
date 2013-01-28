package org.isistan.flabot.executionstatemapping.messages;

import java.util.ResourceBundle;

import org.isistan.flabot.executionstatemapping.messages.util.MessagesUtil;

public class Messages {
	private static final String BUNDLE_NAME = "org.isistan.flabot.executionstatemapping.messages.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}
	
	public static String getStringAsIs(String key) {
		return MessagesUtil.getStringAsIs(RESOURCE_BUNDLE, key);
	}
	
	public static String getString(String key) {
		return MessagesUtil.getString(RESOURCE_BUNDLE, key);
	}

	   
	public static String getStringAsIs(String key, Object... arguments)  {
		return MessagesUtil.getStringAsIs(RESOURCE_BUNDLE, key, arguments);
	}
	
	   
	public static String getString(String key, Object... arguments)  {
		return MessagesUtil.getString(RESOURCE_BUNDLE, key, arguments);
	}	
}
