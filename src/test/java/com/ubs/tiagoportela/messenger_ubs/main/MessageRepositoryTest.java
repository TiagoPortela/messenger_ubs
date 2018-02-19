package com.ubs.tiagoportela.messenger_ubs.main;

import com.ubs.tiagoportela.messenger_ubs.enums.MessageType;
import com.ubs.tiagoportela.messenger_ubs.models.EmailMessage;
import com.ubs.tiagoportela.messenger_ubs.models.Message;
import com.ubs.tiagoportela.messenger_ubs.repositories.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MessengerUbsApplication.class })
@DataJpaTest
public class MessageRepositoryTest extends MessengerUbsApplicationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testMessagePersistence() {
        // given
        Message email = new EmailMessage();
        email.setSender("test@test.com");
        email.setReceiver("test@test.com");
        email.setType(MessageType.EMAIL);
        email.setValue("Test message");

        entityManager.persist(email);
        entityManager.flush();

        // when
        Message persistedEmail = messageRepository.findAll().iterator().next();

        // then
        assertThat(persistedEmail).isEqualTo(email);
    }
}
