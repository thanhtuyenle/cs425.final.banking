package edu.mum.cs.cs425.banking.bankingmanagement.service;


import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CustomerService {

    public abstract Iterable<Customer> getAllCustomers();

    public abstract Page<Customer> getAllCustomersPaged(int pageNo);

    public abstract Customer saveCustomer(Customer customer);

    public abstract Customer getCustomerById(Long customerId);

    public abstract void deleteCustomerById(Long customerId);

    public abstract Optional<Customer> findByCustomerNumber(String customerNumber);

    public abstract Page<Customer> searchCustomers(String searchString, int pageNo);

}
