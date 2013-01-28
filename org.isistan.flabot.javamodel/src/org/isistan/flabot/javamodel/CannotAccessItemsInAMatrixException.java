/**

public class CannotAccessItemsInAMatrixException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;

	
	private JArray array;

	public CannotAccessItemsInAMatrixException(JArray array) {
		this.array=array;
	}
	
	public JArray getArray() {
		return array;
	}
	
	@Override
		return "Cannot invoke the at() method in an array that represents a matrix, use subArrayAt() instead. Array: " + array;
	}
	
	
}