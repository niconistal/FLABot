/**

import java.util.HashMap;
 * This class is used to aviod the gauge consumers to fire events
 * @author $Author: dacostae $
 *
 */
public class NotifyingState {
	private static Map<Thread, ObjectBoolean> notifyings=new HashMap<Thread, ObjectBoolean>();
	
	/**
	 * Sets a notifying state for de current thread
	 * see @see org.isistan.flabot.gauge.GaugeManager#notify
	 * @param value
	 * @return true if value is false or if value is true and the current state is false, false otherwise
	 */
	public static boolean setNotifying(boolean value) {
		ObjectBoolean notifying = notifyings.get(Thread.currentThread());
		if(notifying==null) {
			notifying=new ObjectBoolean(value);
			return true;
		}
			
		if(!value) {
			notifying.value=false;
			return true;
		} else {
			if(notifying.value==false) {
				notifying.value=true;
				return true;
			} else {
				return false;
			}
		}			
	}
}