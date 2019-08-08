package edu.mum.cs.cs425.banking.bankingmanagement.service.impl;

import edu.mum.cs.cs425.banking.bankingmanagement.model.AccountType;
import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import edu.mum.cs.cs425.banking.bankingmanagement.repository.AccountTypeRepository;
import edu.mum.cs.cs425.banking.bankingmanagement.repository.CustomerRepository;
import edu.mum.cs.cs425.banking.bankingmanagement.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    @Autowired
    private AccountTypeRepository repository;

    @Override
    public List<AccountType> getAllAccountTypes() {
//        return ((List<Book>)repository.findAll())
//                .stream()
//                .sorted(Comparator.comparing(Book::getTitle))
//                .collect(Collectors.toList());
        return repository.findAll(Sort.by("accountTypeName"));
    }

    @Override
    public AccountType saveAccountType(AccountType accountType) {
        return repository.save(accountType);
    }

    @Override
    public AccountType getAccountTypeById(Integer accountTypeId) {
        return repository.findById(accountTypeId).orElse(null);
    }

    @Override
    public void deleteAccountTypeById(Integer accountTypeId) {
        repository.deleteById(accountTypeId);
    }
}
