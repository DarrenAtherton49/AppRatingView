package com.atherton.darren.widget.model.analytics;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class AppRatingEventLog {

    private static final String TAG = "AppRatingEventLog";

    private ArrayList<String> eventList;

    private void addEvent(String eventString) {
        eventList.add(eventString);
    }

    public void addRatingViewShownEvent(Date date) {
        String toAdd = new String(); // todo some date to string conversion here instead
        addEvent(toAdd);
    }

    public void addRatingViewDismissedEvent(Date date) {
        String toAdd = new String(); // todo some date to string conversion here instead
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
