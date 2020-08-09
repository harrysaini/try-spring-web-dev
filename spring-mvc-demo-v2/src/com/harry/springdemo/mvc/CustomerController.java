package com.harry.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.harry.springdemo.mvc.models.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("init binder called");

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		System.out.println("\n\n\n\n");

		System.out.println(customer);

		System.out.println(bindingResult);

		if (bindingResult.hasErrors()) {
			return "customer-form";
		}

		return "customer-conf";

	}
}
