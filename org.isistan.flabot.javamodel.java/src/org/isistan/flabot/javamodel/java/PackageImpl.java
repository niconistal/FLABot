/** * $Id: PackageImpl.java,v 1.4 2006/03/29 20:39:54 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.net.URL;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;public class PackageImpl extends AnnotatedElementImpl implements JPackage {

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
	public String getSimpleName() {		if(isInRoot()) {			return getName();		} else {			String name=getName();			int lastDot=name.lastIndexOf(Util.PACKAGE_DELIMITER);			return name.substring(lastDot+1, name.length());		}	}
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
	}	public boolean isDefault() {		return getName().length()==0;	}	private JPackage parentPackage=null;	private boolean parentPackageCalculated=false;	public JPackage getParentPackage() {		if(!parentPackageCalculated) {			if(!isInRoot()) {				String name=javaPackage.getName();				int dotIndex=name.lastIndexOf(Util.PACKAGE_DELIMITER);				String parentPackageName=name.substring(0, dotIndex);				Package javaParentPackage=Package.getPackage(parentPackageName);				parentPackage=JavaFactory.getInstance().buildPackage(javaParentPackage);			}			parentPackageCalculated=true;		}		return parentPackage;	}	public JArray<? extends JPackage> getPackages() {		throw new NotSupportedFeatureException();	}	public boolean isInRoot() {		return getName().indexOf(Util.PACKAGE_DELIMITER)==-1;	}
	public String getDescriptor() {		return Util.getPackageDescriptor(this);	}
}
