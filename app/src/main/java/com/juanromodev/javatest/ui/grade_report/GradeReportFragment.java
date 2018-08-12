package com.juanromodev.javatest.ui.grade_report;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Test;
import com.juanromodev.javatest.util.TestUtils;

public class GradeReportFragment extends Fragment {

    private static final String ARG_TEST = "test";

    private Test test;

    private TextView correctQuestionsTv;
    private TextView incorrectQuestionsTv;
    private TextView totalQuestionsTv;
    private TextView testGradeTv;

    public static GradeReportFragment newInstance(Test test) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_TEST, test);

        GradeReportFragment fragment = new GradeReportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test = getArguments().getParcelable(ARG_TEST);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grade_report, container, false);

        correctQuestionsTv = v.findViewById(R.id.correct_questions_tv);
        int correctAnswers = TestUtils.countCorrectAnswers(test);
        String correctQuestions = getActivity().getString(R.string.correct_questions, correctAnswers);
        correctQuestionsTv.setText(correctQuestions);

        incorrectQuestionsTv = v.findViewById(R.id.incorrect_questions_tv);
        int incorrectAnswers = test.getQuestionCount() - correctAnswers;
        String incorrectQuestions = getActivity().getString(R.string.incorrect_questions, incorrectAnswers);
        incorrectQuestionsTv.setText(incorrectQuestions);

        totalQuestionsTv = v.findViewById(R.id.total_questions_tv);
        String totalQuestions = getActivity().getString(R.string.total_questions, test.getQuestionCount());
        totalQuestionsTv.setText(totalQuestions);

        testGradeTv = v.findViewById(R.id.test_grade_tv);
        String testGrade = getActivity().getString(R.string.test_grade, TestUtils.gradeTest(test));
        testGradeTv.setText(testGrade);

        return v;
    }
}
