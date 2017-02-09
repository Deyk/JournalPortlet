package com.softwerke.journalportlet.journal.pages;


import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public abstract class Page {

	public String path;
	public String param;

	public abstract void render(PortletRequest request, PortletResponse response);
	
	public String getPath() {
		return path;
	}

	public String getParameter() {
		return param;
	}
}