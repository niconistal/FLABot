package org.isistan.flabot.javamodel;

import java.util.Iterator;


/**
 * This array implementation is useful when the used wants to create a new JArray
 * based on another JArray.
 * Instances of this class are obtained using the Factory#buildModelArray(Object[]) method
 * 
 * @author usuario
 *
 * @param <T>
 */
public class ModelArrayImpl<T extends JObject> implements JArray<T> {

	private Object[] jObjectArray;
	private boolean matrix;
	
	ModelArrayImpl(Object[] jObjectArray) {
		this.jObjectArray=jObjectArray;
		this.matrix=jObjectArray.getClass().getComponentType().isArray();
	}

	public int length() {
		return jObjectArray.length;
	}

	public boolean isMatrix() {
		return jObjectArray.getClass().getComponentType().isArray();
	}

	public T at(int index) {
		if(!matrix) {
			return (T)jObjectArray[index];
		} else {
			throw new CannotAccessItemsInAMatrixException(this);
		}
	}

	public JArray<? extends T> subArrayAt(int index) {
		if(matrix) {
			return Factory.<T>buildModelArray((Object[])jObjectArray[index]);	
		} else {
			throw new CannotAccessSubarraysInANonMatrixException(this);
		}
	}

	private class ArrayIterator implements Iterator<T> {
		private int index=0;
		public boolean hasNext() {
			return index<jObjectArray.length;
		}

		public T next() {
			return at(index++);
		}

		public void remove() {
			throw new RuntimeException("Remove not supported");
		}
		
	}
	
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	public long getId() {
		throw new NotSupportedFeatureException();
	}

	public JClass getObjectClass() {
		throw new NotSupportedFeatureException();
	}

	public int objectHashCode() {
		throw new NotSupportedFeatureException();
	}

	public int systemHashCode() {
		throw new NotSupportedFeatureException();
	}

	public boolean objectEquals(JObject other) {
		throw new NotSupportedFeatureException();
	}

	public String objectToString() {
		throw new NotSupportedFeatureException();
	}

	public void objectNotify() {
		throw new NotSupportedFeatureException();
	}

	public void objectNotifyAll() {
		throw new NotSupportedFeatureException();
	}

	public void objectWait(long timeout) throws InterruptedException {
		throw new NotSupportedFeatureException();
	}

	public void objectWait(long timeout, int nanos) throws InterruptedException {
		throw new NotSupportedFeatureException();
	}

	public void objectWait() throws InterruptedException {
		throw new NotSupportedFeatureException();
	}

	public boolean isPrimitiveValue() {
		return false;
	}

}
