package com.juanromodev.javatest.ui.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Question;
import com.juanromodev.javatest.util.TextUtils;

public class QuestionFragment extends Fragment {

    private static final String ARG_QUESTION = "question";

    private static final String SAVED_SELECTED_ANSWER = "selected_answer";

    private Callbacks callbacks;

    private Question question;
    private Answer selectedAnswer;

    private TextView questionCodeSnippetTv;
    private TextView questionDescriptionTv;
    private RadioGroup questionAnswersRg;

    /**
     * Required interface for hosting activities
     */
    public interface Callbacks {
        void onQuestionAnswered(Question question, Answer answer);
    }

    public static QuestionFragment newInstance(Question question) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, question);

        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        question = getArguments().getParcelable(ARG_QUESTION);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);

        questionCodeSnippetTv = v.findViewById(R.id.question_code_snippet_tv);
        String codeSnippet = TextUtils.addNumberLines(question.getCodeSnippet());
        questionCodeSnippetTv.setText(codeSnippet);

        questionDescriptionTv = v.findViewById(R.id.question_description_tv);
        questionDescriptionTv.setText(question.getDescription());

        if (savedInstanceState != null) {
            selectedAnswer = savedInstanceState.getParcelable(SAVED_SELECTED_ANSWER);
        }

        questionAnswersRg = v.findViewById(R.id.question_answers_rg);
        for (Answer answer : question.getAnswers()) {
            RadioButton rb = new RadioButton(getActivity());
            rb.setTag(answer);
            rb.setText(answer.getText());

            questionAnswersRg.addView(rb);

            rb.setChecked(selectedAnswer != null && selectedAnswer.equals(answer));
        }

        questionAnswersRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Answer answer = (Answer) group.findViewById(checkedId).getTag();
                callbacks.onQuestionAnswered(question, answer);

                selectedAnswer = answer;
            }
        });

        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_SELECTED_ANSWER, selectedAnswer);
    }
}
