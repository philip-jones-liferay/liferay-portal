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

package com.liferay.portal.security.sso.cas.portal.settings.web.portlet.action;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseFormMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsDescriptor;
import com.liferay.portal.kernel.settings.SettingsException;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.common.action.PortalSettingsBaseAuthenticationFormMVCActionCommand;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.security.sso.cas.constants.CASConstants;
import com.liferay.portal.settings.web.constants.PortalSettingsPortletKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortalSettingsPortletKeys.PORTAL_SETTINGS,
		"mvc.command.name=/portal_settings/edit_company_cas_configuration"
	},
	service = MVCActionCommand.class
)
public class PortalSettingsCASAuthenticationFormMVCActionCommand
	extends PortalSettingsBaseAuthenticationFormMVCActionCommand {

	@Override
	protected void doValidateForm(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		boolean casEnabled = ParamUtil.getBoolean(
			actionRequest, "cas--enabled");

		if (!casEnabled) {
			return;
		}

		String casLoginURL = ParamUtil.getString(
			actionRequest, "cas--loginURL");
		String casLogoutURL = ParamUtil.getString(
			actionRequest, "cas--logoutURL");
		String casServerName = ParamUtil.getString(
			actionRequest, "cas--serverName");
		String casServerURL = ParamUtil.getString(
			actionRequest, "cas--serverURL");
		String casServiceURL = ParamUtil.getString(
			actionRequest, "cas--serviceURL");
		String casNoSuchUserRedirectURL = ParamUtil.getString(
			actionRequest, "cas--noSuchUserRedirectURL");

		if (!Validator.isUrl(casLoginURL)) {
			SessionErrors.add(actionRequest, "casLoginURLInvalid");
		}

		if (!Validator.isUrl(casLogoutURL)) {
			SessionErrors.add(actionRequest, "casLogoutURLInvalid");
		}

		if (Validator.isNull(casServerName)) {
			SessionErrors.add(actionRequest, "casServerNameInvalid");
		}

		if (!Validator.isUrl(casServerURL)) {
			SessionErrors.add(actionRequest, "casServerURLInvalid");
		}

		if (Validator.isNotNull(casServiceURL) &&
			!Validator.isUrl(casServiceURL)) {

			SessionErrors.add(actionRequest, "casServiceURLInvalid");
		}

		if (Validator.isNotNull(casNoSuchUserRedirectURL) &&
			!Validator.isUrl(casNoSuchUserRedirectURL)) {

			SessionErrors.add(actionRequest, "casNoSuchUserURLInvalid");
		}
	}

	@Override
	protected String getServiceName() {
		return CASConstants.SERVICE_NAME;
	}

	@Override
	protected String getShortNamespace() {
		return "cas";
	}

}