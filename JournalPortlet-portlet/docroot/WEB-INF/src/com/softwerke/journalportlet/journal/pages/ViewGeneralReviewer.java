package com.softwerke.journalportlet.journal.pages;

import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.softwerke.journalportlet.models.ArticleModel;
import com.softwerke.journalportlet.util.ArticleStatus;
import com.softwerke.journalportlet.util.JournalUtil;


public class ViewGeneralReviewer extends Page {
	
	private Log log = LogFactoryUtil.getLog(ViewGeneralReviewer.class.getName());
	
	public ViewGeneralReviewer() {
		this.path = "/html/view_general_reviewer.jsp";
		this.param = "view_general_reviewer";
	}
	@Override
	public void render(PortletRequest request, PortletResponse response) {
		try {
			List<ArticleModel> articleWaitingAndConfirmedModelList = JournalUtil.getAllArticlesByStatus(ArticleStatus.CONFIRMED.getValue());
			articleWaitingAndConfirmedModelList.addAll(JournalUtil.getAllArticlesByStatus(ArticleStatus.WAITING_TO_BE_CONFIRMED.getValue()));
			request.setAttribute("articleWaitingAndConfirmedModelList", articleWaitingAndConfirmedModelList);
		} catch (PortalException e) {
			SessionErrors.add(request, "can-not-get-data-from-database");
			log.warn("Can not get data from database! " + e.getMessage());
		} catch (SystemException e) {
			SessionErrors.add(request, "internal-error-please-try-later");
			log.error("Some problem in render() method. " + e.getMessage());
		}
	}
}
