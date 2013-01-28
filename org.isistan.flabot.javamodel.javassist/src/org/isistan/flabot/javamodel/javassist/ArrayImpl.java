/** * $Id: ArrayImpl.java,v 1.3 2006/03/18 00:25:03 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import java.util.Iterator;import org.isistan.flabot.javamodel.CannotAccessItemsInAMatrixException;import org.isistan.flabot.javamodel.CannotAccessSubarraysInANonMatrixException;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class ArrayImpl<T extends JObject> extends ObjectImpl implements JArray<T> {

	private Object[] javassistArray;
	private ObjectMirrorBuilder<T> componentBuilder;
	private boolean matrix;
	
	Object[] getJavassistArray() {
		return javassistArray;
	}
	
	static Object[] getJavassistArray(JArray<? extends JObject> jArray) {
		if(jArray instanceof ArrayImpl) {
			return ((ArrayImpl)jArray).getJavassistArray();
		} else {
			throw new MixedImplementationsException(jArray);
		}
	}
	
	ArrayImpl(Object[] javassistArray, ObjectMirrorBuilder<T> componentBuilder) {
		super(javassistArray);
		this.javassistArray=javassistArray;
		this.componentBuilder=componentBuilder;
		matrix=javassistArray.getClass().getComponentType().isArray();
	}
	
	public int length() {
		return javassistArray.length;
	}
	
	
	public boolean isMatrix() {
		return matrix;
	}

	public T at(int index) {
		if(!matrix) {
			return JavassistFactory.getInstance().build(
					javassistArray[index],
					componentBuilder
				);
		} else {
			throw new CannotAccessItemsInAMatrixException(this);
		}
	}

	public JArray<? extends T> subArrayAt(int index) {
		if(matrix) {
			return JavassistFactory.getInstance().buildArray(
					javassistArray[index],
					componentBuilder
				);	
		} else {
			throw new CannotAccessSubarraysInANonMatrixException(this);
		}
	}

	private class ArrayIterator implements Iterator<T> {
		int index=0;
		public boolean hasNext() {
			return index<javassistArray.length;
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
}
