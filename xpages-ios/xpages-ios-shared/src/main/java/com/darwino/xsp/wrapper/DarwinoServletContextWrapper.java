package com.darwino.xsp.wrapper;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.openntf.xpages.runtime.util.XSPUtil;
import org.openntf.xpages.runtime.wrapper.JakartaServletContextWrapper;

public class DarwinoServletContextWrapper extends JakartaServletContextWrapper {
	
	private final HttpServletRequest req;

	public DarwinoServletContextWrapper(ServletContext delegate, HttpServletRequest req) {
		super(delegate);
		this.req = new DarwinoServletRequestWrapper(this, req);
	}

	@Override
	public String getContextPath() {
		return super.getContextPath() + "/.xsp";
	}
	
	@Override
	public URL getResource(String path) throws MalformedURLException {
		URL result = super.getResource(path);
		if(result == null) {
			result = XSPUtil.getResource(path, Thread.currentThread().getContextClassLoader());
		}
		return result;
	}
	
	@Override
	public InputStream getResourceAsStream(String path) {
		InputStream result = super.getResourceAsStream(path);
		if(result == null) {
			result = XSPUtil.getResourceAsStream(path, Thread.currentThread().getContextClassLoader());
		}
		return result;
	}
	
	public HttpServletRequest getHttpRequest() {
		return req;
	}
}
