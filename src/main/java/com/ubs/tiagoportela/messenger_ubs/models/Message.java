package com.ubs.tiagoportela.messenger_ubs.models;

import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Message {

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

    public Message() {}
    public Message(String test, String test1, String test2, MessageType test3) {
        sender = test;
        receiver = test1;
        value = test2;
        type = test3;
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
