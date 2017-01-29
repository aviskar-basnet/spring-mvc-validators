package com.aviskar.sample.validator.custom.global.with.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class GenericCustomValidatorForBeanExample extends LocalValidatorFactoryBean {

	@Override
	public boolean supports(Class<?> clazz) {
		return super.supports(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("GenericCustomValidatorForBeanExample :: Validation Started");
		super.validate(target, errors);
		System.out.println("GenericCustomValidatorForBeanExample :: Validation Completed");
	}
	
	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		System.out.println("GenericCustomValidatorForBeanExample :: Validation Started");
		super.validate(target, errors, validationHints);
		System.out.println("GenericCustomValidatorForBeanExample :: Validation Completed");
	}
}
