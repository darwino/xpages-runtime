package com.ibm.designer.domino.napi;

import com.darwino.commons.util.AbstractException;

public class NotesAPIException extends AbstractException {
	private static final long serialVersionUID = 1L;

	public NotesAPIException(Throwable nextException) {
		super(nextException);
	}

	public NotesAPIException(Throwable nextException, String msg, Object... params) {
		super(nextException, msg, params);
	}

}
