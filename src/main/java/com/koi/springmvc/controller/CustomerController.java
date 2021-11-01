package com.koi.springmvc.controller;

import com.koi.springmvc.dao.CustomerDAO;
import com.koi.springmvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomer(Model model) {
        List<Customer> customers = customerDAO.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
