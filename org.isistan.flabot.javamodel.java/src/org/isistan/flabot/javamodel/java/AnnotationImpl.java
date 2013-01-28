/**

import java.lang.annotation.Annotation;
	private Annotation javaAnnotation;
	
	Annotation getJavaAnnotation() {
		return javaAnnotation;
	}
	
	static Annotation getJavaAnnotation(JAnnotation jAnnotation) {
		if(jAnnotation instanceof AnnotationImpl) {
			return ((AnnotationImpl)jAnnotation).getJavaAnnotation();
		} else {
			throw new MixedImplementationsException(jAnnotation);
		} 
	}
	
	AnnotationImpl(Annotation javaAnnotation) {
		super(javaAnnotation);
		this.javaAnnotation=javaAnnotation;
	}
	
	public JClass annotationType() {
		return JavaFactory.getInstance().buildClass(javaAnnotation.annotationType());
	}
}