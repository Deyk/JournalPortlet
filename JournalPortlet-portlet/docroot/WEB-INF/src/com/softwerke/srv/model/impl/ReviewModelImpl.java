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

package com.softwerke.srv.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.softwerke.srv.model.Review;
import com.softwerke.srv.model.ReviewModel;
import com.softwerke.srv.model.ReviewSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Review service. Represents a row in the &quot;new_perfect_journal_Review&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.softwerke.srv.model.ReviewModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReviewImpl}.
 * </p>
 *
 * @author Sasha
 * @see ReviewImpl
 * @see com.softwerke.srv.model.Review
 * @see com.softwerke.srv.model.ReviewModel
 * @generated
 */
@JSON(strict = true)
public class ReviewModelImpl extends BaseModelImpl<Review>
	implements ReviewModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a review model instance should use the {@link com.softwerke.srv.model.Review} interface instead.
	 */
	public static final String TABLE_NAME = "new_perfect_journal_Review";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "reviewId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "reviewName", Types.VARCHAR },
			{ "reviewContent", Types.VARCHAR },
			{ "articleId", Types.BIGINT },
			{ "userId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table new_perfect_journal_Review (uuid_ VARCHAR(75) null,reviewId LONG not null primary key,groupId LONG,reviewName VARCHAR(75) null,reviewContent TEXT null,articleId LONG,userId LONG)";
	public static final String TABLE_SQL_DROP = "drop table new_perfect_journal_Review";
	public static final String ORDER_BY_JPQL = " ORDER BY review.reviewId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY new_perfect_journal_Review.reviewId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.softwerke.srv.model.Review"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.softwerke.srv.model.Review"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.softwerke.srv.model.Review"),
			true);
	public static long ARTICLEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long REVIEWID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Review toModel(ReviewSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Review model = new ReviewImpl();

		model.setUuid(soapModel.getUuid());
		model.setReviewId(soapModel.getReviewId());
		model.setGroupId(soapModel.getGroupId());
		model.setReviewName(soapModel.getReviewName());
		model.setReviewContent(soapModel.getReviewContent());
		model.setArticleId(soapModel.getArticleId());
		model.setUserId(soapModel.getUserId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Review> toModels(ReviewSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Review> models = new ArrayList<Review>(soapModels.length);

		for (ReviewSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.softwerke.srv.model.Review"));

	public ReviewModelImpl() {
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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getReviewId() {
		return _reviewId;
	}

	@Override
	public void setReviewId(long reviewId) {
		_reviewId = reviewId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public String getReviewName() {
		if (_reviewName == null) {
			return StringPool.BLANK;
		}
		else {
			return _reviewName;
		}
	}

	@Override
	public void setReviewName(String reviewName) {
		_reviewName = reviewName;
	}

	@JSON
	@Override
	public String getReviewContent() {
		if (_reviewContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _reviewContent;
		}
	}

	@Override
	public void setReviewContent(String reviewContent) {
		_reviewContent = reviewContent;
	}

	@JSON
	@Override
	public long getArticleId() {
		return _articleId;
	}

	@Override
	public void setArticleId(long articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (!_setOriginalArticleId) {
			_setOriginalArticleId = true;

			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public long getOriginalArticleId() {
		return _originalArticleId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Review.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Review toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Review)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ReviewImpl reviewImpl = new ReviewImpl();

		reviewImpl.setUuid(getUuid());
		reviewImpl.setReviewId(getReviewId());
		reviewImpl.setGroupId(getGroupId());
		reviewImpl.setReviewName(getReviewName());
		reviewImpl.setReviewContent(getReviewContent());
		reviewImpl.setArticleId(getArticleId());
		reviewImpl.setUserId(getUserId());

		reviewImpl.resetOriginalValues();

		return reviewImpl;
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

		if (!(obj instanceof Review)) {
			return false;
		}

		Review review = (Review)obj;

		long primaryKey = review.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ReviewModelImpl reviewModelImpl = this;

		reviewModelImpl._originalUuid = reviewModelImpl._uuid;

		reviewModelImpl._originalGroupId = reviewModelImpl._groupId;

		reviewModelImpl._setOriginalGroupId = false;

		reviewModelImpl._originalArticleId = reviewModelImpl._articleId;

		reviewModelImpl._setOriginalArticleId = false;

		reviewModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Review> toCacheModel() {
		ReviewCacheModel reviewCacheModel = new ReviewCacheModel();

		reviewCacheModel.uuid = getUuid();

		String uuid = reviewCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			reviewCacheModel.uuid = null;
		}

		reviewCacheModel.reviewId = getReviewId();

		reviewCacheModel.groupId = getGroupId();

		reviewCacheModel.reviewName = getReviewName();

		String reviewName = reviewCacheModel.reviewName;

		if ((reviewName != null) && (reviewName.length() == 0)) {
			reviewCacheModel.reviewName = null;
		}

		reviewCacheModel.reviewContent = getReviewContent();

		String reviewContent = reviewCacheModel.reviewContent;

		if ((reviewContent != null) && (reviewContent.length() == 0)) {
			reviewCacheModel.reviewContent = null;
		}

		reviewCacheModel.articleId = getArticleId();

		reviewCacheModel.userId = getUserId();

		return reviewCacheModel;
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

	private static ClassLoader _classLoader = Review.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Review.class };
	private String _uuid;
	private String _originalUuid;
	private long _reviewId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _reviewName;
	private String _reviewContent;
	private long _articleId;
	private long _originalArticleId;
	private boolean _setOriginalArticleId;
	private long _userId;
	private String _userUuid;
	private long _columnBitmask;
	private Review _escapedModel;
}