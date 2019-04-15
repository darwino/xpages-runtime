/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import java.util.List;

import com.darwino.commons.services.HttpServiceFactory;



/**
 * Main plugin class.
 * 
 * This class is used to register the common plugin services and is meant to be overloaded
 * by an actual implementation (J2EE, Mobile...).
 */
public class AppBasePlugin {
	
	public static void findExtensions(Class<?> serviceClass, List<Object> extensions) {
		if(serviceClass==HttpServiceFactory.class) {
			extensions.add(new XPagesServiceFactory());
		}
	}
}
