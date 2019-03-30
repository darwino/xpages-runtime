package com.darwino.xsp.wrapper;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class DarwinoServletConfigWrapper implements ServletConfig {
	
	private ServletContext servletContext;
	
	public DarwinoServletConfigWrapper(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public String getInitParameter(String param) {
		return servletContext.getInitParameter(param);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Enumeration getInitParameterNames() {
		return servletContext.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public String getServletName() {
		return "XPages Service";
	}

}
