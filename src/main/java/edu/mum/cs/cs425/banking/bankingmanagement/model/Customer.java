package edu.mum.cs.cs425.banking.bankingmanagement.model;

import edu.mum.cs.cs425.banking.bankingmanagement.model.validators.UniqueCustomerNumber;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name ="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @UniqueCustomerNumber
    @NotBlank(message = "*Customer Number is required")
    @Column(name="customerNumber", nullable = false, unique = true)
    private String customerNumber;

    @NotBlank(message = "*First Name is required")
    @Column(name="firstName", nullable = false)
    private String firstName;

    private String middleName;

    @NotBlank(message = "*Last Name is required")
    @Column(name="lastName", nullable = false)
    private String lastName;

    @NotBlank(message = "*Email Address is required")
    @Column(name="emailAddress", nullable = false)
    private String emailAddress;

    @NotBlank(message = "*Contact Phone Number is required")
    @Column(name="contactPhoneNumber", nullable = false)
    private String contactPhoneNumber;

    @NotNull(message = "*Date of Birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Customer(){

    }

    public Customer(@NotBlank(message = "*Customer Number is required") String customerNumber, @NotBlank(message = "*First Name is required") String firstName, String middleName, @NotBlank(message = "*Last Name is required") String lastName, @NotBlank(message = "*Email Address is required") String emailAddress, @NotBlank(message = "*Contact Phone Number is required") String contactPhoneNumber, @NotNull(message = "*Date of Birth is required") LocalDate dateOfBirth) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactPhoneNumber = contactPhoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
