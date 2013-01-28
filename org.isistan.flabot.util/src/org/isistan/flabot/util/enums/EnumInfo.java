/** * $Id: EnumInfo.java,v 1.3 2006/03/27 21:39:42 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.enums;

import java.util.LinkedList;import java.util.List;class EnumInfo<T extends Enum> {
	private List<T> options=new LinkedList<T>();
	private T min=null;
	private T max=null;
	
	int addOption(T option) {
		if(min==null)
			min=option;
		max=option;
		options.add(option);
		return options.size()-1;
	}
	
	public T getMinimum() {
		return min;
	}
	
	public T getMaximum() {
		return max;
	}
	
	public T getOption(int ordinal) {		if(ordinal<0 || ordinal>= options.size())			return null;		else			return options.get(ordinal);	}	public T getOption(String name) {		for (T option : options) {			if(name.equals(option.getName())) {				return option; 			}		}		return null;	}	public Enum[] getOptions() {		return options.toArray(new Enum[options.size()]);	}
}
