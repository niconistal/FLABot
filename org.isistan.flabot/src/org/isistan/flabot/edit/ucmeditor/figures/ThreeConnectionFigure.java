/**
 * $Id: ThreeConnectionFigure.java,v 1.10 2006/03/21 02:34:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import java.util.Hashtable;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.edit.editor.figures.FixedConnectionAnchor;

/**
 * ThreeConnectionFigure
 * -	Used as a common class for fork and joins.
 * 
 * @author $Author: franco $
 *
 */
public abstract class ThreeConnectionFigure extends ResponsibilityNodeFigure  {

	public static final String LEFT = "Left"; //$NON-NLS-1$
	public static final String RIGHT = "Right"; //$NON-NLS-1$
	public static final String UP = "Up"; //$NON-NLS-1$
	public static final String DOWN = "Down"; //$NON-NLS-1$
		
	public static final String TERMINAL_LEFT1 = "Terminal.Left1"; //$NON-NLS-1$
	public static final String TERMINAL_LEFT2 = "Terminal.Left2"; //$NON-NLS-1$
	public static final String TERMINAL_LEFT3 = "Terminal.Left3"; //$NON-NLS-1$
	public static final String TERMINAL_LEFT4 = "Terminal.Left4"; //$NON-NLS-1$
	public static final String TERMINAL_LEFT5 = "Terminal.Left5"; //$NON-NLS-1$
	public static final String TERMINAL_RIGHT = "Terminal.Right"; //$NON-NLS-1$
	public static final String TERMINAL = "Terminal"; //$NON-NLS-1$
		
	public static Hashtable anchors = new Hashtable();
	public static Hashtable anchorsThreeOutputs = new Hashtable();
	public static Hashtable anchorsFourOutputs = new Hashtable();
	public static Hashtable anchorsFiveOutputs = new Hashtable();
	
	public static Hashtable allAnchors = new Hashtable();
		
	static {	
		//Anchors for two outputs node
		Figure f = new Figure();
		f.setSize(20,40);
		Hashtable left = new Hashtable();
		FixedConnectionAnchor rightAnchor = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left1Anchor = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left2Anchor = new FixedConnectionAnchor(f);
		FixedConnectionAnchor anchor = new FixedConnectionAnchor(f);
		rightAnchor.setOffsetH(20);
		rightAnchor.setOffsetV(20);
		left1Anchor.setOffsetH(0);
		left1Anchor.setOffsetV(10);			
		left2Anchor.setOffsetH(0);
		left2Anchor.setOffsetV(30);
		anchor.setOffsetH(10);
		anchor.setOffsetV(20);
		left.put(TERMINAL_RIGHT, rightAnchor);
		left.put(TERMINAL_LEFT1, left1Anchor);
		left.put(TERMINAL_LEFT2, left2Anchor);
		left.put(TERMINAL, anchor);
		anchors.put(LEFT, left);
		
		f = new Figure();
		f.setSize(20,40);
		Hashtable right = new Hashtable();
		rightAnchor = new FixedConnectionAnchor(f);
		left1Anchor = new FixedConnectionAnchor(f);
		left2Anchor = new FixedConnectionAnchor(f);
		anchor = new FixedConnectionAnchor(f);
		rightAnchor.setOffsetH(0);
		rightAnchor.setOffsetV(20);
		left1Anchor.setOffsetH(20);
		left1Anchor.setOffsetV(10);			
		left2Anchor.setOffsetH(20);
		left2Anchor.setOffsetV(30);
		anchor.setOffsetH(10);
		anchor.setOffsetV(20);
		right.put(TERMINAL_RIGHT, rightAnchor);
		right.put(TERMINAL_LEFT1, left1Anchor);
		right.put(TERMINAL_LEFT2, left2Anchor);
		right.put(TERMINAL, anchor);
		anchors.put("", right); //$NON-NLS-1$
		anchors.put(RIGHT, right);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable up = new Hashtable();
		rightAnchor = new FixedConnectionAnchor(f);
		left1Anchor = new FixedConnectionAnchor(f);
		left2Anchor = new FixedConnectionAnchor(f);
		anchor = new FixedConnectionAnchor(f);
		rightAnchor.setOffsetH(20);
		rightAnchor.setOffsetV(20);
		left1Anchor.setOffsetH(10);
		left1Anchor.setOffsetV(0);			
		left2Anchor.setOffsetH(30);
		left2Anchor.setOffsetV(0);
		anchor.setOffsetH(20);
		anchor.setOffsetV(10);
		up.put(TERMINAL_RIGHT, rightAnchor);
		up.put(TERMINAL_LEFT1, left1Anchor);
		up.put(TERMINAL_LEFT2, left2Anchor);
		up.put(TERMINAL, anchor);
		anchors.put(UP, up);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable down = new Hashtable();
		rightAnchor = new FixedConnectionAnchor(f);
		left1Anchor = new FixedConnectionAnchor(f);
		left2Anchor = new FixedConnectionAnchor(f);
		anchor = new FixedConnectionAnchor(f);
		rightAnchor.setOffsetH(20);
		rightAnchor.setOffsetV(0);
		left1Anchor.setOffsetH(10);
		left1Anchor.setOffsetV(20);			
		left2Anchor.setOffsetH(30);
		left2Anchor.setOffsetV(20);
		anchor.setOffsetH(20);
		anchor.setOffsetV(10);
		down.put(TERMINAL_RIGHT, rightAnchor);
		down.put(TERMINAL_LEFT1, left1Anchor);
		down.put(TERMINAL_LEFT2, left2Anchor);
		down.put(TERMINAL, anchor);
		anchors.put(DOWN, down);
		
		//Anchors for three outputs node
		f = new Figure();
		f.setSize(20,40);
		Hashtable leftThreeOutputs = new Hashtable();
		FixedConnectionAnchor rightAnchorThreeOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left1AnchorThreeOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left2AnchorThreeOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left3AnchorThreeOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor anchorThreeOutputs = new FixedConnectionAnchor(f);
		rightAnchorThreeOutputs.setOffsetH(20);
		rightAnchorThreeOutputs.setOffsetV(20);
		left1AnchorThreeOutputs.setOffsetH(0);
		left1AnchorThreeOutputs.setOffsetV(10);			
		left2AnchorThreeOutputs.setOffsetH(0);
		left2AnchorThreeOutputs.setOffsetV(20);
		left3AnchorThreeOutputs.setOffsetH(0);
		left3AnchorThreeOutputs.setOffsetV(30);
		anchorThreeOutputs.setOffsetH(10);
		anchorThreeOutputs.setOffsetV(20);
		leftThreeOutputs.put(TERMINAL_RIGHT, rightAnchorThreeOutputs);
		leftThreeOutputs.put(TERMINAL_LEFT1, left1AnchorThreeOutputs);
		leftThreeOutputs.put(TERMINAL_LEFT2, left2AnchorThreeOutputs);
		leftThreeOutputs.put(TERMINAL_LEFT3, left3AnchorThreeOutputs);
		leftThreeOutputs.put(TERMINAL, anchorThreeOutputs);
		anchorsThreeOutputs.put(LEFT, leftThreeOutputs);
		
		f = new Figure();
		f.setSize(20,40);
		Hashtable rightThreeOutputs = new Hashtable();
		rightAnchorThreeOutputs = new FixedConnectionAnchor(f);
		left1AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left2AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left3AnchorThreeOutputs = new FixedConnectionAnchor(f);
		anchorThreeOutputs = new FixedConnectionAnchor(f);
		rightAnchorThreeOutputs.setOffsetH(0);
		rightAnchorThreeOutputs.setOffsetV(20);
		left1AnchorThreeOutputs.setOffsetH(20);
		left1AnchorThreeOutputs.setOffsetV(10);			
		left2AnchorThreeOutputs.setOffsetH(20);
		left2AnchorThreeOutputs.setOffsetV(20);
		left3AnchorThreeOutputs.setOffsetH(20);
		left3AnchorThreeOutputs.setOffsetV(30);
		anchorThreeOutputs.setOffsetH(10);
		anchorThreeOutputs.setOffsetV(20);
		rightThreeOutputs.put(TERMINAL_RIGHT, rightAnchorThreeOutputs);
		rightThreeOutputs.put(TERMINAL_LEFT1, left1AnchorThreeOutputs);
		rightThreeOutputs.put(TERMINAL_LEFT2, left2AnchorThreeOutputs);
		rightThreeOutputs.put(TERMINAL_LEFT3, left3AnchorThreeOutputs);
		rightThreeOutputs.put(TERMINAL, anchorThreeOutputs);
		anchorsThreeOutputs.put("", rightThreeOutputs); //$NON-NLS-1$
		anchorsThreeOutputs.put(RIGHT, rightThreeOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable upThreeOutputs = new Hashtable();
		rightAnchorThreeOutputs = new FixedConnectionAnchor(f);
		left1AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left2AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left3AnchorThreeOutputs = new FixedConnectionAnchor(f);
		anchorThreeOutputs = new FixedConnectionAnchor(f);
		rightAnchorThreeOutputs.setOffsetH(20);
		rightAnchorThreeOutputs.setOffsetV(20);
		left1AnchorThreeOutputs.setOffsetH(10);
		left1AnchorThreeOutputs.setOffsetV(0);			
		left2AnchorThreeOutputs.setOffsetH(20);
		left2AnchorThreeOutputs.setOffsetV(0);
		left3AnchorThreeOutputs.setOffsetH(30);
		left3AnchorThreeOutputs.setOffsetV(0);
		anchorThreeOutputs.setOffsetH(20);
		anchorThreeOutputs.setOffsetV(10);
		upThreeOutputs.put(TERMINAL_RIGHT, rightAnchorThreeOutputs);
		upThreeOutputs.put(TERMINAL_LEFT1, left1AnchorThreeOutputs);
		upThreeOutputs.put(TERMINAL_LEFT2, left2AnchorThreeOutputs);
		upThreeOutputs.put(TERMINAL_LEFT3, left3AnchorThreeOutputs);
		upThreeOutputs.put(TERMINAL, anchorThreeOutputs);
		anchorsThreeOutputs.put(UP, upThreeOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable downThreeOutputs = new Hashtable();
		rightAnchorThreeOutputs = new FixedConnectionAnchor(f);
		left1AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left2AnchorThreeOutputs = new FixedConnectionAnchor(f);
		left3AnchorThreeOutputs = new FixedConnectionAnchor(f);
		anchorThreeOutputs = new FixedConnectionAnchor(f);
		rightAnchorThreeOutputs.setOffsetH(20);
		rightAnchorThreeOutputs.setOffsetV(0);
		left1AnchorThreeOutputs.setOffsetH(10);
		left1AnchorThreeOutputs.setOffsetV(20);			
		left2AnchorThreeOutputs.setOffsetH(20);
		left2AnchorThreeOutputs.setOffsetV(20);
		left3AnchorThreeOutputs.setOffsetH(30);
		left3AnchorThreeOutputs.setOffsetV(20);
		anchorThreeOutputs.setOffsetH(20);
		anchorThreeOutputs.setOffsetV(10);
		downThreeOutputs.put(TERMINAL_RIGHT, rightAnchorThreeOutputs);
		downThreeOutputs.put(TERMINAL_LEFT1, left1AnchorThreeOutputs);
		downThreeOutputs.put(TERMINAL_LEFT2, left2AnchorThreeOutputs);
		downThreeOutputs.put(TERMINAL_LEFT3, left3AnchorThreeOutputs);
		downThreeOutputs.put(TERMINAL, anchorThreeOutputs);
		anchorsThreeOutputs.put(DOWN, downThreeOutputs);
		
		//Anchors for four outputs node
		f = new Figure();
		f.setSize(20,40);
		Hashtable leftFourOutputs = new Hashtable();
		FixedConnectionAnchor rightAnchorFourOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left1AnchorFourOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left2AnchorFourOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left3AnchorFourOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left4AnchorFourOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor anchorFourOutputs = new FixedConnectionAnchor(f);
		rightAnchorFourOutputs.setOffsetH(20);
		rightAnchorFourOutputs.setOffsetV(20);
		left1AnchorFourOutputs.setOffsetH(0);
		left1AnchorFourOutputs.setOffsetV(5);			
		left2AnchorFourOutputs.setOffsetH(0);
		left2AnchorFourOutputs.setOffsetV(15);
		left3AnchorFourOutputs.setOffsetH(0);
		left3AnchorFourOutputs.setOffsetV(25);
		left4AnchorFourOutputs.setOffsetH(0);
		left4AnchorFourOutputs.setOffsetV(35);
		anchorFourOutputs.setOffsetH(10);
		anchorFourOutputs.setOffsetV(20);
		leftFourOutputs.put(TERMINAL_RIGHT, rightAnchorFourOutputs);
		leftFourOutputs.put(TERMINAL_LEFT1, left1AnchorFourOutputs);
		leftFourOutputs.put(TERMINAL_LEFT2, left2AnchorFourOutputs);
		leftFourOutputs.put(TERMINAL_LEFT3, left3AnchorFourOutputs);
		leftFourOutputs.put(TERMINAL_LEFT4, left4AnchorFourOutputs);
		leftFourOutputs.put(TERMINAL, anchorFourOutputs);
		anchorsFourOutputs.put(LEFT, leftFourOutputs);
		
		f = new Figure();
		f.setSize(20,40);
		Hashtable rightFourOutputs = new Hashtable();
		rightAnchorFourOutputs = new FixedConnectionAnchor(f);
		left1AnchorFourOutputs = new FixedConnectionAnchor(f);
		left2AnchorFourOutputs = new FixedConnectionAnchor(f);
		left3AnchorFourOutputs = new FixedConnectionAnchor(f);
		left4AnchorFourOutputs = new FixedConnectionAnchor(f);
		anchorFourOutputs = new FixedConnectionAnchor(f);
		rightAnchorFourOutputs.setOffsetH(0);
		rightAnchorFourOutputs.setOffsetV(20);
		left1AnchorFourOutputs.setOffsetH(20);
		left1AnchorFourOutputs.setOffsetV(5);			
		left2AnchorFourOutputs.setOffsetH(20);
		left2AnchorFourOutputs.setOffsetV(15);
		left3AnchorFourOutputs.setOffsetH(20);
		left3AnchorFourOutputs.setOffsetV(25);
		left4AnchorFourOutputs.setOffsetH(20);
		left4AnchorFourOutputs.setOffsetV(35);
		anchorFourOutputs.setOffsetH(10);
		anchorFourOutputs.setOffsetV(20);
		rightFourOutputs.put(TERMINAL_RIGHT, rightAnchorFourOutputs);
		rightFourOutputs.put(TERMINAL_LEFT1, left1AnchorFourOutputs);
		rightFourOutputs.put(TERMINAL_LEFT2, left2AnchorFourOutputs);
		rightFourOutputs.put(TERMINAL_LEFT3, left3AnchorFourOutputs);
		rightFourOutputs.put(TERMINAL_LEFT4, left4AnchorFourOutputs);
		rightFourOutputs.put(TERMINAL, anchorFourOutputs);
		anchorsFourOutputs.put("", rightFourOutputs); //$NON-NLS-1$
		anchorsFourOutputs.put(RIGHT, rightFourOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable upFourOutputs = new Hashtable();
		rightAnchorFourOutputs = new FixedConnectionAnchor(f);
		left1AnchorFourOutputs = new FixedConnectionAnchor(f);
		left2AnchorFourOutputs = new FixedConnectionAnchor(f);
		left3AnchorFourOutputs = new FixedConnectionAnchor(f);
		left4AnchorFourOutputs = new FixedConnectionAnchor(f);
		anchorFourOutputs = new FixedConnectionAnchor(f);
		rightAnchorFourOutputs.setOffsetH(20);
		rightAnchorFourOutputs.setOffsetV(20);
		left1AnchorFourOutputs.setOffsetH(5);
		left1AnchorFourOutputs.setOffsetV(0);			
		left2AnchorFourOutputs.setOffsetH(15);
		left2AnchorFourOutputs.setOffsetV(0);
		left3AnchorFourOutputs.setOffsetH(25);
		left3AnchorFourOutputs.setOffsetV(0);
		left4AnchorFourOutputs.setOffsetH(35);
		left4AnchorFourOutputs.setOffsetV(0);
		anchorFourOutputs.setOffsetH(20);
		anchorFourOutputs.setOffsetV(10);
		upFourOutputs.put(TERMINAL_RIGHT, rightAnchorFourOutputs);
		upFourOutputs.put(TERMINAL_LEFT1, left1AnchorFourOutputs);
		upFourOutputs.put(TERMINAL_LEFT2, left2AnchorFourOutputs);
		upFourOutputs.put(TERMINAL_LEFT3, left3AnchorFourOutputs);
		upFourOutputs.put(TERMINAL_LEFT4, left4AnchorFourOutputs);
		upFourOutputs.put(TERMINAL, anchorFourOutputs);
		anchorsFourOutputs.put(UP, upFourOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable downFourOutputs = new Hashtable();
		rightAnchorFourOutputs = new FixedConnectionAnchor(f);
		left1AnchorFourOutputs = new FixedConnectionAnchor(f);
		left2AnchorFourOutputs = new FixedConnectionAnchor(f);
		left3AnchorFourOutputs = new FixedConnectionAnchor(f);
		left4AnchorFourOutputs = new FixedConnectionAnchor(f);
		anchorFourOutputs = new FixedConnectionAnchor(f);
		rightAnchorFourOutputs.setOffsetH(20);
		rightAnchorFourOutputs.setOffsetV(0);
		left1AnchorFourOutputs.setOffsetH(5);
		left1AnchorFourOutputs.setOffsetV(20);			
		left2AnchorFourOutputs.setOffsetH(15);
		left2AnchorFourOutputs.setOffsetV(20);
		left3AnchorFourOutputs.setOffsetH(25);
		left3AnchorFourOutputs.setOffsetV(20);
		left4AnchorFourOutputs.setOffsetH(35);
		left4AnchorFourOutputs.setOffsetV(20);
		anchorFourOutputs.setOffsetH(20);
		anchorFourOutputs.setOffsetV(10);
		downFourOutputs.put(TERMINAL_RIGHT, rightAnchorFourOutputs);
		downFourOutputs.put(TERMINAL_LEFT1, left1AnchorFourOutputs);
		downFourOutputs.put(TERMINAL_LEFT2, left2AnchorFourOutputs);
		downFourOutputs.put(TERMINAL_LEFT3, left3AnchorFourOutputs);
		downFourOutputs.put(TERMINAL_LEFT4, left4AnchorFourOutputs);
		downFourOutputs.put(TERMINAL, anchorFourOutputs);
		anchorsFourOutputs.put(DOWN, downFourOutputs);
		
		//Anchors for four outputs node
		f = new Figure();
		f.setSize(20,40);
		Hashtable leftFiveOutputs = new Hashtable();
		FixedConnectionAnchor rightAnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left1AnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left2AnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left3AnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left4AnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor left5AnchorFiveOutputs = new FixedConnectionAnchor(f);
		FixedConnectionAnchor anchorFiveOutputs = new FixedConnectionAnchor(f);
		rightAnchorFiveOutputs.setOffsetH(20);
		rightAnchorFiveOutputs.setOffsetV(20);
		left1AnchorFiveOutputs.setOffsetH(0);
		left1AnchorFiveOutputs.setOffsetV(0);			
		left2AnchorFiveOutputs.setOffsetH(0);
		left2AnchorFiveOutputs.setOffsetV(10);
		left3AnchorFiveOutputs.setOffsetH(0);
		left3AnchorFiveOutputs.setOffsetV(20);
		left4AnchorFiveOutputs.setOffsetH(0);
		left4AnchorFiveOutputs.setOffsetV(30);
		left5AnchorFiveOutputs.setOffsetH(0);
		left5AnchorFiveOutputs.setOffsetV(40);
		anchorFiveOutputs.setOffsetH(10);
		anchorFiveOutputs.setOffsetV(20);
		leftFiveOutputs.put(TERMINAL_RIGHT, rightAnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL_LEFT1, left1AnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL_LEFT2, left2AnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL_LEFT3, left3AnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL_LEFT4, left4AnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL_LEFT5, left5AnchorFiveOutputs);
		leftFiveOutputs.put(TERMINAL, anchorFiveOutputs);
		anchorsFiveOutputs.put(LEFT, leftFiveOutputs);
		
		f = new Figure();
		f.setSize(20,40);
		Hashtable rightFiveOutputs = new Hashtable();
		rightAnchorFiveOutputs = new FixedConnectionAnchor(f);
		left1AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left2AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left3AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left4AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left5AnchorFiveOutputs = new FixedConnectionAnchor(f);
		anchorFiveOutputs = new FixedConnectionAnchor(f);
		rightAnchorFiveOutputs.setOffsetH(0);
		rightAnchorFiveOutputs.setOffsetV(20);
		left1AnchorFiveOutputs.setOffsetH(20);
		left1AnchorFiveOutputs.setOffsetV(0);			
		left2AnchorFiveOutputs.setOffsetH(20);
		left2AnchorFiveOutputs.setOffsetV(10);
		left3AnchorFiveOutputs.setOffsetH(20);
		left3AnchorFiveOutputs.setOffsetV(20);
		left4AnchorFiveOutputs.setOffsetH(20);
		left4AnchorFiveOutputs.setOffsetV(30);
		left5AnchorFiveOutputs.setOffsetH(20);
		left5AnchorFiveOutputs.setOffsetV(40);
		anchorFiveOutputs.setOffsetH(10);
		anchorFiveOutputs.setOffsetV(20);
		rightFiveOutputs.put(TERMINAL_RIGHT, rightAnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL_LEFT1, left1AnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL_LEFT2, left2AnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL_LEFT3, left3AnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL_LEFT4, left4AnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL_LEFT5, left5AnchorFiveOutputs);
		rightFiveOutputs.put(TERMINAL, anchorFiveOutputs);
		anchorsFiveOutputs.put("", rightFiveOutputs); //$NON-NLS-1$
		anchorsFiveOutputs.put(RIGHT, rightFiveOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable upFiveOutputs = new Hashtable();
		rightAnchorFiveOutputs = new FixedConnectionAnchor(f);
		left1AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left2AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left3AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left4AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left5AnchorFiveOutputs = new FixedConnectionAnchor(f);
		anchorFiveOutputs = new FixedConnectionAnchor(f);
		rightAnchorFiveOutputs.setOffsetH(20);
		rightAnchorFiveOutputs.setOffsetV(20);
		left1AnchorFiveOutputs.setOffsetH(0);
		left1AnchorFiveOutputs.setOffsetV(0);			
		left2AnchorFiveOutputs.setOffsetH(10);
		left2AnchorFiveOutputs.setOffsetV(0);
		left3AnchorFiveOutputs.setOffsetH(20);
		left3AnchorFiveOutputs.setOffsetV(0);
		left4AnchorFiveOutputs.setOffsetH(30);
		left4AnchorFiveOutputs.setOffsetV(0);
		left5AnchorFiveOutputs.setOffsetH(40);
		left5AnchorFiveOutputs.setOffsetV(0);
		anchorFiveOutputs.setOffsetH(20);
		anchorFiveOutputs.setOffsetV(10);
		upFiveOutputs.put(TERMINAL_RIGHT, rightAnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL_LEFT1, left1AnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL_LEFT2, left2AnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL_LEFT3, left3AnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL_LEFT4, left4AnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL_LEFT5, left5AnchorFiveOutputs);
		upFiveOutputs.put(TERMINAL, anchorFiveOutputs);
		anchorsFiveOutputs.put(UP, upFiveOutputs);
		
		f = new Figure();
		f.setSize(40,20);
		Hashtable downFiveOutputs = new Hashtable();
		rightAnchorFiveOutputs = new FixedConnectionAnchor(f);
		left1AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left2AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left3AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left4AnchorFiveOutputs = new FixedConnectionAnchor(f);
		left5AnchorFiveOutputs = new FixedConnectionAnchor(f);
		anchorFiveOutputs = new FixedConnectionAnchor(f);
		rightAnchorFiveOutputs.setOffsetH(20);
		rightAnchorFiveOutputs.setOffsetV(0);
		left1AnchorFiveOutputs.setOffsetH(0);
		left1AnchorFiveOutputs.setOffsetV(20);			
		left2AnchorFiveOutputs.setOffsetH(10);
		left2AnchorFiveOutputs.setOffsetV(20);
		left3AnchorFiveOutputs.setOffsetH(20);
		left3AnchorFiveOutputs.setOffsetV(20);
		left4AnchorFiveOutputs.setOffsetH(30);
		left4AnchorFiveOutputs.setOffsetV(20);
		left5AnchorFiveOutputs.setOffsetH(40);
		left5AnchorFiveOutputs.setOffsetV(20);
		anchorFiveOutputs.setOffsetH(20);
		anchorFiveOutputs.setOffsetV(10);
		downFiveOutputs.put(TERMINAL_RIGHT, rightAnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL_LEFT1, left1AnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL_LEFT2, left2AnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL_LEFT3, left3AnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL_LEFT4, left4AnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL_LEFT5, left5AnchorFiveOutputs);
		downFiveOutputs.put(TERMINAL, anchorFiveOutputs);
		anchorsFiveOutputs.put(DOWN, downFiveOutputs);
		
		allAnchors.put(2, anchors);
		allAnchors.put(3, anchorsThreeOutputs);
		allAnchors.put(4, anchorsFourOutputs);
		allAnchors.put(5, anchorsFiveOutputs);
	}
			
	public static Dimension getPreferedSize(String rotation) {
		return ((FixedConnectionAnchor)((Hashtable)anchors.get(rotation)).get(TERMINAL)).getOwner().getSize();
	}
	
	public static FixedConnectionAnchor getAnchor(String rotation, String name, int in_out_puts) {
		Hashtable currentAnchors= (Hashtable)allAnchors.get(in_out_puts);
		Hashtable anchorsByRotation = (Hashtable) currentAnchors.get(rotation);
		return (FixedConnectionAnchor) anchorsByRotation.get(name);
		//return (FixedConnectionAnchor)((Hashtable)anchors.get(rotation)).get(name);
	}
	
	protected String rotation = RIGHT;
	
	/**
	 * Instantiates an instance of ThreeConnectionFigure
	 * 
	 * @param roration the figure rotation
	 * @param fC the foreground color of the figure
	 */
	public ThreeConnectionFigure(String rotation, RGB fc, IFigure parent) {		
		super(parent, fc);
		setLayoutManager(new StackLayout());
		
		setRotation(rotation);
		setBackgroundColor(ColorConstants.black);
		setForegroundColor(new Color(Display.getCurrent(), fc));
	}

	/**
	 * Sets the rotation of the figure and updated the size
	 * 
	 * @param r the new rotation
	 */
	public void setRotation(String r) {
		if (r.equals("")) //$NON-NLS-1$
			this.rotation = RIGHT;
		else
			this.rotation = r;
		
		if (rotation.equals(LEFT))		
			setSize(20,40);			
		else if (rotation.equals(RIGHT))
			setSize(20,40);
		else if (rotation.equals(UP))
			setSize(40,20);
		else if (rotation.equals(DOWN))
			setSize(40,20);
	}
	
	public Dimension getPreferredSize(int wHint, int hHint) {
		return getSize();
	}	
}