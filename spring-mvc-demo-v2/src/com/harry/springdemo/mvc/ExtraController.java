package com.harry.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtraController {

	@RequestMapping("/showForm")
	public String silly() {
		return "silly";
	}

}
