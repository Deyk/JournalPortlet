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

import com.softwerke.srv.model.MyReview;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MyReview in entity cache.
 *
 * @author Sasha
 * @see MyReview
 * @generated
 */
public class MyReviewCacheModel implements CacheModel<MyReview>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", myReviewId=");
		sb.append(myReviewId);
		sb.append(", myReviewDateCreation=");
		sb.append(myReviewDateCreation);
		sb.append(", myReviewDateModification=");
		sb.append(myReviewDateModification);
		sb.append(", myReviewArticleId=");
		sb.append(myReviewArticleId);
		sb.append(", MyReviewName=");
		sb.append(MyReviewName);
		sb.append(", MyReviewContent=");
		sb.append(MyReviewContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MyReview toEntityModel() {
		MyReviewImpl myReviewImpl = new MyReviewImpl();

		if (uuid == null) {
			myReviewImpl.setUuid(StringPool.BLANK);
		}
		else {
			myReviewImpl.setUuid(uuid);
		}

		myReviewImpl.setMyReviewId(myReviewId);

		if (myReviewDateCreation == Long.MIN_VALUE) {
			myReviewImpl.setMyReviewDateCreation(null);
		}
		else {
			myReviewImpl.setMyReviewDateCreation(new Date(myReviewDateCreation));
		}

		if (myReviewDateModification == Long.MIN_VALUE) {
			myReviewImpl.setMyReviewDateModification(null);
		}
		else {
			myReviewImpl.setMyReviewDateModification(new Date(
					myReviewDateModification));
		}

		myReviewImpl.setMyReviewArticleId(myReviewArticleId);

		if (MyReviewName == null) {
			myReviewImpl.setMyReviewName(StringPool.BLANK);
		}
		else {
			myReviewImpl.setMyReviewName(MyReviewName);
		}

		if (MyReviewContent == null) {
			myReviewImpl.setMyReviewContent(StringPool.BLANK);
		}
		else {
			myReviewImpl.setMyReviewContent(MyReviewContent);
		}

		myReviewImpl.resetOriginalValues();

		return myReviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		myReviewId = objectInput.readLong();
		myReviewDateCreation = objectInput.readLong();
		myReviewDateModification = objectInput.readLong();
		myReviewArticleId = objectInput.readLong();
		MyReviewName = objectInput.readUTF();
		MyReviewContent = objectInput.readUTF();
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

		objectOutput.writeLong(myReviewId);
		objectOutput.writeLong(myReviewDateCreation);
		objectOutput.writeLong(myReviewDateModification);
		objectOutput.writeLong(myReviewArticleId);

		if (MyReviewName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MyReviewName);
		}

		if (MyReviewContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(MyReviewContent);
		}
	}

	public String uuid;
	public long myReviewId;
	public long myReviewDateCreation;
	public long myReviewDateModification;
	public long myReviewArticleId;
	public String MyReviewName;
	public String MyReviewContent;
}