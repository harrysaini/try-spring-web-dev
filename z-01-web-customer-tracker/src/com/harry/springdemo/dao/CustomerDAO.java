package com.harry.springdemo.dao;

import java.util.List;

import com.harry.springdemo.entity.Customer;

public interface CustomerDAO {

    public List<Customer> getCustomersList();

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomer(int id);
}
