/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.softwerke.srv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.service.base.ArticleLocalServiceBaseImpl;
import com.softwerke.srv.service.persistence.ArticleUtil;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.softwerke.srv.service.ArticleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sasha
 * @see com.softwerke.srv.service.base.ArticleLocalServiceBaseImpl
 * @see com.softwerke.srv.service.ArticleLocalServiceUtil
 */
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {
	
	private static Log log = LogFactoryUtil.getLog(ArticleLocalServiceImpl.class);

	public List<Article> getByStatus(int status) throws SystemException {
		List<Article> articleList = new ArrayList<Article>();
		try{
			return ArticleUtil.findByArticleStatus(status);
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		return articleList;
	}
	
	public List<Article> getByIsArticlePublished(boolean isArticlePublished) throws SystemException {
		List<Article> articleList = new ArrayList<Article>();
		try{
			return ArticleUtil.findByIsArticlePublished(isArticlePublished);
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		return articleList;
	}
	
	public List<Article> getByAuthorId(long authorId) throws SystemException {
		List<Article> articleList = new ArrayList<Article>();
		try{
			return ArticleUtil.findByArticleUserId(authorId);
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		return articleList;
	}
}