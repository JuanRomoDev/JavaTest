package com.juanromodev.javatest.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.juanromodev.javatest.R;

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
                Toast.makeText(HomeActivity.this, R.string.test_started, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
