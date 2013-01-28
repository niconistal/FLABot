package org.isistan.flabot.util;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class DefualtValidatorSorter implements ValidatorSorterTable {
	
	private boolean checkBox;
	private int values;

	public DefualtValidatorSorter (boolean checkBox, int values){
		this.checkBox = checkBox;
		this.values = values;
	}
	
	public String[] getValues(TableItem item) {
		String[] result = new String[values];
		for (int i=0; i < values; i++){
			  result[i] = item.getText(i);
		  }
		return result;
	}

	public boolean existsCheckBox() {
		return checkBox;
	}

	public boolean validateCheckBox(TableItem item) {
		 return false;
	}
	
	public void setCountValues (int values){
		this.values = values;
	}
	
	public void setExistsCheckBox (boolean check){
		this.checkBox = check;
	}
	
	public void setObejct (Object object){}

	public String getText(TableItem item, int column) {
		return item.getText(column);
	}

	public void setValuesToItem(Table table, TableItem item, String[] values, Object valueData, TableItem newitem) {
		item.setText(values);
        item.setData(valueData);
        if (newitem != null)
        	item.setImage(newitem.getImage());	
	}

	public void setObejctItem(TableItem item) {
		
	}

	public void initOrder() {}
	
}