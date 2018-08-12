package com.juanromodev.javatest.data.local;

import android.content.Context;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static QuestionBank questionBank;

    private Context context;

    private List<Question> questionList = new ArrayList<>();

    public static QuestionBank getInstance(Context context) {
        if (questionBank == null) {
            questionBank = new QuestionBank(context);
        }
        return questionBank;
    }

    private QuestionBank(Context context) {
        this.context = context.getApplicationContext();
        createQuestions();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    private void createQuestions() {
        Question question;

        // Question 1
        question = new Question(context,
                                R.string.question_1_code_snippet,
                                R.string.question_1_description,
                                new Answer(context, R.string.question_1_answer_1, R.bool.question_1_answer_1),
                                new Answer(context, R.string.question_1_answer_2, R.bool.question_1_answer_2)
        );
        questionList.add(question);

        // Question 2
        question = new Question(context,
                                R.string.question_2_code_snippet,
                                R.string.question_2_description,
                                new Answer(context, R.string.question_2_answer_1, R.bool.question_2_answer_1),
                                new Answer(context, R.string.question_2_answer_2, R.bool.question_2_answer_2),
                                new Answer(context, R.string.question_2_answer_3, R.bool.question_2_answer_3),
                                new Answer(context, R.string.question_2_answer_4, R.bool.question_2_answer_4)
        );
        questionList.add(question);

        // Question 3
        question = new Question(context,
                                R.string.question_3_code_snippet,
                                R.string.question_3_description,
                                new Answer(context, R.string.question_3_answer_1, R.bool.question_3_answer_1),
                                new Answer(context, R.string.question_3_answer_2, R.bool.question_3_answer_2),
                                new Answer(context, R.string.question_3_answer_3, R.bool.question_3_answer_3),
                                new Answer(context, R.string.question_3_answer_4, R.bool.question_3_answer_4)
        );
        questionList.add(question);

        // Question 4
        question = new Question(context,
                                R.string.question_4_code_snippet,
                                R.string.question_4_description,
                                new Answer(context, R.string.question_4_answer_1, R.bool.question_4_answer_1),
                                new Answer(context, R.string.question_4_answer_2, R.bool.question_4_answer_2),
                                new Answer(context, R.string.question_4_answer_3, R.bool.question_4_answer_3),
                                new Answer(context, R.string.question_4_answer_4, R.bool.question_4_answer_4)
        );
        questionList.add(question);

        // Question 5
        question = new Question(context,
                                R.string.question_5_code_snippet,
                                R.string.question_5_description,
                                new Answer(context, R.string.question_5_answer_1, R.bool.question_5_answer_1),
                                new Answer(context, R.string.question_5_answer_2, R.bool.question_5_answer_2),
                                new Answer(context, R.string.question_5_answer_3, R.bool.question_5_answer_3),
                                new Answer(context, R.string.question_5_answer_4, R.bool.question_5_answer_4)
        );
        questionList.add(question);

        // Question 6
        question = new Question(context,
                                R.string.question_6_code_snippet,
                                R.string.question_6_description,
                                new Answer(context, R.string.question_6_answer_1, R.bool.question_6_answer_1),
                                new Answer(context, R.string.question_6_answer_2, R.bool.question_6_answer_2)
        );
        questionList.add(question);

        // Question 7
        question = new Question(context,
                                R.string.question_7_code_snippet,
                                R.string.question_7_description,
                                new Answer(context, R.string.question_7_answer_1, R.bool.question_7_answer_1),
                                new Answer(context, R.string.question_7_answer_2, R.bool.question_7_answer_2),
                                new Answer(context, R.string.question_7_answer_3, R.bool.question_7_answer_3),
                                new Answer(context, R.string.question_7_answer_4, R.bool.question_7_answer_4)
        );
        questionList.add(question);

        // Question 8
        question = new Question(context,
                                R.string.question_8_code_snippet,
                                R.string.question_8_description,
                                new Answer(context, R.string.question_8_answer_1, R.bool.question_8_answer_1),
                                new Answer(context, R.string.question_8_answer_2, R.bool.question_8_answer_2),
                                new Answer(context, R.string.question_8_answer_3, R.bool.question_8_answer_3),
                                new Answer(context, R.string.question_8_answer_4, R.bool.question_8_answer_4)
        );
        questionList.add(question);

        // Question 9
        question = new Question(context,
                                R.string.question_9_code_snippet,
                                R.string.question_9_description,
                                new Answer(context, R.string.question_9_answer_1, R.bool.question_9_answer_1),
                                new Answer(context, R.string.question_9_answer_2, R.bool.question_9_answer_2),
                                new Answer(context, R.string.question_9_answer_3, R.bool.question_9_answer_3),
                                new Answer(context, R.string.question_9_answer_4, R.bool.question_9_answer_4)
        );
        questionList.add(question);

        // Question 10
        question = new Question(context,
                                R.string.question_10_code_snippet,
                                R.string.question_10_description,
                                new Answer(context, R.string.question_10_answer_1, R.bool.question_10_answer_1),
                                new Answer(context, R.string.question_10_answer_2, R.bool.question_10_answer_2),
                                new Answer(context, R.string.question_10_answer_3, R.bool.question_10_answer_3),
                                new Answer(context, R.string.question_10_answer_4, R.bool.question_10_answer_4)
        );
        questionList.add(question);

        // Question 11
        question = new Question(context,
                                R.string.question_11_code_snippet,
                                R.string.question_11_description,
                                new Answer(context, R.string.question_11_answer_1, R.bool.question_11_answer_1),
                                new Answer(context, R.string.question_11_answer_2, R.bool.question_11_answer_2),
                                new Answer(context, R.string.question_11_answer_3, R.bool.question_11_answer_3),
                                new Answer(context, R.string.question_11_answer_4, R.bool.question_11_answer_4)
        );
        questionList.add(question);

        // Question 12
        question = new Question(context,
                                R.string.question_12_code_snippet,
                                R.string.question_12_description,
                                new Answer(context, R.string.question_12_answer_1, R.bool.question_12_answer_1),
                                new Answer(context, R.string.question_12_answer_2, R.bool.question_12_answer_2),
                                new Answer(context, R.string.question_12_answer_3, R.bool.question_12_answer_3),
                                new Answer(context, R.string.question_12_answer_4, R.bool.question_12_answer_4)
        );
        questionList.add(question);

        // Question 13
        question = new Question(context,
                                R.string.question_13_code_snippet,
                                R.string.question_13_description,
                                new Answer(context, R.string.question_13_answer_1, R.bool.question_13_answer_1),
                                new Answer(context, R.string.question_13_answer_2, R.bool.question_13_answer_2),
                                new Answer(context, R.string.question_13_answer_3, R.bool.question_13_answer_3),
                                new Answer(context, R.string.question_13_answer_4, R.bool.question_13_answer_4)
        );
        questionList.add(question);

        // Question 14
        question = new Question(context,
                                R.string.question_14_code_snippet,
                                R.string.question_14_description,
                                new Answer(context, R.string.question_14_answer_1, R.bool.question_14_answer_1),
                                new Answer(context, R.string.question_14_answer_2, R.bool.question_14_answer_2),
                                new Answer(context, R.string.question_14_answer_3, R.bool.question_14_answer_3),
                                new Answer(context, R.string.question_14_answer_4, R.bool.question_14_answer_4)
        );
        questionList.add(question);

        // Question 15
        question = new Question(context,
                                R.string.question_15_code_snippet,
                                R.string.question_15_description,
                                new Answer(context, R.string.question_15_answer_1, R.bool.question_15_answer_1),
                                new Answer(context, R.string.question_15_answer_2, R.bool.question_15_answer_2),
                                new Answer(context, R.string.question_15_answer_3, R.bool.question_15_answer_3),
                                new Answer(context, R.string.question_15_answer_4, R.bool.question_15_answer_4)
        );
        questionList.add(question);

        // Question 16
        question = new Question(context,
                                R.string.question_16_code_snippet,
                                R.string.question_16_description,
                                new Answer(context, R.string.question_16_answer_1, R.bool.question_16_answer_1),
                                new Answer(context, R.string.question_16_answer_2, R.bool.question_16_answer_2),
                                new Answer(context, R.string.question_16_answer_3, R.bool.question_16_answer_3),
                                new Answer(context, R.string.question_16_answer_4, R.bool.question_16_answer_4),
                                new Answer(context, R.string.question_16_answer_5, R.bool.question_16_answer_5)
        );
        questionList.add(question);

        // Question 17
        question = new Question(context,
                                R.string.question_17_code_snippet,
                                R.string.question_17_description,
                                new Answer(context, R.string.question_17_answer_1, R.bool.question_17_answer_1),
                                new Answer(context, R.string.question_17_answer_2, R.bool.question_17_answer_2)
        );
        questionList.add(question);

        // Question 18
        question = new Question(context,
                                R.string.question_18_code_snippet,
                                R.string.question_18_description,
                                new Answer(context, R.string.question_18_answer_1, R.bool.question_18_answer_1),
                                new Answer(context, R.string.question_18_answer_2, R.bool.question_18_answer_2),
                                new Answer(context, R.string.question_18_answer_3, R.bool.question_18_answer_3),
                                new Answer(context, R.string.question_18_answer_4, R.bool.question_18_answer_4)
        );
        questionList.add(question);

        // Question 19
        question = new Question(context,
                                R.string.question_19_code_snippet,
                                R.string.question_19_description,
                                new Answer(context, R.string.question_19_answer_1, R.bool.question_19_answer_1),
                                new Answer(context, R.string.question_19_answer_2, R.bool.question_19_answer_2)
        );
        questionList.add(question);

        // Question 20
        question = new Question(context,
                                R.string.question_20_code_snippet,
                                R.string.question_20_description,
                                new Answer(context, R.string.question_20_answer_1, R.bool.question_20_answer_1),
                                new Answer(context, R.string.question_20_answer_2, R.bool.question_20_answer_2)
        );
        questionList.add(question);
    }
}