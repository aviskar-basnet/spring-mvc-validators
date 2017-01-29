package com.aviskar.sample.validator.custom.global;

import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class GenericCustomValidator extends LocalValidatorFactoryBean {

	@Override
	public boolean supports(Class<?> clazz) {
		return super.supports(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("GenericCustomValidator :: Validation Started");
		super.validate(target, errors);
		System.out.println("GenericCustomValidator :: Validation Completed");
	}

	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		System.out.println("GenericCustomValidator :: Validation Started");
		super.validate(target, errors, validationHints);
		System.out.println("GenericCustomValidator :: Validation Completed");
	}
}
