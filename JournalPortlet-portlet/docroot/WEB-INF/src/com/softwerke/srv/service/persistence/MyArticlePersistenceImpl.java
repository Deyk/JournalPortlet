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

import com.softwerke.srv.NoSuchMyArticleException;
import com.softwerke.srv.model.MyArticle;
import com.softwerke.srv.model.impl.MyArticleImpl;
import com.softwerke.srv.model.impl.MyArticleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the my article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see MyArticlePersistence
 * @see MyArticleUtil
 * @generated
 */
public class MyArticlePersistenceImpl extends BasePersistenceImpl<MyArticle>
	implements MyArticlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MyArticleUtil} to access the my article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MyArticleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, MyArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, MyArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, MyArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, MyArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MyArticleModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the my articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my articles
	 * @param end the upper bound of the range of my articles (not inclusive)
	 * @return the range of matching my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the my articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my articles
	 * @param end the upper bound of the range of my articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findByUuid(String uuid, int start, int end,
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

		List<MyArticle> list = (List<MyArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MyArticle myArticle : list) {
				if (!Validator.equals(uuid, myArticle.getUuid())) {
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

			query.append(_SQL_SELECT_MYARTICLE_WHERE);

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
				query.append(MyArticleModelImpl.ORDER_BY_JPQL);
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
					list = (List<MyArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyArticle>(list);
				}
				else {
					list = (List<MyArticle>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first my article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my article
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a matching my article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyArticleException, SystemException {
		MyArticle myArticle = fetchByUuid_First(uuid, orderByComparator);

		if (myArticle != null) {
			return myArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMyArticleException(msg.toString());
	}

	/**
	 * Returns the first my article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my article, or <code>null</code> if a matching my article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<MyArticle> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last my article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my article
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a matching my article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyArticleException, SystemException {
		MyArticle myArticle = fetchByUuid_Last(uuid, orderByComparator);

		if (myArticle != null) {
			return myArticle;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMyArticleException(msg.toString());
	}

	/**
	 * Returns the last my article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my article, or <code>null</code> if a matching my article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MyArticle> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the my articles before and after the current my article in the ordered set where uuid = &#63;.
	 *
	 * @param myArticleId the primary key of the current my article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my article
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle[] findByUuid_PrevAndNext(long myArticleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyArticleException, SystemException {
		MyArticle myArticle = findByPrimaryKey(myArticleId);

		Session session = null;

		try {
			session = openSession();

			MyArticle[] array = new MyArticleImpl[3];

			array[0] = getByUuid_PrevAndNext(session, myArticle, uuid,
					orderByComparator, true);

			array[1] = myArticle;

			array[2] = getByUuid_PrevAndNext(session, myArticle, uuid,
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

	protected MyArticle getByUuid_PrevAndNext(Session session,
		MyArticle myArticle, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MYARTICLE_WHERE);

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
			query.append(MyArticleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(myArticle);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MyArticle> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the my articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (MyArticle myArticle : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(myArticle);
		}
	}

	/**
	 * Returns the number of my articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching my articles
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

			query.append(_SQL_COUNT_MYARTICLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "myArticle.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "myArticle.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(myArticle.uuid IS NULL OR myArticle.uuid = '')";

	public MyArticlePersistenceImpl() {
		setModelClass(MyArticle.class);
	}

	/**
	 * Caches the my article in the entity cache if it is enabled.
	 *
	 * @param myArticle the my article
	 */
	@Override
	public void cacheResult(MyArticle myArticle) {
		EntityCacheUtil.putResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleImpl.class, myArticle.getPrimaryKey(), myArticle);

		myArticle.resetOriginalValues();
	}

	/**
	 * Caches the my articles in the entity cache if it is enabled.
	 *
	 * @param myArticles the my articles
	 */
	@Override
	public void cacheResult(List<MyArticle> myArticles) {
		for (MyArticle myArticle : myArticles) {
			if (EntityCacheUtil.getResult(
						MyArticleModelImpl.ENTITY_CACHE_ENABLED,
						MyArticleImpl.class, myArticle.getPrimaryKey()) == null) {
				cacheResult(myArticle);
			}
			else {
				myArticle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all my articles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MyArticleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MyArticleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the my article.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyArticle myArticle) {
		EntityCacheUtil.removeResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleImpl.class, myArticle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MyArticle> myArticles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MyArticle myArticle : myArticles) {
			EntityCacheUtil.removeResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
				MyArticleImpl.class, myArticle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new my article with the primary key. Does not add the my article to the database.
	 *
	 * @param myArticleId the primary key for the new my article
	 * @return the new my article
	 */
	@Override
	public MyArticle create(long myArticleId) {
		MyArticle myArticle = new MyArticleImpl();

		myArticle.setNew(true);
		myArticle.setPrimaryKey(myArticleId);

		String uuid = PortalUUIDUtil.generate();

		myArticle.setUuid(uuid);

		return myArticle;
	}

	/**
	 * Removes the my article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myArticleId the primary key of the my article
	 * @return the my article that was removed
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle remove(long myArticleId)
		throws NoSuchMyArticleException, SystemException {
		return remove((Serializable)myArticleId);
	}

	/**
	 * Removes the my article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my article
	 * @return the my article that was removed
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle remove(Serializable primaryKey)
		throws NoSuchMyArticleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyArticle myArticle = (MyArticle)session.get(MyArticleImpl.class,
					primaryKey);

			if (myArticle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(myArticle);
		}
		catch (NoSuchMyArticleException nsee) {
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
	protected MyArticle removeImpl(MyArticle myArticle)
		throws SystemException {
		myArticle = toUnwrappedModel(myArticle);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myArticle)) {
				myArticle = (MyArticle)session.get(MyArticleImpl.class,
						myArticle.getPrimaryKeyObj());
			}

			if (myArticle != null) {
				session.delete(myArticle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (myArticle != null) {
			clearCache(myArticle);
		}

		return myArticle;
	}

	@Override
	public MyArticle updateImpl(com.softwerke.srv.model.MyArticle myArticle)
		throws SystemException {
		myArticle = toUnwrappedModel(myArticle);

		boolean isNew = myArticle.isNew();

		MyArticleModelImpl myArticleModelImpl = (MyArticleModelImpl)myArticle;

		if (Validator.isNull(myArticle.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			myArticle.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (myArticle.isNew()) {
				session.save(myArticle);

				myArticle.setNew(false);
			}
			else {
				session.merge(myArticle);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MyArticleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((myArticleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						myArticleModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { myArticleModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
			MyArticleImpl.class, myArticle.getPrimaryKey(), myArticle);

		return myArticle;
	}

	protected MyArticle toUnwrappedModel(MyArticle myArticle) {
		if (myArticle instanceof MyArticleImpl) {
			return myArticle;
		}

		MyArticleImpl myArticleImpl = new MyArticleImpl();

		myArticleImpl.setNew(myArticle.isNew());
		myArticleImpl.setPrimaryKey(myArticle.getPrimaryKey());

		myArticleImpl.setUuid(myArticle.getUuid());
		myArticleImpl.setMyArticleId(myArticle.getMyArticleId());
		myArticleImpl.setMyArticleName(myArticle.getMyArticleName());
		myArticleImpl.setMyArticleContent(myArticle.getMyArticleContent());
		myArticleImpl.setMyArticleRefuseComment(myArticle.getMyArticleRefuseComment());
		myArticleImpl.setMyArticleStatus(myArticle.getMyArticleStatus());
		myArticleImpl.setIsMyArticlePublished(myArticle.isIsMyArticlePublished());

		return myArticleImpl;
	}

	/**
	 * Returns the my article with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my article
	 * @return the my article
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyArticleException, SystemException {
		MyArticle myArticle = fetchByPrimaryKey(primaryKey);

		if (myArticle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyArticleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return myArticle;
	}

	/**
	 * Returns the my article with the primary key or throws a {@link com.softwerke.srv.NoSuchMyArticleException} if it could not be found.
	 *
	 * @param myArticleId the primary key of the my article
	 * @return the my article
	 * @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle findByPrimaryKey(long myArticleId)
		throws NoSuchMyArticleException, SystemException {
		return findByPrimaryKey((Serializable)myArticleId);
	}

	/**
	 * Returns the my article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my article
	 * @return the my article, or <code>null</code> if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MyArticle myArticle = (MyArticle)EntityCacheUtil.getResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
				MyArticleImpl.class, primaryKey);

		if (myArticle == _nullMyArticle) {
			return null;
		}

		if (myArticle == null) {
			Session session = null;

			try {
				session = openSession();

				myArticle = (MyArticle)session.get(MyArticleImpl.class,
						primaryKey);

				if (myArticle != null) {
					cacheResult(myArticle);
				}
				else {
					EntityCacheUtil.putResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
						MyArticleImpl.class, primaryKey, _nullMyArticle);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MyArticleModelImpl.ENTITY_CACHE_ENABLED,
					MyArticleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return myArticle;
	}

	/**
	 * Returns the my article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myArticleId the primary key of the my article
	 * @return the my article, or <code>null</code> if a my article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyArticle fetchByPrimaryKey(long myArticleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)myArticleId);
	}

	/**
	 * Returns all the my articles.
	 *
	 * @return the my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my articles
	 * @param end the upper bound of the range of my articles (not inclusive)
	 * @return the range of my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the my articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my articles
	 * @param end the upper bound of the range of my articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyArticle> findAll(int start, int end,
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

		List<MyArticle> list = (List<MyArticle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYARTICLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYARTICLE;

				if (pagination) {
					sql = sql.concat(MyArticleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MyArticle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyArticle>(list);
				}
				else {
					list = (List<MyArticle>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the my articles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MyArticle myArticle : findAll()) {
			remove(myArticle);
		}
	}

	/**
	 * Returns the number of my articles.
	 *
	 * @return the number of my articles
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

				Query q = session.createQuery(_SQL_COUNT_MYARTICLE);

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
	 * Initializes the my article persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.softwerke.srv.model.MyArticle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyArticle>> listenersList = new ArrayList<ModelListener<MyArticle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyArticle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyArticleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MYARTICLE = "SELECT myArticle FROM MyArticle myArticle";
	private static final String _SQL_SELECT_MYARTICLE_WHERE = "SELECT myArticle FROM MyArticle myArticle WHERE ";
	private static final String _SQL_COUNT_MYARTICLE = "SELECT COUNT(myArticle) FROM MyArticle myArticle";
	private static final String _SQL_COUNT_MYARTICLE_WHERE = "SELECT COUNT(myArticle) FROM MyArticle myArticle WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myArticle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyArticle exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MyArticle exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MyArticlePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static MyArticle _nullMyArticle = new MyArticleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MyArticle> toCacheModel() {
				return _nullMyArticleCacheModel;
			}
		};

	private static CacheModel<MyArticle> _nullMyArticleCacheModel = new CacheModel<MyArticle>() {
			@Override
			public MyArticle toEntityModel() {
				return _nullMyArticle;
			}
		};
}