/**
 * $Id: WorkaroundURIConverter.java,v 1.2 2006/02/03 21:03:01 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.util.emf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;

/**
 * @author $Author: dacostae $
 *
 */
public class WorkaroundURIConverter extends URIConverterImpl {
	
	@Override
	protected InputStream createURLInputStream(URI uri) throws IOException {
		URL url = new URL(uri.toString());
		if (url.getHost() == null || url.getHost().trim().equals(""))
			throw new IOException("http host can't be null");
		else
			return super.createURLInputStream(uri);
	}

}
