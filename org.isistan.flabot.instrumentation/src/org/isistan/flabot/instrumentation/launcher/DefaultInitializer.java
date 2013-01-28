/**


public class DefaultInitializer implements Initializer {
	private String mainClassName;
	private String[] arguments;
	
	public void start(String[] arguments) {
		mainClassName=arguments[0];
		
		this.arguments=new String[arguments.length-1];
		for (int i = 0; i < this.arguments.length; i++) {
			this.arguments[i]=arguments[i+1];
		}
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void finish() {
	}

}