package com.darwino.xsp.wrapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.openntf.xpages.runtime.wrapper.JakartaServletRequestWrapper;

public class DarwinoServletRequestWrapper extends JakartaServletRequestWrapper {
	
	private final String prefix;
	private final DarwinoServletContextWrapper context;

	public DarwinoServletRequestWrapper(DarwinoServletContextWrapper servletContext, HttpServletRequest req) {
		this(servletContext, req, "/.xsp");
	}
	public DarwinoServletRequestWrapper(DarwinoServletContextWrapper servletContext, HttpServletRequest req, String prefix) {
		super(req);
		this.prefix = prefix;
		this.context = servletContext;
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
	
	@Override
	public ServletContext getServletContext() {
		return context;
	}
}
