package com.koi.springmvc.dao;

import com.koi.springmvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers(int sortField);
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
    public List<Customer> searchCustomer(String keyword);
}
