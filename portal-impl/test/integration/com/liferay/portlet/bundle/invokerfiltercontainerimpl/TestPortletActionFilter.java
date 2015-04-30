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
package com.liferay.portlet.bundle.invokerfiltercontainerimpl;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.model.PortletApp;
import com.liferay.portal.model.PortletFilter;

/**
 * @author Philip Jones
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=testPortletActionFilter",
			"layout.type=testPortletActionFilter",
			"service.ranking:Integer=" + Integer.MAX_VALUE
		}
)
public class TestPortletActionFilter implements PortletFilter, ActionFilter {

	@Override
	public String getFilterClass() {
		return null;
	}

	@Override
	public String getFilterName() {
		return null;
	}

	@Override
	public Map<String, String> getInitParams() {
		return null;
	}

	@Override
	public Set<String> getLifecycles() {
		return null;
	}

	@Override
	public PortletApp getPortletApp() {
		return null;
	}

	@Override
	public void setFilterClass(String filterClass) {
		return;
	}

	@Override
	public void setFilterName(String filterName) {
		return;
	}

	@Override
	public void setInitParams(Map<String, String> initParams) {
		return;
	}

	@Override
	public void setLifecycles(Set<String> lifecycles) {
		return;
	}

	@Override
	public void setPortletApp(PortletApp portletApp) {
		return;
	}

	@Override
	public void destroy() {
		return;		
	}

	@Override
	public void init(FilterConfig arg0) throws PortletException {
		return;		
	}

	@Override
	public void doFilter(ActionRequest arg0, ActionResponse arg1,
			FilterChain arg2) throws IOException, PortletException {
		return;		
	}

}