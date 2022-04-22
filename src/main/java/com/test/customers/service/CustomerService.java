package com.test.customers.service;


import com.test.customers.DTO.CustomerDto;
import com.test.customers.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Long id, Customer customer);

    public Customer getCustomer(Long id);

    public void deleteCustomer(Long id);

}
