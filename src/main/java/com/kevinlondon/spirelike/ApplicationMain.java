package com.kevinlondon.spirelike;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.kevinlondon.spirelike.core.Game;
import com.kevinlondon.spirelike.screens.Screen;

public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;
    private Game game;

    public ApplicationMain(){
        super();
        terminal = new AsciiPanel(80, 40);
        add(terminal);
        pack();
        game = new Game(terminal);
        addKeyListener(this);
        repaint();
    }

    @Override
    public void repaint(){
        terminal.clear();
        game.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
