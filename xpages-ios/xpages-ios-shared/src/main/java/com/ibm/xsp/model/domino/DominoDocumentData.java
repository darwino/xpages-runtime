package com.ibm.xsp.model.domino;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.ibm.xsp.FacesExceptionEx;
import com.ibm.xsp.model.AbstractDocumentDataSource;
import com.ibm.xsp.model.DocumentDataContainer;

public class DominoDocumentData extends AbstractDocumentDataSource {
	
	private String formName;

	public DominoDocumentData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDocument(Object var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNewDocument(FacesContext var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doComputeDocument(FacesContext var1, Object var2) throws FacesExceptionEx {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDeleteDocument(FacesContext var1, Object var2) throws FacesExceptionEx {
		// TODO Auto-generated method stub

	}

	@Override
	public DocumentDataContainer doNewDocument(FacesContext var1) throws FacesExceptionEx {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentDataContainer doOpenDocument(FacesContext var1) throws FacesExceptionEx {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doSaveDocument(FacesContext var1, Object var2) throws FacesExceptionEx {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly(Object var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String composeUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDataObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReadonly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void readRequestParams(FacesContext arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub

	}
	
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}

}
