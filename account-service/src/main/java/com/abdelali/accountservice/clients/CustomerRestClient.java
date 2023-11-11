package com.abdelali.accountservice.clients;

import com.abdelali.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    //Cette annotation permet d'appeler la fonction getDefaultCustomer si le MS CUSTOMER-SERVICE est en panne
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstname("Not Vailable");
        customer.setLastname("Not Vailable");
        customer.setEmail("Not Vailable");
        return customer;
    }

    default List<Customer> getDefaultCustomers(Exception exception){
        return List.of();
    }
}

