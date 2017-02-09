package com.softwerke.journalportlet.util;

import java.util.ArrayList;
import java.util.List;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.softwerke.journalportlet.models.ArticleModel;
import com.softwerke.journalportlet.models.ReviewModel;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.ArticleLocalServiceUtil;
import com.softwerke.srv.service.ReviewLocalServiceUtil;

public class JournalUtil {
	public static List<ArticleModel> getAllArticles() throws SystemException,
			PortalException {

		List<ArticleModel> articleModelList = new ArrayList<>();
		List<Article> articleList = ArticleLocalServiceUtil.getArticles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Article article : articleList) {
			articleModelList.add(new ArticleModel(article));
		}
		return articleModelList;
	}

	public static List<ReviewModel> getAllReviews()
			throws SystemException,	PortalException {

		List<ReviewModel> reviewModelList = new ArrayList<>();
		List<Review> reviewList = ReviewLocalServiceUtil.getReviews(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (Review review : reviewList) {
			reviewModelList.add(new ReviewModel(review));
		}
		return reviewModelList;
	}

	public static List<ArticleModel> getAllArticlesByStatus(int status)
			throws SystemException, PortalException {
		List<ArticleModel> articleStatusModelList = new ArrayList<>();
		List<Article> articleList = ArticleLocalServiceUtil.getByStatus(status);

		for (Article article : articleList) {
			articleStatusModelList.add(new ArticleModel(article));
		}
		return articleStatusModelList;
	}

	public static List<ReviewModel> getAllReviewsByArticleId(Long articleId)
			throws SystemException, PortalException {

		List<ReviewModel> reviewArticleIdModelList = new ArrayList<ReviewModel>();
		List<Review> reviewList = ReviewLocalServiceUtil
				.getByArticleId(articleId);

		for (Review review : reviewList) {
			reviewArticleIdModelList.add(new ReviewModel(review));
		}
		return reviewArticleIdModelList;
	}

	public static List<ArticleModel> getAllArticlesByPublished()
			throws SystemException, PortalException {
		List<ArticleModel> articlePublishedModelList = new ArrayList<>();
		List<Article> articleList = ArticleLocalServiceUtil.getByIsArticlePublished(true);

		for (Article article : articleList) {
			articlePublishedModelList.add(new ArticleModel(article));
		}
		return articlePublishedModelList;
	}

	public static List<ArticleModel> getAllArticlesByNotPublished()
			throws SystemException, PortalException {
		List<ArticleModel> articlePublishedModelList = new ArrayList<>();
		List<Article> articleList = ArticleLocalServiceUtil.getByIsArticlePublished(false);

		for (Article article : articleList) {
			articlePublishedModelList.add(new ArticleModel(article));
		}
		return articlePublishedModelList;
	}

	public static ArticleModel getArticleById(Long articleId)
			throws SystemException, PortalException {
		Article article = ArticleLocalServiceUtil.getArticle(articleId);
		ArticleModel articleModel = new ArticleModel(article);
		return articleModel;
	}
	
	public static List<ArticleModel> getArticlesByAuthorId(Long authorId)
			throws SystemException, PortalException {
		List<ArticleModel> articleAuthorIdModelList = new ArrayList<>();
		List<Article> articleList = ArticleLocalServiceUtil.getByAuthorId(authorId);
		
		for (Article article : articleList) {
			articleAuthorIdModelList.add(new ArticleModel(article));
		}
		return articleAuthorIdModelList;
	}
}
