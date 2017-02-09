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
 * This class is used by SOAP remote services, specifically {@link com.softwerke.srv.service.http.ReviewServiceSoap}.
 *
 * @author Sasha
 * @see com.softwerke.srv.service.http.ReviewServiceSoap
 * @generated
 */
public class ReviewSoap implements Serializable {
	public static ReviewSoap toSoapModel(Review model) {
		ReviewSoap soapModel = new ReviewSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setReviewId(model.getReviewId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setReviewName(model.getReviewName());
		soapModel.setReviewContent(model.getReviewContent());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ReviewSoap[] toSoapModels(Review[] models) {
		ReviewSoap[] soapModels = new ReviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ReviewSoap[][] toSoapModels(Review[][] models) {
		ReviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ReviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ReviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ReviewSoap[] toSoapModels(List<Review> models) {
		List<ReviewSoap> soapModels = new ArrayList<ReviewSoap>(models.size());

		for (Review model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ReviewSoap[soapModels.size()]);
	}

	public ReviewSoap() {
	}

	public long getPrimaryKey() {
		return _reviewId;
	}

	public void setPrimaryKey(long pk) {
		setReviewId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getReviewId() {
		return _reviewId;
	}

	public void setReviewId(long reviewId) {
		_reviewId = reviewId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getReviewName() {
		return _reviewName;
	}

	public void setReviewName(String reviewName) {
		_reviewName = reviewName;
	}

	public String getReviewContent() {
		return _reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		_reviewContent = reviewContent;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _reviewId;
	private long _groupId;
	private String _reviewName;
	private String _reviewContent;
	private long _articleId;
	private long _userId;
}