package com.example.telusko.Quiz.Application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String questionText;
    private String[] options;
    private int correctOption;
    private String tech;

    // Constructors, getters, and setters

    public Question() {
    }

    public Question(String questionText, String[] options, int correctOption, String tech) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
        this.tech = tech;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public String getTech(){
        return this.tech;
    }

    public void setTech(String tech){
        this.tech = tech;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question ID: ").append(id).append("\n");
        sb.append("Question: ").append(questionText).append("\n");
        sb.append("Options:\n");
        for (int i = 0; i < options.length; i++) {
            sb.append(i + 1).append(". ").append(options[i]).append("\n");
        }
        sb.append("Correct Option: ").append(correctOption);
        return sb.toString();
    }


}

