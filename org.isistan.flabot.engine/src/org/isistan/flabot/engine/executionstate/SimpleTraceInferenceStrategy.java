/**
 * $Id: SimpleTraceInferenceStrategy.java,v 1.1 2006/01/27 00:10:12 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.engine.executionstate;

/**
 * Simple trace inference strategy: if the log is empty, returns NotExecuted;
 * if any tag contains an exception, returns Faulty; otherwise, it returns
 * Executed
 * @author $Author: mblech $
 * @model
 */
public interface SimpleTraceInferenceStrategy extends TraceInferenceStrategy {

}
