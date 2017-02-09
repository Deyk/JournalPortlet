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

import com.liferay.portal.service.persistence.BasePersistence;

import com.softwerke.srv.model.Review;

/**
 * The persistence interface for the review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see ReviewPersistenceImpl
 * @see ReviewUtil
 * @generated
 */
public interface ReviewPersistence extends BasePersistence<Review> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReviewUtil} to access the review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the first review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the last review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.softwerke.srv.model.Review[] findByUuid_PrevAndNext(
		long reviewId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Removes all the reviews where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the review where uuid = &#63; and groupId = &#63; or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the review where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the review that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the number of reviews where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reviews where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findByArticleId(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByArticleId_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the first review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByArticleId_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review
	* @throws com.softwerke.srv.NoSuchReviewException if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByArticleId_Last(long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the last review in the ordered set where articleId = &#63;.
	*
	* @param articleId the article ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching review, or <code>null</code> if a matching review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByArticleId_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.softwerke.srv.model.Review[] findByArticleId_PrevAndNext(
		long reviewId, long articleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Removes all the reviews where articleId = &#63; from the database.
	*
	* @param articleId the article ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArticleId(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reviews where articleId = &#63;.
	*
	* @param articleId the article ID
	* @return the number of matching reviews
	* @throws SystemException if a system exception occurred
	*/
	public int countByArticleId(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the review in the entity cache if it is enabled.
	*
	* @param review the review
	*/
	public void cacheResult(com.softwerke.srv.model.Review review);

	/**
	* Caches the reviews in the entity cache if it is enabled.
	*
	* @param reviews the reviews
	*/
	public void cacheResult(
		java.util.List<com.softwerke.srv.model.Review> reviews);

	/**
	* Creates a new review with the primary key. Does not add the review to the database.
	*
	* @param reviewId the primary key for the new review
	* @return the new review
	*/
	public com.softwerke.srv.model.Review create(long reviewId);

	/**
	* Removes the review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reviewId the primary key of the review
	* @return the review that was removed
	* @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review remove(long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	public com.softwerke.srv.model.Review updateImpl(
		com.softwerke.srv.model.Review review)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the review with the primary key or throws a {@link com.softwerke.srv.NoSuchReviewException} if it could not be found.
	*
	* @param reviewId the primary key of the review
	* @return the review
	* @throws com.softwerke.srv.NoSuchReviewException if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review findByPrimaryKey(long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchReviewException;

	/**
	* Returns the review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reviewId the primary key of the review
	* @return the review, or <code>null</code> if a review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.Review fetchByPrimaryKey(long reviewId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the reviews.
	*
	* @return the reviews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.Review> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.Review> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the reviews from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of reviews.
	*
	* @return the number of reviews
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}