package com.atherton.darren.widget.base;

import com.atherton.darren.widget.base.BaseFeedbackModel;

public class BaseFeedbackModelImpl implements BaseFeedbackModel {

    private int totalStars;

    public BaseFeedbackModelImpl(int totalStars) {
        this.totalStars = totalStars;
    }
}
