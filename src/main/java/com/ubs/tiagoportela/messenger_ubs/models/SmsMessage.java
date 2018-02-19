package com.ubs.tiagoportela.messenger_ubs.models;

import com.ubs.tiagoportela.messenger_ubs.constraints.ValidPhoneNumber;

import javax.persistence.Entity;

@Entity
@ValidPhoneNumber
public class SmsMessage extends Message {

    private static final String TO_STRING_FORMAT = "SMS: [Sender: %s, Receiver: %s, Value: %s, Type: %s]";

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, this.getSender(), this.getReceiver(), this.getValue(), this.getType().getDescription());
    }
}
