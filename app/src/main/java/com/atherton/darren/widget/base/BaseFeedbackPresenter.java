package com.atherton.darren.widget.base;

import com.atherton.darren.widget.base.BaseFeedbackModel;
import com.atherton.darren.widget.base.BaseFeedbackView;

public interface BaseFeedbackPresenter {

    void init(BaseFeedbackModel feedbackModel);

    void attachView(BaseFeedbackView feedbackView);

    void destroy();

    void onDoneClicked();

    void onDismissButtonClicked();

    void onBackdropTouched();

    void onRatingChanged(float rating);
}
