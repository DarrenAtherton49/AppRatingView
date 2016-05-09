package com.atherton.darren.widget.base;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.atherton.darren.widget.FeedbackView;
import com.atherton.darren.widget.analytics.FeedbackViewResult;

public abstract class BaseFeedbackView extends CoordinatorLayout implements FeedbackView {

    /**
     * Interface for returning the result of the view to the class which
     * instantiated it.
     */
    public interface FeedbackViewListener {
        void onFeedbackViewFinished(final FeedbackViewResult result);
    }

    public enum FeedbackViewStyle {
        CARD_LAYOUT, FULL_WIDTH
    }

    protected Context context;

    protected FeedbackViewStyle viewStyle;
    protected Interpolator interpolator;

    protected FeedbackViewListener feedbackViewListener;

    protected View backdrop;
    protected CardView cardView;
    protected TextView headerTextView;
    protected TextView bodyTextView;
    protected RatingBar ratingBar;
    protected Button dismissButton;
    protected FloatingActionButton doneButton;

    public BaseFeedbackView(Context context, ViewGroup parentLayout, FeedbackViewStyle viewStyle,
                            Interpolator interpolator, FeedbackViewListener feedbackViewListener) {
        super(context);
        this.context = context.getApplicationContext();
        this.viewStyle = viewStyle;
        this.interpolator = interpolator;
        this.feedbackViewListener = feedbackViewListener;
        initView(context, parentLayout);
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    protected abstract void initView(Context context, ViewGroup parentLayout);

    public void renderInitialView() {

    }

    public void enableDoneButton() {
        //todo this.doneButton.setEnabled(true);
        //todo animate in, fab.show
    }

    public void disableDoneButton() {
        //todo this.doneButton.setEnabled(false);
        //todo animate out, fab.hide
    }

    public void dismissView(FeedbackViewResult result) {
        //todo dismiss view via animation, clean up any resources
        if (feedbackViewListener != null) {
            feedbackViewListener.onFeedbackViewFinished(result);
        }
    }
}
