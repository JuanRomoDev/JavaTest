package com.juanromodev.javatest.ui.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Question;
import com.juanromodev.javatest.data.model.Test;
import com.juanromodev.javatest.util.TestUtils;

public class TestActivity extends AppCompatActivity
        implements QuestionFragment.Callbacks {

    private static final String TAG = "TestActivity";

    private ViewPager questionVp;

    private Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questionVp = findViewById(R.id.question_vp);

        test = TestUtils.createTest(this);

        FragmentManager fm = getSupportFragmentManager();
        questionVp.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Question question = test.getQuestion(position);
                return QuestionFragment.newInstance(question);
            }

            @Override
            public int getCount() {
                return test.getQuestionCount();
            }
        });
    }

    @Override
    public void onQuestionAnswered(Question question, Answer answer) {
        test.answerQuestion(question, answer);
        Log.i(TAG, "Current test grade: " + TestUtils.gradeTest(test));
    }
}
