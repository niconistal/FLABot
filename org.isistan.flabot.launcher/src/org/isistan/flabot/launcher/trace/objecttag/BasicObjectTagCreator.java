/**

import java.lang.reflect.Modifier;
	public Tag create(JObject jObject, MetadataHandler metadata) {
		Tag objectTag=TagUtil.createTag();
		objectTag.setProperty(ObjectConstants.ID_PARAMETER, Long.toString(jObject.getId()));
		objectTag.setProperty(ObjectConstants.SYSTEM_HASH_CODE_PARAMETER, systemHashCode);
		addFieldValues(objectTag, jObject, metadata);
	}