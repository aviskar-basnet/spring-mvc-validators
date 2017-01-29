package com.aviskar.sample.validator.detected.global;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@RequestMapping(path = "/employee", method = RequestMethod.POST)
	public String viewEmployee(@ModelAttribute("employee") @Validated Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "addEmployee";
		}
		return "viewEmployee";
	}
}
