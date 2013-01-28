/** * $Id: ArrayImpl.java,v 1.3 2006/03/18 00:25:06 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.util.Iterator;import org.isistan.flabot.javamodel.CannotAccessItemsInAMatrixException;import org.isistan.flabot.javamodel.CannotAccessSubarraysInANonMatrixException;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ArrayImpl<T extends JObject> extends ObjectImpl implements JArray<T> {

	private Object[] javaArray;
	private ObjectMirrorBuilder<T> componentBuilder;
	private boolean matrix;
	
	Object[] getJavaArray() {
		return javaArray;
	}
	
	static Object[] getJavaArray(JArray<? extends JObject> jArray) {
		if(jArray instanceof ArrayImpl) {
			return ((ArrayImpl)jArray).getJavaArray();
		} else {
			throw new MixedImplementationsException(jArray);
		}
	}
	
	ArrayImpl(Object[] javaArray, ObjectMirrorBuilder<T> componentBuilder) {
		super(javaArray);
		this.javaArray=javaArray;
		this.componentBuilder=componentBuilder;
		matrix=javaArray.getClass().getComponentType().isArray();
	}
	
	public int length() {
		return javaArray.length;
	}
	
	
	public boolean isMatrix() {
		return matrix;
	}

	public T at(int index) {
		if(!matrix) {
			return JavaFactory.getInstance().build(
					javaArray[index],
					componentBuilder
				);
		} else {
			throw new CannotAccessItemsInAMatrixException(this);
		}
	}

	public JArray<? extends T> subArrayAt(int index) {
		if(matrix) {
			return JavaFactory.getInstance().buildArray(
					javaArray[index],
					componentBuilder
				);	
		} else {
			throw new CannotAccessSubarraysInANonMatrixException(this);
		}
	}

	private class ArrayIterator implements Iterator<T> {
		private int index=0;
		public boolean hasNext() {
			return index<javaArray.length;
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
	}}
