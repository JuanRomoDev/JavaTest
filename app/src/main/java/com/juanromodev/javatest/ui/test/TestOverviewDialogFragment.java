package com.juanromodev.javatest.ui.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Question;
import com.juanromodev.javatest.data.model.Test;

import java.util.List;

public class TestOverviewDialogFragment extends DialogFragment {

    private static final String ARG_TEST = "test";
    private static final String ARG_SELECTED_QUESTION = "selectedQuestion";

    Callbacks callbacks;

    private RecyclerView testOverviewRv;
    private QuestionAdapter adapter;

    private Test test;
    private Question selectedQuestion;

    /**
     * Required interface for hosting activities
     */
    public interface Callbacks {
        void onQuestionSelected(Question question);
    }

    public static DialogFragment newInstance(Test test, Question selectedQuestion) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_TEST, test);
        args.putParcelable(ARG_SELECTED_QUESTION, selectedQuestion);

        DialogFragment df = new TestOverviewDialogFragment();
        df.setArguments(args);

        return df;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;

        test = getArguments().getParcelable(ARG_TEST);
        selectedQuestion = getArguments().getParcelable(ARG_SELECTED_QUESTION);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_test_overview, container, false);

        testOverviewRv = v.findViewById(R.id.test_overview_rv);
        LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        testOverviewRv.setLayoutManager(layoutManager);

        List<Question> questionList = test.getQuestionList();
        adapter = new QuestionAdapter(questionList);
        testOverviewRv.setAdapter(adapter);

        return v;
    }

    private class QuestionHolder extends RecyclerView.ViewHolder {

        private Button questionBtn;

        private Question question;

        public QuestionHolder(View itemView) {
            super(itemView);
            questionBtn = (Button) itemView;
            questionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callbacks.onQuestionSelected(question);
                    dismiss();
                }
            });
        }

        public void bindQuestion(Question question) {
            this.question = question;

            String btnText = getActivity().getString(R.string.question_number, question.getNumber());
            questionBtn.setText(btnText);

            questionBtn.setEnabled(!question.equals(selectedQuestion));
        }
    }

    private class QuestionAdapter extends Adapter<QuestionHolder> {

        private List<Question> questionList;

        public QuestionAdapter(List<Question> questionList) {
            this.questionList = questionList;
        }

        @NonNull
        @Override
        public QuestionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item_question, viewGroup, false);
            return new QuestionHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionHolder questionHolder, int position) {
            Question question = questionList.get(position);
            questionHolder.bindQuestion(question);
        }

        @Override
        public int getItemCount() {
            return questionList.size();
        }
    }
}
