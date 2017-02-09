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
 * This class is a wrapper for {@link Review}.
 * </p>
 *
 * @author Sasha
 * @see Review
 * @generated
 */
public class ReviewWrapper implements Review, ModelWrapper<Review> {
	public ReviewWrapper(Review review) {
		_review = review;
	}

	@Override
	public Class<?> getModelClass() {
		return Review.class;
	}

	@Override
	public String getModelClassName() {
		return Review.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("reviewId", getReviewId());
		attributes.put("groupId", getGroupId());
		attributes.put("reviewName", getReviewName());
		attributes.put("reviewContent", getReviewContent());
		attributes.put("articleId", getArticleId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long reviewId = (Long)attributes.get("reviewId");

		if (reviewId != null) {
			setReviewId(reviewId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String reviewName = (String)attributes.get("reviewName");

		if (reviewName != null) {
			setReviewName(reviewName);
		}

		String reviewContent = (String)attributes.get("reviewContent");

		if (reviewContent != null) {
			setReviewContent(reviewContent);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this review.
	*
	* @return the primary key of this review
	*/
	@Override
	public long getPrimaryKey() {
		return _review.getPrimaryKey();
	}

	/**
	* Sets the primary key of this review.
	*
	* @param primaryKey the primary key of this review
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_review.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this review.
	*
	* @return the uuid of this review
	*/
	@Override
	public java.lang.String getUuid() {
		return _review.getUuid();
	}

	/**
	* Sets the uuid of this review.
	*
	* @param uuid the uuid of this review
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_review.setUuid(uuid);
	}

	/**
	* Returns the review ID of this review.
	*
	* @return the review ID of this review
	*/
	@Override
	public long getReviewId() {
		return _review.getReviewId();
	}

	/**
	* Sets the review ID of this review.
	*
	* @param reviewId the review ID of this review
	*/
	@Override
	public void setReviewId(long reviewId) {
		_review.setReviewId(reviewId);
	}

	/**
	* Returns the group ID of this review.
	*
	* @return the group ID of this review
	*/
	@Override
	public long getGroupId() {
		return _review.getGroupId();
	}

	/**
	* Sets the group ID of this review.
	*
	* @param groupId the group ID of this review
	*/
	@Override
	public void setGroupId(long groupId) {
		_review.setGroupId(groupId);
	}

	/**
	* Returns the review name of this review.
	*
	* @return the review name of this review
	*/
	@Override
	public java.lang.String getReviewName() {
		return _review.getReviewName();
	}

	/**
	* Sets the review name of this review.
	*
	* @param reviewName the review name of this review
	*/
	@Override
	public void setReviewName(java.lang.String reviewName) {
		_review.setReviewName(reviewName);
	}

	/**
	* Returns the review content of this review.
	*
	* @return the review content of this review
	*/
	@Override
	public java.lang.String getReviewContent() {
		return _review.getReviewContent();
	}

	/**
	* Sets the review content of this review.
	*
	* @param reviewContent the review content of this review
	*/
	@Override
	public void setReviewContent(java.lang.String reviewContent) {
		_review.setReviewContent(reviewContent);
	}

	/**
	* Returns the article ID of this review.
	*
	* @return the article ID of this review
	*/
	@Override
	public long getArticleId() {
		return _review.getArticleId();
	}

	/**
	* Sets the article ID of this review.
	*
	* @param articleId the article ID of this review
	*/
	@Override
	public void setArticleId(long articleId) {
		_review.setArticleId(articleId);
	}

	/**
	* Returns the user ID of this review.
	*
	* @return the user ID of this review
	*/
	@Override
	public long getUserId() {
		return _review.getUserId();
	}

	/**
	* Sets the user ID of this review.
	*
	* @param userId the user ID of this review
	*/
	@Override
	public void setUserId(long userId) {
		_review.setUserId(userId);
	}

	/**
	* Returns the user uuid of this review.
	*
	* @return the user uuid of this review
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _review.getUserUuid();
	}

	/**
	* Sets the user uuid of this review.
	*
	* @param userUuid the user uuid of this review
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_review.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _review.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_review.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _review.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_review.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _review.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _review.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_review.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _review.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_review.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_review.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_review.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReviewWrapper((Review)_review.clone());
	}

	@Override
	public int compareTo(com.softwerke.srv.model.Review review) {
		return _review.compareTo(review);
	}

	@Override
	public int hashCode() {
		return _review.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.softwerke.srv.model.Review> toCacheModel() {
		return _review.toCacheModel();
	}

	@Override
	public com.softwerke.srv.model.Review toEscapedModel() {
		return new ReviewWrapper(_review.toEscapedModel());
	}

	@Override
	public com.softwerke.srv.model.Review toUnescapedModel() {
		return new ReviewWrapper(_review.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _review.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _review.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_review.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReviewWrapper)) {
			return false;
		}

		ReviewWrapper reviewWrapper = (ReviewWrapper)obj;

		if (Validator.equals(_review, reviewWrapper._review)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Review getWrappedReview() {
		return _review;
	}

	@Override
	public Review getWrappedModel() {
		return _review;
	}

	@Override
	public void resetOriginalValues() {
		_review.resetOriginalValues();
	}

	private Review _review;
}