package com.test.customers.controller;

import com.test.customers.DTO.CustomerDto;
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
    public List<CustomerDto> showAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id ){
        CustomerDto customerDto = customerService.getCustomer(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> addNewCustomer(@Valid @RequestBody CustomerDto customer){
        CustomerDto resultCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(resultCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable("id") Long id,
                                                      @RequestBody CustomerDto customer){
        CustomerDto resultCustomer = customerService.updateCustomer(id,customer);
        return ResponseEntity.ok(resultCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id ){
        customerService.deleteCustomer(id);
        return "Customer with ID = " + id + " was deleted, but in DB he is ";

    }


}
