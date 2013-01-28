package org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public interface ItemProvider {
	public TableItem decorateError(Table table, String message);
}
