package com.juanromodev.javatest.util;

import android.content.Context;

import com.juanromodev.javatest.data.local.QuestionBank;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Question;
import com.juanromodev.javatest.data.model.Test;

import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static Test createTest(Context context) {
        QuestionBank questionBank = QuestionBank.getInstance(context);
        List<Question> questionList = questionBank.getQuestionList();

        Collections.shuffle(questionList);

        for (int i = 0; i < questionList.size(); i++) {
            questionList.get(i).setNumber(i + 1);
        }

        return new Test(questionBank.getQuestionList());
    }

    public static int countCorrectAnswers(Test test) {
        int correctAnswers = 0;

        for (Answer answer : test.getAnswers()) {
            if (answer.isCorrect()) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    public static int gradeTest(Test test) {
        int correctAnswers = countCorrectAnswers(test);

        float grade = (float) correctAnswers / test.getQuestionCount() * 100;

        return Math.round(grade);
    }
}
