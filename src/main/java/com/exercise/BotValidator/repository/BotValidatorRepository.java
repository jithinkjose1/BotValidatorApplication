package com.exercise.BotValidator.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.exercise.BotValidator.service.Question;

@Repository
public class BotValidatorRepository {

	private static Map<Integer, Question> botValidatorQnRepo = new ConcurrentHashMap<>();
	private static int id = 1;
	
	public static synchronized Integer createID()
	{
	    return id++;
	}
	
	static {
		botValidatorQnRepo.put(1, new Question(null, null, null, null, null));
	}

	public int getCount() {
		return botValidatorQnRepo.size();
	}

	public void save(Question question) {
		botValidatorQnRepo.put(question.getId(), question);
	}

	public Question getQuestionById(Integer id) {
		return botValidatorQnRepo.get(id);
	}
	
	public void deleteQuestionById(Integer id) {
		if(! botValidatorQnRepo.isEmpty()) {
			botValidatorQnRepo.remove(id);
		}
	}

	public Integer getNewId() {
		return createID();
	}

}
