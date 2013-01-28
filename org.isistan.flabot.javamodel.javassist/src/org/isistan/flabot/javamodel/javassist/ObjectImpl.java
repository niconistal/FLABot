/** * $Id: ObjectImpl.java,v 1.7 2006/03/24 00:34:01 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;public class ObjectImpl implements JObject {
	private Object javassistObject;
	private long id;
	
	Object getJavassistObject() {
		return javassistObject;
	}
	
	static Object getJavassistObject(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			return ((ObjectImpl)jObject).getJavassistObject();
		} else {
			throw new MixedImplementationsException(jObject);
		} 
	}
	
	ObjectImpl(Object javassistObject) {
		this.javassistObject=javassistObject;
		id=JavassistFactory.getInstance().getId(javassistObject);
	}
	
	/**
	 * Creates a clone
	 * @param javassistObject
	 */
	ObjectImpl(JObject jObject) {
		Object javassistObject=ObjectImpl.getJavassistObject(jObject);
		this.javassistObject=javassistObject;
		this.id=jObject.getId();
		
	}
	
	public long getId() {
		return id;
	}

	public JClass getObjectClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean objectEquals(JObject other) {
		return javassistObject.equals(getJavassistObject(other));
	}

	public void objectNotify() {
		javassistObject.notify();
	}

	public void objectNotifyAll() {
		javassistObject.notifyAll();
	}

	public void objectWait(long timeout) throws InterruptedException {
		javassistObject.wait(timeout);
	}

	public void objectWait(long timeout, int nanos) throws InterruptedException {
		javassistObject.wait(timeout, nanos);
	}

	public void objectWait() throws InterruptedException {
		javassistObject.wait();
	}
	
	public String objectToString() {
		return javassistObject.toString();
	}
	
	
	@Override	public String toString() {
		return "Mirror for " + systemHashCode() + "@" + javassistObject.getClass().getName();	}
	
	public int objectHashCode() {
		return javassistObject.hashCode();
	}

	public int systemHashCode() {
		return System.identityHashCode(javassistObject);
	}		public boolean isPrimitiveValue() {		return false;	}

}
