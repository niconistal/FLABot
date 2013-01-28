/**

import java.util.HashMap; 

	private static JavaFactory instance=null;
	
	public static JavaFactory getInstance() {
		if(instance==null)
			instance=new JavaFactory();
		return instance;
	}
	
	private JavaFactory() {
	}
	
	@Override
		objectBuilder=new ObjectBuilder();
				new ObjectMirrorBuilder[] {
						fieldBuilder=new FieldBuilder(),
						behaviorBuilder=new CompositeMirrorBuilder<JBehavior>(
								new ObjectMirrorBuilder[] {
										methodBuilder=new MethodBuilder(),
										constructorBuilder=new ConstructorBuilder()
								}, new BehaviorBuilder()
							)
				}, new MemberBuilder()
			);
		annotationBuilder=new AnnotationBuilder();
		typeBuilder=new CompositeMirrorBuilder<JType>(
				new ObjectMirrorBuilder[] {
						classBuilder=new ClassBuilder(),
						typeVariableBuilder=new TypeVariableBuilder()
				}, new TypeBuilder()
			);
		enumBuilder=new EnumBuilder();
		classLoaderBuilder=new ClassLoaderBuilder();
		genericDeclarationBuilder=new GenericDeclarationBuilder();
		annotatedElementBuilder=new AnnotatedElementBuilder();
		packageBuilder=new PackageBuilder();
		accessibleObjectBuilder=new AccessibleObjectBuilder();
		arrayBuilder=new ArrayBuilder();
	}

}