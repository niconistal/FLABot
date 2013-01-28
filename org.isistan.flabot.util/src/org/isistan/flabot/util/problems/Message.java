/** * $Id: Message.java,v 1.1 2006/02/07 02:19:31 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.problems;
import org.eclipse.core.runtime.Plugin;
public interface Message {

	Plugin getPlugin();	String getPluginId();	MessageSeverity getSeverity();		String getDescription();
	
	String getTitle();
	
	Throwable getCause();
}
