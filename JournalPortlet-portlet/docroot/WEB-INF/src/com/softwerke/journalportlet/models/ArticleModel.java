package com.softwerke.journalportlet.models;

import java.util.List;

import com.softwerke.journalportlet.util.Constants;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.ReviewLocalServiceUtil;

public class ArticleModel {
	private Article article;
	private List<Review> reviewList;
	private String displayedStatus;

	public ArticleModel(Article article) {
		this.article = article;
		this.reviewList = ReviewLocalServiceUtil.getByArticleId(article.getArticleId());
		setDisplayedStatus(article);
	}

	public long getArticleId() {
		return article.getArticleId();
	}

	public String getArticleName() {
		return article.getArticleName();
	}

	public String getArticleContent() {
		return article.getArticleContent();
	}

	public int getArticleStatus() {
		return article.getArticleStatus();
	}

	public String getArticleRefuseComment() {
		return article.getArticleRefuseComment();
	}
	
	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setDisplayedStatus(Article article) {
		switch (article.getArticleStatus()) {
		case (0): {
			this.displayedStatus = Constants.DISPLAYED_STATUS_CREATED;
			break;
		}
		case (1): {
			if (article.getIsArticlePublished()) {
				this.displayedStatus = Constants.DISPLAYED_STATUS_PUBLISHED_CONFIRMED;
			} else {
				this.displayedStatus = Constants.DISPLAYED_STATUS_NONPUBLISHED_CONFIRMED;
			}
			break;
		}
		case (2): {
			if (article.getIsArticlePublished()) {
				this.displayedStatus = Constants.DISPLAYED_STATUS_PUBLISHED_REJECTED;
			} else {
				this.displayedStatus = Constants.DISPLAYED_STATUS_NONPUBLISHED_REJECTED;
			}
			break;
		}case (3): {
			this.displayedStatus = Constants.DISPLAYED_STATUS_WAITING_TO_BE_CONFIRMED;
			break;
		}
		}
	}

	public String getDisplayedStatus() {
		return displayedStatus;
	}
	public boolean getisArticlePublished(){
		return article.isIsArticlePublished();
	}
}