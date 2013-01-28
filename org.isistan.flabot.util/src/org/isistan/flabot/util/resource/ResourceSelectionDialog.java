package org.isistan.flabot.util.resource;


import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceSorter;
import org.isistan.flabot.util.UtilPlugin;
import org.isistan.flabot.util.resource.validator.OkValidator;

/**
 * Utility class to show file selection dialogs
 * @author da Costa Cambio
 */
public class ResourceSelectionDialog {
	private static ResourceSelectionDialog instance=new ResourceSelectionDialog();
	
	public static ResourceSelectionDialog getInstance() {
		return instance;
	}
	
	/**
	 * Shows a dialog for the user to select elements.
	 * @param shell
	 * @param filter
	 * @param validator
	 * @return An array with the user selection, may be a zero lenght array if the
	 * validator allows it, or null if the user cancelled.
	 */ 
	public Object[] open(
			Shell shell,
			String title,
			String message,
			ViewerFilter filter,
			ISelectionStatusValidator validator, boolean allowMultiple) {
		if(validator==null) {
			validator=new OkValidator(UtilPlugin.SYMBOLIC_NAME);
		}
		ILabelProvider lp= new WorkbenchLabelProvider();
		ITreeContentProvider cp= new WorkbenchContentProvider();

		ElementTreeSelectionDialog dialog= new ElementTreeSelectionDialog(shell, lp, cp);
		dialog.setValidator(validator);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.addFilter(filter);
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());	
		dialog.setSorter(new ResourceSorter(ResourceSorter.NAME));
		dialog.setAllowMultiple(allowMultiple);
		
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			return result;
		}	
		return null;
	}
}
