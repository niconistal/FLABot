/** * $Id: MessageSeverity.java,v 1.1 2006/02/07 02:19:31 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.problems;

import org.isistan.flabot.util.enums.Enum;public class MessageSeverity extends Enum {
	public static final MessageSeverity WARNING=new MessageSeverity("WARNING");
	public static final MessageSeverity ERROR=new MessageSeverity("ERROR");	public static final MessageSeverity INFORMATION = new MessageSeverity("INFORMATION");
	
	private MessageSeverity(String name) {
		super(name);
	}
}
