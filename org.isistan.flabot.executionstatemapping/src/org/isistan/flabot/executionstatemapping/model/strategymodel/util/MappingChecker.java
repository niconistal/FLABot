package org.isistan.flabot.executionstatemapping.model.strategymodel.util;

import java.util.List;
import java.util.StringTokenizer;

import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelFactory;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class MappingChecker {

	@SuppressWarnings("unchecked")
	public static void checkComponentMapping(Responsibility responsibility, PatternMapping responsibilityMapping)
	{
		PatternMapping componentMapping;
		for(ComponentModel component : (List<ComponentModel>)responsibility.getComponents())
		{
			componentMapping = (PatternMapping)MappingManager.getMapping(component);
			if (componentMapping == null)
			{
				componentMapping = MappingmodelFactory.eINSTANCE.createPatternMapping();
				MappingManager.setMapping(component, componentMapping);
			}			
			
			if (componentMapping.getBehaviorPattern() == null)
			{
				componentMapping.setBehaviorPattern("");
			}
			
			String newClassPattern = getCheckedMapping(PatternMapping.ALL_MARK, responsibilityMapping.getClassPattern(), componentMapping.getClassPattern());
			if (newClassPattern != null)
			{
				componentMapping.setClassPattern(newClassPattern);
			}
			
			String newPackagePattern = getCheckedMapping("", responsibilityMapping.getPackagePattern(), componentMapping.getPackagePattern());
			if (newPackagePattern != null)
			{
				componentMapping.setPackagePattern(newPackagePattern);
			}
			
			String newJavaFilePattern = getCheckedMapping("", responsibilityMapping.getJavaFilePattern(), componentMapping.getJavaFilePattern());
			if (newJavaFilePattern != null)
			{
				componentMapping.setJavaFilePattern(newJavaFilePattern);
			}			
		}
	}
	
	private static String getCheckedMapping(String descriptor, String responsibiliyMapping, String componentMapping)
	{
		StringTokenizer st = new StringTokenizer(responsibiliyMapping, "|");
		StringBuilder builder = null;
		String token;
		while(st.hasMoreTokens())
		{
			token = st.nextToken();
			if (componentMapping == null || componentMapping.indexOf(token) < 0)
			{
				if (builder == null)
				{
					builder = new StringBuilder();					
				}
				if (componentMapping != null)
				{
					builder.append(componentMapping);
					builder.append("|");
				}
				builder.append(descriptor);
				builder.append(token);
				builder.append("|");
			}
		}
		
		if (builder == null)
		{
			return null;
		}
		else
		{
			builder.deleteCharAt(builder.length()-1);
			return builder.toString();
		}
	}
}
