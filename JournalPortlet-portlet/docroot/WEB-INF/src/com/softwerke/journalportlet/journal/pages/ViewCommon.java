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
import com.softwerke.journalportlet.util.JournalUtil;

public class ViewCommon extends Page {
	
	private Log log = LogFactoryUtil.getLog(ViewCommon.class.getName());
	
	public ViewCommon() {
		this.path = "/html/view_common.jsp";
		this.param = "view_common";
	}
	
	@Override
	public void render(PortletRequest request, PortletResponse response) {

			try {
				List<ArticleModel> articlePublishedModelList = JournalUtil.getAllArticlesByPublished();
				request.setAttribute("articlePublishedModelList", articlePublishedModelList);
			} catch (PortalException e) {
				SessionErrors.add(request, "can-not-get-data-from-database");
				log.warn("Can not get data from database! " + e.getMessage());
			} catch (SystemException e) {
				SessionErrors.add(request, "internal-error-please-try-later");
				log.error("Some problem in render() method. " + e.getMessage());
			}
	}
}
