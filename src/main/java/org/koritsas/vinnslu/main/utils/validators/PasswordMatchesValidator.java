package org.koritsas.vinnslu.main.utils.validators;

import org.koritsas.vinnslu.main.ws.dto.security.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        UserDTO UserDto = (UserDTO) value;

        return UserDto.getPassword().equals(UserDto.getMatchingPassword());

    }
}
