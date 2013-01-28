/**

public class InstrumentationException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstrumentationException(String message, Exception exception) {
		super(message, exception);
	}
	
	@Override
		return "Error while instrumenting: [" + getCause().getClass().getName() + "] " + getMessage();
	}
}