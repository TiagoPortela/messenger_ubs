package com.ubs.tiagoportela.messenger_ubs.main.rest;

import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
import com.ubs.tiagoportela.messenger_ubs.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(MessengerUbsRestService.class);

    @PostMapping("/sendMessage")
    public ResponseEntity<Message> sendMessage(@RequestBody @Valid Message message, HttpServletRequest request) {
        logger.info("Incoming message sending request from " + request.getRemoteAddr());
        logger.info("Message: " + message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/fetchAllSentMessages")
    public ResponseEntity<Message> fetchAllSentMessages() {
        logger.info("Testing #############################");
        return new ResponseEntity<>(new Message("test", "test", "test", MessageType.SMS), HttpStatus.OK);
    }
}
