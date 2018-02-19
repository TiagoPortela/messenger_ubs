package com.ubs.tiagoportela.messenger_ubs.models;

import com.ubs.tiagoportela.messenger_ubs.constraints.ValidEmailAddress;

import javax.persistence.Entity;

@Entity
@ValidEmailAddress
public class EmailMessage extends Message {

    private static final String TO_STRING_FORMAT = "EMAIL: [Sender: %s, Receiver: %s, Value: %s, Type: %s]";

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, this.getSender(), this.getReceiver(), this.getValue(), this.getType().getDescription());
    }
}
