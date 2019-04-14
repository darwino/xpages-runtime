package com.darwino.xsp.domino;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.darwino.commons.json.JsonException;
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
import com.ibm.xsp.domino.el.DominoImplicitObjectFactory;
import com.ibm.xsp.util.TypedUtil;

import lotus.domino.Database;
import lotus.domino.NotesException;

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
			shimImplicitObjects(facesContext);
			
			shimNotesContext();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void shimImplicitObjects(FacesContext facesContext) throws NotesException, JsonException {
//		Map<String, Object> sessionScope = TypedUtil.getSessionMap(facesContext.getExternalContext());
//		Session darwinoSession = DarwinoContext.get().getSession();
//		DarwinoSession session = DarwinoNotesFactory.createSession(darwinoSession);
//		sessionScope.put(DominoImplicitObjectFactory.KEY_SESSION, session);
//		
//		// TODO switch to a system session
//		sessionScope.put(DominoImplicitObjectFactory.KEY_SESSIONASSIGNER, session);
//		sessionScope.put(DominoImplicitObjectFactory.KEY_SESSIONASSIGNERWITHFULLACCESS, session);
//		
//		sessionScope.put(DominoImplicitObjectFactory.KEY_DATABASE, session.getDatabase("", AppDatabaseDef.DATABASE_NAME)); //$NON-NLS-1$
	}
	
	private void shimNotesContext() throws Exception {
		
		final Session darwinoSession = DarwinoContext.get().getSession();
		final DarwinoSession session = DarwinoNotesFactory.createSession(darwinoSession);
		final DarwinoDatabase database = (DarwinoDatabase)session.getDatabase(StringUtil.EMPTY_STRING, AppDatabaseDef.DATABASE_NAME);
		
		NotesContext.init(session, database);
	}
}
