package com.harry.springsecurity.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/customLogin")
    public String loginForm() {

	return "login-form";
    }
}
