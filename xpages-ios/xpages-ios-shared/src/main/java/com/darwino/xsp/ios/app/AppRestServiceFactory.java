/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import java.util.List;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.HttpServiceContext;
import com.darwino.commons.services.rest.RestServiceBinder;
import com.darwino.commons.services.rest.RestServiceFactory;
import com.darwino.platform.DarwinoHttpConstants;

import com.darwino.xsp.ios.app.services.AppInformationRest;


/**
 * Application REST Services Factory.
 * 
 * This is the place to define custom application services.
 */
public class AppRestServiceFactory extends RestServiceFactory {
	
	public AppRestServiceFactory() {
		super(DarwinoHttpConstants.APPSERVICES_PATH);
	}
	
	@Override
	protected void createServicesBinders(List<RestServiceBinder> binders) {
		/////////////////////////////////////////////////////////////////////////////////
		// APP INFORMATION
		binders.add(new RestServiceBinder() {
			@Override
			public HttpService createService(HttpServiceContext context, String[] parts) {
				return new AppInformationRest();
			}
		});
	}	
}