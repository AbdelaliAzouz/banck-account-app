package com.abdelali.accountservice;

import com.abdelali.accountservice.entities.BankAccount;
import com.abdelali.accountservice.enums.AccountType;
import com.abdelali.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
		return args -> {
			BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(98000)
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(56466)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();
			BankAccount bankAccount3 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("EUR")
					.balance(56466)
					.createdAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(3))
					.build();
			accountRepository.save(bankAccount1);
			accountRepository.save(bankAccount2);
			accountRepository.save(bankAccount3);
		};
	}

}
