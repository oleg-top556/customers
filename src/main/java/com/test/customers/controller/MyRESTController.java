package com.test.customers.controller;

import com.test.customers.entity.Customer;
import com.test.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final CustomerService customerService;


    @Autowired
    public MyRESTController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> showAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id ){
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> addNewCustomer(@Valid @RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }


    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id ){
        customerService.deleteCustomer(id);
        return "Employee with ID = " + id + " was deleted";

    }


}
