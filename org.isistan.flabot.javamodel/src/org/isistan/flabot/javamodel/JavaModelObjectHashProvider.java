/**

import org.isistan.flabot.javamodel.JObject;
	public int getHashCode(Object object) {
		return ((JObject)object).objectHashCode();
	}
	
	public boolean areEquals(Object object1, Object object2) {
		return ((JObject)object1).objectEquals((JObject)object2);
	}
}