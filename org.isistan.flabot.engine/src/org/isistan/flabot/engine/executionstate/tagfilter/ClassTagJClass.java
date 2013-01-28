/**
 * 
 */
package org.isistan.flabot.engine.executionstate.tagfilter;

import org.isistan.flabot.javamodel.JAnnotation;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JClassLoader;
import org.isistan.flabot.javamodel.JConstructor;
import org.isistan.flabot.javamodel.JEnum;
import org.isistan.flabot.javamodel.JField;
import org.isistan.flabot.javamodel.JMethod;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.JSourceLocation;
import org.isistan.flabot.javamodel.JType;
import org.isistan.flabot.javamodel.JTypeVariable;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.tagquery.TagQueryUtil;

/**
 * JClass implementation for class tags
 * @author mblech
 *
 */
public class ClassTagJClass implements JClass {

	private Tag classTag;

	public ClassTagJClass(Tag classTag) {
		this.classTag = classTag;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#newInstance()
	 */
	public JObject newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isInstance(org.isistan.flabot.javamodel.JObject)
	 */
	public boolean isInstance(JObject obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isAssignableFrom(org.isistan.flabot.javamodel.JClass)
	 */
	public boolean isAssignableFrom(JClass cls) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isInterface()
	 */
	public boolean isInterface() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isArray()
	 */
	public boolean isArray() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isPrimitive()
	 */
	public boolean isPrimitive() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isAnnotation()
	 */
	public boolean isAnnotation() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isSynthetic()
	 */
	public boolean isSynthetic() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getName()
	 */
	public String getName() {
		return TagQueryUtil.INSTANCE.getClassDescriptor(classTag);
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getJNIName()
	 */
	public String getJNIName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getClassLoader()
	 */
	public JClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getTypeParameters()
	 */
	public JArray<? extends JTypeVariable> getTypeParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getSuperclass()
	 */
	public JClass getSuperclass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getGenericSuperclass()
	 */
	public JType getGenericSuperclass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getPackage()
	 */
	public JPackage getPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getInterfaces()
	 */
	public JArray<? extends JClass> getInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getGenericInterfaces()
	 */
	public JArray<? extends JType> getGenericInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getComponentType()
	 */
	public JClass getComponentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getModifiers()
	 */
	public int getModifiers() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getSigners()
	 */
	public JArray<? extends JObject> getSigners() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getEnclosingMethod()
	 */
	public JMethod getEnclosingMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getEnclosingConstructor()
	 */
	public JConstructor getEnclosingConstructor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getEnclosingBehavior()
	 */
	public JBehavior getEnclosingBehavior() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaringClass()
	 */
	public JClass getDeclaringClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getEnclosingClass()
	 */
	public JClass getEnclosingClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getSimpleName()
	 */
	public String getSimpleName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getCanonicalName()
	 */
	public String getCanonicalName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isAnonymousClass()
	 */
	public boolean isAnonymousClass() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isLocalClass()
	 */
	public boolean isLocalClass() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isMemberClass()
	 */
	public boolean isMemberClass() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getClasses()
	 */
	public JArray<? extends JClass> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getFields()
	 */
	public JArray<? extends JField> getFields() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getMethods()
	 */
	public JArray<? extends JMethod> getMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getConstructors()
	 */
	public JArray<? extends JConstructor> getConstructors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getBehaviors()
	 */
	public JArray<? extends JBehavior> getBehaviors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getField(java.lang.String)
	 */
	public JField getField(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getMethod(java.lang.String, org.isistan.flabot.javamodel.JArray)
	 */
	public JMethod getMethod(String name,
			JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getConstructor(org.isistan.flabot.javamodel.JArray)
	 */
	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getBehavior(java.lang.String, org.isistan.flabot.javamodel.JArray)
	 */
	public JBehavior getBehavior(String name,
			JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredClasses()
	 */
	public JArray<? extends JClass> getDeclaredClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredFields()
	 */
	public JArray<? extends JField> getDeclaredFields() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredMethods()
	 */
	public JArray<? extends JMethod> getDeclaredMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredConstructors()
	 */
	public JArray<? extends JConstructor> getDeclaredConstructors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredBehaviors()
	 */
	public JArray<? extends JBehavior> getDeclaredBehaviors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredField(java.lang.String)
	 */
	public JField getDeclaredField(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredMethod(java.lang.String, org.isistan.flabot.javamodel.JArray)
	 */
	public JMethod getDeclaredMethod(String name,
			JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredConstructor(org.isistan.flabot.javamodel.JArray)
	 */
	public JConstructor getDeclaredConstructor(
			JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getDeclaredBehavior(java.lang.String, org.isistan.flabot.javamodel.JArray)
	 */
	public JBehavior getDeclaredBehavior(String name,
			JArray<? extends JClass> parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getResourceAsStream(java.lang.String)
	 */
	public JObject getResourceAsStream(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getResource(java.lang.String)
	 */
	public JObject getResource(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getProtectionDomain()
	 */
	public JObject getProtectionDomain() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#desiredAssertionStatus()
	 */
	public boolean desiredAssertionStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#isEnum()
	 */
	public boolean isEnum() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JClass#getEnumConstants()
	 */
	public JArray<? extends JEnum> getEnumConstants() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#isPrimitiveValue()
	 */
	public boolean isPrimitiveValue() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#getId()
	 */
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#getObjectClass()
	 */
	public JClass getObjectClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectHashCode()
	 */
	public int objectHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#systemHashCode()
	 */
	public int systemHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectEquals(org.isistan.flabot.javamodel.JObject)
	 */
	public boolean objectEquals(JObject other) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectToString()
	 */
	public String objectToString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectNotify()
	 */
	public void objectNotify() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectNotifyAll()
	 */
	public void objectNotifyAll() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectWait(long)
	 */
	public void objectWait(long timeout) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectWait(long, int)
	 */
	public void objectWait(long timeout, int nanos) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JObject#objectWait()
	 */
	public void objectWait() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JAnnotatedElement#isAnnotationPresent(org.isistan.flabot.javamodel.JClass)
	 */
	public boolean isAnnotationPresent(JClass annotationType) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JAnnotatedElement#getAnnotation(org.isistan.flabot.javamodel.JClass)
	 */
	public JAnnotation getAnnotation(JClass annotationType) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JAnnotatedElement#getAnnotations()
	 */
	public JArray<? extends JAnnotation> getAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.javamodel.JAnnotatedElement#getDeclaredAnnotations()
	 */
	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

	public JArray<? extends JClass> getSubclasses(boolean onlyDirect) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSourceLocation getSourceLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

}
