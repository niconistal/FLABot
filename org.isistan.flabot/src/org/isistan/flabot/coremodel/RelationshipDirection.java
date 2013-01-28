/**

import java.util.Arrays;
 * @model
 */
public class RelationshipDirection extends AbstractEnumerator {
  /**
   * @model name="Unspecified"
   */
  public static final int UNSPECIFIED = 0;

  /**
   * @model name="Source"
   */
  public static final int SOURCE = 1;

  /**
   * @model name="Target"
   */
  public static final int TARGET = 2;

  /**
   * @model name="Bidirectional"
   */
  public static final int BIDIRECTIONAL = 3;
	/**
	 * <!-- end-user-doc -->
	public static final RelationshipDirection UNSPECIFIED_LITERAL = new RelationshipDirection(UNSPECIFIED, "Unspecified", "Unspecified");

	/**
	 * <!-- end-user-doc -->
	public static final RelationshipDirection SOURCE_LITERAL = new RelationshipDirection(SOURCE, "Source", "Source");

	/**
	 * <!-- end-user-doc -->
	public static final RelationshipDirection TARGET_LITERAL = new RelationshipDirection(TARGET, "Target", "Target");

	/**
	 * <!-- end-user-doc -->
	public static final RelationshipDirection BIDIRECTIONAL_LITERAL = new RelationshipDirection(BIDIRECTIONAL, "Bidirectional", "Bidirectional");

	/**
	 * <!-- end-user-doc -->
	private static final RelationshipDirection[] VALUES_ARRAY =
		new RelationshipDirection[] {

	/**
	 * <!-- end-user-doc -->
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * <!-- end-user-doc -->
	public static RelationshipDirection get(int value) {

	/**

}