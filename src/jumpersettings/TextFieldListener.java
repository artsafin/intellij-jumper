package jumpersettings;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class TextFieldListener implements KeyListener {
    private String defaultText = "";
    private String modifiedText = "";

    public boolean isModified() {
        return modifiedText.compareTo(defaultText) != 0;
    }

    public void setInitialValue(String text) {
        defaultText = text;
        modifiedText = text;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link java.awt.event.KeyEvent} for a definition of
     * a key typed event.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link java.awt.event.KeyEvent} for a definition of
     * a key pressed event.
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link java.awt.event.KeyEvent} for a definition of
     * a key released event.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        modifiedText = ((JTextField)e.getSource()).getText();
    }
}
