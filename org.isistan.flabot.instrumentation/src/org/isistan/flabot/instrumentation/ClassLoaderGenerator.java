/**

import java.io.File;
	public static final String CLASS_LOADER_CLASSNAME="java.lang.ClassLoader";
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NotFoundException 
	 * @throws CannotCompileException 
	 */
	public static void main(String[] arguments) throws IOException, NotFoundException, CannotCompileException {
		if(arguments==null || arguments.length!=1 || arguments[0]==null) {
			System.out.println("The first and only argument should be the output file path for the generated ClassLoader");
		}
		
		File file=new File(path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		
		RandomAccessFile outputFile=new RandomAccessFile(file, "rw");
		
		byte[] bytecode=generateClassLoader();
		
		outputFile.write(bytecode);
		
	}

	private static byte[] generateClassLoader() throws NotFoundException, CannotCompileException, IOException {
		classPool.appendSystemPath();
		CtClass classLoaderClass=classPool.get(CLASS_LOADER_CLASSNAME);

		ClassLoaderClassEditor preDefineClassMethodsEditor=new ClassLoaderClassEditor();
		classLoaderClass.instrument(preDefineClassMethodsEditor);
		editLoadClassMethod(classLoaderClass);

		return classLoaderClass.toBytecode();
	}
	
	private static void editLoadClassMethod(CtClass classLoaderClass) throws NotFoundException, CannotCompileException {
		CtClass[] param1=new CtClass[] {
				classLoaderClass.getClassPool().get("java.lang.String"),
		};
		CtClass[] param2=new CtClass[] {
				param1[0],
				classLoaderClass.getClassPool().get("boolean")
		};
		CtMethod method1=classLoaderClass.getDeclaredMethod("loadClass", param1);
		CtMethod method2=classLoaderClass.getDeclaredMethod("loadClass", param2);

		String code=
				"{" +
				"	if(this!=ClassLoader.getSystemClassLoader()" +
				"			&& !this.getClass().getName().startsWith(\"sun.misc.Launcher$\")" +
				"			&& $1!=null " +
				"			&& ($1.startsWith(\"org.isistan.flabot.instrumentation.\")" +
				"				|| $1.startsWith(\"org.isistan.flabot.gauge.\")" +
				"			)) {" +
				"		return ClassLoader.getSystemClassLoader().loadClass($$);" +
				"	}" +
				"}";

		method1.insertBefore(code);
	
	private static class ClassLoaderClassEditor extends ExprEditor {

		@Override
		public void edit(MethodCall methodCall) throws CannotCompileException {
			String methodName=methodCall.getMethodName();
			String className=methodCall.getClassName();
			//Edit preDefineClass method so it doesn't prohibits redefining "java.*" classes
			if(methodCall.where().getName().equals("preDefineClass")
					&& className.equals("java.lang.String")
					&& methodName.equals("startsWith")) {
				methodCall.replace(
						"{" +
						"	if($args.length==1" +
						"			&& $args[0]!=null" +
						"			&& $args[0].getClass().getName().equals(\"java.lang.String\")" +
						"			&& $args[0].equals(\"java.\")) {" +
						"		$_=false;" +
						"	} else {" +
						"		$_=$proceed($$);" +
						"	}" +
						"}"
					);
			}
			if(className.equals("java.lang.ClassLoader")) {
				if(methodName.equals("defineClass0")) {
					methodCall.replace(
							"{" +
							"	byte[] bytecode=org.isistan.flabot.instrumentation.classloader.Interceptor.instrument($0, $1, $2, $3, $4);" +
							"	$_=$0.defineClass0($1, bytecode, 0, bytecode.length, $5,$6);" +
							"}"
							);
				} else if(methodName.equals("defineClass1")) {
					methodCall.replace(
							"	byte[] bytecode=org.isistan.flabot.instrumentation.classloader.Interceptor.instrument($0, $1, $2, $3, $4);" +
							"	$_=$0.defineClass1($1, bytecode, 0, bytecode.length, $5, $6,$7);" +
							"}"
							);
				} else if(methodName.equals("defineClass2")) {
					methodCall.replace(
							"{" +
							"	byte[] bytecode=org.isistan.flabot.instrumentation.classloader.Interceptor.instrument($0, $1, $2, $3, $4);" +
							"	$_=$0.defineClass2($1, buffer, 0, bytecode.length, $5, $6,$7);" +
							"}"
							);
				}
			}		
		}
	}
}