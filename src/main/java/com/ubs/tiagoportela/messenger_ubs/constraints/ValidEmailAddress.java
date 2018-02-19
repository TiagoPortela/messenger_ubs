package com.ubs.tiagoportela.messenger_ubs.constraints;

import com.ubs.tiagoportela.messenger_ubs.validators.EmailAddressValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailAddressValidator.class})
public @interface ValidEmailAddress {

    String message() default "{com.ubs.tiagoportela.messenger_ubs.constraints.ValidEmailAddress.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
