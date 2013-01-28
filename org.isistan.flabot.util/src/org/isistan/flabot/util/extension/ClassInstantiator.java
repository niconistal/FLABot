package org.isistan.flabot.util.extension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassInstantiator<T> {

	private Class<?>[][] parameterTypes;
	
	public ClassInstantiator(Class<?>[]... parameterTypes) {
		if(parameterTypes==null || parameterTypes.length==0) {
			parameterTypes=new Class<?>[1][0];
		}
		this.parameterTypes=parameterTypes;
	}
	
	public T instantiate(Class<? extends T> clazz, Object[]... arguments) throws NoMatchingConstructorFoundException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Constructor<? extends T> constructor=null;
		int i;
		for(i=0; i<this.parameterTypes.length; i++) {
			Class<?>[] parameterTypes=this.parameterTypes[i];
			constructor=getConstructor(clazz, parameterTypes);
			if(constructor!=null)
				break;
			
		}
		if(constructor!=null) {
			if(arguments==null || arguments.length==0) {
				arguments=new Object[1][0];
			}
			return constructor.newInstance(arguments[i]);
		} else {
			throw new NoMatchingConstructorFoundException(clazz);
		}
	}

	private Constructor<? extends T> getConstructor(Class<? extends T> clazz, Class<?>[] parameterTypes) {
		try {
			return clazz.getConstructor((Class[])parameterTypes);
		} catch (SecurityException e) {
			throw e;
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
}
