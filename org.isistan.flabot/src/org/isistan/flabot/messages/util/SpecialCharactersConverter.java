package org.isistan.flabot.messages.util;


public class SpecialCharactersConverter {
	private static final int ACTION_NORMAL=0;
	private static final int ACTION_IGNORE=1;
	private static final int ACTION_CONVERT=2;
	private static final int ACTION_BACKSLASH=3;
	private static final int ACTION_ESCAPED_BACKSLASH=4;

	private static final int CHAR_NORMAL=0;
	private static final int CHAR_BACKSLASH=1;
	private static final int CHAR_SPECIAL=2;
	private static final int CHAR_EOF=3;
	private static final int CHARS=4;
	
	private static final int STATE_NORMAL=0;
	private static final int STATE_ESCAPE=1;
	private static final int STATES=2;
	private static final int STATE_END=2; //doesn't count

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
		transitions[STATE_NORMAL][CHAR_SPECIAL]=new Transition(STATE_NORMAL, ACTION_NORMAL);
		transitions[STATE_NORMAL][CHAR_EOF]=new Transition(STATE_END, ACTION_IGNORE);
		transitions[STATE_ESCAPE][CHAR_NORMAL]=new Transition(STATE_NORMAL, ACTION_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_BACKSLASH]=new Transition(STATE_NORMAL, ACTION_ESCAPED_BACKSLASH);
		transitions[STATE_ESCAPE][CHAR_SPECIAL]=new Transition(STATE_NORMAL, ACTION_CONVERT);
		transitions[STATE_ESCAPE][CHAR_EOF]=new Transition(STATE_END, ACTION_ESCAPED_BACKSLASH);
		return transitions;
	}
	
	
	
	public static SpecialCharacterConversion[] STANDAR_CONVERSION=new SpecialCharacterConversion[] {
		new SpecialCharacterConversion('n','\n'),
		new SpecialCharacterConversion('r','\r'),
		new SpecialCharacterConversion('t','\t')
	};
	
	public static String convertSpecialCharacters(String string) {
		return convertSpecialCharacters(string, STANDAR_CONVERSION);
	}
	public static String convertSpecialCharacters(String string, SpecialCharacterConversion[] specialCharacterConversion) {
		if(string==null || string.length()==0 || string.indexOf('\\')==-1) {
			return string;
		}
		int state=STATE_NORMAL;
		StringBuffer stored=new StringBuffer();
		StringBuffer result=new StringBuffer();
		for(int i=0 ; i<=string.length(); i++) {
			int c=CHAR_EOF;
			char ch='\0';
			SpecialCharacterConversion conversion=null;
			if(i<string.length()) {
				ch=string.charAt(i);
				conversion=getConversion(ch, specialCharacterConversion);
				if(ch=='\\') {
					c=CHAR_BACKSLASH;
				} else if(conversion!=null) {
					c=CHAR_SPECIAL;
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
			} else if(action==ACTION_CONVERT) {
				stored.append(conversion.getSpecialCharacter());
			} else if(action==ACTION_IGNORE) {
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



	private static SpecialCharacterConversion getConversion(char ch, SpecialCharacterConversion[] specialCharacterConversion) {
		for (SpecialCharacterConversion conversion : specialCharacterConversion) {
			if(ch==conversion.getEscapedCharacter())
				return conversion;
		}
		return null;
	}
}
