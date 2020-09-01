package com.harry.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harry.springdemo.entity.Customer;
import com.harry.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomer(Model model) {

	List<Customer> customers = customerService.getCustomers();

	model.addAttribute("customers", customers);

	return "listing-customer";
    }

    @GetMapping("/addCustomerForm")
    public String showAddCustomerForm(Model model) {

	model.addAttribute("customer", new Customer());

	return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("dsa") Customer customer) {

	customerService.saveCustomer(customer);

	return "redirect:/customer/list";
    }

    @GetMapping("showFormForUpdate")
    public String showUpdateCustomerForm(@RequestParam("customerId") int id, Model model) {

	Customer customer = customerService.getCustomer(id);

	model.addAttribute("customer", customer);

	return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {

	customerService.deleteCustomer(id);

	return "redirect:/customer/list";
    }
}
