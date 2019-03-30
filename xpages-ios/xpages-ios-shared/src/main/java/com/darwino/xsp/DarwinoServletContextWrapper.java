package com.darwino.xsp;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import org.openntf.xpages.runtime.wrapper.JakartaServletContextWrapper;

public class DarwinoServletContextWrapper extends JakartaServletContextWrapper {

	public DarwinoServletContextWrapper(ServletContext delegate) {
		super(delegate);
	}

	@Override
	public String getContextPath() {
		return super.getContextPath() + "/.xsp";
	}
	
	@Override
	public URL getResource(String path) throws MalformedURLException {
		URL result = super.getResource(path);
		if(result == null) {
			result = Thread.currentThread().getContextClassLoader().getResource(path);
		}
		return result;
	}
	
	@Override
	public InputStream getResourceAsStream(String path) {
		InputStream result = super.getResourceAsStream(path);
		if(result == null) {
			result = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		}
		return result;
	}
}
