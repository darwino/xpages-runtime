/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import android.os.Bundle;

import com.darwino.android.platform.hybrid.DarwinoHybridActivity;

import org.openntf.xpages.runtime.osgi.OSGiPatcher;

public class MainActivity extends DarwinoHybridActivity {
	
	public MainActivity() {
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		OSGiPatcher.initKnownBundles();
        loadMainPage();
	}
}
