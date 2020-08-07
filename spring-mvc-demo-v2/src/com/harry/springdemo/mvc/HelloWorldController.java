package com.harry.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}

	@RequestMapping("/processFormV2")
	public String processFormV2(HttpServletRequest request, Model model) {
		System.out.println(request.getQueryString());

		System.out.println(request.getContextPath());

		String name = request.getParameter("name");

		model.addAttribute("message", "Yo! " + name);

		return "process-form";
	}

	@RequestMapping("/processFormV3")
	public String processFormV3(@RequestParam("name") String name, Model model) {

		model.addAttribute("message", "Yo from v3! " + name);

		return "process-form";
	}
}
