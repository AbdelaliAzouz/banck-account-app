package com.abdelali.accountservice.clients;

import com.abdelali.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/*
Cette interface est similaire de celle qui existe dans repository,
la différence c'est que BankAccountRepository communique avec la BDD avec JPA,
et cette interface communique avec le MS CUSTOMER-SERVICE
 */
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    //While we call this method, openFeign will make an HTTP request to the CUSTOMER-SERVICE to get the customer by ID
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    List<Customer> allCustomers();
}

