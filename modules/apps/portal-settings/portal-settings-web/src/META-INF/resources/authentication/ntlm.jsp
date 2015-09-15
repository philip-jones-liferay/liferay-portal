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
<%@page import="com.liferay.portal.security.sso.ntlm.constants.NtlmConstants"%>
<%@page import="com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator"%>
<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationFactoryUtil" %>
<%@ page import="com.liferay.portal.security.sso.ntlm.module.configuration.NtlmConfiguration" %>

<%@ include file="/init.jsp" %>

<%
NtlmConfiguration ntlmConfiguration = ConfigurationFactoryUtil.getConfiguration(NtlmConfiguration.class, 
		new ParameterMapSettingsLocator(request.getParameterMap(), new CompanyServiceSettingsLocator(company.getCompanyId(), NtlmConstants.SERVICE_NAME)));

boolean ntlmAuthEnabled = ntlmConfiguration.enabled();
//PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.NTLM_AUTH_ENABLED, PropsValues.NTLM_AUTH_ENABLED);
		 
String ntlmDomainController = ntlmConfiguration.domainController();
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_DOMAIN_CONTROLLER, PropsValues.NTLM_DOMAIN_CONTROLLER);

String ntlmDomainControllerName = ntlmConfiguration.domainControllerName(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_DOMAIN_CONTROLLER_NAME, PropsValues.NTLM_DOMAIN_CONTROLLER_NAME);

String ntlmDomain = ntlmConfiguration.domain();
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_DOMAIN, PropsValues.NTLM_DOMAIN);

String ntlmNegotiationFlags = ntlmConfiguration.negotiateFlags();

String ntlmServiceAccount = ntlmConfiguration.serviceAccount(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_SERVICE_ACCOUNT, PropsValues.NTLM_SERVICE_ACCOUNT);

String ntlmServicePassword = ntlmConfiguration.servicePassword(); 
//PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.NTLM_SERVICE_PASSWORD, PropsValues.NTLM_SERVICE_PASSWORD);

if (Validator.isNotNull(ntlmServicePassword)) {
	ntlmServicePassword = Portal.TEMP_OBFUSCATION_VALUE;
}
%>

<aui:fieldset>
	<aui:input label="enabled" name='<%= "settings--" + PropsKeys.NTLM_AUTH_ENABLED + "--" %>' type="checkbox" value="<%= ntlmAuthEnabled %>" />

	<aui:input cssClass="lfr-input-text-container" label="domain-controller" name='<%= "settings--" + PropsKeys.NTLM_DOMAIN_CONTROLLER + "--" %>' type="text" value="<%= ntlmDomainController %>" />

	<aui:input cssClass="lfr-input-text-container" helpMessage="domain-controller-name-help" label="domain-controller-name" name='<%= "settings--" + PropsKeys.NTLM_DOMAIN_CONTROLLER_NAME + "--" %>' type="text" value="<%= ntlmDomainControllerName %>" />

	<aui:input cssClass="lfr-input-text-container" label="domain" name='<%= "settings--" + PropsKeys.NTLM_DOMAIN + "--" %>' type="text" value="<%= ntlmDomain %>" />
	
	<aui:input cssClass="lfr-input-text-container" label="negotiation-flags" name='<%= "settings--" + PropsKeys.NTLM_AUTH_NEGOTIATE_FLAGS + "--" %>' type="text" value="<%= ntlmNegotiationFlags %>" />

	<aui:input cssClass="lfr-input-text-container" label="service-account" name='<%= "settings--" + PropsKeys.NTLM_SERVICE_ACCOUNT + "--" %>' type="text" value="<%= ntlmServiceAccount %>" />

	<aui:input cssClass="lfr-input-text-container" label="service-password" name='<%= "settings--" + PropsKeys.NTLM_SERVICE_PASSWORD + "--" %>' type="password" value="<%= ntlmServicePassword %>" />
</aui:fieldset>