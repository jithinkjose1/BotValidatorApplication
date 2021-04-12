package com.exercise.BotValidator.service;

import java.util.Date;

public class Question {
	
	private Integer id;
	
	private String question;
	
	private Integer answer;
	
	private String userId;
	
	private Date createdDate;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Question(Integer id, String question, Integer answer, String userId, Date createdDate) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.userId = userId;
		this.createdDate = createdDate;
	}
	
}
