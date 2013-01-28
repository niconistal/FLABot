/** * $Id: Interceptor.java,v 1.4 2006/02/04 03:32:23 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.instrumentation.classloader;

import java.nio.ByteBuffer;public class Interceptor {
	private static class InstrumentorsList {
		private static final int INIT_SIZE = 5;
		private int size=0;
		private Instrumentor[] instrumentors=new Instrumentor[INIT_SIZE];
		
		public void add(Instrumentor instrumentor) {
			checkFull();
			instrumentors[size++]=instrumentor;
		}
		public Instrumentor get(int index) {
			if(index>=size) {
				throw new IndexOutOfBoundsException(index+">="+size);
			}
			return instrumentors[index];
						
		}

		public Instrumentor remove(int index) {
			if(index>=size) {
				throw new IndexOutOfBoundsException(index+">="+size);
			}
			Instrumentor instrumentor=instrumentors[index];
			instrumentors[index]=null;
			return instrumentor;
						
		}
		
		public int size() {
			return size;
		}
			

		private void checkFull() {
			if(size==instrumentors.length) {
				Instrumentor[] newInstrumentors=new Instrumentor[instrumentors.length*2];
				for (int i = 0; i < instrumentors.length; i++) {
					newInstrumentors[i]=instrumentors[i];
				}
				instrumentors=newInstrumentors;
			}
			
		}
		
	}
	
	private static InstrumentorsList instrumentors=new InstrumentorsList();
	
	public static void addInstrumentor(Instrumentor instrumentor) {
		instrumentors.add(instrumentor);
	}
	
	public static byte[] instrument(ClassLoader loader, String name, ByteBuffer buffer, int base, int length) {
		try {
			byte[] bytecode=new byte[length];
			buffer.get(bytecode, base, length);
			return instrument(loader, name, bytecode, 0, bytecode.length);
		} catch(Throwable e) {
			System.out.println(e);
			e.printStackTrace();			throw new RuntimeException(e);
		}
	}
    
	public static byte[] instrument(ClassLoader loader, String name, byte[] bytecode, int base, int length) {
		try {
	    	byte[] trimedBytecode=null;
	    	if(base==0 && length==bytecode.length) {
	    		trimedBytecode=bytecode;
	    	} else {
	    		trimedBytecode=new byte[bytecode.length];
	    		for(int i=0; i<trimedBytecode.length; i++) {
	    			trimedBytecode[i]=bytecode[base+i];
	    		}
	    		bytecode=trimedBytecode;
	    	}
	    	byte[] newBytecode=null;
			if(!isForbiddenClass(name)) {
				newBytecode = instrument(loader, name, bytecode);
			}
	    	if(newBytecode==null) {
	    		return trimedBytecode;
	    	} else {
				return newBytecode;
	    	}
		} catch(Throwable e) {
			System.out.println(e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
    
	private static byte[] instrument(ClassLoader loader, String name, byte[] bytecode) throws InstrumentationException {
		byte[] newBytecode;
		int size=instrumentors.size();
		for(int i=0; i<size; i++) {
			Instrumentor instrumentor=instrumentors.get(i);
			if(instrumentor!=null) {
				newBytecode=instrumentor.instrument(loader, name, bytecode);
				if(newBytecode!=null) {					bytecode=newBytecode;
				}
			}
		}
		return bytecode;
	}

	private static boolean isForbiddenClass(String className) {
		if (className.startsWith("["))
			return true;	
		if (className.endsWith("]"))
			return true;
		if (className.startsWith("org.isistan.flabot.instrumentation."))			return true;		if (className.startsWith("org.isistan.flabot.gauge.instrumentation."))			return true;		if (className.startsWith("org.isistan.flabot.gauge."))			return true;		if (className.startsWith("org.isistan.flabot.javamodel.javassist."))			return true;		if (className.startsWith("org.isistan.flabot.javamodel."))			return true;		if (className.startsWith("org.isistan.flabot.util.custommap."))			return true;		if (className.startsWith("org.isistan.flabot.instrumentation.classloader."))			return true;		if (className.startsWith("org.isistan.flabot.instrumentation.launcher."))			return true;		if (className.startsWith("org.isistan.flabot.util.enums."))			return true;				if (className.startsWith("javassist."))
			return true;
		
		return false;
	}
	
}
