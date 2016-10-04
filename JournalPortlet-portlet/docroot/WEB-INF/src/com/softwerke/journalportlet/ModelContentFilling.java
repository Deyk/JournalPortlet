package com.softwerke.journalportlet;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.softwerke.srv.model.MyArticle;
import com.softwerke.srv.service.MyArticleLocalServiceUtil;

public class ModelContentFilling {
	protected static List<MyArticleModel> getAllArticles() throws SystemException, PortalException{
		List<MyArticleModel> myArticleModelList = new ArrayList<MyArticleModel>();
		List<MyArticle> myArticleList = MyArticleLocalServiceUtil.getMyArticles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (MyArticle myArticle: myArticleList) {
			myArticleModelList.add(new MyArticleModel(myArticle));
		}
		return myArticleModelList;
	}
}
