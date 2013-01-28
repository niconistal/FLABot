/**

import java.io.IOException;

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
		try {
	}

	public JObject getResource(String name) {
		return JavaFactory.getInstance().buildObject(javaClassLoader.getResource(name));
	}

	public JArray<? extends JObject> getResources(String name) {
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