package com.atherton.darren.widget.model.analytics;

import java.util.ArrayList;

public class AppRatingResult {

    public enum Result {

        RATING_GIVEN("Rating given"),
        DISMISSED_VIA_BUTTON("Dismissed via button"),
        DISMISSED_VIA_BACKDROP("Dismissed via backdrop");

        private String stringValue;
        Result(String toString) {
            stringValue = toString;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

    private Result result;
    private AppRatingEventLog eventLog;
    private int totalStars;
    private int starsGiven;

    public AppRatingResult(Result result, AppRatingEventLog eventLog, int totalStars,
                           int starsGiven) {
        this.result = result;
        this.eventLog = eventLog;
        this.totalStars = totalStars;
        this.starsGiven = starsGiven;
    }

    public Result getResult() {
        return result;
    }

    public ArrayList<String> getEventLog() {
        return eventLog.getEventList();
    }

    public int getTotalStars() {
        return totalStars;
    }

    public int getStarsGiven() {
        return starsGiven;
    }

    //todo provide more analytics stars here
}
