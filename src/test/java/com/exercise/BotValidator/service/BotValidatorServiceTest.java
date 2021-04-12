package com.exercise.BotValidator.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.exercise.BotValidator.repository.BotValidatorRepository;
import com.exercise.BotValidator.request.BotValidatorRequest;
import com.exercise.BotValidator.response.BotValidatorResponse;

@SpringBootTest
class BotValidatorServiceTest {

	@Mock
	private BotValidatorRepository botValidatorRepositoryMock;
	
	@InjectMocks
	private BotValidatorService botValidatorService;

	@Test
	void testGetValidatorQuestion() {
		
		when(botValidatorRepositoryMock.getCount()).thenReturn(5);
		doNothing().when(botValidatorRepositoryMock).save(any(Question.class));

		BotValidatorResponse response = botValidatorService.getBotValidatorQuestion("user1");
		assertNotNull(response);
		assertNotNull(response.getQuestion());
		assertFalse(response.getQuestion().isEmpty());
	}
	
	@Test
	void testBotValidatorQuestionValidationSuccess() {
		BotValidatorRequest request = new BotValidatorRequest();
		request.setQuestion("Please sum the numbers 9,5,3 ");
		request.setId(1);
		request.setAnswer(17);
		
		Question qn = new Question(1, "Please sum the numbers 9,5,3 ", 17, "user1", java.util.Calendar.getInstance().getTime());

		when(botValidatorRepositoryMock.getQuestionById(any(Integer.class))).thenReturn(qn);
		doNothing().when(botValidatorRepositoryMock).deleteQuestionById(any(Integer.class));
		
		boolean isValid = botValidatorService.validateBotValidatorQuestion(request, "user1");
		assertTrue(isValid);
	}

	@Test
	void testBotValidatorQuestionValidationFailure() {
		BotValidatorRequest request = new BotValidatorRequest();
		request.setQuestion("Please sum the numbers 9,5,3 ");
		request.setAnswer(10);
		
		Question qn = new Question(1, "Please sum the numbers 9,5,3 ", 10, "user1", java.util.Calendar.getInstance().getTime());
		
		when(botValidatorRepositoryMock.getQuestionById(any(Integer.class))).thenReturn(qn);
		doNothing().when(botValidatorRepositoryMock).deleteQuestionById(any(Integer.class));

		boolean isValid = botValidatorService.validateBotValidatorQuestion(request, "user1");
		assertFalse(isValid);
	}

}

