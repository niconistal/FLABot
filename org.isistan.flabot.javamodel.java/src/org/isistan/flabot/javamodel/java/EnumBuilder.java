/**

import org.isistan.flabot.javamodel.JEnum;

	public boolean accepts(Object object) {
		return object instanceof Enum;
	}

	public JEnum build(Object object) {
		return new EnumImpl((Enum)object);
	}


}