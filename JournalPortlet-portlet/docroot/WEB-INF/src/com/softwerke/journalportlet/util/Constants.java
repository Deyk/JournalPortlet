package com.softwerke.journalportlet.util;

public class Constants {

	// Displayed status for article:
	public static final String DISPLAYED_STATUS_CREATED = "Non published | Non confirmed";
	public static final String DISPLAYED_STATUS_NONPUBLISHED_CONFIRMED = "Non published | Confirmed";
	public static final String DISPLAYED_STATUS_NONPUBLISHED_REJECTED = "Non published | Non confirmed";
	public static final String DISPLAYED_STATUS_PUBLISHED_REJECTED = "Published | Non confirmed";
	public static final String DISPLAYED_STATUS_PUBLISHED_CONFIRMED = "Published | Confirmed";
	public static final String DISPLAYED_STATUS_WAITING_TO_BE_CONFIRMED = "Non published | Waiting to be confirmed";
	
	// Incoming parameters from request:
	public static final String VIEW_COMMON = "view_common";
	public static final String VIEW_AUTHOR = "view_author";
	public static final String VIEW_GENERAL_REVIEWER = "view_general_reviewer";
	public static final String ADD_ARTICLE = "add_article";
	public static final String ADD_REVIEW = "add_review";
	public static final String REFUSE_ARTICLE = "refuse_article";
	public static final String VIEW_ARTICLE = "view_article";
}
