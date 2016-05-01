package com.atherton.darren;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

import com.atherton.darren.appratingview.R;
import com.atherton.darren.widget.view.AppRatingView;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        CoordinatorLayout main = (CoordinatorLayout) findViewById(R.id.coordinatorlayout_main);
//        AppRatingView view = new AppRatingView(this);
//        main.addView(view);
        AppRatingView view = new AppRatingView.Builder(this, main)
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
