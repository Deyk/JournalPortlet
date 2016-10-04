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

import com.softwerke.srv.model.MyArticle;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MyArticle in entity cache.
 *
 * @author Sasha
 * @see MyArticle
 * @generated
 */
public class MyArticleCacheModel implements CacheModel<MyArticle>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", myArticleId=");
		sb.append(myArticleId);
		sb.append(", myArticleName=");
		sb.append(myArticleName);
		sb.append(", myArticleContent=");
		sb.append(myArticleContent);
		sb.append(", myArticleRefuseComment=");
		sb.append(myArticleRefuseComment);
		sb.append(", myArticleStatus=");
		sb.append(myArticleStatus);
		sb.append(", isMyArticlePublished=");
		sb.append(isMyArticlePublished);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MyArticle toEntityModel() {
		MyArticleImpl myArticleImpl = new MyArticleImpl();

		if (uuid == null) {
			myArticleImpl.setUuid(StringPool.BLANK);
		}
		else {
			myArticleImpl.setUuid(uuid);
		}

		myArticleImpl.setMyArticleId(myArticleId);

		if (myArticleName == null) {
			myArticleImpl.setMyArticleName(StringPool.BLANK);
		}
		else {
			myArticleImpl.setMyArticleName(myArticleName);
		}

		if (myArticleContent == null) {
			myArticleImpl.setMyArticleContent(StringPool.BLANK);
		}
		else {
			myArticleImpl.setMyArticleContent(myArticleContent);
		}

		if (myArticleRefuseComment == null) {
			myArticleImpl.setMyArticleRefuseComment(StringPool.BLANK);
		}
		else {
			myArticleImpl.setMyArticleRefuseComment(myArticleRefuseComment);
		}

		myArticleImpl.setMyArticleStatus(myArticleStatus);
		myArticleImpl.setIsMyArticlePublished(isMyArticlePublished);

		myArticleImpl.resetOriginalValues();

		return myArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		myArticleId = objectInput.readLong();
		myArticleName = objectInput.readUTF();
		myArticleContent = objectInput.readUTF();
		myArticleRefuseComment = objectInput.readUTF();
		myArticleStatus = objectInput.readInt();
		isMyArticlePublished = objectInput.readBoolean();
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

		objectOutput.writeLong(myArticleId);

		if (myArticleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(myArticleName);
		}

		if (myArticleContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(myArticleContent);
		}

		if (myArticleRefuseComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(myArticleRefuseComment);
		}

		objectOutput.writeInt(myArticleStatus);
		objectOutput.writeBoolean(isMyArticlePublished);
	}

	public String uuid;
	public long myArticleId;
	public String myArticleName;
	public String myArticleContent;
	public String myArticleRefuseComment;
	public int myArticleStatus;
	public boolean isMyArticlePublished;
}