package edu.mum.cs.cs425.banking.bankingmanagement.service;

import edu.mum.cs.cs425.banking.bankingmanagement.model.AccountType;
import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountTypeService {
    public abstract List<AccountType> getAllAccountTypes();

    public abstract AccountType saveAccountType(AccountType accountType);

    public abstract AccountType getAccountTypeById(Integer accountTypeId);

    public abstract void deleteAccountTypeById(Integer accountTypeId);
}
