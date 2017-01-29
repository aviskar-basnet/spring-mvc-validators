package com.aviskar.sample.validator.custom.global.with.configurer;

import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class GenericCustomValidatorForConfigurerExample extends LocalValidatorFactoryBean {

	@Override
	public boolean supports(Class<?> clazz) {
		return super.supports(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("GenericCustomValidatorForConfigurerExample :: Validation Started");
		super.validate(target, errors);
		System.out.println("GenericCustomValidatorForConfigurerExample :: Validation Completed");
	}
	
	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		System.out.println("GenericCustomValidatorForConfigurerExample :: Validation Started");
		super.validate(target, errors, validationHints);
		System.out.println("GenericCustomValidatorForConfigurerExample :: Validation Completed");
	}
}
