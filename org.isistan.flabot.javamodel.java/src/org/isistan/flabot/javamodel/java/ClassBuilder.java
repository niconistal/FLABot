/**

import org.isistan.flabot.javamodel.JClass;

	public boolean accepts(Object object) {
		return object instanceof Class;
	}
	
	public JClass build(Object object) {
		return new ClassImpl((Class)object);
	}



}