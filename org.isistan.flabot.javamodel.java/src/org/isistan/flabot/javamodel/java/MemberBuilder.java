/** * $Id: MemberBuilder.java,v 1.2 2006/02/16 01:57:48 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Member;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class MemberBuilder implements ObjectMirrorBuilder<JMember> {
	
	public boolean accepts(Object object) {
		return object instanceof Member;
	}

	public JMember build(Object object) {
		return null;
	}

}
