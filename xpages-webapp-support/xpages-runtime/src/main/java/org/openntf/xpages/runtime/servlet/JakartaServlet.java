package org.openntf.xpages.runtime.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openntf.xpages.runtime.platform.JakartaPlatform;
import org.openntf.xpages.runtime.wrapper.JakartaServletConfigWrapper;
import org.openntf.xpages.runtime.wrapper.JakartaServletRequestWrapper;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.webapp.FacesResourceServlet;
import com.ibm.xsp.webapp.resources.JavaResourceProvider;
import com.ibm.xsp.webapp.resources.Resource;

@WebServlet(value="/")
public class JakartaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ServletConfig servletConfig;

	private JakartaFacesServlet delegate;
	private FacesResourceServlet resources = new FacesResourceServlet() {
		private static final long serialVersionUID = 1L;
		
	}; 

	public JakartaServlet() {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		servletConfig = config;
		
		this.delegate = new JakartaFacesServlet();
		
		ServletConfig conf = new JakartaServletConfigWrapper(config);
		JakartaPlatform.initContext(conf.getServletContext());
		delegate.init(conf);
		
		resources.addResourceProvider(new JavaResourceProvider("") {
			@Override
			public Resource getResource(HttpServletRequest paramHttpServletRequest, String paramString) {
				return super.getResource(paramHttpServletRequest, paramString);
			}
			@Override
			protected String getResourcePath(HttpServletRequest req, String path) {
				if(Thread.currentThread().getContextClassLoader().getResourceAsStream(path) != null) {
					return path;
				} else {
					return null;
				}
			}
		});
		resources.init(conf);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = StringUtil.toString(req.getServletPath());
		int xspIndex = path.indexOf(".xsp");
		if("/".equals(path)) {
			HttpServletRequest wrap = new JakartaServletRequestWrapper(req, "/", path);
			delegate.service(wrap, resp);
		} else  if(xspIndex > -1) {
			String pathInfo = path.substring(xspIndex+4);
			HttpServletRequest wrap = new JakartaServletRequestWrapper(req, path.substring(0, xspIndex+4), pathInfo.isEmpty() ? null : pathInfo);
			delegate.service(wrap, resp);
		} else {
			HttpServletRequest wrap = new JakartaServletRequestWrapper(req, "/", path);
			resources.service(wrap, resp);
		}
	}

	@Override
	public void destroy() {
		delegate.destroy();
	}
}