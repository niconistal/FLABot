/** * $Id: ObjectSnapshotTagCreator.java,v 1.2 2006/02/14 02:34:34 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.launcher.trace.objecttag;

import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.launcher.trace.MetadataHandler;import org.isistan.flabot.trace.log.Tag;public interface ObjectSnapshotTagCreator {
	public abstract Tag create(JObject jObject, MetadataHandler metadata);
}
