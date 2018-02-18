package com.ubs.tiagoportela.messenger_ubs.enums;

public enum MessageType {
    EMAIL(1, "e-mail"),
    SMS(2, "text message");

    private final int id;
    private final String description;

    MessageType(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
