/**

import org.isistan.flabot.javamodel.ArrayMirrorBuilder;

	public boolean accepts(Object object) {
		return object instanceof Object[];
	}

	public <T extends JObject> JArray<T> build(Object object, ObjectMirrorBuilder<T> componentBuilder) {
		return new ArrayImpl<T>((Object[])object, componentBuilder);
	}
}