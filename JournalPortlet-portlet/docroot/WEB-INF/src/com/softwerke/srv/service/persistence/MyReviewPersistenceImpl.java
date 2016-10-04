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

import com.softwerke.srv.NoSuchMyReviewException;
import com.softwerke.srv.model.MyReview;
import com.softwerke.srv.model.impl.MyReviewImpl;
import com.softwerke.srv.model.impl.MyReviewModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the my review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see MyReviewPersistence
 * @see MyReviewUtil
 * @generated
 */
public class MyReviewPersistenceImpl extends BasePersistenceImpl<MyReview>
	implements MyReviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MyReviewUtil} to access the my review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MyReviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, MyReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, MyReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, MyReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, MyReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MyReviewModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the my reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my reviews
	 * @param end the upper bound of the range of my reviews (not inclusive)
	 * @return the range of matching my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the my reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of my reviews
	 * @param end the upper bound of the range of my reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findByUuid(String uuid, int start, int end,
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

		List<MyReview> list = (List<MyReview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MyReview myReview : list) {
				if (!Validator.equals(uuid, myReview.getUuid())) {
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

			query.append(_SQL_SELECT_MYREVIEW_WHERE);

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
				query.append(MyReviewModelImpl.ORDER_BY_JPQL);
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
					list = (List<MyReview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyReview>(list);
				}
				else {
					list = (List<MyReview>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first my review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my review
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a matching my review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyReviewException, SystemException {
		MyReview myReview = fetchByUuid_First(uuid, orderByComparator);

		if (myReview != null) {
			return myReview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMyReviewException(msg.toString());
	}

	/**
	 * Returns the first my review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching my review, or <code>null</code> if a matching my review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<MyReview> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last my review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my review
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a matching my review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyReviewException, SystemException {
		MyReview myReview = fetchByUuid_Last(uuid, orderByComparator);

		if (myReview != null) {
			return myReview;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMyReviewException(msg.toString());
	}

	/**
	 * Returns the last my review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching my review, or <code>null</code> if a matching my review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MyReview> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the my reviews before and after the current my review in the ordered set where uuid = &#63;.
	 *
	 * @param myReviewId the primary key of the current my review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next my review
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview[] findByUuid_PrevAndNext(long myReviewId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchMyReviewException, SystemException {
		MyReview myReview = findByPrimaryKey(myReviewId);

		Session session = null;

		try {
			session = openSession();

			MyReview[] array = new MyReviewImpl[3];

			array[0] = getByUuid_PrevAndNext(session, myReview, uuid,
					orderByComparator, true);

			array[1] = myReview;

			array[2] = getByUuid_PrevAndNext(session, myReview, uuid,
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

	protected MyReview getByUuid_PrevAndNext(Session session,
		MyReview myReview, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MYREVIEW_WHERE);

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
			query.append(MyReviewModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(myReview);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MyReview> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the my reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (MyReview myReview : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(myReview);
		}
	}

	/**
	 * Returns the number of my reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching my reviews
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

			query.append(_SQL_COUNT_MYREVIEW_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "myReview.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "myReview.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(myReview.uuid IS NULL OR myReview.uuid = '')";

	public MyReviewPersistenceImpl() {
		setModelClass(MyReview.class);
	}

	/**
	 * Caches the my review in the entity cache if it is enabled.
	 *
	 * @param myReview the my review
	 */
	@Override
	public void cacheResult(MyReview myReview) {
		EntityCacheUtil.putResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewImpl.class, myReview.getPrimaryKey(), myReview);

		myReview.resetOriginalValues();
	}

	/**
	 * Caches the my reviews in the entity cache if it is enabled.
	 *
	 * @param myReviews the my reviews
	 */
	@Override
	public void cacheResult(List<MyReview> myReviews) {
		for (MyReview myReview : myReviews) {
			if (EntityCacheUtil.getResult(
						MyReviewModelImpl.ENTITY_CACHE_ENABLED,
						MyReviewImpl.class, myReview.getPrimaryKey()) == null) {
				cacheResult(myReview);
			}
			else {
				myReview.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all my reviews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MyReviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MyReviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the my review.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyReview myReview) {
		EntityCacheUtil.removeResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewImpl.class, myReview.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MyReview> myReviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MyReview myReview : myReviews) {
			EntityCacheUtil.removeResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
				MyReviewImpl.class, myReview.getPrimaryKey());
		}
	}

	/**
	 * Creates a new my review with the primary key. Does not add the my review to the database.
	 *
	 * @param myReviewId the primary key for the new my review
	 * @return the new my review
	 */
	@Override
	public MyReview create(long myReviewId) {
		MyReview myReview = new MyReviewImpl();

		myReview.setNew(true);
		myReview.setPrimaryKey(myReviewId);

		String uuid = PortalUUIDUtil.generate();

		myReview.setUuid(uuid);

		return myReview;
	}

	/**
	 * Removes the my review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myReviewId the primary key of the my review
	 * @return the my review that was removed
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview remove(long myReviewId)
		throws NoSuchMyReviewException, SystemException {
		return remove((Serializable)myReviewId);
	}

	/**
	 * Removes the my review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my review
	 * @return the my review that was removed
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview remove(Serializable primaryKey)
		throws NoSuchMyReviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyReview myReview = (MyReview)session.get(MyReviewImpl.class,
					primaryKey);

			if (myReview == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(myReview);
		}
		catch (NoSuchMyReviewException nsee) {
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
	protected MyReview removeImpl(MyReview myReview) throws SystemException {
		myReview = toUnwrappedModel(myReview);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myReview)) {
				myReview = (MyReview)session.get(MyReviewImpl.class,
						myReview.getPrimaryKeyObj());
			}

			if (myReview != null) {
				session.delete(myReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (myReview != null) {
			clearCache(myReview);
		}

		return myReview;
	}

	@Override
	public MyReview updateImpl(com.softwerke.srv.model.MyReview myReview)
		throws SystemException {
		myReview = toUnwrappedModel(myReview);

		boolean isNew = myReview.isNew();

		MyReviewModelImpl myReviewModelImpl = (MyReviewModelImpl)myReview;

		if (Validator.isNull(myReview.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			myReview.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (myReview.isNew()) {
				session.save(myReview);

				myReview.setNew(false);
			}
			else {
				session.merge(myReview);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MyReviewModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((myReviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { myReviewModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { myReviewModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
			MyReviewImpl.class, myReview.getPrimaryKey(), myReview);

		return myReview;
	}

	protected MyReview toUnwrappedModel(MyReview myReview) {
		if (myReview instanceof MyReviewImpl) {
			return myReview;
		}

		MyReviewImpl myReviewImpl = new MyReviewImpl();

		myReviewImpl.setNew(myReview.isNew());
		myReviewImpl.setPrimaryKey(myReview.getPrimaryKey());

		myReviewImpl.setUuid(myReview.getUuid());
		myReviewImpl.setMyReviewId(myReview.getMyReviewId());
		myReviewImpl.setMyReviewDateCreation(myReview.getMyReviewDateCreation());
		myReviewImpl.setMyReviewDateModification(myReview.getMyReviewDateModification());
		myReviewImpl.setMyReviewArticleId(myReview.getMyReviewArticleId());
		myReviewImpl.setMyReviewName(myReview.getMyReviewName());
		myReviewImpl.setMyReviewContent(myReview.getMyReviewContent());

		return myReviewImpl;
	}

	/**
	 * Returns the my review with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my review
	 * @return the my review
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyReviewException, SystemException {
		MyReview myReview = fetchByPrimaryKey(primaryKey);

		if (myReview == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return myReview;
	}

	/**
	 * Returns the my review with the primary key or throws a {@link com.softwerke.srv.NoSuchMyReviewException} if it could not be found.
	 *
	 * @param myReviewId the primary key of the my review
	 * @return the my review
	 * @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview findByPrimaryKey(long myReviewId)
		throws NoSuchMyReviewException, SystemException {
		return findByPrimaryKey((Serializable)myReviewId);
	}

	/**
	 * Returns the my review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my review
	 * @return the my review, or <code>null</code> if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MyReview myReview = (MyReview)EntityCacheUtil.getResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
				MyReviewImpl.class, primaryKey);

		if (myReview == _nullMyReview) {
			return null;
		}

		if (myReview == null) {
			Session session = null;

			try {
				session = openSession();

				myReview = (MyReview)session.get(MyReviewImpl.class, primaryKey);

				if (myReview != null) {
					cacheResult(myReview);
				}
				else {
					EntityCacheUtil.putResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
						MyReviewImpl.class, primaryKey, _nullMyReview);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MyReviewModelImpl.ENTITY_CACHE_ENABLED,
					MyReviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return myReview;
	}

	/**
	 * Returns the my review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myReviewId the primary key of the my review
	 * @return the my review, or <code>null</code> if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyReview fetchByPrimaryKey(long myReviewId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)myReviewId);
	}

	/**
	 * Returns all the my reviews.
	 *
	 * @return the my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my reviews
	 * @param end the upper bound of the range of my reviews (not inclusive)
	 * @return the range of my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the my reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of my reviews
	 * @param end the upper bound of the range of my reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyReview> findAll(int start, int end,
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

		List<MyReview> list = (List<MyReview>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYREVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYREVIEW;

				if (pagination) {
					sql = sql.concat(MyReviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MyReview>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyReview>(list);
				}
				else {
					list = (List<MyReview>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the my reviews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MyReview myReview : findAll()) {
			remove(myReview);
		}
	}

	/**
	 * Returns the number of my reviews.
	 *
	 * @return the number of my reviews
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

				Query q = session.createQuery(_SQL_COUNT_MYREVIEW);

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
	 * Initializes the my review persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.softwerke.srv.model.MyReview")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyReview>> listenersList = new ArrayList<ModelListener<MyReview>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyReview>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyReviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MYREVIEW = "SELECT myReview FROM MyReview myReview";
	private static final String _SQL_SELECT_MYREVIEW_WHERE = "SELECT myReview FROM MyReview myReview WHERE ";
	private static final String _SQL_COUNT_MYREVIEW = "SELECT COUNT(myReview) FROM MyReview myReview";
	private static final String _SQL_COUNT_MYREVIEW_WHERE = "SELECT COUNT(myReview) FROM MyReview myReview WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myReview.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyReview exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MyReview exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MyReviewPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static MyReview _nullMyReview = new MyReviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MyReview> toCacheModel() {
				return _nullMyReviewCacheModel;
			}
		};

	private static CacheModel<MyReview> _nullMyReviewCacheModel = new CacheModel<MyReview>() {
			@Override
			public MyReview toEntityModel() {
				return _nullMyReview;
			}
		};
}