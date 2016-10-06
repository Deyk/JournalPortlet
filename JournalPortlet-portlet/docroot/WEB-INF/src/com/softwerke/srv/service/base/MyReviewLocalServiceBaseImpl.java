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

package com.softwerke.srv.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.softwerke.srv.model.MyReview;
import com.softwerke.srv.service.MyReviewLocalService;
import com.softwerke.srv.service.persistence.MyArticlePersistence;
import com.softwerke.srv.service.persistence.MyReviewPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the my review local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.softwerke.srv.service.impl.MyReviewLocalServiceImpl}.
 * </p>
 *
 * @author Sasha
 * @see com.softwerke.srv.service.impl.MyReviewLocalServiceImpl
 * @see com.softwerke.srv.service.MyReviewLocalServiceUtil
 * @generated
 */
public abstract class MyReviewLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements MyReviewLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.softwerke.srv.service.MyReviewLocalServiceUtil} to access the my review local service.
	 */

	/**
	 * Adds the my review to the database. Also notifies the appropriate model listeners.
	 *
	 * @param myReview the my review
	 * @return the my review that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MyReview addMyReview(MyReview myReview) throws SystemException {
		myReview.setNew(true);

		return myReviewPersistence.update(myReview);
	}

	/**
	 * Creates a new my review with the primary key. Does not add the my review to the database.
	 *
	 * @param myReviewId the primary key for the new my review
	 * @return the new my review
	 */
	@Override
	public MyReview createMyReview(long myReviewId) {
		return myReviewPersistence.create(myReviewId);
	}

	/**
	 * Deletes the my review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myReviewId the primary key of the my review
	 * @return the my review that was removed
	 * @throws PortalException if a my review with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MyReview deleteMyReview(long myReviewId)
		throws PortalException, SystemException {
		return myReviewPersistence.remove(myReviewId);
	}

	/**
	 * Deletes the my review from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myReview the my review
	 * @return the my review that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MyReview deleteMyReview(MyReview myReview) throws SystemException {
		return myReviewPersistence.remove(myReview);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(MyReview.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return myReviewPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return myReviewPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return myReviewPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return myReviewPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return myReviewPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public MyReview fetchMyReview(long myReviewId) throws SystemException {
		return myReviewPersistence.fetchByPrimaryKey(myReviewId);
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
	public MyReview getMyReview(long myReviewId)
		throws PortalException, SystemException {
		return myReviewPersistence.findByPrimaryKey(myReviewId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return myReviewPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<MyReview> getMyReviews(int start, int end)
		throws SystemException {
		return myReviewPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of my reviews.
	 *
	 * @return the number of my reviews
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getMyReviewsCount() throws SystemException {
		return myReviewPersistence.countAll();
	}

	/**
	 * Updates the my review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param myReview the my review
	 * @return the my review that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MyReview updateMyReview(MyReview myReview) throws SystemException {
		return myReviewPersistence.update(myReview);
	}

	/**
	 * Returns the my article local service.
	 *
	 * @return the my article local service
	 */
	public com.softwerke.srv.service.MyArticleLocalService getMyArticleLocalService() {
		return myArticleLocalService;
	}

	/**
	 * Sets the my article local service.
	 *
	 * @param myArticleLocalService the my article local service
	 */
	public void setMyArticleLocalService(
		com.softwerke.srv.service.MyArticleLocalService myArticleLocalService) {
		this.myArticleLocalService = myArticleLocalService;
	}

	/**
	 * Returns the my article remote service.
	 *
	 * @return the my article remote service
	 */
	public com.softwerke.srv.service.MyArticleService getMyArticleService() {
		return myArticleService;
	}

	/**
	 * Sets the my article remote service.
	 *
	 * @param myArticleService the my article remote service
	 */
	public void setMyArticleService(
		com.softwerke.srv.service.MyArticleService myArticleService) {
		this.myArticleService = myArticleService;
	}

	/**
	 * Returns the my article persistence.
	 *
	 * @return the my article persistence
	 */
	public MyArticlePersistence getMyArticlePersistence() {
		return myArticlePersistence;
	}

	/**
	 * Sets the my article persistence.
	 *
	 * @param myArticlePersistence the my article persistence
	 */
	public void setMyArticlePersistence(
		MyArticlePersistence myArticlePersistence) {
		this.myArticlePersistence = myArticlePersistence;
	}

	/**
	 * Returns the my review local service.
	 *
	 * @return the my review local service
	 */
	public com.softwerke.srv.service.MyReviewLocalService getMyReviewLocalService() {
		return myReviewLocalService;
	}

	/**
	 * Sets the my review local service.
	 *
	 * @param myReviewLocalService the my review local service
	 */
	public void setMyReviewLocalService(
		com.softwerke.srv.service.MyReviewLocalService myReviewLocalService) {
		this.myReviewLocalService = myReviewLocalService;
	}

	/**
	 * Returns the my review remote service.
	 *
	 * @return the my review remote service
	 */
	public com.softwerke.srv.service.MyReviewService getMyReviewService() {
		return myReviewService;
	}

	/**
	 * Sets the my review remote service.
	 *
	 * @param myReviewService the my review remote service
	 */
	public void setMyReviewService(
		com.softwerke.srv.service.MyReviewService myReviewService) {
		this.myReviewService = myReviewService;
	}

	/**
	 * Returns the my review persistence.
	 *
	 * @return the my review persistence
	 */
	public MyReviewPersistence getMyReviewPersistence() {
		return myReviewPersistence;
	}

	/**
	 * Sets the my review persistence.
	 *
	 * @param myReviewPersistence the my review persistence
	 */
	public void setMyReviewPersistence(MyReviewPersistence myReviewPersistence) {
		this.myReviewPersistence = myReviewPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.softwerke.srv.model.MyReview",
			myReviewLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.softwerke.srv.model.MyReview");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return MyReview.class;
	}

	protected String getModelClassName() {
		return MyReview.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = myReviewPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.softwerke.srv.service.MyArticleLocalService.class)
	protected com.softwerke.srv.service.MyArticleLocalService myArticleLocalService;
	@BeanReference(type = com.softwerke.srv.service.MyArticleService.class)
	protected com.softwerke.srv.service.MyArticleService myArticleService;
	@BeanReference(type = MyArticlePersistence.class)
	protected MyArticlePersistence myArticlePersistence;
	@BeanReference(type = com.softwerke.srv.service.MyReviewLocalService.class)
	protected com.softwerke.srv.service.MyReviewLocalService myReviewLocalService;
	@BeanReference(type = com.softwerke.srv.service.MyReviewService.class)
	protected com.softwerke.srv.service.MyReviewService myReviewService;
	@BeanReference(type = MyReviewPersistence.class)
	protected MyReviewPersistence myReviewPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private MyReviewLocalServiceClpInvoker _clpInvoker = new MyReviewLocalServiceClpInvoker();
}