/**
 * 
 */
package org.isistan.flabot.util.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * SWT utility methods
 * @author mblech
 *
 */
public class SWTUtils {

	/**
	 * Get some shell from the given display
	 * @param display a display
	 * @return some shell from the given display
	 */
	public static synchronized Shell getSomeShell(Display display) {
		if (display == null)
			return new Shell();
		Shell shell = display.getActiveShell();
		if (shell == null) {
			Shell[] shells = display.getShells();
			if (shells.length > 0)
				shell = shells[0];
			else
				shell = new Shell();
		}
		return shell;
	}

}
