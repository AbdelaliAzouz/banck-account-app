package com.abdelali.accountservice;

import com.abdelali.accountservice.clients.CustomerRestClient;
import com.abdelali.accountservice.entities.BankAccount;
import com.abdelali.accountservice.enums.AccountType;
import com.abdelali.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
		return args -> {
			//Créer deux comptes pour chaque Customer
			customerRestClient.allCustomers().forEach(c->{
			BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(Math.random()*98000)
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(c.getId())
					.build();
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(Math.random()*8000)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(c.getId())
					.build();
			accountRepository.save(bankAccount1);
			accountRepository.save(bankAccount2);
			});
		};
	}

}
