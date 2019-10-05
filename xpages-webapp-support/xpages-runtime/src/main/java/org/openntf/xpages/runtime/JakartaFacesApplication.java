/**
 * Copyright © 2019 Jesse Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openntf.xpages.runtime;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.application.ApplicationExImpl;
import com.ibm.xsp.application.DesignerApplicationEx;
import com.ibm.xsp.application.ViewHandlerEx;
import com.ibm.xsp.application.ViewHandlerExImpl;
import com.ibm.xsp.factory.FactoryLookup;
import com.ibm.xsp.library.FacesClassLoader;
import com.ibm.xsp.page.FacesPageDriver;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;

import org.openntf.xpages.runtime.xsp.JakartaFacesClassLoader;
import org.openntf.xpages.runtime.xsp.JakartaFacesPageDriver;
import org.openntf.xpages.runtime.xsp.JakartaFactoryLookup;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JakartaFacesApplication extends DesignerApplicationEx {
	private static final Logger log = Logger.getLogger(JakartaFacesApplication.class.getName());
	
	private FactoryLookup factoryLookup;
	private ViewHandler viewHandler;

	protected JakartaFacesApplication(Application application) {
		super(application);

		try {
			Field factoryLookupField = ApplicationExImpl.class.getDeclaredField("_factoryLookup");
			factoryLookupField.setAccessible(true);
			factoryLookupField.set(this, getFactoryLookup());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.registerCustomControls();
	}
	
	private void registerCustomControls() {
		URL controls = Thread.currentThread().getContextClassLoader().getResource("/WEB-INF/controls");
		if(controls != null) {
			if(log.isLoggable(Level.WARNING)) {
				log.warning("searching for controls in " + controls);
			}
			
			switch(StringUtil.toString(controls.getProtocol())) {
			case "file":
				try {
					Path path = Paths.get(controls.toURI());
					Files.find(path, 1, (file, attrs) ->
						file.getFileName().toString().endsWith(".xsp-config")
					).forEach(config -> {
						System.out.println("registering " + config);
					});
				} catch (IOException | URISyntaxException e) {
					throw new RuntimeException(e);
				}
				break;
			case "jar":
				// TODO figure out, and maybe account for "wsjar"
				break;
			}
		}
	}

	@Override
	public synchronized ViewHandler getViewHandler() {
		if (this.viewHandler == null) {
			ViewHandler sup = super.getViewHandler();
			if (!(sup instanceof ViewHandlerEx)) {
				FacesClassLoader cl = new JakartaFacesClassLoader(getDesignerApplication());
				FacesPageDriver driver = new JakartaFacesPageDriver(cl);
				ViewHandlerExImpl result = new ViewHandlerExImpl(sup);
				result.setPageDriver(driver);
				this.viewHandler = result;
			} else {
				this.viewHandler = sup;
			}
		}
		return this.viewHandler;
	}

	@Override
	public FactoryLookup getFactoryLookup() {
		if (this.factoryLookup == null) {
			this.factoryLookup = new JakartaFactoryLookup(super.getFactoryLookup());
		}
		return this.factoryLookup;
	}

	@Override
	public String getApplicationProperty(String s, String s1) {
		String prop = super.getApplicationProperty(s, s1);
		return prop;
	}

	@Override
	protected ResourceBundle loadResourceBundle(String s, Locale locale) throws IOException {
		return super.loadResourceBundle(s, locale);
	}

	@Override
	public List<?> findServices(String s) {
		List<?> svc = super.findServices(s);
		return svc;
	}
}
