<%--
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
--%>

<%@page import="com.liferay.portal.kernel.settings.ParameterMapSettingsLocator"%>
<%@page import="com.liferay.portal.security.sso.opensso.constants.OpenSSOConstants"%>
<%@page import="com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator"%>
<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationFactoryUtil" %>
<%@ page import="com.liferay.portal.security.sso.opensso.module.configuration.OpenSSOConfiguration" %>

<%@ include file="/init.jsp" %>

<%
OpenSSOConfiguration openSSOConfiguration = ConfigurationFactoryUtil.getConfiguration(OpenSSOConfiguration.class, 
		new ParameterMapSettingsLocator(request.getParameterMap(), new CompanyServiceSettingsLocator(company.getCompanyId(), "com.liferay.portal.security.sso.opensso.module.configuration.OpenSSOConfiguration"))); //OpenSSOConstants.SERVICE_NAME)));

boolean openSsoAuthEnabled = openSSOConfiguration.enabled();
//PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.OPEN_SSO_AUTH_ENABLED, PropsValues.OPEN_SSO_AUTH_ENABLED);
		 
boolean openSsoLdapImportEnabled = openSSOConfiguration.importFromLDAP(); 
//PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.OPEN_SSO_LDAP_IMPORT_ENABLED, PropsValues.OPEN_SSO_LDAP_IMPORT_ENABLED);

String openSsoLoginURL = openSSOConfiguration.loginURL(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LOGIN_URL, PropsValues.OPEN_SSO_LOGIN_URL);

boolean openSsoLogoutOnSessionExpiration = openSSOConfiguration.logoutOnSessionExpiration();

String openSsoLogoutURL = openSSOConfiguration.logoutURL(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LOGOUT_URL, PropsValues.OPEN_SSO_LOGOUT_URL);

String openSsoServiceURL = openSSOConfiguration.serviceURL(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_SERVICE_URL, PropsValues.OPEN_SSO_SERVICE_URL);

String openSsoScreenNameAttr = openSSOConfiguration.screenNameAttr(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_SCREEN_NAME_ATTR, PropsValues.OPEN_SSO_SCREEN_NAME_ATTR);

String openSsoEmailAddressAttr = openSSOConfiguration.emailAddressAttr(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_EMAIL_ADDRESS_ATTR, PropsValues.OPEN_SSO_EMAIL_ADDRESS_ATTR);

String openSsoFirstNameAttr = openSSOConfiguration.firstNameAttr(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_FIRST_NAME_ATTR, PropsValues.OPEN_SSO_FIRST_NAME_ATTR);

String openSsoLastNameAttr = openSSOConfiguration.lastNameAttr(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.OPEN_SSO_LAST_NAME_ATTR, PropsValues.OPEN_SSO_LAST_NAME_ATTR);
%>

<aui:fieldset>
	<aui:input label="enabled" name='<%= "settings--" + PropsKeys.OPEN_SSO_AUTH_ENABLED + "--" %>' type="checkbox" value="<%= openSsoAuthEnabled %>" />

	<aui:input helpMessage="import-open-sso-users-from-ldap-help" label="import-open-sso-users-from-ldap" name='<%= "settings--" + PropsKeys.OPEN_SSO_LDAP_IMPORT_ENABLED + "--" %>' type="checkbox" value="<%= openSsoLdapImportEnabled %>" />

	<aui:input cssClass="lfr-input-text-container" helpMessage="login-url-for-opensso-help" label="login-url" name='<%= "settings--" + PropsKeys.OPEN_SSO_LOGIN_URL + "--" %>' type="text" value="<%= openSsoLoginURL %>" />

	<aui:input helpMessage="opensso-logout-on-session-expiration-help" label="opensso-logout-on-session-expiration" name='<%= "settings--" + PropsKeys.OPEN_SSO_LOGOUT_ON_SESSION_EXPIRATION + "--" %>' type="checkbox" value="<%= openSsoLogoutOnSessionExpiration %>" />

	<aui:input cssClass="lfr-input-text-container" helpMessage="logout-url-for-opensso-help" label="logout-url" name='<%= "settings--" + PropsKeys.OPEN_SSO_LOGOUT_URL + "--" %>' type="text" value="<%= openSsoLogoutURL %>" />

	<aui:input cssClass="lfr-input-text-container" helpMessage="service-url-for-opensso-help" label="service-url" name='<%= "settings--" + PropsKeys.OPEN_SSO_SERVICE_URL + "--" %>' type="text" value="<%= openSsoServiceURL %>" />

	<aui:input cssClass="lfr-input-text-container" helpMessage="mappings-for-opensso-help" label="screen-name-attribute" name='<%= "settings--" + PropsKeys.OPEN_SSO_SCREEN_NAME_ATTR + "--" %>' type="text" value="<%= openSsoScreenNameAttr %>" />

	<aui:input cssClass="lfr-input-text-container" label="email-address-attribute" name='<%= "settings--" + PropsKeys.OPEN_SSO_EMAIL_ADDRESS_ATTR + "--" %>' type="text" value="<%= openSsoEmailAddressAttr %>" />

	<%@ include file="/authentication/open_sso_user_name.jspf" %>

	<aui:button-row>

		<%
		String taglibOnClick = renderResponse.getNamespace() + "testOpenSSOSettings();";
		%>

		<aui:button onClick="<%= taglibOnClick %>" value="test-opensso-configuration" />
	</aui:button-row>
</aui:fieldset>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />testOpenSSOSettings',
		function() {
			var A = AUI();

			var data = {};

			data.<portlet:namespace />openSsoLoginURL = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_LOGIN_URL %>--'].value;
			data.<portlet:namespace />openSsoLogoutURL = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_LOGOUT_URL %>--'].value;
			data.<portlet:namespace />openSsoServiceURL = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_SERVICE_URL %>--'].value;
			data.<portlet:namespace />openSsoScreenNameAttr = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_SCREEN_NAME_ATTR %>--'].value;
			data.<portlet:namespace />openSsoEmailAddressAttr = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_EMAIL_ADDRESS_ATTR %>--'].value;
			data.<portlet:namespace />openSsoFirstNameAttr = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_FIRST_NAME_ATTR %>--'].value;
			data.<portlet:namespace />openSsoLastNameAttr = document.<portlet:namespace />fm['<portlet:namespace />settings--<%= PropsKeys.OPEN_SSO_LAST_NAME_ATTR %>--'].value;

			var url = '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="mvcRenderCommandName" value="/portal_settings/test_opensso_configuration" /></portlet:renderURL>';

			var dialog = Liferay.Util.Window.getWindow(
				{
					dialog: {
						destroyOnHide: true
					},
					title: '<%= UnicodeLanguageUtil.get(request, "open-sso") %>'
				}
			);

			dialog.plug(
				A.Plugin.IO,
				{
					data: data,
					uri: url
				}
			);
		},
		['aui-io-plugin-deprecated', 'aui-io-request', 'liferay-util-window']
	);
</aui:script>