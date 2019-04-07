package org.openntf.xpages.runtime.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import com.ibm.commons.util.StringUtil;

public enum XSPUtil {
	;
	
	public static URL getResource(ClassLoader cl, String path) {
		URL result = cl.getResource(path);
		if(result == null && path != null && path.startsWith("/")) {
			// Try without the leading slash
			result = cl.getResource(path.substring(1));
		}
		return result;
	}
	
	public static InputStream getResourceAsStream(ClassLoader cl, String path) {
		InputStream result = cl.getResourceAsStream(path);
		if(result == null && path != null && path.startsWith("/")) {
			result = cl.getResourceAsStream(path.substring(1));
		}
		return result;
	}
	
	public static Enumeration<URL> getResources(ClassLoader cl, String p) throws IOException {
		String path = StringUtil.toString(p);
		
		Enumeration<URL> result = cl.getResources(path);
		if((result == null || !result.hasMoreElements()) && path != null && path.startsWith("/")) {
			result = cl.getResources(path.substring(1));
		}
		
		if((result == null || !result.hasMoreElements()) && path != null && path.startsWith("/")) {
			result = Thread.currentThread().getContextClassLoader().getResources(path.substring(1));
		}
		
		return result;
	}
}
