/** * $Id: ObjectImpl.java,v 1.6 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;public class ObjectImpl implements JObject {
	private Object javaObject;
	private long id;
	
	Object getJavaObject() {
		return javaObject;
	}
	
	static Object getJavaObject(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			return ((ObjectImpl)jObject).getJavaObject();
		} else {
			throw new MixedImplementationsException(jObject);
		} 
	}
	
	ObjectImpl(Object javaObject) {
		this.javaObject=javaObject;
		id=JavaFactory.getInstance().getId(javaObject);	}
	
	/**
	 * Creates a clone
	 * @param javaObject
	 */
	ObjectImpl(JObject jObject) {
		Object javaObject=ObjectImpl.getJavaObject(jObject);
		this.javaObject=javaObject;
		this.id=jObject.getId();
		
	}
	
	public long getId() {
		return id;
	}

	public JClass getObjectClass() {
		return JavaFactory.getInstance().buildClass(javaObject.getClass());
	}

	public boolean objectEquals(JObject other) {
		return javaObject.equals(getJavaObject(other));
	}

	public void objectNotify() {
		javaObject.notify();
	}

	public void objectNotifyAll() {
		javaObject.notifyAll();
	}

	public void objectWait(long timeout) throws InterruptedException {
		javaObject.wait(timeout);
	}

	public void objectWait(long timeout, int nanos) throws InterruptedException {
		javaObject.wait(timeout, nanos);
	}

	public void objectWait() throws InterruptedException {
		javaObject.wait();
	}
	
	public String objectToString() {
		return javaObject.toString();
	}
	
	
	@Override	public String toString() {
		return "Mirror for " + systemHashCode() + "@" + getObjectClass().getName();
	}
	
	public int objectHashCode() {
		return javaObject.hashCode();
	}

	public int systemHashCode() {
		return System.identityHashCode(javaObject);
	}	public boolean isPrimitiveValue() {		return false;	}

}
