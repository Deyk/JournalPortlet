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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.softwerke.srv.model.Review;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Review in entity cache.
 *
 * @author Sasha
 * @see Review
 * @generated
 */
public class ReviewCacheModel implements CacheModel<Review>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", reviewId=");
		sb.append(reviewId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", reviewName=");
		sb.append(reviewName);
		sb.append(", reviewContent=");
		sb.append(reviewContent);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Review toEntityModel() {
		ReviewImpl reviewImpl = new ReviewImpl();

		if (uuid == null) {
			reviewImpl.setUuid(StringPool.BLANK);
		}
		else {
			reviewImpl.setUuid(uuid);
		}

		reviewImpl.setReviewId(reviewId);
		reviewImpl.setGroupId(groupId);

		if (reviewName == null) {
			reviewImpl.setReviewName(StringPool.BLANK);
		}
		else {
			reviewImpl.setReviewName(reviewName);
		}

		if (reviewContent == null) {
			reviewImpl.setReviewContent(StringPool.BLANK);
		}
		else {
			reviewImpl.setReviewContent(reviewContent);
		}

		reviewImpl.setArticleId(articleId);
		reviewImpl.setUserId(userId);

		reviewImpl.resetOriginalValues();

		return reviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		reviewId = objectInput.readLong();
		groupId = objectInput.readLong();
		reviewName = objectInput.readUTF();
		reviewContent = objectInput.readUTF();
		articleId = objectInput.readLong();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(reviewId);
		objectOutput.writeLong(groupId);

		if (reviewName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reviewName);
		}

		if (reviewContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reviewContent);
		}

		objectOutput.writeLong(articleId);
		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long reviewId;
	public long groupId;
	public String reviewName;
	public String reviewContent;
	public long articleId;
	public long userId;
}