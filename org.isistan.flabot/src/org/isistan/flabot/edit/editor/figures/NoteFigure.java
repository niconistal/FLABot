/**
 * $Id: NoteFigure.java,v 1.8 2005/12/23 01:26:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.figures;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

/**
 * NoteFigure
 * -	The figure used for notes
 * 
 *  @author $Author: franco $
 */
public class NoteFigure extends BentCornerFigure implements DirectEditableFigure
{
	public static final Dimension defaultsize = new Dimension(50,30);
	
	/** The inner TextFlow **/
	private TextFlow textFlow;

	/**
	 *  Creates a new StickyNoteFigure with a default MarginBorder size of DEFAULT_CORNER_SIZE
	 *  - 3 and a FlowPage containing a TextFlow with the style WORD_WRAP_SOFT.
	 */
	public NoteFigure() {
		this(BentCornerFigure.DEFAULT_CORNER_SIZE - 3);
	}

	/** 
	 * Creates a new StickyNoteFigure with a MarginBorder that is the given size and a
	 * FlowPage containing a TextFlow with the style WORD_WRAP_SOFT.
	 * 
	 * @param borderSize the size of the MarginBorder
	 */
	public NoteFigure(int borderSize) {
		setSize(defaultsize);
		setBorder(new MarginBorder(borderSize));
		FlowPage flowPage = new FlowPage();

		textFlow = new TextFlow();

		textFlow.setLayoutManager(new ParagraphTextLayout(textFlow,
						ParagraphTextLayout.WORD_WRAP_SOFT));

		flowPage.add(textFlow);

		setLayoutManager(new StackLayout());
		add(flowPage);
		
		setOpaque(true);
	}

	/**
	 * Returns the text inside the TextFlow.
	 * 
	 * @return the text flow inside the text.
	 */
	public String getText() {
		return textFlow.getText();
	}

	public Dimension getMinimumSize(int wHint, int hHint) {
		Rectangle r = textFlow.getBounds();
		return new Dimension(r.width + 20, r.height + 20).union(defaultsize);
	}
	
	/**
	 * Sets the text of the TextFlow to the given value.
	 * 
	 * @param newText the new text value.
	 */
	public void setText(String newText) {
		textFlow.setText(newText);
		textFlow.repaint();
	}
}