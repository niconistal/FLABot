package org.isistan.flabot.edit.editor.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class ExtendedElementListSelectionDialog extends ElementListSelectionDialog{

	private int returnCode;
	public static final int ADD_NEW_RETURN_CODE = Window.CANCEL + 1;
	private String addNewText;
	
	/**
     * Creates an extended list selection dialog.
     * @param parent   the parent widget.
     * @param renderer the label renderer.
     */
    public ExtendedElementListSelectionDialog(Shell parent, ILabelProvider renderer, String addNewText) {
        super(parent, renderer);
        this.addNewText = addNewText;
    }
    
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
    	super.createButtonsForButtonBar(parent);
    	Button addNewButton = createButton(parent, IDialogConstants.OPEN_ID,
				addNewText, false);
    	addNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				returnCode = ExtendedElementListSelectionDialog.ADD_NEW_RETURN_CODE;
				ExtendedElementListSelectionDialog.this.close();
			}
		});
	}
    
    /**
	 * Returns the "Add new" button.
	 * 
	 * @return the Add New button or <code>null</code> if the button is not created
	 *         yet.
	 */
	public Button getAddNewButton() {
		return getButton(IDialogConstants.OPEN_ID);
	}
	
	/**
	 * Returns this window's return code. A window's return codes are
	 * window-specific, although two standard return codes are predefined:
	 * <code>OK</code> and <code>CANCEL</code>.
	 * 
	 * @return the return code
	 */
	@Override
	public int getReturnCode() {
		if (this.returnCode >= 0)
			return returnCode;
		else
			return super.getReturnCode();
	}
}
