/**

import org.isistan.flabot.javamodel.JPackage;

	public boolean accepts(Object object) {
		return object instanceof PackageBuilder;
	}

	public JPackage build(Object object) {
		return new PackageImpl((Package)object);
	}


}