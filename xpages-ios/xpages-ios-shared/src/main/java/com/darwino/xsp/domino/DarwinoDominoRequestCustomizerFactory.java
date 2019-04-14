package com.darwino.xsp.domino;

import javax.faces.context.FacesContext;

import com.darwino.commons.util.StringUtil;
import com.darwino.domino.notesbe.DarwinoDatabase;
import com.darwino.domino.notesbe.DarwinoNotesFactory;
import com.darwino.domino.notesbe.DarwinoSession;
import com.darwino.jsonstore.Session;
import com.darwino.platform.DarwinoContext;
import com.darwino.xsp.ios.app.AppDatabaseDef;
import com.ibm.domino.xsp.module.nsf.NotesContext;
import com.ibm.xsp.context.RequestCustomizerFactory;
import com.ibm.xsp.context.RequestParameters;

/**
 * This class exists to inject the Darwino Session and Database objects.
 * 
 * @author Jesse Gallagher
 *
 */
public class DarwinoDominoRequestCustomizerFactory extends RequestCustomizerFactory {

	@Override
	public void initializeParameters(FacesContext facesContext, RequestParameters parameters) {
		
		try {
			shimNotesContext();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void shimNotesContext() throws Exception {
		
		final Session darwinoSession = DarwinoContext.get().getSession();
		final DarwinoSession session = DarwinoNotesFactory.createSession(darwinoSession);
		final DarwinoDatabase database = (DarwinoDatabase)session.getDatabase(StringUtil.EMPTY_STRING, AppDatabaseDef.DATABASE_NAME);
		
		NotesContext.init(session, database);
	}
}
