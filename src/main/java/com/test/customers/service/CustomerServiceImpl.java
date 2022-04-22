package com.test.customers.service;



import com.test.customers.DTO.CustomerDto;
import com.test.customers.RepositoryForEnity.CustomerRepository;
import com.test.customers.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> dtos = customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customer) {
        Optional<Customer> resultCustomer = customerRepository.findById(id);
        if (resultCustomer.isPresent()){
            resultCustomer.get().setId(customer.getId());
            resultCustomer.get().setFullName(customer.getFullName());
            resultCustomer.get().setEmail(customer.getEmail());
            resultCustomer.get().setPhone(customer.getPhone());

            return modelMapper.map(customerRepository.save(resultCustomer.get()),CustomerDto.class);
        }
        return null;

    }

    @Override
    public CustomerDto getCustomer(Long id) {

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()){
            return modelMapper.map(optional.get(),CustomerDto.class);
        }

        return null;
    }
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepository.save(customer),CustomerDto.class);
    }
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
