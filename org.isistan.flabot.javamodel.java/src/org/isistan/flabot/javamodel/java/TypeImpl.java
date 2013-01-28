/** * $Id: TypeImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Type;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.MixedImplementationsException;public class TypeImpl extends ObjectImpl implements JType {

	private Type javaType;
	
	Type getJavaType() {
		return javaType;
	}
	
	static Type getJavaType(JType jType) {
		if(jType instanceof TypeImpl) {
			return ((TypeImpl)jType).getJavaType();
		} else {
			throw new MixedImplementationsException(jType);
		} 
	}
	
	TypeImpl(Type javaType) {
		super(javaType);
		this.javaType=javaType;
	}

}
