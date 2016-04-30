package com.atherton.darren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.atherton.darren.appratingview.R;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    private int getContentView() {
        return R.layout.activity_main;
    }
}
