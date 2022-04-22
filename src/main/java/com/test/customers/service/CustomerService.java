package com.test.customers.service;


import com.test.customers.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public void deleteCustomer(Long id);

}
