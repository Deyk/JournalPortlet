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

import com.softwerke.srv.model.MyArticle;

/**
 * The persistence interface for the my article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sasha
 * @see MyArticlePersistenceImpl
 * @see MyArticleUtil
 * @generated
 */
public interface MyArticlePersistence extends BasePersistence<MyArticle> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MyArticleUtil} to access the my article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the my articles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching my articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.MyArticle> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the my articles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of my articles
	* @param end the upper bound of the range of my articles (not inclusive)
	* @return the range of matching my articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.MyArticle> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the my articles where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of my articles
	* @param end the upper bound of the range of my articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching my articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.MyArticle> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first my article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching my article
	* @throws com.softwerke.srv.NoSuchMyArticleException if a matching my article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyArticleException;

	/**
	* Returns the first my article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching my article, or <code>null</code> if a matching my article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last my article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching my article
	* @throws com.softwerke.srv.NoSuchMyArticleException if a matching my article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyArticleException;

	/**
	* Returns the last my article in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching my article, or <code>null</code> if a matching my article could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the my articles before and after the current my article in the ordered set where uuid = &#63;.
	*
	* @param myArticleId the primary key of the current my article
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next my article
	* @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle[] findByUuid_PrevAndNext(
		long myArticleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyArticleException;

	/**
	* Removes all the my articles where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of my articles where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching my articles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the my article in the entity cache if it is enabled.
	*
	* @param myArticle the my article
	*/
	public void cacheResult(com.softwerke.srv.model.MyArticle myArticle);

	/**
	* Caches the my articles in the entity cache if it is enabled.
	*
	* @param myArticles the my articles
	*/
	public void cacheResult(
		java.util.List<com.softwerke.srv.model.MyArticle> myArticles);

	/**
	* Creates a new my article with the primary key. Does not add the my article to the database.
	*
	* @param myArticleId the primary key for the new my article
	* @return the new my article
	*/
	public com.softwerke.srv.model.MyArticle create(long myArticleId);

	/**
	* Removes the my article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param myArticleId the primary key of the my article
	* @return the my article that was removed
	* @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle remove(long myArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyArticleException;

	public com.softwerke.srv.model.MyArticle updateImpl(
		com.softwerke.srv.model.MyArticle myArticle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the my article with the primary key or throws a {@link com.softwerke.srv.NoSuchMyArticleException} if it could not be found.
	*
	* @param myArticleId the primary key of the my article
	* @return the my article
	* @throws com.softwerke.srv.NoSuchMyArticleException if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle findByPrimaryKey(long myArticleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.softwerke.srv.NoSuchMyArticleException;

	/**
	* Returns the my article with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param myArticleId the primary key of the my article
	* @return the my article, or <code>null</code> if a my article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.softwerke.srv.model.MyArticle fetchByPrimaryKey(long myArticleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the my articles.
	*
	* @return the my articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.MyArticle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.softwerke.srv.model.MyArticle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the my articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.softwerke.srv.model.impl.MyArticleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of my articles
	* @param end the upper bound of the range of my articles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of my articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.softwerke.srv.model.MyArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the my articles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of my articles.
	*
	* @return the number of my articles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}