/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import javax.servlet.ServletContext;

import com.darwino.commons.json.JsonException;
import com.darwino.commons.platform.ManagedBeansService;
import com.darwino.j2ee.application.DarwinoJ2EEApplication;
import com.darwino.jsonstore.meta.DatabaseCustomizer;
import com.darwino.platform.DarwinoManifest;
import com.darwino.sql.drivers.DBDriver;

/**
 * J2EE application.
 */
public class AppJ2EEApplication extends DarwinoJ2EEApplication {
	
	public static DarwinoJ2EEApplication create(ServletContext context) throws JsonException {
		if(!DarwinoJ2EEApplication.isInitialized()) {
			AppJ2EEApplication app = new AppJ2EEApplication(
					context,
					new AppManifest(new AppJ2EEManifest())
			);
			app.init();
		}
		return DarwinoJ2EEApplication.get();
	}
	
	protected AppJ2EEApplication(ServletContext context, DarwinoManifest manifest) {
		super(context,manifest);
	}
	
	@Override
	public String[] getConfigurationBeanNames() {
		return new String[] {getManifest().getConfigId(),ManagedBeansService.LOCAL_NAME,ManagedBeansService.DEFAULT_NAME};
	}
	
	@Override
	protected DatabaseCustomizer findDatabaseCustomizerFactory(DBDriver driver, String dbName) {
		return new AppDatabaseCustomizer(driver); 
	}
	
}
