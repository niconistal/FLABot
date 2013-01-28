/**

import java.util.Iterator;

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
	}