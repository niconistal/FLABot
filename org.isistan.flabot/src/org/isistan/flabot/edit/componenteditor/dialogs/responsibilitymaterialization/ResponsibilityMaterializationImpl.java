package org.isistan.flabot.edit.componenteditor.dialogs.responsibilitymaterialization;

import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;

public class ResponsibilityMaterializationImpl implements ResponsibilityMaterialization {

	private Responsibility responsibility;
	private ComponentModel component;

	public ResponsibilityMaterializationImpl(
			Responsibility responsibility,
			ComponentModel component) {
		this.responsibility=responsibility;
		this.component=component;
	}
	
	public Responsibility getResponsibility() {
		return responsibility;
	}

	public ComponentModel getComponent() {
		return component;
	}

}
