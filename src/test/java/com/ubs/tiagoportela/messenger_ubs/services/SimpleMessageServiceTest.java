package com.ubs.tiagoportela.messenger_ubs.services;

import com.ubs.tiagoportela.messenger_ubs.main.MessengerUbsApplication;
import com.ubs.tiagoportela.messenger_ubs.main.MessengerUbsApplicationTests;
import com.ubs.tiagoportela.messenger_ubs.models.Message;
import com.ubs.tiagoportela.messenger_ubs.repositories.MessageRepository;
import com.ubs.tiagoportela.messenger_ubs.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MessengerUbsApplication.class })
public class SimpleMessageServiceTest extends MessengerUbsApplicationTests {

    @Autowired
    private MessageService messageService;

    @MockBean
    private MessageRepository messageRepository;

    @Test
    public void testSendingValidMessage() {
        Message email = TestUtils.createValidEmailMessage();
        when(messageRepository.save(email)).thenReturn(email);
        Optional<Boolean> result = messageService.sendMessage(email);

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isTrue();
    }

    @Test
    public void testFetchingMessages() {
        Message email = TestUtils.createValidEmailMessage();
        when(messageRepository.findAll()).thenReturn(Arrays.asList(email));
        Optional<List<Message>> result = messageService.getAllSentMessages();

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().isEmpty()).isFalse();
        assertThat(result.get().get(0)).isNotNull();
    }
}
