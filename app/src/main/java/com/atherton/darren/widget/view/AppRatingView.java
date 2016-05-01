package com.atherton.darren.widget.view;

public interface AppRatingView {

    /**
     * Renders the initial content - empty RatingBar etc.
     */
    void renderInitialView();

    /**
     * Enables the done button once a rating has been chosen.
     */
    void enableDoneButton();

    /**
     * Dismisses the view using animation and sends callback to
     * the view which instantiated this view.
     */
    void dismissView();
}
