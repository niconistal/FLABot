/**

import java.lang.reflect.AnnotatedElement;
	
	public boolean accepts(Object object) {
		return object instanceof AnnotatedElement;
	}
	
	public JAnnotatedElement build(Object object) {
		return new AnnotatedElementImpl((AnnotatedElement)object);
	}

}