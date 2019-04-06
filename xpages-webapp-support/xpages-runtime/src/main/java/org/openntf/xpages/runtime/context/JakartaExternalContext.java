package org.openntf.xpages.runtime.context;

import java.io.InputStream;

import javax.faces.context.ExternalContext;

import org.openntf.xpages.runtime.platform.JakartaPlatform;

import com.ibm.xsp.context.ExternalContextEx;

public class JakartaExternalContext extends ExternalContextEx {
	public JakartaExternalContext(ExternalContext delegate) {
		super(delegate);
	}

	@Override
	public String encodeResourceURL(String var1) {
		String result = super.encodeResourceURL(var1);
		// Patch around the parent's "/xsp" prefix
		// TODO do this more intelligently
		if(result.startsWith("/xsp/")) {
			return JakartaPlatform.getServletContext().getContextPath() + result;
		} else {
			return result;
		}
	}
	
	@Override
	public InputStream getResourceAsStream(String res) {
		InputStream is = super.getResourceAsStream(res);
		// Mobile app compatibility
		if(is == null && res != null && res.startsWith("/WEB-INF/")) {
			is = super.getResourceAsStream("/DARWINO-INF/" + res.substring("/WEB-INF/".length()));
			
			if(is == null) {
				is = super.getResourceAsStream(res.substring("/WEB-INF/".length()));
			}
		}
		return is;
	}

}
