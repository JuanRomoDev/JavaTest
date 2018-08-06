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

        question = new Question(context,
                                R.string.question_1_code_snippet,
                                R.string.question_1_description,
                                new Answer(context, R.string.question_1_answer_1, R.bool.question_1_answer_1),
                                new Answer(context, R.string.question_1_answer_2, R.bool.question_1_answer_2)
        );
        questionList.add(question);

        question = new Question(context,
                                R.string.question_2_code_snippet,
                                R.string.question_2_description,
                                new Answer(context, R.string.question_2_answer_1, R.bool.question_2_answer_1),
                                new Answer(context, R.string.question_2_answer_2, R.bool.question_2_answer_2),
                                new Answer(context, R.string.question_2_answer_3, R.bool.question_2_answer_3),
                                new Answer(context, R.string.question_2_answer_4, R.bool.question_2_answer_4)
        );
        questionList.add(question);

        question = new Question(context,
                                R.string.question_3_code_snippet,
                                R.string.question_3_description,
                                new Answer(context, R.string.question_3_answer_1, R.bool.question_3_answer_1),
                                new Answer(context, R.string.question_3_answer_2, R.bool.question_3_answer_2),
                                new Answer(context, R.string.question_3_answer_3, R.bool.question_3_answer_3),
                                new Answer(context, R.string.question_3_answer_4, R.bool.question_3_answer_4)
        );
        questionList.add(question);

        question = new Question(context,
                                R.string.question_4_code_snippet,
                                R.string.question_4_description,
                                new Answer(context, R.string.question_4_answer_1, R.bool.question_4_answer_1),
                                new Answer(context, R.string.question_4_answer_2, R.bool.question_4_answer_2),
                                new Answer(context, R.string.question_4_answer_3, R.bool.question_4_answer_3),
                                new Answer(context, R.string.question_4_answer_4, R.bool.question_4_answer_4)
        );
        questionList.add(question);

        question = new Question(context,
                                R.string.question_5_code_snippet,
                                R.string.question_5_description,
                                new Answer(context, R.string.question_5_answer_1, R.bool.question_5_answer_1),
                                new Answer(context, R.string.question_5_answer_2, R.bool.question_5_answer_2),
                                new Answer(context, R.string.question_5_answer_3, R.bool.question_5_answer_3),
                                new Answer(context, R.string.question_5_answer_4, R.bool.question_5_answer_4)
        );
        questionList.add(question);
    }
}