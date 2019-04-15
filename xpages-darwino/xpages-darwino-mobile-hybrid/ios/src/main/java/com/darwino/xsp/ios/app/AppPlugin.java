/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import java.util.List;

import com.darwino.mobile.platform.commands.CommandsExtension;



/**
 * IOS Plugin for registering the services.
 * 
 */
public class AppPlugin extends AppMobilePlugin {
	
	public AppPlugin() {
		super("IOS Application");
	}

	@Override
	public void findExtensions(Class<?> serviceClass, List<Object> extensions) {
		if(serviceClass==CommandsExtension.class) {
			extensions.add(new AppHybridActions());
		}
		super.findExtensions(serviceClass, extensions);
	}
}
