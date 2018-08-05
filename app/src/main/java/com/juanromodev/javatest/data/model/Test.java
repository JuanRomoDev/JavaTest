package com.juanromodev.javatest.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private List<Question> questionList;
    private Map<Question, Answer> answerToQuestion = new HashMap<>();

    public Test(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Question getQuestion(int questionIndex) {
        return questionList.get(questionIndex);
    }

    public int getQuestionCount() {
        return questionList.size();
    }

    public void answerQuestion(Question question, Answer answer) {
        answerToQuestion.put(question, answer);
    }

    public int getGrade() {
        int correctAnswers = 0;
        for (Answer answer : answerToQuestion.values()) {
            if (answer != null && answer.isCorrect()) {
                correctAnswers++;
            }
        }

        float grade = (float) correctAnswers / questionList.size() * 100;

        return Math.round(grade);
    }
}