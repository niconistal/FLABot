package org.isistan.flabot.util.edition;

/**
 * Adapts a data from the type F to the type T
 * @author da Costa Cambio
 *
 */
public interface DataAdapter<F, T> {
	T adapt(F data);

}
