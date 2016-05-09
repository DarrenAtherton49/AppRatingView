package com.atherton.darren.widget.analytics;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class FeedbackViewEventLog {

    private static final String TAG = "FeedbackViewEventLog";

    private ArrayList<String> eventList;

    public FeedbackViewEventLog() {
        eventList = new ArrayList<>();
    }

    private void addEvent(String eventString) {
        eventList.add(eventString);
    }

    public void addFeedbackViewShownEvent(Date date) {
        String toAdd = ""; // todo some date to string conversion here instead
        addEvent(toAdd);
    }

    public void addFeedbackViewDismissedEvent(Date date) {
        String toAdd = ""; // todo some date to string conversion here instead
        addEvent(toAdd);
    }

    public ArrayList<String> getEventList() {
        return eventList;
    }

    private void print() {
        for (int i = 0; i < eventList.size(); i++) {
            String eventString = eventList.get(i);
            if (eventString != null && !eventString.isEmpty()) {
                Log.d(TAG, eventString);
            }
        }
    }
}
