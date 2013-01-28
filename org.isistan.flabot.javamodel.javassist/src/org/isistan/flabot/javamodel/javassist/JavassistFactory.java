/**

import org.isistan.flabot.javamodel.CompositeMirrorBuilder;

	private static JavassistFactory instance=null;
	
	public static JavassistFactory getInstance() {
		if(instance==null)
			instance=new JavassistFactory();
		return instance;
	}
	
	@Override
		objectBuilder=new ObjectBuilder();
		memberBuilder=new CompositeMirrorBuilder<JMember>(
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
		classBuilder=new ClassBuilder();
		packageBuilder=new PackageBuilder();
		arrayBuilder=new ArrayBuilder();
	}
}