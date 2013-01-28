package org.isistan.flabot.executionstatemapping.utils;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CommandUtils {

	public static boolean hasReferences(EObject object, ResourceSet resourceSet)
	{		
		Collection<EObject> eObjects = new UniqueEList<EObject>();
		eObjects.add(object);
		
		Map<EObject, Collection<EStructuralFeature.Setting>> usages = EcoreUtil.UsageCrossReferencer.findAll(eObjects, resourceSet);
		
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages.entrySet())
	    {
	      Collection<EStructuralFeature.Setting> settings = entry.getValue();
	      for (EStructuralFeature.Setting setting : settings)
	      {
	        EObject referencingEObject = setting.getEObject();
	        if (!eObjects.contains(referencingEObject))
	        {
	          EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
	          if (eStructuralFeature.isChangeable())
	          {
	        	return true;
	          }
	        }
	      }
	    }
		
		return false;
	}
	
	public static int countReferences(EObject object, ResourceSet resourceSet)
	{		
		int references = 0;
		
		Collection<EObject> eObjects = new UniqueEList<EObject>();
		eObjects.add(object);
		
		Map<EObject, Collection<EStructuralFeature.Setting>> usages = EcoreUtil.UsageCrossReferencer.findAll(eObjects, resourceSet);
		
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages.entrySet())
	    {
	      Collection<EStructuralFeature.Setting> settings = entry.getValue();
	      for (EStructuralFeature.Setting setting : settings)
	      {
	        EObject referencingEObject = setting.getEObject();
	        if (!eObjects.contains(referencingEObject))
	        {
	          EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
	          if (eStructuralFeature.isChangeable())
	          {
	        	references++;
	          }
	        }
	      }
	    }
		
		return references;
	}
}
