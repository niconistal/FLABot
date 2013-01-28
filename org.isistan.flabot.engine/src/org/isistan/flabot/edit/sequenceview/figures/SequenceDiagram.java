/**
 * $Id: SequenceDiagram.java,v 1.19 2006/04/04 03:29:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.sequenceview.figures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.engine.messages.Messages;

/**
 * An interaction represents a synchronous/asynchronous message that is sent between two components. 
 * 
 * @author $Author: franco $ 
 */
class Interaction
{
    private int srcObj;
    private boolean srcObjHasControl;
    private Color lineColor;
    private int arrowKind; //1=SYNC, 2= ASYNC, 3=EDGE, 4=FILLED
    private int lineKind; //1=SOLID, 2=DOTTED
    private int destObj;
    private boolean destObjHasControl;
    private String methodName;


    public Interaction(int srcObj, boolean srcObjHasControl, Color lineColor, int arrowKind, int lineKind,
		int destObj, boolean destObjHasControl, String methodName)
    {
    	this.srcObj= srcObj;
    	this.srcObjHasControl= srcObjHasControl;
    	this.lineColor = lineColor;
    	this.arrowKind= arrowKind;
    	this.lineKind = lineKind;
    	this.destObj= destObj;
    	this.destObjHasControl= destObjHasControl;
    	this.methodName= methodName;
    }

    public boolean hasControl(int objNum) {
		if ((srcObjHasControl && srcObj== objNum) ||
		    (destObjHasControl && destObj== objNum))
		    return true;
		else return false;
    }


    @Override
	public boolean equals(Object o) {
        if (!(o instanceof Interaction)) return false;
        Interaction i = (Interaction)o;

        return srcObj==i.srcObj && srcObjHasControl==i.srcObjHasControl &&
        	arrowKind==i.arrowKind && destObj==i.destObj && 
			destObjHasControl==i.destObjHasControl &&
			(methodName == null |  methodName.equals(i.methodName));
    }

    @Override
	public int hashCode() {
    	return (methodName!=null?methodName.hashCode():1) + srcObj + 
	    	(srcObjHasControl?1:0) + arrowKind + destObj + (destObjHasControl?1:0);
    }

    public int getSrcObj() {return srcObj;}
    public boolean getSrcObjHasControl() {return srcObjHasControl;}
    public int getArrowKind() {return arrowKind;}
    public Color getLineColor() {return lineColor;}
    public int getLineKind() {return lineKind;}
    public int getDestObj() {return destObj;}
    public boolean getDestObjHasControl() {return destObjHasControl; }
    public String getMethodName() {return methodName; }
}

/**
 * Contains all interactions entered by the user and offers various comfort-functions for finding and working with interactions. 
 * 
 * @author $Author: franco $
 */
class InteractionManagement
{
	private Set[] level;

    InteractionManagement(int numLevels) {
    	level= new HashSet[numLevels];
    	for (int i=0; i < numLevels; i++) {
    		level[i]= new HashSet<Interaction>();
    	}
    }

    public boolean controlBoxExists(int levelNum, int objNum) {
    	Iterator<Interaction> it= level[levelNum-1].iterator();
		while (it.hasNext()) {
			Interaction ia= it.next();
		    if (ia.hasControl(objNum)) return true;
		}
		return false;
    }

    public void add(int numLevel, Interaction i) {
    	level[numLevel-1].add(i);
    }

    public Set<Interaction> getInteractionsInLevel(int levelNum) {
    	return level[levelNum-1];
    }

    public int getNumLevels() {
    	return level.length;
    }
}

/**
 * The sequence diagram is used to show the route followed by the Fault Locator Engine.
 * It shows the components and the interactions between them representing the responsibilities visited by the engine; it also shows the kind of condition (eg: precondition, mapping) with the color of the arrow.
 * 
 * @author $Author: franco $
 *
 */
public class SequenceDiagram extends Shape {

    public int controlFlowBoxWidth = 10;

    //the dimensions for the rectangle(s) (=roles/components) in the first line
    public final int rectDistance = 10; //distance between two columns
    public int rectHeight; //computed
    public int rectWidth;  //computed
    int extraTextSpace = 0;
    
    private Vector<String> obj;
    private int numObjects = 0;
    String boxStrings;

    public final int borderDistance= 30; //d between the component bordeR and the diagram

    public int rectToFirstLevelDistance= 20;
    public int levelHeight= 30;

    //these two constants are important for the arrowhead
    public final int arrowX= 5; 
    public final int arrowY= 5;

    //Arrow Kind
    public final int SYNC=   1;
    public final int ASYNC=  2;
    public final int EDGE=	 3;
    public final int FILLED= 4;
    public final int MAP=    5;
    
    //Line Kind
    public final int SOLID=  SWT.LINE_SOLID;
    public final int DOTTED= SWT.LINE_DOT;
    public final int DASH= SWT.LINE_DASH;
    
    private int levelNum= 0; 
    private InteractionManagement im;

    private int maps = 0;
    private int offset = 0;
    
	//Colors
	private Color _activeColor=ColorConstants.black;
	private Color _mapColor= new Color(Display.getCurrent(), new RGB(200,200,200));
	private Color _fillComponentsColor= new Color(Display.getCurrent(), new RGB(235,235,235));
	       
    String text = ""; //$NON-NLS-1$
    
    /**
     * Instantiates the sequence diagram.
     */
    public SequenceDiagram() {
    	setSize(100,100); //initial size
		setVisible(true);		

    	//Added double Components size.
    	rectHeight= 2*Constants.getDistLineToText() + Constants.getFontsize() + 22;    	
    	im = new InteractionManagement(0);
    	
    	updateText();
    }

    @Override
    public void outlineShape(Graphics g) {
    	//g.setAntialias(SWT.ON);
    	if (text.length() > 0)
    		drawSequence(g);
    	else {
    		setSize(300, 20);
    		g.drawString(Messages.getString("org.isistan.flabot.engine.SequenceDiagram.noExecutionStepsSequenceView"), 0, 0); //$NON-NLS-1$
    	}
    }
    
    @Override
    public void fillShape(Graphics g) {
    	//Do nothing
    }
    
    /**
     * Sets the text to be parsed.
     * 
     * @param text the text to parse
     */
    public void setText(String text) {
    	this.text = text;
    	updateText();
    	repaint();
    }
    
    /**
     * Parses the messages and sets the diagram configuration.
     * The sequence diagram is build parsing a text, the first line represents the components, and the rest of the lines the interaction between this componets.
     * 
     * eg:
     * |_aProvider:ProviderComponent_|_aProcessOrderTask:ProcessOrderTaskComponent_|_aProcess:ProcessOrder_
     * 1->1:1,1:initTransaction
     * 1->2:1,2:storeRequest
     * 2->3:2,3:sendContract
     */
    public void updateText() {
    	Vector<String> lines=Constants.decomposeStrings(text, "\n"); //$NON-NLS-1$
    	numObjects=0;
    	levelNum= 0;   	
    	if (lines.size() == 0)
    		return;
    	
    	for (int i=1; i < lines.size(); i++) {
    		if (lines.elementAt(i).matches("\\A\\s*\\z")) continue; //$NON-NLS-1$
    		levelNum++;
    	}

    	String firstLine= lines.elementAt(0);
		obj= Constants.decomposeStrings(firstLine, "|"); //$NON-NLS-1$
		numObjects= obj.size();

		//parse the messages
		int curLevel= 0; maps = 0;
    	im= new InteractionManagement(levelNum);
		double maxWidth = 0;		
		boxStrings=""; //$NON-NLS-1$
		for (int i=1; i < lines.size(); i++) {
		    if (lines.elementAt(i).matches("\\A\\s*\\z")) continue; //$NON-NLS-1$
		    curLevel++;
		    Vector<String> interactions= Constants.decomposeStrings(lines.elementAt(i), ";"); //$NON-NLS-1$
		    
		    int j = 0;
		    for (; j < interactions.size(); j++) {
		    	Pattern p = Pattern.compile("\\A(\\d+)(->>|->|-/>|.>>|.>|./>|->>>|.>>>|==)(\\d+):(\\d+),(\\d+):(.*)_(\\d+):(\\d+):(\\d+)$\\Z"); //$NON-NLS-1$
		    	//1->2:1,2:methodName_255:255:255
		    	
		    	Matcher m= p.matcher(interactions.elementAt(j));
		    	if (!m.matches()) break;
		    	
		    	int srcObj= Integer.parseInt(m.group(1));
		    	
		    	int arrowKind= -1;
		    	int lineKind= -1;
		    	if (m.group(2).equals("->")) 	   {arrowKind= SYNC; lineKind=SOLID;} //$NON-NLS-1$
		    	else if (m.group(2).equals("->>")) {arrowKind= SYNC; lineKind=DASH;} //$NON-NLS-1$
		    	else if (m.group(2).equals("-/>")) {arrowKind= EDGE; lineKind=SOLID;} //$NON-NLS-1$
		    	else if (m.group(2).equals("->>>")) {arrowKind= FILLED; lineKind=SOLID;} //$NON-NLS-1$
		    	else if (m.group(2).equals(".>"))  {arrowKind= ASYNC; lineKind=DOTTED;} //$NON-NLS-1$
		    	else if (m.group(2).equals(".>>")) {arrowKind= SYNC; lineKind=DOTTED;} //$NON-NLS-1$
		    	else if (m.group(2).equals("./>")) {arrowKind= EDGE; lineKind=DOTTED;} //$NON-NLS-1$
		    	else if (m.group(2).equals(".>>>")) {arrowKind= FILLED; lineKind=DOTTED;} //$NON-NLS-1$
		    				    		    	
		    	int destObj= Integer.parseInt(m.group(3));
		    	String group = m.group(4) + "," + m.group(5); //get alive Objects //$NON-NLS-1$
		    	boxStrings += ";" + group; //get alive Objects //$NON-NLS-1$
		    	
		    	boolean srcObjHasControl= group.contains(String.valueOf(srcObj));;
		    	boolean destObjHasControl= group.contains(String.valueOf(destObj));;
		    	
		    	String methodName= m.group(6);
		    	if (methodName != null) {
		    		Label l1 = new Label(methodName);
		    		l1.setFont(Constants.getFont());
		    		maxWidth = Math.max(l1.getTextBounds().width, maxWidth);
		    	}	    	
		    	
		    	if(destObj==srcObj) levelNum++; //expand the Entity's size
		    	
		    	if ((srcObj <= 0) || (destObj<= 0) || (srcObj > numObjects) || (destObj > numObjects)) continue;
	
		    	RGB rgb = new RGB(Integer.parseInt(m.group(7)),
		    			Integer.parseInt(m.group(8)),
		    			Integer.parseInt(m.group(9)));
		    	Color c = new Color(Display.getCurrent(), rgb);
		    	
		    	im.add(curLevel, new Interaction(srcObj,srcObjHasControl, c, arrowKind, lineKind, destObj, destObjHasControl, methodName));
		    } //#for
		    
		    for (; j < interactions.size(); j++) {
		    	Pattern p = Pattern.compile("\\A(\\d+)(==)(\\d+):(.*)\\Z"); //$NON-NLS-1$
		    	//1->2:1,2:methodName_255:255:255
		    	
		    	Matcher m= p.matcher(interactions.elementAt(j));
		    	if (!m.matches()) break;
	    	
		    	int srcObj= Integer.parseInt(m.group(1));
		    	int destObj= Integer.parseInt(m.group(3));
		    	int arrowKind= MAP; 
		    	int lineKind=SOLID; 
		    	levelNum = levelNum - 1; //This must not be consider a new level. 
		    	maps++;
		    	
		    	String mapName= m.group(4);
		    	Label l1 = new Label(mapName);
		    	l1.setFont(Constants.getFont());
		    	maxWidth = Math.max(l1.getTextBounds().width, maxWidth);
		    	im.add(curLevel, new Interaction(srcObj,false, null, arrowKind, lineKind, destObj, false, mapName));	    
		    }
		}
		
		//end message parsing
		
		// find out the width of the column with the longest text
		for (int i=0; i < numObjects; i++) {
		    String s= obj.elementAt(i);
		    if (s.startsWith("_") && s.endsWith("_") && s.length()>2) { //$NON-NLS-1$ //$NON-NLS-2$
		    	s=s.substring(1,s.length()-1);
		    }

		    //The titles of the components are divided into three texts RoleName:ComponentName:InstanceOf
		    StringTokenizer st = new StringTokenizer(s, "##"); //$NON-NLS-1$
		    int max = 0;
		    while(st.hasMoreTokens()) {
		    	String token = st.nextToken();
			    Label label = new Label(token);
			    label.setFont(Constants.getFont());
			    max = Math.max(max, label.getTextBounds().width);
		    }	    
		    maxWidth= Math.max(max, maxWidth);
		}
		rectWidth= (int)Math.floor(maxWidth+1)+ 2* Constants.getDistLineToText() + Constants.getFontsize();

    }
    
    /**
     * Draws the sequence diagram.
     * @param g
     */
    public void drawSequence(Graphics g) {    	
    	if (numObjects == 0)
    		return;
    	
    	//Inicialization    	
    	g.setFont(Constants.getFont());    	    
    	g.setBackgroundColor(_activeColor);
    	g.setForegroundColor(_activeColor);
    	
    	//draw the border
    	g.drawRectangle(0, 0, getWidth()-1, getHeight()-1);    	   		    	 	
    	
		//draw the first line of the sequence diagram (the componets)
		int ypos= borderDistance;
		int xpos= borderDistance;
		for (int i=0; i < numObjects; i++) {
		    boolean underline= false;
		    String s= obj.elementAt(i);
		    if (s.startsWith("_") && s.endsWith("_") && s.length()>2) { //$NON-NLS-1$ //$NON-NLS-2$
		    	underline=true;
		    	s=s.substring(1,s.length()-1);
		    } 
		   
		    //Draws the rectangle 
		    g.drawRectangle(xpos, ypos, rectWidth-1, rectHeight-1);
		    g.setBackgroundColor(_fillComponentsColor);
		    g.fillRectangle(xpos + 1, ypos + 1, rectWidth - 2, rectHeight - 2);
		    
		    int index = s.indexOf(":"); //$NON-NLS-1$
		    if (index < 0) index = s.length();
		    

		    StringTokenizer st = new StringTokenizer(s, "##"); //$NON-NLS-1$
		    Label label = new Label();
		    int height = 0;
		    while(st.hasMoreTokens()) {
		    	String token = st.nextToken();
			    label = new Label(token);
			    label.setFont(Constants.getFont());
			    
			    int dx= (rectWidth-2 - (int)Math.floor(label.getTextBounds().width+1)) / 2;
			    int dy= height;
			    int tx= xpos + dx;
			    int ty= ypos + dy;		    
			    g.drawString(label.getText(), tx, ty);
			    		    
			    if (underline)
					g.drawLine(tx, 
						    ty+label.getTextBounds().height, 
						    tx+label.getTextBounds().width, 
						    ty+label.getTextBounds().height);
			    height += label.getTextBounds().height + 1;
		    }		    
		    
		    xpos += rectWidth + rectDistance;	
		}
		
		offset = 0;
		Set<Interaction> set = im.getInteractionsInLevel(im.getNumLevels() - maps);
		Iterator<Interaction> it= set.iterator();
		if (it.hasNext()) {
			Interaction i = it.next();
			if(i.getSrcObj() == i.getDestObj()) {
				Label l = new Label(i.getMethodName());
				l.setFont(Constants.getFont());
				offset = l.getTextBounds().width - rectWidth / 2 + borderDistance;
				if (offset < 0) offset = 0;
			}
    	}
		
		//draw the messages
		drawMessages(g);
		if(boxStrings!=null && boxStrings.length()>1)
			drawControlFlowBoxesWithLines(g, boxStrings.substring(1),numObjects); //1,2;1,2;... cut first ;-character
							
		//set our component to the correct size
		setSize(rectWidth * numObjects + 
			rectDistance * (numObjects-1) +
			2 * borderDistance + offset, 
			2 * borderDistance +
			rectHeight + 
			rectToFirstLevelDistance +
			levelNum * levelHeight);
    }

    /**
     * Draws all the interactions between the components with the name of the responsibility.
     * It also draws the map boxes.
     * 
     * @param g
     */
    private void drawMessages(Graphics g) {
    	for (int i=0; i < im.getNumLevels(); i++) {
    		Set<Interaction> interactions= im.getInteractionsInLevel(i+1);
    		Iterator<Interaction> it= interactions.iterator();
    		while (it.hasNext()) {
    			Interaction ia= it.next();    			
    			
    			if (ia.getArrowKind() == MAP)  {
    				//draw the maps boxes
    				int yOffset = 5;
    		    	int h =  borderDistance +
    						 rectHeight + 
    						 rectToFirstLevelDistance +
    						 levelNum * levelHeight;    	
    		    	
    		    	int start = ia.getSrcObj();
    		    	int end = ia.getDestObj();
    		    	int total = end - start + 1;
    		    	
    		    	int endXOffset = 0;
    		    	if (end == numObjects)
    		    		endXOffset = offset;
    		    	
    		    	drawMapFrame(g, ia.getMethodName(), (rectDistance + rectWidth)*(start - 1) + borderDistance - rectDistance/2, yOffset, (rectDistance + rectWidth) * total + endXOffset, h);  				
    				continue;
    			}
    			
    			if (ia.getSrcObj() == ia.getDestObj()) {
    				//draw an arc-arrow
    				int xTextOffset=0;
    				int w= 30;
    				int h= (int)(levelHeight * 0.66);
    				int x= hCenterForObj(ia.getSrcObj()) - w/2;
    				int ay= vCenterForLevel(i+1) + 5;
		    	    if (im.controlBoxExists(i+1, ia.getSrcObj())) {
		    	    	x += controlFlowBoxWidth/2;
		    	    	xTextOffset=controlFlowBoxWidth/2;
		    	    }
		    	    Color oldColor = g.getForegroundColor();
		        	g.setForegroundColor(ia.getLineColor());
		    	    
		        	int oldLineWidth = g.getLineWidth();
		        	int lineWidth = 2;
		    	    g.setLineStyle(ia.getLineKind());
		    	    g.setLineWidth(lineWidth);
		    	    g.drawArc(x,ay,w,h, 90,-180);
		    	    Point p1= new Point(x+w/2, ay+h);
		    	    Point d1= new Point(x+w/2 + 3, p1.y -6);
		    	    Point d2= new Point(x+w/2+4, p1.y +4);
		    	    g.setLineStyle(SWT.LINE_CUSTOM);
		    	    g.setLineWidth(oldLineWidth);
		    	    
		    	    switch(ia.getArrowKind()) {
		    	    case ASYNC: {
		    	    	g.drawLine(p1.x,p1.y, d1.x, d1.y);
		    	    	g.drawLine(p1.x,p1.y, d2.x,d2.y);
		    	    	break;
		    	    }
		    	    	
		    	    case SYNC: {
		    	    	PointList pl = new PointList();
		    			pl.addPoint(p1.x, p1.y);
		    			pl.addPoint(d1.x, d1.y);
		    			pl.addPoint(d2.x, d2.y);
		    	    	g.fillPolygon(pl);
		    	    	g.drawPolygon(pl);
		    	    	break;
		    	    }
		    	    	
		    	    case EDGE: {
		    	    	g.drawLine(p1.x,p1.y, d2.x,d2.y);
		    	    	break;
		    	    }
		    	    	
		    	    case FILLED: {
		    	    	PointList pl = new PointList();
		    			pl.addPoint(p1.x, p1.y);
		    			pl.addPoint(d1.x, d1.y);
		    			pl.addPoint(d2.x, d2.y);
		    			g.fillPolygon(pl);
		    			break;
		    	    }		    	    		    	   

		    	    }
		    	    g.setForegroundColor(oldColor);
		    	    
		    	    //print the methodname of a self transaction
		    	    if (ia.getMethodName() != null && !ia.getMethodName().equals("")){ //$NON-NLS-1$
		    	    	int fx1= x + w + 2;
		    	    	int fy1= ay;
		    	    	//rectWidth/4 so as the text is near the arrow
		    	    	int fx2= hCenterForObj(ia.getSrcObj()) + rectWidth/4;
		    	    	int fy2= ay;
		    	    	printMethodName(g, ia.getMethodName(), fx1+xTextOffset,fx2+xTextOffset,
		    	    			fy1, fy2, true, false);
		    	    }

    			} else {
    				//draw an arrow from the source-object to the destination object
    				int begX= hCenterForObj(ia.getSrcObj());
    				int endX= (ia.getSrcObj() < ia.getDestObj())? hCenterForObj(ia.getDestObj())-1: hCenterForObj(ia.getDestObj())+1;
    				int arrowY= vCenterForLevel(i+1) + levelHeight/2 -1;

    				if (ia.getSrcObjHasControl()) { //shrink arrow if box exists	
    					begX += (ia.getSrcObj() < ia.getDestObj()) ? (controlFlowBoxWidth/2) : (-controlFlowBoxWidth/2);
    				}
    				if(ia.getDestObjHasControl()) { //shrink arrow if box exists
    					endX += (ia.getSrcObj() < ia.getDestObj()) ? (-controlFlowBoxWidth/2) : (controlFlowBoxWidth/2);
    				}

    				drawArrow(g, new Point(begX,arrowY), new Point(endX, arrowY), ia.getArrowKind(), ia.getLineKind(), ia.getLineColor());

    				if (ia.getMethodName() != null && !ia.getMethodName().equals("")){ //$NON-NLS-1$
    					final int b= 2;
    					
    					if (ia.getSrcObj() < ia.getDestObj())
    						printMethodName(g, ia.getMethodName(), begX+b, 
    						endX-arrowX-b, 
							arrowY-1-levelHeight/1, arrowY-1,
							false,true);
    					else
    					printMethodName(g, ia.getMethodName(), endX+arrowX+b, 
    							begX-b, arrowY-1 - levelHeight/2, 
								arrowY-1, false,true);
    				}
    			}
    		}
    	}
    }

    /**
     * Prints the given methodName in an intelligent manner into the supplied rectangle. 
     * The method may put pixels anywhere into the supplied rectangle including the borders.
     *  
     * @param g
     * @param methodName
     * @param begX
     * @param endX
     * @param begY
     * @param endY
     * @param centerVertically
     * @param centerHorizontically
     */
    private void printMethodName(Graphics g, String methodName, 
				 int begX, int endX, int begY, int endY,
				 boolean centerVertically, boolean centerHorizontically) {

    	Label layout= new Label(methodName);
    	layout.setFont(Constants.getFont());
    	
    	//draw it horizontally centered
    	int dx=endX-begX-20+Constants.getDistLineToText();
    	if(centerHorizontically) dx= (endX-begX - layout.getTextBounds().width) / 2;
    	int dy= (centerVertically)? 
    			(endY-begY)/2 : layout.getTextBounds().height;
    	
    	g.drawString(methodName, begX + dx, endY - dy );
    }

    /**
     * 
     * @param g
     * @param s
     * @param numObjects
     */
    public void drawControlFlowBoxesWithLines(Graphics g, String s, int numObjects) {
    	int level=1;
    	StringTokenizer mainTokens = new StringTokenizer(s,";"); //$NON-NLS-1$
    	
    	int tokNum = mainTokens.countTokens();
    	int[][] tField = new int[numObjects][tokNum+2];
    	
    	//collect all tokens into an array: create another view to sequentially access data of a scecific object
    	//1,2;#;1,3;1,3;1;3 will be transfomed to
    	//	tField:	[110]
    	//			[000]
    	//			[101]
    	//			[101]
    	//			[100]
    	//			[001]
    	while(mainTokens.hasMoreTokens()) {
    		String main = mainTokens.nextToken();
    		if(main.indexOf("#")>=0) { //if no box, clear entire row //$NON-NLS-1$
    			for(int i=0;i<numObjects;i++) tField[i][level-1]=0; //clear
    			level++;
    		}	else {
    			StringTokenizer innerT = new StringTokenizer(main,","); //$NON-NLS-1$
    			for(int i=0;i<numObjects;i++) tField[i][level-1]=0; //clear
    			while(innerT.hasMoreTokens()) {
    				String is = innerT.nextToken();
    				int objNum = Integer.parseInt(is);
    				tField[objNum-1][level-1]=1;
    			}
    			level++;
    		}
        }
    	
    	for(int actObjNum=0;actObjNum<numObjects;actObjNum++) {
	    	int offset=2;
	    	int objNum=actObjNum+1;
	    	int x1 = hCenterForObj(objNum) - controlFlowBoxWidth/2; 
	    	int startLevel=-1,boxSize=0;
	    	
	    	int lineX= hCenterForObj(actObjNum+1);
	    	int lineY1= borderDistance + rectHeight;

	    	for(int i=0;i<tokNum+1;i++) {
	    		if(tField[actObjNum][i]==1) {
	    			if(startLevel==-1) startLevel=i;
	    			boxSize++;
	    		}
	    		if((tField[actObjNum][i]==0)&&(startLevel!=-1)) {
	    			int y1 = vCenterForLevel(startLevel+offset) - levelHeight-1;
	    	    	g.drawRectangle(x1,y1,controlFlowBoxWidth-1, levelHeight*boxSize); //draw the box
	    	    	
	    	    	//#draw the line between the boxes
	    	    	g.setLineStyle(SWT.LINE_DASHDOT);
	    	    	g.drawLine(lineX, lineY1, lineX, y1);
	    	    	g.setLineStyle(SWT.LINE_CUSTOM);
	    		    lineY1=y1+levelHeight*boxSize;
	    	    	startLevel=-1; boxSize=0;	    	    	
	    		}
	    	} //#for(int i
	    	
	    	//draw the tail
	    	int lineY2=borderDistance+rectHeight + levelNum* levelHeight + rectToFirstLevelDistance;
	    	
	    	g.setLineStyle(SWT.LINE_DASHDOT);
		    g.drawLine(lineX, lineY1, lineX,lineY2 );
		    g.setLineStyle(SWT.LINE_CUSTOM);
    	} //#for(int actObjNum	
    	
    }
    
    /**
     * Draws a rectangle representing a UCM with its name.
     * 
     * @param g
     * @param text the name of the UCM
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void drawMapFrame(Graphics g, String text, int x, int y, int width, int height) {
    	g.setForegroundColor(_mapColor);
    	
    	g.drawRectangle(x,y,width,height);   
	    
    	g.drawString(text, x + Constants.getDistTextToText(), y + Constants.getDistTextToText());	    
	    Label l=new Label(text);
	    l.setFont(Constants.getFont());
	    Rectangle bounds = l.getTextBounds();
	    int textWidth=(bounds.width > width)?(width):(bounds.width);    
	    
	    g.drawLine(x, y + bounds.height + Constants.getDistTextToText() * 2, x + textWidth + Constants.getDistTextToText() * 2,y + bounds.height + Constants.getDistTextToText() * 2);
	    g.drawLine(x + textWidth + Constants.getDistTextToText() * 2, y + bounds.height + Constants.getDistTextToText() * 2, x + textWidth + 10,y);
	    
	    g.setForegroundColor(_activeColor);
    }
    
    /**
     * Draws the line that links two components (representing a responsibility) and the arrowhead at the end of this line.
     * 
     * @param g
     * @param srcObj the source component
     * @param destObj the target component
     * @param arrowKind the kind of arrow
     * @param lineKind the kind of the line
     */
    public void drawArrow(Graphics g, Point srcObj, Point destObj, int arrowKind, int lineKind, Color color) {
     	int oldLineWidth = g.getLineWidth();
    	Color oldColor = g.getForegroundColor();
    	g.setForegroundColor(color);
    	int lineWidth = 2;
    	
    	Point p1, p2;
		if (srcObj.x < destObj.x){
			p1 = new Point(destObj.x-arrowX, destObj.y+arrowY);
			p2 = new Point(destObj.x-arrowX, destObj.y-arrowY);
	    } else {
	    	p1 = new Point(destObj.x+arrowX, destObj.y+arrowY);
	    	p2 = new Point(destObj.x+arrowX, destObj.y-arrowY);
	    }
		 
		switch(arrowKind) {
		case SYNC:
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
 			g.drawLine(destObj.x, destObj.y, p1.x, p1.y);
 			g.drawLine(destObj.x, destObj.y, p2.x, p2.y);
 			
 			g.setLineWidth(lineWidth);
 			g.setLineStyle(lineKind); 			
 			g.drawLine(srcObj.x,srcObj.y,p1.x, destObj.y);
 			break;
 		
		case ASYNC:
			g.drawLine(destObj.x, destObj.y, p1.x, p1.y);
			g.drawLine(destObj.x, destObj.y, p2.x, p2.y);
			
			g.setLineWidth(lineWidth);
			g.setLineStyle(lineKind);		
			g.drawLine(srcObj.x,srcObj.y,destObj.x, destObj.y);
			break;
			
		case EDGE:
			g.drawLine(destObj.x, destObj.y, p2.x, p2.y);			
			
			g.setLineWidth(lineWidth);
			g.setLineStyle(lineKind);			
			g.drawLine(srcObj.x,srcObj.y,destObj.x, destObj.y);
			break;
			
		case FILLED:
			PointList pl = new PointList();
			pl.addPoint(p1.x, p1.y);
			pl.addPoint(p2.x, p2.y);
			pl.addPoint(destObj.x, destObj.y);
			g.fillPolygon(pl);		
			g.setLineStyle(lineKind);
 			
			g.setLineWidth(lineWidth);
 			g.drawLine(srcObj.x,srcObj.y,p1.x, destObj.y);
 			break;
 			
		}
		
		g.setLineWidth(oldLineWidth);
		g.setLineStyle(SWT.LINE_CUSTOM);
		g.setForegroundColor(oldColor);
    }

    protected int hCenterForObj(int objNum) {
    	return (objNum*rectWidth + (objNum-1)*rectDistance + borderDistance -
    			rectWidth/2);
    }

    protected int vCenterForLevel(int level) {
    	return (level*levelHeight + rectToFirstLevelDistance + 
    			rectHeight + borderDistance - levelHeight/2);
    }
    
	public int getX(){
		return this.getLocation().x;
	}
  
	public int getY(){
	    return this.getLocation().y;
	}
	
  	public int getWidth() {
  		return getSize().width;
  	}
  
  	public int getHeight() {
  		return getSize().height;
  	}
}