package com.koi.springmvc.dao;

import com.koi.springmvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}