/**
 * 
 */
package org.isistan.flabot.report;

import java.util.Map;

import org.isistan.flabot.edit.editormodel.FlabotFileModel;

/**
 * Flabot report generator
 * @author mblech
 *
 */
public interface FlabotReportGenerator {
	
	/**
	 * Generate a report for the given flabot file using the given
	 * parameters, and save it using the given output file name
	 * 
	 * @param flabotFileModel the flabot file model
	 * @param parameters the extra parameters for the generator
	 * @param outputFileName the output file name
	 * @throws FlabotReportGeneratorException if an error occurs while trying to
	 * generate the report
	 */
	void generateReport(FlabotFileModel flabotFileModel,
			Map parameters, String outputFileName)
				throws FlabotReportGeneratorException;

}
