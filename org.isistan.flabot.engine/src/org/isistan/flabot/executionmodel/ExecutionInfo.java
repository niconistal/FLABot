/**


import org.eclipse.emf.common.util.EList;
 * @model
 */

public interface ExecutionInfo extends EObject {
	
	/**
	 * @model type="ExecutionStep" containment="true"
	 * @deprecated
	 */
	@Deprecated
	
	ExecutionStep addExecutionStep(ExecutionContext context, Diagnostic diagnosticToSource, Diagnostic DiagnosticToTarget);
}