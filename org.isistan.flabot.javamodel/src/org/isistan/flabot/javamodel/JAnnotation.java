/**


/**
 * The common interface extended by all annotation types.  Note that an
 * interface that manually extends this one does <i>not</i> define
 * an annotation type.  Also note that this interface does not itself
 * define an annotation type.
 *
 * @author $Author: dacostae $
 * @since   1.5
 */
public interface JAnnotation extends
			JObject {
    /**
     * Returns the annotation type of this annotation.
     */
    JClass annotationType();
}