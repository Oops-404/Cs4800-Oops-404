package cs4800.eventSearch;

import java.util.*;

/*
 * A class that will search through the database
 * for specific events and return an arraylist
 * of events based on filters chosen
 */
public class EventSearch {
    // the arraylist containing events based on search filters
    private ArrayList<String> eventList = null;

    // the list of filters which will be strings
    private List<String> filters = null;

    /*
     * Default constructor that will take in a list of filters
     * and initialize an empty event list
     */
    public EventSearch(List<String> filters) {
        this.filters = new ArrayList<>();
        this.filters.addAll(filters);

        this.eventList = new ArrayList<>();
    }
}
