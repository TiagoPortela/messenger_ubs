package com.ubs.tiagoportela.messenger_ubs.constraints;

import com.ubs.tiagoportela.messenger_ubs.validators.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PhoneNumberValidator.class})
public @interface ValidPhoneNumber {

    String message() default "{com.ubs.tiagoportela.messenger_ubs.constraints.ValidPhoneNumber.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
