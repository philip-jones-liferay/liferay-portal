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

package com.liferay.software.catalog.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SCProductVersion. This utility wraps
 * {@link com.liferay.software.catalog.service.impl.SCProductVersionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SCProductVersionLocalService
 * @see com.liferay.software.catalog.service.base.SCProductVersionLocalServiceBaseImpl
 * @see com.liferay.software.catalog.service.impl.SCProductVersionLocalServiceImpl
 * @generated
 */
@ProviderType
public class SCProductVersionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.software.catalog.service.impl.SCProductVersionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addSCFrameworkVersionSCProductVersion(
		long frameworkVersionId, long productVersionId) {
		getService()
			.addSCFrameworkVersionSCProductVersion(frameworkVersionId,
			productVersionId);
	}

	public static void addSCFrameworkVersionSCProductVersion(
		long frameworkVersionId,
		com.liferay.software.catalog.model.SCProductVersion scProductVersion) {
		getService()
			.addSCFrameworkVersionSCProductVersion(frameworkVersionId,
			scProductVersion);
	}

	public static void addSCFrameworkVersionSCProductVersions(
		long frameworkVersionId,
		java.util.List<com.liferay.software.catalog.model.SCProductVersion> SCProductVersions) {
		getService()
			.addSCFrameworkVersionSCProductVersions(frameworkVersionId,
			SCProductVersions);
	}

	public static void addSCFrameworkVersionSCProductVersions(
		long frameworkVersionId, long[] productVersionIds) {
		getService()
			.addSCFrameworkVersionSCProductVersions(frameworkVersionId,
			productVersionIds);
	}

	/**
	* Adds the s c product version to the database. Also notifies the appropriate model listeners.
	*
	* @param scProductVersion the s c product version
	* @return the s c product version that was added
	*/
	public static com.liferay.software.catalog.model.SCProductVersion addSCProductVersion(
		com.liferay.software.catalog.model.SCProductVersion scProductVersion) {
		return getService().addSCProductVersion(scProductVersion);
	}

	public static void clearSCFrameworkVersionSCProductVersions(
		long frameworkVersionId) {
		getService().clearSCFrameworkVersionSCProductVersions(frameworkVersionId);
	}

	/**
	* Creates a new s c product version with the primary key. Does not add the s c product version to the database.
	*
	* @param productVersionId the primary key for the new s c product version
	* @return the new s c product version
	*/
	public static com.liferay.software.catalog.model.SCProductVersion createSCProductVersion(
		long productVersionId) {
		return getService().createSCProductVersion(productVersionId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteSCFrameworkVersionSCProductVersion(
		long frameworkVersionId, long productVersionId) {
		getService()
			.deleteSCFrameworkVersionSCProductVersion(frameworkVersionId,
			productVersionId);
	}

	public static void deleteSCFrameworkVersionSCProductVersion(
		long frameworkVersionId,
		com.liferay.software.catalog.model.SCProductVersion scProductVersion) {
		getService()
			.deleteSCFrameworkVersionSCProductVersion(frameworkVersionId,
			scProductVersion);
	}

	public static void deleteSCFrameworkVersionSCProductVersions(
		long frameworkVersionId,
		java.util.List<com.liferay.software.catalog.model.SCProductVersion> SCProductVersions) {
		getService()
			.deleteSCFrameworkVersionSCProductVersions(frameworkVersionId,
			SCProductVersions);
	}

	public static void deleteSCFrameworkVersionSCProductVersions(
		long frameworkVersionId, long[] productVersionIds) {
		getService()
			.deleteSCFrameworkVersionSCProductVersions(frameworkVersionId,
			productVersionIds);
	}

	/**
	* Deletes the s c product version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productVersionId the primary key of the s c product version
	* @return the s c product version that was removed
	* @throws PortalException if a s c product version with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCProductVersion deleteSCProductVersion(
		long productVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSCProductVersion(productVersionId);
	}

	/**
	* Deletes the s c product version from the database. Also notifies the appropriate model listeners.
	*
	* @param scProductVersion the s c product version
	* @return the s c product version that was removed
	*/
	public static com.liferay.software.catalog.model.SCProductVersion deleteSCProductVersion(
		com.liferay.software.catalog.model.SCProductVersion scProductVersion) {
		return getService().deleteSCProductVersion(scProductVersion);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.software.catalog.model.SCProductVersion fetchSCProductVersion(
		long productVersionId) {
		return getService().fetchSCProductVersion(productVersionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the frameworkVersionIds of the s c framework versions associated with the s c product version.
	*
	* @param productVersionId the productVersionId of the s c product version
	* @return long[] the frameworkVersionIds of s c framework versions associated with the s c product version
	*/
	public static long[] getSCFrameworkVersionPrimaryKeys(long productVersionId) {
		return getService().getSCFrameworkVersionPrimaryKeys(productVersionId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductVersion> getSCFrameworkVersionSCProductVersions(
		long frameworkVersionId) {
		return getService()
				   .getSCFrameworkVersionSCProductVersions(frameworkVersionId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductVersion> getSCFrameworkVersionSCProductVersions(
		long frameworkVersionId, int start, int end) {
		return getService()
				   .getSCFrameworkVersionSCProductVersions(frameworkVersionId,
			start, end);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductVersion> getSCFrameworkVersionSCProductVersions(
		long frameworkVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.software.catalog.model.SCProductVersion> orderByComparator) {
		return getService()
				   .getSCFrameworkVersionSCProductVersions(frameworkVersionId,
			start, end, orderByComparator);
	}

	public static int getSCFrameworkVersionSCProductVersionsCount(
		long frameworkVersionId) {
		return getService()
				   .getSCFrameworkVersionSCProductVersionsCount(frameworkVersionId);
	}

	/**
	* Returns the s c product version with the primary key.
	*
	* @param productVersionId the primary key of the s c product version
	* @return the s c product version
	* @throws PortalException if a s c product version with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCProductVersion getSCProductVersion(
		long productVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSCProductVersion(productVersionId);
	}

	/**
	* Returns a range of all the s c product versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s c product versions
	* @param end the upper bound of the range of s c product versions (not inclusive)
	* @return the range of s c product versions
	*/
	public static java.util.List<com.liferay.software.catalog.model.SCProductVersion> getSCProductVersions(
		int start, int end) {
		return getService().getSCProductVersions(start, end);
	}

	/**
	* Returns the number of s c product versions.
	*
	* @return the number of s c product versions
	*/
	public static int getSCProductVersionsCount() {
		return getService().getSCProductVersionsCount();
	}

	public static boolean hasSCFrameworkVersionSCProductVersion(
		long frameworkVersionId, long productVersionId) {
		return getService()
				   .hasSCFrameworkVersionSCProductVersion(frameworkVersionId,
			productVersionId);
	}

	public static boolean hasSCFrameworkVersionSCProductVersions(
		long frameworkVersionId) {
		return getService()
				   .hasSCFrameworkVersionSCProductVersions(frameworkVersionId);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void setSCFrameworkVersionSCProductVersions(
		long frameworkVersionId, long[] productVersionIds) {
		getService()
			.setSCFrameworkVersionSCProductVersions(frameworkVersionId,
			productVersionIds);
	}

	/**
	* Updates the s c product version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scProductVersion the s c product version
	* @return the s c product version that was updated
	*/
	public static com.liferay.software.catalog.model.SCProductVersion updateSCProductVersion(
		com.liferay.software.catalog.model.SCProductVersion scProductVersion) {
		return getService().updateSCProductVersion(scProductVersion);
	}

	public static SCProductVersionLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(SCProductVersionLocalService service) {
	}

	private static ServiceTracker<SCProductVersionLocalService, SCProductVersionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SCProductVersionLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<SCProductVersionLocalService, SCProductVersionLocalService>(bundle.getBundleContext(),
				SCProductVersionLocalService.class, null);

		_serviceTracker.open();
	}
}