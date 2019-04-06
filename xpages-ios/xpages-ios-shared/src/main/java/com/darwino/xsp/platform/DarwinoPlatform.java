package com.darwino.xsp.platform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletContext;

import org.openntf.xpages.runtime.JakartaAppExecutionContext;
import org.openntf.xpages.runtime.JakartaApplication;
import org.openntf.xpages.runtime.platform.JakartaPlatform;

import com.darwino.commons.util.io.StreamUtil;
import com.ibm.commons.platform.WebAppServerPlatform;
import com.ibm.commons.util.StringUtil;
import com.ibm.designer.runtime.Application.IApplicationFinder;
import com.ibm.designer.runtime.ApplicationException;
import com.ibm.xsp.context.DojoLibraryFactory;

public class DarwinoPlatform extends WebAppServerPlatform {
	private static ServletContext servletContext;

	public static void initContext(ServletContext servletContext) {
		DarwinoPlatform.servletContext = servletContext;
		JakartaPlatform.initContext(servletContext);
	}
	public static ServletContext getServletContext() {
		return servletContext;
	}

	private File installationDirectory;
	private File userDataDirectory;
	private File propertiesDirectory;
	private File xspDirectory;
	private File nsfDirectory;
	private File styleKitsDirectory;
	private File serverDirectory;
	private Properties xspProperties;

	public DarwinoPlatform() {
		super();

		installationDirectory = new File(System.getProperty("user.dir"));
		this.xspProperties = this.loadStaticProperties();
		
		DojoLibraryFactory.initializeLibraries();
		
		try {
			File zipOut = File.createTempFile("xpages", "");
			zipOut.delete();
			zipOut.mkdirs();
			try(InputStream is = getClass().getResourceAsStream("/xpages.zip")) {
				try(ZipInputStream zis = new ZipInputStream(is)) {
					ZipEntry entry = zis.getNextEntry();
					while(entry != null) {
						if(entry.isDirectory()) {
							File subdir = new File(zipOut, entry.getName().replace('/', File.separatorChar));
							subdir.mkdirs();
						} else {
							File out = new File(zipOut, entry.getName().replace('/', File.separatorChar));
							FileOutputStream fos = new FileOutputStream(out);
							try {
								StreamUtil.copyStream(zis, fos);
							} finally {
								StreamUtil.close(fos);
							}
						}
						
						entry = zis.getNextEntry();
					}
				}
			}

			userDataDirectory = zipOut;
			xspDirectory = new File(userDataDirectory, "xsp");
			nsfDirectory = new File(xspDirectory, "nsf");
			styleKitsDirectory = new File(nsfDirectory, "themes");
			propertiesDirectory = new File(userDataDirectory, "properties");
			serverDirectory = new File(userDataDirectory, StringUtil.replace("java/xsp", '/', File.separatorChar));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object getObject(String s) {
		if("com.ibm.xsp.designer.ApplicationFinder".equals(s)) {
			return (IApplicationFinder) () -> {
				try {
					JakartaAppExecutionContext ctx = new JakartaAppExecutionContext(servletContext);
					return new JakartaApplication(ctx);
				} catch (ApplicationException e) {
					throw new RuntimeException(e);
				}
			};
		} else {
			return super.getObject(s);
		}
	}
	
	@Override
	public File getGlobalResourceFile(String path) {
		if(path.startsWith("/stylekits/")) {
			return new File(styleKitsDirectory, path.substring("/stylekits/".length()));
		}
		if(path.startsWith("/server/")) {
			return new File(serverDirectory, path.substring("/server/".length()));
		}
		if(path.startsWith("/global/")) {
			return new File(serverDirectory, path.substring("/global/".length()));
		}
		if(path.startsWith("/properties/")) {

			if (userDataDirectory != null) {
				File localFile = new File(userDataDirectory, "properties/" + path.substring("/properties/".length()));
				if (localFile.exists()) {
					return localFile;
				}
			}

			return new File(propertiesDirectory, path.substring("/properties/".length()));
		}
		return super.getGlobalResourceFile(path);
	}
	
	@Override
	public String getProperty(String prop) {
		String var2;
		if (this.xspProperties != null) {
			var2 = this.xspProperties.getProperty(prop);
			if (StringUtil.isNotEmpty(var2)) {
				return var2;
			}
		}
		return super.getProperty(prop);
	}
	
	@Override
	public boolean isPlatform(String name) {
		if("Darwino Application".equals(name)) {
			return true;
		} else {
			return super.isPlatform(name);
		}
	}

	@Override
	public File getInstallationDirectory() {
		return installationDirectory;
	}

	@Override
	public File getResourcesDirectory() {
		return userDataDirectory;
	}

	protected Properties loadStaticProperties() {
		return new Properties();
	}
	
	@Override
	public String getName() {
		return "Darwino Application";
	}
	
}