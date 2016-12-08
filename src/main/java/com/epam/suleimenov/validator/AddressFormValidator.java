package com.epam.suleimenov.validator;


import com.epam.suleimenov.domain.Address;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

    @Component
    public class AddressFormValidator implements Validator {

        @Override
        public boolean supports(Class<?> aClass) {
            return Address.class.equals(aClass);
        }

        @Override
        public void validate(Object o, Errors errors) {

            Address address = (Address) o;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotNull.addressForm.city");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "NotNull.addressForm.state");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip_code", "NotNull.addressForm.zip_code");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotNull.addressForm.country");

        }
    }
