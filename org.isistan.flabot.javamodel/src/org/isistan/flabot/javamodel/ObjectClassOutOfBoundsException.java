/**

public class ObjectClassOutOfBoundsException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;
	
	private Object object;
	
	public ObjectClassOutOfBoundsException(Object object) {
		this.object=object;
	}

	public Object getObject() {
		return object;
	}

	@Override
		return "The object mirror could not be built. Object class: " + object.getClass();
	}
}