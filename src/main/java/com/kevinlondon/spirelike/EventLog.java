package com.kevinlondon.spirelike;

import asciiPanel.AsciiPanel;

import java.util.ArrayList;
import java.util.List;

public class EventLog {
    private static List<String> events = new ArrayList<>();
    public static int DISPLAY_SIZE = 4;

    public static void add(final String event) {
        events.add(event);
    }

    /*
     * Starting from the bottom of the pane, write messages from bottom to top.
     * Most recent messages live at the bottom. Older ones live at the top.
     */
    public static void render(final AsciiPanel terminal, final int yOffset) {
        for (int i = 0; i < events.size(); i++) {
            if (i > DISPLAY_SIZE)
                break;

            final int lineNumber = yOffset + DISPLAY_SIZE - i;
            final String event = events.get(events.size() - i - 1);
            terminal.write(event, 0, lineNumber);
        }
    }
}
