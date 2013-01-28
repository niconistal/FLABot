/** * $Id: ConstructorBuilder.java,v 1.4 2006/03/18 00:25:14 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IMethod;import org.eclipse.jdt.core.JavaModelException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.jdt.ImplicitConstructorImpl.JDTImplicitConstructor;public class ConstructorBuilder implements ObjectMirrorBuilder<JConstructor> {

	public boolean accepts(Object object) {
		try {			return (object instanceof IMethod && ((IMethod)object).isConstructor())				 || object instanceof JDTImplicitConstructor;		} catch (JavaModelException e) {			throw new InternalModelException(e);		}
	}	
	public JConstructor build(Object object) {		if(object instanceof IMethod) {			return new ConstructorImpl((IMethod)object);		} else {			return new ImplicitConstructorImpl((JDTImplicitConstructor)object);		}	}

}
