package com.softwerke.journalportlet.journal.pages;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.softwerke.journalportlet.models.ArticleModel;
import com.softwerke.journalportlet.models.ReviewModel;
import com.softwerke.journalportlet.util.JournalUtil;

public class ViewArticle extends Page {
	
	private Log log = LogFactoryUtil.getLog(ViewArticle.class.getName());
	
	public ViewArticle() {
		this.path = "/html/view_article.jsp";
		this.param = "view_article";
	}
	
	@Override
	public void render(PortletRequest request, PortletResponse response) {
		try {
			Long articleId = ParamUtil.getLong(request, "articleId");
			List<ReviewModel> reviewArticleIdModel = JournalUtil.getAllReviewsByArticleId(articleId);
			ArticleModel article = JournalUtil.getArticleById(articleId);
			request.setAttribute("reviewArticleIdModel", reviewArticleIdModel);
			request.setAttribute("articleParams", article);
		} catch (SystemException e) {
			SessionErrors.add(request, "internal-error-please-try-later");
			log.error("Some problem in render() method. " + e.getMessage());
		} catch (PortalException e) {
			SessionErrors.add(request, "can-not-get-data-from-database");
			log.warn("Can not get data from database! " + e.getMessage());
		}
	}
}
