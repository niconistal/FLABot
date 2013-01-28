/** * $Id: FieldImpl.java,v 1.6 2006/03/24 00:33:59 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IField;import org.eclipse.jdt.core.JavaModelException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public class FieldImpl extends MemberImpl implements JField {

	private IField jdtField;
	
	IField getJDTField() {
		return jdtField;
	}
	
	static IField getJDTField(JField jField) {
		if(jField instanceof FieldImpl) {
			return ((FieldImpl)jField).getJDTField();
		} else {
			throw new MixedImplementationsException(jField);
		} 
	}
	
	FieldImpl(IField jdtField) {
		super(jdtField);
		this.jdtField=jdtField;
	}
	
	public void setAccessible(boolean flag) throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public boolean isAccessible() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public boolean isEnumConstant() {
		try {
			return jdtField.isEnumConstant();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	@Override	public JWorkspaceClass getType() {
		return JDTFactory.getInstance().buildClass(jdtField.getDeclaringType());
	}

	public JType getGenericType() {
		throw new NotSupportedFeatureException();
	}

	public String toGenericString() {
		throw new NotSupportedFeatureException();
	}

	public JObject get(JObject obj) {
		throw new NotSupportedFeatureException();
	}

	public void set(JObject obj, JObject value) {
		throw new NotSupportedFeatureException();
	}

	public String getDescriptor() {		return Util.getFieldDescriptor(this);	}
}
