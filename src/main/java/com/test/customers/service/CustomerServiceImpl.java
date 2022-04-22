package com.test.customers.service;



import com.test.customers.RepositoryForEnity.CustomerRepository;
import com.test.customers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()){
            customer=optional.get();
        }

        return customer;
    }
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
