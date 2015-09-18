package com.liferay.portal.settings.web.action;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.SettingsConfigurationAction;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.settings.GroupServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsDescriptor;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.cas.constants.CASConstants;
import com.liferay.portal.settings.web.constants.PortalSettingsPortletKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

@Component(
		property = {
			"javax.portlet.name=" + PortalSettingsPortletKeys.PORTAL_SETTINGS,
			"mvc.command.name=/portal_settings/edit_company_cas_configuration"
		},
		service = MVCActionCommand.class
	)
public class EditCASConfigurationMVCActionCommand extends BaseMVCActionCommand implements MVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		UnicodeProperties properties = PropertiesParamUtil.getProperties(actionRequest, _parameterNamePrefix);
				
		Settings settings = getSettings(actionRequest);		
		ModifiableSettings modifiableSettings = settings.getModifiableSettings();
		
		SettingsDescriptor settingsDescriptor =
				SettingsFactoryUtil.getSettingsDescriptor(_settingsId);

		for (String name : settingsDescriptor.getAllKeys()) {
			
			String propKey = mapConfigKeyToPropKey(name);
			
			String value = properties.getProperty(propKey);
			String oldValue = settings.getValue(name, null);

			if (!StringUtil.equalsIgnoreBreakLine(value, oldValue)) {
				modifiableSettings.setValue(propKey, value);
			}
		}
		
		modifiableSettings.store();
	}

	protected Settings getSettings(ActionRequest actionRequest) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return SettingsFactoryUtil.getSettings(
			new CompanyServiceSettingsLocator(
				themeDisplay.getCompanyId(), _settingsId));
	}
	
	
	protected void validateSettings(ActionRequest actionRequest) {
		String visibleNodes = getParameter(actionRequest, "visibleNodes");

		if (Validator.isNull(visibleNodes)) {
			SessionErrors.add(actionRequest, "visibleNodesCount");
		}
	}
	
	public String getParameter(PortletRequest portletRequest, String name) {
		name = _parameterNamePrefix + name + StringPool.DOUBLE_DASH;

		return ParamUtil.getString(portletRequest, name);
	}

	private static String mapConfigKeyToPropKey(String configKey) {
		
		StringBuffer sb = new StringBuffer();
		
		char prevConfigKeyChar = ' ';
		
		for (char configKeyChar : configKey.toCharArray()) {
			
			if (configKeyChar >= 'A' && configKeyChar <= 'Z') {				
				if (!(prevConfigKeyChar >= 'A' && prevConfigKeyChar <= 'Z')) {
					sb.append('.');
				}
			}			
			sb.append(Character.toLowerCase(configKeyChar));
			
			prevConfigKeyChar = configKeyChar;
		}
		return sb.toString();
	}
	
	private static final String _parameterNamePrefix = "auth.settings--cas.";
	private static final String _settingsId = "com.liferay.portal.security.sso.cas.module.configuration.CASConfiguration";
}
