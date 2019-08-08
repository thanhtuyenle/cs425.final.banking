package edu.mum.cs.cs425.banking.bankingmanagement.model;

import edu.mum.cs.cs425.banking.bankingmanagement.model.validators.UniqueCustomerNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name ="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    //@UniqueAccountNumber
    @NotBlank(message = "*Account Number is required")
    @Column(name="accountNumber", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name="balance", nullable = false)
    private Double balance;



    public Account(){

    }
    public Account(@NotBlank(message = "*Customer Number is required") Long accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountRepository{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
