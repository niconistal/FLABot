/**
 * $Id: ClientViewerLabelProvider.java,v 1.3 2006/03/15 04:10:21 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;


/**
 * @author $Author: dacostae $
 *
 */
public class ClientViewerLabelProvider extends WorkspaceViewerLabelProvider {
	
	public ClientViewerLabelProvider(int flags) {
		super(flags);
	}

	private Object getUndelayingElement(Object element) {
		if(element instanceof Container) {
			element=((Container)element).getUnderlayingObject();
		}
		return element;
	}
	
	@Override
	protected Object getOriginalElement(Object element) {
		element=getUndelayingElement(element);
		return super.getOriginalElement(element);
	}

	@Override
	public String getText(Object element) {
		element=getUndelayingElement(element);
		return super.getText(element);
	}

}