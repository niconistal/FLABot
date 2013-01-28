/**

import org.isistan.flabot.javamodel.CompositeMirrorBuilder;

	private static JDTFactory instance=null;
	
	public static JDTFactory getInstance() {
		if(instance==null)
			instance=new JDTFactory();
		return instance;
	}
	
		objectBuilder=new ObjectBuilder();
		classBuilder=new WorkspaceClassBuilder();
		packageBuilder=new WorkspacePackageBuilder();
		behaviorBuilder=new CompositeMirrorBuilder<JBehavior>(
				new ObjectMirrorBuilder[] {
						methodBuilder=new MethodBuilder(),
						constructorBuilder=new ConstructorBuilder()
				}, new BehaviorBuilder()
			);
		arrayBuilder=new ArrayBuilder();
}