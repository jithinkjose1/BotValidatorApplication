package com.exercise.BotValidator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exercise.BotValidator.request.BotValidatorRequest;
import com.exercise.BotValidator.response.BotValidatorResponse;
import com.exercise.BotValidator.service.IBotValidatorService;

@RestController
public class BotValidatorController {

	@Autowired
	private IBotValidatorService botValidatorService;

	@GetMapping("/botValidator")
	public ResponseEntity<BotValidatorResponse> getBotValidator(@RequestHeader("UserId") String userId) {
		try {
			BotValidatorResponse response = botValidatorService.getBotValidatorQuestion(userId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST", exc);
		}
	}

	@PostMapping("/botValidator")
	public ResponseEntity<String> postBotValidator(@RequestHeader("UserId") String userId, @RequestBody BotValidatorRequest request) {
		try {
			if (botValidatorService.validateBotValidatorQuestion(request,userId)) {
				return new ResponseEntity<>("Thats Great", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("That’s wrong. Please try again", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST", exc);
		}
	}

}
