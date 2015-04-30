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
package com.liferay.portlet;

import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;
import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.impl.PortletAppImpl;
import com.liferay.portal.model.impl.PortletImpl;
import com.liferay.portal.servlet.MainServlet;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.MainServletTestRule;
import com.liferay.portal.test.rule.SyntheticBundleRule;
import com.liferay.portal.test.rule.callback.MainServletTestCallback;
import com.liferay.portlet.bundle.invokerfiltercontainerimpl.TestPortletActionFilter;

/**
 * @author Philip Jones
 */
public class InvokerFilterContainerImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
				new LiferayIntegrationTestRule(), MainServletTestRule.INSTANCE,
				new SyntheticBundleRule("bundle.invokerfiltercontainerimpl"));

	@Test
	public void testGetActionFilters() throws PortletException {
		
		System.out.println("testGetActionFilters");
		
		MainServlet mainServlet = MainServletTestCallback.getMainServlet();

		ServletContext servletContext = mainServlet.getServletContext();
		
		String servletContextName = servletContext.getServletContextName();

		PortletAppImpl portletAppImpl = new PortletAppImpl(servletContextName);
		portletAppImpl.setWARFile(false);
		
		Portlet portlet = new PortletImpl();
		portlet.setPortletClass("com.liferay.portlet.StrutsPortlet");
		portlet.setPortletId("testPortletFilter");
		portlet.setPortletApp(portletAppImpl);
		
		PortletContext portletContext = PortletContextFactory.create(portlet, servletContext);		

		InvokerFilterContainerImpl invokerFilterContainerImpl = 
			new InvokerFilterContainerImpl(portlet, portletContext);
		
		List<ActionFilter> actionFilters = 
			invokerFilterContainerImpl.getActionFilters();
		
		boolean found = false;
		for(ActionFilter actionFilter : actionFilters) {
			Class<?> clazz = actionFilter.getClass();
			if(TestPortletActionFilter.class.getName().equals(
				clazz.getName())) {
				found = true;
			}
		}
		
		Assert.assertTrue(found);

	}
	
	

	@Test
	public void testGetEventFilters() {
		System.out.println("testGetEventFilters");
	}

	@Test
	public void testGetRenderFilters() {
		System.out.println("testGetRenderFilters");
	}

	@Test
	public void testGetResourceFilters() {
		System.out.println("testGetResourceFilters");
	}

}