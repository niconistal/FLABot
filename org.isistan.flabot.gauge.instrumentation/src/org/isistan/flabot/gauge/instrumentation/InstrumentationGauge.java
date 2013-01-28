/** * $Id: InstrumentationGauge.java,v 1.3 2006/02/16 01:57:48 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge.instrumentation;


import java.util.HashMap;import java.util.Map;import javassist.NotFoundException;import org.isistan.flabot.gauge.Gauge;import org.isistan.flabot.instrumentation.InstrumentationUtils;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.java.JavaFactory;public class InstrumentationGauge extends Gauge {
	/**
	 * Attributes map
	 */
	private Map<AttributeName, Object> attributes=null;

	/**
	 * Determine when the gauge attributes where or where not transformed to javamodel
	 */
	private boolean prototype=true;

	
	/**
	 * The classloader to be used when the gauge attributes are converted to java
	 */
	private ClassLoader loader;

	/**
	 * The name of the class where the gauge is allocated
	 */
	private String baseClassName;

	
	/**
	 * Constructs a Gauge with an associated gauge prototype 
	 * @param type
	 * @param prototypeAttributes
	 */
	InstrumentationGauge(Type type, Map<AttributeName, Object> attributes, ClassLoader loader, String baseClassnName) {
		super(type);
		this.attributes=attributes;
		this.loader=loader;
		this.baseClassName=baseClassnName;
	}
	@Override	public Object getAttribute(AttributeName name) {		if(prototype)			buildGauge();		return attributes.get(name);	}		@Override	public boolean hasAttribute(AttributeName name) {		return attributes.containsKey(name);	}


	@Override
	public Map<AttributeName, Object> getAttributes() {
		if(prototype)
			buildGauge();		Map<AttributeName, Object> attributes=new HashMap<AttributeName, Object>();		attributes.putAll(this.attributes);		return attributes;
	}
	
	private void buildGauge() {
		try {
			Class baseClass=loader.loadClass(this.baseClassName);

			Map<AttributeName, Object> gaugeAttributes=
				new HashMap<AttributeName, Object>();
			
			//transform the behavior
			JBehavior prototypeBehavior=(JBehavior)attributes.get(AttributeName.BEHAVIOR);
			JBehavior javaBehavior=getJavaBehavior(baseClass, prototypeBehavior);
			gaugeAttributes.put(AttributeName.BEHAVIOR,
					javaBehavior);
			//transform the target class
			JClass targetPrototypeClass=(JClass)attributes.get(AttributeName.TARGET_CLASS);
			if(targetPrototypeClass!=null) {
				gaugeAttributes.put(AttributeName.TARGET_CLASS,
						getJavaClass(baseClass, targetPrototypeClass));
			}
			//transform the target behavior
			JBehavior targetBehavior=(JBehavior)attributes.get(AttributeName.TARGET_BEHAVIOR);
			if(targetBehavior!=null) {
				if(targetBehavior==prototypeBehavior) {
					gaugeAttributes.put(AttributeName.TARGET_BEHAVIOR,
						javaBehavior);
				} else {
					gaugeAttributes.put(AttributeName.TARGET_BEHAVIOR,
							getJavaBehavior(getClass(baseClass, targetBehavior.getDeclaringClass()), targetBehavior));
				}
			}
			//transform the target field
			JField targetField=(JField)attributes.get(AttributeName.TARGET_FIELD);
			if(targetField!=null) {
				gaugeAttributes.put(AttributeName.TARGET_FIELD,
						getJavaField(getClass(baseClass, targetField.getDeclaringClass()), targetField));
			}
			this.attributes=gaugeAttributes;
			this.prototype=false;
		} catch (Throwable e) {
			String message="Exception while building gauge: "+ e.getClass().getName() + ":" + e.getMessage();
			System.out.println(message);
			e.printStackTrace();
			throw new RuntimeException(message, e);
		}
	}
	
	/**
	 * returns the class defined by desiredClass using the classloader that loaded the baseClass
	 * @param baseClass
	 * @param desiredClassName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotFoundException 
	 */
	private Class getClass(Class baseClass, JClass desiredClass) throws ClassNotFoundException {
		Class clazz=InstrumentationUtils.getPrimitiveType(desiredClass.getName());
		if(clazz!=null) {
			return clazz; 
		} else if(baseClass.getName().equals(desiredClass.getName())) {
			return baseClass;
		} else {
			ClassLoader loader=baseClass.getClassLoader();
			if(loader==null)
				loader=ClassLoader.getSystemClassLoader();
			if(desiredClass.isPrimitive())
				return InstrumentationUtils.getPrimitiveType(desiredClass.getName());
			else
				return loader.loadClass(Util.getClassLoaderName(desiredClass.getName()));
		}
	}
	
	private JClass getJavaClass(Class baseClass, JClass prototypeClass) throws ClassNotFoundException {
		return JavaFactory.getInstance().buildClass(getClass(baseClass, prototypeClass));
	}


	/**
	 * Returns the java behavior from its equivalent prototype behavior 
	 * @param clazz
	 * @param behavior
	 * @return
	 * @throws NotFoundException
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws ClassNotFoundException 
	 */
	private JBehavior getJavaBehavior(Class clazz, JBehavior prototypeBehavior) throws SecurityException, NoSuchMethodException, ClassNotFoundException {
		JArray<? extends JClass> prototypeParameterTypes=prototypeBehavior.getParameterTypes();
		Class[] parameterTypes=new Class[prototypeParameterTypes.length()];
		for (int i = 0; i < parameterTypes.length; i++) {
			parameterTypes[i]=getClass(clazz, prototypeParameterTypes.at(i));
		}
		if(prototypeBehavior instanceof JConstructor) {
			return JavaFactory.getInstance().buildBehavior(clazz.getDeclaredConstructor(parameterTypes));
		} else {
			return JavaFactory.getInstance().buildBehavior(clazz.getDeclaredMethod(prototypeBehavior.getName(), parameterTypes));
		}
	}
	
	/**
	 * Returns the java field from its equivalent prototype field 
	 * @param javaClass
	 * @param targetField
	 * @return
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	private JField getJavaField(Class clazz, JField prototypeField) throws SecurityException, NoSuchFieldException {
		return JavaFactory.getInstance().buildField(clazz.getDeclaredField(prototypeField.getName()));
	}	
}
