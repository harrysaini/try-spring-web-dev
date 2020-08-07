package com.harry.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		Student s = new Student();

		s.setName("ram");

		model.addAttribute("student", s);

		model.addAttribute("countryOptions", Student.countryOptions);
		model.addAttribute("languageOptions", Student.languageOptions);
		model.addAttribute("osOptions", Student.osOptions);

		System.out.println(s);

		return "student-form";
	}

	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("student") Student student) {

		System.out.println(student);

		return "confirm-form";
	}
}
