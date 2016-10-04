package com.softwerke.journalportlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.softwerke.journalportlet.JournalPortlet;
import com.softwerke.srv.model.MyArticle;
import com.softwerke.srv.model.MyReview;
import com.softwerke.srv.service.MyArticleLocalServiceUtil;
import com.softwerke.srv.service.MyReviewLocalServiceUtil;

public class JournalPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(JournalPortlet.class.getName());

	//Incoming parameters:
	public static final String VIEW = "view";
	public static final String ADD_ARTICLE = "add_article";
	public static final String ADD_REVIEW = "add_review";
	
	//.jsp's paths:
	private static final String VIEW_PAGE_PATH = "/html/view.jsp";
	private static final String ADD_ARTICLE_PAGE_PATH = "/html/add_article.jsp";
	private static final String ADD_REVIEW_PAGE_PATH = "/html/add_review.jsp";
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException{
		
		String pageName = request.getParameter("pageName");
		try {
			List<MyArticleModel> MyArticleModelList = ModelContentFilling.getAllArticles();
			request.setAttribute("myArticleModelList", MyArticleModelList);
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}

		if (ADD_ARTICLE.equalsIgnoreCase(pageName)) {
			include(ADD_ARTICLE_PAGE_PATH, request, response);
		} else if (ADD_REVIEW.equalsIgnoreCase(pageName)) {
			include(ADD_REVIEW_PAGE_PATH, request, response);
		} else {
			include(VIEW_PAGE_PATH, request, response);
		}    
	}
	/**
	 * This method adds book in your database. It's called when you submit "add book" form.
	 * 
	 * @param actionRequest It's our actionRequest
	 * @param actionResponse It's our actionResponse
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void addMyArticle(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws SystemException {
		String myArticleName = ParamUtil.getString(actionRequest,"myArticleName", StringPool.BLANK);
		String myArticleContent = ParamUtil.getString(actionRequest, "myArticleContent", StringPool.BLANK);
		long myArticleStatus = ParamUtil.getLong(actionRequest, "myArticleStatus", 0);
		MyArticle myArticle = MyArticleLocalServiceUtil.createMyArticle(CounterLocalServiceUtil.increment());

		if (!myArticleName.equals(StringPool.BLANK)) {
			myArticle.setMyArticleName(myArticleName);
		} else {
			log.warn("myArticleName was NULL. ");
			SessionErrors.add(actionRequest, "there-was-no-article-name");
		}
		
		if (!myArticleContent.equals(StringPool.BLANK)) {
			myArticle.setMyArticleContent(myArticleContent);
		} else {
			log.warn("myArticleContent was NULL. ");
			SessionErrors.add(actionRequest, "there-was-no-article-content");
		} 
		
		if (myArticleStatus != 0) {
			myArticle.setMyArticleStatus((int) myArticleStatus);
		} else {
			log.warn("myArticleStatus was NULL. ");
			SessionErrors.add(actionRequest, "there-was-no-article-status");
		}
		
		myArticle = MyArticleLocalServiceUtil.addMyArticle(myArticle);
	}
	
	public void addMyReview(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws SystemException {
		String myReviewName = ParamUtil.getString(actionRequest,"myArticleName", StringPool.BLANK);
		String myReviewContent = ParamUtil.getString(actionRequest, "myArticleContent", StringPool.BLANK);
		MyReview myReview  = MyReviewLocalServiceUtil.createMyReview(CounterLocalServiceUtil.increment());

		if (!myReviewName.equals(StringPool.BLANK)) {
			myReview.setMyReviewName(myReviewName);
		} else {
			log.warn("myReviewName was NULL. ");
			SessionErrors.add(actionRequest, "there-was-no-review-name");
		}
		
		if (!myReviewContent.equals(StringPool.BLANK)) {
			myReview.setMyReviewContent(myReviewContent);
		} else {
			log.warn("myReviewContent was NULL. ");
			SessionErrors.add(actionRequest, "there-was-no-review-content");
		} 
		
		myReview = MyReviewLocalServiceUtil.addMyReview(myReview);
	}
	
	public void deleteMyArticle(ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {
		long myArticleId = ParamUtil.getLong(actionRequest, "myArticleId", 0);
		if (myArticleId == 0) {
			log.warn("myArticleId is not defined. ");
			SessionErrors.add(actionRequest, "mistake");
			return;
		}
		try {
			MyArticleLocalServiceUtil.deleteMyArticle(myArticleId);
			SessionMessages.add(actionRequest, "deleted-my-article");
		} catch (PortalException | SystemException e) {
			log.warn("Failed to delete myArticle with id: " + myArticleId + ". " + e.getMessage());
			SessionErrors.add(actionRequest, "failed-to-delete-this-article");
		}
	}

}
