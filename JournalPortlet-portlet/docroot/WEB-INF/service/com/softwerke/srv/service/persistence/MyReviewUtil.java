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

import com.softwerke.srv.model.MyReview;

import java.util.List;

/**
 * The persistence utility for the my review service. This utility wraps {@link MyReviewPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see MyReviewPersistence
 * @see MyReviewPersistenceImpl
 * @generated
 */
public class MyReviewUtil {
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
	public static void clearCache(MyReview myReview) {
		getPersistence().clearCache(myReview);
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
	public static List<MyReview> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyReview> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MyReview update(MyReview myReview) throws SystemException {
		return getPersistence().update(myReview);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MyReview update(MyReview myReview,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(myReview, serviceContext);
	}

	/**
	* Returns all the my reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching my reviews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.MyReview> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
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
	public static java.util.List<com.softwerke.srv.model.MyReview> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static java.util.List<com.softwerke.srv.model.MyReview> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static com.softwerke.srv.model.MyReview findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyReviewException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first my review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching my review, or <code>null</code> if a matching my review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.MyReview fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
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
	public static com.softwerke.srv.model.MyReview findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyReviewException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last my review in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching my review, or <code>null</code> if a matching my review could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.MyReview fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static com.softwerke.srv.model.MyReview[] findByUuid_PrevAndNext(
		long myReviewId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyReviewException {
		return getPersistence()
				   .findByUuid_PrevAndNext(myReviewId, uuid, orderByComparator);
	}

	/**
	* Removes all the my reviews where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of my reviews where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching my reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the my review in the entity cache if it is enabled.
	*
	* @param myReview the my review
	*/
	public static void cacheResult(com.softwerke.srv.model.MyReview myReview) {
		getPersistence().cacheResult(myReview);
	}

	/**
	* Caches the my reviews in the entity cache if it is enabled.
	*
	* @param myReviews the my reviews
	*/
	public static void cacheResult(
		java.util.List<com.softwerke.srv.model.MyReview> myReviews) {
		getPersistence().cacheResult(myReviews);
	}

	/**
	* Creates a new my review with the primary key. Does not add the my review to the database.
	*
	* @param myReviewId the primary key for the new my review
	* @return the new my review
	*/
	public static com.softwerke.srv.model.MyReview create(long myReviewId) {
		return getPersistence().create(myReviewId);
	}

	/**
	* Removes the my review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param myReviewId the primary key of the my review
	* @return the my review that was removed
	* @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.MyReview remove(long myReviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyReviewException {
		return getPersistence().remove(myReviewId);
	}

	public static com.softwerke.srv.model.MyReview updateImpl(
		com.softwerke.srv.model.MyReview myReview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(myReview);
	}

	/**
	* Returns the my review with the primary key or throws a {@link com.softwerke.srv.NoSuchMyReviewException} if it could not be found.
	*
	* @param myReviewId the primary key of the my review
	* @return the my review
	* @throws com.softwerke.srv.NoSuchMyReviewException if a my review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.MyReview findByPrimaryKey(
		long myReviewId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyReviewException {
		return getPersistence().findByPrimaryKey(myReviewId);
	}

	/**
	* Returns the my review with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param myReviewId the primary key of the my review
	* @return the my review, or <code>null</code> if a my review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.MyReview fetchByPrimaryKey(
		long myReviewId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(myReviewId);
	}

	/**
	* Returns all the my reviews.
	*
	* @return the my reviews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.MyReview> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.softwerke.srv.model.MyReview> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.softwerke.srv.model.MyReview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the my reviews from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of my reviews.
	*
	* @return the number of my reviews
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MyReviewPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MyReviewPersistence)PortletBeanLocatorUtil.locate(com.softwerke.srv.service.ClpSerializer.getServletContextName(),
					MyReviewPersistence.class.getName());

			ReferenceRegistry.registerReference(MyReviewUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MyReviewPersistence persistence) {
	}

	private static MyReviewPersistence _persistence;
}