/**
 * $Id: SnapshotPredefinedCondition.java,v 1.3 2006/04/11 00:35:35 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.dialogs.conditions;

/**
 * @author usuario
 *
 */
public interface SnapshotPredefinedCondition extends PredefinedCondition{

	public static final int SNAPSHOT_TOSTRING_PROPERTY = 1 << 1;
	
	public static final int SNAPSHOT_FIELD_PROPERTY = 1 << 2;
	
	public static final int SNAPSHOT_OBJECT_PROPERTY = 1 << 3;
	
	public static final int SNAPSHOT_NULL_PROPERTY = 1 << 4;
	
	boolean acceptSnaptshot(int property);
}
