package com.ibm.domino.napi;

import com.darwino.commons.util.AbstractException;

public class NException extends AbstractException {
	private static final long serialVersionUID = 1L;

	public NException(Throwable nextException) {
		super(nextException);
	}

	public NException(Throwable nextException, String msg, Object... params) {
		super(nextException, msg, params);
	}

}
