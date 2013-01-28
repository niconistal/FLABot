package org.isistan.flabot.messages.util;

public class SpecialCharacterConversion {
	private char escapedCharacter;
	private char specialCharacter;
	
	public SpecialCharacterConversion(char escapedCharacter, char specialCharacter) {
		this.escapedCharacter=escapedCharacter;
		this.specialCharacter=specialCharacter;
	}

	public char getEscapedCharacter() {
		return escapedCharacter;
	}

	public char getSpecialCharacter() {
		return specialCharacter;
	}
}
