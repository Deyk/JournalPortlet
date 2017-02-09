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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.softwerke.srv.model.Review;

import java.util.List;

/**
 * The persistence utility for the review service. This utility wraps {@link ReviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see ReviewPersistence
 * @see ReviewPersistenceImpl
 * @generated
 */
public class ReviewUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Review review) {
		getPersistence().clearCache(review);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Review> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Review update(Review review) throws SystemException {
		return getPersistence().update(review);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Review update(Review review, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(review, serviceContext);
	}

	/**
	* Returns all the reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
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
	public static java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static com.softwerke.srv.model.Review findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
	public static com.softwerke.srv.model.Review findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static com.softwerke.srv.model.Review[] findByUuid_PrevAndNext(
		long reviewId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence()
				   .findByUuid_PrevAndNext(reviewId, uuid, orderByComparator);
	}

	/**
	* Removes all the reviews where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the review where uuid = &#63; and groupId = &#63; or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
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
	public static com.softwerke.srv.model.Review fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the review where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the review that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of reviews where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the reviews where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleId(articleId);
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
	public static java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleId(articleId, start, end);
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
	public static java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleId(articleId, start, end, orderByComparator);
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
	public static com.softwerke.srv.model.Review findByArticleId_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence()
				   .findByArticleId_First(articleId, orderByComparator);
	}

	/**
	* Returns the first review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByArticleId_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleId_First(articleId, orderByComparator);
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
	public static com.softwerke.srv.model.Review findByArticleId_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence()
				   .findByArticleId_Last(articleId, orderByComparator);
	}

	/**
	* Returns the last review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByArticleId_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleId_Last(articleId, orderByComparator);
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
	public static com.softwerke.srv.model.Review[] findByArticleId_PrevAndNext(
		long reviewId, long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence()
				   .findByArticleId_PrevAndNext(reviewId, articleId,
			orderByComparator);
	}

	/**
	* Removes all the reviews where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticleId(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticleId(articleId);
	}

	/**
	* Returns the number of reviews where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleId(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleId(articleId);
	}

	/**
	* Caches the review in the entity cache if it is enabled.
	*
	* @param review the review
	*/
	public static void cacheResult(com.softwerke.srv.model.Review review) {
		getPersistence().cacheResult(review);
	}

	/**
	* Caches the reviews in the entity cache if it is enabled.
	*
	* @param reviews the reviews
	*/
	public static void cacheResult(
		java.util.List<com.softwerke.srv.model.Review> reviews) {
		getPersistence().cacheResult(reviews);
	}

	/**
	* Creates a new review with the primary key. Does not add the review to the database.
	*
	* @param reviewId the primary key for the new review
	* @return the new review
	*/
	public static com.softwerke.srv.model.Review create(long reviewId) {
		return getPersistence().create(reviewId);
	}

	/**
	* Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reviewId the primary key of the review
	* @return the review that was removed
	* @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review remove(long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().remove(reviewId);
	}

	public static com.softwerke.srv.model.Review updateImpl(
		com.softwerke.srv.model.Review review)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(review);
	}

	/**
	* Returns the review with the primary key or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	*
	* @param reviewId the primary key of the review
	* @return the review
	* @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review findByPrimaryKey(long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException {
		return getPersistence().findByPrimaryKey(reviewId);
	}

	/**
	* Returns the review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reviewId the primary key of the review
	* @return the review, or <code>null</code> if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Review fetchByPrimaryKey(
		long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reviewId);
	}

	/**
	* Returns all the reviews.
	*
	* @return the reviews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Review> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.softwerke.srv.model.Review> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.softwerke.srv.model.Review> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the reviews from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of reviews.
	*
	* @return the number of reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReviewPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReviewPersistence)PortletBeanLocatorUtil.locate(com.softwerke.srv.service.ClpSerializer.getServletContextName(),
					ReviewPersistence.class.getName());

			ReferenceRegistry.registerReference(ReviewUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ReviewPersistence persistence) {
	}

	private static ReviewPersistence _persistence;
}