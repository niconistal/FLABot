/**
 * $Id: ValidatorSorterTable.java,v 1.2 2006/02/02 00:04:29 apersson Exp $
 *
 */

package org.isistan.flabot.util;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author $Author: apersson $
 *
 */
public interface ValidatorSorterTable {
	
	String[] getValues (TableItem item);
	
	boolean existsCheckBox ();
	
	boolean validateCheckBox (TableItem item);
	
	void setCountValues (int values);
		
	void setExistsCheckBox (boolean check);
		
	void setObejct (Object object);

	String getText(TableItem item, int column);

	void setValuesToItem(Table table, TableItem item,String[] values, Object valueData, TableItem newitem);

	void setObejctItem(TableItem item);

	void initOrder();
	
}
