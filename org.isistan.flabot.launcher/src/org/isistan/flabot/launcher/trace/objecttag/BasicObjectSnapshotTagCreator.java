/**

import java.lang.reflect.Modifier;
	public Tag create(JObject jObject, MetadataHandler metadata) {
		Tag snapShot=TagUtil.createTag();
		snapShot.setProperty(SnapshotConstants.STRING_PARAMETER, objectToString);
		
		return snapShot;
	}