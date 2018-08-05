package com.juanromodev.javatest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Answer implements Parcelable {

    private String text;
    private boolean correct;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Answer)) {
            return false;
        }

        Answer otherAnswer = (Answer) obj;

        return text.equals(otherAnswer.text) &&
               correct == otherAnswer.correct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, correct);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(text);
        out.writeByte((byte) (correct ? 1 : 0));
    }

    public static final Parcelable.Creator<Answer> CREATOR
            = new Parcelable.Creator<Answer>() {
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    private Answer(Parcel in) {
        text = in.readString();
        correct = in.readByte() != 0;
    }
}