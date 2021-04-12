package com.exercise.BotValidator.request;


import org.springframework.stereotype.Component;

@Component
public class BotValidatorRequest {

	private Integer id;
	
	private String question;

	private Integer answer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

}
