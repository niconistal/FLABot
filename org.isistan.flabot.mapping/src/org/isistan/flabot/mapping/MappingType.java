package org.isistan.flabot.mapping;

import org.isistan.flabot.util.enums.Enum;

public final class MappingType extends Enum {
	public static final MappingType PACKAGES=new MappingType("PACKAGES");		
	public static final MappingType CLASSES=new MappingType("CLASSES");		
	public static final MappingType BEHAVIORS=new MappingType("BEHAVIORS");	
	public static final MappingType ANYTHING=new MappingType("ANYTHING");	
	public static final MappingType PACKAGES_AND_CLASSES=new MappingType("PACKAGES_AND_CLASSES");	
	public static final MappingType CLASSES_AND_BEHAVIORS=new MappingType("CLASSES_AND_BEHAVIORS");	
	public static final MappingType PACKAGES_AND_BEHAVIORS=new MappingType("PACKAGES_AND_BEHAVIORS");	

	
	private MappingType(String name) {
		super(name);
	}
	
	public boolean isPackages() {
		return this==PACKAGES
				|| this==ANYTHING
				|| this==PACKAGES_AND_CLASSES
				|| this==PACKAGES_AND_BEHAVIORS;
	}
	
	public boolean isClasses() {
		return this==CLASSES
				|| this==ANYTHING
				|| this==PACKAGES_AND_CLASSES
				|| this==CLASSES_AND_BEHAVIORS;
	}
	
	
	public boolean isBehaviors() {
		return this==BEHAVIORS
				|| this==ANYTHING
				|| this==CLASSES_AND_BEHAVIORS
				|| this==PACKAGES_AND_BEHAVIORS;
	}
}
