package edu.mum.cs.cs425.banking.bankingmanagement.repository;

import edu.mum.cs.cs425.banking.bankingmanagement.model.AccountType;
import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
