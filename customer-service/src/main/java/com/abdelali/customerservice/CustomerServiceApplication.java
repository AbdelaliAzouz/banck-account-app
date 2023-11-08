package com.abdelali.customerservice;

import com.abdelali.customerservice.entities.Customer;
import com.abdelali.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customerList=List.of(
					Customer.builder()
							.firstname("ahmed")
							.lastname("Azouz")
							.email("Hassn@gmail.com")
							.build(),
					Customer.builder()
							.firstname("abdelali")
							.lastname("Azouz")
							.email("abdelali@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}



}
