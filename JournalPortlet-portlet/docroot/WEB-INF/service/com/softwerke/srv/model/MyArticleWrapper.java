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
 * This class is a wrapper for {@link MyArticle}.
 * </p>
 *
 * @author Sasha
 * @see MyArticle
 * @generated
 */
public class MyArticleWrapper implements MyArticle, ModelWrapper<MyArticle> {
	public MyArticleWrapper(MyArticle myArticle) {
		_myArticle = myArticle;
	}

	@Override
	public Class<?> getModelClass() {
		return MyArticle.class;
	}

	@Override
	public String getModelClassName() {
		return MyArticle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("myArticleId", getMyArticleId());
		attributes.put("myArticleName", getMyArticleName());
		attributes.put("myArticleContent", getMyArticleContent());
		attributes.put("myArticleRefuseComment", getMyArticleRefuseComment());
		attributes.put("myArticleStatus", getMyArticleStatus());
		attributes.put("isMyArticlePublished", getIsMyArticlePublished());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long myArticleId = (Long)attributes.get("myArticleId");

		if (myArticleId != null) {
			setMyArticleId(myArticleId);
		}

		String myArticleName = (String)attributes.get("myArticleName");

		if (myArticleName != null) {
			setMyArticleName(myArticleName);
		}

		String myArticleContent = (String)attributes.get("myArticleContent");

		if (myArticleContent != null) {
			setMyArticleContent(myArticleContent);
		}

		String myArticleRefuseComment = (String)attributes.get(
				"myArticleRefuseComment");

		if (myArticleRefuseComment != null) {
			setMyArticleRefuseComment(myArticleRefuseComment);
		}

		Integer myArticleStatus = (Integer)attributes.get("myArticleStatus");

		if (myArticleStatus != null) {
			setMyArticleStatus(myArticleStatus);
		}

		Boolean isMyArticlePublished = (Boolean)attributes.get(
				"isMyArticlePublished");

		if (isMyArticlePublished != null) {
			setIsMyArticlePublished(isMyArticlePublished);
		}
	}

	/**
	* Returns the primary key of this my article.
	*
	* @return the primary key of this my article
	*/
	@Override
	public long getPrimaryKey() {
		return _myArticle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this my article.
	*
	* @param primaryKey the primary key of this my article
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_myArticle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this my article.
	*
	* @return the uuid of this my article
	*/
	@Override
	public java.lang.String getUuid() {
		return _myArticle.getUuid();
	}

	/**
	* Sets the uuid of this my article.
	*
	* @param uuid the uuid of this my article
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_myArticle.setUuid(uuid);
	}

	/**
	* Returns the my article ID of this my article.
	*
	* @return the my article ID of this my article
	*/
	@Override
	public long getMyArticleId() {
		return _myArticle.getMyArticleId();
	}

	/**
	* Sets the my article ID of this my article.
	*
	* @param myArticleId the my article ID of this my article
	*/
	@Override
	public void setMyArticleId(long myArticleId) {
		_myArticle.setMyArticleId(myArticleId);
	}

	/**
	* Returns the my article name of this my article.
	*
	* @return the my article name of this my article
	*/
	@Override
	public java.lang.String getMyArticleName() {
		return _myArticle.getMyArticleName();
	}

	/**
	* Sets the my article name of this my article.
	*
	* @param myArticleName the my article name of this my article
	*/
	@Override
	public void setMyArticleName(java.lang.String myArticleName) {
		_myArticle.setMyArticleName(myArticleName);
	}

	/**
	* Returns the my article content of this my article.
	*
	* @return the my article content of this my article
	*/
	@Override
	public java.lang.String getMyArticleContent() {
		return _myArticle.getMyArticleContent();
	}

	/**
	* Sets the my article content of this my article.
	*
	* @param myArticleContent the my article content of this my article
	*/
	@Override
	public void setMyArticleContent(java.lang.String myArticleContent) {
		_myArticle.setMyArticleContent(myArticleContent);
	}

	/**
	* Returns the my article refuse comment of this my article.
	*
	* @return the my article refuse comment of this my article
	*/
	@Override
	public java.lang.String getMyArticleRefuseComment() {
		return _myArticle.getMyArticleRefuseComment();
	}

	/**
	* Sets the my article refuse comment of this my article.
	*
	* @param myArticleRefuseComment the my article refuse comment of this my article
	*/
	@Override
	public void setMyArticleRefuseComment(
		java.lang.String myArticleRefuseComment) {
		_myArticle.setMyArticleRefuseComment(myArticleRefuseComment);
	}

	/**
	* Returns the my article status of this my article.
	*
	* @return the my article status of this my article
	*/
	@Override
	public int getMyArticleStatus() {
		return _myArticle.getMyArticleStatus();
	}

	/**
	* Sets the my article status of this my article.
	*
	* @param myArticleStatus the my article status of this my article
	*/
	@Override
	public void setMyArticleStatus(int myArticleStatus) {
		_myArticle.setMyArticleStatus(myArticleStatus);
	}

	/**
	* Returns the is my article published of this my article.
	*
	* @return the is my article published of this my article
	*/
	@Override
	public boolean getIsMyArticlePublished() {
		return _myArticle.getIsMyArticlePublished();
	}

	/**
	* Returns <code>true</code> if this my article is is my article published.
	*
	* @return <code>true</code> if this my article is is my article published; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMyArticlePublished() {
		return _myArticle.isIsMyArticlePublished();
	}

	/**
	* Sets whether this my article is is my article published.
	*
	* @param isMyArticlePublished the is my article published of this my article
	*/
	@Override
	public void setIsMyArticlePublished(boolean isMyArticlePublished) {
		_myArticle.setIsMyArticlePublished(isMyArticlePublished);
	}

	@Override
	public boolean isNew() {
		return _myArticle.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_myArticle.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _myArticle.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_myArticle.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _myArticle.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _myArticle.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_myArticle.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myArticle.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_myArticle.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_myArticle.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myArticle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MyArticleWrapper((MyArticle)_myArticle.clone());
	}

	@Override
	public int compareTo(com.softwerke.srv.model.MyArticle myArticle) {
		return _myArticle.compareTo(myArticle);
	}

	@Override
	public int hashCode() {
		return _myArticle.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.softwerke.srv.model.MyArticle> toCacheModel() {
		return _myArticle.toCacheModel();
	}

	@Override
	public com.softwerke.srv.model.MyArticle toEscapedModel() {
		return new MyArticleWrapper(_myArticle.toEscapedModel());
	}

	@Override
	public com.softwerke.srv.model.MyArticle toUnescapedModel() {
		return new MyArticleWrapper(_myArticle.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _myArticle.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _myArticle.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_myArticle.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyArticleWrapper)) {
			return false;
		}

		MyArticleWrapper myArticleWrapper = (MyArticleWrapper)obj;

		if (Validator.equals(_myArticle, myArticleWrapper._myArticle)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MyArticle getWrappedMyArticle() {
		return _myArticle;
	}

	@Override
	public MyArticle getWrappedModel() {
		return _myArticle;
	}

	@Override
	public void resetOriginalValues() {
		_myArticle.resetOriginalValues();
	}

	private MyArticle _myArticle;
}