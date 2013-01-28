/**

import java.net.URL;

	private Package javaPackage;
	
	Package getJavaPackage() {
		return javaPackage;
	}
	
	static Package getJavaPackage(JPackage jPackage) {
		if(jPackage instanceof PackageImpl) {
			return ((PackageImpl)jPackage).getJavaPackage();
		} else {
			throw new MixedImplementationsException(jPackage);
		} 
	}
	
	PackageImpl(Package javaPackage) {
		super(javaPackage);
		this.javaPackage=javaPackage;
	}
	
	public String getName() {
		return javaPackage.getName();
	}

	public String getSpecificationTitle() {
		return javaPackage.getSpecificationTitle();
	}

	public String getSpecificationVersion() {
		return javaPackage.getSpecificationVersion();
	}

	public String getSpecificationVendor() {
		return javaPackage.getSpecificationVendor();
	}

	public String getImplementationTitle() {
		return javaPackage.getImplementationTitle();
	}

	public String getImplementationVersion() {
		return javaPackage.getImplementationVersion();
	}

	public String getImplementationVendor() {
		return javaPackage.getImplementationVendor();
	}

	public boolean isSealed() {
		return javaPackage.isSealed();
	}

	public boolean isSealed(JObject url) {
		return javaPackage.isSealed((URL)ObjectImpl.getJavaObject(url));
	}

	public boolean isCompatibleWith(String desired)
			throws NumberFormatException {
		return javaPackage.isCompatibleWith(desired);
	}

}