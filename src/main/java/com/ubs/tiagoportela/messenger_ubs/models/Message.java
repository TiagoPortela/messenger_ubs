package com.ubs.tiagoportela.messenger_ubs.models;

import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Message {

    private static final String TO_STRING_FORMAT = "[Sender: %s, Receiver: %s, Value: %s, Type: %s]";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String sender;

    @NotEmpty
    private String receiver;

    @NotEmpty
    private String value;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MessageType type;

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, sender, receiver, value, type.getDescription());
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
