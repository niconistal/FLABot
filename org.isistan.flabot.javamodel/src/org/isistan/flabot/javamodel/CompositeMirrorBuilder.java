/** * $Id: CompositeMirrorBuilder.java,v 1.2 2006/02/14 04:34:54 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


public class CompositeMirrorBuilder<T extends JObject> implements ObjectMirrorBuilder<T> {
	private ObjectMirrorBuilder<? extends T>[] mirrorBuilders;
	private ObjectMirrorBuilder<? extends T> generalMirrorBuilder;

	public CompositeMirrorBuilder(ObjectMirrorBuilder<? extends T>[] mirrorBuilders, ObjectMirrorBuilder<? extends T> generalMirrorBuilder) {
		this.mirrorBuilders=mirrorBuilders;		
		this.generalMirrorBuilder=generalMirrorBuilder;
	}
	

	public boolean accepts(Object object) {
		return generalMirrorBuilder.accepts(object);
	}
	
	public T build(Object object) {
		for(ObjectMirrorBuilder<? extends T> mirrorBuilder: mirrorBuilders) {
			if(mirrorBuilder.accepts(object)) {
				return mirrorBuilder.build(object);
			}
		}
		return generalMirrorBuilder.build(object);
	}



}
