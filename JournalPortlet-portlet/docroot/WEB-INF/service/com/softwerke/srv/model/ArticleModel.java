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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Article service. Represents a row in the &quot;new_perfect_journal_Article&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.softwerke.srv.model.impl.ArticleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.softwerke.srv.model.impl.ArticleImpl}.
 * </p>
 *
 * @author Sasha
 * @see Article
 * @see com.softwerke.srv.model.impl.ArticleImpl
 * @see com.softwerke.srv.model.impl.ArticleModelImpl
 * @generated
 */
public interface ArticleModel extends BaseModel<Article> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a article model instance should use the {@link Article} interface instead.
	 */

	/**
	 * Returns the primary key of this article.
	 *
	 * @return the primary key of this article
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this article.
	 *
	 * @param primaryKey the primary key of this article
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this article.
	 *
	 * @return the uuid of this article
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this article.
	 *
	 * @param uuid the uuid of this article
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the article ID of this article.
	 *
	 * @return the article ID of this article
	 */
	public long getArticleId();

	/**
	 * Sets the article ID of this article.
	 *
	 * @param articleId the article ID of this article
	 */
	public void setArticleId(long articleId);

	/**
	 * Returns the group ID of this article.
	 *
	 * @return the group ID of this article
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this article.
	 *
	 * @param groupId the group ID of this article
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the article name of this article.
	 *
	 * @return the article name of this article
	 */
	@AutoEscape
	public String getArticleName();

	/**
	 * Sets the article name of this article.
	 *
	 * @param articleName the article name of this article
	 */
	public void setArticleName(String articleName);

	/**
	 * Returns the article content of this article.
	 *
	 * @return the article content of this article
	 */
	@AutoEscape
	public String getArticleContent();

	/**
	 * Sets the article content of this article.
	 *
	 * @param articleContent the article content of this article
	 */
	public void setArticleContent(String articleContent);

	/**
	 * Returns the article refuse comment of this article.
	 *
	 * @return the article refuse comment of this article
	 */
	@AutoEscape
	public String getArticleRefuseComment();

	/**
	 * Sets the article refuse comment of this article.
	 *
	 * @param articleRefuseComment the article refuse comment of this article
	 */
	public void setArticleRefuseComment(String articleRefuseComment);

	/**
	 * Returns the article status of this article.
	 *
	 * @return the article status of this article
	 */
	public int getArticleStatus();

	/**
	 * Sets the article status of this article.
	 *
	 * @param articleStatus the article status of this article
	 */
	public void setArticleStatus(int articleStatus);

	/**
	 * Returns the is article published of this article.
	 *
	 * @return the is article published of this article
	 */
	public boolean getIsArticlePublished();

	/**
	 * Returns <code>true</code> if this article is is article published.
	 *
	 * @return <code>true</code> if this article is is article published; <code>false</code> otherwise
	 */
	public boolean isIsArticlePublished();

	/**
	 * Sets whether this article is is article published.
	 *
	 * @param isArticlePublished the is article published of this article
	 */
	public void setIsArticlePublished(boolean isArticlePublished);

	/**
	 * Returns the user ID of this article.
	 *
	 * @return the user ID of this article
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this article.
	 *
	 * @param userId the user ID of this article
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this article.
	 *
	 * @return the user uuid of this article
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this article.
	 *
	 * @param userUuid the user uuid of this article
	 */
	public void setUserUuid(String userUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.softwerke.srv.model.Article article);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.softwerke.srv.model.Article> toCacheModel();

	@Override
	public com.softwerke.srv.model.Article toEscapedModel();

	@Override
	public com.softwerke.srv.model.Article toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}