package com.juanromodev.javatest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test implements Parcelable {

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

    public Collection<Answer> getAnswers() {
        return answerToQuestion.values();
    }

    public boolean isCompleted() {
        for (Question question : questionList) {
            if (!answerToQuestion.containsKey(question)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeTypedList(questionList);
        out.writeInt(answerToQuestion.size());
        for (Map.Entry<Question, Answer> answeredQuestion : answerToQuestion.entrySet()) {
            out.writeParcelable(answeredQuestion.getKey(), flags);
            out.writeParcelable(answeredQuestion.getValue(), flags);
        }
    }

    public static final Parcelable.Creator<Test> CREATOR
            = new Parcelable.Creator<Test>() {
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    private Test(Parcel in) {
        questionList = new ArrayList<>();
        in.readTypedList(questionList, Question.CREATOR);
        int answeredQuestionCount = in.readInt();
        for (int i = 0; i < answeredQuestionCount; i++) {
            Question question = in.readParcelable(Question.class.getClassLoader());
            Answer answer = in.readParcelable(Answer.class.getClassLoader());
            answerToQuestion.put(question, answer);
        }
    }
}