/** * $Id: PackageImpl.java,v 1.4 2006/03/29 20:39:26 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;public class PackageImpl extends ObjectImpl implements JPackage {

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
	}		public String getSimpleName() {		if(isInRoot()) {			return getName();		} else {			String name=getName();			int lastDot=name.lastIndexOf(Util.PACKAGE_DELIMITER);			return name.substring(lastDot+1, name.length());		}	}

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
	}	public boolean isDefault() {		return getName().length()==0;	}		private JPackage parentPackage=null;	private boolean parentPackageCalculated=false;	public JPackage getParentPackage() {		if(!parentPackageCalculated) {			if(!isInRoot()) {				String name=getName();				int dotIndex=name.lastIndexOf(Util.PACKAGE_DELIMITER);				String parentPackageName=name.substring(0, dotIndex);				parentPackage=JavassistFactory.getInstance().buildPackage(parentPackageName);			}			parentPackageCalculated=true;		}		return parentPackage;	}	public JArray<? extends JPackage> getPackages() {		throw new NotSupportedFeatureException();	}		public boolean isInRoot() {		return getName().indexOf(Util.PACKAGE_DELIMITER)==-1;	}
	public String getDescriptor() {		return Util.getPackageDescriptor(this);	}
}
