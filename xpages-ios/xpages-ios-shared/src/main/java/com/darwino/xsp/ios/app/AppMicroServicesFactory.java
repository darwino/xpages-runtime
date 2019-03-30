/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import com.darwino.commons.microservices.StaticJsonMicroServicesFactory;

import com.darwino.xsp.ios.app.microservices.HelloWorld;


/**
 * Application Micro Services Factory.
 * 
 * This is the place to define custom application micro services.
 */
public class AppMicroServicesFactory extends StaticJsonMicroServicesFactory {
	
	public AppMicroServicesFactory() {
		add(HelloWorld.NAME, new HelloWorld());
	}
}
