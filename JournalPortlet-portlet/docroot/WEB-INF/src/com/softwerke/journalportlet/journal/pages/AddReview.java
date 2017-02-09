package com.softwerke.journalportlet.journal.pages;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;


public class AddReview extends Page {
	
	public AddReview() {
		this.path = "/html/add_review.jsp";
		this.param = "add_review";
	}
	
	@Override
	public void render(PortletRequest request, PortletResponse response) {
	}
}