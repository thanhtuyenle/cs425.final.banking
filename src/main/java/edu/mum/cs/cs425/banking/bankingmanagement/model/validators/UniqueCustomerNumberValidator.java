package edu.mum.cs.cs425.banking.bankingmanagement.model.validators;

import edu.mum.cs.cs425.banking.bankingmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCustomerNumberValidator implements ConstraintValidator<UniqueCustomerNumber, String> {

    private CustomerService customerService;

    public UniqueCustomerNumberValidator() {
    }

    @Autowired
    public UniqueCustomerNumberValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void initialize(UniqueCustomerNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String customerNumber, ConstraintValidatorContext context) {
        boolean valid;
        if (customerService != null) {
            valid = (customerNumber != null && !customerService.findByCustomerNumber(customerNumber).isPresent());
        } else {
            valid = true;
        }
        return valid;
    }
}
