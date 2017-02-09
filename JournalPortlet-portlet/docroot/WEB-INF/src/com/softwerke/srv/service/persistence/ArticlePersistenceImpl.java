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

package com.softwerke.srv.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.softwerke.srv.NoSuchArticleException;
import com.softwerke.srv.model.Article;
import com.softwerke.srv.model.impl.ArticleImpl;
import com.softwerke.srv.model.impl.ArticleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see ArticlePersistence
 * @see ArticleUtil
 * @generated
 */
public class ArticlePersistenceImpl extends BasePersistenceImpl<Article>
	implements ArticlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ArticleModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Article article : list) {
				if (!Validator.equals(uuid, article.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByUuid_First(uuid, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Article> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByUuid_Last(uuid, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article[] findByUuid_PrevAndNext(long articleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByUuid_PrevAndNext(session, article, uuid,
					orderByComparator, true);

			array[1] = article;

			array[2] = getByUuid_PrevAndNext(session, article, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByUuid_PrevAndNext(Session session, Article article,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(article);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Article article : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "article.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "article.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(article.uuid IS NULL OR article.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ArticleModelImpl.UUID_COLUMN_BITMASK |
			ArticleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or throws a {@link com.softwerke.srv.NoSuchArticleException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByUUID_G(uuid, groupId);

		if (article == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return article;
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if (!Validator.equals(uuid, article.getUuid()) ||
					(groupId != article.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Article> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Article article = list.get(0);

					result = article;

					cacheResult(article);

					if ((article.getUuid() == null) ||
							!article.getUuid().equals(uuid) ||
							(article.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, article);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException, SystemException {
		Article article = findByUUID_G(uuid, groupId);

		return remove(article);
	}

	/**
	 * Returns the number of articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "article.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "article.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(article.uuid IS NULL OR article.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "article.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLESTATUS =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLESTATUS =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleStatus",
			new String[] { Integer.class.getName() },
			ArticleModelImpl.ARTICLESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLESTATUS = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the articles where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @return the matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleStatus(int articleStatus)
		throws SystemException {
		return findByArticleStatus(articleStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where articleStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleStatus the article status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleStatus(int articleStatus, int start,
		int end) throws SystemException {
		return findByArticleStatus(articleStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where articleStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleStatus the article status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleStatus(int articleStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLESTATUS;
			finderArgs = new Object[] { articleStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLESTATUS;
			finderArgs = new Object[] {
					articleStatus,
					
					start, end, orderByComparator
				};
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Article article : list) {
				if ((articleStatus != article.getArticleStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLESTATUS_ARTICLESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleStatus);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first article in the ordered set where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByArticleStatus_First(int articleStatus,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByArticleStatus_First(articleStatus,
				orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleStatus=");
		msg.append(articleStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByArticleStatus_First(int articleStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Article> list = findByArticleStatus(articleStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByArticleStatus_Last(int articleStatus,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByArticleStatus_Last(articleStatus,
				orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleStatus=");
		msg.append(articleStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByArticleStatus_Last(int articleStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArticleStatus(articleStatus);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByArticleStatus(articleStatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where articleStatus = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param articleStatus the article status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article[] findByArticleStatus_PrevAndNext(long articleId,
		int articleStatus, OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByArticleStatus_PrevAndNext(session, article,
					articleStatus, orderByComparator, true);

			array[1] = article;

			array[2] = getByArticleStatus_PrevAndNext(session, article,
					articleStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByArticleStatus_PrevAndNext(Session session,
		Article article, int articleStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_ARTICLESTATUS_ARTICLESTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(articleStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(article);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where articleStatus = &#63; from the database.
	 *
	 * @param articleStatus the article status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArticleStatus(int articleStatus)
		throws SystemException {
		for (Article article : findByArticleStatus(articleStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles where articleStatus = &#63;.
	 *
	 * @param articleStatus the article status
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleStatus(int articleStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLESTATUS;

		Object[] finderArgs = new Object[] { articleStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLESTATUS_ARTICLESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleStatus);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ARTICLESTATUS_ARTICLESTATUS_2 = "article.articleStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISARTICLEPUBLISHED =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsArticlePublished",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARTICLEPUBLISHED =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIsArticlePublished",
			new String[] { Boolean.class.getName() },
			ArticleModelImpl.ISARTICLEPUBLISHED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISARTICLEPUBLISHED = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsArticlePublished",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the articles where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @return the matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByIsArticlePublished(boolean isArticlePublished)
		throws SystemException {
		return findByIsArticlePublished(isArticlePublished, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where isArticlePublished = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isArticlePublished the is article published
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByIsArticlePublished(boolean isArticlePublished,
		int start, int end) throws SystemException {
		return findByIsArticlePublished(isArticlePublished, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where isArticlePublished = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isArticlePublished the is article published
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByIsArticlePublished(boolean isArticlePublished,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARTICLEPUBLISHED;
			finderArgs = new Object[] { isArticlePublished };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISARTICLEPUBLISHED;
			finderArgs = new Object[] {
					isArticlePublished,
					
					start, end, orderByComparator
				};
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Article article : list) {
				if ((isArticlePublished != article.getIsArticlePublished())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ISARTICLEPUBLISHED_ISARTICLEPUBLISHED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isArticlePublished);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first article in the ordered set where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByIsArticlePublished_First(boolean isArticlePublished,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByIsArticlePublished_First(isArticlePublished,
				orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isArticlePublished=");
		msg.append(isArticlePublished);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByIsArticlePublished_First(boolean isArticlePublished,
		OrderByComparator orderByComparator) throws SystemException {
		List<Article> list = findByIsArticlePublished(isArticlePublished, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByIsArticlePublished_Last(boolean isArticlePublished,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByIsArticlePublished_Last(isArticlePublished,
				orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isArticlePublished=");
		msg.append(isArticlePublished);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByIsArticlePublished_Last(boolean isArticlePublished,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsArticlePublished(isArticlePublished);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByIsArticlePublished(isArticlePublished,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where isArticlePublished = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param isArticlePublished the is article published
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article[] findByIsArticlePublished_PrevAndNext(long articleId,
		boolean isArticlePublished, OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByIsArticlePublished_PrevAndNext(session, article,
					isArticlePublished, orderByComparator, true);

			array[1] = article;

			array[2] = getByIsArticlePublished_PrevAndNext(session, article,
					isArticlePublished, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByIsArticlePublished_PrevAndNext(Session session,
		Article article, boolean isArticlePublished,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_ISARTICLEPUBLISHED_ISARTICLEPUBLISHED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isArticlePublished);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(article);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where isArticlePublished = &#63; from the database.
	 *
	 * @param isArticlePublished the is article published
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsArticlePublished(boolean isArticlePublished)
		throws SystemException {
		for (Article article : findByIsArticlePublished(isArticlePublished,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles where isArticlePublished = &#63;.
	 *
	 * @param isArticlePublished the is article published
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsArticlePublished(boolean isArticlePublished)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISARTICLEPUBLISHED;

		Object[] finderArgs = new Object[] { isArticlePublished };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ISARTICLEPUBLISHED_ISARTICLEPUBLISHED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isArticlePublished);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISARTICLEPUBLISHED_ISARTICLEPUBLISHED_2 =
		"article.isArticlePublished = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEUSERID =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEUSERID =
		new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleUserId",
			new String[] { Long.class.getName() },
			ArticleModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEUSERID = new FinderPath(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the articles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleUserId(long userId)
		throws SystemException {
		return findByArticleUserId(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleUserId(long userId, int start, int end)
		throws SystemException {
		return findByArticleUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findByArticleUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Article article : list) {
				if ((userId != article.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first article in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByArticleUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByArticleUserId_First(userId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByArticleUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Article> list = findByArticleUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByArticleUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByArticleUserId_Last(userId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByArticleUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArticleUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByArticleUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where userId = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article[] findByArticleUserId_PrevAndNext(long articleId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchArticleException, SystemException {
		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByArticleUserId_PrevAndNext(session, article, userId,
					orderByComparator, true);

			array[1] = article;

			array[2] = getByArticleUserId_PrevAndNext(session, article, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByArticleUserId_PrevAndNext(Session session,
		Article article, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_ARTICLEUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(article);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArticleUserId(long userId) throws SystemException {
		for (Article article : findByArticleUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ARTICLEUSERID_USERID_2 = "article.userId = ?";

	public ArticlePersistenceImpl() {
		setModelClass(Article.class);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	@Override
	public void cacheResult(Article article) {
		EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey(), article);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { article.getUuid(), article.getGroupId() }, article);

		article.resetOriginalValues();
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	@Override
	public void cacheResult(List<Article> articles) {
		for (Article article : articles) {
			if (EntityCacheUtil.getResult(
						ArticleModelImpl.ENTITY_CACHE_ENABLED,
						ArticleImpl.class, article.getPrimaryKey()) == null) {
				cacheResult(article);
			}
			else {
				article.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all articles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ArticleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ArticleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Article article) {
		EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(article);
	}

	@Override
	public void clearCache(List<Article> articles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Article article : articles) {
			EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
				ArticleImpl.class, article.getPrimaryKey());

			clearUniqueFindersCache(article);
		}
	}

	protected void cacheUniqueFindersCache(Article article) {
		if (article.isNew()) {
			Object[] args = new Object[] { article.getUuid(), article.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, article);
		}
		else {
			ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						article.getUuid(), article.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					article);
			}
		}
	}

	protected void clearUniqueFindersCache(Article article) {
		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		Object[] args = new Object[] { article.getUuid(), article.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((articleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					articleModelImpl.getOriginalUuid(),
					articleModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article create(long articleId) {
		Article article = new ArticleImpl();

		article.setNew(true);
		article.setPrimaryKey(articleId);

		String uuid = PortalUUIDUtil.generate();

		article.setUuid(uuid);

		return article;
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article remove(long articleId)
		throws NoSuchArticleException, SystemException {
		return remove((Serializable)articleId);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article that was removed
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article remove(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Article article = (Article)session.get(ArticleImpl.class, primaryKey);

			if (article == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(article);
		}
		catch (NoSuchArticleException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Article removeImpl(Article article) throws SystemException {
		article = toUnwrappedModel(article);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(article)) {
				article = (Article)session.get(ArticleImpl.class,
						article.getPrimaryKeyObj());
			}

			if (article != null) {
				session.delete(article);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (article != null) {
			clearCache(article);
		}

		return article;
	}

	@Override
	public Article updateImpl(com.softwerke.srv.model.Article article)
		throws SystemException {
		article = toUnwrappedModel(article);

		boolean isNew = article.isNew();

		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		if (Validator.isNull(article.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			article.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (article.isNew()) {
				session.save(article);

				article.setNew(false);
			}
			else {
				session.merge(article);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ArticleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { articleModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { articleModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						articleModelImpl.getOriginalArticleStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLESTATUS,
					args);

				args = new Object[] { articleModelImpl.getArticleStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLESTATUS,
					args);
			}

			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARTICLEPUBLISHED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						articleModelImpl.getOriginalIsArticlePublished()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARTICLEPUBLISHED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARTICLEPUBLISHED,
					args);

				args = new Object[] { articleModelImpl.getIsArticlePublished() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISARTICLEPUBLISHED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISARTICLEPUBLISHED,
					args);
			}

			if ((articleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						articleModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEUSERID,
					args);

				args = new Object[] { articleModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
			ArticleImpl.class, article.getPrimaryKey(), article);

		clearUniqueFindersCache(article);
		cacheUniqueFindersCache(article);

		return article;
	}

	protected Article toUnwrappedModel(Article article) {
		if (article instanceof ArticleImpl) {
			return article;
		}

		ArticleImpl articleImpl = new ArticleImpl();

		articleImpl.setNew(article.isNew());
		articleImpl.setPrimaryKey(article.getPrimaryKey());

		articleImpl.setUuid(article.getUuid());
		articleImpl.setArticleId(article.getArticleId());
		articleImpl.setGroupId(article.getGroupId());
		articleImpl.setArticleName(article.getArticleName());
		articleImpl.setArticleContent(article.getArticleContent());
		articleImpl.setArticleRefuseComment(article.getArticleRefuseComment());
		articleImpl.setArticleStatus(article.getArticleStatus());
		articleImpl.setIsArticlePublished(article.isIsArticlePublished());
		articleImpl.setUserId(article.getUserId());

		return articleImpl;
	}

	/**
	 * Returns the article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException, SystemException {
		Article article = fetchByPrimaryKey(primaryKey);

		if (article == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a {@link com.softwerke.srv.NoSuchArticleException} if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException, SystemException {
		return findByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Article article = (Article)EntityCacheUtil.getResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
				ArticleImpl.class, primaryKey);

		if (article == _nullArticle) {
			return null;
		}

		if (article == null) {
			Session session = null;

			try {
				session = openSession();

				article = (Article)session.get(ArticleImpl.class, primaryKey);

				if (article != null) {
					cacheResult(article);
				}
				else {
					EntityCacheUtil.putResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
						ArticleImpl.class, primaryKey, _nullArticle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ArticleModelImpl.ENTITY_CACHE_ENABLED,
					ArticleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchByPrimaryKey(long articleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Article> list = (List<Article>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ARTICLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLE;

				if (pagination) {
					sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Article>(list);
				}
				else {
					list = (List<Article>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the articles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Article article : findAll()) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the article persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.softwerke.srv.model.Article")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Article>> listenersList = new ArrayList<ModelListener<Article>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Article>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ArticleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ARTICLE = "SELECT article FROM Article article";
	private static final String _SQL_SELECT_ARTICLE_WHERE = "SELECT article FROM Article article WHERE ";
	private static final String _SQL_COUNT_ARTICLE = "SELECT COUNT(article) FROM Article article";
	private static final String _SQL_COUNT_ARTICLE_WHERE = "SELECT COUNT(article) FROM Article article WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "article.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Article exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Article exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ArticlePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Article _nullArticle = new ArticleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Article> toCacheModel() {
				return _nullArticleCacheModel;
			}
		};

	private static CacheModel<Article> _nullArticleCacheModel = new CacheModel<Article>() {
			@Override
			public Article toEntityModel() {
				return _nullArticle;
			}
		};
}