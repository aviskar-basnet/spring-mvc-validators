package com.aviskar.sample.validator.detected.global;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DetectedGlobalWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DetectedGlobalConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/detected-global/*" };
	}

	@Override
	protected String getServletName() {
		return "detected-global-dispatcher";
	}
}
