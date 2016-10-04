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
import com.softwerke.srv.service.MyReviewLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sasha
 */
public class MyReviewClp extends BaseModelImpl<MyReview> implements MyReview {
	public MyReviewClp() {
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
	public long getPrimaryKey() {
		return _myReviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMyReviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _myReviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_myReviewRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMyReviewId() {
		return _myReviewId;
	}

	@Override
	public void setMyReviewId(long myReviewId) {
		_myReviewId = myReviewId;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewId", long.class);

				method.invoke(_myReviewRemoteModel, myReviewId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getMyReviewDateCreation() {
		return _myReviewDateCreation;
	}

	@Override
	public void setMyReviewDateCreation(Date myReviewDateCreation) {
		_myReviewDateCreation = myReviewDateCreation;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewDateCreation",
						Date.class);

				method.invoke(_myReviewRemoteModel, myReviewDateCreation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getMyReviewDateModification() {
		return _myReviewDateModification;
	}

	@Override
	public void setMyReviewDateModification(Date myReviewDateModification) {
		_myReviewDateModification = myReviewDateModification;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewDateModification",
						Date.class);

				method.invoke(_myReviewRemoteModel, myReviewDateModification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMyReviewArticleId() {
		return _myReviewArticleId;
	}

	@Override
	public void setMyReviewArticleId(long myReviewArticleId) {
		_myReviewArticleId = myReviewArticleId;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewArticleId",
						long.class);

				method.invoke(_myReviewRemoteModel, myReviewArticleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMyReviewName() {
		return _MyReviewName;
	}

	@Override
	public void setMyReviewName(String MyReviewName) {
		_MyReviewName = MyReviewName;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewName", String.class);

				method.invoke(_myReviewRemoteModel, MyReviewName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMyReviewContent() {
		return _MyReviewContent;
	}

	@Override
	public void setMyReviewContent(String MyReviewContent) {
		_MyReviewContent = MyReviewContent;

		if (_myReviewRemoteModel != null) {
			try {
				Class<?> clazz = _myReviewRemoteModel.getClass();

				Method method = clazz.getMethod("setMyReviewContent",
						String.class);

				method.invoke(_myReviewRemoteModel, MyReviewContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMyReviewRemoteModel() {
		return _myReviewRemoteModel;
	}

	public void setMyReviewRemoteModel(BaseModel<?> myReviewRemoteModel) {
		_myReviewRemoteModel = myReviewRemoteModel;
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

		Class<?> remoteModelClass = _myReviewRemoteModel.getClass();

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

		Object returnValue = method.invoke(_myReviewRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MyReviewLocalServiceUtil.addMyReview(this);
		}
		else {
			MyReviewLocalServiceUtil.updateMyReview(this);
		}
	}

	@Override
	public MyReview toEscapedModel() {
		return (MyReview)ProxyUtil.newProxyInstance(MyReview.class.getClassLoader(),
			new Class[] { MyReview.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MyReviewClp clone = new MyReviewClp();

		clone.setUuid(getUuid());
		clone.setMyReviewId(getMyReviewId());
		clone.setMyReviewDateCreation(getMyReviewDateCreation());
		clone.setMyReviewDateModification(getMyReviewDateModification());
		clone.setMyReviewArticleId(getMyReviewArticleId());
		clone.setMyReviewName(getMyReviewName());
		clone.setMyReviewContent(getMyReviewContent());

		return clone;
	}

	@Override
	public int compareTo(MyReview myReview) {
		long primaryKey = myReview.getPrimaryKey();

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

		if (!(obj instanceof MyReviewClp)) {
			return false;
		}

		MyReviewClp myReview = (MyReviewClp)obj;

		long primaryKey = myReview.getPrimaryKey();

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
		sb.append(", myReviewId=");
		sb.append(getMyReviewId());
		sb.append(", myReviewDateCreation=");
		sb.append(getMyReviewDateCreation());
		sb.append(", myReviewDateModification=");
		sb.append(getMyReviewDateModification());
		sb.append(", myReviewArticleId=");
		sb.append(getMyReviewArticleId());
		sb.append(", MyReviewName=");
		sb.append(getMyReviewName());
		sb.append(", MyReviewContent=");
		sb.append(getMyReviewContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.softwerke.srv.model.MyReview");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myReviewId</column-name><column-value><![CDATA[");
		sb.append(getMyReviewId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myReviewDateCreation</column-name><column-value><![CDATA[");
		sb.append(getMyReviewDateCreation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myReviewDateModification</column-name><column-value><![CDATA[");
		sb.append(getMyReviewDateModification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>myReviewArticleId</column-name><column-value><![CDATA[");
		sb.append(getMyReviewArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MyReviewName</column-name><column-value><![CDATA[");
		sb.append(getMyReviewName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MyReviewContent</column-name><column-value><![CDATA[");
		sb.append(getMyReviewContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _myReviewId;
	private Date _myReviewDateCreation;
	private Date _myReviewDateModification;
	private long _myReviewArticleId;
	private String _MyReviewName;
	private String _MyReviewContent;
	private BaseModel<?> _myReviewRemoteModel;
	private Class<?> _clpSerializerClass = com.softwerke.srv.service.ClpSerializer.class;
}