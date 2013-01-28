/**
 * $Id: EditVisualizationTabItem.java,v 1.5 2006/03/28 04:05:15 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.dialogs.editionitem;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.edit.editor.commands.EditVisualizationCommand;
import org.isistan.flabot.edit.editor.figures.CloneableShape;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.EditVisualizationPathCommand;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;

/**
 * @author $Author: franco $
 *
 */
public class EditVisualizationTabItem <T extends GraphicalEditPart> extends EditionTabItemImpl<T> {
	
	public static final int BACKGROUND_COLOR_PROPERTY = 1 << 1;
	public static final int FOREGROUND_COLOR_PROPERTY = 1 << 2;
	public static final int LINE_STYLE_PROPERTY = 1 << 3;
	public static final int LINE_WIDTH_PROPERTY = 1 << 4;
	public static final int SIZE_PROPERTY = 1 << 5;
	public static final int IS_PATH = 1 << 6;
	
	private int style = 0;
	
	private VisualModel visualModel = null;
	private Shape figure = null;
	private Dimension size;
	
	private Composite control;
	private EditionItemStatus status=EditionItemStatus.DEFAULT_OK;
			
	public EditVisualizationTabItem(int style) {
		this.style = style;
	}
		
	public void setFigure(Shape figure) {
		this.figure = figure;
	}
	
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			T editPartElement) {
		GraphicalEditPart editPart = (GraphicalEditPart) editPartElement;		
		visualModel = (VisualModel) editPart.getModel();		
		size = getSize();
		
		if ((style & IS_PATH) == 0)
			figure = ((CloneableShape)editPart.getFigure()).cloneShape();			
		
		control = new Composite(tabFolder, SWT.NONE);
		
		tabItem.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.editionitem.EditVisualizationTabItem.tabName")); //$NON-NLS-1$
				
		GridLayout layout = new GridLayout(1, true);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);		
		control.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));			
		
		Group figureEdition = new Group(control, SWT.NONE);
		figureEdition.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.preview")); //$NON-NLS-1$
		figureEdition.setLayout(new GridLayout(1, false));		
		figureEdition.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		
	    Canvas c = new Canvas(figureEdition, SWT.NULL);	    
	    GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
	    gd.widthHint = figure.getSize().width;
	    c.setLayoutData(gd);	    
	    LightweightSystem l = new LightweightSystem(c);
	    l.setContents(figure);	    	    
	    
	    createControl();
	}
	
	public void activate() {
		
	}
	  
	private Control createControl() {
		Group composite = new Group(control, SWT.NONE);
		composite.setText(Messages.getString("org.isistan.flabot.edit.editor.dialogs.editionitem.EditVisualizationTabItem.propertiesCompositeGroup")); //$NON-NLS-1$
	
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		layout.horizontalSpacing = 12;
		composite.setLayout(layout);		
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

		createComponentGroup(composite);		    
		return composite;
	}
	  
	private void createComponentGroup(Composite composite) {	
		if ((style & BACKGROUND_COLOR_PROPERTY) != 0)
			createBackgroundColorProperty(composite);
	
		if ((style & FOREGROUND_COLOR_PROPERTY) != 0)
			createForegroundColorProperty(composite);
		
		if ((style & LINE_STYLE_PROPERTY) != 0)
			createLineStyleProperty(composite);
		
		if ((style & SIZE_PROPERTY) != 0)
			createSizeProperty(composite);
		
		if ((style & LINE_WIDTH_PROPERTY) != 0)
			createLineWidthProperty(composite);	
	}

	private void createBackgroundColorProperty(Composite composite) {
		Label backColorLabel = new Label(composite, SWT.NONE);
		backColorLabel.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.backgroundColor")); //$NON-NLS-1$
		
		final Label backColorButton = new Label(composite, SWT.BORDER);
		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 25;
		backColorButton.setLayoutData(gd);
		backColorButton.setBackground(figure.getBackgroundColor());
		backColorButton.addListener(SWT.MouseDoubleClick, new Listener() {
				public void handleEvent(Event event) {
					ColorDialog d = new ColorDialog(control.getShell());
					d.setRGB(backColorButton.getBackground().getRGB());		    		
					RGB selectedColor = d.open();
					if (selectedColor != null) {
						Color color = new Color(control.getDisplay(), selectedColor);
						backColorButton.setBackground(color);
						backColorButton.setForeground(color);
						figure.setBackgroundColor(color);
					}
				}
			});
	}
	
	private void createForegroundColorProperty(Composite composite) {
		Label foreColorLabel = new Label(composite, SWT.NONE);
		foreColorLabel.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.lineColor")); //$NON-NLS-1$
			
		final Label foreColorButton = new Label(composite, SWT.BORDER);
		foreColorButton.setText(""); //$NON-NLS-1$
		GridData gd = new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 25;
		foreColorButton.setLayoutData(gd);
		foreColorButton.setBackground(figure.getForegroundColor());
		foreColorButton.addListener(SWT.MouseDoubleClick, new Listener() {
		   	public void handleEvent(Event event) {
		   		ColorDialog d = new ColorDialog(control.getShell());
		   		d.setRGB(foreColorButton.getBackground().getRGB());
		   		RGB selectedColor = d.open();
		   		if (selectedColor != null) {
		   			Color color = new Color(control.getDisplay(), selectedColor);
		   			foreColorButton.setBackground(color);
		   			figure.setForegroundColor(color);
		   		}
		   	}
		 });
	}
	 
	private void createLineStyleProperty(Composite composite) {
		Label lineStyleLabel = new Label(composite, SWT.NONE);
		lineStyleLabel.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.lineStyle")); //$NON-NLS-1$
		lineStyleLabel.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		
		Group lineStyleGroup = new Group(composite, SWT.NONE);
		lineStyleGroup.setLayout(new GridLayout(2, false));
					
		Button solidLineButton = new Button(lineStyleGroup, SWT.RADIO);
		solidLineButton.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.solidLine")); //$NON-NLS-1$
		solidLineButton.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				figure.setLineStyle(Graphics.LINE_SOLID);
			}
		});
			
		Button dashLineButton = new Button(lineStyleGroup, SWT.RADIO);
		dashLineButton.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.dashLine")); //$NON-NLS-1$
		dashLineButton.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				figure.setLineStyle(Graphics.LINE_DASH);
			}
		});
			
		Button dotLineButton = new Button(lineStyleGroup, SWT.RADIO);
		dotLineButton.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.dotLine")); //$NON-NLS-1$
		dotLineButton.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				figure.setLineStyle(Graphics.LINE_DOT);
			}
		});
			
		Button dashDotLineButton = new Button(lineStyleGroup, SWT.RADIO);
		dashDotLineButton.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.dashDotLine")); //$NON-NLS-1$
		dashDotLineButton.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				figure.setLineStyle(Graphics.LINE_DASHDOT);
			}
		});
			
		Button dotDotLineButton = new Button(lineStyleGroup, SWT.RADIO);
		dotDotLineButton.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.dashDotDotLine")); //$NON-NLS-1$
		dotDotLineButton.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				figure.setLineStyle(Graphics.LINE_DASHDOTDOT);
			}
		});
			
		switch(figure.getLineStyle()) {
			case Graphics.LINE_SOLID: solidLineButton.setSelection(true); break;
			case Graphics.LINE_DASH: dashLineButton.setSelection(true); break;
			case Graphics.LINE_DOT: dotLineButton.setSelection(true); break;
			case Graphics.LINE_DASHDOT: dashDotLineButton.setSelection(true); break;
			case Graphics.LINE_DASHDOTDOT: dotDotLineButton.setSelection(true); break;
		}
	}
	
	private void createLineWidthProperty(Composite composite) {
		Label lineWidthLabel = new Label(composite, SWT.NONE);
		lineWidthLabel.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.lineWidth")); //$NON-NLS-1$
			
		final Combo lineWidthCombo = new Combo(composite, SWT.READ_ONLY);
		lineWidthCombo.addSelectionListener( new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int index = lineWidthCombo.getSelectionIndex();
				if (index >= 0) {
					String item = lineWidthCombo.getItem(index);
					figure.setLineWidth(Integer.parseInt(item));
				}
			}
		});
		
		lineWidthCombo.setTextLimit(1);
		lineWidthCombo.add("1"); //$NON-NLS-1$
		lineWidthCombo.add("2"); //$NON-NLS-1$
		lineWidthCombo.add("3"); //$NON-NLS-1$
		lineWidthCombo.add("4"); //$NON-NLS-1$
		lineWidthCombo.add("5"); //$NON-NLS-1$
		
		int width = figure.getLineWidth() - 1;
		if (width < 0 || width > 5)
			width = 0;
		lineWidthCombo.select(width);			
	}
	
	private void createSizeProperty(Composite composite) {
		Label SizeStyleLabel = new Label(composite, SWT.NONE);
		SizeStyleLabel.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.size")); //$NON-NLS-1$
		SizeStyleLabel.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING |
				GridData.FILL_HORIZONTAL));
		
		Group SizeGroup = new Group(composite, SWT.NULL);
		SizeGroup.setLayout(new GridLayout(2, false));
		SizeGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final Label heigth = new Label(SizeGroup, SWT.NULL);
		heigth.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.height")); //$NON-NLS-1$
		    
		size = getSize();
		
		final Spinner spinnerHeigth = new Spinner(SizeGroup, SWT.SINGLE | SWT.BORDER | SWT.LEFT_TO_RIGHT | SWT.READ_ONLY);
		spinnerHeigth.setMinimum(0);
		spinnerHeigth.setMaximum(1000);
		spinnerHeigth.setSelection(size.height);
		spinnerHeigth.setIncrement(1);
		spinnerHeigth.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		spinnerHeigth.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				size.setSize(new Dimension(size.width,spinnerHeigth.getSelection()));
			}
		});
		final Label width = new Label(SizeGroup, SWT.NULL);
		width.setText(Messages.getString("org.isistan.flabot.edit.componenteditor.dialogs.EditVisualizationComponent.width"));	     //$NON-NLS-1$
		final Spinner spinnerWidth = new Spinner(SizeGroup, SWT.SINGLE | SWT.BORDER | SWT.LEFT_TO_RIGHT | SWT.READ_ONLY);
		spinnerWidth.setMinimum(0);
		spinnerWidth.setMaximum(1000);
		spinnerWidth.setSelection(size.width);
		spinnerWidth.setIncrement(1);
		spinnerWidth.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		spinnerWidth.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				size.setSize(new Dimension(spinnerWidth.getSelection(),size.height));
			}
		});
	}
	
	private Dimension getSize() {
		return Util.getDraw2DDimension(visualModel.getSize());
	}
		
	@Override
	public Control getControl() {
		return control;
	}

	public Command getCommand() {		
		Command command = null;
		if ((style & IS_PATH) != 0) {
			command = new EditVisualizationPathCommand((NodeVisualModel)visualModel, 
					figure.getBackgroundColor().getRGB(), figure.getForegroundColor().getRGB(), 
					figure.getLineStyle(), figure.getLineWidth());
			
		} else {
			command = new EditVisualizationCommand(visualModel, 
				figure.getBackgroundColor().getRGB(), figure.getForegroundColor().getRGB(), 
				figure.getLineStyle(), figure.getLineWidth(), 
				size, figure.getMinimumSize());
		}	
		return command;
	}

	public boolean canCreateCommand() {
		EditionItemStatus.Type type=getStatus().getType();
		return type!=EditionItemStatus.Type.ERROR;
	}
	
	public EditionItemStatus getStatus() {
		return status;
	}
	
	public boolean accepts(T element) {
		return true;
	}
}