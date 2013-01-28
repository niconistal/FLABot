/**
 * $Id: ComponentRoleSelectionDialog.java,v 1.4 2006/03/27 22:46:29 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.dialogs;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToComponentCommand;
import org.isistan.flabot.edit.componenteditor.commands.model.AddResponsibilityToCoreCommand;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.AddComponentCommand;
import org.isistan.flabot.edit.ucmeditor.dialogs.EditComponentDialog;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.SelectionDialog;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * @author $Author: franco $
 *
 */
public class ComponentRoleSelectionDialog extends SelectionDialog<ComponentModel> {
	
	private Shell shell;
	private CoreModel coreModel;
	private CommandStack commandStack;
	
//	private static ComponentRoleSelectionDialog defaultDialog=new ComponentRoleSelectionDialog(
//			new ComponentRoleLabelProvider(),
//			null);
//
//	public static ComponentRoleSelectionDialog getDefault() {
//		return defaultDialog;
//	}

	public ComponentRoleSelectionDialog(Shell parent) {
		super(new ComponentRoleLabelProvider(), null);
		
		this.shell = parent;
		this.commandStack = commandStack;
		this.coreModel = coreModel;
	}
	
	static private class ComponentRoleLabelProvider implements ILabelProvider {		
		
		public ComponentRoleLabelProvider() {
		}

		private Image image=null;
		public Image getImage(Object element) {
			if(image==null) {
				ImageDescriptor descriptor=ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/component.gif"); //$NON-NLS-1$
				image=descriptor.createImage();
			}
			return image;
		}

		public String getText(Object element) {
			ComponentModel component=(ComponentModel)element;
			return component.getName();
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
			UCMDiagram diagram) {
		elements=normalize(elements);
		initialElements=normalize(initialElements);
		
		ExtendedElementListSelectionDialog dialog= new ExtendedElementListSelectionDialog(shell, labelProvider, "Add new Component");
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
			NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			
			AddComponentCommand addCommand = new AddComponentCommand(visual, diagram);
			if (addCommand.canExecute())
				addCommand.execute();
			
			ComponentModel componentModel = (ComponentModel)visual.getSemanticModel();
			
			EditComponentDialog editComponentDialog = new EditComponentDialog(shell, componentModel);
			componentModel = editComponentDialog.open();
			
			if (componentModel != null)
			{
				elements = this.addElementToArray(elements,componentModel);
				return this.openStandardWithAddNew(shell, title, message, elements, initialElements, allowMultiple, diagram);
			}
			else
				addCommand.undo();
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
	public ComponentModel openSingleWithAddNew(
			Shell shell, 
			String title, 
			String message,
			Collection<ComponentModel> elements,
			ComponentModel initialElement,
			UCMDiagram diagram) {
		
		Object[] result=openStandardWithAddNew(shell, title, message, toArray(elements), toArray(initialElement),
				false, diagram);
		if(result==null || result.length==0) {
			return null;
		} else {
			return (ComponentModel) result[0];
		}
	}
	
	private Object[] normalize(Object[] array) {
		if(array==null) {
			return EMPTY_ARRAY;
		} else {
			return array;
		}
	}
	
	private Object[] toArray(ComponentModel element) {
		if(element==null) {
			return null;
		} else {
			return new Object[] {element};
		}
	}
	
	private Object[] toArray(Collection<ComponentModel> collection) {
		if(collection==null) {
			return null;
		} else {
			Object[] array=new Object[collection.size()];
			
			int index=0;
			for (ComponentModel element : collection) {
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