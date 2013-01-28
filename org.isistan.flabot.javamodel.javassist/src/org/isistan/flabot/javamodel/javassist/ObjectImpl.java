/**

import org.isistan.flabot.javamodel.JClass;
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
	
	
	@Override
		return "Mirror for " + systemHashCode() + "@" + javassistObject.getClass().getName();
	
	public int objectHashCode() {
		return javassistObject.hashCode();
	}

	public int systemHashCode() {
		return System.identityHashCode(javassistObject);
	}

}