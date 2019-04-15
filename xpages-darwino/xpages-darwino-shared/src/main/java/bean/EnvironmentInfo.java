package bean;

import java.io.Serializable;

import util.RuntimeEnvironment;

public class EnvironmentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	public String getPlatformName() {
		RuntimeEnvironment env = RuntimeEnvironment.current();
		switch(env) {
		case ANDROID:
			return "Android"; //$NON-NLS-1$
		case DOMINO:
			return "Domino"; //$NON-NLS-1$
		case JEE:
			return "Java EE"; //$NON-NLS-1$
		default:
			return env.name();
		}
	}
	
	public String getIconPath() {
		RuntimeEnvironment env = RuntimeEnvironment.current();
		switch(env) {
		case DOMINO:
			return "/$Icon"; //$NON-NLS-1$
		default:
			return "/icon-" + env.name() + ".png"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
