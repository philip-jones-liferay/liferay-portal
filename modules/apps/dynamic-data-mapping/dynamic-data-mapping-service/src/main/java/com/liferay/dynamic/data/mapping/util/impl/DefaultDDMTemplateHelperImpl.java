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

package com.liferay.dynamic.data.mapping.util.impl;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMTemplateConstants;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.dynamic.data.mapping.util.DefaultDDMTemplateHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Philip Jones
 */
@Component(immediate = true)
public class DefaultDDMTemplateHelperImpl implements DefaultDDMTemplateHelper {

	@Override
	public void addDDMTemplates(
			long userId, long groupId, ServiceContext serviceContext)
		throws Exception {

		List<TemplateHandler> templateHandlers =
			TemplateHandlerRegistryUtil.getTemplateHandlers();

		for (TemplateHandler templateHandler : templateHandlers) {
			long classNameId = PortalUtil.getClassNameId(
				templateHandler.getClassName());

			List<Element> templateElements =
				templateHandler.getDefaultTemplateElements();

			for (Element templateElement : templateElements) {
				String templateKey = templateElement.elementText(
					"template-key");

				DDMTemplate ddmTemplate =
					DDMTemplateLocalServiceUtil.fetchTemplate(
						groupId, classNameId, templateKey);

				if (ddmTemplate != null) {
					continue;
				}

				String name = templateElement.elementText("name");
				String description = templateElement.elementText("description");
				String language = templateElement.elementText("language");

				Class<?> clazz = templateHandler.getClass();

				ClassLoader classLoader = clazz.getClassLoader();

				String scriptFileName = templateElement.elementText(
					"script-file");

				String script = StringUtil.read(classLoader, scriptFileName);

				boolean cacheable = GetterUtil.getBoolean(
					templateElement.elementText("cacheable"));

				addDDMTemplate(
					userId, groupId, classNameId, templateKey, name,
					description, language, script, cacheable, serviceContext);
			}
		}
	}

	protected void addDDMTemplate(
			long userId, long groupId, long classNameId, String templateKey,
			String name, String description, String language, String script,
			boolean cacheable, ServiceContext serviceContext)
		throws PortalException {

		DDMTemplate ddmTemplate = DDMTemplateLocalServiceUtil.fetchTemplate(
			groupId, classNameId, templateKey);

		if (ddmTemplate != null) {
			return;
		}

		Map<Locale, String> nameMap = new HashMap<>();

		Locale locale = PortalUtil.getSiteDefaultLocale(groupId);

		nameMap.put(locale, LanguageUtil.get(locale, name));

		Map<Locale, String> descriptionMap = new HashMap<>();

		descriptionMap.put(locale, LanguageUtil.get(locale, description));

		long classPK = 0;

		long resourceClassNameId = PortalUtil.getClassNameId(
			_PORTLET_DISPLAY_TEMPLATE_CLASS_NAME);

		boolean smallImage = false; // false is correct value
		String smallImageURL = StringPool.BLANK; // null is correct value
		java.io.File smallImageFile = null; // null is correct value

		DDMTemplateLocalServiceUtil.addTemplate(
			userId, groupId, classNameId, classPK, resourceClassNameId,
			templateKey, nameMap, descriptionMap,
			DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY,
			DDMTemplateConstants.TEMPLATE_MODE_CREATE, language, script,
			cacheable, smallImage, smallImageURL, smallImageFile,
			serviceContext);
	}

	private static final String _PORTLET_DISPLAY_TEMPLATE_CLASS_NAME =
		"com.liferay.portlet.display.template.PortletDisplayTemplate";

}