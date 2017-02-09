package com.softwerke.journalportlet.journal.pages;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;


public class AddArticle extends Page {
	
	public AddArticle() {
		this.path = "/html/add_article.jsp";
		this.param = "add_article";
	}
	
	@Override
	public void render(PortletRequest request, PortletResponse response) {
	}
}