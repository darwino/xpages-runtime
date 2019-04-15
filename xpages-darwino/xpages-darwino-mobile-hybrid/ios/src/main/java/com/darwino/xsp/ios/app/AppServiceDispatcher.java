/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;


import com.darwino.commons.services.HttpServerContext;
import com.darwino.commons.services.HttpServiceFactories;
import com.darwino.commons.services.debug.DebugRestFactory;
import com.darwino.mobile.httpsrv.jetty.JettyDarwinoHttpServer;
import com.darwino.mobile.hybrid.platform.NanoHttpdDarwinoHttpServer;


public class AppServiceDispatcher extends JettyDarwinoHttpServer {
	
	public AppServiceDispatcher(HttpServerContext context) {
		super(context);
	}
	
	@Override
	public void addApplicationServiceFactories(HttpServiceFactories factories) {
		// Add the debug services
		//final DebugRestFactory debug = new DebugRestFactory();  
		//factories.add(debug);
	}
}
