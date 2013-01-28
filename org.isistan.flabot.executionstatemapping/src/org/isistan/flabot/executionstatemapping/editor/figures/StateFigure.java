package org.isistan.flabot.executionstatemapping.editor.figures;

import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editor.figures.CloneableShape;
import org.isistan.flabot.edit.editor.figures.DirectEditableFigure;

public class StateFigure extends Shape implements HandleBounds, DirectEditableFigure, CloneableShape {

	public static final Dimension defaultsize = new Dimension(100,50);
	
	public static final int offset = 0;
	
	private static final Font NameDefaulFont = new Font(Display.getCurrent(), "Verdana", 9 , SWT.BOLD); //$NON-NLS-1$
	
	protected Label nameLabel = new Label(""); //$NON-NLS-1$
	
	private String name; // workaround for bug 0000613
	
	private boolean validClick = false;
	
	/**
	 * Instantiates an instance of StateFigure
	 * 
	 * @param bC the background color of the component
	 * @param fC the foreground color of the component
	 * @param lS the line style of the component
	 */
	public StateFigure(RGB bC, RGB fC, int lS) {		
		nameLabel.setFont(NameDefaulFont);

		addMouseListener( new MouseListener.Stub() {
			/**
			 * MouseListener interface
			 */
			@Override
			public void mousePressed(MouseEvent me) {
				validClick = getHandleBounds().contains(me.getLocation());
			}			
		});
		
		setBackgroundColor(ColorConstants.white);
		//setBackgroundColor(new Color(Display.getCurrent(), bC));
		setForegroundColor(new Color(Display.getCurrent(), fC));
		setLineStyle(lS);
		
		setCornerDimensions(new Dimension(35,35));
		setLayoutManager(new XYLayout());			
		setOpaque(true);
	}
	
	public boolean wasValidClick() {
		return validClick;
	}
	
	protected Dimension corner = new Dimension(15, 15);
	public void setCornerDimensions(Dimension d) {
		corner.width = d.width;
		corner.height = d.height;
	}
	
	
	/**
	 * DirectEditableFigure interface
	 * 
	 * Sets the name of the component
	 */
	public void setText(String name) {
		this.name = name; // workaround for bug 0000613
		nameLabel.setText(new String(name.trim()));
		updateNameBounds();
		repaint();
	}
	
	protected void updateNameBounds() {
		if (name != null && !name.trim().equals("")) { // workaround for bug 0000613 //$NON-NLS-1$
			Rectangle roriginal = getBounds().getCopy();
			nameLabel.setBounds(new Rectangle(roriginal.x + (roriginal.width / 2) - (nameLabel.getTextBounds().width /2) , roriginal.y + (roriginal.height / 2) - (nameLabel.getTextBounds().height / 2) , nameLabel.getTextBounds().width, nameLabel.getTextBounds().height));
		}
	}
	
	/**
	 * DirectEditableFigure interface
	 * 
	 * @return the name of the component
	 */
	public String getText() {
		return nameLabel.getText();
	}
		
	/**
	 * Draw the component figure.
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		
		Rectangle f = Rectangle.SINGLETON;
		Rectangle r = getBounds();
		f.x = r.x + lineWidth / 2;
		f.y = r.y + lineWidth / 2;
		f.width = r.width - lineWidth;
		f.height = r.height - lineWidth;
		graphics.drawRoundRectangle(f, corner.width, corner.height);
		graphics.fillRoundRectangle(f, corner.width, corner.height);		
		
		Rectangle fshadow = Rectangle.SINGLETON;
		fshadow.x = r.x + lineWidth / 2;
		fshadow.y = r.y + lineWidth / 2;
		fshadow.height = r.height - lineWidth;
		//Shadow
		for(int i=1; i<=3; i++)
		{
			fshadow.width = r.width - lineWidth - i;
			graphics.drawRoundRectangle(fshadow, corner.width, corner.height);
		}
		updateNameBounds();
		
		Font oldFont = graphics.getFont();
		graphics.setFont(NameDefaulFont);		
		graphics.drawText(nameLabel.getText(), nameLabel.getBounds().x, nameLabel.getBounds().y);
		graphics.setFont(oldFont);
	}
	
	@Override
	protected void fillShape(Graphics graphics) {
		//Do nothing
	}
	
	/**
	 * HandleBounds interface
	 * 
	 * @return the handle bounds of the component
	 */	
	public Rectangle getHandleBounds() {
		return getBounds().getCropped(new Insets(0,0,0,0));
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
	public void setBounds(Rectangle r) {
		super.setBounds(r);		
		for (Iterator<Figure> iter= (Iterator<Figure>) getChildren().iterator(); iter.hasNext();) {
			Figure figure = (Figure) iter.next();
			figure.setBounds(figure.getBounds());
		}
	}
	
	/**
	 * CloneableShape interface
	 * 
	 * @return a clone of the componet figure
	 */
	public Shape cloneShape() {
		StateFigure clone = new StateFigure(getBackgroundColor().getRGB()
				, getForegroundColor().getRGB(), getLineStyle());
		clone.setText(nameLabel.getText());
		clone.setSize(getMinimumSize());
		return clone;
	}
	
	@Override
	public boolean containsPoint(int x, int y) {
		//return false;
		return getBounds().contains(x, y);
	}
	
	/**
	 * @return the minimum dimension of the componet figure
	 */
	@Override
	public Dimension getMinimumSize(int wHint, int hHint) {
		Rectangle r = nameLabel.getBounds();		
		return new Dimension(r.width+20, r.height).union(defaultsize);
	}
	
	/**
	 * Port figure do not use local coordinates, this means its
	 * children are not placed relative to this Figure's top-left corner.
	 * 
	 * @return <code>true</code> if this Figure uses local coordinates
	 */
	@Override
	protected boolean useLocalCoordinates(){return false;}
}