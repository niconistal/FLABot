/**

import org.isistan.flabot.javamodel.JClass;

	private Enum javaEnum;
	
	Enum getJavaEnum() {
		return javaEnum;
	}
	
	static Enum getJavaEnum(JEnum jEnum) {
		if(jEnum instanceof EnumImpl) {
			return ((EnumImpl)jEnum).getJavaEnum();
		} else {
			throw new MixedImplementationsException(jEnum);
		} 
	}
	
	EnumImpl(Enum javaEnum) {
		super(javaEnum);
		this.javaEnum=javaEnum;
	}
	
	public String name() {
		return javaEnum.name();
	}

	public int ordinal() {
		return javaEnum.ordinal();
	}

	public int compareTo(JEnum o) {
		return javaEnum.compareTo(EnumImpl.getJavaEnum(o));
	}

	public JClass getDeclaringClass() {
		return JavaFactory.getInstance().buildClass(javaEnum.getDeclaringClass());
	}

}