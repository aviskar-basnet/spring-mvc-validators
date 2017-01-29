package com.aviskar.sample.validator.custom.local;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("StudentValidator :: Validation Started");
		Student student = (Student) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.student.name");
		if (student.getAge() < 1 || student.getAge() > 150) {
			errors.rejectValue("age", "Range.student.age");
		}
		System.out.println("StudentValidator :: Validation Completed");
	}
}
