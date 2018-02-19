package com.ubs.tiagoportela.messenger_ubs.validators;

import com.ubs.tiagoportela.messenger_ubs.constraints.ValidEmailAddress;
import com.ubs.tiagoportela.messenger_ubs.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EmailAddressValidator extends PatternValidator implements ConstraintValidator<ValidEmailAddress, Message> {

	private final Logger logger = LoggerFactory.getLogger(EmailAddressValidator.class);

	private static final String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	@Override
	public void initialize(ValidEmailAddress constraint) {}

	@Override
	public boolean isValid(Message message, ConstraintValidatorContext context) {
		try {
            return this.validatePattern(EMAIL_PATTERN, Arrays.asList(message.getSender(), message.getReceiver()));
		} catch (Exception exception) {
			logger.error(exception.getMessage());
			return false;
		}
	}
}
