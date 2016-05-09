package com.atherton.darren.widget;

import com.atherton.darren.widget.analytics.FeedbackViewResult;

public interface FeedbackView {

    /**
     * Renders the initial content - empty RatingBar etc.
     */
    void renderInitialView();

    /**
     * Enables the done button once a rating has been chosen.
     */
    void enableDoneButton();

    /**
     * Disables the done button on startup.
     */
    void disableDoneButton();

    /**
     * Dismisses the view using animation and sends callback to
     * the view which instantiated this view.
     */
    void dismissView(FeedbackViewResult feedbackViewResult);
}
