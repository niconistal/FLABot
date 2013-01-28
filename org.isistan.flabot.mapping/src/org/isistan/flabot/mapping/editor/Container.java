package org.isistan.flabot.mapping.editor;

class Container {
	private Object containedObject;

	public Container(Object containedObject) {
		this.containedObject=containedObject;
	}
	
	public Object getUnderlayingObject() {
		return containedObject;
	}
}
