package com.test.customers.service;



import com.test.customers.DTO.CustomerDto;
import com.test.customers.RepositoryForEnity.CustomerRepository;
import com.test.customers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> resultCustomer = customerRepository.findById(id);
        if (resultCustomer.isPresent()){
            resultCustomer.get().setId(customer.getId());
            resultCustomer.get().setCreated(customer.getCreated());
            resultCustomer.get().setUpdated(customer.getUpdated());
            resultCustomer.get().setFullName(customer.getFullName());
            resultCustomer.get().setEmail(customer.getEmail());
            resultCustomer.get().setPhone(customer.getPhone());
            resultCustomer.get().setActive(customer.getActive());

            return customerRepository.save(resultCustomer.get());
        }
        return null;

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
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
