package edu.mum.cs.cs425.banking.bankingmanagement.repository;


import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // This interface definition relies on the public abstract methods
    // inherited from the super interface, CrudRepository<T, ID>
    // We may override any or add more methods here, if needed.
    Optional<Customer> findCustomerByCustomerNumber(String customerNumber);

//    @Query("Select s from Student s where s.firstName like %:firstName%")
//    Page<Customer> findCustomerByFirstName(String firstName, Pageable pageable);

    Page<Customer> findAllByCustomerNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrContactPhoneNumberContaining
            (String customerNumber, String firstName, String middleName, String lastName, String contactPhoneNumber, Pageable pageable);

    Page<Customer> findAllByContactPhoneNumberEquals(String phoneNumber, Pageable pageable);
    Page<Customer> findAllByDateOfBirthEquals(LocalDate dateOfBirth, Pageable pageable);
    Page<Customer> findAllByEmailAddressEquals(String email, Pageable pageable);

}
