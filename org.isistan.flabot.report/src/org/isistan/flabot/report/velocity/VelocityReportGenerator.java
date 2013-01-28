/**
 * 
 * 
 */
package org.isistan.flabot.report.velocity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.eclipse.core.runtime.Platform;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.StateDeterminationStrategy;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.mapper.WorkspaceMapper;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.report.FlabotReportGenerator;
import org.isistan.flabot.report.FlabotReportGeneratorException;
import org.isistan.flabot.report.ReportPlugin;
import org.isistan.flabot.util.problems.MessageAccumulator;

/**
 * Implementation of FlabotReportGenerator that uses apache velocity to generate
 * the reports
 * @author mblech
 *
 */
public class VelocityReportGenerator implements FlabotReportGenerator {
	
	public class MappingUtil {
		
		MessageAccumulator messageAccumulator = new MessageAccumulator();
		
		/**
		 * get the mapped behaviors for the given responsibility
		 */
		public JBehavior[] getMappedBehaviors(Responsibility responsibility) {
			Mapping mapping = MappingManager.getMapping(responsibility);
			if (mapping != null) {
				WorkspaceMapper mapper = mapping.getWorkspaceMapper();
				JBehavior[] behaviors = mapper.findBehaviors(mapping, messageAccumulator);
				return behaviors;
			}
			return new JBehavior[0];
		}
		
		public StateDeterminationStrategy getStateDeterminationStrategy(Responsibility responsibility){
			return ExecutionStateManager.getStateDeterminationStrategy(responsibility);
		}
		
		
		/**
		 * get the mapped classes for the given component
		 */
		public JClass[] getMappedClasses(ComponentModel component) {
			Mapping mapping = MappingManager.getMapping(component);
			if (mapping != null) {
				WorkspaceMapper mapper = mapping.getWorkspaceMapper();
				JClass[] classes = mapper.findClasses(mapping, true, messageAccumulator);
				return classes;
			}
			return new JClass[0];
		}

	}

	public class ArrayLengthUtil {
		/**
		 * Get the length of the given array (0 if null)
		 */
		public int getLength(Object[] array) {
			if (array!=null)
				return array.length;
			else
				return 0;
		}
	}

	/**
	 * Template file name parameter
	 */
	private static final String PARAMETER_TEMPLATE_FILENAME = "templateFileName";

	/**
	 * The default template's filename
	 */
	private static final String DEFAULT_TEMPLATE_FILENAME = getPluginPath() + "resource/templates/defaultReport.html.vm";
	
	private static VelocityEngine ve = null;
	
	private static VelocityEngine getVelocityEngine() throws Exception {
		if (ve == null) {
			ve = new VelocityEngine();
			ve.init();
		}
		return ve;
	}

	private static String getPluginPath() {
		try {
			return Platform.asLocalURL(ReportPlugin.getDefault().getBundle().getEntry("/")).getPath();
		} catch (IOException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.report.FlabotReportGenerator#generateReport(org.isistan.flabot.edit.editormodel.FlabotFileModel, java.util.Map, java.lang.String)
	 */
	public void generateReport(FlabotFileModel flabotFileModel, Map parameters,
			String outputFileName) throws FlabotReportGeneratorException {
		
		VelocityContext context = new VelocityContext();
		context.put("flabotFileModel", flabotFileModel);
		context.put("arrayLengthUtil", new ArrayLengthUtil());
		context.put("mappingUtil", new MappingUtil());
		
		String templateFilename = (String) parameters.get(PARAMETER_TEMPLATE_FILENAME);
		if (templateFilename == null) {
			templateFilename = DEFAULT_TEMPLATE_FILENAME;
		}
		
		try	{
			FileReader r = new FileReader(templateFilename);
			FileWriter w = new FileWriter(outputFileName);
			getVelocityEngine().evaluate(context, w, templateFilename, r);
			w.flush();
			r.close();
			w.close();
		}
		catch (Exception e) {
			throw new FlabotReportGeneratorException(e);
		}
	}

}
