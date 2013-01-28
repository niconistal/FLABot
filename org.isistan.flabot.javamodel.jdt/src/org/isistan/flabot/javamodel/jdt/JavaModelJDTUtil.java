package org.isistan.flabot.javamodel.jdt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeParameter;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JConstructor;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.Util;
import org.isistan.flabot.javamodel.jdt.WorkspacePrimitiveClassImpl.PrimitiveClass;

public class JavaModelJDTUtil {
	/**
	 * Resolves the class name for a jdt unresolved class name from a given type.
	 * @param fromType
	 * @param typeName
	 * @return
	 * @throws JavaModelException
	 * @throws UnresolvedTypeException
	 */
	@Deprecated
	static String resolveType(IMember from, String typeName) throws JavaModelException, UnresolvedTypeException {
		return Util.getName(resolveJNIType(from, typeName));
	}
	
	/**
	 * Resolves the jni class name for a jdt unresolved class name from a given type.
	 * For resolved types, returns the same value.
	 * For generic types, returns they bound.
	 * @param fromType
	 * @param typeName
	 * @return
	 * @throws JavaModelException
	 * @throws UnresolvedTypeException
	 */
	@Deprecated
	static String resolveJNIType(IMember from, String typeName) throws JavaModelException, UnresolvedTypeException {
		int dimensions=Signature.getArrayCount(typeName);
		String elementTypeName=typeName;
		elementTypeName=Signature.getElementType(typeName);
		if(elementTypeName.charAt(0)==Signature.C_RESOLVED ||
				Signature.getTypeSignatureKind(elementTypeName)==Signature.BASE_TYPE_SIGNATURE) {
			return typeName;
		}
		char elementTypeKind=elementTypeName.charAt(0);
		elementTypeName=elementTypeName.substring(1, elementTypeName.length()-1);
		String resolution;
		if(elementTypeKind==Signature.C_UNRESOLVED) {
			resolution=resolveJNITypeParameter(from, elementTypeName);
			if(resolution==null) {
				IType type=(IType) from.getAncestor(IJavaElement.TYPE);
				String[][] resolutions=type.resolveType(
						elementTypeName.replace(Util.JNI_PACKAGE_DELIMITER, Signature.C_DOT));
				if(resolutions==null || resolutions.length==0) {
					throw new UnresolvedTypeException(from.toString(), typeName);
				}
				resolution=resolutions[0][1].replace(Signature.C_DOT, Util.NESTED_CLASS_DELIMITER);
				if(resolutions[0][0].length()>0) {
					resolution=resolutions[0][0] + Util.PACKAGE_DELIMITER + resolution;
				}
				resolution=Util.getJNIName(resolution);
			}
		} else if(elementTypeKind==Signature.C_TYPE_VARIABLE) {
			resolution=resolveJNITypeParameter(from, elementTypeName);
		} else {
			throw new IllegalArgumentException("Invalid type name: " + typeName);

		}
		resolution=removeGenerics(resolution);
		String resolvedTypeName=Signature.createArraySignature(resolution, dimensions);
		return resolvedTypeName;

	}
	@Deprecated
	private static String removeGenerics(String type) {
		int start=type.indexOf('<');
		if(start==-1)
			return type;
		
		return type.substring(0,start) + ';';
	}
	@Deprecated
	private static String resolveJNITypeParameter(IMember from, String typeName) throws JavaModelException, UnresolvedTypeException {
		String resolvedTypeParameter=null;
		
		IJavaElement typeParameterDeclarator=from;
		while(typeParameterDeclarator!=null && 
				typeParameterDeclarator instanceof IMember) {
			if(typeParameterDeclarator instanceof IType ||
					typeParameterDeclarator instanceof IMethod) {
				resolvedTypeParameter=resolveJNISpecificTypeParameter((IMember) typeParameterDeclarator, typeName);
				if(resolvedTypeParameter!=null) {
					return resolvedTypeParameter;
				}
			}
			typeParameterDeclarator=typeParameterDeclarator.getParent();
		}
		return null;
	}
	@Deprecated
	private  static String resolveJNISpecificTypeParameter(IMember from, String typeName) throws JavaModelException, UnresolvedTypeException {
		ITypeParameter[] typeParameters;
		if(from instanceof IType) {
			typeParameters=((IType)from).getTypeParameters();
		} else if(from instanceof IMethod) {
			typeParameters=((IMethod)from).getTypeParameters();
		} else {
			throw new IllegalArgumentException("'from' should be IType or IMethod.");
		}
		for (ITypeParameter typeParameter : typeParameters) {
			if(typeParameter.getElementName().equals(typeName)) {
				String bounds[]=typeParameter.getBounds();
				if(bounds==null || bounds.length==0)
					return "L" + Object.class.getName().replace('.', '/') + ";";

				String bound=bounds[0];
				return resolveJNIType(from, "Q" + bound.replace('.', '/') + ";");
			}
		}
		return null;
	}
	

	private static IResource getResource(IJavaElement jdtElement) {
		IJavaElement parent=jdtElement;
		IResource resource=null;
		while(parent!=null && resource==null) {
			resource=parent.getResource();
			parent=parent.getParent();
		}
		return resource;
	}
	
	/**
	 * Returns the resource closest to the given object, null if none.
	 * @param jObject
	 * @return
	 */
	public static IResource getResource(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			if(jObject instanceof ImplicitConstructorImpl) {
				jObject=((JConstructor)jObject).getDeclaringClass();
			} else if(jObject instanceof WorkspacePrimitiveClassImpl) {
				return null;
			}
			IJavaElement jdtObject=(IJavaElement) ObjectImpl.getJDTObject(jObject);
			return getResource(jdtObject);
		} else {
			throw new MixedImplementationsException(jObject);
		}
	}
	
	/**
	 * Returns an stable identifier
	 * @param object
	 * @return
	 */
	public static String getStableIdentifier(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			if(jObject instanceof ImplicitConstructorImpl) {
				return ".implicit-constructor:" + WorkspaceClassImpl.getJDTClass(((JConstructor)jObject).getDeclaringClass()).getHandleIdentifier();
			} else if(jObject instanceof WorkspacePrimitiveClassImpl) {
				return ".primitive-class:" + ((JClass)jObject).getName();
			}
			IJavaElement jdtObject=(IJavaElement) ObjectImpl.getJDTObject(jObject);
			return jdtObject.getHandleIdentifier();
		} else {
			throw new MixedImplementationsException(jObject);
		}
	}
	
	
	/**
	 * Returns the java element asocitated with the given object, null if none.
	 * @param jObject
	 * @return
	 */
	public static IJavaElement getJavaElement(JObject jObject) {
		if(jObject instanceof ObjectImpl) {
			if(jObject instanceof ImplicitConstructorImpl) {
				return null;
			} else if(jObject instanceof WorkspacePrimitiveClassImpl) {
				return null;
			}
			IJavaElement jdtObject=(IJavaElement) ObjectImpl.getJDTObject(jObject);
			return jdtObject;
		} else {
			throw new MixedImplementationsException(jObject);
		}
	}

	
	static <T extends IJavaElement> Collection<T> getExistingElements(T[] elements) {
		List<T> existingElements=new ArrayList<T>(elements.length);
		for (T element : elements) {
			if(elementExists(element)) {
				existingElements.add(element);
			}
		}
		return existingElements;
	}
	
	static <T extends IJavaElement> Object[] getExistingElementsArray(T[] elements) {
		return getExistingElements(elements).toArray();
	}
	
	static <T extends IJavaElement> boolean elementExists(T element) {
		return element.exists();
	}

	/**
	 * Determines if an element is in the given iterable, comparing
	 * by JavaModelJDTUtil.getStableIdentifier()
	 * @param elements
	 * @param element
	 * @return
	 */
	public static boolean contains(Iterable<? extends JObject> elements, JObject element) {
		String id=JavaModelJDTUtil.getStableIdentifier(element);
		for (JObject containedElement : elements) {
			String containedId=JavaModelJDTUtil.getStableIdentifier(containedElement);
			if(containedId.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines if an element is in the given array, comparing
	 * by JavaModelJDTUtil.getStableIdentifier()
	 * @param elements
	 * @param element
	 * @return
	 */
	public static boolean contains(JObject[] elements, JObject element) {
		String id=JavaModelJDTUtil.getStableIdentifier(element);
		for (JObject containedElement : elements) {
			String containedId=JavaModelJDTUtil.getStableIdentifier(containedElement);
			if(containedId.equals(id)) {
				return true;
			}
		}
		return false;
	}

	static Object findType(IJavaProject jproject, String fullyQualifiedName) throws JavaModelException, UnresolvedTypeException {
		PrimitiveClass primitive=PrimitiveClass.get(fullyQualifiedName, jproject);
		if(primitive!=null) {
			return primitive;
		} else {
			//workaround for bug 22883
			IType type= jproject.findType(fullyQualifiedName);
			if (type != null)
				return type;
			IPackageFragmentRoot[] roots= jproject.getPackageFragmentRoots();
			for (int i= 0; i < roots.length; i++) {
				IPackageFragmentRoot root= roots[i];
				type= findType(root, fullyQualifiedName);
				if (type != null && type.exists())
					return type;
			}	
			throw new UnresolvedTypeException(jproject.getElementName(), fullyQualifiedName);
		}
	}
	
	private static IType findType(IPackageFragmentRoot root, String fullyQualifiedName) throws JavaModelException{
		IJavaElement[] children= root.getChildren();
		for (int i= 0; i < children.length; i++) {
			IJavaElement element= children[i];
			if (element.getElementType() == IJavaElement.PACKAGE_FRAGMENT){
				IPackageFragment pack= (IPackageFragment)element;
				if (! fullyQualifiedName.startsWith(pack.getElementName()))
					continue;
				IType type= findType(pack, fullyQualifiedName);
				if (type != null && type.exists())
					return type;
			}
		}		
		return null;
	}
	
	private static IType findType(IPackageFragment pack, String fullyQualifiedName) throws JavaModelException{
		ICompilationUnit[] cus= pack.getCompilationUnits();
		for (int i= 0; i < cus.length; i++) {
			ICompilationUnit unit= cus[i];
			IType type= findType(unit, fullyQualifiedName);
			if (type != null && type.exists())
				return type;
		}
		return null;
	}
	
	private static IType findType(ICompilationUnit cu, String fullyQualifiedName) throws JavaModelException{
		fullyQualifiedName=fullyQualifiedName.replace('$','.');
		IType[] types= cu.getAllTypes();
		for (int i= 0; i < types.length; i++) {
			IType type= types[i];
			if (getFullyQualifiedName(type).equals(fullyQualifiedName))
				return type;
		}
		return null;
	}
	
	private static String getFullyQualifiedName(IType type) {
		return type.getFullyQualifiedName('.');
	}
}
	
