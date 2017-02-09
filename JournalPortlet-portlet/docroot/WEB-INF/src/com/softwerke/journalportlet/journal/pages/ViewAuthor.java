package com.softwerke.journalportlet.journal.pages;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.softwerke.journalportlet.models.ArticleModel;
import com.softwerke.journalportlet.util.JournalUtil;
import com.softwerke.srv.model.Article;


public class ViewAuthor extends Page {
	
	private Log log = LogFactoryUtil.getLog(ViewAuthor.class.getName());
	
	public ViewAuthor() {
		this.path = "/html/view_author.jsp";
		this.param = "view_author";
	}
	
	@Override
	public void render(PortletRequest request, PortletResponse response) {
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Article.class.getName(), request);
			List<ArticleModel> articleModelList = JournalUtil.getArticlesByAuthorId(serviceContext.getUserId());
			request.setAttribute("articleModelList", articleModelList);
		} catch (PortalException e) {
			SessionErrors.add(request, "can-not-get-data-from-database");
			log.warn("Can not get data from database! " + e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(request, "internal-error-please-try-later");
			log.error("Some problem in render() method. " + e.getMessage());
		}
		
	}	
}