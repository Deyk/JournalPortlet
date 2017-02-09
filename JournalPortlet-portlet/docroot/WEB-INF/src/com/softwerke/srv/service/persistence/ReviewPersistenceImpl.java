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

import com.softwerke.srv.NoSuchReviewException;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.model.impl.ReviewImpl;
import com.softwerke.srv.model.impl.ReviewModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see ReviewPersistence
 * @see ReviewUtil
 * @generated
 */
public class ReviewPersistenceImpl extends BasePersistenceImpl<Review>
	implements ReviewPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReviewUtil} to access the review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReviewImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ReviewModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @return the range of matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByUuid(String uuid, int start, int end,
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

		List<Review> list = (List<Review>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Review review : list) {
				if (!Validator.equals(uuid, review.getUuid())) {
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

			query.append(_SQL_SELECT_REVIEW_WHERE);

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
				query.append(ReviewModelImpl.ORDER_BY_JPQL);
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
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Review>(list);
				}
				else {
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching review
	 * @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByUuid_First(uuid, orderByComparator);

		if (review != null) {
			return review;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReviewException(msg.toString());
	}

	/**
	 * Returns the first review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Review> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching review
	 * @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByUuid_Last(uuid, orderByComparator);

		if (review != null) {
			return review;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReviewException(msg.toString());
	}

	/**
	 * Returns the last review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Review> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reviews before and after the current review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next review
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review[] findByUuid_PrevAndNext(long reviewId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			Review[] array = new ReviewImpl[3];

			array[0] = getByUuid_PrevAndNext(session, review, uuid,
					orderByComparator, true);

			array[1] = review;

			array[2] = getByUuid_PrevAndNext(session, review, uuid,
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

	protected Review getByUuid_PrevAndNext(Session session, Review review,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REVIEW_WHERE);

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
			query.append(ReviewModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(review);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Review> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Review review : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(review);
		}
	}

	/**
	 * Returns the number of reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching reviews
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

			query.append(_SQL_COUNT_REVIEW_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "review.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "review.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(review.uuid IS NULL OR review.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ReviewModelImpl.UUID_COLUMN_BITMASK |
			ReviewModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the review where uuid = &#63; and groupId = &#63; or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching review
	 * @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByUUID_G(String uuid, long groupId)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByUUID_G(uuid, groupId);

		if (review == null) {
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

			throw new NoSuchReviewException(msg.toString());
		}

		return review;
	}

	/**
	 * Returns the review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Review) {
			Review review = (Review)result;

			if (!Validator.equals(uuid, review.getUuid()) ||
					(groupId != review.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_REVIEW_WHERE);

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

				List<Review> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Review review = list.get(0);

					result = review;

					cacheResult(review);

					if ((review.getUuid() == null) ||
							!review.getUuid().equals(uuid) ||
							(review.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, review);
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
			return (Review)result;
		}
	}

	/**
	 * Removes the review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the review that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review removeByUUID_G(String uuid, long groupId)
		throws NoSuchReviewException, SystemException {
		Review review = findByUUID_G(uuid, groupId);

		return remove(review);
	}

	/**
	 * Returns the number of reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching reviews
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

			query.append(_SQL_COUNT_REVIEW_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "review.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "review.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(review.uuid IS NULL OR review.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "review.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID =
		new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID =
		new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, ReviewImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleId",
			new String[] { Long.class.getName() },
			ReviewModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the reviews where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByArticleId(long articleId)
		throws SystemException {
		return findByArticleId(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the reviews where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @return the range of matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByArticleId(long articleId, int start, int end)
		throws SystemException {
		return findByArticleId(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the reviews where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findByArticleId(long articleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID;
			finderArgs = new Object[] { articleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID;
			finderArgs = new Object[] { articleId, start, end, orderByComparator };
		}

		List<Review> list = (List<Review>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Review review : list) {
				if ((articleId != review.getArticleId())) {
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

			query.append(_SQL_SELECT_REVIEW_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				if (!pagination) {
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Review>(list);
				}
				else {
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first review in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching review
	 * @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByArticleId_First(long articleId,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByArticleId_First(articleId, orderByComparator);

		if (review != null) {
			return review;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReviewException(msg.toString());
	}

	/**
	 * Returns the first review in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByArticleId_First(long articleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Review> list = findByArticleId(articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last review in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching review
	 * @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByArticleId_Last(long articleId,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByArticleId_Last(articleId, orderByComparator);

		if (review != null) {
			return review;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReviewException(msg.toString());
	}

	/**
	 * Returns the last review in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching review, or <code>null</code> if a matching review could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByArticleId_Last(long articleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArticleId(articleId);

		if (count == 0) {
			return null;
		}

		List<Review> list = findByArticleId(articleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the reviews before and after the current review in the ordered set where articleId = &#63;.
	 *
	 * @param reviewId the primary key of the current review
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next review
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review[] findByArticleId_PrevAndNext(long reviewId, long articleId,
		OrderByComparator orderByComparator)
		throws NoSuchReviewException, SystemException {
		Review review = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			Review[] array = new ReviewImpl[3];

			array[0] = getByArticleId_PrevAndNext(session, review, articleId,
					orderByComparator, true);

			array[1] = review;

			array[2] = getByArticleId_PrevAndNext(session, review, articleId,
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

	protected Review getByArticleId_PrevAndNext(Session session, Review review,
		long articleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REVIEW_WHERE);

		query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

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
			query.append(ReviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(articleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(review);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Review> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the reviews where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArticleId(long articleId) throws SystemException {
		for (Review review : findByArticleId(articleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(review);
		}
	}

	/**
	 * Returns the number of reviews where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArticleId(long articleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEID;

		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REVIEW_WHERE);

			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

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

	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_2 = "review.articleId = ?";

	public ReviewPersistenceImpl() {
		setModelClass(Review.class);
	}

	/**
	 * Caches the review in the entity cache if it is enabled.
	 *
	 * @param review the review
	 */
	@Override
	public void cacheResult(Review review) {
		EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewImpl.class, review.getPrimaryKey(), review);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { review.getUuid(), review.getGroupId() }, review);

		review.resetOriginalValues();
	}

	/**
	 * Caches the reviews in the entity cache if it is enabled.
	 *
	 * @param reviews the reviews
	 */
	@Override
	public void cacheResult(List<Review> reviews) {
		for (Review review : reviews) {
			if (EntityCacheUtil.getResult(
						ReviewModelImpl.ENTITY_CACHE_ENABLED, ReviewImpl.class,
						review.getPrimaryKey()) == null) {
				cacheResult(review);
			}
			else {
				review.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all reviews.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReviewImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReviewImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the review.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Review review) {
		EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewImpl.class, review.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(review);
	}

	@Override
	public void clearCache(List<Review> reviews) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Review review : reviews) {
			EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
				ReviewImpl.class, review.getPrimaryKey());

			clearUniqueFindersCache(review);
		}
	}

	protected void cacheUniqueFindersCache(Review review) {
		if (review.isNew()) {
			Object[] args = new Object[] { review.getUuid(), review.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, review);
		}
		else {
			ReviewModelImpl reviewModelImpl = (ReviewModelImpl)review;

			if ((reviewModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						review.getUuid(), review.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					review);
			}
		}
	}

	protected void clearUniqueFindersCache(Review review) {
		ReviewModelImpl reviewModelImpl = (ReviewModelImpl)review;

		Object[] args = new Object[] { review.getUuid(), review.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((reviewModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					reviewModelImpl.getOriginalUuid(),
					reviewModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new review with the primary key. Does not add the review to the database.
	 *
	 * @param reviewId the primary key for the new review
	 * @return the new review
	 */
	@Override
	public Review create(long reviewId) {
		Review review = new ReviewImpl();

		review.setNew(true);
		review.setPrimaryKey(reviewId);

		String uuid = PortalUUIDUtil.generate();

		review.setUuid(uuid);

		return review;
	}

	/**
	 * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the review
	 * @return the review that was removed
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review remove(long reviewId)
		throws NoSuchReviewException, SystemException {
		return remove((Serializable)reviewId);
	}

	/**
	 * Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the review
	 * @return the review that was removed
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review remove(Serializable primaryKey)
		throws NoSuchReviewException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Review review = (Review)session.get(ReviewImpl.class, primaryKey);

			if (review == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(review);
		}
		catch (NoSuchReviewException nsee) {
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
	protected Review removeImpl(Review review) throws SystemException {
		review = toUnwrappedModel(review);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(review)) {
				review = (Review)session.get(ReviewImpl.class,
						review.getPrimaryKeyObj());
			}

			if (review != null) {
				session.delete(review);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (review != null) {
			clearCache(review);
		}

		return review;
	}

	@Override
	public Review updateImpl(com.softwerke.srv.model.Review review)
		throws SystemException {
		review = toUnwrappedModel(review);

		boolean isNew = review.isNew();

		ReviewModelImpl reviewModelImpl = (ReviewModelImpl)review;

		if (Validator.isNull(review.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			review.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (review.isNew()) {
				session.save(review);

				review.setNew(false);
			}
			else {
				session.merge(review);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReviewModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { reviewModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { reviewModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((reviewModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reviewModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
					args);

				args = new Object[] { reviewModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
			ReviewImpl.class, review.getPrimaryKey(), review);

		clearUniqueFindersCache(review);
		cacheUniqueFindersCache(review);

		return review;
	}

	protected Review toUnwrappedModel(Review review) {
		if (review instanceof ReviewImpl) {
			return review;
		}

		ReviewImpl reviewImpl = new ReviewImpl();

		reviewImpl.setNew(review.isNew());
		reviewImpl.setPrimaryKey(review.getPrimaryKey());

		reviewImpl.setUuid(review.getUuid());
		reviewImpl.setReviewId(review.getReviewId());
		reviewImpl.setGroupId(review.getGroupId());
		reviewImpl.setReviewName(review.getReviewName());
		reviewImpl.setReviewContent(review.getReviewContent());
		reviewImpl.setArticleId(review.getArticleId());
		reviewImpl.setUserId(review.getUserId());

		return reviewImpl;
	}

	/**
	 * Returns the review with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the review
	 * @return the review
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReviewException, SystemException {
		Review review = fetchByPrimaryKey(primaryKey);

		if (review == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReviewException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return review;
	}

	/**
	 * Returns the review with the primary key or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	 *
	 * @param reviewId the primary key of the review
	 * @return the review
	 * @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review findByPrimaryKey(long reviewId)
		throws NoSuchReviewException, SystemException {
		return findByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns the review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the review
	 * @return the review, or <code>null</code> if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Review review = (Review)EntityCacheUtil.getResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
				ReviewImpl.class, primaryKey);

		if (review == _nullReview) {
			return null;
		}

		if (review == null) {
			Session session = null;

			try {
				session = openSession();

				review = (Review)session.get(ReviewImpl.class, primaryKey);

				if (review != null) {
					cacheResult(review);
				}
				else {
					EntityCacheUtil.putResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
						ReviewImpl.class, primaryKey, _nullReview);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReviewModelImpl.ENTITY_CACHE_ENABLED,
					ReviewImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return review;
	}

	/**
	 * Returns the review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the review
	 * @return the review, or <code>null</code> if a review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Review fetchByPrimaryKey(long reviewId) throws SystemException {
		return fetchByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns all the reviews.
	 *
	 * @return the reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @return the range of reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of reviews
	 * @param end the upper bound of the range of reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Review> findAll(int start, int end,
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

		List<Review> list = (List<Review>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REVIEW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REVIEW;

				if (pagination) {
					sql = sql.concat(ReviewModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Review>(list);
				}
				else {
					list = (List<Review>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the reviews from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Review review : findAll()) {
			remove(review);
		}
	}

	/**
	 * Returns the number of reviews.
	 *
	 * @return the number of reviews
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

				Query q = session.createQuery(_SQL_COUNT_REVIEW);

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
	 * Initializes the review persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.softwerke.srv.model.Review")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Review>> listenersList = new ArrayList<ModelListener<Review>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Review>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReviewImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REVIEW = "SELECT review FROM Review review";
	private static final String _SQL_SELECT_REVIEW_WHERE = "SELECT review FROM Review review WHERE ";
	private static final String _SQL_COUNT_REVIEW = "SELECT COUNT(review) FROM Review review";
	private static final String _SQL_COUNT_REVIEW_WHERE = "SELECT COUNT(review) FROM Review review WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "review.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Review exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Review exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReviewPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Review _nullReview = new ReviewImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Review> toCacheModel() {
				return _nullReviewCacheModel;
			}
		};

	private static CacheModel<Review> _nullReviewCacheModel = new CacheModel<Review>() {
			@Override
			public Review toEntityModel() {
				return _nullReview;
			}
		};
}