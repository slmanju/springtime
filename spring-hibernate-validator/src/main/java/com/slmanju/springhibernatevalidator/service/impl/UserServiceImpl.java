package com.slmanju.springhibernatevalidator.service.impl;

import com.slmanju.springhibernatevalidator.service.UserService;
import com.slmanju.springhibernatevalidator.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final Validator validator;

    public UserServiceImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void save(UserDto userDto) {
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        if (!violations.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<UserDto> constraintViolation : violations) {
                stringBuilder.append(constraintViolation.getMessage()).append(" ");
            }
            throw new ConstraintViolationException("Error occurred: " + stringBuilder.toString(), violations);
        }
        System.out.println("All good");
    }

}
