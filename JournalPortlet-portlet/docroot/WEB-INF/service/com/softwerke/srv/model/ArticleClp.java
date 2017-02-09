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

import com.softwerke.srv.service.ArticleLocalServiceUtil;
import com.softwerke.srv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sasha
 */
public class ArticleClp extends BaseModelImpl<Article> implements Article {
	public ArticleClp() {
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
	public long getPrimaryKey() {
		return _articleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_articleRemoteModel, uuid);
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

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleId", long.class);

				method.invoke(_articleRemoteModel, articleId);
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

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_articleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArticleName() {
		return _articleName;
	}

	@Override
	public void setArticleName(String articleName) {
		_articleName = articleName;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleName", String.class);

				method.invoke(_articleRemoteModel, articleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArticleContent() {
		return _articleContent;
	}

	@Override
	public void setArticleContent(String articleContent) {
		_articleContent = articleContent;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleContent",
						String.class);

				method.invoke(_articleRemoteModel, articleContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArticleRefuseComment() {
		return _articleRefuseComment;
	}

	@Override
	public void setArticleRefuseComment(String articleRefuseComment) {
		_articleRefuseComment = articleRefuseComment;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleRefuseComment",
						String.class);

				method.invoke(_articleRemoteModel, articleRefuseComment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getArticleStatus() {
		return _articleStatus;
	}

	@Override
	public void setArticleStatus(int articleStatus) {
		_articleStatus = articleStatus;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setArticleStatus", int.class);

				method.invoke(_articleRemoteModel, articleStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsArticlePublished() {
		return _isArticlePublished;
	}

	@Override
	public boolean isIsArticlePublished() {
		return _isArticlePublished;
	}

	@Override
	public void setIsArticlePublished(boolean isArticlePublished) {
		_isArticlePublished = isArticlePublished;

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setIsArticlePublished",
						boolean.class);

				method.invoke(_articleRemoteModel, isArticlePublished);
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

		if (_articleRemoteModel != null) {
			try {
				Class<?> clazz = _articleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_articleRemoteModel, userId);
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

	public BaseModel<?> getArticleRemoteModel() {
		return _articleRemoteModel;
	}

	public void setArticleRemoteModel(BaseModel<?> articleRemoteModel) {
		_articleRemoteModel = articleRemoteModel;
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

		Class<?> remoteModelClass = _articleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_articleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ArticleLocalServiceUtil.addArticle(this);
		}
		else {
			ArticleLocalServiceUtil.updateArticle(this);
		}
	}

	@Override
	public Article toEscapedModel() {
		return (Article)ProxyUtil.newProxyInstance(Article.class.getClassLoader(),
			new Class[] { Article.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ArticleClp clone = new ArticleClp();

		clone.setUuid(getUuid());
		clone.setArticleId(getArticleId());
		clone.setGroupId(getGroupId());
		clone.setArticleName(getArticleName());
		clone.setArticleContent(getArticleContent());
		clone.setArticleRefuseComment(getArticleRefuseComment());
		clone.setArticleStatus(getArticleStatus());
		clone.setIsArticlePublished(getIsArticlePublished());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Article article) {
		long primaryKey = article.getPrimaryKey();

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

		if (!(obj instanceof ArticleClp)) {
			return false;
		}

		ArticleClp article = (ArticleClp)obj;

		long primaryKey = article.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", articleName=");
		sb.append(getArticleName());
		sb.append(", articleContent=");
		sb.append(getArticleContent());
		sb.append(", articleRefuseComment=");
		sb.append(getArticleRefuseComment());
		sb.append(", articleStatus=");
		sb.append(getArticleStatus());
		sb.append(", isArticlePublished=");
		sb.append(getIsArticlePublished());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.softwerke.srv.model.Article");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleName</column-name><column-value><![CDATA[");
		sb.append(getArticleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleContent</column-name><column-value><![CDATA[");
		sb.append(getArticleContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleRefuseComment</column-name><column-value><![CDATA[");
		sb.append(getArticleRefuseComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleStatus</column-name><column-value><![CDATA[");
		sb.append(getArticleStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isArticlePublished</column-name><column-value><![CDATA[");
		sb.append(getIsArticlePublished());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
	private BaseModel<?> _articleRemoteModel;
	private Class<?> _clpSerializerClass = com.softwerke.srv.service.ClpSerializer.class;
}