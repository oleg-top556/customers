package com.test.customers.service;


import com.test.customers.DTO.CustomerDto;

import java.util.List;

public interface CustomerService {
    public List<CustomerDto> getAllCustomers();

    public CustomerDto saveCustomer(CustomerDto customer);

    public CustomerDto updateCustomer(Long id, CustomerDto customer);

    public CustomerDto getCustomer(Long id);

    public void deleteCustomer(Long id);

}
