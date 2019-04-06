package com.darwino.xsp.ios.app;

import com.darwino.commons.services.HttpService;
import com.darwino.commons.services.impl.AbstractServiceFactory;
import com.darwino.xsp.ios.app.services.GlobalResourceService;

public class GlobalResourceServiceFactory extends AbstractServiceFactory {
	private final GlobalResourceService service = new GlobalResourceService();

	public GlobalResourceServiceFactory() {
		super(".xsp/xsp/.ibmxspres");
	}

	@Override
	protected HttpService createService(String path, String pathInfo) {
		return service;
	}
}
