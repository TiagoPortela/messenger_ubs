package com.ubs.tiagoportela.messenger_ubs.validators;

import com.ubs.tiagoportela.messenger_ubs.constraints.ValidPhoneNumber;
import com.ubs.tiagoportela.messenger_ubs.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PhoneNumberValidator extends PatternValidator implements ConstraintValidator<ValidPhoneNumber, Message> {

	private final Logger logger = LoggerFactory.getLogger(PhoneNumberValidator.class);

	private static final String PHONE_PATTERN = "\\(\\d{3}\\) \\d{3}-\\d{3}-\\d{3}";
	
	@Override
	public void initialize(ValidPhoneNumber constraint) {}

	@Override
	public boolean isValid(Message message, ConstraintValidatorContext context) {
		try {
            return this.validatePattern(PHONE_PATTERN, Arrays.asList(message.getSender(), message.getReceiver()));
		} catch (Exception exception) {
			logger.error(exception.getMessage());
			return false;
		}
	}
}
