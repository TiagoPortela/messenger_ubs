package com.ubs.tiagoportela.messenger_ubs.rest;

import com.ubs.tiagoportela.messenger_ubs.models.Message;
import com.ubs.tiagoportela.messenger_ubs.services.MessageService;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class MessengerUbsRestService {
    private final Logger logger = LoggerFactory.getLogger(MessengerUbsRestService.class);

    @Autowired
    private MessageService messageService;

    @PostMapping("/sendMessage")
    public ResponseEntity<Message> sendMessage(@RequestBody @Valid Message message, HttpServletRequest request) {
        logger.info("Incoming message sending request from " + request.getRemoteAddr());
        Optional<Boolean> messageSuccessfullySent = messageService.sendMessage(message);

        if (messageSuccessfullySent.isPresent()) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        logger.error("Internal error while trying to send the following message: " + message);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/fetchAllSentMessages")
    public ResponseEntity<List<Message>> fetchAllSentMessages(HttpServletRequest request) {
        logger.info("Incoming message fetching request from " + request.getRemoteAddr());
        Optional<List<Message>> allSentMessages = messageService.getAllSentMessages();

        if (allSentMessages.isPresent()) {
            return new ResponseEntity<>(allSentMessages.get(), HttpStatus.OK);
        }

        logger.error("Internal error while trying to fetch all previously sent messages");
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
