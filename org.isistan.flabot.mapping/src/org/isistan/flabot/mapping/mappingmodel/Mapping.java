/**

import org.eclipse.emf.ecore.EObject;
 * Represents a mapping to code
 * @author $Author: dacostae $
public interface Mapping extends EObject {
	boolean passes(JBehavior jBehavior);
}