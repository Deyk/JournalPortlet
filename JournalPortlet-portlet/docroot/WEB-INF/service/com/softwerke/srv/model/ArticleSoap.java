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

package com.softwerke.srv.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.softwerke.srv.service.http.ArticleServiceSoap}.
 *
 * @author Sasha
 * @see com.softwerke.srv.service.http.ArticleServiceSoap
 * @generated
 */
public class ArticleSoap implements Serializable {
	public static ArticleSoap toSoapModel(Article model) {
		ArticleSoap soapModel = new ArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setArticleName(model.getArticleName());
		soapModel.setArticleContent(model.getArticleContent());
		soapModel.setArticleRefuseComment(model.getArticleRefuseComment());
		soapModel.setArticleStatus(model.getArticleStatus());
		soapModel.setIsArticlePublished(model.getIsArticlePublished());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ArticleSoap[] toSoapModels(Article[] models) {
		ArticleSoap[] soapModels = new ArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[][] toSoapModels(Article[][] models) {
		ArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[] toSoapModels(List<Article> models) {
		List<ArticleSoap> soapModels = new ArrayList<ArticleSoap>(models.size());

		for (Article model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleSoap[soapModels.size()]);
	}

	public ArticleSoap() {
	}

	public long getPrimaryKey() {
		return _articleId;
	}

	public void setPrimaryKey(long pk) {
		setArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getArticleName() {
		return _articleName;
	}

	public void setArticleName(String articleName) {
		_articleName = articleName;
	}

	public String getArticleContent() {
		return _articleContent;
	}

	public void setArticleContent(String articleContent) {
		_articleContent = articleContent;
	}

	public String getArticleRefuseComment() {
		return _articleRefuseComment;
	}

	public void setArticleRefuseComment(String articleRefuseComment) {
		_articleRefuseComment = articleRefuseComment;
	}

	public int getArticleStatus() {
		return _articleStatus;
	}

	public void setArticleStatus(int articleStatus) {
		_articleStatus = articleStatus;
	}

	public boolean getIsArticlePublished() {
		return _isArticlePublished;
	}

	public boolean isIsArticlePublished() {
		return _isArticlePublished;
	}

	public void setIsArticlePublished(boolean isArticlePublished) {
		_isArticlePublished = isArticlePublished;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _articleId;
	private long _groupId;
	private String _articleName;
	private String _articleContent;
	private String _articleRefuseComment;
	private int _articleStatus;
	private boolean _isArticlePublished;
	private long _userId;
}