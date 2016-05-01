package com.atherton.darren.widget.presenter;

import com.atherton.darren.widget.model.AppRatingModel;
import com.atherton.darren.widget.view.AppRatingView;

public interface AppRatingPresenter {

    void init(AppRatingModel appRatingModel);

    void setView(AppRatingView appRatingView);

    void onDoneClicked();

    void onDismissButtonClicked();

    void onBackdropTouched();

    void onRatingChanged(int rating);
}
