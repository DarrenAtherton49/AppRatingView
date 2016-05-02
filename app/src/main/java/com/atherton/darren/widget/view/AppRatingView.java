package com.atherton.darren.widget.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
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
    private final int headerTextId;
    private final int bodyTextId;
    private final int dismissTextId;
    private final Interpolator interpolator;

    private AppRatingListener appRatingListener;
    private AppRatingPresenter appRatingPresenter;

    private View backdrop;
    private CardView cardView;
    private TextView headerTextView;
    private TextView bodyTextView;
    private RatingBar ratingBar;
    private Button dismissButton;
    private FloatingActionButton doneButton;

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
        this.headerTextId = builder.headerTextId;
        this.bodyTextId = builder.bodyTextId;
        this.dismissTextId = builder.dismissTextId;
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

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_app_rating_view, viewGroup, true);

        initBackdrop(view);
        initCardView(view);
        initHeader(view);
        initBody(view);
        initRatingBar(view);
        initDismissButton(view);
        initDoneButton(view);
    }

    private void initBackdrop(View parentView) {
        backdrop = parentView.findViewById(R.id.view_backdrop_app_rating_view);
        //todo set backdrop touched listener which calls presenter
    }

    private void initCardView(View parentView) {
        cardView = (CardView) parentView.findViewById(R.id.cardview_app_rating_view);
        //todo setup initial position, visibilty and animations here
    }

    private void initHeader(View parentView) {
        headerTextView = (TextView) parentView.findViewById(R.id.textview_header_app_rating_View);
        //todo set attribute from builder etc (colors)
    }

    private void initBody(View parentView) {
        bodyTextView = (TextView) parentView.findViewById(R.id.textview_body_app_rating_View);
        //todo set attribute from builder etc (colors)
    }

    private void initRatingBar(View parentView) {
        ratingBar = (RatingBar) parentView.findViewById(R.id.ratingbar_app_rating_view);
        //todo set attribute from builder etc (colors)
    }

    private void initDismissButton(View parentView) {
        dismissButton = (Button) parentView.findViewById(R.id.button_dismiss_app_rating_view);
        //todo set attribute from builder etc (colors), clicklistener to call presenter
    }

    private void initDoneButton(View parentView) {
        doneButton = (FloatingActionButton) parentView.findViewById(R.id.fab_done_app_rating_view);
        //todo set attribute from builder etc (colors), clicklistener to call presenter
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
        // todo pass builder attributes into constructor here
        AppRatingModel model = new AppRatingModelImpl(builder.totalStars);
        this.appRatingPresenter = new AppRatingPresenterImpl();
        this.appRatingPresenter.init(model);
        this.appRatingPresenter.attachView(this);
    }

    public void renderInitialView() {
        //todo start the animation to bring the view onto the screen
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

    //todo attach this to the RatingBar when it is initialized
    private RatingBar.OnRatingBarChangeListener ratingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            if (fromUser) {
                appRatingPresenter.onRatingChanged(rating);
            }
        }
    };










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
        private int headerTextId = R.string.header_text_app_rating_view;
        private int bodyTextId = R.string.body_text_app_rating_view;
        private int dismissTextId = R.string.dismiss_text_app_rating_view;
        private Interpolator interpolator = new OvershootInterpolator();

        private AppRatingListener appRatingListener;

        // Optional parameters - model attributes
        private int totalStars = 5;

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

        public Builder headerTextId(int headerTextId) {
            this.headerTextId = headerTextId;
            return this;
        }

        public Builder bodyTextId(int bodyTextId) {
            this.bodyTextId = bodyTextId;
            return this;
        }

        public Builder dismissTextId(int dismissTextId) {
            this.dismissTextId = dismissTextId;
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

        public Builder totalStars(int totalStars) {
            this.totalStars = totalStars;
            return this;
        }

        public AppRatingView build() {
            return new AppRatingView(this);
        }
    }
}
