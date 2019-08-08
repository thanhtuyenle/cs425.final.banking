package edu.mum.cs.cs425.banking.bankingmanagement.repository;

import edu.mum.cs.cs425.banking.bankingmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
