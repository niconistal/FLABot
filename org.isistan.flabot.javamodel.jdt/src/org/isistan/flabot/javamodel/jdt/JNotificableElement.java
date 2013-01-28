package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IJavaElement;

interface JNotificableElement {
 
	void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event);
}
