/**
 * $Id: NoExecutionFlabotCommandStack.java,v 1.1 2006/03/29 19:27:28 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview;

import org.eclipse.gef.commands.Command;
import org.isistan.flabot.edit.editor.FlabotCommandStack;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;

/**
 * @author $Author: franco $
 *
 */
public class NoExecutionFlabotCommandStack extends FlabotCommandStack {
	
	public NoExecutionFlabotCommandStack(FlabotMultiPageEditor multipageEditor) {		
		super(multipageEditor);
	}
	
	public void execute(Command command) {
		//Do nothing
	}
	
	public void redo() {
		//Do nothing
	}
	
	public void undo() {
		//Do nothing
	}
	
	public void appendToLastAndExecute(Command command) {
		//Do nothing
	}
}