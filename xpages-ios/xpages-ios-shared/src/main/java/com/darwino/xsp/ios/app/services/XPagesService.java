package com.darwino.xsp.ios.app.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openntf.xpages.runtime.listener.JakartaConfigureCoreListener;
import org.openntf.xpages.runtime.platform.JakartaPlatform;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.HttpServiceContext;
import com.darwino.j2ee.servlet.server.http.ServletServiceContext;
import com.darwino.xsp.util.XSPUtil;
import com.darwino.xsp.wrapper.DarwinoServletConfigWrapper;
import com.darwino.xsp.wrapper.DarwinoServletContextWrapper;
import com.darwino.xsp.wrapper.DarwinoServletRequestWrapper;
import com.ibm.commons.util.StringUtil;
import com.ibm.commons.util.io.StreamUtil;
import com.ibm.xsp.webapp.DesignerFacesServlet;

public class XPagesService extends HttpService {
	private DesignerFacesServlet delegate;
	private JakartaConfigureCoreListener listener = new JakartaConfigureCoreListener();
	private boolean initialized;

	@Override
	public void service(HttpServiceContext serviceContext) {
		init(serviceContext);
		
		HttpServletRequest req = new DarwinoServletRequestWrapper(((ServletServiceContext)serviceContext).getHttpRequest());
		HttpServletResponse res = ((ServletServiceContext)serviceContext).getHttpResponse();
		
		try {
			String pathInfo = StringUtil.toString(req.getPathInfo());
			if(!pathInfo.startsWith("/xsp/")) {
				delegate.service(req, res);
			} else {
				// Service from a local file
				String resPath = pathInfo.substring("/xsp".length());
				InputStream is = XSPUtil.getResourceAsStream(Thread.currentThread().getContextClassLoader(), resPath);
				if(is != null) {
					try {
						String contentType = URLConnection.guessContentTypeFromName(resPath);
						res.setContentType(contentType);
						
						OutputStream os = res.getOutputStream();
						try {
							StreamUtil.copyStream(is, os);
						} finally {
							StreamUtil.close(os);
						}
					} finally {
						StreamUtil.close(is);
					}
				}
			}
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private synchronized void init(HttpServiceContext serviceContext) {
		if(!this.initialized) {
			ServletContext context = new DarwinoServletContextWrapper(((ServletServiceContext)serviceContext).getServletContext());
			ServletConfig conf = new DarwinoServletConfigWrapper(context);
			ServletContextEvent sce = new ServletContextEvent(context);
			listener.contextInitialized(sce);
			
			this.delegate = new DesignerFacesServlet();
			
			JakartaPlatform.initContext(context);
			try {
				delegate.init(conf);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			}
			
			this.initialized = true;
		}
	}
}
