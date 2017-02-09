package com.softwerke.journalportlet.journal.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.softwerke.journalportlet.journal.pages.AddArticle;
import com.softwerke.journalportlet.journal.pages.AddReview;
import com.softwerke.journalportlet.journal.pages.Page;
import com.softwerke.journalportlet.journal.pages.RefuseArticle;
import com.softwerke.journalportlet.journal.pages.ViewArticle;
import com.softwerke.journalportlet.journal.pages.ViewAuthor;
import com.softwerke.journalportlet.journal.pages.ViewCommon;
import com.softwerke.journalportlet.journal.pages.ViewGeneralReviewer;
import com.softwerke.journalportlet.util.ArticleStatus;
import com.softwerke.journalportlet.util.Constants;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.ArticleLocalServiceUtil;
import com.softwerke.srv.service.ReviewLocalServiceUtil;

public class JournalPortlet extends MVCPortlet {
	
	private Log log = LogFactoryUtil.getLog(JournalPortlet.class.getName());

	/**
	 *  This method is started with a render phase of our portlet. Not only it gets all roles existing on the portal but it's also responsive for rendering default page.
	 */
	@Override
	public void render(RenderRequest request, RenderResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			List<Role> roleList = themeDisplay.getUser().getRoles();
			request.setAttribute("roleList", roleList);
			
			String pageName = request.getParameter("pageName");
			if (pageName == null) {
				pageName = "view_common";
			}
			Page currentPage = getPageFromRequest(pageName);
			currentPage.render(request, response);
			include(currentPage.getPath(), request, response);
			
		} catch (PortletException | IOException | SystemException e) {
			SessionErrors.add(request, "internal-error-please-try-later");
			log.error("Some problem in render() method. " + e.getMessage());
		}
	}
	
	/**
	 *  This method creates new object of respective subclass. So this value is been used in render method to render that page we need.
	 */
	private Page getPageFromRequest(String pageName) {
		
		if (Constants.ADD_ARTICLE.equalsIgnoreCase(pageName)) {
			return new AddArticle(); 
		}
		
		if (Constants.ADD_REVIEW.equalsIgnoreCase(pageName)) {
			return new AddReview();
		}
		
		if (Constants.REFUSE_ARTICLE.equalsIgnoreCase(pageName)) {
			return new RefuseArticle();
		}
		
		if (Constants.VIEW_ARTICLE.equalsIgnoreCase(pageName)) {
			return new ViewArticle();
		}
		
		if (Constants.VIEW_AUTHOR.equalsIgnoreCase(pageName)) {
			return new ViewAuthor();
		}
		
		if (Constants.VIEW_COMMON.equalsIgnoreCase(pageName)) {
			return new ViewCommon();
		}
		
		if (Constants.VIEW_GENERAL_REVIEWER.equalsIgnoreCase(pageName)) {
			return new ViewGeneralReviewer();
		}
		
		return null;	
	}

	/**
	 * This method adds article in your database. It's called when you submit
	 * "add article" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void addArticle(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String articleName = ParamUtil.getString(actionRequest, "articleName", StringPool.BLANK);
		String articleContent = ParamUtil.getString(actionRequest, "articleContent", StringPool.BLANK);

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			        Article.class.getName(), actionRequest);
			
			Long articleId = CounterLocalServiceUtil.increment();
			Article article = ArticleLocalServiceUtil.createArticle(articleId);

			if (!articleName.equals(StringPool.BLANK)) {
				article.setArticleName(articleName);
			} else {
				log.warn("articleName was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-article-name");
				return;
			}

			if (!articleContent.equals(StringPool.BLANK)) {
				article.setArticleContent(articleContent);
			} else {
				log.warn("articleContent was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-article-content");
				return;
			}
			
			article.setArticleStatus(ArticleStatus.CREATED.getValue());
			article.setIsArticlePublished(false);
			article.setUserId(serviceContext.getUserId());
			article = ArticleLocalServiceUtil.addArticle(article);
			SessionMessages.add(actionRequest, "article-added");
			
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "can-not-get-records-from-database");
			log.warn("Can't get some records from database \n" + e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-create-new-article");
			log.warn("Can not create new article. See next trace to know more \n" + e.getMessage());
		} 
	}

	/**
	 * This method adds review to some article in your database. It's called when you submit
	 * "add article review" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse 
	 */
	public void addReview(ActionRequest actionRequest, ActionResponse actionResponse) {

		String reviewName = ParamUtil.getString(actionRequest, "reviewName", StringPool.BLANK);
		String reviewContent = ParamUtil.getString(actionRequest, "reviewContent", StringPool.BLANK);
		long articleId = ParamUtil.getLong(actionRequest, "articleId");
		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			        Review.class.getName(), actionRequest);
			
			Long reviewId = CounterLocalServiceUtil.increment();
			Review review = ReviewLocalServiceUtil.createReview(reviewId);

			if (!reviewName.equals(StringPool.BLANK)) {
				review.setReviewName(reviewName);
			} else {
				log.warn("reviewName was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-review-name");
				return;
			}

			if (!reviewContent.equals(StringPool.BLANK)) {
				review.setReviewContent(reviewContent);
			} else {
				log.warn("reviewContent was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-review-content");
				return;
			}
			
			if (!(articleId == 0)) {
				review.setArticleId(articleId);
			} else {
				log.warn("articleId is not defined. ");
				SessionErrors.add(actionRequest, "article-id-is-not-defined");
				return;
			}
			review.setUserId(serviceContext.getUserId());
			ReviewLocalServiceUtil.addReview(review);
			SessionMessages.add(actionRequest, "review-added");
			
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "can-not-get-records-from-database");
			log.warn("Can't get some records from database \n" + e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-create-new-review");
			log.warn("Can not create new review. See next trace to know more \n" + e.getMessage());
		}
	}

	/**
	 * This method changes article's status to "refused" and adds refuse message to article in your database. It's called when you refuse some
	 * article from general reviewer's page.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void refuseArticle(ActionRequest actionRequest,	ActionResponse actionResponse) {
		String refuseMessage = ParamUtil.getString(actionRequest, "refuseMessage", StringPool.BLANK);
		long articleId = ParamUtil.getLong(actionRequest, "articleId");
		
		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			
			if (!refuseMessage.equals(StringPool.BLANK)) {
				article.setArticleRefuseComment(refuseMessage);
			} else {
				log.warn("verdictMessage was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-refuse-message");
				return;
			}

			article.setArticleStatus(ArticleStatus.REFUSED.getValue());
			article.setIsArticlePublished(false);
			ArticleLocalServiceUtil.updateArticle(article);
			log.info("Verdict has been added successfully");
			SessionMessages.add(actionRequest, "verdict-has-been-added-successfully");
			
		} catch (PortalException e) {
			log.warn("Can not get article with this id to refuse it");
			SessionErrors.add(actionRequest, "can-not-get-article-with-this-id-to-refuse-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-refuse-article");
			log.warn("Can not refuse article. See next trace to know more \n" + e.getMessage());
		} 
	}
	
	/**
	 * This method deletes chosen article from your database.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void deleteArticle(ActionRequest actionRequest, ActionResponse actionResponse) {

		long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);

		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		try {
			ArticleLocalServiceUtil.deleteArticle(articleId);
			SessionMessages.add(actionRequest, "deleted-article");
		} catch (PortalException e) {
			log.warn("Can not delete article with this id ");
			SessionErrors.add(actionRequest, "can-not-delete-article-with-this-id");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-delete-article");
			log.warn("Can not delete article. See next trace to know more \n" + e.getMessage());
		} 
	}
	
	/**
	 * This method deletes chosen review from your database.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void deleteReview(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException {

		long reviewId = ParamUtil.getLong(actionRequest, "reviewId", 0);

		if (reviewId == 0) {
			log.warn("reviewId is not defined. ");
			SessionErrors.add(actionRequest, "review-id-is-not-defined");
			return;
		}

		try {
			ReviewLocalServiceUtil.deleteReview(reviewId);
			SessionMessages.add(actionRequest, "deleted-review");
		} catch (PortalException e) {
			log.warn("Can not delete review with this id ");
			SessionErrors.add(actionRequest, "can-not-delete-review-with-this-id");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-review-article");
			log.warn("Can not delete review. See next trace to know more \n" + e.getMessage());
		} 
	}
	/**
	 * This method gets particular article from your database and change it's status to 'published'.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void publishArticle(ActionRequest actionRequest,	ActionResponse actionResponse) {
		long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			article.setIsArticlePublished(true);
			ArticleLocalServiceUtil.updateArticle(article);
			log.info("article has been published successfully");
			SessionMessages.add(actionRequest, "article-has-been-published-successfully");
		} catch (PortalException e) {
			log.warn("Can not get article with this id to publish it");
			SessionErrors.add(actionRequest, "can-not-delete-article-with-this-id-to-publish-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-get-article");
			log.warn("Can not get article. See next trace to know more \n" + e.getMessage());
		} 
		
	}

	/**
	 * This method gets particular article from your database and change it's status to 'confirmed'.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void confirmArticle(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			article.setArticleStatus(ArticleStatus.CONFIRMED.getValue());
			ArticleLocalServiceUtil.updateArticle(article);
			log.info("article has been confirmed successfully");
			SessionMessages.add(actionRequest, "article-has-been-confirmed-successfully");
		} catch (PortalException e) {
			log.warn("Can not get article with this id to confirm it");
			SessionErrors.add(actionRequest, "can-not-get-article-with-this-id-to-confirm-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-get-article");
			log.warn("Can not get article. See next trace to know more \n" + e.getMessage());
		} 
	
	}
	
	/**
	 * This method gets particular article from your database and change it's status to 'waiting to be confirmed'.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	
	public void sendToConfirmArticle(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			article.setArticleStatus(ArticleStatus.WAITING_TO_BE_CONFIRMED.getValue());
			ArticleLocalServiceUtil.updateArticle(article);
			log.info("article has been confirmed successfully");
			SessionMessages.add(actionRequest, "article-has-been-confirmed-successfully");
		} catch (PortalException e) {
			log.warn("Can not get article with this id to sent it");
			SessionErrors.add(actionRequest, "can-not-get-article-with-this-id-to-sent-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-get-article");
			log.warn("Can not get article. See next trace to know more \n" + e.getMessage());
		} 
	
	}
	/**
	 * This method gets particular article from your database and change it's status to 'unpublished'.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void unpublishArticle(ActionRequest actionRequest, ActionResponse actionResponse) {
		long articleId = ParamUtil.getLong(actionRequest, "articleId", 0);
		if (articleId == 0) {
			log.warn("articleId is not defined. ");
			SessionErrors.add(actionRequest, "article-id-is-not-defined");
			return;
		}
		
		try {
			Article article = ArticleLocalServiceUtil.getArticle(articleId);
			article.setIsArticlePublished(false);
			ArticleLocalServiceUtil.updateArticle(article);
			log.info("article-has-been-unpublished-successfully");
			SessionMessages.add(actionRequest, "article-has-been-unpublished-successfully");
		} catch (PortalException e) {
			log.warn("Can not get article with this id to unpublish it");
			SessionErrors.add(actionRequest, "can-not-get-article-with-this-id-to-unpublish-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-get-article");
			log.warn("Can not get article. See next trace to know more \n" + e.getMessage());
		} 
	}
	
	/**
	 * This method update article's content in your database. It's called when you submit
	 * "update article" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 */
	public void updateArticle(ActionRequest actionRequest, ActionResponse actionResponse) {

		String articleContent = ParamUtil.getString(actionRequest, "articleContent", StringPool.BLANK);
		long articleId = ParamUtil.getLong(actionRequest, "articleId");
		
		try {			
			
			Article article = ArticleLocalServiceUtil.getArticle(articleId);

			if (!articleContent.equals(StringPool.BLANK)) {
				article.setArticleContent(articleContent);
			} else {
				log.warn("articleContent was NULL. ");
				SessionErrors.add(actionRequest, "there-was-no-article-content");
				return;
			}
			
			article = ArticleLocalServiceUtil.updateArticle(article);
			SessionMessages.add(actionRequest, "article-updated");
			
		} catch (PortalException e) {
			log.warn("Can not get article with this id to update it");
			SessionErrors.add(actionRequest, "can-not-get-article-with-this-id-to-update-it");
		} catch (SystemException e) {
			SessionErrors.add(actionRequest, "can-not-update-article");
			log.warn("Can not update article. See next trace to know more \n" + e.getMessage());
		} 
	}
}
