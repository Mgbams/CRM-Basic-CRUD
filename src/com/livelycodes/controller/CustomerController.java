package com.livelycodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livelycodes.business.Customer;
import com.livelycodes.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add the customers to the modal
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
