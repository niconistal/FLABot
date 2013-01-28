package org.isistan.flabot.util;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.isistan.flabot.util.resource.validator.OkValidator;

/**
 * Utility class to show file selection dialogs
 * @author da Costa Cambio
 */
public class SelectionDialog<T> {
	protected static Object[] EMPTY_ARRAY=new Object[0];
	protected ILabelProvider labelProvider;
	protected ISelectionStatusValidator validator;


	/**
	 * Chreates
	 * @param labelProvider
	 * @param validator
	 */
	public SelectionDialog(
			ILabelProvider labelProvider,
			ISelectionStatusValidator validator) {
		this.labelProvider=labelProvider;
		if(validator==null) {
			validator=new OkValidator(UtilPlugin.SYMBOLIC_NAME);
		}
		this.validator=validator;
		
	}
	
	
	/**
	 * Shows a dialog for the user to select elements.
	 * 
	 * @return An array with the user selection, may be a zero lenght array if the
	 * validator allows it, or null if the user cancelled.
	 */ 
	public Collection<T> openMultiple(
			Shell shell, 
			String title, 
			String message,
			T[] elements,
			T[] initialElements) {
		Object[] result=openStandard(shell, title, message, elements,
				initialElements,
				true);
		return toCollection(result);
	}
	
	/**
	 * Shows a dialog for the user to select elements.
	 * 
	 * @return An array with the user selection, may be a zero lenght array if the
	 * validator allows it, or null if the user cancelled.
	 */ 
	public Collection<T> openMultiple(
			Shell shell, 
			String title, 
			String message,
			Collection<T> elements,
			Collection<T> initialElements) {
		
		Object[] result=openStandard(shell, title, message, toArray(elements),
				toArray(initialElements),
				true);
		return toCollection(result);
	}
	
	/**
	 * Shows a dialog for the user to select one element.
	 * 
	 * @return The element selected, or null if the user cancelled.
	 */ 
	public T openSingle(
			Shell shell, 
			String title, 
			String message,
			Collection<T> elements,
			T initialElement) {
		
		Object[] result=openStandard(shell, title, message, toArray(elements), toArray(initialElement),
				false);
		if(result==null || result.length==0) {
			return null;
		} else {
			return (T) result[0];
		}
	}
	
	/**
	 * Shows a dialog for the user to select one element.
	 * 
	 * @return The element selected, or null if the user cancelled.
	 */ 
	public T openSingle(
			Shell shell, 
			String title, 
			String message,
			T[] elements,
			T initialElement) {
		Object[] result=openStandard(shell, title, message, elements, toArray(initialElement),
				false);
		if(result==null || result.length==0) {
			return null;
		} else {
			return (T) result[0];
		}
	}
	
	
	/**
	 * Shows a checkbox dialog for the user to select elements.
	 * 
	 * @return An array with the user selection, may be a zero lenght array if the
	 * validator allows it, or null if the user cancelled.
	 */ 
	public Collection<T> openCheckboxes(
			Shell shell, 
			String title, 
			String message,
			Collection<T> elements,
			Collection<T> initialElements) {
		
		Object[] result=openCheckboxesInternal(shell, title, message, toArray(elements),
				toArray(initialElements));
		return toCollection(result);

	}
	/**
	 * Shows a checkbox dialog for the user to select elements.
	 * 
	 * @return An array with the user selection, may be a zero lenght array if the
	 * validator allows it, or null if the user cancelled.
	 */ 
	public Collection<T> openCheckboxes(
			Shell shell, 
			String title, 
			String message,
			T[] elements,
			T[] initialElements) {
		Object[] result=openCheckboxesInternal(shell, title, message, elements,
				initialElements);
		return toCollection(result);
	}
	
	private Object[] openCheckboxesInternal(
			Shell shell, 
			String title, 
			String message,
			Object[] elements,
			Object[] initialElements) {
		elements=normalize(elements);
		initialElements=normalize(initialElements);

		ListSelectionDialog dialog= new ListSelectionDialog(shell, elements,
				new ArrayContentProvider(elements), labelProvider, message);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setInitialSelections(initialElements);
		
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			IStatus status=validator.validate(result);
			while(!status.isOK()) {
				MessageDialog.openError(shell, title, status.getMessage());
				dialog.setInitialSelections(result);
				result = dialog.getResult();
				status=validator.validate(result);
				
			}
			return result;
		}	
		return null;
	}
	
	private Object[] openStandard(
			Shell shell, 
			String title, 
			String message,
			Object[] elements,
			Object[] initialElements,
			boolean allowMultiple) {
		elements=normalize(elements);
		initialElements=normalize(initialElements);
		
		ElementListSelectionDialog dialog= new ElementListSelectionDialog(shell, labelProvider);
		dialog.setValidator(validator);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setElements(elements);
		dialog.setInitialSelections(initialElements);
		dialog.setMultipleSelection(allowMultiple);
		
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			return result;
		}	
		return null;
	}

	private Collection<T> toCollection(Object[] array) {
		if(array==null) {
			return null;
		} else {
			Collection<T> collection=new ArrayList<T>(array.length);
			for (Object element : array) {
				collection.add((T) element);
			}
			return collection;
		}
	}
	
	
	private Object[] toArray(T element) {
		if(element==null) {
			return null;
		} else {
			return new Object[] {element};
		}
	}
	private Object[] toArray(Collection<T> collection) {
		if(collection==null) {
			return null;
		} else {
			Object[] array=new Object[collection.size()];
			
			int index=0;
			for (T element : collection) {
				array[index++]=element;
			}
			return array;
		}
	}
	
	private Object[] normalize(Object[] array) {
		if(array==null) {
			return EMPTY_ARRAY;
		} else {
			return array;
		}
	}
	private class ArrayContentProvider implements IStructuredContentProvider {

		private Object[] elements;

		public ArrayContentProvider(Object[] elements) {
			this.elements=elements;
		}
		public Object[] getElements(Object inputElement) {
			if(inputElement==elements) {
				return elements;
			} else {
				return EMPTY_ARRAY;
			}
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
		
	}
}
