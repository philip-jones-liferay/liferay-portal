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
 * Provides the local service utility for SCProductEntry. This utility wraps
 * {@link com.liferay.software.catalog.service.impl.SCProductEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SCProductEntryLocalService
 * @see com.liferay.software.catalog.service.base.SCProductEntryLocalServiceBaseImpl
 * @see com.liferay.software.catalog.service.impl.SCProductEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class SCProductEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.software.catalog.service.impl.SCProductEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addSCLicenseSCProductEntries(long licenseId,
		java.util.List<com.liferay.software.catalog.model.SCProductEntry> SCProductEntries) {
		getService().addSCLicenseSCProductEntries(licenseId, SCProductEntries);
	}

	public static void addSCLicenseSCProductEntries(long licenseId,
		long[] productEntryIds) {
		getService().addSCLicenseSCProductEntries(licenseId, productEntryIds);
	}

	public static void addSCLicenseSCProductEntry(long licenseId,
		long productEntryId) {
		getService().addSCLicenseSCProductEntry(licenseId, productEntryId);
	}

	public static void addSCLicenseSCProductEntry(long licenseId,
		com.liferay.software.catalog.model.SCProductEntry scProductEntry) {
		getService().addSCLicenseSCProductEntry(licenseId, scProductEntry);
	}

	/**
	* Adds the s c product entry to the database. Also notifies the appropriate model listeners.
	*
	* @param scProductEntry the s c product entry
	* @return the s c product entry that was added
	*/
	public static com.liferay.software.catalog.model.SCProductEntry addSCProductEntry(
		com.liferay.software.catalog.model.SCProductEntry scProductEntry) {
		return getService().addSCProductEntry(scProductEntry);
	}

	public static void clearSCLicenseSCProductEntries(long licenseId) {
		getService().clearSCLicenseSCProductEntries(licenseId);
	}

	/**
	* Creates a new s c product entry with the primary key. Does not add the s c product entry to the database.
	*
	* @param productEntryId the primary key for the new s c product entry
	* @return the new s c product entry
	*/
	public static com.liferay.software.catalog.model.SCProductEntry createSCProductEntry(
		long productEntryId) {
		return getService().createSCProductEntry(productEntryId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteSCLicenseSCProductEntries(long licenseId,
		java.util.List<com.liferay.software.catalog.model.SCProductEntry> SCProductEntries) {
		getService().deleteSCLicenseSCProductEntries(licenseId, SCProductEntries);
	}

	public static void deleteSCLicenseSCProductEntries(long licenseId,
		long[] productEntryIds) {
		getService().deleteSCLicenseSCProductEntries(licenseId, productEntryIds);
	}

	public static void deleteSCLicenseSCProductEntry(long licenseId,
		long productEntryId) {
		getService().deleteSCLicenseSCProductEntry(licenseId, productEntryId);
	}

	public static void deleteSCLicenseSCProductEntry(long licenseId,
		com.liferay.software.catalog.model.SCProductEntry scProductEntry) {
		getService().deleteSCLicenseSCProductEntry(licenseId, scProductEntry);
	}

	/**
	* Deletes the s c product entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productEntryId the primary key of the s c product entry
	* @return the s c product entry that was removed
	* @throws PortalException if a s c product entry with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCProductEntry deleteSCProductEntry(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSCProductEntry(productEntryId);
	}

	/**
	* Deletes the s c product entry from the database. Also notifies the appropriate model listeners.
	*
	* @param scProductEntry the s c product entry
	* @return the s c product entry that was removed
	*/
	public static com.liferay.software.catalog.model.SCProductEntry deleteSCProductEntry(
		com.liferay.software.catalog.model.SCProductEntry scProductEntry) {
		return getService().deleteSCProductEntry(scProductEntry);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.software.catalog.model.SCProductEntry fetchSCProductEntry(
		long productEntryId) {
		return getService().fetchSCProductEntry(productEntryId);
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
	* Returns the licenseIds of the s c licenses associated with the s c product entry.
	*
	* @param productEntryId the productEntryId of the s c product entry
	* @return long[] the licenseIds of s c licenses associated with the s c product entry
	*/
	public static long[] getSCLicensePrimaryKeys(long productEntryId) {
		return getService().getSCLicensePrimaryKeys(productEntryId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductEntry> getSCLicenseSCProductEntries(
		long licenseId) {
		return getService().getSCLicenseSCProductEntries(licenseId);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductEntry> getSCLicenseSCProductEntries(
		long licenseId, int start, int end) {
		return getService().getSCLicenseSCProductEntries(licenseId, start, end);
	}

	public static java.util.List<com.liferay.software.catalog.model.SCProductEntry> getSCLicenseSCProductEntries(
		long licenseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.software.catalog.model.SCProductEntry> orderByComparator) {
		return getService()
				   .getSCLicenseSCProductEntries(licenseId, start, end,
			orderByComparator);
	}

	public static int getSCLicenseSCProductEntriesCount(long licenseId) {
		return getService().getSCLicenseSCProductEntriesCount(licenseId);
	}

	/**
	* Returns a range of all the s c product entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.software.catalog.model.impl.SCProductEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s c product entries
	* @param end the upper bound of the range of s c product entries (not inclusive)
	* @return the range of s c product entries
	*/
	public static java.util.List<com.liferay.software.catalog.model.SCProductEntry> getSCProductEntries(
		int start, int end) {
		return getService().getSCProductEntries(start, end);
	}

	/**
	* Returns the number of s c product entries.
	*
	* @return the number of s c product entries
	*/
	public static int getSCProductEntriesCount() {
		return getService().getSCProductEntriesCount();
	}

	/**
	* Returns the s c product entry with the primary key.
	*
	* @param productEntryId the primary key of the s c product entry
	* @return the s c product entry
	* @throws PortalException if a s c product entry with the primary key could not be found
	*/
	public static com.liferay.software.catalog.model.SCProductEntry getSCProductEntry(
		long productEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSCProductEntry(productEntryId);
	}

	public static boolean hasSCLicenseSCProductEntries(long licenseId) {
		return getService().hasSCLicenseSCProductEntries(licenseId);
	}

	public static boolean hasSCLicenseSCProductEntry(long licenseId,
		long productEntryId) {
		return getService().hasSCLicenseSCProductEntry(licenseId, productEntryId);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void setSCLicenseSCProductEntries(long licenseId,
		long[] productEntryIds) {
		getService().setSCLicenseSCProductEntries(licenseId, productEntryIds);
	}

	/**
	* Updates the s c product entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scProductEntry the s c product entry
	* @return the s c product entry that was updated
	*/
	public static com.liferay.software.catalog.model.SCProductEntry updateSCProductEntry(
		com.liferay.software.catalog.model.SCProductEntry scProductEntry) {
		return getService().updateSCProductEntry(scProductEntry);
	}

	public static SCProductEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(SCProductEntryLocalService service) {
	}

	private static ServiceTracker<SCProductEntryLocalService, SCProductEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SCProductEntryLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<SCProductEntryLocalService, SCProductEntryLocalService>(bundle.getBundleContext(),
				SCProductEntryLocalService.class, null);

		_serviceTracker.open();
	}
}