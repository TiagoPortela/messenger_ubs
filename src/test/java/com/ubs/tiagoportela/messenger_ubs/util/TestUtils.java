package com.ubs.tiagoportela.messenger_ubs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
import com.ubs.tiagoportela.messenger_ubs.models.EmailMessage;
import com.ubs.tiagoportela.messenger_ubs.models.Message;

public class TestUtils {

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Message createValidEmailMessage() {
        return newMessage("test@test.com", "test@test.com", MessageType.EMAIL);
    }

    public static Message createInvalidEmailMessage() {
        return newMessage("@test.com", "test@test.com", MessageType.EMAIL);
    }

    public static Message createValidSmsMessage() {
        return newMessage("(123) 123-123-123", "(123) 123-123-123", MessageType.SMS);
    }

    public static Message createInvalidSmsMessage() {
        return newMessage("123-123-123", "(123) 123-123-123", MessageType.SMS);
    }

    private static Message newMessage(String sender, String receiver, MessageType type) {
        Message email = new EmailMessage();
        email.setSender(sender);
        email.setReceiver(receiver);
        email.setType(type);
        email.setValue("Test message");
        return email;
    }
}
