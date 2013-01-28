package org.isistan.flabot.edit.editor.dialogs.consistency;

import java.util.Comparator;

import org.eclipse.jface.viewers.ISelectionProvider;
//import org.eclipse.pde.internal.runtime.logview.EventDetailsDialog;
//import org.eclipse.pde.internal.runtime.logview.LogEntry;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.internal.views.log.EventDetailsDialog;
import org.eclipse.ui.internal.views.log.LogEntry;
import org.eclipse.swt.widgets.Shell;

public class ConsistencyDetailsDialog extends EventDetailsDialog {
	
	public ConsistencyDetailsDialog(Shell parentShell, LogEntry logEntry, ISelectionProvider provider, Comparator comparator, IMemento memento) {
		super(parentShell, logEntry, provider, comparator, memento);
	}
}
