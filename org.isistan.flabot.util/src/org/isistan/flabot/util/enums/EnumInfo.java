/**

import java.util.LinkedList;
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
	
	public T getOption(int ordinal) {
}