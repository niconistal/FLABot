/**

public class InternalModelException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;

	public InternalModelException(Throwable e) {
		super(e);
	}
	
	@Override
		return "Exception caused by the particular underlying model [" + getCause().getClass().getName() + "]: " + getCause().toString();
	}

}