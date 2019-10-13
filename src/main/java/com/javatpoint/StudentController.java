package com.javatpoint;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class StudentController {
	// add an initbinder.. to convert trim input strings
	// remove leading and trailing white spaces
	// resolve issue for validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);

	}

	@RequestMapping("/bookingForm")
	public String bookingForm(Model model) {
		Student res = new Student();
		model.addAttribute("student", res);
		return "reservation-page";
	}

	@RequestMapping("/submitForm")
	public String submitForm(@Valid @ModelAttribute("student") Student res, BindingResult theresult) {
		if (theresult.hasErrors()) {
			return "reservation-page";
		}
		System.out.println(
				"Hello: " + res.getFirstName() + " " + res.getLastName() + " Country Name: " + res.getCountryOptions());
		return "confirmation-form";
	}

}
