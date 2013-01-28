/**
 * $Id: SorterToTable.java,v 1.7 2006/03/21 02:57:52 franco Exp $
 *
 */

package org.isistan.flabot.util;

import java.text.Collator;
import java.util.Hashtable;
import java.util.Locale;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.FlabotPlugin;

/**
 * @author $Author: franco $
 *
 */
public class SorterToTable{
	  
	  private int column;
	  private Hashtable direction;
	  private Table table;
	  private ValidatorSorterTable validator;
	  private Image ascending = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/ascendingOrder.gif").createImage(); //$NON-NLS-1$
	  private Image descending = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/descendingOrder.gif").createImage(); //$NON-NLS-1$
	  private boolean sorted=false;
	  
	  public SorterToTable(Table table, ValidatorSorterTable validator) {
			this.table = table;
			direction = new Hashtable();
			for (int i=0; i < table.getColumnCount(); i++){
				direction.put(i,0);
			}
			this.validator = validator;
		}

	  /**
	   * Compares two Player objects
	   * 
	   * @param obj1 the first Player
	   * @param obj2 the second Player
	   * @return int
	   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	   */
	  
	  public void order() {
		sorted=true;
	    if ((Integer)direction.get(column) == 1){
	    	orderDescending();
	    	deleteImageOtherColumn();
	    	table.getColumn(column).setImage(descending);
	    	table.getColumn(0).setWidth(table.getColumn(0).getWidth());
	    }
	    else{
	    	orderAscending();
	    	deleteImageOtherColumn();
	    	table.getColumn(column).setImage(ascending);
	    	table.getColumn(0).setWidth(table.getColumn(0).getWidth());
	    }
	  }

	  private void deleteImageOtherColumn() {
		  for (int i=0; i < table.getColumnCount(); i++){
				table.getColumn(i).setImage(null);
			}
		
	}

	/**
	   * Reverses the direction
	   */
	  public void reverseDirection() {
	    direction.put(column,1 -(Integer)direction.get(column));
	  }
	  
	  private void orderDescending (){
		    validator.initOrder();
	        TableItem[] items = table.getItems();
	        Collator collator = Collator.getInstance(Locale.getDefault());
	        for (int i = 1; i < items.length; i++) {
	          String value1 = validator.getText(items[i],column);
	          for (int j = 0; j < i; j++) {
	            String value2 = validator.getText(items[j],column);
	            if (collator.compare(value1, value2) < 0) {
	              String[] values = validator.getValues(items[i]);
	              Object valueData = items[i].getData();
	              boolean ischecked = items[i].getChecked();
	              validator.setObejctItem(items[i]);
	              items[i].dispose();
	              TableItem item = new TableItem(table, SWT.NONE, j);
	              validator.setValuesToItem(table,item,values,valueData,items[j]);
	              if (validator.existsCheckBox())
	  		    	item.setChecked(ischecked);
	  		      else
	  		    	item.setChecked(false);
	              items = table.getItems();
	              break;
	            }
	          }
	        }
	      }
	  
	  private void orderAscending (){
	        TableItem[] items = table.getItems();
	        
	        Collator collator = Collator.getInstance(Locale.getDefault());
	        for (int i = 1; i < items.length; i++) {
	          String value1 = validator.getText(items[i],column);
	          for (int j = 0; j < i; j++) {
	            String value2 = validator.getText(items[j],column);
	            if (collator.compare(value1, value2) > 0) {
	              String[] values =  validator.getValues(items[i]);
	              Object valueData = items[i].getData();
	              validator.setObejctItem(items[i]);
	              boolean ischecked = items[i].getChecked();
	              items[i].dispose();
	              TableItem item = new TableItem(table, SWT.NONE, j);
	              validator.setValuesToItem(table,item,values,valueData,items[j]);
	              if (validator.existsCheckBox())
		  		    	item.setChecked(ischecked);
	              items = table.getItems();
	              break;
	            }
	          }
	        }
	      }

	  /**
	   * Sets the column for sorting
	   * 
	   * @param column the column
	   */
	  public void setColumn(TableColumn column) {
		int i = 0; 
		while (!table.getColumns()[i].equals(column)) {
			i++;
			}
	    this.column = i;
	  }
	  
	  public ValidatorSorterTable getValidator(){
		  return validator;
	  }

	public boolean isSorted() {
		return sorted;
	}
	  
	}
