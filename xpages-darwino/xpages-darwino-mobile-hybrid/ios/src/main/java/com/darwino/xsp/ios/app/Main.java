/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;
/*!COPYRIGHT HEADER! - CONFIDENTIAL 
 *
 * Darwino Inc Confidential.
 *
 * (c) Copyright Darwino Inc 2014-2015.
 *
 * The source code for this program is not published or otherwise
 * divested of its trade secrets, irrespective of what has been
 * deposited with the U.S. Copyright Office.     
 */

import apple.NSObject;
import apple.foundation.NSDictionary;
import apple.uikit.UIApplication;
import apple.uikit.UIColor;
import apple.uikit.UINavigationController;
import apple.uikit.UIScreen;
import apple.uikit.UIWindow;
import apple.uikit.c.UIKit;
import apple.uikit.protocol.UIApplicationDelegate;

import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.objc.ann.Selector;

import com.darwino.commons.Platform;
import com.darwino.sqlite.IOSInstall;
import org.openntf.xpages.runtime.osgi.OSGiPatcher;

@RegisterOnStartup
public class Main extends NSObject implements UIApplicationDelegate {

    public static void main(String[] args) {
    	UIKit.UIApplicationMain(0, null, null, Main.class.getName());
    }

    @Selector("alloc")
    public static native Main alloc();

    protected Main(Pointer peer) {
        super(peer);
    }

    private UIWindow window;

    @Override
    public boolean applicationDidFinishLaunchingWithOptions(UIApplication application, NSDictionary<?, ?> launchOptions) {
    	Platform.setDevelopment(true);
    	try {
        	IOSInstall.init();
        } catch(Throwable t) {
        	t.printStackTrace();
        }

        //Class<?>[] keep = new Class<?>[] { com.darwino.platform.web.PluginDarwinoWeb.class, com.darwino.ios.platform.IOSPlatformLog };
        OSGiPatcher.initKnownBundles();

		try {
	        AppHybridApplication.create();
		} catch(Throwable t) {
			Platform.log(t);
			return false;
    }

        window = UIWindow.alloc().initWithFrame(UIScreen.mainScreen().bounds());
        window.setBackgroundColor(UIColor.lightGrayColor());
        
        UINavigationController navigationController = UINavigationController.alloc().initWithRootViewController(MainViewController.alloc().init());
        window.setRootViewController(navigationController);
        window.makeKeyAndVisible();

        return true;
    }
}
