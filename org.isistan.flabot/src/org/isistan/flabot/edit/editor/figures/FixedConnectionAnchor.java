/**

import org.eclipse.draw2d.AbstractConnectionAnchor;
public class FixedConnectionAnchor 
		extends AbstractConnectionAnchor
	{

	public boolean leftToRight = true;
	public int offsetH;
	public int offsetV;
	public boolean topDown = true;

	public FixedConnectionAnchor(IFigure owner) {
		super(owner);
	}

	/**
	 * @see org.eclipse.draw2d.AbstractConnectionAnchor#ancestorMoved(IFigure)
	 */
	public void ancestorMoved(IFigure figure) {
		if (figure instanceof ScalableFigure)
			return;
		super.ancestorMoved(figure);
	}

	public Point getLocation(Point reference) {
		Rectangle r = getOwner().getBounds();
		int x,y;
		if (topDown)
			y = r.y + offsetV;
		else
			y = r.bottom() - 1 - offsetV;

		if (leftToRight)
			x = r.x + offsetH;
		else
			x = r.right() - 1 - offsetH;
		
		Point p = new PrecisionPoint(x,y);
		getOwner().translateToAbsolute(p);
		return p;
	}

	public Point getReferencePoint(){
		return getLocation(null);
	}
		
	/**
	 * @param offsetH The offsetH to set.
	 */
	public void setOffsetH(int offsetH) {
		this.offsetH = offsetH;
		fireAnchorMoved();
	}

	/**
	 * @param offsetV The offsetV to set.
	 */
	public void setOffsetV(int offsetV) {
		this.offsetV = offsetV;
		fireAnchorMoved();
	}
}