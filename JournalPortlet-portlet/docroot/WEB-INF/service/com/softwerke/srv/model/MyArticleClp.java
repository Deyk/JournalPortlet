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

import com.softwerke.srv.service.ClpSerializer;
import com.softwerke.srv.service.MyArticleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sasha
 */
public class MyArticleClp extends BaseModelImpl<MyArticle> implements MyArticle {
	public MyArticleClp() {
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
	public long getPrimaryKey() {
		return _myArticleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMyArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _myArticleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_myArticleRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMyArticleId() {
		return _myArticleId;
	}

	@Override
	public void setMyArticleId(long myArticleId) {
		_myArticleId = myArticleId;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMyArticleId", long.class);

				method.invoke(_myArticleRemoteModel, myArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMyArticleName() {
		return _myArticleName;
	}

	@Override
	public void setMyArticleName(String myArticleName) {
		_myArticleName = myArticleName;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMyArticleName", String.class);

				method.invoke(_myArticleRemoteModel, myArticleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMyArticleContent() {
		return _myArticleContent;
	}

	@Override
	public void setMyArticleContent(String myArticleContent) {
		_myArticleContent = myArticleContent;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMyArticleContent",
						String.class);

				method.invoke(_myArticleRemoteModel, myArticleContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMyArticleRefuseComment() {
		return _myArticleRefuseComment;
	}

	@Override
	public void setMyArticleRefuseComment(String myArticleRefuseComment) {
		_myArticleRefuseComment = myArticleRefuseComment;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMyArticleRefuseComment",
						String.class);

				method.invoke(_myArticleRemoteModel, myArticleRefuseComment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMyArticleStatus() {
		return _myArticleStatus;
	}

	@Override
	public void setMyArticleStatus(int myArticleStatus) {
		_myArticleStatus = myArticleStatus;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setMyArticleStatus", int.class);

				method.invoke(_myArticleRemoteModel, myArticleStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMyArticlePublished() {
		return _isMyArticlePublished;
	}

	@Override
	public boolean isIsMyArticlePublished() {
		return _isMyArticlePublished;
	}

	@Override
	public void setIsMyArticlePublished(boolean isMyArticlePublished) {
		_isMyArticlePublished = isMyArticlePublished;

		if (_myArticleRemoteModel != null) {
			try {
				Class<?> clazz = _myArticleRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMyArticlePublished",
						boolean.class);

				method.invoke(_myArticleRemoteModel, isMyArticlePublished);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMyArticleRemoteModel() {
		return _myArticleRemoteModel;
	}

	public void setMyArticleRemoteModel(BaseModel<?> myArticleRemoteModel) {
		_myArticleRemoteModel = myArticleRemoteModel;
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

		Class<?> remoteModelClass = _myArticleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_myArticleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MyArticleLocalServiceUtil.addMyArticle(this);
		}
		else {
			MyArticleLocalServiceUtil.updateMyArticle(this);
		}
	}

	@Override
	public MyArticle toEscapedModel() {
		return (MyArticle)ProxyUtil.newProxyInstance(MyArticle.class.getClassLoader(),
			new Class[] { MyArticle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MyArticleClp clone = new MyArticleClp();

		clone.setUuid(getUuid());
		clone.setMyArticleId(getMyArticleId());
		clone.setMyArticleName(getMyArticleName());
		clone.setMyArticleContent(getMyArticleContent());
		clone.setMyArticleRefuseComment(getMyArticleRefuseComment());
		clone.setMyArticleStatus(getMyArticleStatus());
		clone.setIsMyArticlePublished(getIsMyArticlePublished());

		return clone;
	}

	@Override
	public int compareTo(MyArticle myArticle) {
		long primaryKey = myArticle.getPrimaryKey();

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

		if (!(obj instanceof MyArticleClp)) {
			return false;
		}

		MyArticleClp myArticle = (MyArticleClp)obj;

		long primaryKey = myArticle.getPrimaryKey();

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
		sb.append(", myArticleId=");
		sb.append(getMyArticleId());
		sb.append(", myArticleName=");
		sb.append(getMyArticleName());
		sb.append(", myArticleContent=");
		sb.append(getMyArticleContent());
		sb.append(", myArticleRefuseComment=");
		sb.append(getMyArticleRefuseComment());
		sb.append(", myArticleStatus=");
		sb.append(getMyArticleStatus());
		sb.append(", isMyArticlePublished=");
		sb.append(getIsMyArticlePublished());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.softwerke.srv.model.MyArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myArticleId</column-name><column-value><![CDATA[");
		sb.append(getMyArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myArticleName</column-name><column-value><![CDATA[");
		sb.append(getMyArticleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myArticleContent</column-name><column-value><![CDATA[");
		sb.append(getMyArticleContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myArticleRefuseComment</column-name><column-value><![CDATA[");
		sb.append(getMyArticleRefuseComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myArticleStatus</column-name><column-value><![CDATA[");
		sb.append(getMyArticleStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMyArticlePublished</column-name><column-value><![CDATA[");
		sb.append(getIsMyArticlePublished());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _myArticleId;
	private String _myArticleName;
	private String _myArticleContent;
	private String _myArticleRefuseComment;
	private int _myArticleStatus;
	private boolean _isMyArticlePublished;
	private BaseModel<?> _myArticleRemoteModel;
	private Class<?> _clpSerializerClass = com.softwerke.srv.service.ClpSerializer.class;
}