package com.aviskar.sample.validator.custom.local;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomLocalWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { CustomLocalConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/custom-local/*" };
	}

	@Override
	protected String getServletName() {
		return "custom-local-dispatcher";
	}
}
