/**

public class DefaultMessage implements Message {

	private MessageSeverity severity;
	private String title;
	private String description;
	private Throwable cause;

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
		this.cause=cause;
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
	@Override
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
	}
}