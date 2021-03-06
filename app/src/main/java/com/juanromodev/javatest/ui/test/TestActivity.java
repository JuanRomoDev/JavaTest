package com.juanromodev.javatest.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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
        implements QuestionFragment.Callbacks, SubmitIncompleteTestDialogFragment.Callbacks,
        ExitTestDialogFragment.Callbacks, TestOverviewDialogFragment.Callbacks {

    private static final String SAVED_TEST = "test";

    private static final String DIALOG_SUBMIT_INCOMPLETE_TEST = "submit_incomplete_test";
    private static final String DIALOG_EXIT_TEST = "exit_test";
    private static final String DIALOG_TEST_OVERVIEW = "test_overview";

    private ViewPager questionVp;

    private Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if (savedInstanceState != null) {
            test = savedInstanceState.getParcelable(SAVED_TEST);
        } else {
            test = TestUtils.createTest(this);
        }

        setActionBarTitle(test.getQuestion(0).getNumber());

        questionVp = findViewById(R.id.questions_vp);

        questionVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
                setActionBarTitle(test.getQuestion(position).getNumber());
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
                if (test.isComplete()) {
                    navigateToGradeReport();
                } else {
                    DialogFragment dialogFragment = new SubmitIncompleteTestDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(), DIALOG_SUBMIT_INCOMPLETE_TEST);
                }
                return true;

            case R.id.overview:
                DialogFragment dialogFragment =
                        TestOverviewDialogFragment.newInstance(test, test.getQuestionList().get(questionVp.getCurrentItem()));
                dialogFragment.show(getSupportFragmentManager(), DIALOG_TEST_OVERVIEW);
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
    public void onBackPressed() {
        DialogFragment dialogFragment = new ExitTestDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), DIALOG_EXIT_TEST);
    }

    @Override
    public void onQuestionAnswered(Question question, Answer answer) {
        test.answerQuestion(question, answer);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        switch (dialog.getTag()) {
            case DIALOG_SUBMIT_INCOMPLETE_TEST:
                navigateToGradeReport();
                break;
            case DIALOG_EXIT_TEST:
                finish();

            default:
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

    @Override
    public void onQuestionSelected(Question question) {
        int questionIndex = test.getQuestionList().indexOf(question);
        questionVp.setCurrentItem(questionIndex);
    }

    private void setActionBarTitle(int questionNumber) {
        String title = getString(R.string.question_number, questionNumber);
        setTitle(title);
    }

    private void navigateToGradeReport() {
        Intent i = GradeReportActivity.newIntent(this, test);
        startActivity(i);
    }
}
