package com.liferay.portlet.social.service.impl;

import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.MainServletTestRule;
import com.liferay.portal.test.rule.SyntheticBundleRule;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestFeedEntry;
import com.liferay.portlet.social.model.SocialRequestSoap;
import com.liferay.portlet.social.model.impl.SocialRequestModelImpl;
import com.liferay.portlet.social.service.SocialRequestInterpreterLocalService;
import com.liferay.portlet.social.service.SocialRequestInterpreterLocalServiceUtil;
import com.liferay.portlet.social.service.impl.bundle.socialrequestinterpreterlocalserviceimpl.TestSocialRequestInterpreterImpl;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
public class SocialRequestInterpreterLocalServiceImplTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), MainServletTestRule.INSTANCE,
			new SyntheticBundleRule(
				"bundle.socialrequestinterpreterlocalserviceimpl"));

	@Test
	public void testInterpret() {
		System.out.println("testInterpret");

		ThemeDisplay themeDisplay = new ThemeDisplay();

		long classNameId = PortalUtil.getClassNameId(
			TestSocialRequestInterpreterImpl.class.getName());

		SocialRequestSoap soapModel = new SocialRequestSoap();
		soapModel.setClassNameId(classNameId);

		SocialRequest request = SocialRequestModelImpl.toModel(soapModel);

		SocialRequestInterpreterLocalService
			socialRequestInterpreterLocalService =
				SocialRequestInterpreterLocalServiceUtil.getService();

		SocialRequestFeedEntry socialRequestFeedEntry =
			socialRequestInterpreterLocalService.interpret(
				request, themeDisplay);

		Assert.assertNotNull(socialRequestFeedEntry);
	}

	@Test
	public void testProcessConfirmation() {

		System.out.println("testProcessConfirmation");

		ThemeDisplay themeDisplay = new ThemeDisplay();

		long classNameId = PortalUtil.getClassNameId(
			TestSocialRequestInterpreterImpl.class.getName());

		SocialRequestSoap soapModel = new SocialRequestSoap();
		soapModel.setClassNameId(classNameId);

		SocialRequest request = SocialRequestModelImpl.toModel(soapModel);

		SocialRequestInterpreterLocalService
		socialRequestInterpreterLocalService =
			SocialRequestInterpreterLocalServiceUtil.getService();

		socialRequestInterpreterLocalService.processConfirmation(
			request, themeDisplay);

		// TODO use AtomicReference/AtomicState to verify it worked

	}

	@Test
	public void testProcessRejection() {

		System.out.println("testProcessRejection");

		ThemeDisplay themeDisplay = new ThemeDisplay();

		long classNameId = PortalUtil.getClassNameId(
			TestSocialRequestInterpreterImpl.class.getName());

		SocialRequestSoap soapModel = new SocialRequestSoap();
		soapModel.setClassNameId(classNameId);

		SocialRequest request = SocialRequestModelImpl.toModel(soapModel);

		SocialRequestInterpreterLocalService
			socialRequestInterpreterLocalService =
				SocialRequestInterpreterLocalServiceUtil.getService();

		socialRequestInterpreterLocalService.processRejection(
			request, themeDisplay);

		// TODO use AtomicReference/AtomicState to verify it worked

	}

}