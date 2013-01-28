/**
 * $Id: ComponentFigure.java,v 1.29 2006/04/01 02:44:50 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LabeledContainer;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;


/**
 * ComponentFigure
 * -	The figure used for components in the component diagrams
 * 
 *  @author $Author: franco $
 */
public class ComponentFigure extends org.isistan.flabot.edit.editor.figures.ComponentFigure {
	
	public static final String SHOW_RESPONSIBILITIES_PROPERTY = "Show.Responsibilites"; //$NON-NLS-1$
	public static final Dimension defaultsize = new Dimension(200,60);
	public static final int offset = 35;
	
	private static final Font DEFAULT_FONT = new Font(Display.getCurrent(), "Verdana", 7 , SWT.NONE);	 //$NON-NLS-1$
	private static final int DEFAULT_WIDTH = 90;
			
	private Label buttonLabel = new Label("+"); //$NON-NLS-1$
	
	private LabeledContainer container = new LabeledContainer();	
	private TextFlow textFlow= new TextFlow();	
	private String stereotype = ""; //$NON-NLS-1$
	
	int maxWidth = DEFAULT_WIDTH;
	int totalResp = 0;
	private boolean validClick = false;
	/**
	 * Instantiates an instance of ComponentFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public ComponentFigure(RGB bC, RGB fC, int lS) {
		super(bC, fC, lS);

		addMouseListener( new MouseListener.Stub() {
			/**
			 * MouseListener interface
			 */
			public void mousePressed(MouseEvent me) {
				validClick = getHandleBounds().contains(me.getLocation());
			}			
		});
		
		FlowPage flowPage = new FlowPage();
		textFlow.setLayoutManager(new ParagraphTextLayout(textFlow,
				ParagraphTextLayout.WORD_WRAP_SOFT));
		textFlow.setFont(DEFAULT_FONT);
		flowPage.add(textFlow);		
		container.add(flowPage);		
		container.setLayoutManager(new StackLayout());
		container.setVisible(false);
		container.setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.figures.ComponentFigure.responsibilities")); //$NON-NLS-1$
		container.setFont(DEFAULT_FONT);
		add(container);

		buttonLabel.addMouseListener(new MouseListener.Stub() {
			/**
			 * MouseListener interface
			 */
			public void mousePressed(MouseEvent me) {
				if (container.isVisible())
					firePropertyChange(SHOW_RESPONSIBILITIES_PROPERTY, VisualModel.HIGH_DETAIL, VisualModel.LOW_DETAIL);
				else
					firePropertyChange(SHOW_RESPONSIBILITIES_PROPERTY, VisualModel.LOW_DETAIL, VisualModel.HIGH_DETAIL);
			}			
		});
		buttonLabel.setBorder(new LineBorder());
		buttonLabel.setFont(DEFAULT_FONT);
		add(buttonLabel);
	}
	
	public boolean wasValidClick() {
		return validClick;
	}
	
	/**
	 * Sets the stereotype's name of the component
	 * 
	 * @param text the stereotype's name of the component
	 */
	public void setStereotype(String text) {
		stereotype = new String("{" + text + "}"); //$NON-NLS-1$ //$NON-NLS-2$
		if (stereotype.equals("{}")) //$NON-NLS-1$
			stereotype = ""; //$NON-NLS-1$
		repaint();
	}
	
	/**
	 * Adds a array of names of the responsibilities of the component.
	 * The new bounds of the component are set.
	 * 
	 * @param names the array of names of the responsibilities of the component
	 */
	public void addResponsibilities(String[] names) {				
		maxWidth = DEFAULT_WIDTH;
		totalResp = names.length;
		
		Label l = new Label();
		l.setFont(DEFAULT_FONT);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<names.length; i++) {
			l.setText(names[i]);
			int width = l.getTextBounds().width + 10;
			if (width > maxWidth)
				maxWidth = width;
			sb.append(" - " + names[i] + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		maxWidth += 30;
		textFlow.setText(sb.toString());
		container.setSize(maxWidth, totalResp * 15 + 25);
	}
			
	protected void updateNameBounds() {
		super.updateNameBounds();
		if (container.getSize().width < nameLabel.getBounds().width)
			container.setSize(nameLabel.getBounds().width, container.getSize().height);
		
		if (container.getSize().width > nameLabel.getBounds().width)
			container.setSize(maxWidth, container.getSize().height);
	}
	
	/**
	 * Draw the component figure.
	 */
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);
		
		Rectangle rect = getHandleBounds().getCopy();
		graphics.drawString(stereotype, rect.x + 5, rect.y + 10);
		
		Rectangle roriginal = getBounds().getCopy();
		
		
		Rectangle nameOriginal = nameLabel.getBounds();		
		buttonLabel.setBounds(new Rectangle(nameOriginal.x - 15, nameOriginal.y + 2, 11, 11));
		container.setBounds(new Rectangle(roriginal.x + roriginal.width / 2 - container.getSize().width/ 2 , roriginal.y + 50 , container.getSize().width, container.getSize().height));
	}
	
	/**
	 * @return the minimum dimension of the componet figure
	 */
	public Dimension getMinimumSize(int wHint, int hHint) {	
		Rectangle r = nameLabel.getBounds();
		int height = r.height;
		int width = r.width + 130;
		if (container.isVisible()) {
			height += container.getSize().height + 50;
			int dif = (container.getSize().width + 50) - width;  
			if ( dif > 0)
				width += dif + 30; 			
		}
		return new Dimension(width,height).union(defaultsize);
	}
	
	/**
	 * @param b <code>true</code> if the responsibilites must be shown
	 */
	public void showResponsibilites(boolean b) {
		container.setVisible(b);
		if (container.isVisible())			
			buttonLabel.setText("-"); //$NON-NLS-1$
		else
			buttonLabel.setText("+"); //$NON-NLS-1$
	}		
	
	/**
	 * CloneableShape interface
	 * 
	 * @return a clone of the componet figure
	 */
	public Shape cloneShape() {
		ComponentFigure clone = new ComponentFigure(getBackgroundColor().getRGB()
				, getForegroundColor().getRGB(), getLineStyle());
		clone.setText(nameLabel.getText());
		clone.setSize(getMinimumSize());
		clone.setStereotype(stereotype);
		return clone;
	}
		
	/**
	 * HandleBounds interface
	 * The bounds of the componet are smaller beacuse it contains port and interfaces.
	 * 
	 * @return the handle bounds of the component
	 */
	public Rectangle getHandleBounds() {
		return getBounds().getCropped(new Insets(1,offset,1,offset));
	}
}