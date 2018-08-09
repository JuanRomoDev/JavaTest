package com.juanromodev.javatest.ui.home;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getTheme();
            theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
            int color = typedValue.data;

            Bitmap overviewIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_overview);
            ActivityManager.TaskDescription td = new ActivityManager.TaskDescription(null, overviewIcon, color);

            setTaskDescription(td);
        }

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
