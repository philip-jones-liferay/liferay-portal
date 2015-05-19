 /* Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.monitoring;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.PortalSessionContext;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Philip Jones
 */
public class MonitoringPortlet extends MVCPortlet {

	public void invalidateSession(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		String sessionId = ParamUtil.getString(actionRequest, "sessionId");

		HttpSession userSession = PortalSessionContext.get(sessionId);

		if (userSession != null) {
			try {
				if (!actionRequest.getPortletSession().getId().equals(
						sessionId)) {

					userSession.invalidate();
				}
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	private static final Log _log = 
		LogFactoryUtil.getLog(MonitoringPortlet.class);
}
