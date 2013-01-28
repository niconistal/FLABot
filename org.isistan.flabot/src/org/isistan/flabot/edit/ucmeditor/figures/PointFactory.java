/**
 * $Id: PointFactory.java,v 1.1 2005/09/30 19:22:42 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import com.graphbuilder.curve.Point;

/**
 * @author $Author: franco $
 *
 */
public class PointFactory {
	
	public static Point createPoint(double x, double y) {
		final double[] arr = new double[] {x, y};

		return new Point() {
			public double[] getLocation() {
				return arr;
			}

			public void setLocation(double[] loc) {
				arr[0] = loc[0];
				arr[1] = loc[1];
			}
		};
	}
}
