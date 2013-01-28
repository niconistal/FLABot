/**

import java.lang.reflect.AccessibleObject;
		JAccessibleObject {
	
	private AccessibleObject javaAccessibleObject;
	
	AccessibleObject getJavaAccessibleObject() {
		return javaAccessibleObject;
	}
	
	static AccessibleObject getJavaAccessibleObject(JAccessibleObject jAccessibleObject) {
		if(jAccessibleObject instanceof AccessibleObjectImpl) {
			return ((AccessibleObjectImpl)jAccessibleObject).getJavaAccessibleObject();
		} else {
			throw new MixedImplementationsException(jAccessibleObject);
		} 
	}
	
	AccessibleObjectImpl(AccessibleObject javaAccessibleObject) {
		super(javaAccessibleObject);
		this.javaAccessibleObject=javaAccessibleObject;
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaAccessibleObject.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaAccessibleObject.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaAccessibleObject.isAnnotationPresent(
				ClassImpl.getJavaClass(annotationType)
			);		
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(
				javaAccessibleObject.getAnnotation(ClassImpl.getJavaClass(annotationType))
			);		
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAccessibleObject.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaAccessibleObject.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);
	}

}