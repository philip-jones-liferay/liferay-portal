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

package com.liferay.dynamic.data.mapping.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.events.AppStartupAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.CompanyLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Philip Jones
 */

@Component(
		immediate = true,
		property = {
			"key=application.startup.events"
		},
		service = LifecycleAction.class
	)
public class AddDefaultDDMTemplatesAction extends AppStartupAction {

	@Override
	public void run(String[] ids) {

		try {
			doRun(GetterUtil.getLong(ids[0]));
		}
		catch (Exception e) {
//			throw new ActionException(e);
		}
	}

	@Activate
	protected void activate() throws ActionException {
		Long companyId = CompanyThreadLocal.getCompanyId();

		try {
			List<Company> companies = _companyLocalService.getCompanies();

			for (Company company : companies) {
				CompanyThreadLocal.setCompanyId(company.getCompanyId());

				run(new String[] {String.valueOf(company.getCompanyId())});
			}
		}
		finally {
			CompanyThreadLocal.setCompanyId(companyId);
		}
	}

	protected void doRun(long companyId) throws Exception {
		
		return;

//		ServiceContext serviceContext = new ServiceContext();
//
//		serviceContext.setAddGuestPermissions(true);
//		serviceContext.setAddGroupPermissions(true);
//
//		Group group = _groupLocalService.getCompanyGroup(companyId);
//
//		serviceContext.setScopeGroupId(group.getGroupId());
//
//		long defaultUserId = _userLocalService.getDefaultUserId(companyId);
//
//		serviceContext.setUserId(defaultUserId);
//
//		Class<?> clazz = getClass();
//
//		_defaultDDMStructureHelper.addDDMStructures(
//			defaultUserId, group.getGroupId(),
//			PortalUtil.getClassNameId(JournalArticle.class),
//			clazz.getClassLoader(),
//			"com/liferay/journal/upgrade/v1_0_0/dependencies" +
//				"/basic-web-content-structure.xml",
//			serviceContext);
	}

	@Reference(unbind = "-")
	protected void setCompanyLocalService(
		CompanyLocalService companyLocalService) {

		_companyLocalService = companyLocalService;
	}

//	@Reference(unbind = "-")
//	protected void setDefaultDDMStructureHelper(
//		DefaultDDMStructureHelper defaultDDMStructureHelper) {
//
//		_defaultDDMStructureHelper = defaultDDMStructureHelper;
//	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	private static final Log _log = LogFactoryUtil.getLog(
			AddDefaultDDMTemplatesAction.class);

	private volatile CompanyLocalService _companyLocalService;
//	private volatile DefaultDDMStructureHelper _defaultDDMStructureHelper;
}