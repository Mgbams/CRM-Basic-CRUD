package com.livelycodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.livelycodes.business.Customer;
import com.livelycodes.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// Get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// Add the customers to the modal
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer customer = new Customer();
		 theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/customerProcessForm")
	public String customerProcessForm(@ModelAttribute("customer") Customer customer) {
		
		
		//Save the customer using our service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") Long theId, Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomerById(theId);
		
		// set the customer as a model attribute
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("deleteId") Long theId) {
		
		// get the customer from our service
		customerService.deleteCustomerById(theId);
		
		// send over to the customer list page
		return "redirect:/customer/list";
	}
	

}
