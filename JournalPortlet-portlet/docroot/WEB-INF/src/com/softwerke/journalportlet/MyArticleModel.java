package com.softwerke.journalportlet;

import com.softwerke.srv.model.MyArticle;

public class MyArticleModel {
	private MyArticle myArticle;
	
	public MyArticleModel(MyArticle myArticle) {
		this.myArticle = myArticle;
	}
	
	public long getMyArticleId() {
		return myArticle.getMyArticleId();
	}
	public String getMyArticleName() {
		return myArticle.getMyArticleName();
	}
	
	public String getMyArticleContent() {
		return myArticle.getMyArticleContent();
	}
}