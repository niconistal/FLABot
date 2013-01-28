/**

import java.util.Iterator;

	private Object[] jdtArray;
	private ObjectMirrorBuilder<T> componentBuilder;
	private boolean matrix;
	
	Object[] getJDTArray() {
		return jdtArray;
	}
	
	static Object[] getJDTArray(JArray<? extends JObject> jArray) {
		if(jArray instanceof ArrayImpl) {
			return ((ArrayImpl)jArray).getJDTArray();
		} else {
			throw new MixedImplementationsException(jArray);
		}
	}
	
	ArrayImpl(Object[] jdtArray, ObjectMirrorBuilder<T> componentBuilder) {
		super(jdtArray);
		this.jdtArray=jdtArray;
		this.componentBuilder=componentBuilder;
		matrix=jdtArray.getClass().getComponentType().isArray();
	}
	
	public int length() {
		return jdtArray.length;
	}
	
	
	public boolean isMatrix() {
		return matrix;
	}

	public T at(int index) {
		if(!matrix) {
			return JDTFactory.getInstance().build(
					jdtArray[index],
					componentBuilder
				);
		} else {
			throw new CannotAccessItemsInAMatrixException(this);
		}
	}

	public JArray<? extends T> subArrayAt(int index) {
		if(matrix) {
			return JDTFactory.getInstance().buildArray(
					jdtArray[index],
					componentBuilder
				);	
		} else {
			throw new CannotAccessSubarraysInANonMatrixException(this);
		}
	}

	private class ArrayIterator implements Iterator<T> {
		int index=0;
		public boolean hasNext() {
			return index<jdtArray.length;
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