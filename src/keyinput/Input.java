package keyinput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Input {
    private static final Map<Integer, Boolean> pressedKeys = new HashMap<>();

    static {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            synchronized (Input.class) {
                if (event.getID() == KeyEvent.KEY_PRESSED) pressedKeys.put(event.getKeyCode(), true);
                else if (event.getID() == KeyEvent.KEY_RELEASED) pressedKeys.put(event.getKeyCode(), false);
                return false;
            }
        });
    }

    public static boolean isKeyPressed(int keyCode) {
        synchronized (Input.class) {
            return pressedKeys.getOrDefault(keyCode, false);
        }
    }

    public static void main(String[] args) {
        while (true) {
            boolean isWPressed = isKeyPressed(KeyEvent.VK_W);
            System.out.println("Is W key pressed: " + isWPressed);

            // Add a short delay to avoid excessive console output
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
