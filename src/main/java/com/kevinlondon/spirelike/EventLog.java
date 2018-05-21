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

    public static void render(final AsciiPanel terminal, final int yOffset) {
        for (int i = 0; i < events.size(); i++) {
            if (i > DISPLAY_SIZE)
                break;

            terminal.write(events.get(events.size() - i - 1), 0, yOffset + i);
        }
    }
}
