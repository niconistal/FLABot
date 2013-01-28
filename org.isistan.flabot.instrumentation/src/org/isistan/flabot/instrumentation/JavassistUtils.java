/** * $Id: JavassistUtils.java,v 1.3 2006/02/03 04:42:31 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.instrumentation;

import javassist.ByteArrayClassPath;import javassist.ClassPool;import javassist.CtClass;import javassist.LoaderClassPath;import javassist.NotFoundException;public class JavassistUtils {
	private static class ClassLoaderClassPath extends LoaderClassPath {
		private Object loader;
		ClassLoaderClassPath(ClassLoader loader) {
			super(loader);
			this.loader=loader;
			if(this.loader==null);
		}
	}

	public static CtClass getCtClass(ClassLoader loader, String className, byte[] bytecode) throws NotFoundException {
		ClassPool loaderClassPool=new ClassPool(ClassPool.getDefault());
		loaderClassPool.appendClassPath(new ClassLoaderClassPath(loader));
		ClassPool classClassPool=new ClassPool(loaderClassPool);
		classClassPool.appendClassPath(new ByteArrayClassPath(className, bytecode));
		loaderClassPool.childFirstLookup=true;
		classClassPool.childFirstLookup=true;
		return classClassPool.get(className);
	}
	
	/**
	 * Check whether the given class is a classloader or not
	 * @param clazz
	 * @return
	 * @throws NotFoundException 
	 */
	public static boolean isClassLoader(CtClass clazz) throws NotFoundException {
		if(clazz.isArray()) {
			return false;
		}
		if ( clazz.getName().equals("java.lang.ClassLoader")) {
			return true;
		}
		CtClass superClass = clazz.getSuperclass();
		return superClass != null && isClassLoader(superClass);
	}	
}
