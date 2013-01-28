/**

public class CannotAccessSubarraysInANonMatrixException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;
	
	private JArray array;

	public CannotAccessSubarraysInANonMatrixException(JArray array) {
		this.array=array;
	}
	
	public JArray getArray() {
		return array;
	}
	
	@Override
		return "Cannot invoke the subArrayAt() method in an array that does not represent a matrix, use at() instead. Array: " + array;
	}
}