package com.slmanju.springhibernatevalidator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

//import javax.validation.Validation;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator localValidatorFactoryBean() {
//        javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return new LocalValidatorFactoryBean();
    }

}
