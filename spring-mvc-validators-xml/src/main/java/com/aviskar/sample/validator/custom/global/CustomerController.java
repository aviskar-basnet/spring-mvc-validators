package com.aviskar.sample.validator.custom.global;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	@RequestMapping(path = "/customer", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public String viewCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		}
		return "viewCustomer";
	}
}
