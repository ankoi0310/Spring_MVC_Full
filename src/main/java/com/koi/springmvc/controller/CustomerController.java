package com.koi.springmvc.controller;

import com.koi.springmvc.entity.Customer;
import com.koi.springmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomer(Model model) {
        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // Create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);

        // Redirect from controller to another URL in controller
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        // Get customer from Database
        Customer customer = customerService.getCustomer(id);

        // Bind data to model
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id, Model model) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("keyword") String keyword, Model model) {
        List<Customer> customers = customerService.searchCustomer(keyword);
        model.addAttribute("customers", customers);
        return "list-customers";
    }
}
