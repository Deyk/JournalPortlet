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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.softwerke.srv.service.http.MyReviewServiceSoap}.
 *
 * @author Sasha
 * @see com.softwerke.srv.service.http.MyReviewServiceSoap
 * @generated
 */
public class MyReviewSoap implements Serializable {
	public static MyReviewSoap toSoapModel(MyReview model) {
		MyReviewSoap soapModel = new MyReviewSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMyReviewId(model.getMyReviewId());
		soapModel.setMyReviewDateCreation(model.getMyReviewDateCreation());
		soapModel.setMyReviewDateModification(model.getMyReviewDateModification());
		soapModel.setMyReviewArticleId(model.getMyReviewArticleId());
		soapModel.setMyReviewName(model.getMyReviewName());
		soapModel.setMyReviewContent(model.getMyReviewContent());

		return soapModel;
	}

	public static MyReviewSoap[] toSoapModels(MyReview[] models) {
		MyReviewSoap[] soapModels = new MyReviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MyReviewSoap[][] toSoapModels(MyReview[][] models) {
		MyReviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MyReviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MyReviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MyReviewSoap[] toSoapModels(List<MyReview> models) {
		List<MyReviewSoap> soapModels = new ArrayList<MyReviewSoap>(models.size());

		for (MyReview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MyReviewSoap[soapModels.size()]);
	}

	public MyReviewSoap() {
	}

	public long getPrimaryKey() {
		return _myReviewId;
	}

	public void setPrimaryKey(long pk) {
		setMyReviewId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMyReviewId() {
		return _myReviewId;
	}

	public void setMyReviewId(long myReviewId) {
		_myReviewId = myReviewId;
	}

	public Date getMyReviewDateCreation() {
		return _myReviewDateCreation;
	}

	public void setMyReviewDateCreation(Date myReviewDateCreation) {
		_myReviewDateCreation = myReviewDateCreation;
	}

	public Date getMyReviewDateModification() {
		return _myReviewDateModification;
	}

	public void setMyReviewDateModification(Date myReviewDateModification) {
		_myReviewDateModification = myReviewDateModification;
	}

	public long getMyReviewArticleId() {
		return _myReviewArticleId;
	}

	public void setMyReviewArticleId(long myReviewArticleId) {
		_myReviewArticleId = myReviewArticleId;
	}

	public String getMyReviewName() {
		return _MyReviewName;
	}

	public void setMyReviewName(String MyReviewName) {
		_MyReviewName = MyReviewName;
	}

	public String getMyReviewContent() {
		return _MyReviewContent;
	}

	public void setMyReviewContent(String MyReviewContent) {
		_MyReviewContent = MyReviewContent;
	}

	private String _uuid;
	private long _myReviewId;
	private Date _myReviewDateCreation;
	private Date _myReviewDateModification;
	private long _myReviewArticleId;
	private String _MyReviewName;
	private String _MyReviewContent;
}