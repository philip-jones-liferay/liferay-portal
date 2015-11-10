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

package com.liferay.portal.security.sso.facebook.connect.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseFormMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsDescriptor;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.security.sso.facebook.connect.constants.FacebookConnectConstants;
import com.liferay.portal.settings.web.constants.PortalSettingsPortletKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 * @author Stian Sigvartsen
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortalSettingsPortletKeys.PORTAL_SETTINGS,
		"mvc.command.name=/portal_settings/edit_company_facebook_connect_configuration"
	},
	service = MVCActionCommand.class
)
public class PortalSettingsFacebookConnectAuthenticationFormMVCActionCommand
	extends BaseFormMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if (!permissionChecker.isCompanyAdmin(themeDisplay.getCompanyId())) {
			SessionErrors.add(actionRequest, PrincipalException.class);

			actionResponse.setRenderParameter("mvcPath", "/error.jsp");

			return;
		}

		Settings settings = SettingsFactoryUtil.getSettings(
			new CompanyServiceSettingsLocator(
				themeDisplay.getCompanyId(),
				FacebookConnectConstants.SERVICE_NAME));

		ModifiableSettings modifiableSettings =
			settings.getModifiableSettings();

		SettingsDescriptor settingsDescriptor =
			SettingsFactoryUtil.getSettingsDescriptor(
				FacebookConnectConstants.SERVICE_NAME);

		for (String name : settingsDescriptor.getAllKeys()) {
			String value = ParamUtil.getString(
				actionRequest, "facebook--" + name);
			String oldValue = settings.getValue(name, null);

			if (!value.equals(oldValue)) {
				modifiableSettings.setValue(name, value);
			}
		}

		modifiableSettings.store();
	}

	@Override
	protected void doValidateForm(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		boolean fbEnabled = ParamUtil.getBoolean(
			actionRequest, "facebook--enabled");

		if (!fbEnabled) {
			return;
		}

		String fbGraphURL = ParamUtil.getString(
			actionRequest, "facebook--graphURL");
		String fbOauthAuthURL = ParamUtil.getString(
			actionRequest, "facebook--oauthAuthURL");
		String fbOauthRedirectURL = ParamUtil.getString(
			actionRequest, "facebook--oauthRedirectURL");
		String fbOauthTokenURL = ParamUtil.getString(
			actionRequest, "facebook--oauthTokenURL");

		if (Validator.isNotNull(fbGraphURL) && !Validator.isUrl(fbGraphURL)) {
			SessionErrors.add(actionRequest, "facebookConnectGraphURLInvalid");
		}

		if (Validator.isNotNull(fbOauthAuthURL) &&
			!Validator.isUrl(fbOauthAuthURL)) {

			SessionErrors.add(
				actionRequest, "facebookConnectOauthAuthURLInvalid");
		}

		if (Validator.isNotNull(fbOauthRedirectURL) &&
			!Validator.isUrl(fbOauthRedirectURL)) {

			SessionErrors.add(
				actionRequest, "facebookConnectOauthRedirectURLInvalid");
		}

		if (Validator.isNotNull(fbOauthTokenURL) &&
			!Validator.isUrl(fbOauthTokenURL)) {

			SessionErrors.add(
				actionRequest, "facebookConnectOauthTokenURLInvalid");
		}
	}

}