/**

import org.isistan.flabot.javamodel.JClassLoader;

	public boolean accepts(Object object) {
		return object instanceof ClassLoader;
	}
	public JClassLoader build(Object object) {
		return new ClassLoaderImpl((ClassLoader)object);
	}



}