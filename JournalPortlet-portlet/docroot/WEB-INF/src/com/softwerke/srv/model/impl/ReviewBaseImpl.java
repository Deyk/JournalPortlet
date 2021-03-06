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

package com.softwerke.srv.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.softwerke.srv.model.Review;
import com.softwerke.srv.service.ReviewLocalServiceUtil;

/**
 * The extended model base implementation for the Review service. Represents a row in the &quot;new_perfect_journal_Review&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReviewImpl}.
 * </p>
 *
 * @author Sasha
 * @see ReviewImpl
 * @see com.softwerke.srv.model.Review
 * @generated
 */
public abstract class ReviewBaseImpl extends ReviewModelImpl implements Review {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a review model instance should use the {@link Review} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ReviewLocalServiceUtil.addReview(this);
		}
		else {
			ReviewLocalServiceUtil.updateReview(this);
		}
	}
}