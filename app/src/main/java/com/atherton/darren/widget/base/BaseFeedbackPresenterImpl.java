package com.atherton.darren.widget.base;

import com.atherton.darren.widget.base.BaseFeedbackModel;
import com.atherton.darren.widget.base.BaseFeedbackPresenter;
import com.atherton.darren.widget.base.BaseFeedbackView;

public class BaseFeedbackPresenterImpl implements BaseFeedbackPresenter {

    private BaseFeedbackView feedbackView;
    private BaseFeedbackModel feedbackModel;

    public void init(BaseFeedbackModel feedbackModel) {
        this.feedbackModel = feedbackModel;
    }

    public void attachView(BaseFeedbackView feedbackView) {
        this.feedbackView = feedbackView;
    }

    public void destroy() {
        this.feedbackView = null;
        //todo unsubscribe from model (clear listeners)
    }

    public void onDoneClicked() {
        //todo this.feedbackModel. go get a return and return in callback.
        //todo in callback, call this.fe.dismiss(result).
    }

    public void onDismissButtonClicked() {

    }

    public void onBackdropTouched() {

    }

    public void onRatingChanged(float rating) {
        //todo update the rating in the model
        //todo add an event to the event log (could do this in the model instead)
    }
}
