package com.juanromodev.javatest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.juanromodev.javatest.R;
import com.juanromodev.javatest.ui.test.TestActivity;

public class HomeActivity extends AppCompatActivity {

    private Button startTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startTestBtn = findViewById(R.id.start_test_btn);
        startTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, TestActivity.class);
                startActivity(i);
            }
        });
    }
}
