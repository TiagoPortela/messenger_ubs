package com.ubs.tiagoportela.messenger_ubs.rest;

import com.ubs.tiagoportela.messenger_ubs.main.MessengerUbsApplication;
import com.ubs.tiagoportela.messenger_ubs.main.MessengerUbsApplicationTests;
import com.ubs.tiagoportela.messenger_ubs.repositories.MessageRepository;
import com.ubs.tiagoportela.messenger_ubs.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = { MessengerUbsApplication.class }
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-it.properties")
public class MessengerUbsRestServiceTest extends MessengerUbsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testFetchAllSentMessagesRestSuccess() throws Exception {
        messageRepository.save(TestUtils.createValidEmailMessage());

        mockMvc.perform(get("/fetchAllSentMessages")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((jsonPath("$[0].sender", is("test@test.com"))));

    }

    @Test
    public void testSendMessageRestSuccess() throws Exception {
        mockMvc.perform(post("/sendMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.asJsonString(TestUtils.createValidEmailMessage())))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendMessageRestInvalidEmail() throws Exception {
        mockMvc.perform(post("/sendMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.asJsonString(TestUtils.createInvalidEmailMessage())))
                .andExpect(status().is(400));
    }

    @Test
    public void testSendMessageRestInvalidSms() throws Exception {
        mockMvc.perform(post("/sendMessage")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.asJsonString(TestUtils.createInvalidSmsMessage())))
                .andExpect(status().is(400));
    }
}