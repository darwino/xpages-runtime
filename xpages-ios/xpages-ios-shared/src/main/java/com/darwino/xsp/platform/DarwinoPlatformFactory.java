package com.darwino.xsp.platform;

import com.ibm.commons.Platform;
import com.ibm.commons.platform.IPlatformFactory;

public class DarwinoPlatformFactory implements IPlatformFactory {
	@Override
	public Platform createPlatform() {
		return new DarwinoPlatform();
	}

}
