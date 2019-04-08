package com.darwino.xsp.ios.app.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openntf.xpages.runtime.listener.JakartaConfigureCoreListener;
import org.openntf.xpages.runtime.util.XSPUtil;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.HttpServiceContext;
import com.darwino.j2ee.servlet.server.http.ServletServiceContext;
import com.darwino.xsp.platform.DarwinoPlatform;
import com.darwino.xsp.wrapper.DarwinoServletConfigWrapper;
import com.darwino.xsp.wrapper.DarwinoServletContextWrapper;
import com.darwino.xsp.wrapper.DarwinoServletRequestWrapper;
import com.ibm.commons.util.StringUtil;
import com.ibm.commons.util.io.StreamUtil;
import com.ibm.xsp.webapp.DesignerFacesServlet;
import com.ibm.xsp.webapp.DesignerGlobalResourceServlet;

public class XPagesService extends HttpService {
	private DesignerFacesServlet delegate;
	private JakartaConfigureCoreListener listener = new JakartaConfigureCoreListener();
	private boolean initialized;
	private DesignerGlobalResourceServlet globalResources;
	
	private File dojoRoot;

	@Override
	public void service(HttpServiceContext serviceContext) {
		try {
			init(serviceContext);
			
			HttpServletRequest req = new DarwinoServletRequestWrapper(((ServletServiceContext)serviceContext).getHttpRequest());
			HttpServletResponse res = ((ServletServiceContext)serviceContext).getHttpResponse();
			
			String pathInfo = StringUtil.toString(req.getPathInfo());
			if(!pathInfo.startsWith("/xsp/")) {
				delegate.service(req, res);
			} else if(pathInfo.startsWith("/xsp/.ibmxspres/")) {
				// globalResources expects pathInfo to be e.g. "/dojoroot/dojo/dojo.js", not "/xsp/.ibmxspres/dojoroot/dojo/dojo.js"
				String prefix = "/.xsp/xsp/.ibmxspres";
				req = new DarwinoServletRequestWrapper(((ServletServiceContext)serviceContext).getHttpRequest(), prefix);
				
				// TODO patch around the method the Dojo resource loader uses to get the resource input stream instead of overriding here
				if(!maybeWorkaroundAndroid(req, res)) {
					globalResources.service(req, res);
				}
			} else {
				// TODO replace with a real resources servlet if possible
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

	private synchronized void init(HttpServiceContext serviceContext) throws IOException {
		if(!this.initialized) {
			ServletContext context = new DarwinoServletContextWrapper(((ServletServiceContext)serviceContext).getServletContext());
			ServletConfig conf = new DarwinoServletConfigWrapper(context);
			ServletContextEvent sce = new ServletContextEvent(context);
			listener.contextInitialized(sce);
			
			this.delegate = new DesignerFacesServlet();
			this.globalResources = new DesignerGlobalResourceServlet();
			
			DarwinoPlatform.initContext(context);
			try {
				delegate.init(conf);
				globalResources.init(conf);
			} catch (ServletException e) {
				throw new RuntimeException(e);
			}
			
			// Expand the embedded Dojo resources
			// TODO move this to Android-only
			this.dojoRoot = File.createTempFile("dojo-underscores", "zip");
			this.dojoRoot.delete();
			this.dojoRoot.mkdirs();
			InputStream is = getClass().getResourceAsStream("/dojo-underscores.zip");
			if(is == null) {
				is = getClass().getResourceAsStream("dojo-underscores.zip");
			}
			if(is != null) {
				try {
					ZipInputStream zis = new ZipInputStream(is);
					try {
						ZipEntry entry = zis.getNextEntry();
						while(entry != null) {
							if(!entry.isDirectory()) {
								File dest = new File(this.dojoRoot, entry.getName().replace('/', File.separatorChar));
								dest.getParentFile().mkdirs();
								dest.deleteOnExit();
								OutputStream os = new FileOutputStream(dest);
								try {
									StreamUtil.copyStream(zis, os);
								} finally {
									os.close();
								}
							}
							
							entry = zis.getNextEntry();
						}
					} finally {
						zis.close();
					}
				} finally {
					is.close();
				}
			}
			
			this.initialized = true;
		}
	}
	
	private boolean maybeWorkaroundAndroid(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if(this.dojoRoot != null) {
			String p = StringUtil.toString(req.getPathInfo());
			if(p.startsWith("/dojoroot/") && p.contains("_")) {
				String subPath = p.substring("/dojoroot/".length());
				File file = new File(this.dojoRoot, "resources" + File.separatorChar + "dojo-version" + File.separatorChar + subPath.replace('/', File.separatorChar));
				if(file.exists()) {
					String contentType = URLConnection.guessContentTypeFromName(file.getName());
					if(StringUtil.isEmpty(contentType)) {
						contentType = "application/octet-stream";
					}
					res.setContentType(contentType);
					res.setContentLength((int)file.length());
					res.setStatus(HttpServletResponse.SC_OK);
					
					InputStream is = new FileInputStream(file);
					try {
						OutputStream os = res.getOutputStream();
						StreamUtil.copyStream(is, os);
					} finally {
						is.close();
					}
					
					return true;	
				}
			}
		}
		return false;
	}
}
