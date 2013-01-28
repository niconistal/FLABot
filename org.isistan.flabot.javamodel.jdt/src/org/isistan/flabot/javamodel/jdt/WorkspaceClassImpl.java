/** * $Id: WorkspaceClassImpl.java,v 1.9 2006/07/18 01:50:33 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.javamodel.jdt;

import java.lang.ref.WeakReference;import java.lang.reflect.Modifier;import java.util.LinkedList;import java.util.List;import org.eclipse.jdt.core.ElementChangedEvent;import org.eclipse.jdt.core.Flags;import org.eclipse.jdt.core.IClassFile;import org.eclipse.jdt.core.ICompilationUnit;import org.eclipse.jdt.core.IJavaElement;import org.eclipse.jdt.core.IJavaElementDelta;import org.eclipse.jdt.core.IMethod;import org.eclipse.jdt.core.IParent;import org.eclipse.jdt.core.ISourceRange;import org.eclipse.jdt.core.IType;import org.eclipse.jdt.core.ITypeHierarchy;import org.eclipse.jdt.core.JavaModelException;import org.eclipse.jdt.core.dom.ASTNode;import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;import org.eclipse.jdt.core.dom.CompilationUnit;import org.eclipse.jdt.core.dom.ITypeBinding;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.JavaMetaModelException;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.jdt.ast.ASTUtil;import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;public class WorkspaceClassImpl extends ObjectImpl implements JWorkspaceClass, JNotificableElement {
	private static final int CLASS_CHANGE_FLAG=0;	private static final int CLASS_CHILDREN_CHANGE_FLAG=1;	private static final int CLASSES_EVENT_FLAG=2;
	private IType jdtClass;
	
	IType getJDTClass() {
		return jdtClass;
	}
	
	static IType getJDTClass(JClass jClass) {
		if(jClass instanceof WorkspaceClassImpl) {
			return ((WorkspaceClassImpl)jClass).getJDTClass();
		} else {
			throw new MixedImplementationsException(jClass);
		} 
	}
	
	WorkspaceClassImpl(IType jdtClass) {		super(jdtClass);
		this.jdtClass=jdtClass;
		JavaModelListener.getInstance().add(this, CLASS_CHANGE_FLAG, jdtClass,				IJavaElementDelta.CHANGED);		JavaModelListener.getInstance().add(this, CLASS_CHILDREN_CHANGE_FLAG, jdtClass,				IJavaElementDelta.F_CHILDREN);		JavaModelListener.getInstance().add(this, CLASSES_EVENT_FLAG,				IJavaElementDelta.ADDED | IJavaElementDelta.CHANGED | IJavaElementDelta.REMOVED);	}		public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {		if(flag==CLASS_CHANGE_FLAG) {			name=null;			superclassCalculated=false;			bindingRef=null;			enclosingBehaviorCalculated=false;			interfaces=null;		} else if(flag==CLASS_CHILDREN_CHANGE_FLAG) {			declaredClasses=null;			declaredBehaviors=null;			declaredMethods=null;			declaredConstructors=null;		} else if(flag==CLASSES_EVENT_FLAG) {			if(javaElement instanceof IType) {				subclasses=null;				directSubclasses=null;			}		}	}
	
	public JObject newInstance() {
		throw new NotSupportedFeatureException();
	}

	public boolean isInstance(JObject obj) {
		throw new NotSupportedFeatureException();
	}

	public boolean isAssignableFrom(JClass cls) {
		throw new NotSupportedFeatureException();
	}

	public boolean isInterface() {
		try {
			return jdtClass.isInterface();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public boolean isArray() {
		throw new NotSupportedFeatureException();
	}

	public boolean isPrimitive() {		return false;	}

	public boolean isAnnotation() {
		try {
			return jdtClass.isAnnotation();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public boolean isSynthetic() {
		try {
			return Flags.isSynthetic(jdtClass.getFlags());
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}
	private String name=null; 
	public String getName() {		if(name==null) {			//if class is in a class file or if it is not nested,			//class name can be directly obtained, else it must			//be obtained from the type binding			String fqname=jdtClass.getFullyQualifiedName(Util.NESTED_CLASS_DELIMITER);			if(jdtClass.isBinary() || fqname.indexOf(Util.NESTED_CLASS_DELIMITER)==-1) {
				name=fqname;			} else {				name=getBinding().getBinaryName();			}		}		return name;
	}
	
	public String getJNIName() {
		return Util.getJNIName(getName());
	}

	public JClassLoader getClassLoader() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		throw new NotSupportedFeatureException();
	}
	private JWorkspaceClass superclass=null;	private boolean superclassCalculated=false;
	public JWorkspaceClass getSuperclass() {		if(!superclassCalculated) {			try {				if(isInterface() || isAnnotation()) {					return null;				}				IType jdtSuperclass=jdtClass.newSupertypeHierarchy(null).getSuperclass(jdtClass);				if(jdtSuperclass==null || !JavaModelJDTUtil.elementExists(jdtSuperclass)) {					jdtSuperclass=jdtClass.getJavaProject().findType("java.lang.Object");				}				if(jdtSuperclass==null) {					superclass=null;				} else {					superclass=JDTFactory.getInstance().buildClass(jdtSuperclass);				}				superclassCalculated=true;			} catch(JavaModelException e) {				throw new InternalModelException(e);			}		}		return superclass;	}		private WeakReference<ITypeBinding> bindingRef=null;	ITypeBinding getBinding() {		ITypeBinding binding = null;		if (bindingRef != null) {			binding = bindingRef.get();		}		if(binding==null) {			CompilationUnit cu=ASTUtil.getASTRoot(jdtClass.getCompilationUnit());			BindingFinder bindingFinder=new BindingFinder(jdtClass);			ASTUtil.getDescendants(cu, bindingFinder);			binding=bindingFinder.getBinding();			if(binding==null) {				throw new JavaMetaModelException("Couln't resolve binding for type" + jdtClass);			}			else {				bindingRef = new WeakReference<ITypeBinding>(binding);			}		}		return binding;			}		private class BindingFinder implements ASTUtil.ASTNodeFilter {		private boolean found=false;		private ITypeBinding binding=null;		private String typeKey;		public BindingFinder(IType type) {			typeKey=type.getHandleIdentifier();		}				public boolean accept(ASTNode node) {			if(found)				return false;			ITypeBinding binding=null;			if(node instanceof AbstractTypeDeclaration) {				binding=((AbstractTypeDeclaration)node).resolveBinding();			} else if(node instanceof AnonymousClassDeclaration) {				binding=((AnonymousClassDeclaration)node).resolveBinding();			}			if(binding!=null && binding.getJavaElement().getHandleIdentifier().equals(typeKey)) {				found=true;				this.binding=binding;				return true;			}			return false;		}		public boolean stop(ASTNode node) {			return found;		}		public ITypeBinding getBinding() {			return binding;		}	}	
	public JType getGenericSuperclass() {
		throw new NotSupportedFeatureException();
	}

	public JPackage getPackage() {
		return JDTFactory.getInstance().buildPackage(jdtClass.getPackageFragment());
	}
	
	private JArray<? extends JWorkspaceClass> interfaces=null;
	public JArray<? extends JWorkspaceClass> getInterfaces() {		if(interfaces==null) {
			try {				if(isInterface()) {					return JDTFactory.getInstance().buildArray(new Object[0],							JDTFactory.getInstance().getClassBuilder());				}				IType[] jdtInterfaces=jdtClass.newSupertypeHierarchy(null).getSuperInterfaces(jdtClass);				interfaces=JDTFactory.getInstance().buildArray(						JavaModelJDTUtil.getExistingElementsArray(jdtInterfaces),						JDTFactory.getInstance().getClassBuilder());			} catch(JavaModelException e) {				throw new InternalModelException(e);			}		}		return interfaces;
	}

	public JArray<? extends JType> getGenericInterfaces() {
		throw new NotSupportedFeatureException();
	}

	public JClass getComponentType() {
		throw new NotSupportedFeatureException();
	}

	public int getModifiers() {
		try {
			int flags=jdtClass.getFlags();
			int modifiers=0;
			if(Flags.isAbstract(flags))
				modifiers=modifiers | Modifier.ABSTRACT;
			if(Flags.isFinal(flags))
				modifiers=modifiers | Modifier.FINAL;
			if(Flags.isInterface(flags))
				modifiers=modifiers | Modifier.INTERFACE;
			if(Flags.isNative(flags))
				modifiers=modifiers | Modifier.NATIVE;
			if(Flags.isPrivate(flags))
				modifiers=modifiers | Modifier.PRIVATE;
			if(Flags.isProtected(flags))
				modifiers=modifiers | Modifier.PROTECTED;
			if(Flags.isPublic(flags))
				modifiers=modifiers | Modifier.PUBLIC;
			if(Flags.isStatic(flags))
				modifiers=modifiers | Modifier.STATIC;
			if(Flags.isStrictfp(flags))
				modifiers=modifiers | Modifier.STRICT;
			if(Flags.isSynchronized(flags))
				modifiers=modifiers | Modifier.SYNCHRONIZED;
			if(Flags.isTransient(flags))
				modifiers=modifiers | Modifier.TRANSIENT;
			if(Flags.isVolatile(flags))
				modifiers=modifiers | Modifier.VOLATILE;
			return modifiers;
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public JArray<? extends JObject> getSigners() {
		throw new NotSupportedFeatureException();
	}

	public JMethod getEnclosingMethod() {
		throw new NotSupportedFeatureException();
	}

	public JConstructor getEnclosingConstructor() {
		throw new NotSupportedFeatureException();
	}
	private JBehavior enclosingBehavior=null;	private boolean enclosingBehaviorCalculated=false;
	public JBehavior getEnclosingBehavior() {		if(!enclosingBehaviorCalculated) {			IJavaElement parent=jdtClass.getParent();			while(parent!=null) {				if(parent instanceof IMethod) {					enclosingBehavior=JDTFactory.getInstance().buildBehavior(parent);					break;				} else if(parent instanceof IType) {					break;				}				parent=parent.getParent();			}			enclosingBehaviorCalculated=true;		}		return enclosingBehavior;	}

	public JClass getDeclaringClass() {		return JDTFactory.getInstance().buildClass(jdtClass.getDeclaringType());
		
	}

	public JClass getEnclosingClass() {
		throw new NotSupportedFeatureException();
	}

	public String getSimpleName() {
		return jdtClass.getElementName();
	}

	public String getCanonicalName() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnonymousClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean isLocalClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean isMemberClass() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JClass> getClasses() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JField> getFields() throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JMethod> getMethods() throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JConstructor> getConstructors() throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JBehavior> getBehaviors() throws SecurityException {
		throw new NotSupportedFeatureException();	}

	public JField getField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}	
	JArray<? extends JWorkspaceClass> declaredClasses=null;
	public JArray<? extends JWorkspaceClass> getDeclaredClasses() {		if(declaredClasses==null) {
			List<IType> jdtDeclaredClasses=new LinkedList<IType>();			getDeclaredClasses(jdtClass, jdtDeclaredClasses);			declaredClasses=JDTFactory.getInstance().buildArray(					jdtDeclaredClasses.toArray(new IType[jdtDeclaredClasses.size()]),					JDTFactory.getInstance().getClassBuilder()					);		}		return declaredClasses;	}		private void getDeclaredClasses(IParent element, List<IType> jdtDeclaredClasses) {		try {			IJavaElement[] children=element.getChildren();			for (IJavaElement child : children) {				if(JavaModelJDTUtil.elementExists(child)) {					if(child instanceof IType) {						jdtDeclaredClasses.add((IType) child);					} else if(child instanceof IParent){						getDeclaredClasses((IParent) child, jdtDeclaredClasses);					}				}			}		} catch (JavaModelException e) {			throw new InternalModelException(e);		}	}

	public JArray<? extends JField> getDeclaredFields() {
		throw new NotSupportedFeatureException();
	}

	private JArray<? extends JMethod> declaredMethods=null;	public JArray<? extends JMethod> getDeclaredMethods() {
		if(declaredMethods==null) {			try {				IMethod[] jdtBehaviors=jdtClass.getMethods();				IMethod[] existingJDTBehaviors=JavaModelJDTUtil.getExistingElements(						jdtBehaviors).toArray(new IMethod[jdtBehaviors.length]);				List<IMethod> jdtMethods=new LinkedList<IMethod>();				for (IMethod jdtBehavior : existingJDTBehaviors) {					if(!jdtBehavior.isConstructor()) {						jdtMethods.add(jdtBehavior);					}				}				Object[] allJDTConstructors;				allJDTConstructors=jdtMethods.toArray();				declaredMethods=JDTFactory.getInstance().buildArray(						allJDTConstructors,						JDTFactory.getInstance().getMethodBuilder()						);			} catch (JavaModelException e) {				throw new InternalModelException(e);			}		}		return declaredMethods;	}

	private JArray<? extends JConstructor> declaredConstructors=null;	public JArray<? extends JConstructor> getDeclaredConstructors() {
		if(declaredConstructors==null) {			try {				IMethod[] jdtBehaviors=jdtClass.getMethods();				IMethod[] existingJDTBehaviors=JavaModelJDTUtil.getExistingElements(						jdtBehaviors).toArray(new IMethod[jdtBehaviors.length]);				List<IMethod> jdtConstructors=new LinkedList<IMethod>();				for (IMethod jdtBehavior : existingJDTBehaviors) {					if(jdtBehavior.isConstructor()) {						jdtConstructors.add(jdtBehavior);					}				}				Object[] allJDTConstructors;				if(jdtConstructors.size()>0) {					allJDTConstructors=jdtConstructors.toArray();				} else {					allJDTConstructors=new Object[] {							new ImplicitConstructorImpl.JDTImplicitConstructor(this)						};				}				declaredConstructors=JDTFactory.getInstance().buildArray(						allJDTConstructors,						JDTFactory.getInstance().getConstructorBuilder()						);			} catch (JavaModelException e) {				throw new InternalModelException(e);			}		}		return declaredConstructors;
	}
	private JArray<? extends JBehavior> declaredBehaviors=null;
	public JArray<? extends JBehavior> getDeclaredBehaviors() throws SecurityException {		if(declaredBehaviors==null) {
			try {				IMethod[] jdtBehaviors=jdtClass.getMethods();				IMethod[] existingJDTBehaviors=JavaModelJDTUtil.getExistingElements(						jdtBehaviors).toArray(new IMethod[jdtBehaviors.length]);				boolean constructorFound=false;				for (IMethod jdtBehavior : existingJDTBehaviors) {					if(jdtBehavior.isConstructor()) {						constructorFound=true;						break;					}				}				Object[] allJDTBehaviors;				if(constructorFound) {					allJDTBehaviors=existingJDTBehaviors;				} else {					allJDTBehaviors=new Object[existingJDTBehaviors.length+1];					allJDTBehaviors[0]=new ImplicitConstructorImpl.JDTImplicitConstructor(this);					for (int i = 0; i < existingJDTBehaviors.length; i++) {						allJDTBehaviors[i+1]=existingJDTBehaviors[i];					}				}				declaredBehaviors=JDTFactory.getInstance().buildArray(						allJDTBehaviors,						JDTFactory.getInstance().getBehaviorBuilder()						);			} catch (JavaModelException e) {				throw new InternalModelException(e);			}		}		return declaredBehaviors;
	}
	
	public JField getDeclaredField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getDeclaredMethod(String name, JArray<? extends JClass> parameterTypes) {		if(name.equals(JConstructor.BEHAVIOR_NAME)) {			throw new IllegalArgumentException("Name cannot be " + JConstructor.BEHAVIOR_NAME + ".");		}
		return (JMethod) getDeclaredBehavior(name, parameterTypes);	}

	public JConstructor getDeclaredConstructor(JArray<? extends JClass> parameterTypes) {
		return (JConstructor) getDeclaredBehavior(JConstructor.BEHAVIOR_NAME, parameterTypes);
	}

	public JBehavior getDeclaredBehavior(String name, JArray<? extends JClass> parameterTypes) {		JArray<? extends JBehavior> behaviors = getDeclaredBehaviors();		String[] parameterTypeNames=new String[parameterTypes.length()];		for (int i = 0; i < parameterTypeNames.length; i++) {			parameterTypeNames[i]=parameterTypes.at(i).getName();		}		String signature=Util.getSignature(parameterTypeNames, "");		for (JBehavior behavior : behaviors) {			if(name.equals(behavior.getName()) && behavior.getSignature().startsWith(signature)) {				return behavior;			}		}		return null;
	}

	public JObject getResourceAsStream(String name) {
		throw new NotSupportedFeatureException();
	}

	public JObject getResource(String name) {
		throw new NotSupportedFeatureException();
	}

	public JObject getProtectionDomain() {
		throw new NotSupportedFeatureException();
	}

	public boolean desiredAssertionStatus() {
		throw new NotSupportedFeatureException();
	}

	public boolean isEnum() {
		try {
			return jdtClass.isEnum();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public JArray<? extends JEnum> getEnumConstants() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}	public JArray<? extends JWorkspaceClass> directSubclasses=null;	public JArray<? extends JWorkspaceClass> subclasses=null;	public JArray<? extends JWorkspaceClass> getSubclasses(boolean onlyDirect) {		if(subclasses==null || directSubclasses==null) {			try {				IType[] jdtDirectSubclasses=getSubclasses(jdtClass, true);				IType[] jdtSubclasses=getSubclasses(jdtClass, false);				directSubclasses=JDTFactory.getInstance().buildArray(						JavaModelJDTUtil.getExistingElementsArray(jdtDirectSubclasses),						JDTFactory.getInstance().getClassBuilder());				subclasses=JDTFactory.getInstance().buildArray(						JavaModelJDTUtil.getExistingElementsArray(jdtSubclasses),						JDTFactory.getInstance().getClassBuilder());			} catch (JavaModelException e) {				throw new InternalModelException(e);			}		}		if(onlyDirect) {			return directSubclasses;		} else {			return subclasses;		}	}	public JJavaFile getJavaFile() {		IJavaElement javaElement=jdtClass.getParent();		while(!(javaElement instanceof IClassFile) && !(javaElement instanceof ICompilationUnit)) {			javaElement=javaElement.getParent();		}		return JDTFactory.getInstance().buildJavaFile(javaElement);	}	public JSourceLocation getSourceLocation() {		try {			ISourceRange sourceRange=jdtClass.getSourceRange();			return new JSourceLocation(sourceRange.getOffset(), sourceRange.getLength());		} catch (JavaModelException e) {			throw new InternalModelException(e);		}	}		public String getDescriptor() {		return Util.getClassDescriptor(this);	}		private static final int MAX_HIERARCHIES=50;	private static List<ITypeHierarchy> subHierarchies=new LinkedList<ITypeHierarchy>();	private static IType[] getSubclasses(IType type, boolean onlyDirect) throws JavaModelException {		ITypeHierarchy hierarchy=null;		for (ITypeHierarchy aHierarchy : subHierarchies) {			boolean contains=aHierarchy.contains(type);			if(contains) {				hierarchy=aHierarchy;			}		}		if(hierarchy==null) {			hierarchy = type.newTypeHierarchy(null);			subHierarchies.add(0, hierarchy);			if(subHierarchies.size()==MAX_HIERARCHIES+1) {				subHierarchies.remove(MAX_HIERARCHIES);			}		}		if(onlyDirect) {			return hierarchy.getSubtypes(type);		} else {			return hierarchy.getAllSubtypes(type);		}	}
}
