package com.ubs.tiagoportela.messenger_ubs.main;

import com.ubs.tiagoportela.messenger_ubs.repositories.MessageRepositoryTest;
import com.ubs.tiagoportela.messenger_ubs.rest.MessengerUbsRestServiceTest;
import com.ubs.tiagoportela.messenger_ubs.services.SimpleMessageServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		MessageRepositoryTest.class,
		SimpleMessageServiceTest.class,
		MessengerUbsRestServiceTest.class
})
public class MessengerUbsApplicationTests {}
