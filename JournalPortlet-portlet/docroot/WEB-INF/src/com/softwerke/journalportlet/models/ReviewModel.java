package com.softwerke.journalportlet.models;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.ArticleLocalServiceUtil;

public class ReviewModel {
	private Review review;
	private Article article; 
	
	public ReviewModel(Review review) throws PortalException, SystemException {
		this.review = review;
		this.article = ArticleLocalServiceUtil.getArticle(review.getArticleId());
	}
	
	public long getReviewId() {
		return review.getReviewId();
	}
	
	public String getReviewName() {
		return review.getReviewName();
	}
	
	public String getReviewContent() {
		return review.getReviewContent();
	}
	public String getArticleName(){
		return article.getArticleName();
	}
}
