package spirelike;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import spirelike.screens.Screen;
import spirelike.screens.BattleScreen;

public class Launcher extends JFrame implements KeyListener {

    private AsciiPanel terminal;
    private Screen screen;

    public Launcher(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new BattleScreen();
        addKeyListener(this);
        repaint();
    }

    @Override
    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        Launcher app = new Launcher();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
