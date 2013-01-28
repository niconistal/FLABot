package org.isistan.flabot.executionstatemapping.messages.util;


public class ArgumentsReplacer {
	private static final int ACTION_NORMAL=0;
	private static final int ACTION_STORE=1;
	private static final int ACTION_IGNORE=2;
	private static final int ACTION_REPLACE=3;
	private static final int ACTION_CLEAR=4;
	private static final int ACTION_ESCAPED_BACKSLASH=5;
	private static final int ACTION_BACKSLASH=6;

	private static final int CHAR_NORMAL=0;
	private static final int CHAR_BACKSLASH=1;
	private static final int CHAR_BRACKET_OPEN=2;
	private static final int CHAR_BRACKET_CLOSE=3;
	private static final int CHAR_DIGIT=4;
	private static final int CHAR_EOF=5;
	private static final int CHARS=6;
	
	private static final int STATE_NORMAL=0;
	private static final int STATE_ESCAPE=1;
	private static final int STATE_STORING=2;
	private static final int STATES=3;
	private static final int STATE_END=3; //doesn't count

	private static class Transition {
		private Transition(int nextState, int action) {
			this.nextState=nextState;
			this.action=action;
		}
		private int nextState;
		private int action;
	}
	

	private static final Transition[][] TRANSITIONS=getTransitions();

	private static Transition[][] getTransitions() {
		Transition[][] transitions=new Transition[STATES][CHARS];
		transitions[STATE_NORMAL][CHAR_NORMAL]=new Transition(STATE_NORMAL, ACTION_NORMAL);
		transitions[STATE_NORMAL][CHAR_BACKSLASH]=new Transition(STATE_ESCAPE, ACTION_IGNORE);
		transitions[STATE_NORMAL][CHAR_BRACKET_OPEN]=new Transition(STATE_STORING, ACTION_IGNORE);
		transitions[STATE_NORMAL][CHAR_BRACKET_CLOSE]=new Transition(STATE_NORMAL, ACTION_NORMAL);
		transitions[STATE_NORMAL][CHAR_DIGIT]=new Transition(STATE_NORMAL, ACTION_NORMAL);
		transitions[STATE_NORMAL][CHAR_EOF]=new Transition(STATE_END, ACTION_IGNORE);
		transitions[STATE_ESCAPE][CHAR_NORMAL]=new Transition(STATE_NORMAL, ACTION_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_BACKSLASH]=new Transition(STATE_NORMAL, ACTION_ESCAPED_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_BRACKET_OPEN]=new Transition(STATE_NORMAL, ACTION_NORMAL);
		transitions[STATE_ESCAPE][CHAR_BRACKET_CLOSE]=new Transition(STATE_NORMAL, ACTION_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_DIGIT]=new Transition(STATE_NORMAL, ACTION_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_EOF]=new Transition(STATE_END, ACTION_ESCAPED_BACKSLASH);
		transitions[STATE_STORING][CHAR_NORMAL]=new Transition(STATE_NORMAL, ACTION_CLEAR);
		transitions[STATE_STORING][CHAR_BACKSLASH]=new Transition(STATE_NORMAL, ACTION_CLEAR);
		transitions[STATE_STORING][CHAR_BRACKET_OPEN]=new Transition(STATE_STORING, ACTION_CLEAR);
		transitions[STATE_STORING][CHAR_BRACKET_CLOSE]=new Transition(STATE_NORMAL, ACTION_REPLACE);
		transitions[STATE_STORING][CHAR_DIGIT]=new Transition(STATE_STORING, ACTION_STORE);
		transitions[STATE_STORING][CHAR_EOF]=new Transition(STATE_END, ACTION_CLEAR);
		return transitions;
	}
	
	
	public static String replace(String string, Object... arguments) {
		if(string==null || string.length()==0 || string.indexOf('{')==-1 || string.indexOf('}')==-1 || arguments==null || arguments.length==0) {
			return string;
		}
		int state=STATE_NORMAL;
		StringBuffer stored=new StringBuffer();
		StringBuffer result=new StringBuffer();
		for(int i=0 ; i<=string.length(); i++) {
			int c=CHAR_EOF;
			char ch='\0';
			if(i<string.length()) {
				ch=string.charAt(i);
				if(ch=='{') {
					c=CHAR_BRACKET_OPEN;
				} else if(ch=='}') {
					c=CHAR_BRACKET_CLOSE;
				} else if(ch=='{') {
					c=CHAR_BRACKET_OPEN;
				} else if(ch=='\\') {
					c=CHAR_BACKSLASH;
				} else if(ch>='0' && ch<='9') {
					c=CHAR_DIGIT;
				} else {
					c=CHAR_NORMAL;
				}
			}
			Transition transition=TRANSITIONS[state][c];
			state=transition.nextState;
			int action=transition.action;
			if(action==ACTION_NORMAL) {
				if(c!=CHAR_EOF)
					result.append(ch);
			} else if(action==ACTION_STORE) {
				stored.append(ch);
			} else if(action==ACTION_IGNORE) {
			} else if(action==ACTION_REPLACE) {
				result.append(getArgument(Integer.parseInt(stored.toString()), arguments));
				stored=new StringBuffer();
			} else if(action==ACTION_CLEAR) {
				result.append('{');
				result.append(stored);
				if(c!=CHAR_EOF)
					result.append(ch);
				stored=new StringBuffer();
			} else if(action==ACTION_ESCAPED_BACKSLASH) {
				result.append('\\');
			} else if(action==ACTION_BACKSLASH) {
				result.append('\\');
				if(c!=CHAR_EOF)
					result.append(ch);
			}
		}
		return result.toString();
	}


	private static String getArgument(int index, Object... arguments) {
		if(index<0 || index>=arguments.length) {
			return "{" + index + '}'; //$NON-NLS-1$
		}
		Object argument=arguments[index];
		if(argument==null)
			return "null"; //$NON-NLS-1$
		else
			return argument.toString();
	}
	

}
