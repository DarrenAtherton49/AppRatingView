package com.atherton.darren.widget.presenter;

import com.atherton.darren.widget.model.AppRatingModel;
import com.atherton.darren.widget.view.RatingView;

public interface AppRatingPresenter {

    void init(AppRatingModel appRatingModel);

    void attachView(RatingView appRatingView);

    void destroy();

    void onDoneClicked();

    void onDismissButtonClicked();

    void onBackdropTouched();

    void onRatingChanged(int rating);
}
