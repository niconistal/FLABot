package org.isistan.flabot.edit.editor.dialogs;

import java.awt.Component;
import java.util.Collection;
import java.util.Vector;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToComponentCommand;
import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToCoreCommand;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SelectionDialog;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * Shows a dialog for the user to select a responsibility
 * 
 * @author $Author: franco $
 *
 */
public class ResponsibilitySelectionDialog extends SelectionDialog<Responsibility> {
	
	//private static Object[] EMPTY_ARRAY=new Object[0];
	
	private Shell shell;
	private CoreModel coreModel;
	private CommandStack commandStack;
	
//	private static ResponsibilitySelectionDialog defaultDialog=new ResponsibilitySelectionDialog(
//			new ResponsibilityLabelProvider(),
//			null);
//
//	public static ResponsibilitySelectionDialog getDefault() {
//		return defaultDialog;
//	}

	public ResponsibilitySelectionDialog(Shell parent, CommandStack commandStack, CoreModel coreModel) {
		super(new ResponsibilityLabelProvider(), null);
		this.shell = parent;
		this.commandStack = commandStack;
		this.coreModel = coreModel;
		//elementListDialog = new ExtendedElementListSelectionDialog(parent, renderer)
	}
	
	static private class ResponsibilityLabelProvider implements ILabelProvider {		
		public ResponsibilityLabelProvider() {
		}

		private Image image=null;
		public Image getImage(Object element) {
			if(image==null) {
				ImageDescriptor descriptor=ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/responsibility.gif"); //$NON-NLS-1$
				image=descriptor.createImage();
			}
			return image;
		}

		public String getText(Object element) {
			Responsibility responsibility=(Responsibility)element;
			if(responsibility.getDescription().trim().length()==0) {
				return responsibility.getName();
			}else {
				return responsibility.getName() + " - " + responsibility.getDescription(); //$NON-NLS-1$
			}
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
	
	private Object[] openStandardWithAddNew(
			Shell shell, 
			String title, 
			String message,
			Object[] elements,
			Object[] initialElements,
			boolean allowMultiple,
			ComponentModel componentModel) {
		elements=normalize(elements);
		initialElements=normalize(initialElements);
		
		ExtendedElementListSelectionDialog dialog= new ExtendedElementListSelectionDialog(shell, labelProvider, "Add new Responsibility");
		dialog.setValidator(validator);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setElements(elements);
		dialog.setInitialSelections(initialElements);
		dialog.setMultipleSelection(allowMultiple);
		
		int sel = dialog.open();
		if (sel == Window.OK) {
			Object[] result = dialog.getResult();
			return result;
		}
		else if (sel == ExtendedElementListSelectionDialog.ADD_NEW_RETURN_CODE)
		{
			StandardEditionDialog<Responsibility> f=getEditionDialog();
			
			Responsibility resp=CoremodelFactory.eINSTANCE.createResponsibility();
			Command addCommand=new AddResponsibilityToCoreCommand(coreModel, resp);
			commandStack.execute(addCommand);
			
			Command editCommand=f.open(resp);
			if (editCommand == null) {
				commandStack.undo();
			} else {
				editCommand.execute();
				if (componentModel != null)
				{
					AddResponsibilityToComponentCommand addToComponent = new AddResponsibilityToComponentCommand(componentModel, resp);
					addToComponent.execute();
				}
				
				elements = this.addElementToArray(elements, resp);
				
				return this.openStandardWithAddNew(shell, title, message, elements, initialElements, allowMultiple, componentModel);
			}
		}
		return null;
	}
	
	private StandardEditionDialog<Responsibility> getEditionDialog() {

		StandardEditionDialog<Responsibility> f =
			new StandardEditionDialog<Responsibility>(
					shell,
					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditResponsibilityDialog.title"),//$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.ResponsibilitiesDialog.commandName"), //$NON-NLS-1$
					ResponsibilityEditionItem.LOADER.getEditionItems(
							new LoggerMessageAccumulator()));
		return f;
	}
	
	/**
	 * Shows a dialog for the user to select one element.
	 * 
	 * @return The element selected, or null if the user cancelled.
	 */ 
	public Responsibility openSingleWithAddNew(
			Shell shell, 
			String title, 
			String message,
			Collection<Responsibility> elements,
			Responsibility initialElement,
			ComponentModel componentModel) {
		
		Object[] result=openStandardWithAddNew(shell, title, message, toArray(elements), toArray(initialElement),
				false, componentModel);
		if(result==null || result.length==0) {
			return null;
		} else {
			return (Responsibility) result[0];
		}
	}
	
	private Object[] normalize(Object[] array) {
		if(array==null) {
			return EMPTY_ARRAY;
		} else {
			return array;
		}
	}
	
	private Object[] toArray(Responsibility element) {
		if(element==null) {
			return null;
		} else {
			return new Object[] {element};
		}
	}
	
	private Object[] toArray(Collection<Responsibility> collection) {
		if(collection==null) {
			return null;
		} else {
			Object[] array=new Object[collection.size()];
			
			int index=0;
			for (Responsibility element : collection) {
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
