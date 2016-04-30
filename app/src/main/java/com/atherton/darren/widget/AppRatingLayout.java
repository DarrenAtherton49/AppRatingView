package com.atherton.darren.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.atherton.darren.appratingview.R;

public class AppRatingLayout extends CoordinatorLayout {

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

    public AppRatingLayout(Context context) {
        super(context);
        initViews(context);
    }

    public AppRatingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public AppRatingLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews(context);
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    private void initViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_app_rating_view, this);
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
}
