package com.ubs.tiagoportela.messenger_ubs.services;

import com.ubs.tiagoportela.messenger_ubs.models.Message;
import com.ubs.tiagoportela.messenger_ubs.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleMessageSender implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(SimpleMessageSender.class);

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Optional<Boolean> sendMessage(Message message) {
        try{
            messageRepository.save(message);
            logger.info("Sent Message: " + message);
        } catch (Exception ex) {
            return Optional.empty();
        }

        return Optional.of(true);
    }

    @Override
    public Optional<List<Message>> getAllSentMessages() {
        List<Message> fetchedMessages = new ArrayList<>();
        messageRepository.findAll().forEach(m -> {
            fetchedMessages.add(m);
        });

        logger.info("Fetched Messages: " + fetchedMessages);

        return Optional.of(fetchedMessages);
    }
}
