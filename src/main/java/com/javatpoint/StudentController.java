package com.javatpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class StudentController {
	@RequestMapping("/bookingForm")
	public String bookingForm(Model model) {
		Student res = new Student();
		model.addAttribute("student", res);
		return "reservation-page";
	}

	@RequestMapping("/submitForm")
	public String submitForm(@ModelAttribute("student") Student res) {

		System.out.println(
				"Hello: " + res.getFirstName() + " " + res.getLastName() + " Country Name: " + res.getCountryOptions());
		return "confirmation-form";
	}
}
