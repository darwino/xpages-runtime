package com.darwino.xsp.ios.app.services;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.HttpServiceContext;
import com.darwino.j2ee.servlet.server.http.ServletServiceContext;
import com.darwino.xsp.wrapper.DarwinoServletConfigWrapper;
import com.darwino.xsp.wrapper.DarwinoServletContextWrapper;
import com.darwino.xsp.wrapper.DarwinoServletRequestWrapper;
import com.ibm.xsp.webapp.DesignerGlobalResourceServlet;

public class GlobalResourceService extends HttpService {
	private final DesignerGlobalResourceServlet delegate = new DesignerGlobalResourceServlet();
	private boolean initialized = false;

	@Override
	public void service(HttpServiceContext serviceContext) {
		try {
			initialize(serviceContext);

			// Delegate expects pathInfo to be e.g. "/dojoroot/dojo/dojo.js", not "/xsp/.ibmxspres/dojoroot/dojo/dojo.js"
			String prefix = "/.xsp/xsp/.ibmxspres";
			HttpServletRequest req = new DarwinoServletRequestWrapper(((ServletServiceContext)serviceContext).getHttpRequest(), prefix);
			HttpServletResponse res = ((ServletServiceContext)serviceContext).getHttpResponse();
			
			delegate.service(req, res);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private synchronized void initialize(HttpServiceContext serviceContext) throws ServletException {
		if(!this.initialized) {
			ServletContext context = new DarwinoServletContextWrapper(((ServletServiceContext)serviceContext).getServletContext());
			ServletConfig conf = new DarwinoServletConfigWrapper(context);
			delegate.init(conf);
			
			this.initialized = true;
		}
	}
}
