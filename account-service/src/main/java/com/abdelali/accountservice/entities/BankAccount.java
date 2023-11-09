package com.abdelali.accountservice.entities;

import com.abdelali.accountservice.enums.AccountType;
import com.abdelali.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient //pour ignorer l'attribut customer car il n'existe pas dans la BDD de ce MS
    private Customer customer; //cette class n'est pas une entité JPA mais c'est un model
    private Long customerId;

}
