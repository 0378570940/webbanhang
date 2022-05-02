package vn.t3h.class2109.dto.valid;

import vn.t3h.class2109.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualConstraintValidator implements
        ConstraintValidator<PasswordsEqualConstraint, Object> {

    @Override
    public void initialize(PasswordsEqualConstraint arg0) {
    }

    @Override
    public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
        UserDto user = (UserDto) candidate;
        return user.getPassword().equals(user.getRepassword());
    }
}
