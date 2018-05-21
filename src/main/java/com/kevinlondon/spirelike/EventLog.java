package com.kevinlondon.spirelike;

import java.util.ArrayList;
import java.util.List;

public class EventLog {
    private static List<String> events = new ArrayList<>();
    public static int DISPLAY_SIZE = 4;

    public static void add(final String event) {
        events.add(event);
    }
}
