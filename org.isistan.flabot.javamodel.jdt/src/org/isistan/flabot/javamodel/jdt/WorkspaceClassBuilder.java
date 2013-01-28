/** * $Id: WorkspaceClassBuilder.java,v 1.2 2006/05/09 00:50:16 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IJavaProject;import org.eclipse.jdt.core.IType;import org.eclipse.jdt.core.JavaCore;import org.eclipse.jdt.core.dom.ITypeBinding;import org.eclipse.jdt.internal.corext.util.JavaModelUtil;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;import org.isistan.flabot.javamodel.Util;public class WorkspaceClassBuilder implements ObjectMirrorBuilder<JClass> {

	public boolean accepts(Object object) {
		return object instanceof IType || object instanceof WorkspacePrimitiveClassImpl.PrimitiveClass;
	}
	
	public JClass build(Object object) {		if(object instanceof IType) {			return new WorkspaceClassImpl((IType)object);		} else {			return new WorkspacePrimitiveClassImpl((WorkspacePrimitiveClassImpl.PrimitiveClass)object);		}
	}		static Object getBuildableObjectFromBinding(ITypeBinding binding, IJavaProject project) {		boolean isArray=binding.isArray();		boolean isPrimitive;		if(isArray) {			ITypeBinding elementType;			elementType=binding.getElementType();			while(elementType.isArray()) {				elementType=elementType.getElementType();				}			isPrimitive=elementType.isPrimitive();		} else {			isPrimitive=binding.isPrimitive();		}		if(isPrimitive) {			WorkspacePrimitiveClassImpl.PrimitiveClass primitiveClass=				WorkspacePrimitiveClassImpl.PrimitiveClass.get(						binding.getName(), project);			return primitiveClass;		} else {			if(binding.isTypeVariable()) {				binding=binding.getErasure();			}			return binding.getJavaElement();		}	}



}
