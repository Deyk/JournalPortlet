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

import com.softwerke.srv.model.Article;
import com.softwerke.srv.service.ArticleLocalService;
import com.softwerke.srv.service.persistence.ArticlePersistence;
import com.softwerke.srv.service.persistence.ReviewPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the article local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.softwerke.srv.service.impl.ArticleLocalServiceImpl}.
 * </p>
 *
 * @author Sasha
 * @see com.softwerke.srv.service.impl.ArticleLocalServiceImpl
 * @see com.softwerke.srv.service.ArticleLocalServiceUtil
 * @generated
 */
public abstract class ArticleLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ArticleLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.softwerke.srv.service.ArticleLocalServiceUtil} to access the article local service.
	 */

	/**
	 * Adds the article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Article addArticle(Article article) throws SystemException {
		article.setNew(true);

		return articlePersistence.update(article);
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article createArticle(long articleId) {
		return articlePersistence.create(articleId);
	}

	/**
	 * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws PortalException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Article deleteArticle(long articleId)
		throws PortalException, SystemException {
		return articlePersistence.remove(articleId);
	}

	/**
	 * Deletes the article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Article deleteArticle(Article article) throws SystemException {
		return articlePersistence.remove(article);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Article.class,
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
		return articlePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return articlePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return articlePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return articlePersistence.countWithDynamicQuery(dynamicQuery);
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
		return articlePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Article fetchArticle(long articleId) throws SystemException {
		return articlePersistence.fetchByPrimaryKey(articleId);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article fetchArticleByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return articlePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article with the primary key.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws PortalException if a article with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article getArticle(long articleId)
		throws PortalException, SystemException {
		return articlePersistence.findByPrimaryKey(articleId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return articlePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article
	 * @throws PortalException if a matching article could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Article getArticleByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return articlePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Article> getArticles(int start, int end)
		throws SystemException {
		return articlePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getArticlesCount() throws SystemException {
		return articlePersistence.countAll();
	}

	/**
	 * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Article updateArticle(Article article) throws SystemException {
		return articlePersistence.update(article);
	}

	/**
	 * Returns the article local service.
	 *
	 * @return the article local service
	 */
	public com.softwerke.srv.service.ArticleLocalService getArticleLocalService() {
		return articleLocalService;
	}

	/**
	 * Sets the article local service.
	 *
	 * @param articleLocalService the article local service
	 */
	public void setArticleLocalService(
		com.softwerke.srv.service.ArticleLocalService articleLocalService) {
		this.articleLocalService = articleLocalService;
	}

	/**
	 * Returns the article remote service.
	 *
	 * @return the article remote service
	 */
	public com.softwerke.srv.service.ArticleService getArticleService() {
		return articleService;
	}

	/**
	 * Sets the article remote service.
	 *
	 * @param articleService the article remote service
	 */
	public void setArticleService(
		com.softwerke.srv.service.ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * Returns the article persistence.
	 *
	 * @return the article persistence
	 */
	public ArticlePersistence getArticlePersistence() {
		return articlePersistence;
	}

	/**
	 * Sets the article persistence.
	 *
	 * @param articlePersistence the article persistence
	 */
	public void setArticlePersistence(ArticlePersistence articlePersistence) {
		this.articlePersistence = articlePersistence;
	}

	/**
	 * Returns the review local service.
	 *
	 * @return the review local service
	 */
	public com.softwerke.srv.service.ReviewLocalService getReviewLocalService() {
		return reviewLocalService;
	}

	/**
	 * Sets the review local service.
	 *
	 * @param reviewLocalService the review local service
	 */
	public void setReviewLocalService(
		com.softwerke.srv.service.ReviewLocalService reviewLocalService) {
		this.reviewLocalService = reviewLocalService;
	}

	/**
	 * Returns the review remote service.
	 *
	 * @return the review remote service
	 */
	public com.softwerke.srv.service.ReviewService getReviewService() {
		return reviewService;
	}

	/**
	 * Sets the review remote service.
	 *
	 * @param reviewService the review remote service
	 */
	public void setReviewService(
		com.softwerke.srv.service.ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	/**
	 * Returns the review persistence.
	 *
	 * @return the review persistence
	 */
	public ReviewPersistence getReviewPersistence() {
		return reviewPersistence;
	}

	/**
	 * Sets the review persistence.
	 *
	 * @param reviewPersistence the review persistence
	 */
	public void setReviewPersistence(ReviewPersistence reviewPersistence) {
		this.reviewPersistence = reviewPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.softwerke.srv.model.Article",
			articleLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.softwerke.srv.model.Article");
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
		return Article.class;
	}

	protected String getModelClassName() {
		return Article.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = articlePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.softwerke.srv.service.ArticleLocalService.class)
	protected com.softwerke.srv.service.ArticleLocalService articleLocalService;
	@BeanReference(type = com.softwerke.srv.service.ArticleService.class)
	protected com.softwerke.srv.service.ArticleService articleService;
	@BeanReference(type = ArticlePersistence.class)
	protected ArticlePersistence articlePersistence;
	@BeanReference(type = com.softwerke.srv.service.ReviewLocalService.class)
	protected com.softwerke.srv.service.ReviewLocalService reviewLocalService;
	@BeanReference(type = com.softwerke.srv.service.ReviewService.class)
	protected com.softwerke.srv.service.ReviewService reviewService;
	@BeanReference(type = ReviewPersistence.class)
	protected ReviewPersistence reviewPersistence;
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
	private ArticleLocalServiceClpInvoker _clpInvoker = new ArticleLocalServiceClpInvoker();
}