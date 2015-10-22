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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.search.Document" %><%@
page import="com.liferay.portal.kernel.search.DocumentComparator" %><%@
page import="com.liferay.portal.kernel.search.Field" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.model.*" %><%@
page import="com.liferay.portal.model.impl.*" %><%@
page import="com.liferay.portal.plugin.PluginPackageUtil" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.service.*" %><%@
page import="com.liferay.portal.service.permission.PortalPermissionUtil" %><%@
page import="com.liferay.portal.util.PortalUtil" %><%@
page import="com.liferay.portal.util.PortletKeys" %><%@
page import="com.liferay.portal.util.PropsValues" %><%@
page import="com.liferay.portal.util.WebKeys" %><%@
page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %><%@
page import="com.liferay.portlet.PortalPreferences" %><%@
page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %><%@
page import="com.liferay.portlet.PortletURLUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.DuplicateProductEntryModuleIdException" %><%@
page import="com.liferay.portlet.softwarecatalog.DuplicateProductVersionDirectDownloadURLException" %><%@
page import="com.liferay.portlet.softwarecatalog.FrameworkVersionNameException" %><%@
page import="com.liferay.portlet.softwarecatalog.LicenseNameException" %><%@
page import="com.liferay.portlet.softwarecatalog.NoSuchFrameworkVersionException" %><%@
page import="com.liferay.portlet.softwarecatalog.NoSuchLicenseException" %><%@
page import="com.liferay.portlet.softwarecatalog.NoSuchProductEntryException" %><%@
page import="com.liferay.portlet.softwarecatalog.NoSuchProductVersionException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryAuthorException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryLicenseException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryNameException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryPageURLException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryScreenshotsException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryShortDescriptionException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductEntryTypeException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductVersionChangeLogException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductVersionDownloadURLException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductVersionFrameworkVersionException" %><%@
page import="com.liferay.portlet.softwarecatalog.ProductVersionNameException" %><%@
page import="com.liferay.portlet.softwarecatalog.RequiredLicenseException" %><%@
page import="com.liferay.portlet.softwarecatalog.UnavailableProductVersionDirectDownloadURLException" %><%@
page import="com.liferay.portlet.softwarecatalog.model.SCFrameworkVersion" %><%@
page import="com.liferay.portlet.softwarecatalog.model.SCLicense" %><%@
page import="com.liferay.portlet.softwarecatalog.model.SCProductEntry" %><%@
page import="com.liferay.portlet.softwarecatalog.model.SCProductScreenshot" %><%@
page import="com.liferay.portlet.softwarecatalog.model.SCProductVersion" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionLocalServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCLicenseLocalServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCProductEntryLocalServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCProductScreenshotLocalServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.SCProductVersionServiceUtil" %><%@
page import="com.liferay.portlet.softwarecatalog.service.permission.SCFrameworkVersionPermission" %><%@
page import="com.liferay.portlet.softwarecatalog.service.permission.SCLicensePermission" %><%@
page import="com.liferay.portlet.softwarecatalog.service.permission.SCPermission" %><%@
page import="com.liferay.portlet.softwarecatalog.service.permission.SCProductEntryPermission" %><%@
page import="com.liferay.portlet.softwarecatalog.util.SCUtil" %><%@
page import="com.liferay.software.catalog.web.constants.SoftwareCatalogWebKeys" %><%@
page import="com.liferay.taglib.search.ResultRow" %><%@
page import="com.liferay.taglib.search.SearchEntry" %><%@
page import="com.liferay.taglib.search.TextSearchEntry" %>

<%@ page import="java.text.Format" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.List" %><%@
page import="java.util.Map" %><%@
page import="java.util.Set" %>

<%@ page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
WindowState windowState = liferayPortletRequest.getWindowState();

PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);

String currentURL = currentURLObj.toString();

PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>

<%@ include file="/init-ext.jsp" %>