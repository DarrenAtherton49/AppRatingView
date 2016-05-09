package com.atherton.darren;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

import com.atherton.darren.feedbackview.R;
import com.atherton.darren.widget.FeedbackView;
import com.atherton.darren.widget.instant.InstantFeedbackView;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        CoordinatorLayout main = (CoordinatorLayout) findViewById(R.id.coordinatorlayout_main);
//        AppFeedbackView view = new AppFeedbackView(this);
//        main.addView(view);
        FeedbackView view = new InstantFeedbackView.Builder(this, main)
                .build();
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
