/**

import org.isistan.flabot.javamodel.JClass;
	private Object jdtObject;
	private long id;
	
	Object getJDTObject() {
		return jdtObject;
	}
	
	static Object getJDTObject(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			return ((ObjectImpl)jObject).getJDTObject();
		} else {
			throw new MixedImplementationsException(jObject);
		} 
	}
	
	ObjectImpl(Object javaObject) {
		this.jdtObject=javaObject;
		id=JDTFactory.getInstance().getId(javaObject);
	}
	
	public long getId() {
		return id;
	}

	public JClass getObjectClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean objectEquals(JObject other) {
		return jdtObject.equals(ObjectImpl.getJDTObject(other));
	}

	public void objectNotify() {
		jdtObject.notify();
	}

	public void objectNotifyAll() {
		jdtObject.notifyAll();
	}

	public void objectWait(long timeout) throws InterruptedException {
		jdtObject.wait(timeout);
	}

	public void objectWait(long timeout, int nanos) throws InterruptedException {
		jdtObject.wait(timeout, nanos);
	}

	public void objectWait() throws InterruptedException {
		jdtObject.wait();
	}
	
	public String objectToString() {
		return jdtObject.toString();
	}
	
	
	@Override
		return "Mirror for " + systemHashCode() + "@" + jdtObject.getClass().getName();
	}
	
	public int objectHashCode() {
		return jdtObject.hashCode();
	}

	public int systemHashCode() {
		return System.identityHashCode(jdtObject);
	}

}