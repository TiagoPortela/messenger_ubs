package com.ubs.tiagoportela.messenger_ubs.main.rest;

import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
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

@RestController
public class MessengerUbsRestService {

    @Autowired
    private MessageRepository messageRepository;

    private final Logger logger = LoggerFactory.getLogger(MessengerUbsRestService.class);

    @PostMapping("/sendMessage")
    public ResponseEntity<Message> sendMessage(@RequestBody @Valid Message message, HttpServletRequest request) {
        logger.info("Incoming message sending request from " + request.getRemoteAddr());
        logger.info("Message: " + message);
        messageRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/fetchAllSentMessages")
    public ResponseEntity<Message> fetchAllSentMessages() {
        logger.info("Testing #############################");
        return new ResponseEntity<>(new Message("test", "test", "test", MessageType.SMS), HttpStatus.OK);
    }
}
