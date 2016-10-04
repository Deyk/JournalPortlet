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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MyReview}.
 * </p>
 *
 * @author Sasha
 * @see MyReview
 * @generated
 */
public class MyReviewWrapper implements MyReview, ModelWrapper<MyReview> {
	public MyReviewWrapper(MyReview myReview) {
		_myReview = myReview;
	}

	@Override
	public Class<?> getModelClass() {
		return MyReview.class;
	}

	@Override
	public String getModelClassName() {
		return MyReview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("myReviewId", getMyReviewId());
		attributes.put("myReviewDateCreation", getMyReviewDateCreation());
		attributes.put("myReviewDateModification", getMyReviewDateModification());
		attributes.put("myReviewArticleId", getMyReviewArticleId());
		attributes.put("MyReviewName", getMyReviewName());
		attributes.put("MyReviewContent", getMyReviewContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long myReviewId = (Long)attributes.get("myReviewId");

		if (myReviewId != null) {
			setMyReviewId(myReviewId);
		}

		Date myReviewDateCreation = (Date)attributes.get("myReviewDateCreation");

		if (myReviewDateCreation != null) {
			setMyReviewDateCreation(myReviewDateCreation);
		}

		Date myReviewDateModification = (Date)attributes.get(
				"myReviewDateModification");

		if (myReviewDateModification != null) {
			setMyReviewDateModification(myReviewDateModification);
		}

		Long myReviewArticleId = (Long)attributes.get("myReviewArticleId");

		if (myReviewArticleId != null) {
			setMyReviewArticleId(myReviewArticleId);
		}

		String MyReviewName = (String)attributes.get("MyReviewName");

		if (MyReviewName != null) {
			setMyReviewName(MyReviewName);
		}

		String MyReviewContent = (String)attributes.get("MyReviewContent");

		if (MyReviewContent != null) {
			setMyReviewContent(MyReviewContent);
		}
	}

	/**
	* Returns the primary key of this my review.
	*
	* @return the primary key of this my review
	*/
	@Override
	public long getPrimaryKey() {
		return _myReview.getPrimaryKey();
	}

	/**
	* Sets the primary key of this my review.
	*
	* @param primaryKey the primary key of this my review
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_myReview.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this my review.
	*
	* @return the uuid of this my review
	*/
	@Override
	public java.lang.String getUuid() {
		return _myReview.getUuid();
	}

	/**
	* Sets the uuid of this my review.
	*
	* @param uuid the uuid of this my review
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_myReview.setUuid(uuid);
	}

	/**
	* Returns the my review ID of this my review.
	*
	* @return the my review ID of this my review
	*/
	@Override
	public long getMyReviewId() {
		return _myReview.getMyReviewId();
	}

	/**
	* Sets the my review ID of this my review.
	*
	* @param myReviewId the my review ID of this my review
	*/
	@Override
	public void setMyReviewId(long myReviewId) {
		_myReview.setMyReviewId(myReviewId);
	}

	/**
	* Returns the my review date creation of this my review.
	*
	* @return the my review date creation of this my review
	*/
	@Override
	public java.util.Date getMyReviewDateCreation() {
		return _myReview.getMyReviewDateCreation();
	}

	/**
	* Sets the my review date creation of this my review.
	*
	* @param myReviewDateCreation the my review date creation of this my review
	*/
	@Override
	public void setMyReviewDateCreation(java.util.Date myReviewDateCreation) {
		_myReview.setMyReviewDateCreation(myReviewDateCreation);
	}

	/**
	* Returns the my review date modification of this my review.
	*
	* @return the my review date modification of this my review
	*/
	@Override
	public java.util.Date getMyReviewDateModification() {
		return _myReview.getMyReviewDateModification();
	}

	/**
	* Sets the my review date modification of this my review.
	*
	* @param myReviewDateModification the my review date modification of this my review
	*/
	@Override
	public void setMyReviewDateModification(
		java.util.Date myReviewDateModification) {
		_myReview.setMyReviewDateModification(myReviewDateModification);
	}

	/**
	* Returns the my review article ID of this my review.
	*
	* @return the my review article ID of this my review
	*/
	@Override
	public long getMyReviewArticleId() {
		return _myReview.getMyReviewArticleId();
	}

	/**
	* Sets the my review article ID of this my review.
	*
	* @param myReviewArticleId the my review article ID of this my review
	*/
	@Override
	public void setMyReviewArticleId(long myReviewArticleId) {
		_myReview.setMyReviewArticleId(myReviewArticleId);
	}

	/**
	* Returns the my review name of this my review.
	*
	* @return the my review name of this my review
	*/
	@Override
	public java.lang.String getMyReviewName() {
		return _myReview.getMyReviewName();
	}

	/**
	* Sets the my review name of this my review.
	*
	* @param MyReviewName the my review name of this my review
	*/
	@Override
	public void setMyReviewName(java.lang.String MyReviewName) {
		_myReview.setMyReviewName(MyReviewName);
	}

	/**
	* Returns the my review content of this my review.
	*
	* @return the my review content of this my review
	*/
	@Override
	public java.lang.String getMyReviewContent() {
		return _myReview.getMyReviewContent();
	}

	/**
	* Sets the my review content of this my review.
	*
	* @param MyReviewContent the my review content of this my review
	*/
	@Override
	public void setMyReviewContent(java.lang.String MyReviewContent) {
		_myReview.setMyReviewContent(MyReviewContent);
	}

	@Override
	public boolean isNew() {
		return _myReview.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_myReview.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _myReview.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_myReview.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _myReview.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _myReview.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_myReview.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myReview.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_myReview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_myReview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myReview.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MyReviewWrapper((MyReview)_myReview.clone());
	}

	@Override
	public int compareTo(com.softwerke.srv.model.MyReview myReview) {
		return _myReview.compareTo(myReview);
	}

	@Override
	public int hashCode() {
		return _myReview.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.softwerke.srv.model.MyReview> toCacheModel() {
		return _myReview.toCacheModel();
	}

	@Override
	public com.softwerke.srv.model.MyReview toEscapedModel() {
		return new MyReviewWrapper(_myReview.toEscapedModel());
	}

	@Override
	public com.softwerke.srv.model.MyReview toUnescapedModel() {
		return new MyReviewWrapper(_myReview.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _myReview.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _myReview.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_myReview.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyReviewWrapper)) {
			return false;
		}

		MyReviewWrapper myReviewWrapper = (MyReviewWrapper)obj;

		if (Validator.equals(_myReview, myReviewWrapper._myReview)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MyReview getWrappedMyReview() {
		return _myReview;
	}

	@Override
	public MyReview getWrappedModel() {
		return _myReview;
	}

	@Override
	public void resetOriginalValues() {
		_myReview.resetOriginalValues();
	}

	private MyReview _myReview;
}