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
 * This class is used by SOAP remote services, specifically {@link com.softwerke.srv.service.http.MyArticleServiceSoap}.
 *
 * @author Sasha
 * @see com.softwerke.srv.service.http.MyArticleServiceSoap
 * @generated
 */
public class MyArticleSoap implements Serializable {
	public static MyArticleSoap toSoapModel(MyArticle model) {
		MyArticleSoap soapModel = new MyArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMyArticleId(model.getMyArticleId());
		soapModel.setMyArticleName(model.getMyArticleName());
		soapModel.setMyArticleContent(model.getMyArticleContent());
		soapModel.setMyArticleRefuseComment(model.getMyArticleRefuseComment());
		soapModel.setMyArticleStatus(model.getMyArticleStatus());
		soapModel.setIsMyArticlePublished(model.getIsMyArticlePublished());

		return soapModel;
	}

	public static MyArticleSoap[] toSoapModels(MyArticle[] models) {
		MyArticleSoap[] soapModels = new MyArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MyArticleSoap[][] toSoapModels(MyArticle[][] models) {
		MyArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MyArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MyArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MyArticleSoap[] toSoapModels(List<MyArticle> models) {
		List<MyArticleSoap> soapModels = new ArrayList<MyArticleSoap>(models.size());

		for (MyArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MyArticleSoap[soapModels.size()]);
	}

	public MyArticleSoap() {
	}

	public long getPrimaryKey() {
		return _myArticleId;
	}

	public void setPrimaryKey(long pk) {
		setMyArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMyArticleId() {
		return _myArticleId;
	}

	public void setMyArticleId(long myArticleId) {
		_myArticleId = myArticleId;
	}

	public String getMyArticleName() {
		return _myArticleName;
	}

	public void setMyArticleName(String myArticleName) {
		_myArticleName = myArticleName;
	}

	public String getMyArticleContent() {
		return _myArticleContent;
	}

	public void setMyArticleContent(String myArticleContent) {
		_myArticleContent = myArticleContent;
	}

	public String getMyArticleRefuseComment() {
		return _myArticleRefuseComment;
	}

	public void setMyArticleRefuseComment(String myArticleRefuseComment) {
		_myArticleRefuseComment = myArticleRefuseComment;
	}

	public int getMyArticleStatus() {
		return _myArticleStatus;
	}

	public void setMyArticleStatus(int myArticleStatus) {
		_myArticleStatus = myArticleStatus;
	}

	public boolean getIsMyArticlePublished() {
		return _isMyArticlePublished;
	}

	public boolean isIsMyArticlePublished() {
		return _isMyArticlePublished;
	}

	public void setIsMyArticlePublished(boolean isMyArticlePublished) {
		_isMyArticlePublished = isMyArticlePublished;
	}

	private String _uuid;
	private long _myArticleId;
	private String _myArticleName;
	private String _myArticleContent;
	private String _myArticleRefuseComment;
	private int _myArticleStatus;
	private boolean _isMyArticlePublished;
}