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

package com.softwerke.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyReviewLocalService}.
 *
 * @author Sasha
 * @see MyReviewLocalService
 * @generated
 */
public class MyReviewLocalServiceWrapper implements MyReviewLocalService,
	ServiceWrapper<MyReviewLocalService> {
	public MyReviewLocalServiceWrapper(
		MyReviewLocalService myReviewLocalService) {
		_myReviewLocalService = myReviewLocalService;
	}

	/**
	* Adds the my review to the database. Also notifies the appropriate model listeners.
	*
	* @param myReview the my review
	* @return the my review that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyReview addMyReview(
		com.softwerke.srv.model.MyReview myReview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.addMyReview(myReview);
	}

	/**
	* Creates a new my review with the primary key. Does not add the my review to the database.
	*
	* @param myReviewId the primary key for the new my review
	* @return the new my review
	*/
	@Override
	public com.softwerke.srv.model.MyReview createMyReview(long myReviewId) {
		return _myReviewLocalService.createMyReview(myReviewId);
	}

	/**
	* Deletes the my review with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param myReviewId the primary key of the my review
	* @return the my review that was removed
	* @throws PortalException if a my review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyReview deleteMyReview(long myReviewId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.deleteMyReview(myReviewId);
	}

	/**
	* Deletes the my review from the database. Also notifies the appropriate model listeners.
	*
	* @param myReview the my review
	* @return the my review that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyReview deleteMyReview(
		com.softwerke.srv.model.MyReview myReview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.deleteMyReview(myReview);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myReviewLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyReviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.softwerke.srv.model.MyReview fetchMyReview(long myReviewId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.fetchMyReview(myReviewId);
	}

	/**
	* Returns the my review with the primary key.
	*
	* @param myReviewId the primary key of the my review
	* @return the my review
	* @throws PortalException if a my review with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyReview getMyReview(long myReviewId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.getMyReview(myReviewId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.softwerke.srv.model.MyReview> getMyReviews(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.getMyReviews(start, end);
	}

	/**
	* Returns the number of my reviews.
	*
	* @return the number of my reviews
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMyReviewsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.getMyReviewsCount();
	}

	/**
	* Updates the my review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param myReview the my review
	* @return the my review that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyReview updateMyReview(
		com.softwerke.srv.model.MyReview myReview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myReviewLocalService.updateMyReview(myReview);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _myReviewLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_myReviewLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _myReviewLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MyReviewLocalService getWrappedMyReviewLocalService() {
		return _myReviewLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMyReviewLocalService(
		MyReviewLocalService myReviewLocalService) {
		_myReviewLocalService = myReviewLocalService;
	}

	@Override
	public MyReviewLocalService getWrappedService() {
		return _myReviewLocalService;
	}

	@Override
	public void setWrappedService(MyReviewLocalService myReviewLocalService) {
		_myReviewLocalService = myReviewLocalService;
	}

	private MyReviewLocalService _myReviewLocalService;
}