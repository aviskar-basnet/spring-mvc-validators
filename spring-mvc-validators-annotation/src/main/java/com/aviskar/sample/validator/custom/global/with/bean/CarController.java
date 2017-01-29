package com.aviskar.sample.validator.custom.global.with.bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {

	@RequestMapping(path = "/car", method = RequestMethod.GET)
	public String addCar(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "addCar";
	}

	@RequestMapping(path = "/car", method = RequestMethod.POST)
	public String viewCar(@ModelAttribute("car") @Validated Car car, BindingResult result) {
		if (result.hasErrors()) {
			return "addCar";
		}
		return "viewCar";
	}
}
