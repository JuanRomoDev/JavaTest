package com.juanromodev.javatest.ui.grade_report;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.data.model.Test;

public class GradeReportActivity extends AppCompatActivity {

    private static final String EXTRA_TEST = "com.juanromodev.javatest.test";

    public static Intent newIntent(Context packageContext, Test test) {
        Intent i = new Intent(packageContext, GradeReportActivity.class);
        i.putExtra(EXTRA_TEST, test);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_report);

        Test test = getIntent().getParcelableExtra(EXTRA_TEST);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.grade_report_container);

        if (fragment == null) {
            fragment = GradeReportFragment.newInstance(test);
            fm.beginTransaction()
                    .add(R.id.grade_report_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }
}
