package com.ubs.tiagoportela.messenger_ubs.main.rest;

import com.ubs.tiagoportela.messenger_ubs.models.Message;
import com.ubs.tiagoportela.messenger_ubs.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessengerUbsRestService {

    @Autowired
    private MessageRepository messageRepository;

    private final Logger logger = LoggerFactory.getLogger(MessengerUbsRestService.class);

    @PostMapping("/sendMessage")
    public ResponseEntity<Message> sendMessage(@RequestBody @Valid Message message, HttpServletRequest request) {
        logger.info("Incoming message sending request from " + request.getRemoteAddr());

        messageRepository.save(message);
        logger.info("Sent Message: " + message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/fetchAllSentMessages")
    public ResponseEntity<List<Message>> fetchAllSentMessages(HttpServletRequest request) {
        logger.info("Incoming message fetching request from " + request.getRemoteAddr());

        List<Message> fetchedMessages = new ArrayList<>();
        messageRepository.findAll().forEach(m -> {
            logger.info("Fetched Message: " + m.toString());
            fetchedMessages.add(m);
        });

        return new ResponseEntity<>(fetchedMessages, HttpStatus.OK);
    }
}
