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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.softwerke.srv.service.ClpSerializer;
import com.softwerke.srv.service.ReviewLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sasha
 */
public class ReviewClp extends BaseModelImpl<Review> implements Review {
	public ReviewClp() {
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
	public long getPrimaryKey() {
		return _reviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_reviewRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReviewId() {
		return _reviewId;
	}

	@Override
	public void setReviewId(long reviewId) {
		_reviewId = reviewId;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewId", long.class);

				method.invoke(_reviewRemoteModel, reviewId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_reviewRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReviewName() {
		return _reviewName;
	}

	@Override
	public void setReviewName(String reviewName) {
		_reviewName = reviewName;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewName", String.class);

				method.invoke(_reviewRemoteModel, reviewName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReviewContent() {
		return _reviewContent;
	}

	@Override
	public void setReviewContent(String reviewContent) {
		_reviewContent = reviewContent;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewContent", String.class);

				method.invoke(_reviewRemoteModel, reviewContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_articleId = articleId;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_reviewRemoteModel, articleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_reviewRemoteModel != null) {
			try {
				Class<?> clazz = _reviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_reviewRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getReviewRemoteModel() {
		return _reviewRemoteModel;
	}

	public void setReviewRemoteModel(BaseModel<?> reviewRemoteModel) {
		_reviewRemoteModel = reviewRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _reviewRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_reviewRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReviewLocalServiceUtil.addReview(this);
		}
		else {
			ReviewLocalServiceUtil.updateReview(this);
		}
	}

	@Override
	public Review toEscapedModel() {
		return (Review)ProxyUtil.newProxyInstance(Review.class.getClassLoader(),
			new Class[] { Review.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ReviewClp clone = new ReviewClp();

		clone.setUuid(getUuid());
		clone.setReviewId(getReviewId());
		clone.setGroupId(getGroupId());
		clone.setReviewName(getReviewName());
		clone.setReviewContent(getReviewContent());
		clone.setArticleId(getArticleId());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Review review) {
		long primaryKey = review.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReviewClp)) {
			return false;
		}

		ReviewClp review = (ReviewClp)obj;

		long primaryKey = review.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", reviewId=");
		sb.append(getReviewId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", reviewName=");
		sb.append(getReviewName());
		sb.append(", reviewContent=");
		sb.append(getReviewContent());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.softwerke.srv.model.Review");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewId</column-name><column-value><![CDATA[");
		sb.append(getReviewId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewName</column-name><column-value><![CDATA[");
		sb.append(getReviewName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewContent</column-name><column-value><![CDATA[");
		sb.append(getReviewContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _reviewId;
	private long _groupId;
	private String _reviewName;
	private String _reviewContent;
	private long _articleId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _reviewRemoteModel;
	private Class<?> _clpSerializerClass = com.softwerke.srv.service.ClpSerializer.class;
}