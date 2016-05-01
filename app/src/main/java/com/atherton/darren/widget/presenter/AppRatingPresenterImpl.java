package com.atherton.darren.widget.presenter;

import com.atherton.darren.widget.model.AppRatingModel;
import com.atherton.darren.widget.view.RatingView;

public class AppRatingPresenterImpl implements AppRatingPresenter {

    private RatingView appRatingView;
    private AppRatingModel appRatingModel;

    public void init(AppRatingModel appRatingModel) {
        this.appRatingModel = appRatingModel;
    }

    public void attachView(RatingView appRatingView) {
        this.appRatingView = appRatingView;
    }

    public void destroy() {
        this.appRatingView = null;
        //todo unsubscribe from model (clear listeners)
    }

    public void onDoneClicked() {
        //todo this.appRatingModel. go get a return and return in callback.
        //todo in callback, call this.appRatingView.dismiss(result).
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
