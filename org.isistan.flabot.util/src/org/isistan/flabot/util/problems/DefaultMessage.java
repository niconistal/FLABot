/** * $Id: DefaultMessage.java,v 1.1 2006/02/07 02:19:31 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.problems;
import org.eclipse.core.runtime.Plugin;
public class DefaultMessage implements Message {

	private MessageSeverity severity;
	private String title;
	private String description;
	private Throwable cause;	private Plugin plugin;	private String pluginId;

	public DefaultMessage(Plugin plugin, String pluginId, MessageSeverity severity, String title, String description) {
		this(plugin, pluginId, severity, title, description, null);
	}

	public DefaultMessage(Plugin plugin, String pluginId, MessageSeverity severity, String title, String description, Throwable cause) {
		if(severity==null) {
			throw new NullPointerException();
		}
		this.plugin=plugin;
		this.severity=severity;
		this.title=title;
		this.description=description;
		this.cause=cause;		this.pluginId=pluginId;
	}
	
	public MessageSeverity getSeverity() {
		return severity;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public Throwable getCause() {
		return cause;
	}
	@Override	public String toString() {
		StringBuffer string=new StringBuffer();
		if(title!=null) {
			string.append('[');
			string.append(title);
			string.append(']');
		}
		if(description!=null) {
			string.append(' ');
			string.append(description);
		}
		if(string.length()==0) {
			string.append("Problem ");
			string.append('[');
			string.append(severity.getName());
			string.append(']');
		}
		return string.toString();
	}	public Plugin getPlugin() {		return plugin;	}	public String getPluginId() {		return pluginId;	}
}
