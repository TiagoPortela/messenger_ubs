package com.ubs.tiagoportela.messenger_ubs.models;

import org.hibernate.validator.constraints.NotEmpty;

public class Message {

    @NotEmpty
    private String sender;

    @NotEmpty
    private String receiver;

    @NotEmpty
    private String value;

    @NotEmpty
    private String type;

    public Message() {}
    public Message(String test, String test1, String test2, String test3) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
