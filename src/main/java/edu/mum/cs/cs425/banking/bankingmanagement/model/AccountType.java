package edu.mum.cs.cs425.banking.bankingmanagement.model;

import edu.mum.cs.cs425.banking.bankingmanagement.model.validators.UniqueCustomerNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name ="accounttypes")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountTypeId;

    @NotBlank(message = "*Account Type Name is required")
    @Column(name="accountTypeName", nullable = false)
    private String accountTypeName;

    public AccountType(){

    }

    public AccountType(@NotBlank(message = "*Account Type Name is required") String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
