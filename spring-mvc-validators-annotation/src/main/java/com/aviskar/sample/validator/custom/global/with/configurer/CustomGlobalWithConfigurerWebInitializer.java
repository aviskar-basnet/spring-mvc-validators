package com.aviskar.sample.validator.custom.global.with.configurer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomGlobalWithConfigurerWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { CustomGlobalWithConfigurerConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/custom-global-with-configurer/*" };
	}

	@Override
	protected String getServletName() {
		return "custom-global-with-configurer-dispatcher";
	}
}
