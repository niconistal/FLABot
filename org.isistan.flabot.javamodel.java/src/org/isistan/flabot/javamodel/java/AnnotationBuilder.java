/**

import java.lang.annotation.Annotation;
	public boolean accepts(Object object) {
		return object instanceof Annotation;
	}
	
	public JAnnotation build(Object object) {
		return new AnnotationImpl((Annotation)object);
	}



}