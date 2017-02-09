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

package com.softwerke.srv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.base.ReviewLocalServiceBaseImpl;
import com.softwerke.srv.service.persistence.ReviewUtil;

/**
 * The implementation of the review local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.softwerke.srv.service.ReviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sasha
 * @see com.softwerke.srv.service.base.ReviewLocalServiceBaseImpl
 * @see com.softwerke.srv.service.ReviewLocalServiceUtil
 */
public class ReviewLocalServiceImpl extends ReviewLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.softwerke.srv.service.ReviewLocalServiceUtil} to access the review local service.
	 */
	
	private static Log log = LogFactoryUtil.getLog(ReviewLocalServiceImpl.class);

	public List<Review> getByArticleId(long articleId) {
		List<Review> reviewList = new ArrayList<Review>();
		try {
			return ReviewUtil.findByArticleId(articleId);
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		return reviewList;
	}
}