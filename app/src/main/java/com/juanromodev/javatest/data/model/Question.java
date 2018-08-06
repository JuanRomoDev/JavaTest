package com.juanromodev.javatest.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.Objects;

public class Question implements Parcelable {

    private String codeSnippet;
    private String description;
    private Answer[] answers;

    public Question(String codeSnippet, String description, Answer... answers) {
        this.codeSnippet = codeSnippet;
        this.description = description;
        this.answers = answers;
    }

    public Question(Context context, int codeSnippetResId, int descriptionResId, Answer... answers) {
        this(context.getString(codeSnippetResId),
             context.getString(descriptionResId),
             answers);
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public String getDescription() {
        return description;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Question)) {
            return false;
        }

        Question otherQuestion = (Question) obj;

        return codeSnippet.equals(otherQuestion.codeSnippet) &&
               description.equals(otherQuestion.description) &&
               Arrays.equals(answers, otherQuestion.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeSnippet, description, Arrays.hashCode(answers));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(codeSnippet);
        out.writeString(description);
        out.writeInt(answers.length);
        out.writeTypedArray(answers, flags);
    }

    public static final Parcelable.Creator<Question> CREATOR
            = new Parcelable.Creator<Question>() {
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    private Question(Parcel in) {
        codeSnippet = in.readString();
        description = in.readString();
        int answerCount = in.readInt();
        answers = new Answer[answerCount];
        in.readTypedArray(answers, Answer.CREATOR);
    }
}
