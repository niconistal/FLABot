/**

import org.isistan.flabot.javamodel.JPackage;

	public boolean accepts(Object object) {
		return object instanceof String;
	}

	public JPackage build(Object object) {
		return new PackageImpl((String)object);
	}


}