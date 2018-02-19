package com.ubs.tiagoportela.messenger_ubs.services;

import com.ubs.tiagoportela.messenger_ubs.models.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    Optional<Boolean> sendMessage(Message message);

    Optional<List<Message>> getAllSentMessages();
}
