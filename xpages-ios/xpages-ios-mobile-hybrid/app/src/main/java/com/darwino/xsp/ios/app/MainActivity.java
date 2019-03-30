/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import android.os.Bundle;

import com.darwino.android.platform.hybrid.DarwinoHybridActivity;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

public class MainActivity extends DarwinoHybridActivity {
	
	public MainActivity() {
		//System.setProperty(DOMImplementationRegistry.PROPERTY, "com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");

	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        loadMainPage();
	}
}
