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
 * Provides the local service utility for SCLicense. This utility wraps
 * {@link com.liferay.software.catalog.service.impl.SCLicenseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SCLicenseLocalService
 * @see com.liferay.software.catalog.service.base.SCLicenseLocalServiceBaseImpl
 * @see com.liferay.software.catalog.service.impl.SCLicenseLocalServiceImpl
 * @generated
 */
@ProviderType
public class SCLicenseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.software.catalog.service.impl.SCLicenseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s c license to the database. Also notifies the appropriate model listeners.
	*
	* @param scLicense the s c license
	* @return the s c license that was added
	*/
	public static com.liferay.software.catalog.model.SCLicense addSCLicense(
		com.liferay.software.catalog.model.SCLicense scLicense) {
		return getService().addSCLicense(scLicense);
	}

	public static void addSCProductEntrySCLicense(long productEntryId,
		long licenseId) {
		getService().addSCProductEntrySCLicense(productEntryId, licenseId);
	}

	public static void addSCProductEntrySCLicense(long productEntryId,
		com.liferay.software.catalog.model.SCLicense scLicense) {
		getService().addSCProductEntrySCLicense(productEntryId, scLicense);
	}

	public static void addSCProductEntrySCLicenses(long productEntryId,
		java.util.List<com.liferay.software.catalog.model.SCLicense> SCLicenses) {
		getService().addSCProductEntrySCLicenses(productEntryId, SCLicenses);
	}

	public static void addSCProductEntrySCLicenses(long productEntryId,
		long[] licenseIds) {
		getService().addSCProductEntrySCLicenses(productEntryId, licenseIds);
	}

	public static void clearSCProductEntrySCLicenses(long productEntryId) {
		getService().clearSCProductEntrySCLicenses(productEntryId);
	}

	/**
	* Creates a new s c license with the primary key. Does not add the s c license to the database.
	*
	* @param licenseId the primary key for the new s c license
	* @return the new s c license
	*/
	public static com.liferay.software.catalog.model.SCLicense createSCLicense(
		long licenseId) {
		return getService().createSCLicense(licenseId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the s c license with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param licenseId the primary key of the s c license
	* @return the s c license that was removed
	* @throws PortalException if a s c license with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCLicense deleteSCLicense(
		long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSCLicense(licenseId);
	}

	/**
	* Deletes the s c license from the database. Also notifies the appropriate model listeners.
	*
	* @param scLicense the s c license
	* @return the s c license that was removed
	*/
	public static com.liferay.software.catalog.model.SCLicense deleteSCLicense(
		com.liferay.software.catalog.model.SCLicense scLicense) {
		return getService().deleteSCLicense(scLicense);
	}

	public static void deleteSCProductEntrySCLicense(long productEntryId,
		long licenseId) {
		getService().deleteSCProductEntrySCLicense(productEntryId, licenseId);
	}

	public static void deleteSCProductEntrySCLicense(long productEntryId,
		com.liferay.software.catalog.model.SCLicense scLicense) {
		getService().deleteSCProductEntrySCLicense(productEntryId, scLicense);
	}

	public static void deleteSCProductEntrySCLicenses(long productEntryId,
		java.util.List<com.liferay.software.catalog.model.SCLicense> SCLicenses) {
		getService().deleteSCProductEntrySCLicenses(productEntryId, SCLicenses);
	}

	public static void deleteSCProductEntrySCLicenses(long productEntryId,
		long[] licenseIds) {
		getService().deleteSCProductEntrySCLicenses(productEntryId, licenseIds);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.software.catalog.model.SCLicense fetchSCLicense(
		long licenseId) {
		return getService().fetchSCLicense(licenseId);
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
	* Returns the s c license with the primary key.
	*
	* @param licenseId the primary key of the s c license
	* @return the s c license
	* @throws PortalException if a s c license with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCLicense getSCLicense(
		long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSCLicense(licenseId);
	}

	/**
	* Returns a range of all the s c licenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCLicenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s c licenses
	* @param end the upper bound of the range of s c licenses (not inclusive)
	* @return the range of s c licenses
	*/
	public static java.util.List<com.liferay.software.catalog.model.SCLicense> getSCLicenses(
		int start, int end) {
		return getService().getSCLicenses(start, end);
	}

	/**
	* Returns the number of s c licenses.
	*
	* @return the number of s c licenses
	*/
	public static int getSCLicensesCount() {
		return getService().getSCLicensesCount();
	}

	/**
	* Returns the productEntryIds of the s c product entries associated with the s c license.
	*
	* @param licenseId the licenseId of the s c license
	* @return long[] the productEntryIds of s c product entries associated with the s c license
	*/
	public static long[] getSCProductEntryPrimaryKeys(long licenseId) {
		return getService().getSCProductEntryPrimaryKeys(licenseId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCLicense> getSCProductEntrySCLicenses(
		long productEntryId) {
		return getService().getSCProductEntrySCLicenses(productEntryId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCLicense> getSCProductEntrySCLicenses(
		long productEntryId, int start, int end) {
		return getService()
				   .getSCProductEntrySCLicenses(productEntryId, start, end);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCLicense> getSCProductEntrySCLicenses(
		long productEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.software.catalog.model.SCLicense> orderByComparator) {
		return getService()
				   .getSCProductEntrySCLicenses(productEntryId, start, end,
			orderByComparator);
	}

	public static int getSCProductEntrySCLicensesCount(long productEntryId) {
		return getService().getSCProductEntrySCLicensesCount(productEntryId);
	}

	public static boolean hasSCProductEntrySCLicense(long productEntryId,
		long licenseId) {
		return getService().hasSCProductEntrySCLicense(productEntryId, licenseId);
	}

	public static boolean hasSCProductEntrySCLicenses(long productEntryId) {
		return getService().hasSCProductEntrySCLicenses(productEntryId);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void setSCProductEntrySCLicenses(long productEntryId,
		long[] licenseIds) {
		getService().setSCProductEntrySCLicenses(productEntryId, licenseIds);
	}

	/**
	* Updates the s c license in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scLicense the s c license
	* @return the s c license that was updated
	*/
	public static com.liferay.software.catalog.model.SCLicense updateSCLicense(
		com.liferay.software.catalog.model.SCLicense scLicense) {
		return getService().updateSCLicense(scLicense);
	}

	public static SCLicenseLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(SCLicenseLocalService service) {
	}

	private static ServiceTracker<SCLicenseLocalService, SCLicenseLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SCLicenseLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<SCLicenseLocalService, SCLicenseLocalService>(bundle.getBundleContext(),
				SCLicenseLocalService.class, null);

		_serviceTracker.open();
	}
}