package util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public enum RuntimeEnvironment {
	DOMINO, ANDROID, JEE;
	
	public static RuntimeEnvironment current() {
		String javaVendor = System.getProperty("java.vendor"); //$NON-NLS-1$
		if("The Android Project".equals(javaVendor)) { //$NON-NLS-1$
			return ANDROID;
		}
		
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String serverName = req.getSession().getServletContext().getServerInfo();
		if("XPages-Domino Web Container".equals(serverName)) { //$NON-NLS-1$
			return DOMINO;
		}
		
		return JEE;
	}
}
