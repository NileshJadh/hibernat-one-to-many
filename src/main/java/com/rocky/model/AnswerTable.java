package com.rocky.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AnswerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Integer id;

    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionTable question;

	
	public AnswerTable() {
		
		System.out.println("Zero Param Constructor of Answer Table");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}



	@Override
	public String toString() {
		return "AnswerTable [id=" + id + ", answer=" + answer + "]";
	}

	public QuestionTable getQuestion() {
		return question;
	}

	public void setQuestion(QuestionTable question) {
		this.question = question;
	}
	
	
	
}
