package org.isistan.flabot.executionstatemapping.dialogs;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.messages.Messages;



public class ShowPrologDialog {

	protected Shell sShell = null; // @jve:decl-index=0:visual-constraint="41,12"
	protected Composite compositeMain = null;
	protected Label labelMain = null;
	
	
	private ScrolledComposite scrollPanelCondicion = null;
	
	protected Composite compositeBody  = null;
	protected Button buttonOK = null;
	protected Text itemsTable = null;
	protected String title;
	protected String message;
	
	public ShowPrologDialog(String title,String message)
	{
		this.title=title;
		this.message=message;
		createSShell();
	}
	
	protected void createSShell()
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = true;
		sShell = new Shell(Display.getCurrent(), SWT.CLOSE|SWT.APPLICATION_MODAL|SWT.TITLE);
		sShell.setImage(ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/eclipse32.png").createImage()); //$NON-NLS-1$
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(527, 352));
		sShell.setText(title);
		
		createNameComposite();
		createPanelItems();
		createCompositeButtons();
	}
	
	public void showDialog(String prologText) {
		try {
			itemsTable.setText(prologText);
			
			sShell.setMinimumSize(new Point(400, 300));
			sShell.pack();
			// Centra la pantalla
			Display display = sShell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - sShell.getSize().x / 2;
			int centerY = r.height / 2 - sShell.getSize().y / 2;
			sShell.setLocation(centerX, centerY);
			sShell.open();
			//scrollPanelCondicion.setMinSize(scrollPanelCondicion.computeSize(100,100));
			compositeBody.pack();
			compositeBody.layout();
			while (!sShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
	}

	/**
	 * This method initializes compositeName	
	 *
	 */
	private void createNameComposite() {
		GridData gridData14 = new GridData();
		gridData14.horizontalAlignment = GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		gridData14.verticalAlignment = GridData.CENTER;
		
		GridData gridData111 = new GridData();
		gridData111.horizontalAlignment = GridData.BEGINNING;
		gridData111.grabExcessHorizontalSpace = true;
		
		compositeMain = new Composite(sShell, SWT.NONE);
		compositeMain.setLayout(new GridLayout());
		compositeMain.setLayoutData(gridData14);
		
		labelMain = new Label(compositeMain, SWT.NONE);
		labelMain.setText(message);
		labelMain.setLayoutData(gridData111);		
	}
	
	
	private void createPanelItems() {
		
		GridData gridData14 = new GridData();
		gridData14.horizontalAlignment = GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		gridData14.heightHint=200;
		
		Composite compositeMain = new Composite(sShell, SWT.NONE);
		compositeMain.setLayout(new GridLayout());
		compositeMain.setLayoutData(gridData14);
		
		scrollPanelCondicion = new ScrolledComposite(compositeMain,SWT.BORDER|SWT.V_SCROLL);
		compositeBody =new Composite(scrollPanelCondicion,SWT.NONE);
		scrollPanelCondicion.setContent(compositeBody);
		scrollPanelCondicion.setSize(scrollPanelCondicion.computeSize(200, 100));
		scrollPanelCondicion.setExpandHorizontal(true);
		scrollPanelCondicion.setExpandVertical(true);
		scrollPanelCondicion.setBackground( Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			
		GridData gridData111 = new GridData();
		gridData111.horizontalAlignment = SWT.FILL;
		gridData111.verticalAlignment = SWT.FILL;
		gridData111.grabExcessHorizontalSpace = true;
		gridData111.grabExcessVerticalSpace = true;
		itemsTable=new Text(compositeBody, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.READ_ONLY);
		itemsTable.setLayoutData(gridData111);
		itemsTable.setBackground( Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		compositeBody.setBackground( Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		
		compositeBody.setLayout(new GridLayout());
		scrollPanelCondicion.setLayoutData(gridData111);
		scrollPanelCondicion.setMinSize(scrollPanelCondicion.computeSize(200, 100));
		scrollPanelCondicion.setLayout(new FillLayout());
		compositeBody.setLayoutData(gridData111);;
	}
	
	/**
	 * This method initializes composite1
	 * 
	 */
	private void createCompositeButtons() {
		GridData gridData4 = new GridData();
		gridData4.widthHint = 60;
		GridData gridData3 = new GridData();
		gridData3.widthHint = 60;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.marginHeight = 5;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalIndent = 0;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		Composite compositeButtons = new Composite(sShell, SWT.NONE);
		compositeButtons.setLayoutData(gridData1);
		compositeButtons.setLayout(gridLayout2);
		buttonOK = new Button(compositeButtons, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ShowPrologDialog.okButton")); //$NON-NLS-1$
		buttonOK.setLayoutData(gridData3);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					sShell.dispose();
			}
		});
	}
	
}
