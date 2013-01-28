/** * $Id: ClassLoaderImpl.java,v 1.4 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.io.IOException;import java.net.URL;import java.util.Enumeration;import java.util.Iterator;import java.util.LinkedList;import java.util.List;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;public class ClassLoaderImpl extends ObjectImpl implements JClassLoader {

	private ClassLoader javaClassLoader;
	
	ClassLoader getJavaClassLoader() {
		return javaClassLoader;
	}
	
	static ClassLoader getJavaClassLoader(JClassLoader jClassLoader) {
		if(jClassLoader instanceof ClassLoaderImpl) {
			return ((ClassLoaderImpl)jClassLoader).getJavaClassLoader();
		} else {
			throw new MixedImplementationsException(jClassLoader);
		} 
	}
	
	ClassLoaderImpl(ClassLoader javaClassLoader) {
		super(javaClassLoader);
		this.javaClassLoader=javaClassLoader;
	}
	
	public JClass loadClass(String name) {
		try {			return JavaFactory.getInstance().buildClass(javaClassLoader.loadClass(name));		} catch (ClassNotFoundException e) {			return null;		}
	}

	public JObject getResource(String name) {
		return JavaFactory.getInstance().buildObject(javaClassLoader.getResource(name));
	}

	public JArray<? extends JObject> getResources(String name) {		Enumeration<URL> resources;		try {			resources = javaClassLoader.getResources(name);		} catch (IOException e) {			throw new InternalModelException(e);		}		List<URL> resourcesList=new LinkedList<URL>();		for (; resources.hasMoreElements();) {			resourcesList.add(resources.nextElement());		}
		return JavaFactory.getInstance().buildArray(resourcesList.toArray());
	}

	public JObject getResourceAsStream(String name) {
		return JavaFactory.getInstance().buildObject(javaClassLoader.getResourceAsStream(name));
	}

	public JClassLoader getParent() {
		return JavaFactory.getInstance().buildClassLoader(javaClassLoader.getParent());
	}

	public void setDefaultAssertionStatus(boolean enabled) {
		javaClassLoader.setDefaultAssertionStatus(enabled);
	}

	public void setPackageAssertionStatus(String packageName, boolean enabled) {
		javaClassLoader.setPackageAssertionStatus(packageName, enabled);
	}

	public void setClassAssertionStatus(String className, boolean enabled) {
		javaClassLoader.setClassAssertionStatus(className, enabled);
	}

	public void clearAssertionStatus() {
		javaClassLoader.clearAssertionStatus();
	}

}
