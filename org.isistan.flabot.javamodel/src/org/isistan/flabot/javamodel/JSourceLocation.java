package org.isistan.flabot.javamodel;

/**
 * Contains information about source.
 * @author da Costa Cambio
 *
 */
public class JSourceLocation {
	
	/**
	 * The unknown value, for line, offset and length
	 */
	public static final int UNKNOWN_VALUE=-1;
	
	/**
	 * A default unknown location
	 */
	public static final JSourceLocation UNKNOWN=new JSourceLocation();

	private int line;

	private int offset;

	private int length;
	
	/**
	 * Creates a source location with unknown line, offset and
	 * length
	 *
	 */
	public JSourceLocation() {
		this(UNKNOWN_VALUE, UNKNOWN_VALUE, UNKNOWN_VALUE);
	}
	/**
	 * Creates a source location with unknown offset and
	 * endCharacter
	 * @param line
	 */
	public JSourceLocation(int line) {
		this(line, UNKNOWN_VALUE, UNKNOWN_VALUE);
	}
	
	/**
	 * Creates a source location with unknown line
	 * @param offset
	 * @param length
	 */
	public JSourceLocation(int offset, int length) {
		this(UNKNOWN_VALUE, offset, length);
	}
	
	/**
	 * Creates a source location with known line, offset and
	 * length
	 * @param line
	 * @param offset
	 * @param length
	 */
	public JSourceLocation(int line, int offset, int length) {
		this.line=line;
		this.offset=offset;
		this.length=length;
	}

	/**
	 * Returns the line in which the element is declared
	 * @return
	 */
	public int getLine() {
		return line;
	}
	
	/**
	 * Returns the offset where the declaration starts
	 * @return
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * Returns the length of the declaration
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Returns the offset where the declaration ends.
	 * It is equal to offset+length if both are known,
	 * otherwise it is UNKNOWN_VALUE (-1)
	 * @return
	 */
	public int getEndOffset() {
		if(offset==UNKNOWN_VALUE || length==UNKNOWN_VALUE) {
			return UNKNOWN_VALUE;
		}
		return offset+length;
	}
}
