package com.kevinlondon.spirelike;

import java.util.List;

public class EventLog {
    private static List<String> events = new List<>();
    public static int DISPLAY_SIZE = 4;

    public void add(final String event) {
        events.add(event);
    }
}
