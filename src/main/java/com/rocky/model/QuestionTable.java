package com.rocky.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="question_Table")
public class QuestionTable {

	@Id
	@Column(name="question_id")
	private Integer id;
	
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List <AnswerTable> answerList;
	
	public QuestionTable() {
		
		System.out.println("Zero Parma Constructor of Question Table");
	}

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

	public List<AnswerTable> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<AnswerTable> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "QuestionTable [id=" + id + ", question=" + question + ", answerList=" + answerList + "]";
	}
	
	
}
