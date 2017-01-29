package com.aviskar.sample.validator.custom.global.with.bean;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomGlobalWithBeanWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { CustomGlobalWithBeanConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/custom-global-with-bean/*" };
	}

	@Override
	protected String getServletName() {
		return "custom-global-with-bean-dispatcher";
	}
}
