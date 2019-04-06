package com.ibm.xsp.model.domino;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import com.ibm.xsp.model.AbstractViewDataSource;
import com.ibm.xsp.model.ViewDataContainer;

public class DominoViewData extends AbstractViewDataSource {
	
	private String viewName;

	public DominoViewData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isView(Object var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataModel getDataModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ViewDataContainer doOpenView(FacesContext var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isReadOnly(Object var1) {
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
	public void readRequestParams(FacesContext arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub

	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
}
