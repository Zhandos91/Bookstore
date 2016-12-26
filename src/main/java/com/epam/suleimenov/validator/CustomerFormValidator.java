package com.epam.suleimenov.validator;

import com.epam.suleimenov.domain.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "NotNull.customerForm.first_name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "NotNull.customerForm.last_name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotNull.customerForm.phone");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotNull.customerForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotNull.customerForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm_password", "NotNull.customerForm.confirm_password");


        if(!(customer.getPassword().equals(customer.getConfirm_password()))){
            errors.rejectValue("confirm_password", "NotMatch.customerForm.confirm_password");
        }


    }
}
