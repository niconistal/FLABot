package org.isistan.flabot.edit.ucmeditor.dialogs;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.editor.dialogs.ExtendedElementListSelectionDialog;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SelectionDialog;

public class ConditionedStubSelectionDialog  extends SelectionDialog<ConditionedStub> {
	
	//private static Object[] EMPTY_ARRAY=new Object[0];
	
	private Shell shell;
	private CoreModel coreModel;
	
//	private static ResponsibilitySelectionDialog defaultDialog=new ResponsibilitySelectionDialog(
//			new ResponsibilityLabelProvider(),
//			null);
//
//	public static ResponsibilitySelectionDialog getDefault() {
//		return defaultDialog;
//	}

	public ConditionedStubSelectionDialog() {
		super(new ConditionedStubLabelProvider(), null);
//		this.shell = parent;
//		this.coreModel = coreModel;
		//elementListDialog = new ExtendedElementListSelectionDialog(parent, renderer)
	}
	
	static private class ConditionedStubLabelProvider implements ILabelProvider {		
		public ConditionedStubLabelProvider() {
		}

		private Image image=null;
		public Image getImage(Object element) {
			if(image==null) {
				ImageDescriptor descriptor=ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/stub.gif"); //$NON-NLS-1$
				image=descriptor.createImage();
			}
			return image;
		}

		public String getText(Object element) {
			ConditionedStub conditionedStub =(ConditionedStub)element;
			return conditionedStub.getName() + ", " + 
				Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.StartNode") + ": " + conditionedStub.getStub().getStartPointReference().getName() 
				+ ", " + Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.DynamicStubManagerDialog.EndNode") + ": " + conditionedStub.getStub().getEndPointReference().getName();
		}

		public void addListener(ILabelProviderListener listener) {
			
		}

		public void dispose() {
			
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			
		}
		
	}
	
//	private StandardEditionDialog<ConditionedStub> getEditionDialog() {
//
//		StandardEditionDialog<ConditionedStub> f =
//			new StandardEditionDialog<ConditionedStub>(
//					shell,
//					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.title"),//$NON-NLS-1$
//					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilitiesDialog.commandName"), //$NON-NLS-1$
//					ResponsibilityEditionItem.LOADER.getEditionItems(
//							new LoggerMessageAccumulator()));
//		return f;
//	}
	
//	/**
//	 * Shows a dialog for the user to select one element.
//	 * 
//	 * @return The element selected, or null if the user cancelled.
//	 */ 
//	public Responsibility openSingleWithAddNew(
//			Shell shell, 
//			String title, 
//			String message,
//			Collection<Responsibility> elements,
//			Responsibility initialElement,
//			ComponentModel componentModel) {
//		
//		Object[] result=openStandardWithAddNew(shell, title, message, toArray(elements), toArray(initialElement),
//				false, componentModel);
//		if(result==null || result.length==0) {
//			return null;
//		} else {
//			return (Responsibility) result[0];
//		}
//	}
	
	private Object[] normalize(Object[] array) {
		if(array==null) {
			return EMPTY_ARRAY;
		} else {
			return array;
		}
	}
	
	private Object[] toArray(ConditionedStub element) {
		if(element==null) {
			return null;
		} else {
			return new Object[] {element};
		}
	}
	
	private Object[] toArray(Collection<ConditionedStub> collection) {
		if(collection==null) {
			return null;
		} else {
			Object[] array=new Object[collection.size()];
			
			int index=0;
			for (ConditionedStub element : collection) {
				array[index++]=element;
			}
			return array;
		}
	}
	
	private Object[] addElementToArray(Object[] elements, Object object){
		Vector vectorElements = new Vector();
		for (int i=0; i < elements.length; i++)
		{
			vectorElements.add(elements[i]);
		}
		vectorElements.add(object);
		return vectorElements.toArray();
	}
}
