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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.softwerke.srv.model.MyArticle;
import com.softwerke.srv.service.MyArticleService;
import com.softwerke.srv.service.persistence.MyArticlePersistence;
import com.softwerke.srv.service.persistence.MyReviewPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the my article remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.softwerke.srv.service.impl.MyArticleServiceImpl}.
 * </p>
 *
 * @author Sasha
 * @see com.softwerke.srv.service.impl.MyArticleServiceImpl
 * @see com.softwerke.srv.service.MyArticleServiceUtil
 * @generated
 */
public abstract class MyArticleServiceBaseImpl extends BaseServiceImpl
	implements MyArticleService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.softwerke.srv.service.MyArticleServiceUtil} to access the my article remote service.
	 */

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
	}

	public void destroy() {
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
		return MyArticle.class;
	}

	protected String getModelClassName() {
		return MyArticle.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = myArticlePersistence.getDataSource();

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
	private MyArticleServiceClpInvoker _clpInvoker = new MyArticleServiceClpInvoker();
}