package com.kevinlondon.spirelike.screens;


import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public abstract class Screen {

    AsciiPanel terminal;

    abstract public void displayOutput();
    abstract public Screen respondToUserInput(KeyEvent key);
}
