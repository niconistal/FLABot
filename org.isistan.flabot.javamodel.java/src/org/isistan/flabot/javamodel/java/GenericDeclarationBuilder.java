/**

import java.lang.reflect.GenericDeclaration;

	public boolean accepts(Object object) {
		return object instanceof GenericDeclaration;
	}
	public JGenericDeclaration build(Object object) {
		return new GenericDeclarationImpl((GenericDeclaration)object);
	}


}