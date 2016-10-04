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
 * Provides a wrapper for {@link MyArticleLocalService}.
 *
 * @author Sasha
 * @see MyArticleLocalService
 * @generated
 */
public class MyArticleLocalServiceWrapper implements MyArticleLocalService,
	ServiceWrapper<MyArticleLocalService> {
	public MyArticleLocalServiceWrapper(
		MyArticleLocalService myArticleLocalService) {
		_myArticleLocalService = myArticleLocalService;
	}

	/**
	* Adds the my article to the database. Also notifies the appropriate model listeners.
	*
	* @param myArticle the my article
	* @return the my article that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyArticle addMyArticle(
		com.softwerke.srv.model.MyArticle myArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.addMyArticle(myArticle);
	}

	/**
	* Creates a new my article with the primary key. Does not add the my article to the database.
	*
	* @param myArticleId the primary key for the new my article
	* @return the new my article
	*/
	@Override
	public com.softwerke.srv.model.MyArticle createMyArticle(long myArticleId) {
		return _myArticleLocalService.createMyArticle(myArticleId);
	}

	/**
	* Deletes the my article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param myArticleId the primary key of the my article
	* @return the my article that was removed
	* @throws PortalException if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyArticle deleteMyArticle(long myArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.deleteMyArticle(myArticleId);
	}

	/**
	* Deletes the my article from the database. Also notifies the appropriate model listeners.
	*
	* @param myArticle the my article
	* @return the my article that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyArticle deleteMyArticle(
		com.softwerke.srv.model.MyArticle myArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.deleteMyArticle(myArticle);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myArticleLocalService.dynamicQuery();
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
		return _myArticleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _myArticleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _myArticleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _myArticleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _myArticleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.softwerke.srv.model.MyArticle fetchMyArticle(long myArticleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.fetchMyArticle(myArticleId);
	}

	/**
	* Returns the my article with the primary key.
	*
	* @param myArticleId the primary key of the my article
	* @return the my article
	* @throws PortalException if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyArticle getMyArticle(long myArticleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.getMyArticle(myArticleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.softwerke.srv.model.MyArticle> getMyArticles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.getMyArticles(start, end);
	}

	/**
	* Returns the number of my articles.
	*
	* @return the number of my articles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMyArticlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.getMyArticlesCount();
	}

	/**
	* Updates the my article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param myArticle the my article
	* @return the my article that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.softwerke.srv.model.MyArticle updateMyArticle(
		com.softwerke.srv.model.MyArticle myArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myArticleLocalService.updateMyArticle(myArticle);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _myArticleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_myArticleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _myArticleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MyArticleLocalService getWrappedMyArticleLocalService() {
		return _myArticleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMyArticleLocalService(
		MyArticleLocalService myArticleLocalService) {
		_myArticleLocalService = myArticleLocalService;
	}

	@Override
	public MyArticleLocalService getWrappedService() {
		return _myArticleLocalService;
	}

	@Override
	public void setWrappedService(MyArticleLocalService myArticleLocalService) {
		_myArticleLocalService = myArticleLocalService;
	}

	private MyArticleLocalService _myArticleLocalService;
}