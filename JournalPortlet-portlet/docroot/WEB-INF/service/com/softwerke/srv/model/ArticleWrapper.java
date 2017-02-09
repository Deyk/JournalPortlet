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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author Sasha
 * @see Article
 * @generated
 */
public class ArticleWrapper implements Article, ModelWrapper<Article> {
	public ArticleWrapper(Article article) {
		_article = article;
	}

	@Override
	public Class<?> getModelClass() {
		return Article.class;
	}

	@Override
	public String getModelClassName() {
		return Article.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("articleId", getArticleId());
		attributes.put("groupId", getGroupId());
		attributes.put("articleName", getArticleName());
		attributes.put("articleContent", getArticleContent());
		attributes.put("articleRefuseComment", getArticleRefuseComment());
		attributes.put("articleStatus", getArticleStatus());
		attributes.put("isArticlePublished", getIsArticlePublished());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String articleName = (String)attributes.get("articleName");

		if (articleName != null) {
			setArticleName(articleName);
		}

		String articleContent = (String)attributes.get("articleContent");

		if (articleContent != null) {
			setArticleContent(articleContent);
		}

		String articleRefuseComment = (String)attributes.get(
				"articleRefuseComment");

		if (articleRefuseComment != null) {
			setArticleRefuseComment(articleRefuseComment);
		}

		Integer articleStatus = (Integer)attributes.get("articleStatus");

		if (articleStatus != null) {
			setArticleStatus(articleStatus);
		}

		Boolean isArticlePublished = (Boolean)attributes.get(
				"isArticlePublished");

		if (isArticlePublished != null) {
			setIsArticlePublished(isArticlePublished);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this article.
	*
	* @return the primary key of this article
	*/
	@Override
	public long getPrimaryKey() {
		return _article.getPrimaryKey();
	}

	/**
	* Sets the primary key of this article.
	*
	* @param primaryKey the primary key of this article
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_article.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this article.
	*
	* @return the uuid of this article
	*/
	@Override
	public java.lang.String getUuid() {
		return _article.getUuid();
	}

	/**
	* Sets the uuid of this article.
	*
	* @param uuid the uuid of this article
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_article.setUuid(uuid);
	}

	/**
	* Returns the article ID of this article.
	*
	* @return the article ID of this article
	*/
	@Override
	public long getArticleId() {
		return _article.getArticleId();
	}

	/**
	* Sets the article ID of this article.
	*
	* @param articleId the article ID of this article
	*/
	@Override
	public void setArticleId(long articleId) {
		_article.setArticleId(articleId);
	}

	/**
	* Returns the group ID of this article.
	*
	* @return the group ID of this article
	*/
	@Override
	public long getGroupId() {
		return _article.getGroupId();
	}

	/**
	* Sets the group ID of this article.
	*
	* @param groupId the group ID of this article
	*/
	@Override
	public void setGroupId(long groupId) {
		_article.setGroupId(groupId);
	}

	/**
	* Returns the article name of this article.
	*
	* @return the article name of this article
	*/
	@Override
	public java.lang.String getArticleName() {
		return _article.getArticleName();
	}

	/**
	* Sets the article name of this article.
	*
	* @param articleName the article name of this article
	*/
	@Override
	public void setArticleName(java.lang.String articleName) {
		_article.setArticleName(articleName);
	}

	/**
	* Returns the article content of this article.
	*
	* @return the article content of this article
	*/
	@Override
	public java.lang.String getArticleContent() {
		return _article.getArticleContent();
	}

	/**
	* Sets the article content of this article.
	*
	* @param articleContent the article content of this article
	*/
	@Override
	public void setArticleContent(java.lang.String articleContent) {
		_article.setArticleContent(articleContent);
	}

	/**
	* Returns the article refuse comment of this article.
	*
	* @return the article refuse comment of this article
	*/
	@Override
	public java.lang.String getArticleRefuseComment() {
		return _article.getArticleRefuseComment();
	}

	/**
	* Sets the article refuse comment of this article.
	*
	* @param articleRefuseComment the article refuse comment of this article
	*/
	@Override
	public void setArticleRefuseComment(java.lang.String articleRefuseComment) {
		_article.setArticleRefuseComment(articleRefuseComment);
	}

	/**
	* Returns the article status of this article.
	*
	* @return the article status of this article
	*/
	@Override
	public int getArticleStatus() {
		return _article.getArticleStatus();
	}

	/**
	* Sets the article status of this article.
	*
	* @param articleStatus the article status of this article
	*/
	@Override
	public void setArticleStatus(int articleStatus) {
		_article.setArticleStatus(articleStatus);
	}

	/**
	* Returns the is article published of this article.
	*
	* @return the is article published of this article
	*/
	@Override
	public boolean getIsArticlePublished() {
		return _article.getIsArticlePublished();
	}

	/**
	* Returns <code>true</code> if this article is is article published.
	*
	* @return <code>true</code> if this article is is article published; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsArticlePublished() {
		return _article.isIsArticlePublished();
	}

	/**
	* Sets whether this article is is article published.
	*
	* @param isArticlePublished the is article published of this article
	*/
	@Override
	public void setIsArticlePublished(boolean isArticlePublished) {
		_article.setIsArticlePublished(isArticlePublished);
	}

	/**
	* Returns the user ID of this article.
	*
	* @return the user ID of this article
	*/
	@Override
	public long getUserId() {
		return _article.getUserId();
	}

	/**
	* Sets the user ID of this article.
	*
	* @param userId the user ID of this article
	*/
	@Override
	public void setUserId(long userId) {
		_article.setUserId(userId);
	}

	/**
	* Returns the user uuid of this article.
	*
	* @return the user uuid of this article
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _article.getUserUuid();
	}

	/**
	* Sets the user uuid of this article.
	*
	* @param userUuid the user uuid of this article
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_article.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _article.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_article.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _article.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_article.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _article.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _article.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_article.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _article.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_article.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_article.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_article.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArticleWrapper((Article)_article.clone());
	}

	@Override
	public int compareTo(com.softwerke.srv.model.Article article) {
		return _article.compareTo(article);
	}

	@Override
	public int hashCode() {
		return _article.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.softwerke.srv.model.Article> toCacheModel() {
		return _article.toCacheModel();
	}

	@Override
	public com.softwerke.srv.model.Article toEscapedModel() {
		return new ArticleWrapper(_article.toEscapedModel());
	}

	@Override
	public com.softwerke.srv.model.Article toUnescapedModel() {
		return new ArticleWrapper(_article.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _article.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _article.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_article.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleWrapper)) {
			return false;
		}

		ArticleWrapper articleWrapper = (ArticleWrapper)obj;

		if (Validator.equals(_article, articleWrapper._article)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Article getWrappedArticle() {
		return _article;
	}

	@Override
	public Article getWrappedModel() {
		return _article;
	}

	@Override
	public void resetOriginalValues() {
		_article.resetOriginalValues();
	}

	private Article _article;
}