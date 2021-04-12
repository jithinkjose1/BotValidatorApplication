package com.exercise.BotValidator.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.BotValidator.repository.BotValidatorRepository;
import com.exercise.BotValidator.request.BotValidatorRequest;
import com.exercise.BotValidator.response.BotValidatorResponse;

@Service
public class BotValidatorService implements IBotValidatorService {
	
	@Autowired
	private BotValidatorRepository botValidatorRepository;

	@Override
	public BotValidatorResponse getBotValidatorQuestion(String userName) {
		Question question = getNewQuestion(userName);
		
		botValidatorRepository.save(question);

		BotValidatorResponse response = new BotValidatorResponse();
		response.setQuestion(question.getQuestion());
		response.setId(question.getId());
		return response;
	}

	
	@Override
	public boolean validateBotValidatorQuestion(BotValidatorRequest request, String userName) {
		String question = request.getQuestion();
		Integer id = request.getId();
		Integer answer = request.getAnswer();

		if (question != null && !question.isEmpty()) {
			Question qn = botValidatorRepository.getQuestionById(id);
			if(null != qn && qn.getUserId().equals(userName) && qn.getQuestion().equals(question) && qn.getAnswer().equals(answer)) {
				botValidatorRepository.deleteQuestionById(id);	
				return true;
			}
		}
		return false;
	}
	
	private Question getNewQuestion(String userName) {
		List<Integer> randomList = generateRandomList();
		
		String question = "Please sum the numbers " + randomList.stream().map(String::valueOf)
		        .collect(Collectors.joining(","));
		
		Integer answer = randomList.stream().mapToInt(Integer::intValue).sum();
		
		Integer qnId = botValidatorRepository.getNewId();
		Date createdDate = java.util.Calendar.getInstance().getTime();

		return new Question(qnId, question, answer, userName, createdDate);
	}

	private List<Integer> generateRandomList() {
		
		Random random = new Random();
		List<Integer> randomList = new ArrayList<Integer>();
		randomList.add(random.nextInt(100));
		randomList.add(random.nextInt(100));
		randomList.add(random.nextInt(100));

		return randomList;
	}

}
