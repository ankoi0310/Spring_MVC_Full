package com.koi.springmvc.service;

import com.koi.springmvc.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
}
