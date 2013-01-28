/** * $Id: Factory.java,v 1.8 2006/03/24 00:33:55 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;
import java.lang.ref.WeakReference;import java.util.HashMap;import java.util.Map;import org.isistan.flabot.util.custommap.ExactHashProvider;import org.isistan.flabot.util.custommap.HashProvider;import org.isistan.flabot.util.custommap.WeakCustomMap;public abstract class Factory {
	public Factory() {
		initialize();		builders=new ObjectMirrorBuilder<?>[] {				objectBuilder,				memberBuilder,				fieldBuilder,				behaviorBuilder,				methodBuilder,				constructorBuilder,				annotationBuilder,				typeBuilder,				classBuilder,				typeVariableBuilder,				enumBuilder,				classLoaderBuilder,				genericDeclarationBuilder,				annotatedElementBuilder,				packageBuilder,				accessibleObjectBuilder,				throwableBuilder,				booleanPrimitiveBuilder,				bytePrimitiveBuilder,				charPrimitiveBuilder,				doublePrimitiveBuilder,				floatPrimitiveBuilder,				intPrimitiveBuilder,				longPrimitiveBuilder,				shortPrimitiveBuilder,				voidPrimitiveBuilder			};
	}
	
	protected abstract void initialize();	
	public <T extends JObject> T build(Object object, ObjectMirrorBuilder<T> builder) {
		synchronized(preBuilt) {			if(builder==null)
				throw new NotSupportedFeatureException();			if(object==null)
				return null;
			
			
			T jObject=null;
			if(builder.accepts(object)) {
				jObject=getPreBuilt(object, builder);
				if(jObject==null) {
					jObject=builder.build(object);
				} else {
					return jObject;
				}
			}
			if(jObject!=null) {
				built(object, jObject, builder);
				return jObject;
			} else {
				throw new ObjectClassOutOfBoundsException(object);
			}		}
	}
	
	public <T extends JObject> JArray<? extends T> buildArray(Object object, ObjectMirrorBuilder<T> componentBuilder) {		synchronized(preBuiltArrays) {
			if(arrayBuilder==null)
				throw new NotSupportedFeatureException();
			if(componentBuilder==null)
				throw new NotSupportedFeatureException();
			if(object==null)
				return null;
	
			JArray<? extends T> jArray=null;
			if(arrayBuilder.accepts(object)) {
				jArray=getPreBuiltArray(object, componentBuilder);
				if(jArray==null) {
					jArray=arrayBuilder.build(object, componentBuilder);
				} else {
					return jArray;
				}
			}
			if(jArray!=null) {
				arrayBuilt(object, jArray, componentBuilder);
				return jArray;
			} else {
				throw new ObjectClassOutOfBoundsException(object);
			}		}
	}
	
	private Map<ObjectMirrorBuilder<?>, WeakCustomMap<Object, WeakReference<JObject>>> preBuilt=new HashMap<ObjectMirrorBuilder<?>, WeakCustomMap<Object, WeakReference<JObject>>>();
	private Map<ObjectMirrorBuilder<?>, WeakCustomMap<Object, WeakReference<JArray<?>>>> preBuiltArrays=new HashMap<ObjectMirrorBuilder<?>, WeakCustomMap<Object, WeakReference<JArray<?>>>>();
	private HashProvider<Object> exactHashProvider=new ExactHashProvider<Object>();
		private Map<Object, Long> ids=new WeakCustomMap<Object, Long>(exactHashProvider);	private long nextId=0;	public long getId(Object object) {		synchronized(ids) {			Long id=ids.get(object);			if(id==null) {				id=Long.valueOf(nextId++);				ids.put(object, id);			}			return id.longValue();		}			}	
	public WeakCustomMap<Object, WeakReference<JObject>> getBuilderMap(ObjectMirrorBuilder<? extends JObject> builder) {
		WeakCustomMap<Object, WeakReference<JObject>> builderMap=preBuilt.get(builder);
		if(builderMap==null) {
			builderMap=new WeakCustomMap<Object, WeakReference<JObject>>(exactHashProvider);
			preBuilt.put(builder, builderMap);
		}
		return builderMap;
	}

	protected <T extends JObject> T getPreBuilt(Object object, ObjectMirrorBuilder<T> builder) {		Map<Object, WeakReference<JObject>> builderMap=getBuilderMap(builder);
		WeakReference<JObject> ref=builderMap.get(object);		if(ref==null) {			return null;		}		return (T)ref.get();
	}

	protected <T extends JObject> void built(Object object, T jObject, ObjectMirrorBuilder<T> builder) {
		WeakCustomMap<Object, WeakReference<JObject>> builderMap=getBuilderMap(builder);
		builderMap.put(object, new WeakReference<JObject>(jObject));
	}
	
	public WeakCustomMap<Object, WeakReference<JArray<?>>> getArrayBuilderMap(ObjectMirrorBuilder<? extends JObject> builder) {
		WeakCustomMap<Object, WeakReference<JArray<?>>> builderMap=preBuiltArrays.get(builder);
		if(builderMap==null) {
			builderMap=new WeakCustomMap<Object, WeakReference<JArray<?>>>(exactHashProvider);
			preBuiltArrays.put(builder, builderMap);
		}
		return builderMap;
	}

	protected <T extends JObject> JArray<? extends T> getPreBuiltArray(Object object, ObjectMirrorBuilder<T> componentBuilder) {
		WeakCustomMap<Object, WeakReference<JArray<?>>> builderMap=getArrayBuilderMap(componentBuilder);		WeakReference<JArray<?>> ref=builderMap.get(object);		if(ref==null) {			return null;		}		return (JArray<? extends T>)ref.get();
	}


	protected <T extends JObject> void arrayBuilt(Object object, JArray<? extends T> jArray, ObjectMirrorBuilder<T> componentBuilder) {
		WeakCustomMap<Object, WeakReference<JArray<?>>> builderMap=getArrayBuilderMap(componentBuilder);
		builderMap.put(object, new WeakReference<JArray<?>>(jArray));
	}
	
	protected ObjectMirrorBuilder<? extends JObject> objectBuilder;
	protected ObjectMirrorBuilder<? extends JMember> memberBuilder;
	protected ObjectMirrorBuilder<? extends JField> fieldBuilder;
	protected ObjectMirrorBuilder<? extends JBehavior> behaviorBuilder;
	protected ObjectMirrorBuilder<? extends JMethod> methodBuilder;
	protected ObjectMirrorBuilder<? extends JConstructor> constructorBuilder;
	protected ObjectMirrorBuilder<? extends JAnnotation> annotationBuilder;
	protected ObjectMirrorBuilder<? extends JType> typeBuilder;
	protected ObjectMirrorBuilder<? extends JClass> classBuilder;
	protected ObjectMirrorBuilder<? extends JTypeVariable> typeVariableBuilder;
	protected ObjectMirrorBuilder<? extends JEnum> enumBuilder;
	protected ObjectMirrorBuilder<? extends JClassLoader> classLoaderBuilder;
	protected ObjectMirrorBuilder<? extends JGenericDeclaration> genericDeclarationBuilder;
	protected ObjectMirrorBuilder<? extends JAnnotatedElement> annotatedElementBuilder;
	protected ObjectMirrorBuilder<? extends JPackage> packageBuilder;
	protected ObjectMirrorBuilder<? extends JAccessibleObject> accessibleObjectBuilder;	protected ObjectMirrorBuilder<? extends JThrowable> throwableBuilder;	protected ObjectMirrorBuilder<? extends JBooleanPrimitive> booleanPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JBytePrimitive> bytePrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JCharPrimitive> charPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JDoublePrimitive> doublePrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JFloatPrimitive> floatPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JIntPrimitive> intPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JLongPrimitive> longPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JShortPrimitive> shortPrimitiveBuilder;	protected ObjectMirrorBuilder<? extends JVoidPrimitive> voidPrimitiveBuilder;	private ObjectMirrorBuilder<?>[] builders;	protected ArrayMirrorBuilder arrayBuilder;

	public ObjectMirrorBuilder<? extends JObject> getObjectBuilder() {
		return objectBuilder;
	}
	public ObjectMirrorBuilder<? extends JMember> getMemberBuilder() {
		return memberBuilder;
	}
	public ObjectMirrorBuilder<? extends JField> getFieldBuilder() {
		return fieldBuilder;
	}
	public ObjectMirrorBuilder<? extends JBehavior> getBehaviorBuilder() {
		return behaviorBuilder;
	}
	public ObjectMirrorBuilder<? extends JMethod> getMethodBuilder() {
		return methodBuilder;
	}
	public ObjectMirrorBuilder<? extends JConstructor> getConstructorBuilder() {
		return constructorBuilder;
	}
	public ObjectMirrorBuilder<? extends JAnnotation> getAnnotationBuilder() {
		return annotationBuilder;
	}
	public ObjectMirrorBuilder<? extends JType> getTypeBuilder() {
		return typeBuilder;
	}
	public ObjectMirrorBuilder<? extends JClass> getClassBuilder() {
		return classBuilder;
	}
	public ObjectMirrorBuilder<? extends JTypeVariable> getTypeVariableBuilder() {
		return typeVariableBuilder;
	}
	public ObjectMirrorBuilder<? extends JEnum> getAnumBuilder() {
		return enumBuilder;
	}
	public ObjectMirrorBuilder<? extends JClassLoader> getClassLoaderBuilder() {		return classLoaderBuilder;	}	public ObjectMirrorBuilder<? extends JGenericDeclaration> getGenericDeclarationBuilder() {
		return genericDeclarationBuilder;
	}
	public ObjectMirrorBuilder<? extends JAnnotatedElement> getAnnotatedElementBuilder() {
		return annotatedElementBuilder;
	}
	public ObjectMirrorBuilder<? extends JPackage> getPackageBuilder() {
		return packageBuilder;
	}
	public ObjectMirrorBuilder<? extends JAccessibleObject> getAccessibleObjectBuilder() {
		return accessibleObjectBuilder;
	}
	public ObjectMirrorBuilder<? extends JThrowable> getThrowableBuilder() {		return throwableBuilder;	}	public ObjectMirrorBuilder<? extends JBooleanPrimitive> getBooleanPrimitiveBuilder() {		return booleanPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JBytePrimitive> getBytePrimitiveBuilder() {		return bytePrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JCharPrimitive> getCharPrimitiveBuilder() {		return charPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JDoublePrimitive> getDoublePrimitiveBuilder() {		return doublePrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JFloatPrimitive> getFloatPrimitiveBuilder() {		return floatPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JIntPrimitive> getIntPrimitiveBuilder() {		return intPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JLongPrimitive> getLongPrimitiveBuilder() {		return longPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JShortPrimitive> getShortPrimitiveBuilder() {		return shortPrimitiveBuilder;	}	public ObjectMirrorBuilder<? extends JVoidPrimitive> getVoidPrimitiveBuilder() {		return voidPrimitiveBuilder;	}		public ArrayMirrorBuilder getArrayBuilder() {		return arrayBuilder;	}
	public JObject buildObject(Object internalObject) {
		return build(internalObject, objectBuilder);
	}
	public JMember buildMember(Object internalObject) {
		return build(internalObject, memberBuilder);
	}
	public JField buildField(Object internalField) {
		return build(internalField, fieldBuilder);
	}
	public JBehavior buildBehavior(Object internalBehavior) {
		return build(internalBehavior, behaviorBuilder);
	}
	public JMethod buildMethod(Object internalMethod) {
		return build(internalMethod, methodBuilder);
	}
	public JConstructor buildConstructor(Object internalConstructor) {
		return build(internalConstructor, constructorBuilder);
	}
	public JAnnotation buildAnnotation(Object internalAnnotation) {
		return build(internalAnnotation, annotationBuilder);
	}
	public JType buildType(Object internalType) {
		return build(internalType, typeBuilder);
	}
	public JClass buildClass(Object internalClass) {
		return build(internalClass, classBuilder);
	}
	public JTypeVariable buildTypeVariable(Object internalTypeVariable) {
		return build(internalTypeVariable, typeVariableBuilder);
	}
	public JEnum buildEnum(Object internalEnum) {
		return build(internalEnum, enumBuilder);
	}
	public JClassLoader buildClassLoader(Object internalClassLoader) {
		return build(internalClassLoader, classLoaderBuilder);
	}
	public JGenericDeclaration buildGenericDeclaration(Object internalGenericDeclaration) {
		return build(internalGenericDeclaration, genericDeclarationBuilder);
	}
	public JAnnotatedElement buildAnnotatedElement(Object internalAnnotatedElement) {
		return build(internalAnnotatedElement, annotatedElementBuilder);
	}
	public JPackage buildPackage(Object internalPackage) {
		return build(internalPackage, packageBuilder);
	}
	public JAccessibleObject buildAccessibleObject(Object internalAccessibleObject) {		return build(internalAccessibleObject, accessibleObjectBuilder);	}	public JThrowable buildThrowable(Object internalThrowable) {		return build(internalThrowable, throwableBuilder);	}	public JBooleanPrimitive buildBooleanPrimitive(Object internalBooleanPrimitive) {		if(internalBooleanPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalBooleanPrimitive, booleanPrimitiveBuilder);	}	public JBytePrimitive buildBytePrimitive(Object internalBytePrimitive) {		if(internalBytePrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalBytePrimitive, bytePrimitiveBuilder);	}	public JCharPrimitive buildCharPrimitive(Object internalCharPrimitive) {		if(internalCharPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalCharPrimitive, charPrimitiveBuilder);	}	public JDoublePrimitive buildDoublePrimitive(Object internalDoublePrimitive) {		if(internalDoublePrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalDoublePrimitive, doublePrimitiveBuilder);	}	public JFloatPrimitive buildFloatPrimitive(Object internalFloatPrimitive) {		if(internalFloatPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalFloatPrimitive, floatPrimitiveBuilder);	}	public JIntPrimitive buildIntPrimitive(Object internalIntPrimitive) {		if(internalIntPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalIntPrimitive, intPrimitiveBuilder);	}	public JLongPrimitive buildLongPrimitive(Object internalLongPrimitive) {		if(internalLongPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalLongPrimitive, longPrimitiveBuilder);	}	public JShortPrimitive buildShortPrimitive(Object internalShortPrimitive) {		if(internalShortPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalShortPrimitive, shortPrimitiveBuilder);	}	public JVoidPrimitive buildVoidPrimitive(Object internalVoidPrimitive) {		if(internalVoidPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		return build(internalVoidPrimitive, voidPrimitiveBuilder);	}	public JArray<? extends JObject> buildArray(Object internalArray) {
		return buildArray(internalArray, objectBuilder);
	}		public static <T extends JObject> JArray<T> buildModelArray(Object[] jObjectArray) {		if(jObjectArray==null)			return null;		return new ModelArrayImpl<T>(jObjectArray);	}
}
