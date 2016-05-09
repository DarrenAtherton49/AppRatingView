package com.atherton.darren.widget.instant;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.atherton.darren.feedbackview.R;
import com.atherton.darren.widget.base.BaseFeedbackModel;
import com.atherton.darren.widget.base.BaseFeedbackModelImpl;
import com.atherton.darren.widget.base.BaseFeedbackPresenter;
import com.atherton.darren.widget.base.BaseFeedbackPresenterImpl;
import com.atherton.darren.widget.base.BaseFeedbackView;

public class InstantFeedbackView extends BaseFeedbackView implements InstantView {

    private BaseFeedbackPresenter feedbackPresenter;

    private InstantFeedbackView(Builder builder) {
        super(builder.context, builder.parent);
        this.context = builder.context.getApplicationContext();
        this.viewStyle = builder.viewStyle;
        this.interpolator = builder.interpolator;
        this.feedbackViewListener = builder.feedbackViewListener;
        initView(builder.context, builder.parent);
        initPresenter(builder);
    }

    @Override protected void initView(Context context, ViewGroup parentLayout) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_feedback_view, parentLayout, true);

        initBackdrop(view);
        initCardView(view);
        initHeader(view);
        initBody(view);
        initRatingBar(view);
        initDismissButton(view);
        initDoneButton(view);
    }

    private void initBackdrop(View parentView) {
        backdrop = parentView.findViewById(R.id.view_backdrop_feedback_view);
        //todo set backdrop touched listener which calls presenter
    }

    private void initCardView(View parentView) {
        cardView = (CardView) parentView.findViewById(R.id.cardview_feedback_view);
        //todo setup initial position, visibilty and animations here
    }

    private void initHeader(View parentView) {
        headerTextView = (TextView) parentView.findViewById(R.id.textview_header_feedback_View);
    }

    private void initBody(View parentView) {
        bodyTextView = (TextView) parentView.findViewById(R.id.textview_body_feedback_View);
    }

    private void initRatingBar(View parentView) {
        ratingBar = (RatingBar) parentView.findViewById(R.id.ratingbar_feedback_view);
        ratingBar.setOnRatingBarChangeListener(ratingBarChangeListener);
    }

    private void initDismissButton(View parentView) {
        dismissButton = (Button) parentView.findViewById(R.id.button_dismiss_feedback_view);
    }

    private void initDoneButton(View parentView) {
        doneButton = (FloatingActionButton) parentView.findViewById(R.id.fab_done_feedback_view);
    }

    /**
     * Constructs a {@link BaseFeedbackModel}
     * and then passes it into a newly created presenter, binding this view
     * to the presenter
     *
     * @param builder
     *           the builder object passes into the view
     */
    private void initPresenter(Builder builder) {
        // todo pass builder attributes into constructor here
        BaseFeedbackModel model = new BaseFeedbackModelImpl(builder.totalStars);
        this.feedbackPresenter = new BaseFeedbackPresenterImpl();
        this.feedbackPresenter.init(model);
        this.feedbackPresenter.attachView(this);
    }

    private RatingBar.OnRatingBarChangeListener ratingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            if (fromUser && feedbackPresenter != null) {
                feedbackPresenter.onRatingChanged(rating);
            }
        }
    };

    public static class Builder {

        // Required parameters
        private Context context;
        private ViewGroup parent;

        // Optional parameters - view attributes
        private FeedbackViewStyle viewStyle = FeedbackViewStyle.FULL_WIDTH;
        private Interpolator interpolator = new OvershootInterpolator();

        private FeedbackViewListener feedbackViewListener;

        // Optional parameters - model attributes
        private int totalStars = 5;

        public Builder(Context context, ViewGroup parent) {
            this.context = context;
            this.parent = parent;
        }

        public Builder viewStyle(FeedbackViewStyle viewStyle) {
            this.viewStyle = viewStyle;
            return this;
        }

        public Builder interpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public Builder addListener(FeedbackViewListener listener) {
            this.feedbackViewListener = listener;
            return this;
        }

        public Builder totalStars(int totalStars) {
            this.totalStars = totalStars;
            return this;
        }

        public InstantFeedbackView build() {
            return new InstantFeedbackView(this);
        }
    }
}
