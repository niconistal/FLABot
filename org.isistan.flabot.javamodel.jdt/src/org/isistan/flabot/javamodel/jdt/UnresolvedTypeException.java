/**


public class UnresolvedTypeException extends Exception {
	private String whereTypeName;
	private String unresolvedTypeName;

	public UnresolvedTypeException(String whereTypeName, String unresolvedTypeName) {
		this.whereTypeName=whereTypeName;
		this.unresolvedTypeName=unresolvedTypeName;
	}

	private static final long serialVersionUID = 1L;

	
	@Override
		return "Type could not be resolved: " + unresolvedTypeName + " (referenced from " + whereTypeName + ")";
	}
}