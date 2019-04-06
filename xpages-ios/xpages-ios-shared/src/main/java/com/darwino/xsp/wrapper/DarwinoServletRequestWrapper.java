package com.darwino.xsp.wrapper;

import javax.servlet.http.HttpServletRequest;

import org.openntf.xpages.runtime.wrapper.JakartaServletRequestWrapper;

public class DarwinoServletRequestWrapper extends JakartaServletRequestWrapper {
	
	private final String prefix;

	public DarwinoServletRequestWrapper(HttpServletRequest delegate) {
		this(delegate, "/.xsp");
	}
	public DarwinoServletRequestWrapper(HttpServletRequest delegate, String prefix) {
		super(delegate);
		this.prefix = prefix;
	}
	
	@Override
	public String getPathInfo() {
		String path = super.getPathInfo();
		if(path.startsWith(this.prefix)) {
			path = path.substring(this.prefix.length());
		}
		int xspIndex = path.indexOf(".xsp");
		if(xspIndex > -1) {
			path = path.substring(xspIndex+".xsp".length());
		}
		if(path.isEmpty()) {
			return null;
		} else {
			return path;
		}
	}
	
	@Override
	public String getServletPath() {
		String url = getRequestURI();
		return url.substring(this.getContextPath().length());
	}
}
