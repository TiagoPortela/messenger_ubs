package com.ubs.tiagoportela.messenger_ubs.collections;

import com.ubs.tiagoportela.messenger_ubs.models.Message;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class MessageList {

    @Valid
    private List<Message> messages;

    public MessageList() {
        this.messages = new ArrayList<Message>();
    }

    public MessageList(List<Message> trades) {
        this.messages = trades;
    }

	public List<Message> getTrades() {
		return messages;
	}

	public void setTrades(List<Message> trades) {
		this.messages = trades;
	}
}