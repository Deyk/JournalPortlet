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

import com.softwerke.srv.model.Article;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author Sasha
 * @see Article
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", articleName=");
		sb.append(articleName);
		sb.append(", articleContent=");
		sb.append(articleContent);
		sb.append(", articleRefuseComment=");
		sb.append(articleRefuseComment);
		sb.append(", articleStatus=");
		sb.append(articleStatus);
		sb.append(", isArticlePublished=");
		sb.append(isArticlePublished);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Article toEntityModel() {
		ArticleImpl articleImpl = new ArticleImpl();

		if (uuid == null) {
			articleImpl.setUuid(StringPool.BLANK);
		}
		else {
			articleImpl.setUuid(uuid);
		}

		articleImpl.setArticleId(articleId);
		articleImpl.setGroupId(groupId);

		if (articleName == null) {
			articleImpl.setArticleName(StringPool.BLANK);
		}
		else {
			articleImpl.setArticleName(articleName);
		}

		if (articleContent == null) {
			articleImpl.setArticleContent(StringPool.BLANK);
		}
		else {
			articleImpl.setArticleContent(articleContent);
		}

		if (articleRefuseComment == null) {
			articleImpl.setArticleRefuseComment(StringPool.BLANK);
		}
		else {
			articleImpl.setArticleRefuseComment(articleRefuseComment);
		}

		articleImpl.setArticleStatus(articleStatus);
		articleImpl.setIsArticlePublished(isArticlePublished);
		articleImpl.setUserId(userId);

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		articleId = objectInput.readLong();
		groupId = objectInput.readLong();
		articleName = objectInput.readUTF();
		articleContent = objectInput.readUTF();
		articleRefuseComment = objectInput.readUTF();
		articleStatus = objectInput.readInt();
		isArticlePublished = objectInput.readBoolean();
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

		objectOutput.writeLong(articleId);
		objectOutput.writeLong(groupId);

		if (articleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(articleName);
		}

		if (articleContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(articleContent);
		}

		if (articleRefuseComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(articleRefuseComment);
		}

		objectOutput.writeInt(articleStatus);
		objectOutput.writeBoolean(isArticlePublished);
		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long articleId;
	public long groupId;
	public String articleName;
	public String articleContent;
	public String articleRefuseComment;
	public int articleStatus;
	public boolean isArticlePublished;
	public long userId;
}