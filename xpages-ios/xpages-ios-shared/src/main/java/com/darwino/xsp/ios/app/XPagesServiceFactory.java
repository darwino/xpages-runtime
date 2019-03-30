package com.darwino.xsp.ios.app;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.impl.AbstractServiceFactory;
import com.darwino.xsp.ios.app.services.XPagesService;

public class XPagesServiceFactory extends AbstractServiceFactory {

	protected XPagesServiceFactory() {
		super(".xsp");
	}
	
	@Override
	protected HttpService createService(String path, String pathInfo) {
		return new XPagesService();
	}
}
