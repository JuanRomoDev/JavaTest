package com.juanromodev.javatest.util;

import android.content.Context;

import com.juanromodev.javatest.data.local.QuestionBank;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Test;

public class TestUtils {

    public static Test createTest(Context context) {
        QuestionBank questionBank = QuestionBank.getInstance(context);
        return new Test(questionBank.getQuestionList());
    }

    public static int getCorrectAnswersCount(Test test) {
        int correctAnswers = 0;

        for (Answer answer : test.getAnswers()) {
            if (answer.isCorrect()) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    public static int gradeTest(Test test) {
        int correctAnswers = getCorrectAnswersCount(test);

        float grade = (float) correctAnswers / test.getQuestionCount() * 100;

        return Math.round(grade);
    }
}
