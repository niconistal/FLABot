/**

public class MixedImplementationsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private JObject externalObject;
	
	public MixedImplementationsException(JObject externalObject) {
		this.externalObject=externalObject;
	}

	public JObject getExternalObject() {
		return externalObject;
	}

	@Override
		return "The operation does not allow the use of object mirrors from other implementations. External object: " + externalObject;
	}
}