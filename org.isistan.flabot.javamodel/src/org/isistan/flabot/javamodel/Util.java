/**


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
	public static final char MEMBER_DELIMITER='#';
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
	/**
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
	}
}