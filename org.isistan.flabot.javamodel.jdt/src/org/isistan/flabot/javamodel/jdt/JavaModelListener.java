package org.isistan.flabot.javamodel.jdt;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaCore;

class JavaModelListener {
	private static JavaModelListener instance=new JavaModelListener();
	
	private static class InterestedInfo {
		private WeakReference<JNotificableElement> interested;
		private int flag;
		private int eventFlags;
		
		public InterestedInfo(JNotificableElement interested, int flag, int eventFlags) {
			this.interested=new WeakReference<JNotificableElement>(interested);
			this.flag=flag;
			this.eventFlags=eventFlags;
		}
	}
	
	
	private Map<IJavaElement, List<InterestedInfo>> interested=new HashMap<IJavaElement, List<InterestedInfo>>();
	
	private JavaModelListener() {
		JavaCore.addElementChangedListener(new ElementChangedListener());
		
	}
	
	public static JavaModelListener getInstance() {
		return instance;
	}
	
	public void add(JNotificableElement interested, int flag, IJavaElement javaElement, int eventFlags) {
		List<InterestedInfo> list = this.interested.get(javaElement);
		if(list==null) {
			list=new LinkedList<InterestedInfo>();
			this.interested.put(javaElement, list);
		}
		list.add(new InterestedInfo(interested, flag, eventFlags));
	}
	
	public void add(JNotificableElement interested, int flag, IJavaElement[] javaElements, int eventFlags) {
		for (IJavaElement javaElement : javaElements) {
			this.add(interested, flag, javaElement, eventFlags);
		}
	}

	public void add(JNotificableElement interested, int flag, int eventFlags) {
		add(interested, flag, (IJavaElement)null, eventFlags);
	}
	
	private class ElementChangedListener implements IElementChangedListener {
		public void elementChanged(ElementChangedEvent event) {
			List<InterestedInfo> list=JavaModelListener.this.interested.get(event.getDelta().getElement());
			IJavaElement javaElement=event.getDelta().getElement();
			int eventFlags=event.getDelta().getFlags();
			if(list!=null) {
				notify(event, list, javaElement, eventFlags);
			}
			list=JavaModelListener.this.interested.get(null);
			if(list!=null) {
				notify(event, list, javaElement, eventFlags);
			}

		}
		private void notify(ElementChangedEvent event, List<InterestedInfo> list, IJavaElement javaElement, int eventFlags) {
			for (Iterator<InterestedInfo> iter = list.iterator(); iter.hasNext();) {
				InterestedInfo interestedInfo = iter.next();
				JNotificableElement notificableElement=interestedInfo.interested.get();
				if(notificableElement==null) {
					iter.remove();
				} else {
					if((interestedInfo.eventFlags | eventFlags)!=0) {
						notificableElement.changed(interestedInfo.flag, javaElement, eventFlags, event);
					}
				}
				
			}
		}

	}
	

}
