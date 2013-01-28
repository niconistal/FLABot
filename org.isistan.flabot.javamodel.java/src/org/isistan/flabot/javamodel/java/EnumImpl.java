/** * $Id: EnumImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.MixedImplementationsException;public class EnumImpl extends ObjectImpl implements JEnum {

	private Enum javaEnum;
	
	Enum getJavaEnum() {
		return javaEnum;
	}
	
	static Enum getJavaEnum(JEnum jEnum) {
		if(jEnum instanceof EnumImpl) {
			return ((EnumImpl)jEnum).getJavaEnum();
		} else {
			throw new MixedImplementationsException(jEnum);
		} 
	}
	
	EnumImpl(Enum javaEnum) {
		super(javaEnum);
		this.javaEnum=javaEnum;
	}
	
	public String name() {
		return javaEnum.name();
	}

	public int ordinal() {
		return javaEnum.ordinal();
	}

	public int compareTo(JEnum o) {
		return javaEnum.compareTo(EnumImpl.getJavaEnum(o));
	}

	public JClass getDeclaringClass() {
		return JavaFactory.getInstance().buildClass(javaEnum.getDeclaringClass());
	}

}
