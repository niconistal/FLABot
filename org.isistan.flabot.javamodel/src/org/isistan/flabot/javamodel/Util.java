/** * $Id: Util.java,v 1.7 2006/03/29 20:43:50 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


public class Util {
	public static final String BOOLEAN_NAME="boolean";
	public static final String BYTE_NAME="byte";
	public static final String CHAR_NAME="char";
	public static final String DOUBLE_NAME="double";
	public static final String FLOAT_NAME="float";
	public static final String INT_NAME="int";
	public static final String LONG_NAME="long";
	public static final String SHORT_NAME="short";
	public static final String VOID_NAME="void";
	
	public static final String ARRAY_TERMINATOR="[]";

	public static final String BOOLEAN_JNI_NAME="Z";
	public static final String BYTE_JNI_NAME="B";
	public static final String CHAR_JNI_NAME="C";
	public static final String DOUBLE_JNI_NAME="D";
	public static final String FLOAT_JNI_NAME="F";
	public static final String INT_JNI_NAME="I";
	public static final String LONG_JNI_NAME="J";
	public static final String SHORT_JNI_NAME="S";
	public static final String VOID_JNI_NAME="V";
	
	public static final String CLASS_JNI_CHARACTER="L";
	public static final char CLASS_JNI_TERMINATOR_CHARACTER=';';
	public static final String ARRAY_JNI_CHARACTER="[";


	public static final char JNI_NESTED_CLASS_DELIMITER='$';
	public static final char JNI_PACKAGE_DELIMITER='/';
	public static final char NESTED_CLASS_DELIMITER='$';
	public static final char PACKAGE_DELIMITER='.';
	//public static final char CLASS_DELIMITER='@';
	public static final char MEMBER_DELIMITER='#';	public static final char TYPE_DELIMITER=':';	public static final char ARGUMENT_DELIMITER=',';	public static final char ARGUMENTS_INITIATOR='(';	public static final char ARGUMENTS_TERMINATOR=')';	public static final String PACKAGE_DESCRIPTOR_TYPE="";//"package";	public static final String CLASS_DESCRIPTOR_TYPE="";//"class";	public static final String FIELD_DESCRIPTOR_TYPE="";//"field";	public static final String BEHAVIOR_DESCRIPTOR_TYPE="";//"behavior";	public static final String DESCRIPTOR_TYPE_DELIMITER="";//":";		/**	 * Transforms a primitve type name into a JNI primitive type name	 * @param name	 * @return	 */
	public static String getPrimitiveJNIName(String name) {
		if(name.equals(BOOLEAN_NAME)) {
			return BOOLEAN_JNI_NAME;
		} else if(name.equals(BYTE_NAME)) {
			return BYTE_JNI_NAME;
		} else if(name.equals(CHAR_NAME)) {
			return CHAR_JNI_NAME;
		} else if(name.equals(DOUBLE_NAME)) {
			return DOUBLE_JNI_NAME;
		} else if(name.equals(FLOAT_NAME)) {
			return FLOAT_JNI_NAME;
		} else if(name.equals(INT_NAME)) {
			return INT_JNI_NAME;
		} else if(name.equals(LONG_NAME)) {
			return LONG_JNI_NAME;
		} else if(name.equals(SHORT_NAME)) {
			return SHORT_JNI_NAME;
		} else if(name.equals(VOID_NAME)) {
			return VOID_JNI_NAME;
		} else {
			throw new IllegalArgumentException("Not a primitive name: " + name);
		}
			
	}	
	/**	 * Transforms a JNI primitve type name into a primitive type name 	 * @param jniName	 * @return	 */
	public static String getPrimitiveName(String jniName) {
		if(jniName.equals(BOOLEAN_JNI_NAME)) {
			return BOOLEAN_NAME;
		} else if(jniName.equals(BYTE_JNI_NAME)) {
			return BYTE_NAME;
		} else if(jniName.equals(CHAR_JNI_NAME)) {
			return CHAR_NAME;
		} else if(jniName.equals(DOUBLE_JNI_NAME)) {
			return DOUBLE_NAME;
		} else if(jniName.equals(FLOAT_JNI_NAME)) {
			return FLOAT_NAME;
		} else if(jniName.equals(INT_JNI_NAME)) {
			return INT_NAME;
		} else if(jniName.equals(LONG_JNI_NAME)) {
			return LONG_NAME;
		} else if(jniName.equals(SHORT_JNI_NAME)) {
			return SHORT_NAME;
		} else if(jniName.equals(VOID_JNI_NAME)) {
			return VOID_NAME;
		} else {
			throw new IllegalArgumentException("Not a primitive JNI name: " + jniName);
		}
	}
	/**	 * Checks whether a type name is primitive	 * @param name	 * @return	 */
	public static boolean isPrimitiveName(String name) {
		return name.equals(BOOLEAN_NAME) ||
			name.equals(BYTE_NAME) ||
			name.equals(CHAR_NAME) ||
			name.equals(DOUBLE_NAME) ||
			name.equals(FLOAT_NAME) ||
			name.equals(INT_NAME) ||
			name.equals(LONG_NAME) ||
			name.equals(SHORT_NAME) ||
			name.equals(VOID_NAME);
	}
	/**	 * Checks whether a type name is JNI primitive	 * @param jniName	 * @return	 */
	public static boolean isPrimitiveJNIName(String jniName) {
		return jniName.equals(BOOLEAN_JNI_NAME) ||
			jniName.equals(BYTE_JNI_NAME) ||
			jniName.equals(CHAR_JNI_NAME) ||
			jniName.equals(DOUBLE_JNI_NAME) ||
			jniName.equals(FLOAT_JNI_NAME) ||
			jniName.equals(INT_JNI_NAME) ||
			jniName.equals(LONG_JNI_NAME) ||
			jniName.equals(SHORT_JNI_NAME) ||
			jniName.equals(VOID_JNI_NAME);
	}
		/**	 * Transforms a class name into a JNI class name 	 * @param jniName	 * @return	 */
	public static String getName(String jniName) {
		String deArrayedJNIName=jniName.replace(ARRAY_JNI_CHARACTER, "");
		int dimensions=jniName.length()-deArrayedJNIName.length();
		
		StringBuffer name=new StringBuffer();
		if(isPrimitiveJNIName(deArrayedJNIName)) {
			name.append(getPrimitiveName(deArrayedJNIName));
		} else {
			name.append(deArrayedJNIName.substring(1, deArrayedJNIName.length()-1).replace(JNI_PACKAGE_DELIMITER, PACKAGE_DELIMITER).replace(JNI_NESTED_CLASS_DELIMITER, NESTED_CLASS_DELIMITER));
		}
		
		for(int i=0; i<dimensions; i++) {
			name.append(ARRAY_TERMINATOR);
		}
		return name.toString();
	}
		/**	 * Transforms a JNI class name into a class name	 * @param name	 * @return	 */
	public static String getJNIName(String name) {
		String deArrayedName=name.replace(ARRAY_TERMINATOR, "");
		int dimensions=(name.length()-deArrayedName.length())/2;
		
		StringBuffer jniName=new StringBuffer();
		for(int i=0; i<dimensions; i++) {
			jniName.append(ARRAY_JNI_CHARACTER);
		}
		if(isPrimitiveName(deArrayedName)) {
			jniName.append(getPrimitiveJNIName(deArrayedName));
		} else {
			jniName.append(CLASS_JNI_CHARACTER);
			jniName.append(deArrayedName.replace(PACKAGE_DELIMITER, JNI_PACKAGE_DELIMITER).replace(NESTED_CLASS_DELIMITER, JNI_NESTED_CLASS_DELIMITER));
			jniName.append(CLASS_JNI_TERMINATOR_CHARACTER);
		}
		

		return jniName.toString();
	}

	/**
	 * Transforms a class name into a name understood by the class loaders
	 * @param jniName
	 * @return
	 */
	public static String getClassLoaderName(String name) {
		if(isPrimitiveName(name)) {
			throw new IllegalArgumentException("Primitive names doesn't have ClassLoder names: " + name);
		}
		if(name.endsWith("]"))
			return getJNIName(name).replace(JNI_PACKAGE_DELIMITER, PACKAGE_DELIMITER);
		else
			return name;
	}
	/**	 * Checks whether a class is a subclass of another with the given name	 * @param jClass	 * @param name	 * @return	 */
	public static boolean isSubclassOf(JClass jClass, String name) {
		JClass superClass=jClass.getSuperclass();
		if(superClass==null) {
			return false;
		} else {
			if(superClass.getName().equals(name)) {
				return true;
			} else {
				return isSubclassOf(superClass, name);
			}
		}
	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @param jPackage	 * @return	 */	public static String getPackageDescriptor(JPackage jPackage) {		return PACKAGE_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ jPackage.getName();	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @return	 */	public static String getPackageDescriptor(String packageName) {		return PACKAGE_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ packageName;	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @param jClass	 * @return	 */	public static String getClassDescriptor(JClass jClass) {		return CLASS_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ jClass.getName();	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @return	 */	public static String getClassDescriptor(String className) {		return CLASS_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ className;	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @param jBehavior	 * @return	 */	public static String getBehaviorDescriptor(JBehavior jBehavior) {		return BEHAVIOR_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ jBehavior.getDeclaringClass().getName()				+ Util.MEMBER_DELIMITER				+ jBehavior.getName()				+ jBehavior.getSignature();	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @return	 */	public static String getBehaviorDescriptor(String declaringClassName,			String behaviorName, String signature) {		return BEHAVIOR_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ declaringClassName				+ Util.MEMBER_DELIMITER				+ behaviorName				+ signature;	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @param jField	 * @return	 */	public static String getFieldDescriptor(JField jField) {		return FIELD_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ jField.getDeclaringClass().getName()				+ Util.MEMBER_DELIMITER				+ jField.getName()				+ Util.TYPE_DELIMITER				+ jField.getType().getName();	}		/**	 * Returns a descriptor as defined by JDescriptedElement.getDescriptor()	 * @return	 */	public static String getFieldDescriptor(String declaringClassName,			String fieldName, String typeName) {		return FIELD_DESCRIPTOR_TYPE				+ DESCRIPTOR_TYPE_DELIMITER				+ declaringClassName				+ Util.MEMBER_DELIMITER				+ fieldName				+ Util.TYPE_DELIMITER				+ typeName;	}		/**	 * Returns a signature as defined by JBehavior.getSignature()	 * @param jBehavior	 * @return	 */	public static String getSignature(JBehavior jBehavior) {		StringBuffer signatureBuff=new StringBuffer();				signatureBuff.append('(');		JArray<? extends JClass> parameterTypes=jBehavior.getParameterTypes();		for(int i=0; i<parameterTypes.length(); i++) {			if(i>0)				signatureBuff.append(',');			signatureBuff.append(parameterTypes.at(i).getName());		}		signatureBuff.append(')');		if(jBehavior instanceof JMethod) {			signatureBuff.append(Util.TYPE_DELIMITER);			signatureBuff.append(jBehavior.getType().getName());				}		return signatureBuff.toString();	}		/**	 * Returns a signature as defined by JBehavior.getJNISignature()	 * @param jBehavior	 * @return	 */	public static String getJNISignature(JBehavior jBehavior) {		StringBuffer signatureBuff=new StringBuffer();				signatureBuff.append('(');		JArray<? extends JClass> parameterTypes=jBehavior.getParameterTypes();				for(int i=0; i<parameterTypes.length(); i++) {			signatureBuff.append(parameterTypes.at(i).getJNIName());		}		signatureBuff.append(')');		if(jBehavior instanceof JMethod) {			signatureBuff.append(jBehavior.getType().getJNIName());					} else {			signatureBuff.append(Util.VOID_JNI_NAME);		}				return signatureBuff.toString();	}		/**	 * Returns a signature as defined by JBehavior.getJNISignature()	 * if return type is null then it is replaced by V (void)	 * @return	 */	public static String getJNISignature(String[] jniParameterTypes, String jniReturnType) {		StringBuffer signatureBuff=new StringBuffer();				signatureBuff.append('(');			for(int i=0; i<jniParameterTypes.length; i++) {			signatureBuff.append(jniParameterTypes[i]);		}		signatureBuff.append(')');		if(jniReturnType!=null) {			signatureBuff.append(jniReturnType);					} else {			signatureBuff.append(Util.VOID_JNI_NAME);		}				return signatureBuff.toString();	}		/**	 * Returns a signature as defined by JBehavior.getJNISignature()	 * if return type is null, return type is not included in signature	 * @return	 */	public static String getSignature(String[] parameterTypes, String returnType) {		StringBuffer signatureBuff=new StringBuffer();				signatureBuff.append('(');		for(int i=0; i<parameterTypes.length; i++) {			if(i>0)				signatureBuff.append(',');			signatureBuff.append(parameterTypes[i]);		}		signatureBuff.append(')');		if(returnType!=null) {			signatureBuff.append(Util.TYPE_DELIMITER);			signatureBuff.append(returnType);				}		return signatureBuff.toString();	}
}
