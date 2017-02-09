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

import com.softwerke.srv.model.Article;

import java.util.List;

/**
 * The persistence utility for the article service. This utility wraps {@link ArticlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see ArticlePersistence
 * @see ArticlePersistenceImpl
 * @generated
 */
public class ArticleUtil {
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
	public static void clearCache(Article article) {
		getPersistence().clearCache(article);
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
	public static List<Article> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Article update(Article article) throws SystemException {
		return getPersistence().update(article);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Article update(Article article, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(article, serviceContext);
	}

	/**
	* Returns all the articles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the articles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the articles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the articles before and after the current article in the ordered set where uuid = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article[] findByUuid_PrevAndNext(
		long articleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByUuid_PrevAndNext(articleId, uuid, orderByComparator);
	}

	/**
	* Removes all the articles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of articles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the article where uuid = &#63; and groupId = &#63; or throws a {@link com.softwerke.srv.NoSuchArticleException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the article where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the article that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of articles where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the articles where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleStatus(
		int articleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleStatus(articleStatus);
	}

	/**
	* Returns a range of all the articles where articleStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param articleStatus the article status
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleStatus(
		int articleStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleStatus(articleStatus, start, end);
	}

	/**
	* Returns an ordered range of all the articles where articleStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param articleStatus the article status
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleStatus(
		int articleStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleStatus(articleStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByArticleStatus_First(
		int articleStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleStatus_First(articleStatus, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByArticleStatus_First(
		int articleStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleStatus_First(articleStatus, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByArticleStatus_Last(
		int articleStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleStatus_Last(articleStatus, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByArticleStatus_Last(
		int articleStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleStatus_Last(articleStatus, orderByComparator);
	}

	/**
	* Returns the articles before and after the current article in the ordered set where articleStatus = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param articleStatus the article status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article[] findByArticleStatus_PrevAndNext(
		long articleId, int articleStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleStatus_PrevAndNext(articleId, articleStatus,
			orderByComparator);
	}

	/**
	* Removes all the articles where articleStatus = &#63; from the database.
	*
	* @param articleStatus the article status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticleStatus(int articleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticleStatus(articleStatus);
	}

	/**
	* Returns the number of articles where articleStatus = &#63;.
	*
	* @param articleStatus the article status
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleStatus(int articleStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleStatus(articleStatus);
	}

	/**
	* Returns all the articles where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByIsArticlePublished(
		boolean isArticlePublished)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsArticlePublished(isArticlePublished);
	}

	/**
	* Returns a range of all the articles where isArticlePublished = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isArticlePublished the is article published
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByIsArticlePublished(
		boolean isArticlePublished, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsArticlePublished(isArticlePublished, start, end);
	}

	/**
	* Returns an ordered range of all the articles where isArticlePublished = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isArticlePublished the is article published
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByIsArticlePublished(
		boolean isArticlePublished, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsArticlePublished(isArticlePublished, start, end,
			orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByIsArticlePublished_First(
		boolean isArticlePublished,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByIsArticlePublished_First(isArticlePublished,
			orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByIsArticlePublished_First(
		boolean isArticlePublished,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsArticlePublished_First(isArticlePublished,
			orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByIsArticlePublished_Last(
		boolean isArticlePublished,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByIsArticlePublished_Last(isArticlePublished,
			orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByIsArticlePublished_Last(
		boolean isArticlePublished,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsArticlePublished_Last(isArticlePublished,
			orderByComparator);
	}

	/**
	* Returns the articles before and after the current article in the ordered set where isArticlePublished = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param isArticlePublished the is article published
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article[] findByIsArticlePublished_PrevAndNext(
		long articleId, boolean isArticlePublished,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByIsArticlePublished_PrevAndNext(articleId,
			isArticlePublished, orderByComparator);
	}

	/**
	* Removes all the articles where isArticlePublished = &#63; from the database.
	*
	* @param isArticlePublished the is article published
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsArticlePublished(boolean isArticlePublished)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsArticlePublished(isArticlePublished);
	}

	/**
	* Returns the number of articles where isArticlePublished = &#63;.
	*
	* @param isArticlePublished the is article published
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsArticlePublished(boolean isArticlePublished)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsArticlePublished(isArticlePublished);
	}

	/**
	* Returns all the articles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleUserId(userId);
	}

	/**
	* Returns a range of all the articles where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @return the range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArticleUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the articles where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findByArticleUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArticleUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByArticleUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first article in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByArticleUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article
	* @throws com.softwerke.srv.NoSuchArticleException if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByArticleUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last article in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching article, or <code>null</code> if a matching article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByArticleUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByArticleUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the articles before and after the current article in the ordered set where userId = &#63;.
	*
	* @param articleId the primary key of the current article
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next article
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article[] findByArticleUserId_PrevAndNext(
		long articleId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence()
				   .findByArticleUserId_PrevAndNext(articleId, userId,
			orderByComparator);
	}

	/**
	* Removes all the articles where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArticleUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArticleUserId(userId);
	}

	/**
	* Returns the number of articles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArticleUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArticleUserId(userId);
	}

	/**
	* Caches the article in the entity cache if it is enabled.
	*
	* @param article the article
	*/
	public static void cacheResult(com.softwerke.srv.model.Article article) {
		getPersistence().cacheResult(article);
	}

	/**
	* Caches the articles in the entity cache if it is enabled.
	*
	* @param articles the articles
	*/
	public static void cacheResult(
		java.util.List<com.softwerke.srv.model.Article> articles) {
		getPersistence().cacheResult(articles);
	}

	/**
	* Creates a new article with the primary key. Does not add the article to the database.
	*
	* @param articleId the primary key for the new article
	* @return the new article
	*/
	public static com.softwerke.srv.model.Article create(long articleId) {
		return getPersistence().create(articleId);
	}

	/**
	* Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleId the primary key of the article
	* @return the article that was removed
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article remove(long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().remove(articleId);
	}

	public static com.softwerke.srv.model.Article updateImpl(
		com.softwerke.srv.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(article);
	}

	/**
	* Returns the article with the primary key or throws a {@link com.softwerke.srv.NoSuchArticleException} if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article
	* @throws com.softwerke.srv.NoSuchArticleException if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article findByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchArticleException {
		return getPersistence().findByPrimaryKey(articleId);
	}

	/**
	* Returns the article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleId the primary key of the article
	* @return the article, or <code>null</code> if a article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.softwerke.srv.model.Article fetchByPrimaryKey(
		long articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(articleId);
	}

	/**
	* Returns all the articles.
	*
	* @return the articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.softwerke.srv.model.Article> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.ArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of articles
	* @param end the upper bound of the range of articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of articles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.softwerke.srv.model.Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of articles.
	*
	* @return the number of articles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ArticlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ArticlePersistence)PortletBeanLocatorUtil.locate(com.softwerke.srv.service.ClpSerializer.getServletContextName(),
					ArticlePersistence.class.getName());

			ReferenceRegistry.registerReference(ArticleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ArticlePersistence persistence) {
	}

	private static ArticlePersistence _persistence;
}