package org.isistan.flabot.javamodel;


/**
 * A JDescriptedElement are elements that can be descripted with a
 * string.
 * 
 * @author da Costa Cambio
 *
 */
public interface JDescriptedElement extends JObject {
	
    /**
	 * A user readable descriptor.
	 * 
	 * 
	 * For packages should be:
	 * 		package:{package}
	 * 		
	 * 		where:
	 * 			{package} is the value returned by getName()
	 * 
	 * this can be performed by calling Util.getDescriptor(JClass)
	 *
	 * For classes should be:
	 * 		class:{class}
	 * 		
	 * 		where:
	 * 			{class} is the value returned by getName()
	 * 
	 * this can be performed by calling Util.getDescriptor(JClass)
	 *
	 * For behaviors should be:
	 * 		behavior:{class}#{name}{signature}
	 * 		
	 * 		where:
	 * 			{class} is the value returned by getDeclaringClass().getName()
	 * 			{name} is the value returned by getName()
	 * 			{signature} is the value returned by getSignature()
	 *			# constant is defined in Util.MEMBER_DELIMITER
	 * 
	 * this can be performed by calling Util.getDescriptor(JBehavior)
	 * 
	 * For fields should be:
	 * 		field:{class}#{name}:{type}
	 * 		
	 * 		where:
	 * 			{class} is the value returned by getDeclaringClass().getName()
	 * 			{name} is the value returned by getName()
	 * 			{type} is the value returned by getReturnType().getName()
	 *			# constant is defined in Util.MEMBER_DELIMITER
	 *			: constant is defined in Util.TYPE_DELIMITER
	 *
 	 * this can be performed by calling Util.getDescriptor(JField)
 	 * @return
     */
	public String getDescriptor();
}
