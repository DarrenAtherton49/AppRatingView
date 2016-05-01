package com.atherton.darren.widget.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

import com.atherton.darren.appratingview.R;
import com.atherton.darren.widget.model.AppRatingModel;
import com.atherton.darren.widget.model.AppRatingModelImpl;
import com.atherton.darren.widget.model.analytics.AppRatingResult;
import com.atherton.darren.widget.presenter.AppRatingPresenter;
import com.atherton.darren.widget.presenter.AppRatingPresenterImpl;

public class AppRatingView extends CoordinatorLayout implements RatingView {

    /**
     * Interface for returning the result of the view to the class which
     * instantiated it.
     */
    public interface AppRatingListener {
        void onAppRatingViewFinished(final AppRatingResult result);
    }

    public enum RatingViewStyle {
        CARD_LAYOUT, FULL_WIDTH
    }

    private final Context context;

    private final RatingViewStyle viewStyle;
    private final int backdropColor;
    private final int cardColor;
    private final int fabEnabledColor;
    private final int fabDisabledColor;
    private final int headerTextColor;
    private final int bodyTextColor;
    private final int dismissButtonTextColor;
    private final String headerText;
    private final String bodyText;
    private final String dismissText;
    private final Interpolator interpolator;

    private AppRatingListener appRatingListener;
    private AppRatingPresenter appRatingPresenter;

//    private final View backdrop;
//    private final FloatingActionButton doneButton;
//    private final TextView headerTextView;
//    private final TextView bodyTextView;
//    private final TextView dismissButton;
//    private final RatingBar ratingBar;
//

    private AppRatingView(Builder builder) {
        super(builder.context);
        this.context = builder.context.getApplicationContext();
        this.viewStyle = builder.viewStyle;
        this.backdropColor = builder.backdropColor;
        this.cardColor = builder.cardColor;
        this.fabEnabledColor = builder.fabEnabledColor;
        this.fabDisabledColor = builder.fabDisabledColor;
        this.headerTextColor = builder.headerTextColor;
        this.bodyTextColor = builder.bodyTextColor;
        this.dismissButtonTextColor =  builder.dismissTextColor;
        this.headerText = builder.headerText;
        this.bodyText = builder.bodyText;
        this.dismissText = builder.dismissText;
        this.interpolator = builder.interpolator;
        this.appRatingListener = builder.appRatingListener;
        initViews(builder.context, builder.parent);
        initPresenter(builder);
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

    /**
     * Constructs a {@link com.atherton.darren.widget.model.AppRatingModel}
     * and then passes it into a newly created presenter, binding this view
     * to the presenter
     *
     * @param builder
     *           the builder object passes into the view
     */
    private void initPresenter(Builder builder) {
        AppRatingModel model = new AppRatingModelImpl(); // todo pass builder attributes into constructor here
        this.appRatingPresenter = new AppRatingPresenterImpl();
        this.appRatingPresenter.init(model);
        this.appRatingPresenter.attachView(this);
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
        //todo dismiss view via animation, clean up any resources
        if (appRatingListener != null) {
            appRatingListener.onAppRatingViewFinished(result);
        }
    }












    public static class Builder {

        // Required parameters
        private Context context;
        private ViewGroup parent;

        // Optional parameters - view attributes
        private RatingViewStyle viewStyle = RatingViewStyle.FULL_WIDTH;
        private int backdropColor = R.color.app_rating_view_backdrop;
        private int cardColor = R.color.app_rating_view_card;
        private int fabEnabledColor = R.color.app_rating_view_fab_enabled;
        private int fabDisabledColor = R.color.app_rating_view_fab_disabled;
        private int headerTextColor = R.color.app_rating_view_header;
        private int bodyTextColor = R.color.app_rating_view_body;
        private int dismissTextColor = R.color.app_rating_view_dismiss;
        private String headerText = context.getString(R.string.app_rating_view_header_text);
        private String bodyText = context.getString(R.string.app_rating_view_body_text);
        private String dismissText = context.getString(R.string.app_rating_view_dismiss_text);
        private Interpolator interpolator = new OvershootInterpolator();

        private AppRatingListener appRatingListener;

        // Optional parameters - model attributes
        private int numberOfStars = 5;

        public Builder(Context context, ViewGroup parent) {
            this.context = context;
            this.parent = parent;
        }

        public Builder viewStyle(RatingViewStyle viewStyle) {
            this.viewStyle = viewStyle;
            return this;
        }

        public Builder backdropColor(int backdropColor) {
            this.backdropColor = backdropColor;
            return this;
        }

        public Builder cardColor(int cardColor) {
            this.cardColor = cardColor;
            return this;
        }

        public Builder fabEnabledColor(int fabEnabledColor) {
            this.fabEnabledColor = fabEnabledColor;
            return this;
        }

        public Builder fabDisabledColor(int fabDisabledColor) {
            this.fabDisabledColor = fabDisabledColor;
            return this;
        }

        public Builder headerTextColor(int headerTextColor) {
            this.headerTextColor = headerTextColor;
            return this;
        }

        public Builder bodyTextColor(int bodyTextColor) {
            this.bodyTextColor = bodyTextColor;
            return this;
        }

        public Builder dismissTextColor(int dismissTextColor) {
            this.dismissTextColor = dismissTextColor;
            return this;
        }

        public Builder headerText(String headerText) {
            this.headerText = headerText;
            return this;
        }

        public Builder bodyText(String bodyText) {
            this.bodyText = bodyText;
            return this;
        }

        public Builder dismissText(String dismissText) {
            this.dismissText = dismissText;
            return this;
        }

        public Builder interpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public Builder addListener(AppRatingListener listener) {
            this.appRatingListener = listener;
            return this;
        }

        public AppRatingView build() {
            return new AppRatingView(this);
        }
    }
}
