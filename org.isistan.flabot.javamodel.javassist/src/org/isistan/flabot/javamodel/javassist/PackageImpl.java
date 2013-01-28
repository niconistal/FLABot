/**

import org.isistan.flabot.javamodel.JAnnotation;

	private String javassistPackage;
	
	String getJavassistPackage() {
		return javassistPackage;
	}
	
	static String getJavassistPackage(JPackage jPackage) {
		if(jPackage instanceof PackageImpl) {
			return ((PackageImpl)jPackage).getJavassistPackage();
		} else {
			throw new MixedImplementationsException(jPackage);
		} 
	}
	
	PackageImpl(String javassistPackage) {
		super(javassistPackage);
		this.javassistPackage=javassistPackage;
	}
	
	public String getName() {
		return javassistPackage;
	}

	public String getSpecificationTitle() {
		throw new NotSupportedFeatureException();
	}

	public String getSpecificationVersion() {
		throw new NotSupportedFeatureException();
	}

	public String getSpecificationVendor() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationTitle() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationVersion() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationVendor() {
		throw new NotSupportedFeatureException();
	}

	public boolean isSealed() {
		throw new NotSupportedFeatureException();
	}

	public boolean isSealed(JObject url) {
		throw new NotSupportedFeatureException();
	}

	public boolean isCompatibleWith(String desired)
			throws NumberFormatException {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}

}