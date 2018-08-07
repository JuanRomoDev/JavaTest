package com.juanromodev.javatest.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Answer;
import com.juanromodev.javatest.data.model.Question;
import com.juanromodev.javatest.data.model.Test;
import com.juanromodev.javatest.ui.grade_report.GradeReportActivity;
import com.juanromodev.javatest.util.TestUtils;

public class TestActivity extends AppCompatActivity
        implements QuestionFragment.Callbacks {

    private static final String SAVED_TEST = "test";

    private ViewPager questionVp;

    private Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        updateActionBarTitle(1);

        questionVp = findViewById(R.id.question_vp);

        if (savedInstanceState != null) {
            test = savedInstanceState.getParcelable(SAVED_TEST);
        } else {
            test = TestUtils.createTest(this);
        }

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

        questionVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateActionBarTitle(position + 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submit:
                Intent i = GradeReportActivity.newIntent(this, test);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_TEST, test);
    }

    @Override
    public void onQuestionAnswered(Question question, Answer answer) {
        test.answerQuestion(question, answer);
    }

    private void updateActionBarTitle(int questionNumber) {
        String title = getString(R.string.question_number, questionNumber);
        setTitle(title);
    }
}
