package com.aviskar.sample.validator.custom.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	private StudentValidator studentValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(studentValidator);
	}

	@RequestMapping(path = "/student", method = RequestMethod.GET)
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addStudent";
	}

	@RequestMapping(path = "/student", method = RequestMethod.POST)
	public String viewStudent(@ModelAttribute("student") @Validated Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "addStudent";
		}
		return "viewStudent";
	}
}
