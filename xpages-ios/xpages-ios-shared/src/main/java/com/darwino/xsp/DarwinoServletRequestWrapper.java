package com.darwino.xsp;

import javax.servlet.http.HttpServletRequest;

import org.openntf.xpages.runtime.wrapper.JakartaServletRequestWrapper;

public class DarwinoServletRequestWrapper extends JakartaServletRequestWrapper {

	public DarwinoServletRequestWrapper(HttpServletRequest delegate) {
		super(delegate);
	}
	
	@Override
	public String getPathInfo() {
		String path = super.getPathInfo();
		if(path.startsWith("/.xsp")) {
			path = path.substring("/.xsp".length());
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
