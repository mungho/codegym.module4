package org.example.form_validation.validation;
import org.example.form_validation.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        if(!user.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            errors.rejectValue("email", "email.invalid", "Email is invalid");
        }
        if(!user.getPhoneNumber().matches("^[0-9]{10}$")) {
            errors.rejectValue("phoneNumber", "phone.invalid", "Phone number is invalid");
        }
    }
}
