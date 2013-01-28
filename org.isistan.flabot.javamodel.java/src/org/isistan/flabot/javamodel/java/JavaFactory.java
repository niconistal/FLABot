/** * $Id: JavaFactory.java,v 1.4 2006/02/16 01:57:48 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.util.HashMap; import java.util.Map;import org.isistan.flabot.javamodel.CompositeMirrorBuilder;import org.isistan.flabot.javamodel.Factory;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JBooleanPrimitive;import org.isistan.flabot.javamodel.JBytePrimitive;import org.isistan.flabot.javamodel.JCharPrimitive;import org.isistan.flabot.javamodel.JDoublePrimitive;import org.isistan.flabot.javamodel.JFloatPrimitive;import org.isistan.flabot.javamodel.JIntPrimitive;import org.isistan.flabot.javamodel.JLongPrimitive;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.JPrimitive;import org.isistan.flabot.javamodel.JShortPrimitive;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JVoidPrimitive;import org.isistan.flabot.javamodel.ObjectClassOutOfBoundsException;import org.isistan.flabot.javamodel.ObjectMirrorBuilder;public class JavaFactory extends Factory {

	private static JavaFactory instance=null;
	
	public static JavaFactory getInstance() {
		if(instance==null)
			instance=new JavaFactory();
		return instance;
	}
	
	private JavaFactory() {
	}
	
	@Override	protected void initialize() {
		objectBuilder=new ObjectBuilder();		throwableBuilder=new ThrowableBuilder();		memberBuilder=new CompositeMirrorBuilder<JMember>(
				new ObjectMirrorBuilder[] {
						fieldBuilder=new FieldBuilder(),
						behaviorBuilder=new CompositeMirrorBuilder<JBehavior>(
								new ObjectMirrorBuilder[] {
										methodBuilder=new MethodBuilder(),
										constructorBuilder=new ConstructorBuilder()
								}, new BehaviorBuilder()
							)
				}, new MemberBuilder()
			);
		annotationBuilder=new AnnotationBuilder();
		typeBuilder=new CompositeMirrorBuilder<JType>(
				new ObjectMirrorBuilder[] {
						classBuilder=new ClassBuilder(),
						typeVariableBuilder=new TypeVariableBuilder()
				}, new TypeBuilder()
			);
		enumBuilder=new EnumBuilder();
		classLoaderBuilder=new ClassLoaderBuilder();
		genericDeclarationBuilder=new GenericDeclarationBuilder();
		annotatedElementBuilder=new AnnotatedElementBuilder();
		packageBuilder=new PackageBuilder();
		accessibleObjectBuilder=new AccessibleObjectBuilder();		booleanPrimitiveBuilder=new BooleanPrimitiveBuilder();		bytePrimitiveBuilder=new BytePrimitiveBuilder();		charPrimitiveBuilder=new CharPrimitiveBuilder();		doublePrimitiveBuilder=new DoublePrimitiveBuilder();		floatPrimitiveBuilder=new FloatPrimitiveBuilder();		intPrimitiveBuilder=new IntPrimitiveBuilder();		longPrimitiveBuilder=new LongPrimitiveBuilder();		shortPrimitiveBuilder=new ShortPrimitiveBuilder();		voidPrimitiveBuilder=new VoidPrimitiveBuilder();		
		arrayBuilder=new ArrayBuilder();
	}
	public JBooleanPrimitive buildBooleanPrimitive(boolean internalBooleanPrimitive) {		Boolean newBoolean=Boolean.valueOf(internalBooleanPrimitive);		return buildBooleanPrimitive(newBoolean);	}	public JBytePrimitive buildBytePrimitive(byte internalBytePrimitive) {		Byte newByte=Byte.valueOf(internalBytePrimitive);		return buildBytePrimitive(newByte);	}	public JCharPrimitive buildCharPrimitive(char internalCharPrimitive) {		Character newChar=Character.valueOf(internalCharPrimitive);		return buildCharPrimitive(newChar);	}	public JDoublePrimitive buildDoublePrimitive(double internalDoublePrimitive) {		Double newDouble=Double.valueOf(internalDoublePrimitive);		return buildDoublePrimitive(newDouble);	}	public JFloatPrimitive buildFloatPrimitive(float internalFloatPrimitive) {		Float newFloat=Float.valueOf(internalFloatPrimitive);		return buildFloatPrimitive(newFloat);	}	public JIntPrimitive buildIntPrimitive(int internalIntPrimitive) {		Integer newInt=Integer.valueOf(internalIntPrimitive);		return buildIntPrimitive(newInt);	}	public JLongPrimitive buildLongPrimitive(long internalLongPrimitive) {		Long newLong=Long.valueOf(internalLongPrimitive);		return buildLongPrimitive(newLong);	}	public JShortPrimitive buildShortPrimitive(short internalShortPrimitive) {		Short newShort=Short.valueOf(internalShortPrimitive);		return buildShortPrimitive(newShort);	}	public JVoidPrimitive buildVoidPrimitive() {		return buildVoidPrimitive(VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE);	}		private Map<Boolean, Boolean> booleanObjects=new HashMap<Boolean, Boolean>(); 	@Override	public JBooleanPrimitive buildBooleanPrimitive(Object internalBooleanPrimitive) {		if(internalBooleanPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalBooleanPrimitive instanceof Boolean))			throw new ObjectClassOutOfBoundsException(internalBooleanPrimitive);				Boolean newBoolean=(Boolean)internalBooleanPrimitive;		Boolean booleanObject=booleanObjects.get(newBoolean);		if(booleanObject==null) {			booleanObject=newBoolean;			booleanObjects.put(booleanObject, booleanObject);		}		return build(booleanObject, booleanPrimitiveBuilder);	}	private Map<Byte, Byte> byteObjects=new HashMap<Byte, Byte>(); 	@Override	public JBytePrimitive buildBytePrimitive(Object internalBytePrimitive) {		if(internalBytePrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalBytePrimitive instanceof Byte))			throw new ObjectClassOutOfBoundsException(internalBytePrimitive);				Byte newByte=(Byte)internalBytePrimitive;		Byte byteObject=byteObjects.get(newByte);		if(byteObject==null) {			byteObject=newByte;			byteObjects.put(byteObject, byteObject);		}		return build(byteObject, bytePrimitiveBuilder);	}	private Map<Character, Character> charObjects=new HashMap<Character, Character>(); 	@Override	public JCharPrimitive buildCharPrimitive(Object internalCharPrimitive) {		if(internalCharPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalCharPrimitive instanceof Character))			throw new ObjectClassOutOfBoundsException(internalCharPrimitive);				Character newChar=(Character)internalCharPrimitive;		Character charObject=charObjects.get(newChar);		if(charObject==null) {			charObject=newChar;			charObjects.put(charObject, charObject);		}		return build(charObject, charPrimitiveBuilder);	}	private Map<Double, Double> doubleObjects=new HashMap<Double, Double>(); 	@Override	public JDoublePrimitive buildDoublePrimitive(Object internalDoublePrimitive) {		if(internalDoublePrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalDoublePrimitive instanceof Double))			throw new ObjectClassOutOfBoundsException(internalDoublePrimitive);				Double newDouble=(Double)internalDoublePrimitive;		Double doubleObject=doubleObjects.get(newDouble);		if(doubleObject==null) {			doubleObject=newDouble;			doubleObjects.put(doubleObject, doubleObject);		}		return build(doubleObject, doublePrimitiveBuilder);	}	private Map<Float, Float> floatObjects=new HashMap<Float, Float>(); 	@Override	public JFloatPrimitive buildFloatPrimitive(Object internalFloatPrimitive) {		if(internalFloatPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalFloatPrimitive instanceof Float))			throw new ObjectClassOutOfBoundsException(internalFloatPrimitive);				Float newFloat=(Float)internalFloatPrimitive;		Float floatObject=floatObjects.get(newFloat);		if(floatObject==null) {			floatObject=newFloat;			floatObjects.put(floatObject, floatObject);		}		return build(floatObject, floatPrimitiveBuilder);	}	private Map<Integer, Integer> intObjects=new HashMap<Integer, Integer>(); 	@Override	public JIntPrimitive buildIntPrimitive(Object internalIntPrimitive) {		if(internalIntPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalIntPrimitive instanceof Integer))			throw new ObjectClassOutOfBoundsException(internalIntPrimitive);				Integer newInt=(Integer)internalIntPrimitive;		Integer intObject=intObjects.get(newInt);		if(intObject==null) {			intObject=newInt;			intObjects.put(intObject, intObject);		}		return build(intObject, intPrimitiveBuilder);	}	private Map<Long, Long> longObjects=new HashMap<Long, Long>(); 	@Override	public JLongPrimitive buildLongPrimitive(Object internalLongPrimitive) {		if(internalLongPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalLongPrimitive instanceof Long))			throw new ObjectClassOutOfBoundsException(internalLongPrimitive);				Long newLong=(Long)internalLongPrimitive;		Long longObject=longObjects.get(newLong);		if(longObject==null) {			longObject=newLong;			longObjects.put(longObject, longObject);		}		return build(longObject, longPrimitiveBuilder);	}	private Map<Short, Short> shortObjects=new HashMap<Short, Short>(); 	@Override	public JShortPrimitive buildShortPrimitive(Object internalShortPrimitive) {		if(internalShortPrimitive==null)			throw new IllegalArgumentException("Internal primitive cannot be null");		if(!(internalShortPrimitive instanceof Short))			throw new ObjectClassOutOfBoundsException(internalShortPrimitive);				Short newShort=(Short)internalShortPrimitive;		Short shortObject=shortObjects.get(newShort);		if(shortObject==null) {			shortObject=newShort;			shortObjects.put(shortObject, shortObject);		}		return build(shortObject, shortPrimitiveBuilder);	}		/**	 * Builds a JVoidPrimitive, internalVoidPrimitive should be null or	 * VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE	 */	@Override	public JVoidPrimitive buildVoidPrimitive(Object internalVoidPrimitive) {		if(internalVoidPrimitive==null) {			internalVoidPrimitive=VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE;		}		if(internalVoidPrimitive!=VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE)			throw new IllegalArgumentException("Internal void primitive should be null or VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE");				return build(internalVoidPrimitive, voidPrimitiveBuilder);	}		/**	 * Builds a JPrimitive from the give internal primitive wrapper (Boolean, Integer,	 * etc...). For void type, internalPrimitive should be	 * VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE	 * @param internalPrimitive	 * @return	 */	public JPrimitive buildPrimitive(Object internalPrimitive) {		if(internalPrimitive==null) {			throw new IllegalArgumentException("InternalPrimitive cannot be null");		}		if(internalPrimitive instanceof Boolean) {			return buildBooleanPrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Byte) {			return buildBytePrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Character) {			return buildCharPrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Double) {			return buildDoublePrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Float) {			return buildFloatPrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Integer) {			return buildIntPrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Long) {			return buildLongPrimitive(internalPrimitive);		}		if(internalPrimitive instanceof Short) {			return buildShortPrimitive(internalPrimitive);		}		if(internalPrimitive==VoidPrimitiveImpl.INTERNAL_VOID_PRIMITIVE) {			return buildVoidPrimitive(internalPrimitive);		}		throw new IllegalArgumentException("InternalPrimitive is not a primitive wrapper type");	}
}
