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

package com.liferay.portlet.social.service.impl.bundle.socialrequestinterpreterlocalserviceimpl;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestFeedEntry;
import com.liferay.portlet.social.model.SocialRequestInterpreter;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceReference;
import com.liferay.registry.ServiceTrackerCustomizer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Component;

/**
 * @author Phil Jones
 */
@Component(
	immediate = true,
	property = {"service.ranking:Integer=" + Integer.MAX_VALUE}
)
public class TestSocialRequestInterpreterImpl
	implements SocialRequestInterpreter {

	public TestSocialRequestInterpreterImpl() {
		System.out.println("oh goodie.  a new one of me");
		_portletId = null;
		_requestInterpreter = null;

	}
	
	public TestSocialRequestInterpreterImpl(
			String portletId, SocialRequestInterpreter requestInterpreter) {

			_portletId = portletId;
			_requestInterpreter = requestInterpreter;

			String[] classNames = _requestInterpreter.getClassNames();

			for (String className : classNames) {
				_classNames.add(className);
			}
		}

	@Override
	public String[] getClassNames() {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public SocialRequestFeedEntry interpret(
		SocialRequest request, ThemeDisplay themeDisplay) {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean processConfirmation(
		SocialRequest request, ThemeDisplay themeDisplay) {

		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean processRejection(
		SocialRequest request, ThemeDisplay themeDisplay) {

		// TODO Auto-generated method stub

		return false;
	}

	private class SocialRequestInterpreterServiceTrackerCustomizer
	implements ServiceTrackerCustomizer
		<SocialRequestInterpreter, SocialRequestInterpreter> {

		private final List<SocialRequestInterpreter> _requestInterpreters =
			new CopyOnWriteArrayList<>();

		@Override
		public SocialRequestInterpreter addingService(
				ServiceReference<SocialRequestInterpreter> serviceReference) {

			Registry registry = RegistryUtil.getRegistry();

			SocialRequestInterpreter requestInterpreter = registry.getService(
				serviceReference);

			String portletId = (String)serviceReference.getProperty(
				"javax.portlet.name");

			if (!(requestInterpreter instanceof
					TestSocialRequestInterpreterImpl)) {
				requestInterpreter = new TestSocialRequestInterpreterImpl(
					portletId, requestInterpreter);
			}

			_requestInterpreters.add(requestInterpreter);

			return requestInterpreter;
		}

		@Override
		public void modifiedService(
				ServiceReference<SocialRequestInterpreter> serviceReference,
				SocialRequestInterpreter requestInterpreter) {
		}

		@Override
		public void removedService(
				ServiceReference<SocialRequestInterpreter> serviceReference,
				SocialRequestInterpreter requestInterpreter) {

			Registry registry = RegistryUtil.getRegistry();

			registry.ungetService(serviceReference);

			_requestInterpreters.remove(requestInterpreter);
		}
	}

	private final Set<String> _classNames = new HashSet<>();
	private final String _portletId;
	private final SocialRequestInterpreter _requestInterpreter;

}