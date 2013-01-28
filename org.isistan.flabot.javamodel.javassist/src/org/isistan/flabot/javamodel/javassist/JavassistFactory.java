/** * $Id: JavassistFactory.java,v 1.3 2006/02/14 04:34:47 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import org.isistan.flabot.javamodel.CompositeMirrorBuilder;import org.isistan.flabot.javamodel.Factory;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class JavassistFactory extends Factory {

	private static JavassistFactory instance=null;
	
	public static JavassistFactory getInstance() {
		if(instance==null)
			instance=new JavassistFactory();
		return instance;
	}
	
	@Override	protected void initialize() {
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
