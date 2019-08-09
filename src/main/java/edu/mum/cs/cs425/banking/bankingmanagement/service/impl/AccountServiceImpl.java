package edu.mum.cs.cs425.banking.bankingmanagement.service.impl;


import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import edu.mum.cs.cs425.banking.bankingmanagement.repository.CustomerRepository;
import edu.mum.cs.cs425.banking.bankingmanagement.service.CustomerService;
import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

//@Service(value = "MainBookService")
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Iterable<Customer> getAllCustomers() {
//        return ((List<Book>)repository.findAll())
//                .stream()
//                .sorted(Comparator.comparing(Book::getTitle))
//                .collect(Collectors.toList());
        return repository.findAll(Sort.by("lastName"));
    }

    @Override
    public Page<Customer> getAllCustomersPaged(int pageNo) {
        return repository.findAll(PageRequest.of(pageNo, 3, Sort.by("lastName")));
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        return repository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return repository.findById(customerId).orElse(null);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public Optional<Customer> findByCustomerNumber(String customerNumber) {
        return repository.findCustomerByCustomerNumber(customerNumber);
    }

    @Override
    public Page<Customer> searchCustomers(String searchString, int pageNo) {

        if(isDate(searchString)) {
            return repository.findAllByDateOfBirthEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE), PageRequest.of(pageNo, 3, Sort.by("lastName")));
        }else if(isValidEmail(searchString)){
            return repository.findAllByEmailAddressEquals(searchString, PageRequest.of(pageNo, 3, Sort.by("lastName")));
        }
        else {
            return repository.findAllByCustomerNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrContactPhoneNumberContaining(searchString, searchString, searchString, searchString, searchString, PageRequest.of(pageNo, 3, Sort.by("lastName")));
        }


    }

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private boolean isCGPA(String searchString) {
        boolean isParseableAsMoney = false;
        try {

            Double.parseDouble(searchString);
            isParseableAsMoney = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsMoney = false;
            }
        }
        return isParseableAsMoney;
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

}
