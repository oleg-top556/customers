package com.test.customers.RepositoryForEnity;


import com.test.customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
