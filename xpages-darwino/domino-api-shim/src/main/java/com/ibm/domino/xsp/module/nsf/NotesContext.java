package com.ibm.domino.xsp.module.nsf;

import javax.faces.component.UIViewRoot;

import com.darwino.commons.json.JsonException;
import com.darwino.domino.notesbe.DarwinoDatabase;
import com.darwino.domino.notesbe.DarwinoDocument;
import com.darwino.domino.notesbe.DarwinoSession;

import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.Session;

// TODO consider if this is enough - Android will prove difficult
// Maybe it'll make sense to repackage the adapter jar
public class NotesContext {
	public static ThreadLocal<NotesContext> contextThreadLocal = new ThreadLocal<NotesContext>();
	
	public static void init(DarwinoSession session, DarwinoDatabase database) {
		contextThreadLocal.set(new NotesContext(session, database));
	}
	
	public static NotesContext getCurrent() {
		NotesContext ctx = contextThreadLocal.get();
		if(ctx == null) {
			throw new IllegalStateException("NotesContext is not initialized for this thread");
		}
		return ctx;
	}
	
	public static NotesContext getCurrentUnchecked() {
		return contextThreadLocal.get();
	}
	
	private DarwinoSession session;
	private DarwinoDatabase database;
	private UIViewRoot currentViewRoot;
	
	public NotesContext(DarwinoSession session, DarwinoDatabase database) {
		this.session = session;
		this.database = database;
	}
	
	public Session getCurrentSession() {
		return session;
	}
	
	public Database getCurrentDatabase() {
		return database;
	}
	
	public UIViewRoot getCurrentViewRoot() {
		return currentViewRoot;
	}
	public void setCurrentViewRoot(UIViewRoot currentViewRoot) {
		this.currentViewRoot = currentViewRoot;
	}
	
	public String getTemplateDBPath() {
		return null;
	}
	
	public Boolean isDocumentEditable(Document doc) {
		DarwinoDocument darwinoDoc = (DarwinoDocument)doc;
		try {
			return !darwinoDoc.getDarwinoDocument().isReadOnly();
		} catch (JsonException e) {
			throw new RuntimeException(e);
		}
	}
}
