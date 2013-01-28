package org.isistan.flabot.mapping.mapper;

import org.isistan.flabot.javamodel.JObject;

public class WorkspaceMapperResult<T extends JObject> {

	private T element;
	private boolean packageAccepted;
	private boolean classAccepted;

	public WorkspaceMapperResult(T element, boolean packageAccepted, boolean classAccepted) {
		this.element=element;
		this.packageAccepted=packageAccepted;
		this.classAccepted=classAccepted;
		
	}

	public T getElement() {
		return element;
	}
	
	public boolean isPackageAccepted() {
		return packageAccepted;
	}

	public boolean isClassAccepted() {
		return classAccepted;
	}
}
