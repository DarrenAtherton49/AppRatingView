package com.atherton.darren.widget.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.atherton.darren.appratingview.R;
import com.atherton.darren.widget.model.analytics.AppRatingResult;

public class AppRatingView extends CoordinatorLayout implements RatingView {

    private Context context;

//    private final View backdrop;
//    private final FloatingActionButton doneButton;
//    private final TextView headerTextView;
//    private final TextView bodyTextView;
//    private final TextView dismissButton;
//    private final RatingBar ratingBar;
//
//    private final int backdropColor;
//    private final int cardColor;
//    private final int fabColor;
//    private final int headerTextColor;
//    private final int bodyTextColor;
//    private final int dismissButtonTextColor;

    private AppRatingView(Builder builder) {
        super(builder.context);
        initViews(builder.context, builder.parent);
        this.context = builder.context.getApplicationContext();

    }

    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    private void initViews(Context context, ViewGroup viewGroup) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_app_rating_view, viewGroup, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        // Sets the images for the previous and next buttons. Uses
//        // built-in images so you don't need to add images, but in
//        // a real application your images should be in the
//        // application package so they are always available.
//        mPreviousButton = (Button) this
//                .findViewById(R.id.sidespinner_view_previous);
//        mPreviousButton
//                .setBackgroundResource(android.R.drawable.ic_media_previous);
//
//        mNextButton = (Button)this
//                .findViewById(R.id.sidespinner_view_next);
//        mNextButton
//                .setBackgroundResource(android.R.drawable.ic_media_next);
    }

    public void renderInitialView() {

    }

    public void enableDoneButton() {
        //todo this.doneButton.setEnabled(true);
        //todo this.doneButton setTintColor to enabled color
    }

    public void disableDoneButton() {
        //todo this.doneButton.setEnabled(false);
        //todo this.doneButton setTintColor to disabled color
    }

    public void dismissView(AppRatingResult result) {
        //todo call callback method to return result to activity
    }












    public static class Builder {

        // Required parameters
        private Context context;
        private ViewGroup parent;

        // Optional parameters
        private int backdropColor = ContextCompat.getColor(context, R.color.app_rating_view_backdrop);
        private int cardColor;
        private int fabColor;
        private int headerTextColor;
        private int bodyTextColor;
        private int dismissButtonTextColor;

        public Builder(Context context, ViewGroup parent) {
            this.context = context;
            this.parent = parent;
        }

        public Builder backdropColor(int backdropColor) {
            this.backdropColor = backdropColor;
            return this;
        }

        public AppRatingView build() {
            return new AppRatingView(this);
        }
    }
}
