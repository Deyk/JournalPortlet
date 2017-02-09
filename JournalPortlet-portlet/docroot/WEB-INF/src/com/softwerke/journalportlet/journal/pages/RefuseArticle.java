package com.softwerke.journalportlet.journal.pages;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;


public class RefuseArticle extends Page {
	
	public RefuseArticle() {
		this.path = "/html/refuse_article.jsp";
		this.param = "refuse_article";
	}
	@Override
	public void render(PortletRequest request, PortletResponse response) {
	}
}
	