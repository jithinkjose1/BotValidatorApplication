package com.exercise.BotValidator.service;

import com.exercise.BotValidator.request.BotValidatorRequest;
import com.exercise.BotValidator.response.BotValidatorResponse;

public interface IBotValidatorService {

	public BotValidatorResponse getBotValidatorQuestion(String userName);

	public boolean validateBotValidatorQuestion(BotValidatorRequest request, String userName);

}
